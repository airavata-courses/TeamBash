echo 'sstarting installation process'
rm -r /home/ec2-user/dataIngestor
mv /home/ec2-user/DataIngestor  /home/ec2-user/dataIngestor
cd /home/ec2-user/dataIngestor/core/python/
chmod 777 DataIngestor
cd DataIngestor
pip install virtualenv
virtualenv venv
. venv/bin/activate
pip install Flask
export FLASK_APP=DataIngestor.py
export FLASK_DEBUG=0
flask run --host=0.0.0.0 --port=65000>> dataIngestor.log 2>&1 &
