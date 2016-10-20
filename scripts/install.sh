echo 'starting installation process'
rm -r /home/ec2-user/stormDetection
mv /home/ec2-user/StormDetection  /home/ec2-user/stormDetection
cd /home/ec2-user/stormDetection/core/python/
chmod 777 stormDetection
cd stormDetection
python stormDetection.py >> dataIngestor.log 2>&1 &
