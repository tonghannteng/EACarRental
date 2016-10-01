<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="UI" uri="/WEB-INF/views/UITag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car Here</title>
<UI:UITag type="dependency" />
</head>
<body>

	<UI:UITag type="header" />
	<UI:UITag type="containerBase1" />
	<h1>${message }</h1>
	<div>
		<table border="2">
			<thead>
				<tr>
					<th>Number Of Cylinder</th>
					<th>No Of Person</th>
					<th>Car Manufacturer</th>
					<th>Name</th>
					<th>Image Link</th>
					<th>Number Of Miles</th>
					<th>Price Per Day</th>
					<th>Year</th>
					<th>Last Inspected</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cars }" var="car">
					<tr>
						<td>${car.carType.numberOfCylinder}</td>
						<td>${car.carType.noOfPerson}</td>
						<td>${car.carType.carManufacturer}</td>
						<td>${car.name }</td>
						<td>${car.imageLink }</td>
						<td>${car.numberOfMiles }</td>
						<td>${car.pricePerDay }</td>
						<td>${car.year }</td>
						<td>${car.lastInpsected }</td>

						<td><a href="edit/${car.id }"><button action="/edit">Edit</button></a></td>
						<td><a href="delete/${car.id }"><button action="/delete">Delete</button></a></td>


					</tr>

				</c:forEach>
			</tbody>

		</table>


	</div>
	<a href="addCar"><input type="button" value="Add Car"></a>
	<UI:UITag type="endContainer" />
</body>
</html>