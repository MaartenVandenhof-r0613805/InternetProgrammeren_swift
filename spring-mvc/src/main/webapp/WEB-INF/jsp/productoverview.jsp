
<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.*" %>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Product overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
<header>
<h1><span>Web shop</span></h1>
    <%@include file="header.jsp"%>
<h2>
Product Overview
</h2>

</header><main>
<table>
<tr>
    <th><spring:message code="product.productId"/></th>
<th><spring:message code="product.name"/></th>
<th><spring:message code="product.description"/></th>
    <th><spring:message code="product.component"/></th>
</tr>
<c:forEach var="Product" items = "${ProductDatabank}">

<tr>
    <td>${Product.productId}</td>
<td>${Product.name}</td>
<td>${Product.description}</td>
    <td>
        <ul>
        <c:forEach var="Component" items="${Product.components}">
            <li>${Component.name}</li>
        </c:forEach>
        </ul>
    </td>
    <td><a href="<c:url value="AddProductController/${Product.productId}.htm"/> ">Update</a></td>
<td><a href="<c:url value="AddProductController/remove/${Product.productId}.htm"/> ">Remove</a></td>

</tr>
</c:forEach>

<caption>Product Overview</caption>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>