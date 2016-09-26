echo "killing any pre existing processes at port"

fuser -k 65000/tcp

sleep 10

echo "checking if node is installed"

node -v
if [ "$?" -ne 0 ]; then
    echo "installing node.js --version 4.x"
        curl --silent --location https://rpm.nodesource.com/setup_4.x | bash -
        yum -y install nodejs
        yum -y install gcc-c++ make
        npm install npm -g
        node -v
fi
