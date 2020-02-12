FROM java:8
VOLUME /tmp
ADD target/portmaster-0.0.1-SNAPSHOT.jar portmaster.jar
RUN bash -c 'touch /portmaster.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /user.jar"]
