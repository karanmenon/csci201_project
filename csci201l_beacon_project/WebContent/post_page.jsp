<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ page import="ClassStructure.DatabaseDriver" %>
<%@ page import="ClassStructure.Comment" %>
<%@ page import="ClassStructure.SubBeacon" %>
<%@ page import="ClassStructure.BeaconSignal" %>
<%@ page import="java.util.ArrayList" %>

<%
	BeaconSignal post = null;
	DatabaseDriver driver = new DatabaseDriver();
	int postID = -1;
	if(request.getParameter("post_id") != null)
	{
		postID = Integer.parseInt(request.getParameter("post_id"));
		post = driver.getBeaconSignal(postID);
	}
	else if (request.getAttribute("BeaconSignal") != null){
		post = (BeaconSignal) request.getAttribute("BeaconSignal");
		postID = post.get_postId();
	}
%>

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
	<% if(post != null) {%>
	<div class="post">
		<div class="post-username">Posted by: <%= driver.getUsernameFromId(post.get_userId()) %></div>
		<div class="post-title"><%= post.get_postTitle() %></div>
		<div class="post-info"><%= post.get_postBody() %></div>
		<%
		Cookie[] cookies = request.getCookies();
			boolean loggedIn = false;
			Cookie loginCookie = null;
			for(int i = 0; cookies != null && i < cookies.length; i++)
			{
				Cookie cookie = cookies[i];
	            if(cookies[i].getName().equals("username"))
	            {
	            	loggedIn = true;
	            	loginCookie = cookies[i];
	            }
			}
			if(loggedIn)
			{%>
		<form action="CommentRequest" method="POST" id="comment-form-id">
			<input name="comment_text" id="comment-input-id" placeholder="Comment">
			<input type="hidden" name="post_title" value=<%= post.get_postTitle() %>>
			<input type="hidden" name="username" value="<%= loginCookie.getValue()%>">
		</form>
		<%} %>
		<div class="comments">
			<% ArrayList<Comment> comments = post.get_comments();
			for(int i = 0; comments != null && i < comments.size(); i++)
			{%>
			<div class="comment-block">
				<span class="comment-username"><%= comments.get(i).get_author() %></span>
				<span class="comment"><%= comments.get(i).get_body() %></span>
			</div>
			<%} %>
		</div>
	<% } %>
	</div>
	<!-- PLACEHOLDER - content will be dynamically created -->
	<!-- <div class="post">
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
	</div> -->
		
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