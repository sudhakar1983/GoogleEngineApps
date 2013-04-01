<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %> 
<html>
<head>
	<title>Zap Url shortener</title>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>	
		
	<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/start/jquery-ui.css" type="text/css" media="all" />		
		
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
	
	
</head>

			<style>
			.errorblock{
					color:red;
					font-size: 10px;
				}				    		    	
		    </style>

<body>
  <div class="container">
        <header class="hero-unit">
			<h1>Welcome to ZAP url shortener</h1>
			<div class="span5 offset3">
				 <h5 class="text-warning">...the place to zap your long urls.</h5>     
			</div>
        </header> 

		
		<div class="well" style="width: 80%; text-align:center;font-size: 20px; font-weight: bold;" >
			<h2>Not Authorized to view this link.</h2>
		</div>
		

		
		<div class="well" style="width: 80%; text-align:center;font-size: 20px; font-weight: bold;" >
			<h5>You can still view the link if you have valid password to access it.</h5>
			<form:form method="post" commandName="auth" >				
				<form:errors path="*" cssClass="errorblock"></form:errors>
				<label>Password</label>
				<form:input path="password" />
				
				
			    <div class="well captcha_options" id="captcha">
					<%
						ReCaptcha c = ReCaptchaFactory.newReCaptcha(
								"6LdnC98SAAAAAOuHfTMoV6odEDeI8pfirEfIwKId",
								"6LdnC98SAAAAAJ3q4yEdt3lPcM9yigZtf5B80HzQ", false);
						out.print(c.createRecaptchaHtml(null, null));
					%>		    
					
				    <div class="well" style="width:200px;margin-left:45%">
				    	<button type="submit" class="btn btn-default btn-block btn-primary">Let me through</button>
				    </div>				
			    </div>
					
			</form:form>
			
			
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
</html>