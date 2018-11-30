<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body>
	<header id="header" class="alt">
		<h1>
			<a href="index.html">AlertVue</a>
		</h1>

		<nav id="nav">
			<ul>
				<li class="special"><a href="#menu" class="menuToggle"><span>Menu</span></a>
					<div id="menu" style="background-color: #843232;">
						<ul>
							<li><a href="homepage">Home</a></li>
							<li><a href="history">History</a></li>
							<li><a href="elements.html">something</a></li>
							<li><a href="/">Log Out</a></li>
						</ul>
					</div></li>
			</ul>
		</nav>
	</header>

	<section id="three" class="wrapper style3 special"
		style="background-color: #2e3842;">
		<div class="inner">
			<header class="major">
				<h2>Search Result</h2>
				<p></p>
			</header>
			<ul class="features">


				<c:forEach items="${searchShowList}" var="rl">
					<li><a href="showinfo?id=${rl.showId}">
							<h3>${rl.showTitle}</h3> <span class="image fit"><img
								src="${rl.showImage}" alt="" width="200" height="283"></span>
					</a></li>
				</c:forEach>
			</ul>
		</div>
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