var isLoggedIn = true;

// Displays user dropdown
$(".user").on("click", function(event) {
	event.stopPropagation();
	if (isLoggedIn) {
		$(".user__user-dropdown--logged-in").css("display", "block");
	}
	else {
		$(".user__user-dropdown--logged-out").css("display", "block");
	}
});

// Hides user dropdown when clicked outside of dropdown
$(document).on("click", function (event) {
	$(".user__user-dropdown--logged-in").css("display", "none");
	$(".user__user-dropdown--logged-out").css("display", "none");
});

// Submits search when enter key pressed
$("#search-form-id").on("keypress", function(event) {
	if (event.keyCode == 13) {
		console.log("Search submitted");
	}
	// NEED TO IMPLEMENT
});

