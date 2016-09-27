echo 'killing existing flask process if any'
sudo touch /var/log/teambash.log

ps -ef | grep python | grep -v grep | awk '{print $2}' | xargs kill >> /var/log/teambash.log 2>&1 &
