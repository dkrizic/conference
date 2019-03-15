FROM debian

RUN apt-get update && apt-get -y install wget gnupg2 apt-transport-https
RUN wget -O - https://debian.neo4j.org/neotechnology.gpg.key | apt-key add -
RUN echo 'deb https://debian.neo4j.org/repo stable/' | tee -a /etc/apt/sources.list.d/neo4j.list
RUN apt-get update
RUN apt-get install -y cypher-shell nginx
RUN mkdir /data
COPY src/main/shell/merge /data
COPY src/main/data/* /var/www/html/
ENTRYPOINT /data/merge
