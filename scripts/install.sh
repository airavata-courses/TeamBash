echo 'starting the installation' >> debug.log

rm -r /home/ec2-user/runWeatherForecast
mv /home/ec2-user/RunWeatherForecast /home/ec2-user/runWeatherForecast
cd '/home/ec2-user/runWeatherForecast/'

chmod 777 runWeatherForecast
cd runWeatherForecast
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/run-forecast-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name run-forecast-service -p 8200:8200 -d teambash/run-forecast-service:v1