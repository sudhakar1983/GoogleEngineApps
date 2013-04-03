<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		
		<meta name="description" content="Effective Java Notes is a free serice that sends java tips, every day directly to your Twitter/Facebook account." />
		<meta name="keyword" content="Effective Java,Java Tips,Java, Tips" />

		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<link type="text/css" rel="stylesheet" href="css/jquery/jquery-ui.css" />		

		<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
		<link type="text/css" rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link type="text/css" rel="stylesheet" href="css/effectivejava.css" />
		

		
		
		<link href="http://feeds.feedburner.com/effectivejava" rel="alternate" type="application/rss+xml" title="Subscribe to Effective Java Notes via RSS" />		
		<title>Effective Java Notes - Everyday Health Pill for Java Developers</title>

	</head>
	<body id="app" class="subscribe">
		<div class='container'>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			<div class='row5'><div class='span12 offset5'>&nbsp;</div></div>
			
			<div class='row'>
				<div class='span4'>
					<a class='btn btn-info' href="notes"><i class='icon-arrow-left icon-white'></i> Back to Front page</a>
				</div>
			</div>
			
		
			
			<article class='hero-unit' style="background-color: white;">
				<h1>
					To Subscribe,Follow or Like Us
				</h1>
				<p>Once you've subscribed, your will receive subscriptions from next day.(either as a Twitter direct message / a Facebook Update).</p>
				<br/>
				For feedback click:<a id="feed-back"  href="#">contact Sudhakar Duraiswamy</a>
				<br/><br/>
				<div class='row'>
					<div class='span3'>
						<h2>Twitter</h2>
						<br/>
						<p><a href="https://twitter.com/Effective_Java" class="twitter-follow-button" data-show-count="false" data-size="large">Follow @Effective_Java</a></p>
					</div>
					<div class='span4'>
						<h2>Facebook</h2>
						<br/>
						<div class="fb-like-box" data-href="http://www.facebook.com/effectivejavanotes" data-width="292" data-show-faces="true" data-stream="false" data-header="true"></div>
					</div>
					<div class='span3'>
						<h2>RSS Feed</h2>
						<br/>
						<p><a href="http://feeds.feedburner.com/effectivejava">Subscribe via RSS feed</a> so that you'll get notified in your favorite feed reader when we publish Java Tips.</p>
					</div>
				</div>
			</article>
	    <div class="well" >
			        <p>Developed & Maintained by <a href="http://www.sudhakar.duraiswamy.in/" rel="author">Sudhakar Duraiswamy</a>.
			        <br> 
			        Built using <a href="http://www.oracle.com/technetwork/java/javaee/tech/index.html"> Jsp/Servlet  </a>,<a href="http://www.jquery.com/"> Jquery </a> and <a href="http://twitter.github.com/bootstrap"> Bootstrap </a> and powered by <a href="appengine.google.com">Google Apps Engine</a>.</p>	    
	    </div>			

		<!-- Feedback form -->
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
		
		<%-- 3rd party JS --%>
		<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
		<div id="fb-root"></div>
		<script>(function(d, s, id) {
		  var js, fjs = d.getElementsByTagName(s)[0];
		  if (d.getElementById(id)) return;
		  js = d.createElement(s); js.id = id;
		  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
		  fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));</script>
		<script type="text/javascript">


</script>
<script type="text/javascript" src="js/feedback.js"></script>
	</body>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-39831824-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>	
</html>