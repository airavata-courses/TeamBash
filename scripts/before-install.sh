echo "killing any preexisting processes at port"

kill -9 $(lsof -t -i:65000)
