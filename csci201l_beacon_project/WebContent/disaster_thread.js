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
	$("#post-title-input-id").val("");
	$("#post-city-input-id").val("");
	$("#post-state-input-id").val("");
	$("#post-info-input-id").val("");
});

// Create new thread when submitted
$("#post-form-id").on("submit", function(event) {
	event.preventDefault();
	var error = false;
	// Check if input is empty
	if ($("#post-title-input-id").val().trim() == "") {
		$("#post-title-input-id").addClass("is-invalid");
		error = true;
	}
	if ($("#post-city-input-id").val().trim() == "") {
		$("#post-city-input-id").addClass("is-invalid");
		error = true;
	}
	if ($("#post-state-input-id").val().trim() == "") {
		$("#post-state-input-id").addClass("is-invalid");
		error = true;
	}
	if ($("#post-info-input-id").val().trim() == "") {
		$("#post-info-input-id").addClass("is-invalid");
		error = true;
	}
	
	if (!error) {
		console.log(event);
		console.log("New Post Submitted");
		// NEED TO IMPLEMENT
	}

});

// Remove warning after text is entered
$("#post-form-id").on("input", function(event) {
	if ($("#post-title-input-id").val().trim().length > 0) {
		$("#post-title-input-id").removeClass("is-invalid");
	}
	if ($("#post-city-input-id").val().trim().length > 0) {
		$("#post-city-input-id").removeClass("is-invalid");
	}
	if ($("#post-state-input-id").val().trim().length > 0) {
		$("#post-state-input-id").removeClass("is-invalid");
	}
	if ($("#post-info-input-id").val().trim().length > 0) {
		$("#post-info-input-id").removeClass("is-invalid");
	}
});