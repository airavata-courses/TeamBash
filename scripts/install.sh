echo 'Installing APIGateway' 
cd '/home/ec2-user/apigateway'
mvn -e clean install
java -jar target/apigateway-1.0.0.jar server apigateway.yml