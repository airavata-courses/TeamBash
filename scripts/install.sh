echo 'starting installation process'
<<<<<<< HEAD
cd '/home/ec2-user/stormDetection'

echo 'Activating virtualenv for stormDetection Microservice'
pip install virtualenv
virtualenv venv
. venv/bin/activate
pip install Flask
export FLASK_APP=stormDetection.py 
flask run --host=0.0.0.0 --port=34000 &

=======
rm -r /home/ec2-user/stormDetection
mv /home/ec2-user/StormDetection  /home/ec2-user/stormDetection
cd /home/ec2-user/stormDetection/core/python/
chmod 777 stormDetection
cd stormDetection
python stormDetection.py >> dataIngestor.log 2>&1 &
>>>>>>> 6df65dbc25b64f8e34c80fa4edcd17df0e70f3d5
