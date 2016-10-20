import json
import unittest
from unittest import TestCase

from stormDetection import app

class FlaskTestCase(TestCase):
    def test_stormDetection_success(self):
        tester = app.test_client(self)

        response = tester.get('/getKml/https://noaa-nexrad-level2.s3.amazonaws.com/1996/06/06/KABR/KABR19960606_000202.gz')

        self.assertEqual(response.status_code, (200 or 206))

    if __name__ == '__main__':
        unittest.main()
