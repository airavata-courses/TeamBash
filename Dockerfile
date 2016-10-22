FROM node:latest
ADD core/javascript/runWeatherForecast /runWeatherForecast
WORKDIR /runWeatherForecast
RUN npm install
EXPOSE 8200
CMD [ "npm", "start" ]