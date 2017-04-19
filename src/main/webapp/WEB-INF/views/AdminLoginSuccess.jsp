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
<title>Admin Dashboard</title>
</head>
<body>
	<a href="userLogout.htm">Logout</a>
	<c:choose>
		<c:when test="${empty requestScope.airlineList}">
			<form action="searchPendingRequests.htm" method="POST">
			<table>
				<tr> 
					<td><input type="submit" value="Pending Request"></td>
				</tr>
			</table>
			</form>
			
			<form action="searchRejectedRequests.htm" method="POST">
			<table>
				<tr>
					<td><input type="submit" value="View Rejected"></td>
				</tr>
			</table>
			</form>
			
			<form action="searchAcceptedRequests.htm" method="POST">
			<table>
				<tr>
					<td><input type="submit" value="View Accepted"></td>
				</tr>
			</table>
			</form>
		</c:when>
		<c:otherwise>
		<!-- <form action="actionPendingRequests.htm" method="POST"> -->
			<table border="1 solid black" align="center">
			<thead>
				<tr>
					<td>Airline ID</td>
					<td>Airline Name</td>
					<td>Airline Email</td>
					<td>Airline Address</td>
					<td>Account Status</td>
					<td>Action</td>
				</tr>
			</thead>
			<tr>
			<c:forEach items="${requestScope.airlineList}" var="airline">
				<tr>
					<td>
						<c:out value="${airline.userID}"></c:out>
					</td>
					<td>
						<c:out value="${airline.airlineName}"></c:out>
					</td>
					<td>
						<c:out value="${airline.airlineEmail}"></c:out>
					</td>
					<td>
						<c:out value="${airline.airlineAddress}"></c:out>
					</td>
					<td>
						<c:out value="${airline.accountStatus}"></c:out>
					</td>
					<td><a href="actionPendingRequests.htm?userID=${airline.userID}&action=Accept">Accept</a>
					<a href="actionPendingRequests.htm?userID=${airline.userID}&action=Reject">Reject</a></td>
				</tr>
			</c:forEach>
			</tr>
		</table>
		<!-- </form> -->
		</c:otherwise>
	</c:choose>
</body>
</html>