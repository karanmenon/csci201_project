var isLoggedIn = true;

// Displays user dropdown
$(document).on("click",".user", function(event) {
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
// Not sure if there's a better way to handle this
$("#search-form-id").on("keypress", function(event) {
	if (event.keyCode == 13) {
		console.log("Search submitted");
	}
});

