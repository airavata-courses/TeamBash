from django.conf.urls import url,include
from django.contrib import admin
from . import views
#regex,name of the function,shorthand name
urlpatterns = [
    url(r'^$', views.weatherForm, name = "weatherForm"),
    url('complete/google-oauth2/', views.home, name="home"),
    url('weatherForm', views.weatherForm, name = "weatherForm"),
    url('loginUser', views.loginAPI, name = "loginAPI"),
    url('hit', views.hit, name = "hit"),
    url('getStats', views.getStats, name = "getStats"),
    url('start_here', views.start_here, name = "start_here"),
    url('result', views.result, name="result"),
   # url('disconnect/(?P<backend>[^/]+)/$', views.disconnect, name='disconnect'),
]