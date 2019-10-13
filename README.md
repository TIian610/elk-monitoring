# ELK Monitorig

This is a project to learn how to monitor applications with ELK.
This is not for production, it's just to test the integration.

Dashboard Example: [dashboard-example](dashboard-example), import it into the saved objects option.

### Links

- Project Base [https://github.com/deviantony/docker-elk](https://github.com/deviantony/docker-elk)
- ELK Stack [https://www.elastic.co/elk-stack](https://www.elastic.co/elk-stack)
- ELK Docker [https://www.docker.elastic.co/](https://www.docker.elastic.co/)

### Commands

`make show` shows containers info

`make run` runs compose

`make stop` stops the ELK

`make remove` deletes containers

`make app` compiles the application

### ELK Information

Give Kibana a few seconds to initialize, then access the Kibana web UI by hitting
[http://localhost:5601](http://localhost:5601) with a web browser.

By default, the stack exposes the following ports:
* 5000: Logstash TCP input.
* 9600: Logstash HTTP healthy check
* 9200: Elasticsearch HTTP
* 9300: Elasticsearch TCP transport
* 5601: Kibana
