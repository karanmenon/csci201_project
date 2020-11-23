<%@ page import="java.io.*,java.util.*, javax.servlet.*, Servlets.MyPostsRequest, ClassStructure.BeaconSignal, ClassStructure.DatabaseDriver" %>
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
	</div>

	<%  Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		for(int i = 0; i < cookies.length; i++)
		{
			Cookie cookie = cookies[i];
            if(cookies[i].getName().equals("username"))
            {
            	loginCookie = cookies[i];
            }
		}
		
		String username = loginCookie.getValue();
		
		MyPostsRequest m = new MyPostsRequest();
		ArrayList<BeaconSignal> posts = m.getPosts(username);
	%>
	
	
	<div class="content">
	<% DatabaseDriver db = new DatabaseDriver();
	if(posts != null)
	{
	for(int i = 0; i < posts.size(); i++)
		{%>
		<!-- PLACEHOLDER - Posts will be created dynamically -->
		<div class="post" onclick = "location.href = './post_page.jsp?post_id=<%= posts.get(i).get_postId() %>';">
			<div class="post-username">
				<%= db.getUsernameFromId(posts.get(i).get_userId()) %>
			</div>
			<div class="post-title">
				<%= posts.get(i).get_postTitle() %>
			</div>
			<div class="post-comment">
				<span><i class="fas fa-comment"></i> Comments</span>
			</div>
		</div>
		<% }}
	else out.println("No user posts found. Go make one!");%>


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