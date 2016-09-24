from django import forms

class RegisterForm(forms.Form):
    your_name = forms.CharField(label = 'Your name', max_length =100)
    password = forms.CharField(widget=forms.PasswordInput())