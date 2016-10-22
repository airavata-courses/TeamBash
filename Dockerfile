FROM java:openjdk-8-jdk

ADD /core/java/stormClustering/target/stormClustering-1.0.0.jar stormClustering-1.0.0.jar

ADD /core/java/stormClustering/stormClustering.yml stormClustering.yml

CMD java -jar stormClustering-1.0.0.jar server stormClustering.yml

EXPOSE 7777
