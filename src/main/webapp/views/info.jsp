<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information Page</title>
</head>
<body>
<script type="text/javascript">

function confirmdel()
{
return confirm("Are you sure to delete contact?????");

}


</script>

	<h1>All Contacts</h1>
	<p><font color="Red">${msg}</font></p>
	<a href="/loadform">++Add new Contact</a>

	<table border="1">
		<tr>
			<td>Contact_Name</td>
			<td>Contact_email</td>
			<td>Contact_number</td>
			<td>Action</td>
		</tr>

		
			<c:forEach items="${contacts}" var="i" >
			<tr>
				<td><c:out value="${i.name}" /></td>
				<td><c:out value="${i.email}" /></td>
				<td><c:out value="${i.number}" /></td>
				<td>
				<a href="/edit?id=${i.cid}">edit</a> 
				<a href="/del?id=${i.cid}" onclick="return confirmdel()" >delete</a>
				</td>
			</tr>	
			</c:forEach>
			
	</table>



</body>
</html>