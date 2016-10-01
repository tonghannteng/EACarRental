<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="UI" uri="/WEB-INF/views/UITag.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<UI:UITag type="dependency"/>
</head>
<body>
<UI:UITag type="header"/>
<UI:UITag type="startContainer"/>

	<form:form modelAttribute="user" action="/EACarRental/admin/editUser" method="post">
		<form:hidden path="id" />
First Name: <form:input path="firstName" type="text"  />
		<form:errors path="firstName" />
		<br>
Last Name: <form:input path="lastName" type="text" />
		<form:errors path="lastName" /><br>
		
Email: <form:input path="email" type="text" />
		<form:errors path="email" /><br>
Password: <form:input path="password" type="password" /> 
		<form:errors path="password" /><br>
<%-- <form:hidden path="role.role" /> --%><%-- type="hidden" value='${role.role}' --%>
<form:hidden path="userName"/>	
City: <form:input path="address.city" type="text" />
		<form:errors path="address.city" /><br>	
State: <form:input path="address.state" type="text" />
		<form:errors path="address.state" />	<br>
ZIP: <form:input path="address.zip" type="text" />
		<form:errors path="address.zip" />	<br>
Street Address: <form:input path="address.address" type="text" /> 
		<form:errors path="address.address" />	<br>
<input type="submit" name="submit" value="Save Changes">							
	
	
	</form:form>
	
	<a href="/EACarRental/admin/userList" ><button >Cancel</button></a>
	<UI:UITag type="endContainer"/>
</body>
</html>