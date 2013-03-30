<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="now" value="<%=new java.util.Date()%>" />
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
	
	<script>
	$(function() {

		$('#url').focus(function (){
				$('#captcha').show('slow');
			}
		);
		
		$( "#datepicker" ).datepicker({
			inline: true
		});	


		$("#advanceOptionlink").click(function(){
				var advancedDiv = 	$('#advanceoptions');			
				advancedDiv.fadeToggle()
			}
		);

	});
	</script>
	
	
</head>


<body>
  <div class="container">
        <header class="hero-unit">
			<h1>Welcome to ZAP url shortener</h1>
			<div class="span5 offset3">
				 <h5 class="text-warning">...the place to zap your long urls.</h5>     
			</div>
        </header>  


		<form>
		  
		    <div class="well" id="main">
			    <label><strong>Paste your long  URL here</strong></label>		    
			    <input type="text" style="width: 100%; " maxlength="1000" name="url" id="url" placeholder="http://URL.."/>			    
		    </div>
		    
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
				}					    		    	
		    </style>		    
		    
		    <div class="well captcha_options" id="captcha">
				<%
					ReCaptcha c = ReCaptchaFactory.newReCaptcha(
							"6LdnC98SAAAAAOuHfTMoV6odEDeI8pfirEfIwKId",
							"6LdnC98SAAAAAJ3q4yEdt3lPcM9yigZtf5B80HzQ", false);
					out.print(c.createRecaptchaHtml(null, null));
				%>		    

			    <div class="well" style="width:200px;margin-left:45%">
			    	<button type="submit" class="btn btn-default btn-block btn-primary">Zap</button>
			    </div>				
		    </div>

			<div id="advanceOptionlink" class="makemelink">
				<i class="icon-plus"></i>Show Advance Option
			</div>			
			
			
			<div class="well advance_options" id="advanceoptions">
			    <label class="checkbox">
			      <input type="checkbox" name="secure" value="true">Make it Password Protected
			    </label>	
			    
			    <label>Password</label>
			    <input type="password" style="width: 185px;" maxlength="30" name="password" id="password" />
			    
			    <label>Valid till</label>
			   <input type="text" style="width: 185px;" maxlength="30" name="validtill" id="datepicker" value='<fmt:formatDate pattern="MM/dd/yyyy" value="${now}" />'/>    
			</div>
		    
		    

		    
		    
		  
		</form>
  	
		

    <footer>
      <div class="container">
        <p>Developed & Maintained by <a href="http://www.sudhakar.duraiswamy.in/" rel="author">Sudhakar Duraiswamy</a>.
        <br> 
         Built using <a href="http://www.springsource.org/"> Spring </a>,<a href="http://www.jquery.com/"> Jquery </a> and <a href="http://twitter.github.com/bootstrap"> Bootstrap </a> and powered by <a href="appengine.google.com">Google Apps Engine</a>.</p>
      </div>
    </footer>		
		
  </div>
</body>
</html>