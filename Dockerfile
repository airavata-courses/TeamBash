FROM node:latest
ADD core/javascript/ForecastTrigger /ForecastTrigger
WORKDIR /ForecastTrigger
RUN npm install
EXPOSE 8100
CMD [ "npm", "start" ]