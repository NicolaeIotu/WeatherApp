const $domain = 'http://localhost:8080';
const $searchUrl = $domain + '/cities/name';

var options = {
	ajax : {
		url : $searchUrl,
		type : 'GET',
		dataType : 'json',
		data : {
			q : '{{{q}}}'
		}
	},
	minLength : 2,
	log : 3,

	preprocessData : function(data) {
		var i, l = data.content.length, arr = [];
		var content;
		if (l) {
			for (i = 0; i < l; i++) {
				content = data.content[i];
				arr.push({
					text : content.city_name,
					value : content.wwwapiid,
					data : {
						subtext : content.countrycode
					}
				});
			}
		}
		return arr;
	}
};


$('.selectpicker').selectpicker().ajaxSelectPicker.locale["en-US"].emptyTitle = "Search City";
$('.selectpicker').selectpicker().ajaxSelectPicker(options);
$('#ajax-select').change(function() {
	var tgt = this.selectedOptions;
	//city name is tgt[0].text;
	//city id is tgt[0].value;
	if(tgt && tgt[0] && tgt[0].value && tgt[0].value != $('#ajax-select').attr('data-value')) {
		$('#ajax-select').attr('data-value', tgt[0].value);
		$('#ajax-select ~ button').attr('disabled', 'disabled');
		$("#details_spinner").show();
		$AjaxHandler.cityDetails.ajax(WEATHERDETAILSBASEURL + tgt[0].value);		
	}
});
