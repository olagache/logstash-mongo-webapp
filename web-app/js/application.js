if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

/* Open all links with attribute 'rel=external' in a popup windows */
$(document).ready(function () {
    $("a[rel=external]").click(function (e) {
        var url = $(this).attr("href")
        var windowSize = "width=1200,height=800"

        window.open(url, "logDetails", windowSize);
        e.preventDefault()
    });
});


