from flask import Flask
from flask import request
from flask import make_response
import random

app = Flask(__name__)

@app.route('/')
@app.route('/<url>', methods=['GET'])
def detectionDummy(url = None):

    # url = self.get_url()
    json = request.get_json()
    # return request.base_url+'---->>'+ str(json)
    if 's3.amazonaws.com' in str(url) and '.gz' in str(url) and url:
        result = compute(url)
        response = make_response(result)
        response.headers["Content-Disposition"] = "attachment; filename=dummy.kml"
        return response
    else:
        return 'No valid URL found'

def compute(url):
    flag = random.getrandbits(1)
    if flag:
        return """'Characterizing the storm<br>'+'<br>Generating dummy.kml'"""
    else:
        return """Not enough data to characterize the storm"""

if __name__ == '__main__':
    app.run(
        host="127.0.0.1",
        port=int(5000),
        debug=True
    )
