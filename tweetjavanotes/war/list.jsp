<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Effective Java Notes - Everyday Health Pill for Java Developers</title>
<!-- Include required JS files -->
<script type="text/javascript" src="js/syntaxhighlighter/shCore.js"></script>
<script type="text/javascript" src="js/syntaxhighlighter/shBrushJava.js"></script>


<link href="js/syntaxhighlighter/shCoreEclipse.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link type="text/css" rel="stylesheet" href="css/effectivejava.css" />
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/jquery/jquery-ui.css" />

<script type="text/javascript">

	$(document).ready(function() {
		SyntaxHighlighter.all();

		$("#collapseall").click(function() {			
			$('.description').fadeOut('slow');
		});
		
		$("#expandall").click(function() {
			$('.description').fadeIn('slow');
		});		

		$('[class="notelink"]').click(function() {				
			var des= "#des"+this.id;
			$(des).fadeToggle("slow", "linear");			
		});


        $(window).scroll(function(){
            if ($(this).scrollTop() > 100) {
                $('.scrollup').fadeIn();
            } else {
                $('.scrollup').fadeOut();
            }
        }); 
 
        $('.scrollup').click(function(){
            $("html, body").animate({ scrollTop: 0 }, 600);
            return false;
        });
		
		//Auto focus based on the Note Id parameter
		 	<c:if test="${not empty request_noteid} ">
				var divtofocus = ${request_noteid};
				
				if(divtofocus > 0){
					console.log('#des'+divtofocus);
					$(window).scrollTop($('#des'+divtofocus).offset().top);
				}
		 	</c:if>			
		
	});
</script>


</head>
<body >

<div class='container' style="margin-top:15%;">
	<div class='' style="float:right;width:20%;margin-top:0px;margin-right:20px;word-wrap: break-word;">
		<ul class="thumbnails">
		  <li class="span5">
		  	<a href="subscribe.jsp" style="text-decoration: none;">		    
		      <img src="img/facebook.png" alt="Facebook" height="90px" width="90px">
		      <img src="img/twitter.png" alt="Twitter" height="90px" width="90px">
		      <img src="img/rss.png" alt="Rss" height="90px" width="90px">
		    </a>
		      <h3>
		      <a class="btn btn-large btn-info" href="subscribe.jsp" style="margin-left:100px;margin-top:20px;">Subscribe</a>
		      </h3>
		  </li>
		</ul> 			
	</div>	
	<div>		
		<iframe src="http://www.flipkart.com/affiliate/displayWidget?affrid=WRID-136289907574016181" 
		style="width:120px;height:240px;float:left;" scrolling="no" marginwidth="0" marginheight="0" >
		</iframe>
		
	    This site serves as a quick reference material which i created for my everyday personal use.
	    The information portrayed are only my understanding of the materials stated in the book and i will not be responsible for the accuracy , efficacy or any damaged caused by using the tips prescribed. 
	    <br>For Complete , in-depth information please refer <a href="http://www.flipkart.com/affiliate/displayWidget?affrid=WRID-136289907574016181">Effective Java</a>
	    <br><br>For feedback click:<a id="feed-back"  href="#">contact Sudhakar Duraiswamy</a>
	    		
	</div>

		

			
	<div class="notes">
	
		<div class='' style="float:left;margin-top:10px;margin-left:60%;height:50px;">
			<div class="btn btn-info" id="collapseall"><i class='icon-book icon-white'></i>Collapse All</div>			
			&nbsp;&nbsp;
			<div class="btn btn-success" id="expandall"><i class='icon-book icon-white'></i>Expand All</div>			
		</div>
		<div style="margin:0px;float:left;width:inherit;">
		<c:forEach items="${notes }" var="note">
			<div class="notesection" >
				<div class="notetitle" id="${note.id }"><a href="#${note.id}" class="notelink" id="${note.id }">	${note.title }</a></div>							
				<div class="description" id="des${note.id}"  <c:if test="${request_noteid == note.id }">style="display:block;"</c:if>>
					<c:out value="${note.description.value }" escapeXml="false" />									
				</div>
			</div>			
		</c:forEach>
		</div>
	</div>
	<a href="#" class="scrollup" style="width: 120px; height: 120px;">Scroll</a>
	
	<div id="dialog-form" title="Feedback Form">
		<form method="post" action="feedback" id="feedback-form">
			<fieldset>
			<div id="feedbackview">
			<p class="validateTips">All form fields are required.</p>
				<label for="name">Name</label> 
				<input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all" />
				<label 	for="email">Email</label>
				<input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all" />
				<label for="feedback">Feedback</label>
				<textarea rows="15" cols="10" name="feedback" id="feedback"  class="text ui-widget-content ui-corner-all" ></textarea>
				
			</div>								
			</fieldset>
		</form>
	</div>		
</div>
<script type="text/javascript" src="js/feedback.js"></script>
</body>
</html>