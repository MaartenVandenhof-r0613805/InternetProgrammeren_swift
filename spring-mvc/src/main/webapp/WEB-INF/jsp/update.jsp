<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Update</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/> ">
</head>
<body>
<div id="container">
<header>
<h1><span>Web shop</span></h1>
    <%@include file="header.jsp"%>
<h2>
Sign Up
</h2>

</header><main>
	<c:forEach var = "error" items = "${errors }">
	<div class="alert-danger">
		<ul>
			<li>${error}</li>
		</ul>
	</div>
	</c:forEach>
	
    <form method="post" action="<c:url value="/SignUpController/update.htm"/> " novalidate="novalidate">
    	<!-- novalidate in order to be able to run tests correctly -->
        <p><label for="userid">User id</label><input type="text" id="userid" name="userid"
         required value="${person.userid }"> </p>
        <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"
         required value="${person.firstName }"> </p>
        <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"
         required value="${person.lastName }"> </p>
        <p><label for="email">Email</label><input type="email" id="email" name="email" required value="${person.email }"></p>
        <p><label for="password">Password</label><input type="password" id="password"  name="password"
         required > </p>
        <p><input type="submit" id="signUp" value="Sign Up"></p>
        
    </form>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>
