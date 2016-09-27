echo 'starting the installation' >> debug.log

rm -r /home/ec2-user/forecastTrigger
mv /home/ec2-user/ForecastTrigger /home/ec2-user/forecastTrigger
cd '/home/ec2-user/forecastTrigger/core/javascript/ForecastTrigger'

echo "installing the dependencies from package.json" >> debug.log

npm install >> debug.log

echo "starting the application run weather forecast" >> debug.log

PORT=8100 npm start >> debug.log 2>&1 &
