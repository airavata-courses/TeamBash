FROM python:2.7
ADD core/UI/SampleWeb /SampleWeb
WORKDIR /SampleWeb
RUN pip install -r requirements.txt
CMD ["python", "manage.py migrate"]
ENTRYPOINT ["python", "manage.py"]
CMD ["runserver", "0.0.0.0:9001"]
EXPOSE 9001