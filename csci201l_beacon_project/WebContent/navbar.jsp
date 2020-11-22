<!-- Navbar -->
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Beacon</a>
		<div class="user">
			<i class="fas fa-user"></i>
			<i class="fas fa-caret-down"></i>
			<% Cookie[] cookies = request.getCookies();
			boolean loggedIn = false;
			Cookie loginCookie = null;
			for(int i = 0; i < cookies.length; i++)
			{
				Cookie cookie = cookies[i];
	            if(cookies[i].getName().equals("username"))
	            {
	            	loggedIn = true;
	            	loginCookie = cookies[i];
	            }
			}
			if(loggedIn){%>
			<!-- Display on click when user is logged-in -->
			<div class="user__user-dropdown">
				<!-- PLACEHOLDER - Retrieve username dynamically -->
				<div class="user-dropdown__username" id="username-id"><%= loginCookie.getValue() %></div>
				<button type="button" class="btn user-dropdown__btn" onclick="document.location='user_posts.jsp'"  id="my-posts-btn-id">My Posts</button>
				<form action = "LogOutRequest" method = "GET">
					<button type="submit" class="btn user-dropdown__btn" id="logout-btn-id">
						<i class="fas fa-sign-out-alt"></i>
						Logout
					</button>
				</form>
			</div>
			<%}else{ %>
			<!-- Display on click when user is logged-out -->
			<div class="user__user-dropdown">
				<button type="button" class="btn user-dropdown__btn" onclick="document.location='login.jsp'" id="login-btn-id">
					<i class="fas fa-sign-in-alt"></i>
					Login
				</button>
			</div>
			<%} %>
		</div>		
	</nav>