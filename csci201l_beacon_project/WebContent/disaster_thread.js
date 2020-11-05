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
$("#submit-btn-id").on("click", function(event) {
	console.log(event);
	// NEED TO IMPLEMENT
});