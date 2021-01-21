<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick15" method="post">
        <%--表明是第一个User对象username age--%>
        <input type="text" placeholder="用户名1" name="userList[0].username"><br/>
        <input type="text" placeholder="年龄1" name="userList[0].age"><br/>
        <input type="text" placeholder="用户名2" name="userList[1].username"><br/>
        <input type="text" placeholder="年龄2" name="userList[1].age"><br/>
        <input type="submit" plvalue="提交">
    </form>
</body>
</html>