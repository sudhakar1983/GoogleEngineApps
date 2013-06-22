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


<script type="text/javascript" src="js/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
		plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave,visualblocks,syntaxhl",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft,visualblocks,|,syntaxhl",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,
		extended_valid_elements : "textarea[cols|rows|disabled|name|readonly|class],pre[class]",		

		// Style formats
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
			{title : 'Example 1', inline : 'span', classes : 'example1'},
			{title : 'Example 2', inline : 'span', classes : 'example2'},
			{title : 'Table styles'},
			{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
		],

		// Replace values for the template plugin
		template_replace_values : {
			username : "Some User",
			staffid : "991234"
		}
	});
</script>
</head>
<body>

<div class='container' style="margin-top:15%;">

			
	<div class='row'>
		<div class='span4'>
			<a class='btn btn-info' href="notes"><i class='icon-arrow-left icon-white'></i> Back to Front page</a>
		</div>
	</div>
			


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
	<c:if test="${result}">			
			<button type="button" class="btn btn-large btn-success disabled offset2" disabled="disabled">Inserted Successfully . . . . . . .  . .  . . . . . .  . . . . . . . .  . . . . . . . .  . .</button>
	</c:if>	
		
	<form method="post" action="setup">
	
	  <input type="hidden" name="pp" value="letusrock"/><br/>
	  <fieldset class="offset1">
	
	    <label><h3>Note Order Id</h3></label>
	    <input type="text" name="order"  />
	    <span class="help-block">The order by which it will be displayed.</span>
	    <br/>
	    
	    <label><h3>Title</h3></label>
	    <input type="text" name="title" /> <br/>
	    <br/>
	    
	    <label><h3>Description</h3></label>
	   	<textarea rows="30" cols="80"  name="description" ></textarea>    
	    <br/>
		
		<br/>
		<button class="btn btn-info btn-large offset2" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Insert&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
	</fieldset>	
	

	</form>	
	
</div>

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>	
</body>

</html>