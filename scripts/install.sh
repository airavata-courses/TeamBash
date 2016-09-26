echo 'Installing Registry' 
cd "/home/ec2-user/registry"
sudo mvn -e clean install
nohup java -jar target/registry-1.0.0.jar server registry.yml &