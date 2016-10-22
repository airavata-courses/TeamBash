FROM python:latest
ADD core/python/DataIngestor /DataIngestor
WORKDIR /DataIngestor
RUN pip install -r requirements.txt
ENTRYPOINT ["python"]
CMD ["DataIngestor.py"]
EXPOSE 65000