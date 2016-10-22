Team Bash Members
==============================
* Raghuveer Raavi (rraavi) 
* Sruthi Ramesh Vani (sruthirameshv) 
* Manikandan Murugesan (manikandan5)
* Janak Bhalla (janak1710)

Weather Predictor - Milestone -1
==============================

Build Status - Master  : [![Build Status](https://travis-ci.org/airavata-courses/TeamBash.svg?branch=master)](https://travis-ci.org/airavata-courses/TeamBash)

Build Status - Develop : [![Build Status](https://travis-ci.org/airavata-courses/TeamBash.svg?branch=Develop)](https://travis-ci.org/airavata-courses/TeamBash)

Instructions Manual
--------------

We have created our Microservices in seperate feature branches.

These feature branches have their own seperate travis files, which will upload the artifact to S3 bucket and then will be deployed to the EC-2 instances.

We have not merged our feature branches to either develop or the master.

While deploying the code to a new instance, edit and update the .travis.yml file and launch it. In future, if we were to deploy in individual EC-2 instances, we have to update the .travis.yml

Branch list for each Microservice
--------------
* Microservice A - Registry : https://github.com/airavata-courses/TeamBash/tree/feature/feature-14-registry
* Microservice B - Data Ingestor : https://github.com/airavata-courses/TeamBash/tree/feature/feature-3-data-ingestor
* Microservice C - Storm Detection : https://github.com/airavata-courses/TeamBash/tree/feature/feature-4-storm-detection
* Microservice D - Storm Clustering : https://github.com/airavata-courses/TeamBash/tree/feature/feature-5-storm-clustering
* Microservice E - Forecast Trigger : https://github.com/airavata-courses/TeamBash/tree/feature/feature-13-forecast-trigger
* Microservice F - Run Weather Forecast : https://github.com/airavata-courses/TeamBash/tree/feature/feature-15-run-weather-forecast

* UI Branch : https://github.com/airavata-courses/TeamBash/tree/feature/feature-11-UI
* API Gateway Branch : https://github.com/airavata-courses/TeamBash/tree/feature/feature-10-apigateway
=======
Build Status - Registry MicroService  : [![Build Status](https://travis-ci.org/airavata-courses/TeamBash.svg?branch=feature%2Ffeature-14-registry)](https://travis-ci.org/airavata-courses/TeamBash)
