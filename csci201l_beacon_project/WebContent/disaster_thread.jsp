<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ page import="ClassStructure.DatabaseDriver" %>
<%@ page import="ClassStructure.SubBeacon" %>
<%@ page import="ClassStructure.BeaconSignal" %>
<%@ page import="java.util.ArrayList" %>

<%
	String threadName = request.getParameter("thread_name");
	DatabaseDriver driver = new DatabaseDriver();
	SubBeacon thread = driver.getSubBeacon(threadName);
	ArrayList<BeaconSignal> posts = null;
	if(thread != null)
	{
	posts = thread.get_beaconSignals();
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
	<link rel="stylesheet" href="disaster_thread.css">
	
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<!-- Main Content -->
	<div class="content-header">
		<!-- PLACEHOLDER - Retrieve name of disaster thread dynamically -->
		<div class="filters-and-button">
			<h1 class="thread-name"><%= threadName %></h1>
			<button type="button" id="report-btn-id" class="btn btn-danger">Create a Post</button>
		</div>
	</div>

	<div class="content">
		<!-- PLACEHOLDER - Posts will be created dynamically -->
		<!-- 
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
		 -->
 	<% for (int i=0; posts != null && i<posts.size(); i++) { %>
		<div class="post" onclick = "location.href = './post_page.jsp?post_id=<%= posts.get(i).get_postId() %>';">
			<div class="post-username">
				<%= posts.get(i).get_userId() %>
			</div>
			<div class="post-title">
				<%= posts.get(i).get_postTitle() %>
			</div>
			<div class="post-comment">
				<span><i class="fas fa-comment"></i> Comments</span>
			</div>
		</div>
	<% } 
		if(posts == null)
		{%>
			No posts found. Go make some!
		<%}%>
	
	</div>

	<!-- Modal -->
	<div class="modal-background">
		
		<!-- Modal content -->
		
		<div class="modal-content">
			<div id="modal-content__header">Create New Post</div>
			<form id="post-form-id" action="BeaconSignalRequest" method="POST">
				<input type="hidden" name="disaster_title" value="<%=threadName%>">
				<input name="modal_title" class="form-control" type="text" id="post-title-input-id" placeholder="Title/Description">
				<textarea name="modal_info" class="form-control" id="post-info-input-id" placeholder="Info"></textarea>
				<!-- <div id="post-img-upload">
					<label for="img">Upload image:</label>
	  				<input type="file" id="post-img-input-id" name="img" accept="image/*">
	  			</div> -->
	            <div class="modal-content__buttons">
	            	<button type="submit" id="submit-btn-id" class="btn btn-primary">Submit</button>
	            	<button type="button" id="discard-btn-id" class="btn btn-secondary">Discard</button>
	            </div>    
	        </form>  
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
  	<script src="disaster_thread.js"></script>
	
</body>
</html>