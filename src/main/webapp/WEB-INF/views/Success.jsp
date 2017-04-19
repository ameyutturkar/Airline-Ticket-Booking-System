<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<a href="userLogout.htm">Logout</a>
<a href="toCustomerDashboard.htm">Dashboard</a>
	<c:choose>
		<c:when test="${empty sessionScope.flightList}">
			<form action="searchFlights.htm" method="POST">
		<table>
			<tr>
				<td>From</td>
				<td><input type="text" name="source" size="30" /> <font color="red"></font></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input type="text" name="destination" size="30" /> <font color="red"></font></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="text" name="startDate" size="30" /> <font color="red"></font></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="text" name="endDate" size="30" /> <font color="red"></font></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" size="30" /> <font color="red"></font></td>
			</tr>
			<tr>
				<td> <input type="submit" value="Search" /> </td>
			</tr>
		</table>	
			</form>
		</c:when>
		<c:otherwise>
			<table border="1 solid black" align="center">
				<thead>
					<tr>
						<td>Flight ID</td>
						<td>Flight Name</td>
						<td>Flight Source</td>
						<td>Flight Destination</td>
						<td>Order Quantity</td>
						<td>Journey Start</td>
						<td>Journey End</td>
						<td>Total Price</td>
					</tr>
				</thead>
				<c:forEach items="${sessionScope.flightList}" var="flight">
				<form action="addToCart.htm?flightID=${flight.flightID}&price=${flight.price}&quantity=${flight.quantity}" method="POST">
					<tr>
						<td>
							<input type="checkbox" name="cart">
							<input type="hidden" name="listID" value="${flight.flightID}">
						</td>
						<td>
							<c:out value="${flight.flightName}"></c:out>
						</td>
						<td>
							<c:out value="${flight.source}"></c:out>
						</td>
						<td>
							<c:out value="${flight.destination}"></c:out>
						</td>
						<td>
							<c:out value="${flight.quantity}"></c:out>
						</td>
						<td>
							<c:out value="${flight.startDateTime}"></c:out>
						</td>
						<td>
							<c:out value="${flight.endDateTime}"></c:out>
						</td>
						<td>
							<c:out value="${flight.price}"></c:out>
						</td>
						<td><input type="Submit" name="addCart" value="Add To Cart"></td>
					</tr>
				</form>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>