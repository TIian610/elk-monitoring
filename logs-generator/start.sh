#!/bin/bash

until curl 'http://logstash:9600' 2> /dev/null; do
  printf "Waiting for logtash..."
  sleep 1;
done

printf "\nStarting...\n"

./bin/logs-generator
