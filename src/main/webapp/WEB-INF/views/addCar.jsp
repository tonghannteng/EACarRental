<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="UI" uri="/WEB-INF/views/UITag.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car</title>
<UI:UITag type="dependency"/>
</head>
<body>

<form:form modelAttribute="car" action="addCar" method="post">
<UI:UITag type="header"/>
<UI:UITag type="startContainer"/>
Number Of Cylinder:<form:input path="carType.numberOfCylinder" type="number" /><form:errors path="carType.numberOfCylinder" cssClass="error"/><br>
No Of Person:<form:input path="carType.noOfPerson" type="number" /><form:errors path="carType.noOfPerson" cssClass="error"/><br>
Car Manufacturer:<form:input path="carType.carManufacturer" type="text" /><form:errors path="carType.carManufacturer" cssClass="error"/><br>
Name:<form:input path="name" type="text" /><form:errors path="name" cssClass="error"/><br>
Image Link: <form:input path="imageLink" type="text" /><form:errors path="imageLink" cssClass="error"/><br>
Number Of Miles:<form:input path="numberOfMiles" type="number" /><form:errors path="numberOfMiles" cssClass="error"/><br>
Price Per Day:<form:input path="pricePerDay" type="number" /><form:errors path="pricePerDay" cssClass="error"/><br>
Year:<form:input path="year" type="number" /><form:errors path="year" cssClass="error"/><br>
Last Inspected:<form:input path="lastInpsected" type="date" /><form:errors path="lastInpsected" cssClass="error"/><br>
<form:button value="Add Car" type="submit">Add Car</form:button>
</form:form>
<UI:UITag type="endContainer"/>
</body>
</html>