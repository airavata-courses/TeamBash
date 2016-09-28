from django.shortcuts import render
from django.shortcuts import render
from django.template import loader
from django.http import HttpResponse, HttpResponseRedirect
from django.urls import reverse
from django.shortcuts import redirect
import httplib2
import urllib
import urllib2
import json

# Create your views here.

userid=''
def login(request) :
    return render(request, 'Login/login.html', {})

def loginAPI(request):
    context = {
        'username': request.POST['Username'],
        'password': request.POST['Password'],
    }

    h = httplib2.Http()
    resp, content = h.request(
        uri='http://52.25.123.69:8888/loginUser',
        method='POST',
        headers={'Content-Type': 'application/json; charset=UTF-8'},
        body=json.dumps(context),
    )
    print resp ,"JANAL", content
    if resp['status'] == '401':
        return render(request, 'Login/401.html', {})
    userid = content
    return redirect('Login:weatherForm')

def getStats(request):
    h = httplib2.Http()
    context = {
        'userid': userid
    }

    body = urllib.urlencode(context)
    resp, content = h.request("http://52.25.123.69:8888/registry/displayData/"+str(userid), method="GET", body=body)

    return render(request, 'Login/login.html', {})


def weatherForm(request):
    print("I AM HERRE")
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
    day =[]

    for i in range(1,31):
        if i<10:
            day.append('0'+str(i))
        else:
            day.append(str(i))
    return render(request, 'Login/weatherForm.html', {'year' : range(1991,2017), 'day':day , 'station':stationList1})


