echo 'starting installation process'
mv /home/ec2-user/StormDetection  /home/ec2-user/stormDetection
cd /home/ec2-user/stormDetection/core/python/
chmod 777 stormDetection
cd stormDetection
export FLASK_APP=stormDetection.py
export FLASK_DEBUG=0
flask run --host=0.0.0.0 --port=34000 >> dataIngestor.log 2>&1 &
