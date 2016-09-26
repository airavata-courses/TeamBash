cd '/home/ec2-user/RunWeatherForecast'

echo "installing the dependencies from package.json"

npm install

echo "starting the application run weather forecast"

PORT=65000 npm start
