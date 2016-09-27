echo 'starting the installation' >> debug.log

mv /home/ec2-user/runWeatherForecast /home/ec2-user/RunWeatherForecast
cd '/home/ec2-user/RunWeatherForecast/core/javascript/runWeatherForecast'

echo "installing the dependencies from package.json" >> debug.log

npm install >> debug.log

echo "starting the application run weather forecast" >> debug.log

PORT=8200 npm start >> debug.log 2>&1 &
