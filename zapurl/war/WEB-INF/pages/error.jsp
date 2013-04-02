<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
 <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
 
<html>
<head>
	<title>TrimUrl shortener</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>	
		
	<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/start/jquery-ui.css" type="text/css" media="all" />		
		
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
	
	
</head>


<body>
  <div class="container">
        <header class="hero-unit">
			<h1>Welcome to ZAP url shortener</h1>
			<div class="span5 offset3">
				 <h5 class="text-warning">...the place to zap your long urls.</h5>     
			</div>
        </header> 
        <c:if test="${empty zaperror }">
        	<h4 class="text-info">This is bad ..Something terrible happened...</h4>
        </c:if>
		
		<div class="well" style="width: 80%; text-align:center;font-size: 20px; font-weight: bold;" >
			<c:if test="${not empty zaperror}">			
				<c:forEach items="${zaperror.errors}" var="err">
					<p class="text-info">${err.value}</p>
				</c:forEach>
			</c:if>		
		</div>
				



  	
		

    <footer>
      <div class="container" style="margin-top: 50px;">
        <p>Developed & Maintained by <a href="http://www.sudhakar.duraiswamy.in/" rel="author">Sudhakar Duraiswamy</a>.
        <br> 
         Built using <a href="http://www.springsource.org/"> Spring </a>,<a href="http://www.jquery.com/"> Jquery </a> and <a href="http://twitter.github.com/bootstrap"> Bootstrap </a> and powered by <a href="appengine.google.com">Google Apps Engine</a>.</p>
      </div>
    </footer>		
		
  </div>
</body>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-39788980-1', 'minifyururl.appspot.com');
  ga('send', 'pageview');

</script>
</html>