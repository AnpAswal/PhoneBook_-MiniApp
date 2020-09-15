<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts page </title>
</head>
<body>

	<h1>Welcome to Contact_Data handler Application</h1>

	<font color="green">${msg }</font>
	<font color="red">${errmsg }</font>
	<font color="purple">${editmsg }</font>

	<form:form action="/savecontact" method="post" modelAttribute="formdata">

		<table>
			<tr>
			    <form:hidden path="cid"/> 
				<td>contact_Name</td>
				<td><form:input path="name" /></td>

			</tr>

			<tr>
				<td>contact_email</td>
				<td><form:input path="email" /></td>

			</tr>

			<tr>
				<td>contact_number</td>
				<td><form:input path="number"/><td>
			</tr>
			<tr>
				<td><input type="submit" value="Save Contact" /></td>
			</tr>
		</table>



	</form:form>

	<a href="/display"> view All Accounts</a>



</body>
</html>