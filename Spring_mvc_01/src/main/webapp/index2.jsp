<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index2</title>
</head>
<body>
    <h1>这是主页面2</h1>

    <%--@RequestParam注解--%>
    <a href="/anno/testRequestParam?name=嘻嘻">RequestParam</a>
    <hr/>

    <%--@RequestBody注解--%>
    <form action="/anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交"/>
    </form>
    <hr/>

    <%--@PathVariable注解--%>
    <a href="/anno/testPathVariable/100">testPathVariable</a>
    <hr/>

    <%--@RequestHeader注解--%>
    <a href="/anno/testRequestHeader">testRequestHeader</a>
    <hr/>

    <%--@CookieValue注解--%>
    <a href="/anno/testCookieValue">testCookieValue</a>
    <hr/>

    <%--@ModelAttribute注解1--%>
    <form action="/anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="name"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交"/>
    </form>
    <hr/>

    <%--@ModelAttribute注解2--%>
    <form action="/anno/testModelAttribute2" method="post">
        用户姓名：<input type="text" name="name"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交"/>
    </form>
    <hr/>

    <%--@SessionAttributes注解--%>
    <a href="/anno2/testSessionAttributes">SessionAttributes</a>
    <hr/>
    <%--从Session域取值--%>
    <a href="/anno2/getSessionAttributes">GetSessionAttributes</a>
    <hr/>
    <%--清除Session域--%>
    <a href="/anno2/deleteSessionAttributes">DeleteSessionAttributes</a>

</body>
</html>
