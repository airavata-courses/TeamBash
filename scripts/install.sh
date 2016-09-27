yum -y install python34
yum -y install python34-pip
python3 -m pip install django

echo 'starting installation process'
mv /home/ec2-user/UI  /home/ec2-user/ui
cd /home/ec2-user/ui/core/ui/

python manage.py runserver 0.0.0.0:8080 > /dev/null 2> /dev/null < /dev/null &

