echo 'Installing Registry' 
cd '/home/ec2-user/registry'
mvn -e clean install
java -jar target/registry-1.0.0.jar server registry.yml