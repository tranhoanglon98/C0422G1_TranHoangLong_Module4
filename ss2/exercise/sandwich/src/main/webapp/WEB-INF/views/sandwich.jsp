<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>

<div class="mt-5">
    <div class="d-flex justify-content-center">
        <h3>Sandwich condiments</h3>
    </div>
    <div class="d-flex justify-content-center">
        <form action="/condiments" method="post">
            <c:forEach items="${condimentList}" var="condiment">
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" role="switch" value="${condiment}"
                           name="condiments" id="${condiment}">
                    <label class="form-check-label" for="${condiment}">${condiment}</label>
                </div>
            </c:forEach>
            <button type="submit" class="btn btn-outline-primary mt-2" style="width: 100%">Save</button>
        </form>
    </div>

    <div class="text-center">
        <h4>${mess}</h4>
        <c:if test="${condiments != null}">
            <h4>your condiments</h4>
            <c:forEach items="${condiments}" var="condiment">
                <p>${condiment}</p>
            </c:forEach>
        </c:if>
    </div>
</div>


<script src="<c:url value="/resources/javascript/bootstrap.min.js" />"></script>
</body>
</html>
