<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%-- 
<%@ page session="false" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="UI" uri="/WEB-INF/views/UITag.tld"%>
<html>
<head>
	<title>Home</title>
	<UI:UITag type="dependency" />
</head>
<body>
<UI:UITag type="header" />
	<UI:UITag type="containerBase1" />
<div style="float:right;font-weight: bold;">
 <a href="${pageContext.request.contextPath}/welcome">Home</a>
 
  | &nbsp;
   <a href="/EACarRental/admin/addUser">Add User</a>
  
  | &nbsp;
  
   <a href="/EACarRental/admin/userList">List User</a>
  
  | &nbsp;
  
  <a href="/EACarRental/car/addCar">Add Car</a>
   | &nbsp;
   
  <a href="/EACarRental/car/carList">List Car</a>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
  
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>
     
  </c:if>

<div style="float: right;"><h3>Welcome<span style="color:yellow;"> ${pageContext.request.userPrincipal.name}</span></h3></div>
</div>


<%-- <h1>${Iuser}</h1>
<h1>${email}</h1> --%>

<P>  </P>
<!-- <h1><a href="/EACarRental/admin/addUser">Employee register</a></h1>
<h1><a href="/EACarRental/admin/userList">All Users</a></h1>
<h1><a href="/EACarRental/user/signUp">User Signup</a></h1>
<h1><a href="/EACarRental/car/carList">List Car</a></h1>
<h1><a href="/EACarRental/car/addCar">Add Car</a></h1> -->
<UI:UITag type="endContainer" />
</body>
</html>
