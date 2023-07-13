<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="/SD18101/upload">
		<input type="file" name="photo"> 
		<br>
		<button type="submit">Upload a file</button>
	</form>
</body>
</html>