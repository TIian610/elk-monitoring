FROM openjdk:8
COPY build/install/logs-generator /logs-generator
COPY start.sh /logs-generator/start.sh
WORKDIR /logs-generator
ENTRYPOINT ["./start.sh"]
