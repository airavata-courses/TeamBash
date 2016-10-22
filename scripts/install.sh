echo 'starting the installation' >> debug.log

rm -r /home/ec2-user/forecastTrigger
mv /home/ec2-user/ForecastTrigger /home/ec2-user/forecastTrigger
cd '/home/ec2-user/forecastTrigger/'
chmod 777 forecastTrigger
cd forecastTrigger
echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/forecast-trigger-service:v1 . >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name forecast-trigger-service -p 8100:8100 -d teambash/forecast-trigger-service:v1
