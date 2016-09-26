echo 'Installing APIGateway' 
cd '/home/ec2-user/apigatewayService/core/java/apigateway'
mvn -e clean install
java -jar target/apigateway-1.0.0.jar server apigateway.yml >> apigateway.log 2>&1 &
