<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Add Product</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
<header>
<h1><span>Web shop</span></h1>
    <%@include file="header.jsp"%>
<h2>
Add Product
</h2>

</header>
<main>
    <form:form method="post" action="${pageContext.request.contextPath}/AddProductController.htm" modelAttribute="product" novalidate="novalidate">
        <div class="alert-danger">
            <ul>
                <li><form:errors path="productId"/></li>
                <li><form:errors path="name"/></li>
                <li><form:errors path="price"/></li>
                <li><form:errors path="description"/></li>
            </ul>
        </div>
        <p><label for="id"><spring:message code="product.productId"/></label>
            <form:input type="text" id="name" name="id"
                        path="productId"/> </p>
        <p><label for="name"><spring:message code="product.name"/></label>
            <form:input type="text" id="name" name="name"
                        path="name"/> </p>
        <p><label for="description"><spring:message code="product.description"/></label>
            <form:input type="text" id="description" name="description"
                        path="description"/> </p>
        <p><label for="price"><spring:message code="product.price"/></label>
            <form:input type="number" id="price" name="price"  path="price"/></p>

        <p><label for="component"><spring:message code="product.component"/></label>
            <form:input type="text" id="component" name="component"  path="components[0].name"/></p>

        <p><input type="submit" id="signUp" value="Add Product"></p>
    </form:form>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>