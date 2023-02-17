<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz Admin Login</title>
</head>
<body>
	
	<div class="main">
	
		<div class="header">
	
			<span class="title">Online Quiz Game</span>
			<br><span class="home"><a href="index.html">Home</a></span>
		</div>
	
		<div class="content">
			
			<h1>Quiz Admin Login</h1>
			
			<p>Please login to Create a Quiz.</p>
		
			<form method="POST" action='<%= response.encodeURL("j_security_check") %>' >
			  <table border="0" cellspacing="5">
			    <tr>
			      <th align="right">Username:</th>
			      <td align="left"><input type="text" name="j_username"></td>
			    </tr>
			    <tr>
			      <th align="right">Password:</th>
			      <td align="left"><input type="password" name="j_password"></td>
			    </tr>
			    <tr>
			      <td align="right"><input type="submit" value="Log In"></td>
			      <td align="left"><input type="reset"></td>
			    </tr>
			  </table>
			</form>
			
		</div>

	</div>

</body>
</html>