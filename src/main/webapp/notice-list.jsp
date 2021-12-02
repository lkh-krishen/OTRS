<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Online Train Reservation System</title>
	
	<!--------------------------- Adding Bootstrap via hyperlink --------------------------->
	
	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		  crossorigin="anonymous">
		  
	<!--------------------------------------------------------------------------------------->
		  
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #dc3545">
		<div>
			<a href="#" class="navbar-brand">Sign out</a>
		</div>
			<ul class="navbar-nav">
			
			<!-----request. getContextPath() is used to returns the context portion of given URI and it 
			is used to get the path of the requested servlet.----------------------------------------->
			
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Notices</a></li>
				
			<!---------------------------------------------------------------------------------------->
				
			</ul>
		</nav>
	</header> 
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Notices</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-primary">Add New Notice</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Priority</th>
						<th>Title</th>
						<th>Description</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<!--For each loop to loop through each notice object and display attributes-->
				
					<c:forEach var="notice" items="${listNotice}">
						<tr>
							<td><c:out value="${notice.id}"/></td>
							<td><c:out value="${notice.priority}"/></td>
							<td><c:out value="${notice.title}"/></td>
							<td><c:out value="${notice.description}"/></td>
							<td><c:out value="${notice.email}"/></td>
							<td>
							<a href="edit?id=<c:out value='${notice.id}'/>">Edit</a> 
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="delete?id=<c:out value='${notice.id}'/>">Delete</a>
							</td>
						</tr>
					</c:forEach>
					
					<!----------------------------------------------------------------------------->
					
				</tbody>
			</table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
			crossorigin="anonymous">
	</script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" 
    		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" 
    		crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" 
    		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" 
    		crossorigin="anonymous">
    </script>
</body>
</html>
