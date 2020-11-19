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
	$("#thread-input-id").removeClass("is-invalid");
	$("#new-thread-categories option[value='']").prop("selected", true);
	$("#new-thread-categories").css("border", "1px solid black");
});

// Create new thread when submitted
$("#thread-form-id").on("submit", function(event) {
	
	var error = false;
	// Check if input is empty
	if ($("#thread-input-id").val().trim() == "") {
		$("#thread-input-id").addClass("is-invalid");
		error = true;
	}
	
	var optionSelected = $("option:selected", this);
	if (optionSelected.val() == "") {
		error = true;
		$("#new-thread-categories").css("border", "1px solid red");
	}

	if (error) {
		event.preventDefault();
	}

});

// Remove warning after text is entered
$("#thread-input-id").on("input", function(event) {
	if ($("#thread-input-id").val().trim().length > 0) {
		$("#thread-input-id").removeClass("is-invalid");
	}
});

// Change selected on click
$(document).on("change", "#new-thread-categories", function(event) {
var optionSelected = $("option:selected", this);
	$("#new-thread-categories").css("border", "1px solid black");
});