echo 'Installing Registry' 
rm -r /home/ec2-user/registry
mv /home/ec2-user/registryService /home/ec2-user/registry
cd "/home/ec2-user/registry/core/java/registry"
sudo mvn -e clean install
java -jar target/registry-1.0.0.jar server registry.yml >> registry.log 2>&1 &