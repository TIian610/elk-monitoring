-include .env
export

app:
	@ cd logs-generator && ./gradlew clean install -q

build: app
	@ docker-compose build

up:
	@ docker-compose up

upd:
	@ docker-compose up -d

show:
	@ docker-compose ps

down:
	@ docker-compose stop

delete:
	@ docker-compose rm -fsv
	@ docker volume rm -f elk-monitoring_elasticsearch_data
