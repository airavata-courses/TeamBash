echo 'Installing APIGateway' 
rm -r /home/ec2-user/apigateway
mv /home/ec2-user/apigatewayService /home/ec2-user/apigateway
cd /home/ec2-user/apigateway/
chmod 777 apigateway
cd apigateway
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/apigateway-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name apigateway-service -p 8888:8888 -d teambash/apigateway-service:v1
