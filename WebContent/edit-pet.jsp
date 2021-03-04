<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Pet</title>
<link rel="stylesheet" type="text/css" href="petstyle.css">
</head>
<body>

	<h1>Edit Pet</h1>

	<form action = "editPetServlet" method="post">
		Name: <input type ="text" name = "name" size="10" value= "${petToEdit.name}">
		Species: <input type = "text" name = "species" size="13" value= "${petToEdit.species}">
		<input type = "hidden" name = "id" value="${petToEdit.id}">
		<input type = "submit" value="Save Edited Pet"> 
	</form>

</body>
</html>