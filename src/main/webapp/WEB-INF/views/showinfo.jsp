<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${infoShows.showTitle}</title>
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<script type="text/javascript">

     
         window.onload = function(){
        initializeClock();
        function getTimeRemaining(endtime){
            var t = Date.parse(endtime) - Date.parse(new Date());
            console.log(t);
            var seconds = Math.floor( (t/1000) % 60 );
            var minutes = Math.floor( (t/1000/60) % 60 );
            var hours = Math.floor( (t/(1000*60*60)) % 24 );
            var days = Math.floor( t/(1000*60*60*24) );
            return {
                'total': t,
                'days': days,
                'hours': hours,
                'minutes': minutes,
                'seconds': seconds
            };
        }
        
        function initializeClock(){
            
            
            var deadline = '${infoShows.showAirTime} GMT-0600';
            console.log(deadline);
            var clock = document.getElementById("clockdiv");
            console.log(clock);
            function updateClock(){
                var t = getTimeRemaining(deadline);
                var daysSpan = clock.querySelector('.days');
                var hoursSpan = clock.querySelector('.hours');
                var minutesSpan = clock.querySelector('.minutes');
                var secondsSpan = clock.querySelector('.seconds');
                daysSpan.innerHTML = t.days;
                hoursSpan.innerHTML = t.hours;
                minutesSpan.innerHTML = t.minutes;
                secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);
                if(t.total<=0){
                    // Redirect if the Countdown is Over
                    //window.location.href="https://www.google.com";
                	 clockdiv.innerHTML = "The Show is already Airing at the time";
                }
        
            }
        
            updateClock(); // run function once at first to avoid delay
            var timeinterval = setInterval(updateClock,1000);
                }
        };
        
       
        </script>
  
  <style>
h7 {
        text-align: center;
        font-size: 48px;
        color: beige;
}
</style>      
</head>
<body>
	<header id="header" class="alt">
		<h1>
			<a href="index.html">Spectral</a>
		</h1>

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

	<div class="col-4">

		<span class="image fit"> <iframe width="900" height="650"
				style="margin-top: 5%; margin-left: 25%; margin-right: 25%;"
				src="${infoShows.showYoutube}" frameborder="0"
				allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen> </iframe> <!-- wrong code  <iframe src="https://www.youtube.com/watch?v=gMDy2_AUvqs" alt=""
			allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen
			style="width: 900px; hieght: 900px; margin-top: 7%; margin-left: 25%; margin-right: 25%;" >
			</iframe>-->

		</span>
	</div>

<div class="countdown-wrap" style="margin-left: 28%; color:salmon; font-size: 36px;">
        <div id="clockdiv">
            
                <span class="days"></span>
                <span class="time-label">DAYS</span>
            
                <span class="hours"></span>
                <span class="time-label">HOURS</span>
           
                <span class="minutes"></span>
                <span class="time-label">MINUTES</span>
           
                <span class="seconds"></span>
                <span class="time-label">SECS</span>
            
        </div>
    </div>
    <br><br>
	<header class="major" style="margin-left: 26%; margin-right: 29%;">
		<h7>${infoShows.showTitle}</h7>
		<p>${infoShows.showSummary}</p>
		<br> <br> <br>
		<h3>Station: ${infoShows.station}</h3>
		<Br>
		<h3>Air Time: ${infoShows.showAirTime}</h3>

	</header>

	<!-- add post and componets to this button -->
	<a href="add?id=${infoShows.showId}" class="button"
		style="margin-left: 34%;">Add</a>
	<a href="notify?id=${infoShows.showId}" class="button primary"
		style="margin-left: 2.2%; background-color: #328484;">Notify Me</a>
	<a href="remove?id=${infoShows.showId}" class="button"
		style="margin-left: 2.2%">Remove</a>


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