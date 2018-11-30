<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href="assets/css/main.css" />
<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
</head>
<body>

	<section>

		<form:form method="post" action="register" modelAttribute="user">
			<div class="row gtr-uniform" style="margin-top:8%;">
				<div class="col-6 col-12-xsmall">
						<form:input type="text" path="firstName" id="demo-name" value="" placeholder="First Name" style="
   							 margin-left: 55%;"/>
				</div>
				
				<br>
				<div class="col-6 col-12-xsmall">
					
					<form:input type="text" path="lastName" id="demo-name" value="" placeholder="Last Name" style="
    						margin-top: 9%; margin-left: -48%;" />
				</div>
				<br>
				<div class="col-6 col-12-xsmall">
					<form:input type="text" path="telephone" id="demo-age" value=""
						placeholder="Telephone" style="
   							 margin-left: 55%;" />
				</div>
				<br>
				<div class="col-6 col-12-xsmall">
					<form:input type="text" path="userName" id="demo-name" value=""
						placeholder="Username" style="
    						margin-top: 9%; margin-left: -48%;"/>
				</div>
				<br>
				<div class="col-6 col-12-xsmall">
					<form:input type="text" path="email" id="demo-email" value=""
						placeholder="Email" style="
   							 margin-left: 55%;" />
				</div>
				<br>
				<div class="col-6 col-12-xsmall">
					<form:input type="password" path="password" id="demo-name" value=""
						placeholder="Password" style="
    						margin-top: 9%; margin-left: -48%;"/>
				</div>

				<div class="col-6 col-12-small">
					<input type="checkbox" id="demo-human" name="demo-human" checked >
						<label for="demo-human" style=" margin-left: 55%;">Not a robot</label>


				<ul class="actions">
					<li><input type="submit" value="Sign up" class="primary"style=" margin-left: 490%; background-color: #328484;" /></li>
					
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