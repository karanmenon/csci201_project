// Display modal when report button is clicked
$("#report-btn-id").on("click", function(event) {
	$(".modal-background").css("display", "flex");
});

// Close modal when background is clicked
$(".modal-background").on("click", function(event) {
	if (event.target === this) {
		$(this).css("display", "none");
		$("#thread-input-id").val("");
	}
});

// Close modal when discarded
$("#discard-btn-id").on("click", function(event) {
	$(".modal-background").css("display", "none");
	$("#thread-input-id").val("");
});

// Create new thread when submitted
$("#thread-form-id").on("submit", function(event) {
	event.preventDefault();
	var error = false;
	// Check if input is empty
	if ($("#thread-input-id").val().trim() == "") {
		$("#thread-input-id").addClass("is-invalid");
		error = true;
	}
	/* 
	// NEED TO FIX -- add function so that clicked dropdown becomes selected
	// Check is selection is made 
	if ($("#form__categories-id").find(".selected").text() == "") {
		error = true;
		console.log("none selected");
		// NEED TO FIX -- add error box when none are selected
	}
	*/

	if (!error) {
		console.log(event);
		console.log("New Thread Submitted");
		// NEED TO IMPLEMENT
	}
});

// Remove warning after text is entered
$("#thread-input-id").on("input", function(event) {
	if ($("#thread-input-id").val().trim().length > 0) {
		$("#thread-input-id").removeClass("is-invalid");
	}
});