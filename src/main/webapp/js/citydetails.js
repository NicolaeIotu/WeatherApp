const nastring = "N/A";

$sentences = {
	setIcon : function(icon, target) {
		$(target).attr({
			src : "./img/weather/" + icon + ".png",
			onerror : "this.onerror=null; this.src='http://openweathermap.org/img/w/" + icon + ".png';"
		});
	},
	cityCountry : function(city, country) {
		return (city + " (" + country + ")");
	},
	timestampToString : function(ts) {
		return (new Date(parseInt(ts, 10) * 1000).toString());
	},
	timestampToTimeString : function(ts) {
		return (new Date(parseInt(ts, 10) * 1000).toLocaleTimeString());
	},
	latLon : function(lat, lon) {
		ns = (lat = parseFloat(lat, 10)) >= 0 ? "N" : "S";
		ew = (lon = parseFloat(lon, 10)) >= 0 ? "E" : "W";
		return ("Lat: " + (lat = Math.abs(lat)) + ns + ", Lon: " + (lon = Math.abs(lon)) + ew);
	},
	temperature : function(main, max, min) {
		ret = main;
		if (max != nastring) {
			ret += " [ max " + max + " ]";
		}
		if (min != nastring) {
			ret += " [ min " + min + " ]";
		}
		return ret;
	},
	pressure : function(main, grnd, sea) {
		ret = parseFloat(main, 10).toFixed(0);
		if (grnd != nastring) {
			ret += " [ ground level " + parseFloat(grnd, 10).toFixed(0) + " ]";
		}
		if (sea != nastring) {
			ret += " [ sea level " + parseFloat(sea, 10).toFixed(0) + " ]";
		}
		return ret;
	}
};

function $convert(type, value) {
	switch (type) {
	case "metric":
		return value.toFixed(1);
		break;
	case "imperial":
		return (value * 2.23694).toFixed(1);
		break;
	case "celsius":
		return (value - 273.15).toFixed(1);
	case "fahrenheit":
		return ((value * 9 / 5) - 459.67).toFixed(1);
	default:

		break;
	}
}

function $convertOps(type) {
	console.log("$convertOps", type);

	switch (type) {
	case "metric":
	case "imperial":
		// $("#details_wind_speed").text($(this).attr('data-on'));
		for (i = 0; i < $$_windspeed.length; i++) {
			ws = parseFloat($$_windspeed[i].getAttribute('data-windspeed'), 10);
			$$_windspeed[i].innerHTML = $convert(type, ws);
		}
		break;
	case "celsius":
	case "fahrenheit":
		for (i = 0; i < $$_temperature.length; i++) {
			kelvin = parseFloat($$_temperature[i].getAttribute('data-kelvin'), 10);
			kelvinMax = parseFloat($$_temperature[i].getAttribute('data-kelvinmax'), 10);
			kelvinMin = parseFloat($$_temperature[i].getAttribute('data-kelvinmin'), 10);
			$$_temperature[i].innerHTML = $sentences.temperature($convert(type, kelvin), $convert(type, kelvinMax), $convert(type,
					kelvinMin));
		}
		break;
	default:

		break;
	}

}

// declare these elements once in order to speed up subsequent requests
$_details_icon = $("#details_icon");
$_details_citycountry = $("#details_citycountry");
$_details_timestamp = $("#details_timestamp");
$_details_sunrise = $("#details_sunrise");
$_details_sunset = $("#details_sunset");
$_details_main = $("#details_main");
$_details_description = $("#details_description");
$_details_latlon = $("#details_latlon");
$_details_temp = $("#details_temp");
$_details_pres = $("#details_pres");
$_details_wind_speed = $("#details_wind_speed");
$_details_wind_deg = $("#details_wind_deg");
$_details_humidity = $("#details_humidity");
$_details_visiblity = $("#details_visiblity");
$_details_clouds = $("#details_clouds");
$_details_rain_1 = $("#details_rain_1");
$_details_rain_3 = $("#details_rain_3");
$_details_snow_1 = $("#details_snow_1");
$_details_snow_3 = $("#details_snow_3");

