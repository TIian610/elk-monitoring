#!/bin/bash

until curl 'http://logstash:9600' 2> /dev/null; do
  echo "Waiting for logstash..."
  sleep 5
done

echo "Starting..."

INDEX_CHECK=$(curl -X GET "http://kibana:5601/api/saved_objects/_find?type=index-pattern&per_page=10000")

if [[ "$INDEX_CHECK" == *"logstash"* ]]; then
    echo "Index exists..."
else
    echo "Creating index..."
    curl -X POST 'http://kibana:5601/api/saved_objects/index-pattern' \
        -H 'Content-Type: application/json' \
        -H 'kbn-version: '"$ELK_VERSION"'' \
        -d '{"attributes":{"title":"logstash-*","timeFieldName":"@timestamp"}}'
fi

./logs-generator
