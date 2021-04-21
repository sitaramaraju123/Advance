<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Calculate.jsp">
<input type="text"; placeholder="Enter 1st Number" name="one" required="required"><br>
<input type="radio" name="cal" value="+">Add
<input type="radio" name="cal" value="-">Sub
<input type="radio" name="cal" value="*">Mul
<input type="radio" name="cal" value="/">Div<br>
<input type="text"; placeholder="Enter 2nd Number" name="two" required="required"><br>
<input type="submit" value="Calculate">
</form>
</body>
</html>