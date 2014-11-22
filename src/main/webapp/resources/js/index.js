/** ------------------------------------------------------------ */
var block = false;
var synctime = true;

var edit_url = "";

function setEditUrl(url) {
	this.edit_url = url;
	jQuery( ".exercise_class" ).dblclick(function() {
	  window.location.href = url;
	});
}

// jQuery('.relevant_table_popup').dialog({
// 	modal: true,
// 	height: 'auto',
// 	width: 'auto'
// });

jQuery(document).ready(function() {
	var delay = parseInt(jQuery("[id*=sessionTime]").html());
	function countdown() {
		delay = parseInt(jQuery("[id*=sessionTime]").html());
		setTimeout(countdown, 1000);
		delay--;
		if (delay < 0) {
			delay = 0;
		} else {
			jQuery('[id*=sessionTime]').html(delay);
		}
	}
	countdown();
});


jQuery.ajaxSetup({
	error : handleXhrError,
	success : handleSuccess
});

function handleXhrError(xhr) {
	startAjaxStatus();
	setTimeout("ajax_error_dialog.show()", 3000);
}

function handleSuccess(xhr) {
	if (!block) {
		blockUpdate();
		syncSessionDisplay();
		setTimeout("unblockUpdate()", 2000);
	}
}

function syncSessionDisplay() {
	if (synctime) {
		lazyload();
		lazyload_online();
	}
}

function blockUpdate() {
	block = true;
}

function unblockUpdate() {
	block = false;
}

function startAjaxStatus() {
	jQuery("#ajaxStatusPanel_prestart").css({
		display : "block"
	});
	setTimeout("endAjaxStatus()", 1500);
}

function endAjaxStatus() {
	jQuery("#ajaxStatusPanel_prestart").css({
		display : "none"
	});

	jQuery("#ajaxStatusPanel_default").css({
		display : "none"
	});
}

function collapseIntroduction() {
	startAjaxStatus();
	intro.unselect(0);
}

function editLastDatatableRow() {
	jQuery('.ui-datatable-tablewrapper tr').last().find('span.ui-icon-pencil')
			.each(function() {
				jQuery(this).click()
			});
}

jQuery(document).ready(function() {

	if (detectIE()) {
  	jQuery("#shitty_internet_explorer").css({
  		display : "block"
  	});
	}

	jQuery('.tree_description').pulsate({
	 color: '#DCE0FF',
  	 repeat: 3  
	});

	jQuery('.admin_help_text').pulsate({
	 color: '#FFE5E5',
  	 repeat: 2  
	});

//	jQuery('.unrated_tab').click(function() {
//		startAjaxStatus();
//		setTimeout("startAjaxStatus()", 500);
//	});
//	jQuery('.rated_tab').click(function() {
//		startAjaxStatus();
//		setTimeout("startAjaxStatus()", 500);
//	});
	jQuery( ".tree_doubleclick" ).dblclick(function() {
	 	this.parentNode.parentNode.firstChild.click();
	});
});


function pulsateButton() {
	jQuery('#usertask\\:user_result_button').pulsate({
	 color: '#D3D8FF',
  	 repeat: 2  
	});

	jQuery('#usertask\\:result_button').pulsate({
	 color: '#D3D8FF',
  	 repeat: 2  
	});

	jQuery('#usertask\\:feedback_accordion').pulsate({
	 color: '#D3D8FF',
  	 repeat: 2  
	});

	jQuery('#saved_query_box').pulsate({
	 color: '#D3D8FF',
  	 repeat: 2  
	});
}

var siteFunctions = {
	// patch to fix a problem that the context menu disappears after update
	// delay the show to occure after the update
	patchContextMenuShow : function() {
		'use strict';
		var protShow = PrimeFaces.widget.ContextMenu.prototype.show;
		siteFunctions.patchContextMenuShow.lastEvent = null;
		PrimeFaces.widget.ContextMenu.prototype.show = function(e) {
			var ret;
			if (e) {
				siteFunctions.patchContextMenuShow.lastEvent = e;
				siteFunctions.patchContextMenuShow.lastEventArg = arguments;
				siteFunctions.patchContextMenuShow.lastEventContext = this;
			} else if (siteFunctions.patchContextMenuShow.lastEvent) {
				ret = protShow.apply(
						siteFunctions.patchContextMenuShow.lastEventContext,
						siteFunctions.patchContextMenuShow.lastEventArg);
				siteFunctions.patchContextMenuShow.lastEvent = null;
			}
			return ret;
		};
	}
};

jQuery(document).ready(function() {
	'use strict';
	try {
		siteFunctions.patchContextMenuShow();
	} catch (e) {
		console.error(e);
	}
});

function expand_tree() {
	var treeExcludingRoot = jQuery(".ui-treenode-children").first();
	jQuery(".ui-tree-toggler.ui-icon-triangle-1-e", treeExcludingRoot).click();
}

function collapse_tree() {
	var treeExcludingRoot = jQuery(".ui-treenode-children").first();
	jQuery(".ui-tree-toggler.ui-icon-triangle-1-s", treeExcludingRoot).click();
}


// jQuery("#gif_image").waitUntilExists(function() {
// });

// jQuery(document).ready(function(){
// jQuery('#gif_image').each(function(e){
// var src = jQuery(e).attr('src');
// alert(src);
// jQuery(e).hover(function(){
// jQuery(this).attr('src', src.replace('_dea.gif', '.gif'));
// }, function(){
// jQuery(this).attr('src', src);
// });
// });
// });

jQuery(document).ready(function() {
	jQuery("#gif_image").hover(function() {
		jQuery(this).attr("src", "/sql/resources/img/help.gif");
	}, function() {
		jQuery(this).attr("src", "/sql/resources/img/help_dea.gif");
	});
});




PrimeFaces.locales['de'] = {
    closeText: 'Schließen',
    prevText: 'Zurück',
    nextText: 'Weiter',
    monthNames: ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember'],
    monthNamesShort: ['Jan', 'Feb', 'Mär', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Okt', 'Nov', 'Dez'],
    dayNames: ['Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag'],
    dayNamesShort: ['Son', 'Mon', 'Die', 'Mit', 'Don', 'Fre', 'Sam'],
    dayNamesMin: ['S', 'M', 'D', 'M ', 'D', 'F ', 'S'],
    weekHeader: 'Woche',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Nur Zeit',
    timeText: 'Zeit',
    hourText: 'Stunde',
    minuteText: 'Minute',
    secondText: 'Sekunde',
    currentText: 'Aktuelles Datum',
    ampm: false,
    month: 'Monat',
    week: 'Woche',
    day: 'Tag',
    allDayText: 'Ganzer Tag'
};

function detectIE() {
    var ua = window.navigator.userAgent;
    var msie = ua.indexOf('MSIE ');
    var trident = ua.indexOf('Trident/');

    if (msie > 0) {
        // IE 10 or older => return version number
        // return parseInt(ua.substring(msie + 5, ua.indexOf('.', msie)), 10);
		return true;
    }

    if (trident > 0) {
        // IE 11 (or newer) => return version number
        var rv = ua.indexOf('rv:');
        //return parseInt(ua.substring(rv + 3, ua.indexOf('.', rv)), 10);
		return true;
    }

    // other browser
    return false;
}

function hideIEMessage() {
	jQuery("#shitty_internet_explorer").css({
		display : "none"
	});
}
