ARG ELK_VERSION
FROM docker.elastic.co/logstash/logstash:${ELK_VERSION}
COPY config/logstash.yml /usr/share/logstash/config/logstash.yml
COPY pipeline/logstash.conf /usr/share/logstash/pipeline/logstash.conf
# RUN logstash-plugin install plugin
