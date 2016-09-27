echo 'starting installation process'
mv /home/ec2-user/DataIngestor  /home/ec2-user/dataIngestor
cd /home/ec2-user/dataIngestor/core/python/DataIngestor
chmod 777
export FLASK_APP=DataIngestor.py
export FLASK_DEBUG=0
flask run --host=0.0.0.0 --port=35000
