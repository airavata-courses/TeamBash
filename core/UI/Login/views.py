from django.shortcuts import render
from django.shortcuts import render
from django.template import loader
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from django.shortcuts import redirect


# Create your views here.

def login(request) :
    return render(request, 'Login/login.html', {})

def loginAPI(request):
    # context = {
    #     'username': request.POST[Username],
    #     'password': request.POST[Password],
    # }
    return HttpResponseRedirect(request, 'http://149.161.136.83:8080/loginUser')
    #return redirect('http://149.161.136.83:8080/loginUser')
    #r = requests.post('http://149.161.136.83:8080/loginUser/', auth=HTTPBasicAuth(request.POST[Username], request.POST[Password]))
    #return render(request,'http://149.161.136.83:8080/loginUser/')

def weatherForm(request):
    stationList1 = ['Albany, NY', 'Albuquerque, NM', 'Amarillo, TX', 'Anchorage/Kenai, AK', 'Andersen AFB, Guam', 'Atlanta, GA', 'Beale AFB, CA', 'Bethel, AK', 'Billings, MT', 'Binghamton, NY', 'Biorka Island/Sitka, AK', 'Birmingham, AL', 'Bismarck, ND', 'Blacksburg, VA', 'Boston, MA', 'Brownsville, TX', 'Buffalo, NY', 'Burlington, VT', 'Cannon AFB, NM', 'Caribou, ME', 'Cedar City, UT', 'Charleston, SC', 'Charleston, WV', 'Cheyenne, WY', 'Chicago, IL', 'Cincinnati/Wilmington, OH', 'Cleveland, OH', 'Columbia, SC', 'Columbus AFB, MS', 'Corpus Christi, TX', 'Denver, CO', 'Des Moines IA', 'Detroit, MI', 'Dodge City, KS', 'Dover AFB, DE', 'Duluth, MN', 'Dyess AFB, TX', 'Edwards AFB, CA', 'El Paso, TX', 'Eureka, CA', 'Evansville, IN', 'Fairbanks/Pedro Dome, AK', 'Flagstaff, AZ', 'Fort Smith, AR', 'Frederick/Altus AFB, OK', 'Ft Campbell, KY', 'Ft Rucker, AL', 'Ft Worth, TX', 'Gaylord, MI', 'Glasgow, MT', 'Goodland, KS', 'Grand Forks, ND', 'Grand Junction, CO', 'Grand Rapids, MI', 'Great Falls, MT', 'Green Bay, WI', 'Greer, SC', 'Hastings, NE', 'Holloman AFB, NM', 'Houston, TX', 'Huntsville/Hytop, AL', 'Indianapolis, IN', 'Jackson, KY', 'Jackson, MS', 'Kamuela/Kohala, HI', 'Kansas City, MO', 'Key West, FL', 'King Salmon, AK', 'Knoxville/Morristown, TN', 'La Crosse, WI', 'Lake Charles, LA', 'Las Vegas, NV', 'Laughlin AFB, TX', 'Lincoln, IL', 'Little Rock, AR', 'Los Angeles, CA', 'Louisville, KY', 'Lubbock, TX', 'Marquette, MI', 'Maxwell AFB, AL', 'Medford, OR', 'Melbourne, FL', 'Memphis, TN', 'Miami, FL', 'Middleton Island, AK', 'Midland/Odessa, TX', 'Milwaukee, WI', 'Minneapolis, MN', 'Minot AFB, ND', 'Mobile, AL', 'Molokai, HI', 'Montague/Ft Drum, NY', 'Moody AFB, GA', 'Morehead City, NC', 'Nashville, TN', 'New Orleans, LA', 'Nome, AK', 'North Platte, NE', 'Northern Indiana/North Webster, IN', 'Northwest Florida/Eglin AFB, FL', 'Oklahoma City, OK', 'Omaha, NE', 'Paducah, KY', 'Pendleton, OR', 'Philadelphia, PA', 'Phoenix, AZ', 'Pittsburgh, PA', 'Pocatello, ID', 'Portland, ME', 'Portland, OR', 'Pueblo, CO', 'Quad Cities/Davenport, IA', 'Raleigh/Durham, NC', 'Rapid City, SD', 'Riverton, WY', 'Robins AFB, GA', 'Sacramento, CA', 'Salt Lake City, UT', 'San Angelo, TX', 'San Antonio, TX', 'San Diego, CA', 'San Joaquin Valley, CA', 'San Juan, PR', 'Santa Ana Mountains, CA', 'Seattle, WA', 'Shreveport, LA', 'Sioux Falls, SD', 'South Kauai, HI', 'South Shore, HI', 'Spokane, WA', 'Springfield, MO', 'St Louis, MO', 'State College, PA', 'Sterling, VA', 'Tallahassee, FL', 'Tampa Bay, FL', 'Topeka, KS', 'Tucson, AZ', 'Tulsa, OK', 'Vandenberg AFB, CA', 'Wakefield, VA', 'Wichita, KS', 'Wilmington, NC', 'Yuma, AZ']
    stationList =['KABR','KENX', 'KABX', 'KAMA', 'PAHG', 'PGUA', 'KFFC', 'KBBX', 'PABC', 'FAA', 'KBLX', 'KBGM', 'PACG', 'KBMX', 'KBIS',
     'NWS', 'KFCX', 'KBOX', 'KBRO', 'KBUF', 'KCXX', 'KFDX', 'KCBW', 'KICX', 'KCLX', 'KRLX', 'KCYS', 'KLOT', 'KILN',
     'KCLE', 'KCAE', 'KGWX', 'KCRP', 'KFTG', 'KDMX', 'KDTX', 'KDDC', 'KDOX', 'KDLH', 'KDYX', 'KEYX', 'KEPZ', 'KBHX',
     'KVWX', 'PAPD', 'FAA', 'KFSX', 'KSRX', 'KFDR', 'KHPX', 'KEOX', 'KFWS', 'KAPX', 'KGGW', 'KGLD', 'KMVX', 'KGJX',
     'KGRR', 'KTFX', 'KGRB', 'KGSP', 'KUEX', 'KHDX', 'KHGX', 'KHTX', 'KIND', 'KJKL', 'KDGX', 'PHKM', 'KEAX', 'KBYX',
     'PAKC', 'KMRX', 'KARX', 'KLCH', 'KESX', 'KDFX', 'KILX', 'KLZK', 'KVTX', 'KLVX', 'KLBB', 'KMQT', 'KMXX', 'KMAX',
     'KMLB', 'KNQA', 'KAMX', 'PAIH', 'FAA', 'KMAF', 'KMKX', 'KMPX', 'KMBX', 'KMOB', 'PHMO', 'KTYX', 'KVAX', 'KMHX',
     'KOHX', 'KLIX', 'PAEC', 'FAA', 'KLNX', 'KIWX', 'KEVX', 'KTLX', 'KOAX', 'KPAH', 'KPDT', 'KDIX', 'KIWA', 'KPBZ',
     'KSFX', 'KGYX', 'KRTX', 'KPUX', 'KDVN', 'KRAX', 'KUDX', 'KRIW', 'KJGX', 'KDAX', 'KMTX', 'KSJT', 'NWS', 'KEWX',
     'KNKX', 'KHNX', 'TJUA', 'FAA', 'KSOX', 'KATX', 'KSHV', 'KFSD', 'PHKI', 'FAA', 'PHWA', 'KOTX', 'KSGF', 'KLSX',
     'KCCX', 'KLWX', 'KTLH', 'KTBW', 'KTWX', 'KEMX', 'KINX', 'KVBX', 'KAKQ', 'KICT', 'KLTX', 'KYUX']
    day = []
    for i in range(1,31):
        if i<10:
            day.append('0'+str(i))
        else:
            day.append(str(i))
    return render(request, 'Login/weatherForm.html', {'year' : range(1991,2017), 'day':day , 'station':stationList})

def hit(request):
    if request.method == 'POST':
        print(request.POST)
        #return redirect('http://149.161.136.83:8080/'+request.POST['year']+'/'+request.POST['month']+'/'+request.POST['day']+'/'+"KLTX"+'/')
        return redirect('http://149.161.136.83:8080/redirect/1991/06/06/KLTX')
        #return redirect('http://127.0.0.1:5000//')