from BeautifulSoup import BeautifulStoneSoup as Soup
from flask import Flask, jsonify, render_template, request, url_for, render_template
import requests

app = Flask(__name__)


# Rather than passing everything in the URL we can make use of request.form['key for the field']

#@app.route('/<int:yy>/<int:mm>/<int:dd>/<string:stationId>/', methods=['POST'])
@app.route('/index/', methods=['POST'])
def generateURL(yy, mm, dd, stationId):
    # Error if trying to access non-existent file
    print("HELLO")
    if yy < 1991 or yy == 1991 and mm < 6:
        return render_template('base.html'), 404

    # Base Url where we get the XML file from
    url = 'http://unidata-nexrad-level2-chunks.s3.amazonaws.com/'

    # Read the data from URL
    response = requests.get(url)

    # Create the partial key to be searched.
    search_string = str(stationId) + "/" + "1/" + str(yy) + str(mm) + str(dd) + "/"

    if response:

        # text processing
        soup = Soup(response.content)

        # find all the <Key> tags in the document
        key_tags = soup.findAll('Key')

        # if there are no <Key> tags then return error page
        if not key_tags:
            return render_template('404.html'), 404

        # Select a random time from the list
        for k_tag in key_tags:
            if search_string in k_tag:
                return url_for(url + search_string)


# We only need this for local development.
if __name__ == '__main__':
    app.run(debug =True) #restart automatically
