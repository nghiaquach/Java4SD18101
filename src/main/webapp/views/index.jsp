<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>Java 4 Home Page</H1>
	<jsp:useBean id="now" class="java.util.Date"/>
	<H5><fmt:formatDate value="${now}" pattern="EEE, dd/MM hh:mm:ss a"/></H5>
	<br/>
	<c:if test="${!empty sessionScope.user}">
		<h4>Welcome, ${fn:toUpperCase(sessionScope.user.fullName)} - ${sessionScope.user.email}</h4>
		
	</c:if>
	
	<c:if test="${empty sessionScope.user}">
		<h4>Please login!</h4>
	</c:if>
	
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