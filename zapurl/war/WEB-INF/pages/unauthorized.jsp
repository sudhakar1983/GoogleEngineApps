<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<link href='<c:url value="../css/trimurl.css"></c:url>'  rel="stylesheet" />
	
	<script type="text/javascript">
	$(document).ready(function() {

		$('#submitZap').click(function(){								
				var value = $('#recaptcha_response_field').val();
				$('#cap_hidden').val(value);
				console.log($('#cap_hidden').val());	
				$(this).closest('form').submit();
			}
		);		
	
	});	
	</script>
	
</head>
	
		

<style>				
.captcha{
	float:center;
	width:60%;
	margin-left: 300px;
}			    		    	
</style>

<body>
<div id="wrap">
  <div class="container">
  		<a href='<c:url value="../zap"></c:url>'  style="text-decoration: none;">
        <header class="hero-unit">
			<h1>TrimUrl</h1>
			<div class="span5 offset1">
				 <h5 class="text-warning">...the place to shorten your long urls.</h5>     
			</div>
        </header>  
		</a>

		<c:if test="${not empty zaperror.errors }">
		<div class="well" style="width: 80%; text-align:center;font-size: 20px; font-weight: bold;" >
				<c:forEach items="${zaperror.errors}" var="err">
					<p class="text-info">${err.value}</p>
					<!-- <h4 class="text-info">This is bad ..Something terrible happened...</h4> -->
				</c:forEach>
		</div>
		</c:if>
	
<c:set var="contains" value="false" />
<c:forEach items="${zaperror.errors}" var="err">
<c:if test="${err.code =='zap.link.expired'}">
    <c:set var="contains" value="true" />
  </c:if>	
</c:forEach>		
<c:if test="${!contains}">

		
		<div class="well" style="width: 80%; text-align:center;font-size: 20px; font-weight: bold;" >
			<h5>
				<p class="text-info">
					You can still view the link if you have valid password to access it.
				</p>
			</h5>
			<form:form method="post" commandName="auth" >
				<label>Password</label>				
				<form:password path="password"/>
				<br/>
				<form:errors path="password" cssClass="text-error"></form:errors>
				
				
			    <div class="well captcha_options" id="captcha" style="display: block;">
			    <form:hidden path="captcha"  id="cap_hidden"/>
			    	<div class="captcha">
					<%
						ReCaptcha c = ReCaptchaFactory.newReCaptcha(
								"6LdnC98SAAAAAOuHfTMoV6odEDeI8pfirEfIwKId",
								"6LdnC98SAAAAAJ3q4yEdt3lPcM9yigZtf5B80HzQ", false);
						out.print(c.createRecaptchaHtml(null, null));
					%>
					</div>
					<form:errors path="captcha" cssClass="text-error"></form:errors>
					<br/>
					<br/>
				    <div id="submitZap"  class="btn btn-default  btn-primary">Let me through</div>				    				
			    </div>
			</form:form>
		</div>		
</c:if>		
</div>


  	
		

    <footer>
      <div class="container" style="margin-top: 50px;">
        <p>Developed & Maintained by <a href="http://www.sudhakarduraiswamy.in/" rel="author">Sudhakar Duraiswamy</a>.
        <br> 
         Built using <a href="http://www.springsource.org/"> Spring </a>,<a href="http://www.jquery.com/"> Jquery </a> and <a href="http://twitter.github.com/bootstrap"> Bootstrap </a> and powered by <a href="appengine.google.com">Google Apps Engine</a>.</p>
      </div>
    </footer>		
		
  </div>
</body>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-39831824-2']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</html>