#!/bin/bash

until curl 'http://logstash:9600' 2> /dev/null; do
  echo "Waiting for logtash..."
  sleep 1;
done

echo "Starting..."

./bin/logs-generator
