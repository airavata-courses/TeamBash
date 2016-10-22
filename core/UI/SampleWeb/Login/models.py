from __future__ import unicode_literals

from django.db import models


# Create your models here.
from social.backends.google import GoogleOAuth2
class User(models.Model):
    user_name = models.CharField(max_length=60, unique=True)
    email = models.CharField(max_length=60, unique=True)

    def __str__(self):
        return self.user_name

