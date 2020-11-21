<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<title>Beacon</title>
	<link rel="stylesheet" href="navbar.css">
	<link rel="stylesheet" href="user_posts.css">
	
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>


	<!-- Main Content -->
	<div class="content-header">
		<h1 class="thread-name">My Posts</h1>
		<div class="filters-and-button">
			<form class="form" id="filters-form-id" action="" method="GET">
				<label id="category-label-id" for="form__categories-id">Category:</label>
	            <select name="filter_category" id="form__categories-id">
	                <option value="All">All</option>
	                <option value="Fire">Fire</option>
	                <option value="Earthquake">Earthquake</option>
	                <option value="Tornado">Tornado</option>
	                <option value="Hurricane">Hurricane</option>
	            </select>

	            <label id="sort-label-id" for="form__sort-id">Sort By:</label>
	            <select name="sort_by" id="form__sort-id">
	                <option value="Newest">Newest</option>
	                <option value="Closest">Closest</option>
	                <option value="Trending">Trending</option>
	            </select>
			</form>
		</div>
	</div>

	<div class="content">
		<!-- PLACEHOLDER - Posts will be created dynamically -->
		<div class="post">
			<div class="post-username">
				Username
			</div>
			<div class="post-title">
				Post Title
			</div>
			<div class="post-comment">
				<span><i class="fas fa-comment"></i> Comments</span>
			</div>
		</div>

		<div class="post">
			<div class="post-username">
				Username
			</div>
			<div class="post-title">
				Post Title
			</div>
			<div class="post-comment">
				<span><i class="fas fa-comment"></i> Comments</span>
			</div>
		</div>

		<div class="post">
			<div class="post-username">
				Username
			</div>
			<div class="post-title">
				Post Title
			</div>
			<div class="post-comment">
				<span><i class="fas fa-comment"></i> Comments</span>
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
  	<script src="user_posts.js"></script>
	
</body>
</html>