echo 'starting installation process'
rm -r /home/ec2-user/ui
mv /home/ec2-user/UI  /home/ec2-user/ui

cd /home/ec2-user/ui/
chmod 777 ui
cd ui
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/ui-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name ui-service -p 9001:9001 -d teambash/ui-service:v1

