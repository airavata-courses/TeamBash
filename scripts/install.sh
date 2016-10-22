yum -y install python27
yum -y install python2-pip
python -m pip install django
pip install django-social-auth

echo 'starting installation process'
rm -r /home/ec2-user/ui
mv /home/ec2-user/UI  /home/ec2-user/ui
cd /home/ec2-user/ui/core/UI/SampleWeb
sudo pip uninstall Django
sudo pip install Django==1.8.1
sudo pip install httplib2
python manage.py runserver 0.0.0.0:9001 >>DjangoUi.log > /dev/null 2> /dev/null < /dev/null &

