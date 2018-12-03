Requirements

* Install java >= 8
* Install maven
* Install kubectl
* Install minikube

# Preparation

## Minikube

Configure minikube

    $ minikube config set kubernetes-version v1.12.3
    $ minikube config set memory 8000
    $ minikube config set cpus 4
    $ minikube config set disk-size 100g

Start minikube

    $ minikube start

Enable heapster

    $ minikube addons enable heapster

Read minikube IP address

    $ minikube ip

should be 192.168.99.100 per default.

Open dashboard with

    $ minikube dashboard

Enable heapster in minikube

    $ minikube addons enable heapster

Enable ingress controller

    $ minikube addons enable ingress

Check that all pods are up and running

    $ kubectl get pods --all-namespaces 
    NAMESPACE     NAME                                    READY   STATUS    RESTARTS   AGE
    kube-system   coredns-576cbf47c7-zvtj5                1/1     Running   0          34m
    kube-system   etcd-minikube                           1/1     Running   0          33m
    kube-system   heapster-qq2l9                          1/1     Running   0          34m
    kube-system   influxdb-grafana-sm48d                  2/2     Running   0          34m
    kube-system   kube-addon-manager-minikube             1/1     Running   0          33m
    kube-system   kube-apiserver-minikube                 1/1     Running   0          33m
    kube-system   kube-controller-manager-minikube        1/1     Running   0          33m
    kube-system   kube-proxy-7t6rp                        1/1     Running   0          34m
    kube-system   kube-scheduler-minikube                 1/1     Running   0          33m
    kube-system   kubernetes-dashboard-5bb6f7c8c6-zrrj9   1/1     Running   0          34m
    kube-system   storage-provisioner                     1/1     Running   0          34m

## Install Tiller (for Helm)

    $ helm init

## Neo4j

Create namespace persistence

    $ kubectl create namespace persistence

Install Neo4j

    $ helm --name neo4j --namespace persistence --set core.numberOfServers=1,authEnabled=false,imageTag=3.5.0 install stable/neo4j

## Grafana and Prometheus

Create namespace monitoring

    $ kubectl create namespace monitoring

Install Grafana and Prometheus

    $ helm install --name prometheus --namespace monitoring --set 'server.ingress.enabled=true,server.ingress.hosts={"prometheus.192.168.99.100.nip.io"}' stable/prometheus
    $ helm install --name grafana --namespace monitoring --set 'persistence.enabled=true,persistence.size=1G,persistence.accessModes={ReadWriteOnce},ingress.enabled=true,ingress.hosts={"grafana.192.168.99.100.nip.io"}' stable/grafana

Wait for all pods being up and activate port forward to prometheus

    $ kubectl -n monitoring get pods
    NAME                                             READY   STATUS    RESTARTS   AGE
    grafana-5499bfcc6b-hkzpb                         1/1     Running   0          35s
    prometheus-alertmanager-799df667c9-fs8g9         1/2     Running   0          45s
    prometheus-kube-state-metrics-567749cd46-hgq4f   1/1     Running   0          45s
    prometheus-node-exporter-qtffl                   1/1     Running   0          45s
    prometheus-pushgateway-76f8f64679-bxds8          1/1     Running   0          45s
    prometheus-server-7899445547-srt5c               1/2     Running   0          45s```

Read admin password for grafana (which is dynamically generated):

    $ kubectl get secret --namespace monitoring grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo

Access

http://prometheus.192.168.99.100.nip.io

click on targets and ensure that all targets are "green". Access 

http://grafana.192.168.99.100.nip.io/login 

and login as admin with the given password. Add a datasource:

* Name: Prometheus
* Type: Prometheus
* URL: http://prometheus-server/
* Access: Server

# The Business Service

Create namespace for the business application

    $ kubernetes create namespace business
    
Build the application

    $ mvn install
    
Check the availability of the docker image

    $ docker images

Go to the directory

    src/main/helm
    
and install the application

    helm install --name microservice --namespace business .

# TODO

    kubernetes create namespace messaging
    helm install --name rabbitmq --namespace messaging stable/rabbitmq