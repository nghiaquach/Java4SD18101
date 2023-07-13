<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:url var="url" value="/SimpleBean"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Bean - Bean Utils</title>
</head>
<body>
	<form action="${url}" method="post">
		Fullname: <input name="fullname">
		<br>
		Age: <input type="number" name="age">
		<br>
		Salary <input type="number" name="salary">
		<br>
		<input name="gender" type="radio" value="true"> Male
		<br>
		<input name="gender" type="radio" value="false"> Female
		<button type="submit">Submit</button>
	</form>
</body>
</html>