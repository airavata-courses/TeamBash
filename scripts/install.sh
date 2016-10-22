echo 'starting installation process'
rm -r /home/ec2-user/stormDetection
mv /home/ec2-user/StormDetection  /home/ec2-user/stormDetection
cd /home/ec2-user/stormDetection/
chmod 777 stormDetection
cd stormDetection
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/storm-detection-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name storm-detection-service -p 34000:34000 -d teambash/storm-detection-service:v1
