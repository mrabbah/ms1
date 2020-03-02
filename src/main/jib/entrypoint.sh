#!/bin/sh

echo "The application will start in ${MS_SLEEP}s..." && sleep ${MS_SLEEP}
exec java ${JAVA_OPTS} -noverify -XX:+AlwaysPreTouch -Djava.security.egd=file:/dev/./urandom -cp /app/resources/:/app/classes/:/app/libs/* "com.example.ms1"  "$@"
