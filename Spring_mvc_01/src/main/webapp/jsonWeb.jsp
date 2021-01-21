<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsonWeb</title>
    <script src="js/jquery-2.2.4.min.js"></script>

    <script>
        //页面加载，绑定点击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn~");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"json/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"张三","password":"123","age":18}',
                    dataType:"json",
                    type:"post",
                    success:function(data) {
                    }
                });
            });
        });
    </script>

    <script>
        //页面加载，绑定点击事件
        $(function () {
            $("#btn2").click(function () {
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"json/testJSON",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"张三","password":"123","age":18}',
                    dataType:"json",
                    type:"post",
                    success:function(data) {
                        //data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>

</head>
<body>
    <button id="btn">模拟异步请求响应</button>
    <hr/>
    <button id="btn2">响应json格式数据</button>

</body>
</html>
