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
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>	
		
	<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/themes/start/jquery-ui.css" type="text/css" media="all" />		
	 
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
	
	<script>
	$(function() {

		$(window).load(function() {
			$('#submitZap').click(function(){								
				var value = $('#recaptcha_response_field').val();
				$('#cap_hidden').val(value);


				var urlFormat ="^(www\.)?(?!www)[a-zA-Z0-9]+\.[a-zA-Z]{2,6}/?[a-zA-Z0-9/\._\-]+$";
				
				var formValid = true;

				var url =$('#url').val(); 
				console.log('url :'+ url.length);
				if( url.match(urlFormat) &&  url.length > 0 ) {					
					formValid = true;					
					$('#url').css('background-color','#ffffff');
				}else{
					$('#url').css('background-color','#FF1919');
					formValid = false;					
				}

				var pwd = $('#password').val();
				console.log('pwd :'+ pwd);
				if($('#secure1').is(':checked') && pwd.length < 4){
					formValid = false;	
					$('#password').css('background-color','#FF1919');
					$('#advanceoptions').show();				
				}else{
					formValid = true;	
					$('#password').css('background-color','#ffffff');
				}

				
				if(formValid){
					console.log('submitting')
					$(this).closest('form').submit();
					}
				
			}
		);
			
			});		

		$('#url').focus(function (){
				$('#captcha').show('slow');
			}
		);
		
		$( "#datepicker" ).datepicker({
			inline: true
		});	


		$("#advanceOptionlink").click(function(){
				var advancedDiv = 	$('#advanceoptions');			
				advancedDiv.fadeToggle();
			}
		);

		$('#url').tooltip({'trigger':'focus', 'title': 'Enter url in the format www.example.com','placement':'bottom'});
		$('#password').tooltip({'trigger':'focus', 'title': 'Password should be atleast 4 characters','placement':'bottom'});


	});

	</script>
	
<style>
	.captcha_options{
		display:none;
	}
	.advance_options{
		display:none;
	}	
	.makemelink{
		color:#005580;
		text-decoration:underline;
		cursor: hand;
		cursor: pointer; 
	}				
	input[type="text"],input[type="password"] { 
	    height:50px;
	    color:black;
	    font-weight: 900px;
	    font-size: 20px;
	}	
	.text-error{
		color:red;
	}
					
	html,
	body {
	    height: 100%;
	}
	 
	#wrap  {
	    min-height: 100%;
	    height: auto !important;
	    height: 100%;
	    margin: 0 auto -60px;
	}
	
	.hero-unit {
		background-color :#ffffff;
	}
	
	.well{
		background-color :#D6EBFF;
	}				
	
	#advanceoptions{
		background-color :#FFCC99;
	}   
	.text-warning{
		color :#FF6600;
	}
</style>		    
		    	
	
</head>


<body>
<div id="wrap">
			  <div class="container">
			        <header class="hero-unit">
						<h1>TrimUrl</h1>
						<div class="span5 offset1">
							 <h5 class="text-warning">...the place to shorten your long urls.</h5>     
						</div>
			        </header>  
			
			
			<c:if test="">
			
			</c:if>
			
			<c:choose>
				<c:when test="${not empty success && success}">
					The URL <br/>
					<h4><a href="${zapurl.url}" >${zapurl.url}</a></h4>
					
					is transformed to 
					
					<h2><a href="${APP_URL}${zapurl.zappedUrl}" >${APP_URL}${zapurl.zappedUrl}</a></h2>
				</c:when>
					
				<c:otherwise>
			<form:form method="post"  name="zapform" modelAttribute="zapurl">
			
					  
					    <div class="well" id="main">
						    <form:label path="url"><strong>Paste your long  URL here</strong></form:label>		    
						    <form:input path="url"  style="width: 100%;" maxlength="1000" id="url" placeholder="www.example.com"/>	
						    <form:errors path="url" cssClass="text-error"></form:errors>
						    
							<div class="captcha_options" id="captcha"		
							
									<form:errors path="captcha" cssClass="text-error">
										style="display:block;"
									</form:errors>    
									>
									
									
										<form:hidden path="captcha"  id="cap_hidden"/>
									
									<%
									ReCaptcha c = ReCaptchaFactory.newReCaptcha(
											"6LdnC98SAAAAAOuHfTMoV6odEDeI8pfirEfIwKId",
											"6LdnC98SAAAAAJ3q4yEdt3lPcM9yigZtf5B80HzQ", false);
									out.print(c.createRecaptchaHtml(null, null));
									%>		    
									<form:errors path="captcha" cssClass="text-error"></form:errors>
									
									<div class="well" style="width:200px;margin-left:45%">
									 	<div id="submitZap"  class="btn btn-default btn-block btn-primary">Trim</div>
									 </div>				
							</div>						        
					    </div>
					    
					 
	
						<div id="advanceOptionlink" class="makemelink">
							<i class="icon-plus"></i>Show Advance Option
						</div>			
						
						
						<div class="well advance_options" id="advanceoptions"
						<form:errors path="password" cssClass="text-error">
							style="display:block;"
						</form:errors>      
						>
						    <label class="checkbox">
						      <form:checkbox path="secure"></form:checkbox>Make it Password Protected
						    </label>	
						    
						    <label>Password</label>
						    <form:password path="password" style="width: 185px;" maxlength="30"  id="password" />
						     <form:errors path="password" cssClass="text-error"></form:errors>    
						    
						    
						    
						    <label>This link will be valid till</label>
						   <form:input path="validTill" type="text" style="width: 185px;" maxlength="10" id="datepicker" />			   
						    <form:errors path="validTill" cssClass="text-error"></form:errors>  
						</div>
					    
					  
					</form:form>			
				</c:otherwise>
			</c:choose>
			
			
			    <footer>
			      <div class="container">
			        <p>Developed & Maintained by <a href="http://www.sudhakar.duraiswamy.in/" rel="author">Sudhakar Duraiswamy</a>.
			        <br> 
			         Built using <a href="http://www.springsource.org/"> Spring </a>,<a href="http://www.jquery.com/"> Jquery </a> and <a href="http://twitter.github.com/bootstrap"> Bootstrap </a> and powered by <a href="appengine.google.com">Google Apps Engine</a>.</p>
			      </div>
			    </footer>
			  </div>
			  <div id="push"></div>
</div>
  
</body>
</html>