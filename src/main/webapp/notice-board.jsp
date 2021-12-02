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
<body class="bg-danger">
	<header>
	
		<!------------------------------------------------------Navigation Bar--------------------------------------------------------->
	
		<nav class="navbar navbar-expand-md navbar-light bg-white fixed-top font-weight-bold mx-auto ">
        	<a href="" class="navbar-brand mx-auto"><h4 style="font-weight: 800; font-style: italic; color: #b33c00">SRI LANKA RAILWAY</h4><!-- <img class="mx-5" src="image/Capture.PNG">--></a>
        	<button class="navbar-toggler" data-toggle="collapse" data-target="#ccsl"><span class="navbar-toggler-icon"></span></button>
        	<div class="collapse navbar-collapse justify-content-center" id="ccsl">
            	<ul class="navbar-nav">
                	<li class="nav-item active mx-3"><a href="#" class="nav-link">Home</a></li>
                	<li class="nav-item mx-3"><a href="#" class="nav-link">Trains</a></li>
                	
                	<!-----request. getContextPath() is used to returns the context portion of given URI and it 
				    is used to get the path of the requested servlet.----------------------------------------->
                	
                	<li class="nav-item mx-3"><a href="<%=request.getContextPath()%>/display" class="nav-link">Notices</a></li>
                	
                	<!---------------------------------------------------------------------------------------->
                	
                	<li class="nav-item mx-3"><a href="#" class="nav-link">Guide</a></li>
                	<li class="nav-item mx-3"><a href="#" class="nav-link">Contact Us</a></li>
                	<li class="nav-item mx-3 "><a href="#" class="nav-link text-danger">MyBookings</a></li>
            	</ul>
            </div>   
    	</nav>
    	
    	<!----------------------------------------------------------------------------------------------------------------------------->
    	
    </header>
	<br>
	<br>
	<br>
	<div class="row">
		<div class="container" style="background-color: #ffffff">
			<hr>
			<h3 class="text-center">Notices</h3>
			<hr>
			<div class="container text-left">
			
				<!-----request. getContextPath() is used to returns the context portion of given URI and it 
				is used to get the path of the requested servlet.----------------------------------------->
			
				<!-- <a href="<%=request.getContextPath()%>/display" class="btn btn-primary">Display Notices</a> -->
				
				<!---------------------------------------------------------------------------------------->
				
				<!-- <br>
				<br> -->
				<p class="text-info">*Priority ranges from 1(highest)-5(lowest)</p> 
			</div>
			<hr>
			
			<!---------------For-each loop to loop through each notice object and display attributes------------------>
			
			<c:forEach var="notice" items="${displayNotice}">
				<div class="container">
					<h5>
						Priority: <c:out value="${notice.priority}"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Title: <c:out value="${notice.title}"/>
					</h5>
					<br>
					<h6>
						Description: <c:out value="${notice.description}"/>
					</h6>
					<br>
					<h6>
						Email for Queries: <c:out value="${notice.email}"/>
					</h6>
				</div>
				<hr>
			</c:forEach>
			
			<!---------------------------------------------------------------------------------------------------------->
			
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
