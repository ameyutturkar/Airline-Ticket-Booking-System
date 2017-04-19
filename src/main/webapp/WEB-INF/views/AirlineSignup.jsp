<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
				$("#airlineSignupForm").validate({
					rules: {
						airlineName: {
							required: true
						},
						airlineEmail: {
							required: true,
							email: true
						},
						airlineAddress: {
							required: true
						},
						userName: {
							required: true,
							minlength: 5
						},
						userPassword: {
							required: true,
							minlength: 5
						},
						
						messages: {
							airlineName: "Please enter Customer Name",
							airlineEmail: "Please enter a valid email ID",
							airlineAddress: "Please enter Customer Address",
							userName: {
								required: "Please enter a valid User Name",
								minlength: "User Name must consist atleast 5 characters"
							},
							userPassword: {
								required: "Please enter a valid User Password",
								minlength: "User Password must consist atleast 5 characters"
							}
							
						}
					}
			})
		})
	</script>
	
	<h3>Sign Up Screen for Airline</h3>
	<h3>Hello <c:out value="${sessionScope.user}"></c:out></h3>
	<form:form id="airlineSignupForm" action="airlineSignup.htm" commandName="airline" method="POST">
		<form:select path="roleType">
			<!-- <form:option value="">--- Select ---</form:option>
			<form:option value="Admin"></form:option> -->
			<form:option value="Airline"></form:option>
			<!-- <form:option value="Customer"></form:option> -->
		</form:select>
		<table>
			<tr>
				<td>Airline Name:</td>
				<td><form:input name="airlineName" path="airlineName" size="30" /> <font color="red"><form:errors path="airlineName" /></font></td>
			</tr>
			<tr>
				<td>EmailAddress:</td>
				<td><form:input name="airlineEmail" path="airlineEmail" type="email" size="30" /> <font color="red"><form:errors path="airlineEmail" type="email" /></font></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input name="airlineAddress" path="airlineAddress" size="30" /> <font color="red"><form:errors path="airlineAddress" /></font></td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><form:input name="userName" path="userName" size="30" /> <font color="red"><form:errors path="userName" /></font></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input name="userPassword" path="userPassword" type="password" size="30" /> <font color="red"><form:errors path="userPassword" type="password" /></font></td>
			</tr>
		</table>
		<input id="submit" type="submit" value="Signup"/>
	</form:form>
</body>
</html>