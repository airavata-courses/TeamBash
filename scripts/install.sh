echo 'sstarting installation process'
rm -r /home/ec2-user/dataIngestor
mv /home/ec2-user/DataIngestor  /home/ec2-user/dataIngestor
cd /home/ec2-user/dataIngestor/
chmod 777 dataIngestor
cd dataIngestor
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/data-ingestor-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name data-ingestor-service -p 65000:65000 -d teambash/data-ingestor-service:v1