def hit(request):
    stationCodeDict = {'Aberdeen, SD ': 'KABR', 'Tulsa, OK': 'KSGF', 'Milwaukee, WI': 'KAMX',
                       'Columbus AFB, MS': 'KCLE', 'Rapid City, SD': 'KGYX',
                       'El Paso, TX': 'KDYX', 'Bismarck, ND': 'KBMX', 'Caribou, ME': 'KCXX', 'Sioux Falls, SD': 'KNKX',
                       'Paducah, KY': 'KLNX', 'San Joaquin Valley, CA': 'KDAX', 'Amarillo, TX': 'KAMA',
                       'Tallahassee, FL': 'PHKI',
                       'Duluth, MN': 'KDDC', 'Dyess AFB, TX': 'KDOX', 'Atlanta, GA': 'KFFC', 'Maxwell AFB, AL': 'KLVX',
                       'Biorka Island/Sitka, AK': 'KBGM', 'Great Falls, MT': 'KMVX', 'Kansas City, MO': 'KJKL',
                       'Brownsville, TX': 'KFCX',
                       'Wakefield, VA': 'KCCX', 'Montague/Ft Drum, NY': 'KMPX', 'Hastings, NE': 'KTFX',
                       'Salt Lake City, UT': 'KRAX',
                       'Omaha, NE': 'FAA', 'Jackson, KY': 'KHGX', 'Northwest Florida/Eglin AFB, FL': 'KLIX',
                       'Spokane, WA': 'FAA',
                       'Dodge City, KS': 'KDMX', 'Tampa Bay, FL': 'FAA', 'North Platte, NE': 'KMHX',
                       'Albuquerque, NM': 'KABX',
                       'Ft Worth, TX': 'KFDR', 'Grand Junction, CO': 'KGGW', 'Houston, TX': 'KGSP',
                       'Medford, OR': 'KLBB',
                       'Sterling, VA': 'KFSD', 'Shreveport, LA': 'KEWX', 'Marquette, MI': 'KVTX',
                       'Oklahoma City, OK': 'PAEC',
                       'Bethel, AK': 'PABC', 'Pocatello, ID': 'KPAH', 'Charleston, WV': 'KICX', 'Des Moines IA': 'KCRP',
                       'Blacksburg, VA': 'KBIS', 'Goodland, KS': 'KFWS', 'Eureka, CA': 'KEYX', 'Columbia, SC': 'KILN',
                       'Kamuela/Kohala, HI': 'KIND', 'Greer, SC': 'KGRR', 'Cannon AFB, NM': 'KBUF',
                       'Pendleton, OR': 'KIWX',
                       'Mobile, AL': 'KMAF', 'Corpus Christi, TX': 'KCAE', 'Boston, MA': 'NWS', 'Billings, MT': 'FAA',
                       'Holloman AFB, NM': 'KGRB', 'Laughlin AFB, TX': 'KARX', 'Cincinnati/Wilmington, OH': 'KCYS',
                       'Memphis, TN': 'KMXX',
                       'Northern Indiana/North Webster, IN': 'KOHX', 'State College, PA': 'KSHV', 'Molokai, HI': 'KMKX',
                       'Andersen AFB, Guam': 'PGUA', 'Fairbanks/Pedro Dome, AK': 'KBHX', 'Melbourne, FL': 'KMQT',
                       'Cedar City, UT': 'KFDX', 'Lincoln, IL': 'KLCH', 'San Juan, PR': 'KMTX',
                       'Birmingham, AL': 'PACG',
                       'Jackson, MS': 'KHTX', 'Little Rock, AR': 'KESX', 'Minot AFB, ND': 'FAA', 'Detroit, MI': 'KFTG',
                       'Seattle, WA': 'NWS', 'Flagstaff, AZ': 'KVWX', 'Ft Rucker, AL': 'KSRX', 'Wilmington, NC': 'KTLH',
                       'La Crosse, WI': 'KBYX', 'Topeka, KS': 'PHWA', 'Indianapolis, IN': 'KHDX',
                       'Sacramento, CA': 'KDVN',
                       'San Diego, CA': 'KJGX', 'Pittsburgh, PA': 'KOAX', 'San Antonio, TX': 'KRIW',
                       'Evansville, IN': 'KEPZ',
                       'Wichita, KS': 'KLWX', 'Gaylord, MI': 'KHPX', 'Raleigh/Durham, NC': 'KSFX',
                       'Green Bay, WI': 'KGJX',
                       'King Salmon, AK': 'PHKM', 'Anchorage/Kenai, AK': 'PAHG', 'Philadelphia, PA': 'KEVX',
                       'Louisville, KY': 'KILX',
                       'Santa Ana Mountains, CA': 'KSJT', 'Phoenix, AZ': 'KTLX', 'Key West, FL': 'KDGX',
                       'Portland, OR': 'KDIX',
                       'Buffalo, NY': 'KBOX', 'Cheyenne, WY': 'KCLX', 'Lake Charles, LA': 'PAKC',
                       'Burlington, VT': 'KBRO',
                       'Cleveland, OH': 'KLOT', 'Midland/Odessa, TX': 'KNQA', 'Glasgow, MT': 'KEOX',
                       'Tucson, AZ': 'KOTX',
                       'Nome, AK': 'KVAX', 'Dover AFB, DE': 'KDTX', 'Moody AFB, GA': 'KMBX', 'St Louis, MO': 'KATX',
                       'Springfield, MO': 'KSOX', 'Lubbock, TX': 'KLZK', 'San Angelo, TX': 'KUDX', 'Albany, NY': 'KENX',
                       'Ft Campbell, KY': 'KFSX', 'Minneapolis, MN': 'PAIH', 'South Kauai, HI': 'KHNX',
                       'Las Vegas, NV': 'KMRX',
                       'Yuma, AZ': 'KTBW', 'Binghamton, NY': 'KBLX', 'Knoxville/Morristown, TN': 'KEAX',
                       'Frederick/Altus AFB, OK': 'FAA',
                       'Los Angeles, CA': 'KDFX', 'Middleton Island, AK': 'KMLB', 'Grand Rapids, MI': 'KGLD',
                       'Robins AFB, GA': 'KPUX',
                       'Nashville, TN': 'PHMO', 'Miami, FL': 'KMAX', 'New Orleans, LA': 'KTYX',
                       'Vandenberg AFB, CA': 'KLSX',
                       'Morehead City, NC': 'KMOB', 'Fort Smith, AR': 'PAPD', 'Riverton, WY': 'KRTX',
                       'Denver, CO': 'KGWX',
                       'Edwards AFB, CA': 'KDLH', 'Pueblo, CO': 'KIWA', 'Quad Cities/Davenport, IA': 'KPBZ',
                       'Charleston, SC': 'KCBW',
                       'Chicago, IL': 'KRLX', 'Portland, ME': 'KPDT', 'South Shore, HI': 'TJUA',
                       'Huntsville/Hytop, AL': 'KUEX',
                       'Beale AFB, CA': 'KBBX', 'Grand Forks, ND': 'KAPX'}
    stationCode =''
    if request.method == 'POST':
        print(request.POST)
        for key in stationCodeDict.keys():
            if  str(request.POST['station']) in key:
                stationCode = stationCodeDict[key]
                break
        h = httplib2.Http()

        response, content=h.request("http://52.25.123.69:8888/dataIngestor/"+str(userid) +str(request.POST['year'])+'/'+str(request.POST['month'])+'/'+str(request.POST['day'])+'/'+stationCode+'/')
        print(content)
        if content == 'false':
            return render(request, 'Login/falseForecast.html')
        elif response['status']=='206':
            return render(request, 'Login/206.html')
        elif response['status']=='404':
            return render(request, 'Login/404.html')
        elif response['status'] == '500':
            return render(request, 'Login/500.html')
        else:
            return render(request, 'Login/Result.html',content)


def result(request):
    if '404' in request.body:
        return render(request, 'Login/404.html', {})
    else:
        return render(request, 'Login/Result.html',{} )


