import json
import unittest
from unittest import TestCase

from DataIngestor import app


class FlaskTestCase(TestCase):
    # Our first unit test - We are using the unittest
    # library, calling the generateMyURL route from the app
    # passing a couple of strings, and checking that the
    # returned value, contained on the JSON response, match
    # a valid url.
    # Success Case
    def test_generateMyURL_success(self):
        tester = app.test_client(self)

        expected_response = {"url": "https://noaa-nexrad-level2.s3.amazonaws.com/1996/06/06/KABR/KABR19960606_000202.gz"}
        response = tester.get('/getUrl/1996/06/06/KABR/')

        self.assertEqual(response.status_code, 200)
        self.assertEqual(json.loads(response.data),expected_response)

    #Fail Case
    def test_generateMyURL_error(self):
        expected_response = 'Invalid arguments!!! Records does not exist'
        response = app.get('/getUrl/1991/01/01/KABR/')

        self.assertEqual(response.status_code, 404)
        self.assertEqual(json.loads(response.data), expected_response)

    if __name__ == '__main__':
        unittest.main()


