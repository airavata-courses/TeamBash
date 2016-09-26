echo 'starting installation process' 
cd '/home/ec2-user/'
mkdir python
chmod 777 python
cp -R /home/ec2-user/DataIngestor/ /home/ec2-user/python

cd '/home/ec2-user/python/DataIngestor'

pip install requests
pip install Flask
pip install boto
export FLASK_APP=DataIngestor.py
flask run --host=0.0.0.0 --port=65000>> /var/log/teambash.log 2>&1 &
