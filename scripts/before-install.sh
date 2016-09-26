echo "killing any pre existing processes at port"

kill -9 $(lsof -t -i:65000)
