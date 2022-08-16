<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div>
    <form action="/calculate" method="post">
        <label for="number1">Number 1: </label>
        <input type="number" name="number1" id="number1">
        <select name="operator">
            <option value="add">Addition(+)</option>
            <option value="sub">Subtraction(-)</option>
            <option value="mul">Multiplication(X)</option>
            <option value="div">Division(/)</option>
        </select>
        <label for="number2">Number 2: </label>
        <input type="number" name="number2" id="number2">
        <button type="submit">calculate</button>
    </form>
    <h5>Result: ${result}</h5>
</div>
<script>

</script>
</body>
</html>
