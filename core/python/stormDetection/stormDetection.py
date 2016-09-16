from flask import Flask
from flask import request
import random

app = Flask(__name__)

@app.route('/')
@app.route('/<url>')
def detectionDummy(url = None):
    if 's3.amazonaws.com' in str(url) and '.gz' in str(url) and url:
        result = compute(url)
        return result
    else:
        return 'No valid URL found'

def compute(url):
    flag = random.getrandbits(1)
    if flag:
        return 'Characterizing the storm<br>'+'<br>Generating dummy.kml'
    else:
        return "Not enough data to characterize the storm"

if __name__ == '__main__':
    app.run()
