FROM openjdk:8
COPY build/install/logs-generator /logs-generator
COPY start.sh /logs-generator/start.sh
WORKDIR /logs-generator
RUN ln -s ./bin/logs-generator
ENTRYPOINT ["./start.sh"]
