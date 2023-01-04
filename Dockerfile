FROM anapsix/alpine-java:11
MAINTAINER rivolt2022 rivolt2022@gmail.com
ADD build/libs/*.RELEASE.jar core.jar
RUN sh -c 'touch /core.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/core.jar"]