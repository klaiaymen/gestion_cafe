<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 26/11/2024
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<% String msg= (String)request.getAttribute("msg"); %>
<p><%=msg%></p>
    <form action="ServletValidate" method="post">
        <input type="text" name="login" required>
        <input type="text" name="mdp" required>
        <button type="submit">Login</button>
    </form>

</body>
</html>
