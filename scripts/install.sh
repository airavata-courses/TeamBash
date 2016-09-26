echo 'starting installation process'
cd '/home/ec2-user/stormDetection'

echo 'Activating virtualenv for stormDetection Microservice'
pip install virtualenv
virtualenv venv
. venv/bin/activate
pip install Flask
export FLASK_APP=stormDetection.py 
flask run --host=0.0.0.0 --port=36000

