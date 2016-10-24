echo 'Installing Registry' 
rm -r /home/ec2-user/registry
mv /home/ec2-user/registryService /home/ec2-user/registry
cd /home/ec2-user/registry/
chmod 777 registry
cd registry
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/registry-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name registry-service -p 9999:9999 -d teambash/registry-service:v1
