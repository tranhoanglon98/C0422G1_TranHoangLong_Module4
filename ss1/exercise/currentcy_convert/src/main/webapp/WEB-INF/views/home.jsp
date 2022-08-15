<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/currency" method="get">
    <select name="from">
        <c:choose>
            <c:when test="${from == null}">
                <option value="USD">USD</option>
                <option value="VND">VND</option>
            </c:when>
            <c:otherwise>
                <option value="${from}">${from}</option>
                <option value="${to}">${to}</option>
            </c:otherwise>
        </c:choose>
    </select>
    <input value="${amount}" type="text" name="amount">
    <button type="submit">convert</button>
    <p>Result:
        <c:if test="${errMap == null}">
            <span>${result} ${to}</span>
        </c:if>
        <span style="color: red">${errMap.get("amountErr")}</span></p>
</form>
</body>
</html>
