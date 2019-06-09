const WEATHERDETAILSBASEURL = "http://localhost:8080/weather/";
var $AjaxHandler = {
	append : function(entryName, success, error, previewPosition) {
		$AjaxHandler[entryName] = {
			running : false,
			error : false,
			ajax : function(url) {
				if ($AjaxHandler[entryName].running) {
					alert("Update operation in progress. Please wait!");
				} else {
					if (previewPosition != null) {
						$("#preview_spinner" + previewPosition).show();
					} else {
						$("#details_spinner").show();
					}

					$AjaxHandler[entryName].jqXhrOpt.url = url;
					$AjaxHandler[entryName].jqXhrOpt.success = function(data) {
						console.log("SUCCES!");

						success(data, previewPosition);
						$AjaxHandler[entryName].jqXhrOpt.setOnSuccess();
					}
					$AjaxHandler[entryName].jqXhrOpt.error = function(jqXHR, textStatus, errorThrown) {
						console.log("ERROR!");

						error(jqXHR, textStatus, errorThrown, previewPosition);
						$AjaxHandler[entryName].jqXhrOpt.setOnError();
					};
					$AjaxHandler[entryName].running = true;
					$AjaxHandler[entryName].error = false;

					$AjaxHandler[entryName].jqXhr = $.ajax($AjaxHandler[entryName].jqXhrOpt);
				}
			},
			jqXhrOpt : {
				url : WEATHERDETAILSBASEURL,
				data : null,
				dataType : "json",
				crossDomain : false,
				method : 'GET',
				setOnSuccess : function() {
					$AjaxHandler[entryName].running = false;
					$AjaxHandler[entryName].error = false;
				},
				setOnError : function() {
					$AjaxHandler[entryName].running = false;
					$AjaxHandler[entryName].error = true;
				},
				success : null,
				error : null
			},
			jqXhr : null
		};
	}
};

function toggleExplain() {
	try {
		$explain = !$explain;
	} catch (e) {
		$explain = true;
	}

	if ($explain) {
		$('.explain').show();
		$('#explain_li').addClass('active');
	} else {
		$('.explain').hide();
		$('#explain_li').removeClass('active');
	}
}

function reloadPreviews() {
	$AjaxHandler.cityPreview1.ajax(WEATHERDETAILSBASEURL + $previewIds[1]);
	$AjaxHandler.cityPreview2.ajax(WEATHERDETAILSBASEURL + $previewIds[2]);
	$AjaxHandler.cityPreview3.ajax(WEATHERDETAILSBASEURL + $previewIds[3]);
}

$AjaxHandler.append("cityDetails", $cityDetails.populateCityDetails, $cityDetails.errorFetchingCityDetails);
$AjaxHandler.append("cityPreview1", $previews.populateCityPreview, $previews.errorFetchingPreviewDetails, 1);
$AjaxHandler.append("cityPreview2", $previews.populateCityPreview, $previews.errorFetchingPreviewDetails, 2);
$AjaxHandler.append("cityPreview3", $previews.populateCityPreview, $previews.errorFetchingPreviewDetails, 3);
Object.seal($AjaxHandler);

reloadPreviews();
