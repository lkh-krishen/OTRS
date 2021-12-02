<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Online Train Reservation System</title>
	<link rel="stylesheet"
	  	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	  	  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	  	  crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #dc3545">
			<div>
				<a href="#" class="navbar-brand">Sign out</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Notices</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${notice != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${notice == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${notice != null}">
            			Edit Notice
            		</c:if>
						<c:if test="${notice == null}">
            			Add New Notice
            		</c:if>
					</h2>
				</caption>
				<c:if test="${notice != null}">
					<input type="hidden" name="id" value="<c:out value='${notice.id}'/>"/>
				</c:if>
				<fieldset class="form-group">
					<label>Notice Priority (Must be a number between 1 and 5)</label> 
					<input type="number" min="1" max="5" required value="<c:out value='${notice.priority}'/>" class="form-control" name="priority" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Notice Title (Must be between 1 and 100 letters and/or numbers only)</label> 
					<input type="text" pattern = "[a-zA-Z0-9 ]{1,100}" required value="<c:out value='${notice.title}'/>" class="form-control" name="title">
				</fieldset>
				<fieldset class="form-group">
					<label>Notice Description (May be between 0 and 300 characters)</label> 
					<textarea maxlength = "300" class="form-control" name="description"><c:out value='${notice.description}'/></textarea>
				</fieldset>
				<fieldset class="form-group">
					<label>Email for Queries (Ex: traininfo@slrailways.gov.lk)</label> 
					<input type="email" pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" value="<c:out value='${notice.email}'/>" class="form-control" name="email">
				</fieldset>
				<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
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
