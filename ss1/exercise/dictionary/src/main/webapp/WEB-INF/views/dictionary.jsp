<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
</head>
<body style="background: linear-gradient(to right,#a8ff78,#78ffd6)">

<div class="mt-5">
    <div class="row text-center">
        <h3>Từ điển Anh - Việt</h3>
    </div>
    <form action="/search" method="get" class="row d-flex justify-content-center">
        <div class="col-lg-1">
            <label for="searchInput">Tiếng Anh:</label>
        </div>
        <div class="col-lg-4">
            <input type="text" name="word" id="searchInput" class="form-control" placeholder="Nhập từ bạn muốn tìm">
        </div>
        <div class="col-lg-1">
            <button style="width: 100%" type="submit" class="btn btn-outline-dark">Tìm</button>
        </div>
    </form>
    <div class="row d-flex justify-content-center">
        <div class="col-lg-1">
            <span>Tiếng Việt:</span>
        </div>
        <div class="col-lg-4">
            <input type="text" readonly value="${result}" class="form-control">
        </div>
        <div class="col-lg-1"></div>
    </div>
</div>


<link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
</body>
</html>
