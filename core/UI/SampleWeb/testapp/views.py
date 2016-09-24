from django.shortcuts import render
from django.template import loader
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from .forms import RegisterForm
from django.shortcuts import redirect

import os

# Create your views here.
def index(request) :
    print(os.getcwd())

    #template = loader.get_template('testapp/base.html')
    #return HttpResponse(template.render({'current_name' : 'sruthi'}, request))
    return render(request, 'testapp/base.html', {})

def hit(request):
    return redirect('http://127.0.0.1:5000/user/id/2016/05/14/FOPL')

def get_name(request):
    # if this is a POST request we need to process the form data
    if request.method == 'POST':
        # create a form instance and populate it with data from the request:
        form = RegisterForm(request.POST)
        # check whether it's valid:
        if form.is_valid():
            # process the data in form.cleaned_data as required
            # ...
            # redirect to a new URL:
            return HttpResponseRedirect(reverse('/thanks/'))

    # if a GET (or any other method) we'll create a blank form
    else:
        form = RegisterForm()
    var = 'hello'
    return render(request, 'base.html', {'form': form})