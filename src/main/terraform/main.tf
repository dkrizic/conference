provider "helm" {
  install_tiller="false"
}

resource "helm_release" "grafana" {
  name = "grafana"
  namespace = "monitoring"
  chart = "stable/grafana"
  values = [
    "${file("../helm/grafana/minikube.yaml")}"
  ]
}

resource "helm_release" "prometheus" {
  name = "prometheus"
  namespace = "monitoring"
  chart = "stable/prometheus"
  values = [
    "${file("../helm/grafana/minikube.yaml")}"
  ]
}
