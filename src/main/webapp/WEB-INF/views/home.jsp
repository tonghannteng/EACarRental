<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title></title>

<link href="http://getbootstrap.com/dist/css/bootstrap.css"
	rel="stylesheet">

<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"
	rel="stylesheet">

</head>

<body>

	<div class="container">
	
		<h1 style="text-align: right;text-shadow: 2px gray;">
			<c:if test="${Iuser!=null}">
				Hello<span style="color: yellow"> ${Iuser}</span> welcome!!!
				</c:if>
		</h1>
		
		<div class="header">
			<ul class="nav nav-pills pull-right">


				<li><a href="/EACarRental" class="btn btn-danger">Home</a></li>
				<li><a href="/EACarRental/login" class="btn btn-danger">Login</a></li>
				<li><a href="/EACarRental/user/signUp" class="btn btn-danger">SignUp</a></li>
				<li><a href="/EACarRental/reserve" class="btn btn-danger">Reserve
						Car</a></li>
				<c:if test="${Iuser!=null}">
					<li><a href="/EACarRental/logoutSuccessful"
						class="btn btn-danger">Logout</a></li>

				</c:if>
				<li></li>


			</ul>

			<img src="/EACarRental/resources/images/car1.png" alt="image"
				style="width: 5%" />Rental Service
		</div>

		<!-- <div style="float: right; font-weight: bolder;"></div> -->

		<div class="jumbotron">
			<h1>Welcome to our Car Rental Service</h1>
			<p>Rent a car</p>
		</div>

		<div>
			<img alt="Car Image" src="/EACarRental/resources/images/car2.jpg"
				style="length: 400px; width: 400px;"> <img alt="Car Image"
				src="/EACarRental/resources/images/car3.png"
				style="length: 400px; width: 400px;">


		</div>

		<div class="footer">
			<p>&copy; Group F</p>
			<P>Contact: 6414513369</P>
			<p>1000 Nth 4th St</p>
			<p>Fairfield, Iowa</p>
		</div>

	</div>
</body>
</html>
