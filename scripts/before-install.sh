echo 'killing existing process on ports 9000/9001 if any'
fuser -k 9999/tcp
fuser -k 9998/tcp
sleep 20
export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk
echo 'check if maven is installed'
mvn --version
if [ "$?" -ne 0 ]; then
    echo 'Installing Maven...'
	sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
	sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
	sudo yum install -y apache-maven
	mvn --version
fi
