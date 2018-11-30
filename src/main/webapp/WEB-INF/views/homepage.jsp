<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
   
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body style="margin-left: 20%; margin-right: 20%;" class="landing">
	<header id="header" class="alt">
		<h1>
			<a href="index.html">AlertVue</a>
		</h1>

		<form method="get" action="searchShows">
			<div class="row gtr-uniform">
				<div class="col-6 col-12-xsmall">
					<input type="text" class="form-control" placeholder="Search"
						style="width: 984.6666px; margin-left: 40.5%;" name="word"/>
				</div>
				<div class="col-6 col-12-xsmall">
				
					<input type="submit" class="button primary small" style="margin-left: 43%; height: 55px; background-color: #328484;">
					<!-- <a href="homepage" class="button primary small"
						style="margin-left: 43%; height: 55px; background-color: #328484;">Search</a> -->
				</div>
			</div>
		</form>

		<nav id="nav">
			<ul>
				<li class="special"><a href="#menu" class="menuToggle"><span>Menu</span></a>
					<div id="menu" style="background-color: #843232;">
						<ul>
							<li><a href="homepage">Home</a></li>
							<li><a href="history">History</a></li>
							<li><a href="elements.html">something</a></li>
							<li><a href="logout">Log Out</a></li>
						</ul>
					</div></li>
			</ul>
		</nav>
	</header>
	<div class="box alt" style="margin-top: 15%; text-align: center;">
		Tracked Shows
		<div class="row gtr-50 gtr-uniform">
			<c:forEach items="${trackedList}" var="tl">
			<div class="col-4" style="text-align: center;">
				<a href="showinfo?id=${tl.showId}"> <span class="image fit"><img
						src="${tl.showImage}" alt="" width="200" height="283"></span> ${tl.showTitle}
				</a>
			</div>
			</c:forEach>
		</div>
	</div>

	<div class="box alt" style="margin-top: 15%; text-align: center;">
		Recommend Shows
		<div class="row gtr-50 gtr-uniform">
			
			<c:forEach items="${recommedList}" var="rl">
				<div class="col-4" style="text-align: center;">
				<a href="showinfo?id=${rl.showId}"> <span class="image fit"><img
						src="${rl.showImage}" alt="" width="200" height="283" ></span>${r1.showTitle}</a>
			</div>
			</c:forEach>
		

		</div>
	</div>
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