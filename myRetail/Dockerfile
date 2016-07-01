FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
COPY target/myRetail-1.0.jar app.jar
CMD java -jar -Dmongo.host="mongodb" /app.jar