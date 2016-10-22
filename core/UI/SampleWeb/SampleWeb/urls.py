"""SampleWeb URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.10/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url,include
from django.contrib import admin
from django.contrib.staticfiles.urls import staticfiles_urlpatterns


urlpatterns = [
    #url('', include('social.apps.django_app.urls', namespace='social')),
    #url(r'^$', include('social_auth.urls')),

    url(r'^admin/', admin.site.urls),
    url(r'^home/', 'Login.views.start_here', name='start_here'),
    url(r'', include('social.apps.django_app.urls', namespace='social')),
    url(r'^home/', 'Login.views.start_here', name='start_here'),
    url(r'^log/', include('Login.urls', namespace="Login")),
    url(r'disconnect/(?P<backend>[^/]+)/$', 'Login.views.disconnect', name='disconnect'),
    #url('complete/google-oauth2/', views.home, name="home"),
    #url(r'^home/', 'Login.views.home', name='home'),

    #url(r'^log/', include('Login.urls', namespace="Login")),
    # url(r'^$', 'django_social_app.views.login'),
    # url(r'^home/$', 'django_social_app.views.home'),
    # url(r'^logout/$', 'django_social_app.views.logout'),

    #url(r'^secrets$', login_required(TemplateView.as_view(template_name="secrets.html"))),
    #url(r'^soc/', include('social.apps.django_app.urls', namespace='social')),


    #url(r'^login/', include('Login.urls', namespace="Login")),
    # url('', include('social.apps.django_app.urls', namespace='social')),
    #url('', include('django.contrib.auth.urls', namespace='auth')),
    #url(r'/admin/oauth/', include('oauthadmin.urls')),
    #url(r'^oauth2/', include('provider.oauth2.urls', namespace = 'oauth2')),
   # url(r'^testapp/', include('testapp.urls')),

]
urlpatterns+=staticfiles_urlpatterns()
