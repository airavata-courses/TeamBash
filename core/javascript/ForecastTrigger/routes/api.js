
var express = require('express');
var router = express.Router();

/* POST users listing. */
router.post('/forecastTrigger', function(req, res, next) {
    var number = Math.random() > 0.5 ? 0 : 1;
    if(number==1) {
        var resultForecast = 'True';
    } 
    else {
        var resultForecast = 'False';
    }
    res.send(resultForecast);
});

module.exports = router;
