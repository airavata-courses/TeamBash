FROM python:latest
ADD core/python/stormDetection /stormDetection
WORKDIR /stormDetection
RUN pip install -r requirements.txt
ENTRYPOINT ["python"]
CMD ["stormDetection.py"]
EXPOSE 34000
