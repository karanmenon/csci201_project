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
	$("#thread-input-id").val("");
	$("#thread-input-id").removeClass("is-invalid");
	$("#new-thread-categories option[value='']").prop("selected", true);
	$("#new-thread-categories").css("border", "1px solid black");
}

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

// Change selected of modal
$(document).on("change", "#new-thread-categories", function(event) {
	var optionSelected = $("option:selected", this);
	// $("#new-thread-categories").css("border", "1px solid black");
});

// Change selected of filter 
$(document).on("change", "#form__categories-id", function(event) {
	$(".thread").css("display", "none");
	var optionSelected = $("option:selected", this);
	// var selector = "'." + optionSelected.val() + "'";
	// console.log(selector);
	// $(".content").find(".Fire").css("display", "flex");
	if (optionSelected.val() == "All") {
		$(".thread").css("display", "flex");
	} else {	
		$(".content").find("." + optionSelected.val()).css("display", "flex");
		console.log(optionSelected.val());
	}
});

// Clicking thread links to thread page
$(".content").on("click", ".thread", function(event) {
	// console.log($(event.target).closest(".thread").find(".thread-name").html().trim());
	var threadName = $(event.target).closest(".thread").find(".thread-name").html().trim();
	window.location.href = "disaster_thread.jsp?thread_name=" + threadName;
});