
// Displays user dropdown
$(".user").on("click", function(event) {
	event.stopPropagation();
	$(".user__user-dropdown").css("display", "block");
});

// Hides user dropdown when clicked outside of dropdown
$(document).on("click", function (event) {
	$(".user__user-dropdown").css("display", "none");
});

