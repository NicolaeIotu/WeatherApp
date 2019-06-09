$cookies = {
	get : function(cookieName) {
		try {
			ckArr = document.cookie.split(';');
			for (i = 0; i < ckArr.length; i++) {
				valArr = ckArr[i].split('=');
				if (valArr[0].trim() == cookieName)
					return valArr[1].trim();
			}

			return null;
		} catch (e) {
			return null;
		}
	},
	set : function(name, value, expiration) {
		document.cookie = name + '=' + value + ((expiration instanceof Date) ? '; expires=' + expiration.toUTCString() : '');
	}
};

if (($previewIds = $cookies.get('previewIds')) === null) {
	$previewIds = [ '', '681290', '5128581', '680963' ];
} else {
	$previewIds = $previewIds.split(',');
	if($previewIds[0] != "") {
		$previewIds.unshift("");
		$previewIds.pop();
	}
}

$previews = {
	populateCityPreview : function(data, previewPosition) {
		// filter and replace default values
		for ( var prop in data) {
			data[prop] = $cityDetails.na(data[prop]);
		}

		$sentences.setIcon(data.weather_condition_icon, "#preview_icon" + previewPosition);
		$("#preview_citycountry"+previewPosition).text($sentences.cityCountry(data.city_name, data.countrycode));

		$("#preview_temperature"+previewPosition).attr('data-kelvin', data.main_temp);
		$("#preview_temperature"+previewPosition).attr('data-kelvinmax', data.main_temp_max);
		$("#preview_temperature"+previewPosition).attr('data-kelvinmin', data.main_temp_min);
		$('#toggle-temperature').change();

		$("#preview_pres"+previewPosition).text($sentences.pressure(data.main_pressure, data.main_pressure_grnd_level, data.main_pressure_sea_level));

		$("#preview_wind_speed"+previewPosition).attr('data-windspeed', data.wind_speed);
		$('#toggle-system').change();
		// ///////////////////////////////////////////////////

		$("#preview_spinner"+previewPosition).hide();
		$("#preview"+previewPosition).show();
	},
	errorFetchingPreviewDetails : function(jqXHR, textStatus, errorThrown, previewPosition) {
		$('#main_error_toast').toast('show');
		$("#details_spinner").hide();
		$("#weather_details").hide();
		$('#ajax-select ~ button').attr('disabled', null);
	}
};

