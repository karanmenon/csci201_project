<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<title>Beacon</title>
	<link rel="stylesheet" href="navbar.css">
	<link rel="stylesheet" href="post_page.css">
	
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<!-- Post Display -->
	<!-- PLACEHOLDER - content will be dynamically created -->
	<div class="post">
		<div class="post-username">Posted by: Username</div>
		<div class="post-title">Title</div>
		<div class="post-info">Info Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info InfoInfo Info Info</div>
		<form action="CommentRequest" method="POST" id="comment-form-id">
			<input name="comment_text" id="comment-input-id" placeholder="Comment">
		</form>
		<div class="comments">
			<div class="comment-block">
				<span class="comment-username">Username</span>
				<span class="comment">Comment comment comment comment</span>
			</div>
			<div class="comment-block">
				<span class="comment-username">Username</span>
				<span class="comment">Comment comment comment comment</span>
			</div>
			<div class="comment-block">
				<span class="comment-username">Username</span>
				<span class="comment">Comment comment comment comment</span>
			</div>
		</div>
	</div>
		
	<!-- Import Font Awesome library -->
	<script src="https://kit.fontawesome.com/e558bbfafc.js" crossorigin="anonymous"></script>

	<!-- Import jquery library -->
	<script
		src="http://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous">
  	</script>

  	<script src="navbar.js"></script>
  	<script src="post_page.js"></script>
	
</body>
</html>