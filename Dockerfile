FROM java:openjdk-8-jdk

ADD /core/java/apigateway/target/apigateway-1.0.0.jar apigateway-1.0.0.jar

ADD /core/java/apigateway/apigateway.yml apigateway.yml

CMD java -jar apigateway-1.0.0.jar server apigateway.yml

EXPOSE 8888