<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
</head>
<body>
    <%--响应返回值是String类型--%>
    <a href="/response/testString">testString</a><br/>
    <%--响应返回值是void类型--%>
    <a href="/response/testVoid">testVoid</a><br/>
    <%--响应返回值是ModelAndView类型--%>
    <a href="/response/testModelAndView">testModelAndView</a><br/>
    <%--响应返回值是forward进行页面跳转--%>
    <a href="/response/testForward">testForward</a><br/>
    <%--响应返回值是redirect进行页面跳转--%>
    <a href="/response/testRedirect">testRedirect</a><br/>

</body>
</html>

