echo 'Installing Registry' 
mv /home/ec2-user/registryService registry
cd "/home/ec2-user/registry/core/java/registry"
sudo mvn -e clean install
java -jar target/registry-1.0.0.jar server registry.yml >> registry.log 2>&1 &