echo "killing any pre existing processes at port"

fuser -k 65000/tcp

sleep 20

echo "installing node.js --version 4.x"

curl -sL https://deb.nodesource.com/setup_4.x | sudo -E bash -
sudo yum install -y nodejs 
sudo yum install npm

