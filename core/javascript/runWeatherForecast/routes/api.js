/**
 * Created by Raghuveer Raavi on 9/20/2016.
 */
var express = require('express');
var router = express.Router();
var url = require('url');

/* GET users trigger forecast value. */
router.get('/run-weather-forecast/:value', function(req, res, next) {
    // var url_parts = url.parse(req.url, true);
    // var query = url_parts.query;
    var value = req.params.value;
    if(value=='true')
        string = `<?xml version="1.0" encoding="UTF-8"?>
    <kml xmlns="http://earth.google.com/kml/2.2">
        <Folder>
        <name>NSSL/U. of Oklahoma Weather Products</name>
    <visibility>0</visibility>
    <open>1</open>
    <description>These data are experimental and are provided for research purposes only. Images are (C) 2008 University of Oklahoma and the National Severe Storms Laboratory. See wdssii.org and wdssii.nssl.noaa.gov for more details.</description>
    <lookAt>
    <longitude>-94.30748438559675</longitude>
    <latitude>36.2972521725685</latitude>
    <altitude>0</altitude>
    <range>5139465.519150443</range>
    <tilt>0</tilt>
    <heading>0.20760638</heading>
    </lookAt>
    <NetworkLink>
    <name>Radar: Reflectivity Composite from 3D</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/MergedReflectivityQCComposite_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Lowest Altitude Reflectivity</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/ReflectivityAtLowestAltitude_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: VIL</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/VIL_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Hail: Max Expected Size</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/MESH_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Hail: Swath 30 Min</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/MESH_Max_30min_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Hail: Swath 120 Min</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/MESH_Max_120min_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Hail: Prob of Severe</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/POSH_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Echo Top (18dBZ)</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/EchoTop_18_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Echo Top (30dBZ)</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/EchoTop_30_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Echo Top (50dBZ)</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/EchoTop_50_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Reflectivity on 0C Isosurface</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/Reflectivity_0C_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Refletivitiy on -10C Isosurface</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/Reflectivity_-10C_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Reflectivity on -20C Isosurface</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/Reflectivity_-20C_00.50/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Rotation: Max Az Shear 0-2 km AGL</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/MergedAzShear_0-2kmAGL_00.00/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: Rotation: Max Az Shear 3-6 km AGL</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/MergedAzShear_3-6kmAGL_00.00/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: 120 Minute 0-2km AGL Rotation Track</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/RotationTrack120min_00.00/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: 30 Minute 0-2km AGL Rotation Track</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/RotationTrack30min_00.00/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: 120 Minute 3-6km AGL Rotation Track</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/RotationTrackML120min_00.00/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Radar: 30 Minute 3-6km AGL Rotation Track</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/tiles/RotationTrackML30min_00.00/index.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Warnings: NWS Warning Products</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/realtime/warnings/NWS_Warnings.kml</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Reports: NWS Hourly Storm Reports</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/geotiff/kml/NwsHourlyStormLogs.kml</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Metars: Hourly METAR Observations</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/realtime/METAR.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>

    <NetworkLink>
    <name>Colormaps: Weather Products Colormaps</name>
    <visibility>0</visibility>
    <Url>
    <href>http://wdssii.nssl.noaa.gov/geotiff/colormaps.kmz</href>
    <refreshMode>onInterval</refreshMode>
    <refreshInterval>300</refreshInterval>
    </Url>
    </NetworkLink>
    </Folder>
    </kml>`;
    else
        string = "Good news! There are no storms predicted, Are we running today?";
    res.send(string);
});

module.exports = router;
