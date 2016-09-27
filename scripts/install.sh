echo 'Installing Storm Clustering' 
mv /home/ec2-user/stormClusteringService /home/ec2-user/stormClustering
cd "/home/ec2-user/stormClustering/core/java/stormClustering"
sudo mvn -e clean install
java -jar target/stormClustering-1.0.0.jar server stormClustering.yml >> stormClustering.log 2>&1 &
