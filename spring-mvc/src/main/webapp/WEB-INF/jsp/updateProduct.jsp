<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
Update Product
</h2>

</header><main>



    <form:form method="post" action="${pageContext.request.contextPath}/AddProductController/update.htm" modelAttribute="product" novalidate="novalidate">
    	<!-- novalidate in order to be able to run tests correctly -->
        <div class="alert-danger">
            <ul>
                <li><form:errors path="name"/></li>
                <li><form:errors path="price"/></li>
                <li><form:errors path="description"/></li>
            </ul>
        </div>
        <p><label for="id"><spring:message code="product.productId"/></label>
            <form:input id="name" name="id"
                        path="productId"/> </p>
        <p><label for="name">Name</label><form:input type="text" id="name" name="name"
          value="${product.name }" path="name"/> </p>
        <p><label for="description">Description</label><form:input type="text" id="description" name="description"
          value="${product.description }" path="description"/> </p>
        <p><label for="price">Price</label><form:input type="number" id="price" name="price"  value="${product.price }" path="price"/></p>

        ${product.addComponent()}

        <c:forEach var="component" items="${product.components}" varStatus="i">
            <p><spring:message code="product.component"/>
                <form:input type="text" path="components[${i.index}].name"/></p>
        </c:forEach>




        <p><input type="submit" id="signUp" value="Update Product"></p>

    </form:form>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>
