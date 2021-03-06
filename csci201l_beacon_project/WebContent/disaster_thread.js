// Display modal when report button is clicked
$("#report-btn-id").on("click", function(event) {
	$(".modal-background").css("display", "flex");
});

// Close modal when background is clicked
$(".modal-background").on("click", function(event) {
	if (event.target === this) {
		$(this).css("display", "none");
		resetModal();
	}
});

// Close modal when discarded
$("#discard-btn-id").on("click", function(event) {
	$(".modal-background").css("display", "none");
	resetModal();
});


// Function for resetting modal form
function resetModal() {
	$("#post-title-input-id").val("").removeClass("is-invalid");
	$("#post-info-input-id").val("").removeClass("is-invalid");
}

// Create new thread when submitted
$("#post-form-id").on("submit", function(event) {
	var error = false;
	// Check if input is empty
	if ($("#post-title-input-id").val().trim() == "") {
		$("#post-title-input-id").addClass("is-invalid");
		error = true;
	}
	if ($("#post-info-input-id").val().trim() == "") {
		$("#post-info-input-id").addClass("is-invalid");
		error = true;
	}
	
	if (error) {
		event.preventDefault();
	}

});

// Remove warning after text is entered
$("#post-form-id").on("input", function(event) {
	if ($("#post-title-input-id").val().trim().length > 0) {
		$("#post-title-input-id").removeClass("is-invalid");
	}
	if ($("#post-info-input-id").val().trim().length > 0) {
		$("#post-info-input-id").removeClass("is-invalid");
	}
});