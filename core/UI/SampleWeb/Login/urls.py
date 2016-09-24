from django.conf.urls import url,include
from django.contrib import admin
from . import views
#regex,name of the function,shorthand name
urlpatterns = [
    url(r'^$', views.login, name = "login"),
    url('weatherForm', views.weatherForm, name = "weatherForm"),
    url('loginUser', views.loginAPI, name = "loginAPI"),
    url('hit', views.hit, name = "hit"),
    url('getStats', views.getStats, name = "getStats"),
    url('result', views.result, name="result"),
]