<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <h3>文件上传___传统方式</h3>
    <form action="/user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>
    <hr/>

    <h3>文件上传___SpringMVC方式</h3>
    <form action="/user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>
    <hr/>

</body>
</html>
