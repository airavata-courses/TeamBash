echo 'Checking if Docker is installed'
docker --version
if [ "$?" -ne 0 ]; then
	echo "Installing docker."
	sudo yum update -y
	sudo yum install -y docker
	sudo service docker start
	sudo usermod -a -G docker ec2-user
	docker info
	#Installing docker-compose
	echo "Installing docker."
	curl -L https://github.com/docker/compose/releases/download/1.8.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
	chmod +x /usr/local/bin/docker-compose
fi
echo 'Removing existing docker instances' >> /var/log/sga-docker.log 2>&1
docker ps -a | grep 'forecast-trigger-service' | awk '{print $1}' | xargs --no-run-if-empty docker stop
docker ps -a | grep 'forecast-trigger-service' | awk '{print $1}' | xargs --no-run-if-empty docker rm
