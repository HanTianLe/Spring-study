<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>这是主页面</h1>

<a href="/user/delete?accountName=htl&money=200">money为200</a><hr/>
<a href="/user/delete?accountName=htx&money=20">money为20</a><hr/>
<a href="/param/test1?username=htl&password=123">请求参数绑定</a><hr/>

<form action="/param/saveAccount" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>

<form action="/param/saveAccount2" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    用户姓名：<input type="text" name="user.name"/><br/>
    用户年龄：<input type="text" name="user.age"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>

<form action="/param/saveAccount3" method="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>

    用户姓名1：<input type="text" name="list[0].name"/><br/>
    用户年龄1：<input type="text" name="list[0].age"/><br/>

    用户姓名2：<input type="text" name="map['one'].name"/><br/>
    用户年龄2：<input type="text" name="map['one'].age"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>

<form action="/param/saveUser" method="post">
    用户姓名：<input type="text" name="name"/><br/>
    用户年龄：<input type="text" name="age"/><br/>
    用户生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交"/>
</form>
<hr/>

</body>
</html>
