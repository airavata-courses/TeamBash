echo 'Installing Monitor'
rm -r /home/ec2-user/monitor
mv /home/ec2-user/monitorService /home/ec2-user/monitor
cd "/home/ec2-user/monitor/core/java/monitor"
sudo mvn -e clean install
java -jar target/monitor-1.0.0.jar server monitor.yml >> monitor.log 2>&1 &
