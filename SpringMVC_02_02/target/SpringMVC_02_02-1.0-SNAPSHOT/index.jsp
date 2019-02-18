<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <script src="js/jquery.min.js"></script>
    <script>

        $(function () {
            $("#lock").click(function () {
               // alert("aaa")
                $.post("user/testAjax",{"username":"zhangsan","password":"123"},function (data) {

                    alert(data)
                },"json")
            });
        })

    </script>

<body>
<h2>Hello World!</h2>

<br><br>
<a href="user/forward">forward...</a>
<br><br>
<a href="user/redirect">redirect...</a>
<br><br>
<input type="button" value="发送Ajax请求" id="lock">

</body>
</html>
