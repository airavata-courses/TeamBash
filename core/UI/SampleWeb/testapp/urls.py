from django.conf.urls import url,include
from django.contrib import admin
from . import views
#regex,name of the function,shorthand name
urlpatterns = [
    url(r'^$', views.index, name = "index"),
    url(r'^$', views.get_name, name = "get_name"),
    url('hit', views.hit, name = "hit"),
]
