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
	<h3>Customer Dashboard</h3>
	<a href="userLogout.htm">Logout</a>
	<form action="toCustomerSearch.htm" method="GET">
		<table>
			<tr>
				<td><input type="submit" name="action" value="Search Flights"></td>
			</tr>
		</table>
	</form>
	
	<!-- <form action="toCustomerDocuments.htm" method="GET">
		<table>
			<tr>
				<td><input type="submit" name="action" value="Upload Documents"></td>
			</tr>
		</table>
	</form>  -->
	
	<form action="toCustomerViewHistory.htm" method="GET">
		<table>
			<tr>
				<td><input type="submit" name="action" value="View History"></td>
			</tr>
		</table>
	</form>
</body>
</html>