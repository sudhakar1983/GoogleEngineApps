<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
		]

	});
</script>
</head>
<body>

	<form method="post" action="edit">
	<input type="password" name="pp" value="letusrock"/><br/>
	<input type="noteid" value="${note.id}" />

		Title :<input type="text" name="title" value="${note.title}"/> <br/>
		description :<textarea rows="30" cols="80"  name="description" >${note.description.value }</textarea><br/>

		<input type="submit" value="Submit" />
	</form>
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var kurals;
			$('[type="button"]').click(function() {
				
				kurals = $.parseJSON($('textarea').val());
				console.log(kurals);
				jQuery.each(kurals, function() {
					console.log(this );
				});
				
				//upload(0);
			});


			function upload(index) {
				var kural = kurals[index];
				var pin = $('[name="pin"]').val();
				if(kural == undefined) return;
				console.log(kural);
				upload(index+1);
				
				$.post('setup', {
					title : kural.title,
					description : kural.description,
					codeSample : kural.codeSample,				
					pp : pin
				}, function(){
					console.log('success');
					//upload(index+1);
				});
				
			}
		});
	</script>
</body>

</html>