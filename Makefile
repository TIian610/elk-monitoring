app:
	@ cd logs-generator && ./gradlew clean install -q

build: app
	@ docker-compose build

up:
	@ docker-compose up -d && sleep 5

show:
	@ docker-compose ps

down:
	@ docker-compose stop

delete:
	@ docker-compose rm -fsv

init-kibana:
	@ curl -XPOST -D- 'http://localhost:5601/api/saved_objects/index-pattern' \
	    -H 'Content-Type: application/json' \
	    -H 'kbn-version: 6.3.2' \
	    -d '{"attributes":{"title":"logstash-*","timeFieldName":"@timestamp"}}'

init: delete build up init-kibana
