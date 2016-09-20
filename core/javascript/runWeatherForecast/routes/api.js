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
        string = "There will be storm today. Please stay Indoors. Stay safe :P";
    else
        string = "Good news! There are no storms predicted, Are we running today?";
    res.send(string);
});

module.exports = router;
