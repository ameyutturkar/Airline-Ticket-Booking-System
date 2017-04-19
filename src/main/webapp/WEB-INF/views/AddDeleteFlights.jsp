<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				$("#addFlightsForm").validate({
					rules: {
						flightName: {
							required: true
						},
						source: {
							required: true
						},
						destination: {
							required: true
						},
						quantity: {
							required: true,
							min: 1
						},
						startDateTime: {
							required: true,
							date: true
						},
						endDateTime: {
							required: true,
							date: true
						},
						price: {
							required: true,
							min: 1
						},
						
						messages: {
							flightName: "Please enter Flight Name",
							source: "Please enter Source",
							destination: "Please enter Destination",
							quantity: "Please enter ticket quantity",
							startDateTime: {
								required: "Please enter a valid Date"
							},
							endDateTime: {
								required: "Please enter a valid Date"
							},
							price: "Please enter the price"
							
						}
					}
			})
		})
	</script>
	
	<h1>Add Flights</h1>
	<div>
		<a href="userLogout.htm">Logout</a>
		<a href="toAirlineDashboard.htm">Dashboard</a>
		<form:form id="addFlightsForm" action="addDeleteFlights.htm" commandName="flight" method="POST">
			<table>
				<tr>
					<td>Flight Name:</td>
					<td><form:input name="flightName" path="flightName" size="30" /> <font color="red"><form:errors path="flightName" /></font></td>
				</tr>
				<tr>
					<td>Source:</td>
					<td><form:input name="source" path="source" size="30" /> <font color="red"><form:errors path="source" /></font></td>
				</tr>
				<tr>
					<td>Destination:</td>
					<td><form:input name="destination" path="destination" size="30" /> <font color="red"><form:errors path="destination" /></font></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td><form:input name="quantity" path="quantity" size="30" /> <font color="red"><form:errors path="quantity" /></font></td>
				</tr>
				<tr>
					<td>Journey Start:</td>
					<td><form:input name="startDateTime" path="startDateTime" size="30" /> <font color="red"><form:errors path="startDateTime" /></font></td>
				</tr>
				<tr>
					<td>Journey End:</td>
					<td><form:input name="endDateTime" path="endDateTime" size="30" /> <font color="red"><form:errors path="endDateTime" /></font></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input name="price" path="price" size="30" /> <font color="red"><form:errors path="price" /></font></td>
				</tr>
			</table>		
			<input type="submit" value="Add Flight"/>
		</form:form>
	</div>
</body>
</html>