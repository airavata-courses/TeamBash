FROM java:openjdk-8-jdk

ADD /core/java/registry/target/registry-1.0.0.jar registry-1.0.0.jar

ADD /core/java/registry/registry.yml registry.yml

CMD java -jar registry-1.0.0.jar server registry.yml

EXPOSE 9999