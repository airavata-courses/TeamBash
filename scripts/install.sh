echo 'starting the installation' >> debug.log

rm -r /home/ec2-user/runWeatherForecast
mv /home/ec2-user/RunWeatherForecast /home/ec2-user/runWeatherForecast
cd '/home/ec2-user/runWeatherForecast/core/javascript/runWeatherForecast'

echo "installing the dependencies from package.json" >> debug.log

npm install >> debug.log

echo "starting the application run weather forecast" >> debug.log

PORT=8200 npm start >> debug.log 2>&1 &
