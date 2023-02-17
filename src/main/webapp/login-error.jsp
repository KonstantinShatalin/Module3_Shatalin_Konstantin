<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page For Examples</title>
</head>
<body>
	
	<div class="main">
	
		<div class="header">
	
			<span class="title">Online Quiz Game</span>
			<br><span class="home"><a href="index.html">Home</a></span>
		</div>
	
		<div class="content">
			
			<h1>Login Failed</h1>
			
			Invalid username and/or password, please try
			<a href='<%= response.encodeURL("login.jsp") %>'>again</a>.<br>
			Or go back to <a href='<%= response.encodeURL("index.html") %>'>home page</a>
			
		</div>

	</div>

</body>
</html>