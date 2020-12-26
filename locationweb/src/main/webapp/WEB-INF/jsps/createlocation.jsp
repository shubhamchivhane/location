<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>

	<form action="saveloc" method="post">
		Id : <input type="text" name="id" value="${location.id}" readonly/>
	    code : <input type="text" name="code" value="${location.code}"/>
	    Name : <input type="text" name="name" value="${location.name}"/> 
	    Type : Urban <input type="radio" name="type" value="Urban" ${location.type =='URBAN'?'checked':''}  /> 
	    	   Rural <input type="radio" name="type" value="Rural" ${location.type =='Rural'?'checked':''}/>
	    <input type="submit" value="Save" />
	</form>
   ${msg}
   
   <a href="displayLoc">View All</a>
</body>
</html>