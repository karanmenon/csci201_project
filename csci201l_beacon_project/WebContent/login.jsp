<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<title>Beacon</title>
	<link rel="stylesheet" href="navbar.css">
	
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Beacon</a>
		<div class="user">
			<i class="fas fa-user"></i>
			<i class="fas fa-caret-down"></i>

			<!-- Display on click when user is logged-in -->
			<div class="user__user-dropdown user__user-dropdown--logged-in">
				<!-- PLACEHOLDER - Retrieve username dynamically -->
				<div class="user-dropdown__username" id="username-id">Username</div>
				<button type="button" class="btn user-dropdown__btn" id="my-posts-btn-id">My Posts</button>
				<button type="button" class="btn user-dropdown__btn" id="logout-btn-id">
					<i class="fas fa-sign-out-alt"></i>
					Logout
				</button>
			</div>
			<!-- How to make only this part display and guarantee users can't reach this page if already signed up? -->
			<!-- Display on click when user is logged-out -->
			<div class="user__user-dropdown user__user-dropdown--logged-out">
				<button type="button" class="btn user-dropdown__btn" id="logout-btn-id">
					<i class="fas fa-sign-in-alt"></i>
					Login
				</button>
			</div>
	</nav>


	<!-- Main Content -->
	
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="h1 mt-5 mb-5">Log in</div>
			</div>
		</div>
		<form class="row mb-4">
			<div class="col-12 text-danger mb-3">
			</div>
			<div class="form-group col-12">
				<div class="row mb-3">
					<label for="username" class="col col-12 col-md-2 col-lg-1 mb-2">Username:</label>
					<div class="col col-12 col-md-4 col-lg-2">
						<input type="text" class="form-control" id="username" name="username" required>
					</div>
				</div>
				<div class="row">
					<label for="password" class="col col-12 col-md-2 col-lg-1 mb-2">Password:</label>
					<div class="col col-12 col-md-4 col-lg-2">
						<input type="password" class="form-control" id="password" name="password" required>
					</div>
				</div>
			</div>
			<div class="col-12 mb-3">
				<button type="submit" class="btn btn-primary">Log in</button>
			</div>
		</form>
		</form>
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
  	<script src="homepage.js"></script>
	
</body>
</html>