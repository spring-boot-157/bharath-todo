#!/usr/bin/env bash
cd /var/bharath-todo/target
sudo /usr/bin/java -jar -Dserver.port=8080 \
    rest-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &