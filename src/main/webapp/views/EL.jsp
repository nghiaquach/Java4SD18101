<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Demo</title>
</head>
<body>
	<ul>
		<li>Request scope x: ${requestScope.x} = ${x}  </li>
		<li>Request scope y: ${sessionScope.y} = ${y}  </li>
		<li>Request scope z: ${applicationScope.z} = ${z}  </li>
		<li>Application Scope]: ${applicationScope.x} = ${x}  </li>
		
		<li>Date ${now.date}  </li>
		<li>Month ${now.month + 1} from Bean </li>
		<li>Year ${now.year + 1900} from Bean</li>
		
		<br/>
		MAP:
		<li>Mon 1: ${map['Nhap Mon Lap Trinh']}</li>
		<li>Mon 2: ${map['Java 1']}</li>
		<li>Mon 3: ${map['Java 2']}</li>
		
		List:
		<li>SV 1: ${students[0]}</li>
		<li>SV 2: ${students[1]}</li>
		<li>SV 3: ${students[2]}</li>
		
	</ul>
</body>
</html>