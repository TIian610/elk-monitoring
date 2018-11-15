-include .env
export

app:
	@ cd logs-generator && ./gradlew clean install -q

build: app
	@ docker-compose build

up:
	@ docker-compose up

upd:
	@ docker-compose up -d && sleep 10

show:
	@ docker-compose ps

down:
	@ docker-compose stop && sleep 2

delete:
	@ docker-compose rm -fsv
	@ docker volume rm -f elk-monitoring_elasticsearch_data

init:
	@ curl -XPOST -D- 'http://localhost:5601/api/saved_objects/index-pattern' \
	    -H 'Content-Type: application/json' \
	    -H 'kbn-version: $(ELK_VERSION)' \
	    -d '{"attributes":{"title":"logstash-*","timeFieldName":"@timestamp"}}' && printf "\n"
