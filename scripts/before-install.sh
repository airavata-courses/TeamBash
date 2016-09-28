echo 'killing existing flask process if any'
sudo touch /var/log/teambash.log
sudo kill -9 $(sudo lsof -i :65000 | grep LISTEN) >> processkill.log 2>&1 &
