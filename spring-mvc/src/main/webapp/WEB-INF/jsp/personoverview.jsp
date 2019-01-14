<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.*" %>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
<header>
<h1><span>Web shop</span></h1>
    <%@include file="header.jsp"%>
<h2>
User Overview
</h2>

</header><main>
<table>
<tr>
<th>E-mail</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<c:forEach var="Person" items = "${Databank}">

<tr>
<td>${Person.email}</td>
<td>${Person.firstName}</td>
<td>${Person.lastName}</td>
<td><a href="<c:url value = "SignUpController/${Person.userid}.htm"/>">Update</a></td>
<td><a href="<c:url value="/SignUpController/remove/${Person.userid}.htm"/>">Remove</a></td>
</tr>
</c:forEach>

<caption>Users Overview</caption>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>
