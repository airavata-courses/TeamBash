echo 'starting installation process' 
cd '/home/ec2-user/DataIngestor/core/python/DataIngestor'

sudo su
pip install requests
pip install Flask
pip install boto
export FLASK_APP=DataIngestor.py
flask run --host=0.0.0.0 --port=35000 >> dataIngestor.log 2>&1 &
