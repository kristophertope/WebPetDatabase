<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Pets</title>
<link rel="stylesheet" type="text/css" href="petstyle.css">

</head>
<body>

	<h1>All Pets</h1>

	<form method = "post" action = "navigationServlet">
		<table>
			<tr class="topline">
				<td></td>
				<td>Name</td>
				<td>Species</td>
			</tr>
			<c:forEach items="${requestScope.allPets}" var="currentpet"> 
			<tr>
				<td><input type="radio" name="id" value="${currentpet.id}"></td> 
				<td>${currentpet.name}</td>
				<td>${currentpet.species}</td>
			</tr>
			</c:forEach> 
		</table>
		<div class="buttons">
			<input type = "submit" value = "edit" name="doThisToPet"> 
			<input type = "submit" value = "delete" name="doThisToPet"> 
			<input type="submit" value = "add" name = "doThisToPet">
		</div>
	</form>
	
</body>
</html>