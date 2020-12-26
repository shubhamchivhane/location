<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Location</title>
</head>

<body>
<table>
<tr>
<th>Id</th>
<th>Code</th>
<th>Name</th>
<th>Type</th>
<th>Operation</th>
</tr>
<pre>${location}</pre>
<c:forEach items="${location}" var="locations">
<tr>
<td>${locations.id}</td>
<td>${locations.code}</td>
<td>${locations.name}</td>
<td>${locations.type}</td>
<td><a href="deletelocation?id=${locations.id}">Delete</a></td>
<td><a href="updatelocation?id=${locations.id}">EDIT</a></td>
</tr>
</c:forEach>
</table>
<a href="showCreate">Add Location</a>
</body>
</html>