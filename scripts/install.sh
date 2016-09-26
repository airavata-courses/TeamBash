echo 'starting installation process' 
cd '/home/ec2-user/DataIngestor/core/python/DataIngestor'

pip install requests
pip install Flask
pip install boto
export FLASK_APP=DataIngestor.py
flask run --host=0.0.0.0 --port=35000 >> teambash.log 2>&1 &
