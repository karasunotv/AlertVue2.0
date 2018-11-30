<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link rel="stylesheet" href="assets/css/main.css" />
<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
</head>
<body>
<section>

		<form:form method="post" action="loggingin" modelAttribute="user">
			<div class="row gtr-uniform" style="margin-top:8%;">
				<div class="col-6 col-12-xsmall">
						<form:input type="text" path="userName"  id="demo-name" value="" placeholder="UserName" style="
   							 margin-left: 55%;"/>
				</div>
				<br>
				<div class="col-6 col-12-xsmall">
					
					<form:input type="password" path="password" id="demo-name" value="" placeholder="Password" style="
    						margin-top: 9%; margin-left: -48%;"/>
				</div>				
				<ul class="actions">
					<li><input type="submit" value="Log In" class="primary"style=" margin-left: 550%; background-color: #328484;"/></li>
					
				</ul>
			</div>
			
		</form:form>
	</section>
	<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
</html>