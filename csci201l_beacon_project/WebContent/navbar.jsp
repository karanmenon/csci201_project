<!-- Navbar -->
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Beacon</a>
		<form class="form form-inline" id="search-form-id" action="" method="GET">
  			<input name="search_title" class="form-control" type="text" id="searchbar-id" placeholder="Search">
  		</form>
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

			<!-- Display on click when user is logged-out -->
			<div class="user__user-dropdown user__user-dropdown--logged-out">
				<button type="button" class="btn user-dropdown__btn" id="logout-btn-id">
					<i class="fas fa-sign-in-alt"></i>
					Login
				</button>
			</div>

		</div>		
	</nav>