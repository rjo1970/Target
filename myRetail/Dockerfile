FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER J. R. Titko
VOLUME /tmp
COPY build/libs/myRetail-1.0.jar app.jar
CMD java -jar -Dmongo.host="mongodb" -Drun.mode="demo" /app.jar