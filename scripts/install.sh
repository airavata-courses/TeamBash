echo 'starting installation process'
mv /home/ec2-user/DataIngestor  /home/ec2-user/dataIngestor
cd '/home/ec2-user/dataIngestor/core/python/DataIngestor'

sudo su
pip install requests
pip install Flask
pip install boto
export FLASK_APP=DataIngestor.py
flask run --host=0.0.0.0 --port=35000 >> dataIngestor.log 2>&1 &
