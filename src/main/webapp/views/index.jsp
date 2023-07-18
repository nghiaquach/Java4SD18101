<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>Java 4 Home Page</H1>
	<h4>${welcome}</h4>
	
	<!-- /TenDuAn/MyServlet -->
	<form action="/SD18101/MyServlet" method="POST">
		<input name="fullname" placeholder="enter fullname"><br/>
		<input name="favorites" type="checkbox" value="RE">Reading<br/>
		<input name="favorites" type="checkbox" value="MU">Music<br/>
		<input name="favorites" type="checkbox" value="SH">Shopping<br/>
		<button type="submit">Submit</button>
	</form>
	<br/>
	<%@ include file="subpage.jsp" %>
	
</body>
</html>