-include .env
export

app:
	@ cd logs-generator && ./gradlew clean install -q
	@ cd logs-generator && docker build -t logs-generator .

run: app
	@ docker stack deploy -c docker-stack.yml elk

show:
	@ docker stack services elk

stop:
	@ docker stack rm elk || true

remove: stop
	@ docker volume rm -f elk_elasticsearch_data || true
	@ docker image rm logs-generator || true
