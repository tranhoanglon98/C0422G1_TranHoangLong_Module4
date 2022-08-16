<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/validate" method="get">
    <span>Email:</span>
    <input type="text" placeholder="Enter your email" name="email">
    <button type="submit">Validate</button>
    <p>Result: ${result}</p>
</form>
</body>
</html>
