<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>login</title>
</head>
<body>
<form action="/login" method="post">
    <div style="text-align: center">
        用户名：<input type="text" id="userName" name="userName"/><br/>
        密码：<input type="text" id="password" name="password"/><br/>
        <input type="submit" value="提交"/>
    </div>
</form>
</body>
</html>