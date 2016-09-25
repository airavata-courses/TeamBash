echo 'Terminating existing flask processes ' 
ps -ef | grep python | grep -v grep | awk '{print $2}' | xargs kill
sleep 5