// objects, not arrays
$$_temperature = $("[data-temperature]");
$$_windspeed = $("[data-windspeed]");

$cityDetails = {
	populateCityDetails : function(data) {
		// filter and replace default values
		for ( var prop in data) {
			data[prop] = $cityDetails.na(data[prop]);
		}

		$sentences.setIcon(data.weather_condition_icon, "#details_icon");
		$("#details_citycountry").text($sentences.cityCountry(data.city_name, data.countrycode));
		$("#details_timestamp").text($sentences.timestampToString(data.calculation_timestamp_utc));
		$("#details_sunrise").text("Sunrise: " + $sentences.timestampToTimeString(data.sys_sunrise_timestamp_utc));
		$("#details_sunset").text("Sunset: " + $sentences.timestampToTimeString(data.sys_sunset_timestamp_utc));
		$("#details_main").text(data.weather_condition_main);
		$("#details_description").text(" - " + data.weather_condition_description);
		$("#details_latlon").text($sentences.latLon(data.geo_latitude, data.geo_longitude));

		$("#details_temp").attr('data-kelvin', data.main_temp);
		$("#details_temp").attr('data-kelvinmax', data.main_temp_max);
		$("#details_temp").attr('data-kelvinmin', data.main_temp_min);
		$('#toggle-temperature').change();

		$("#details_pres").text($sentences.pressure(data.main_pressure, data.main_pressure_grnd_level, data.main_pressure_sea_level));

		$("#details_wind_speed").attr('data-windspeed', data.wind_speed);
		$('#toggle-system').change();

		$("#details_wind_deg").text(parseInt(data.wind_deg));
		$("#details_humidity").text(data.main_humidity);
		$("#details_visiblity").text(data.visibility);
		$("#details_clouds").text(data.clouds);
		$("#details_rain_1").text(data.rain_last_1_hr);
		$("#details_rain_3").text(data.rain_last_3_hr);
		$("#details_snow_1").text(data.snow_last_1_hr);
		$("#details_snow_3").text(data.snow_last_3_hr);

		$('#intro').hide();
		$("#details_spinner").hide();
		$("#weather_details").show();
		$('#ajax-select ~ button').attr('disabled', null);
		
		
		wwwapiid= data.wwwapiid.toString();
		index = $previewIds.indexOf(wwwapiid);
		if ($previewIds[0] == '') {
			if (index == -1) {
				$previewIds[0] = wwwapiid;
			} else {
				// nothing to do here for now
			}
		} else {
			if (index == -1) {
				$previewIds.unshift(wwwapiid);
				$previewIds.pop();
			} else {
				$previewIds.splice(index, 1);
				$previewIds.unshift(wwwapiid);
			}
			reloadPreviews();
		}
		
		var tomorrow = new Date();
		tomorrow.setDate(tomorrow.getDate() + 1);
		$cookies.set('previewIds', $previewIds, tomorrow);
	},
	errorFetchingCityDetails : function(jqXHR, textStatus, errorThrown) {
		//console.log(textStatus, errorThrown);
		$('#intro').hide();
		$('#main_error_toast').toast('show');
		$("#details_spinner").hide();
		$("#weather_details").hide();
		$('#ajax-select ~ button').attr('disabled', null);
	},
	na : function(arg) {
		ret = arg;
		if ((arg = arg.toString()) == "-999999") {
			return nastring;
		} else {
			return ret;
		}
	}
};

$('#toggle-temperature').change(function() {
	if ($(this).prop('checked')) {
		$convertOps("celsius");
		$(".temp_uom").text($(this).attr('data-on'));
	} else {
		$convertOps("fahrenheit");
		$(".temp_uom").text($(this).attr('data-off'));
	}
});

$('#toggle-system').change(function() {
	uom = $(".windspeed_uom");

	if ($(this).prop('checked')) {
		$convertOps("metric");
		uom.text(uom.attr('data-metric'));
	} else {
		$convertOps("imperial");
		uom.text(uom.attr('data-imperial'));
	}
});
