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

<script type="text/javascript">

	$(document).ready(function() {
		SyntaxHighlighter.all();

		$("#collapseall").click(function() {
			//console.log("collapsing ..");
			$('.description').fadeOut('slow');
		});
		
		$("#expandall").click(function() {
			$('.description').fadeIn('slow');
		});		

		$('[class="notelink"]').click(function() {
			console.log(this.id);			
			var des= "#des"+this.id;
			$(des).fadeToggle("slow", "linear");			
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
 	


 	
	<div>
		<iframe src="http://www.flipkart.com/affiliate/displayWidget?affrid=WRID-136289907574016181" 
		style="width:120px;height:260px;float:left;" scrolling="no" marginwidth="0" marginheight="0" >
		</iframe>
	    This site serves as a quick reference material which i created for my everyday personal use.
	    The information portrayed are only my understanding of the materials stated in the book and i will not be responsible for the accuracy , efficacy or any damaged caused by using the tips prescribed. 
	    <br>For Complete , in-depth information please refer <a href="http://www.flipkart.com/affiliate/displayWidget?affrid=WRID-136289907574016181">Effective Java</a>
	    <br><br>For feedback please shoot a email to <a href="mailto:sudhakar.duraiswamy@gmail.com?Subject=Feedback">sudhakar.duraiswamy@gmail.com</a>

	</div>
		
	<header class='row' style="margin-top:50px;">
		<div class='' style="float:right;width:50%;margin-top:10px;">
			<div class="btn btn-info" id="collapseall"><i class='icon-book icon-white'></i>Collapse All</div>			
			&nbsp;&nbsp;
			<div class="btn btn-success" id="expandall"><i class='icon-book icon-white'></i>Expand All</div>			
		</div>
	</header>
			
	<div class="notes">
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
</body>
</html>