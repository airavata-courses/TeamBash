echo '===============Building docker===============' >> /var/log/sga-docker.log 2>&1
docker build -t teambash/data-ingestor-service:v1 DataIngestor >> /var/log/sga-docker.log 2>&1
echo '===============Running docker===============' >> /var/log/sga-docker.log 2>&1
docker run -it --name data-ingestor-service -p 65000:65000 -d teambash/data-ingestor-service:v1