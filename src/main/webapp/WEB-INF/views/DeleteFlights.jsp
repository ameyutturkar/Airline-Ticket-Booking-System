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
<!--
	<script>
		var flightID = document.forms['deleteFlightForm'].elements['listID'].value;
		function deleteFlight(x)
		{
			alert("flightID is " + x)
			$.ajax({
				type: "POST",
				url: "deleteFlight.htm?flightID="+x,
						
						contentType: "application/json",
						dataType:"json",
						success: function(response){
							var record = document.getElementById(flightID);
							record.parentNode.removeChild(record);
						},
					error:function(){
						alert("Error");
					}
			});
		}
	</script> -->
<h1>Delete Flights</h1>
<a href="userLogout.htm">Logout</a>
<a href="toAirlineDashboard.htm">Dashboard</a>
	<c:choose>
		<c:when test="${empty sessionScope.flightList}">
			<p>No flights available for this airline!</p>
		</c:when>
			
		<c:otherwise>
			<table border="1 solid black" align="center">
				<c:forEach items="${sessionScope.flightList}" var="flight">
				<!-- <form id="deleteFlightForm"> -->
				<form action="deleteFlight.htm?flightID=${flight.flightID}" method="POST">
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
						<td><input type="Submit" name="action" value="Delete Flight"></td>
						<!-- <input type="Submit" name="action" onclick="deleteFlight(${flight.flightID})" value="Delete Flight"> -->
					</tr>
				</form>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>