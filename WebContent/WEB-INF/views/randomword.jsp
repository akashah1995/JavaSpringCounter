<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Random Word Generator</title>
</head>
<body>
	<h2>You have generated a word ${sessionScope.Count} times.</h2>
	<h2> ${sessionScope.Word} </h2>
	<form action = '/Counter/Generate' method = 'POST'>
		<input type = "submit" value = "Generate">
	</form>
	<h2> The last time you generated a word was: </h2>
	<h2> ${sessionScope.Date} </h2>
</body>
</html>