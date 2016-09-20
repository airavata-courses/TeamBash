''' Data Ingestor Microservice -
The service will take form data and generate
the appropriate URL for the .gz file '''

from boto.s3.connection import S3Connection
from flask import Flask, render_template, request, url_for, render_template
import requests
import boto
from boto.s3.connection import S3Connection
from flask import jsonify, abort

app = Flask(__name__)


@app.route('/getUrl/<string:yy>/<string:mm>/<string:dd>/<string:stationId>/', methods=['GET'])
def generateMyURL(yy, mm, dd, stationId):
    #Error if trying to access non-existent file
    finalURL= ''
    if yy < 1991 or (yy == 1991 and mm < 6):
        abort(404)
        #return jsonify(url = 'Invalid arguments!!! Records does not exist'), 404

    s3conn = boto.connect_s3(anon = True)
    bucket = s3conn.get_bucket('noaa-nexrad-level2',validate=False)
    keyGenerated = str(yy)+"/" +str(mm)+"/"+str(dd)

    #Sample Download Url :https://noaa-nexrad-level2.s3.amazonaws.com/1996/06/06/KVBX/KVBX19960606_001958.gz

    for k in bucket.get_all_keys(prefix=keyGenerated):
        #Reformatring the s3 content to match the .gz file
        searchKeySet = str(k).split("Key:")[1].split(">")[0].split(",")[1]
        if keyGenerated in str(searchKeySet):
            finalURL = 'https://noaa-nexrad-level2.s3.amazonaws.com/'+searchKeySet
            break

    if finalURL =='':
        abort(404)
    return jsonify(url= finalURL) ,200


@app.errorhandler(404)
def invalidArguments(e):
    return jsonify({'Error-Message': 'Invalid arguments!!! Records does not exist'})



# We only need this for local development.
if __name__ == '__main__':
    #restart automatically if DEBUG = True
    app.run(host = '0.0.0.0',debug=True)
