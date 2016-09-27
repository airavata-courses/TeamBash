echo 'Installing APIGateway' 
rm -r /home/ec2-user/apigateway
mv /home/ec2-user/apigatewayService /home/ec2-user/apigateway
cd '/home/ec2-user/apigateway/core/java/apigateway'
mvn -e clean install
java -jar target/apigateway-1.0.0.jar server apigateway.yml >> apigateway.log 2>&1 &
