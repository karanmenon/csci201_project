<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ page import="ClassStructure.DatabaseDriver" %>
<%@ page import="ClassStructure.SubBeacon" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<title>Beacon</title>
	<link rel="stylesheet" href="navbar.css">
	<link rel="stylesheet" href="homepage.css">
	
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<% 
		DatabaseDriver driver = new DatabaseDriver();
		ArrayList<SubBeacon> subBeacons = driver.getSubBeacons();
	%>
	
	

	<!-- Main Content -->
	<div class="content-header">
		<form class="form" id="filters-form-id" action="" method="GET">
			<label id="category-label-id" for="form__categories-id">Category:</label>
            <select name="filter_category" id="form__categories-id">
                <option value="All">All</option>
                <option value="Fire">Fire</option>
                <option value="Earthquake">Earthquake</option>
                <option value="Tornado">Tornado</option>
                <option value="Hurricane">Hurricane</option>
            </select>
		</form>
		<button type="button" id="report-btn-id" class="btn btn-danger">Report</button>
	</div>

	<div class="content">
		<!-- PLACEHOLDER - Threads will be created dynamically -->
		<!--  
		<div class="thread">
			<div class="thread-tag">
				Category
			</div>
			<div class="thread-name">
				Name of Disaster Thread
			</div>
		</div>

		<div class="thread">
			<div class="thread-tag">
				Category
			</div>
			<div class="thread-name">
				Name of Disaster Thread
			</div>
		</div>

		<div class="thread">
			<div class="thread-tag">
				Category
			</div>
			<div class="thread-name">
				Name of Disaster Thread
			</div>
		</div>
		-->
	<% for (int i=0; i<subBeacons.size(); i++) { %> 
		<div class="thread <%= subBeacons.get(i).get_tag() %>">
			<div class="thread-tag">
				<%= subBeacons.get(i).get_tag() %>
			</div>
			<div class="thread-name">
				<%= subBeacons.get(i).get_disaster() %>
			</div>
		</div>
	<% } %> 
	

	</div>

	<!-- Modal -->
	<div class="modal-background">
		
		<!-- Modal content -->
		
		<div class="modal-content">
			<div id="modal-content__header">Create New Disaster Thread</div>
			<form id="thread-form-id" action="SubBeaconRequest" method="POST">
				<input name="modal_title" class="form-control" type="text" id="thread-input-id" placeholder="Thread Title">
				<div>
					<label id="category-label-id" for="form__categories-id">Category:</label>
					<select name="modal_category" id="new-thread-categories">
						<option class="categories__default" value="" selected disabled>-- Select--</option>
		                <option value="Fire">Fire</option>
		                <option value="Earthquake">Earthquake</option>
		                <option value="Tornado">Tornado</option>
		                <option value="Hurricane">Hurricane</option>
		            </select>
	            </div>
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
  	<script src="homepage.js"></script>
	
</body>
</html>