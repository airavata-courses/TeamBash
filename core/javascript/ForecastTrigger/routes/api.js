
var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/forecastTrigger', function(req, res, next) {
    var number = Math.random(0,1);
    if(number==0) {
        var resultForecast = {forecast:'YES' ,num:number};
    }
    else {
        var resultForecast = {forecast: 'NO' , num:number};
    }
    var resultForecastJSON = JSON.stringify(resultForecast)
    res.json(resultForecastJSON);
});

module.exports = router;
