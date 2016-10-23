echo 'Installing Storm Clustering' 
rm -r /home/ec2-user/stormClustering
mv /home/ec2-user/stormClusteringService /home/ec2-user/stormClustering
cd /home/ec2-user/stormClustering/
chmod 777 stormClustering
cd stormClustering
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/storm-clustering-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name storm-clustering-service -p 7777:7777 -d teambash/storm-clustering-service:v1
