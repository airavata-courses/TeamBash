echo "killing any pre existing processes at port" >> debug.log

fuser -k 8200/tcp >> debug.log

sleep 10 >> debug.log

echo "checking if node is installed" >>debug.log

node -v >> debug.log
if [ "$?" -ne 0 ]; then
    echo "installing node.js --version 4.x" >> debug.log
        curl --silent --location https://rpm.nodesource.com/setup_4.x | bash -
        yum -y install nodejs
        yum -y install gcc-c++ make
        npm install npm -g
        node -v
fi
