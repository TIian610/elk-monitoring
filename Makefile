app:
	@ cd logs-generator && ./gradlew clean install -q

build: app
	@ docker-compose build

up:
	@ docker-compose up

up-d:
	@ docker-compose up -d && sleep 6

show:
	@ docker-compose ps

down:
	@ docker-compose stop && sleep 2

delete:
	@ docker-compose rm -fsv

init-kibana:
	@ curl -XPOST -D- 'http://localhost:5601/api/saved_objects/index-pattern' \
	    -H 'Content-Type: application/json' \
	    -H 'kbn-version: 6.3.2' \
	    -d '{"attributes":{"title":"logstash-*","timeFieldName":"@timestamp"}}'
