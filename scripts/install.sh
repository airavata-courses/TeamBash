echo 'sstarting installation process'
rm -r /home/ec2-user/dataIngestor
mv /home/ec2-user/DataIngestor  /home/ec2-user/dataIngestor
cd /home/ec2-user/dataIngestor/core/python/
chmod 777 DataIngestor
cd DataIngestor
python DataIngestor.py  >> dataIngestor.log 2>&1 &
