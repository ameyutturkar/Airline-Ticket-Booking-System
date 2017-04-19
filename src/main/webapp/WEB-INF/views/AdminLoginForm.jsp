<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	
	<script>
		$(document).ready(function(){
			alert("Function executed onclick");
				$("#adminLoginForm").validate({
					rules: {
						userName: {
							required: true,
							minlength: 5
						},
						password: {
							required: true,
							minlength: 5
						},
						
						messages: {
							userName: {
								required: "Please enter a valid User Name",
								minlength: "User Name must consist atleast 5 characters"
							},
							password: {
								required: "Please enter a valid User Password",
								minlength: "User Password must consist atleast 5 characters"
							}
							
						}
					}
			})
		})
	</script>
	
	<h2>Admin Login Screen</h2>
	<div>
	<a href="userLogout.htm">Home Page</a>
		<form id="adminLoginForm" action="loginSuccessAdmin.htm" method="POST">
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName" size="30" /> <font color="red"></font></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" size="30" /> <font color="red"></font></td>
				</tr>
				<tr>
					<td> <input type="submit" value="Admin Login" /> </td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>