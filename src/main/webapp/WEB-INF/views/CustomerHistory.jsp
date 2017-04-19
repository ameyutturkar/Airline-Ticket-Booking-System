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
<h1>Customer History</h1>
<a href="userLogout.htm">Logout</a>
<a href="toCustomerDashboard.htm">Dashboard</a>
	<c:choose>
		<c:when test="${empty sessionScope.viewHistory}">
			<p>No History to Display!!</p>
		</c:when>
		
		<c:otherwise>
			<table border="1 solid black" align="center">
				<thead>
					<tr>
						<td>Order ID</td>
						<td>Flight ID</td>
						<td>Order Quantity</td>
						<td>Total Price</td>
						<td>User Name</td>
					</tr>
				</thead>
				<c:forEach items="${sessionScope.viewHistory}" var="order">
				<tr>
					<td>
						<c:out value="${order.orderID}"></c:out>
					</td>
					<td>
						<c:out value="${order.flightID}"></c:out>
					</td>
					<td>
						<c:out value="${order.quantity}"></c:out>
					</td>
					<td>
						<c:out value="${order.totalPrice}"></c:out>
					</td>
					<td>
						<c:out value="${order.userName}"></c:out>
					</td>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>