<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/9 0009
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="user/save">点我跳转</a>
<br/>
 <%--   <form action="user/save" method="post">
        姓名: <input type="text" name="name"><br/>
        性别: <input type="text" name="sex"><br/>
        年龄: <input type="text" name="age"><br/>
        <input type="submit" value="提交">
    </form>

<br/><br/><br/>
<form action="user/arr" method="post">
    <input type="checkbox" value="1" name="arr">1
    <input type="checkbox" value="2" name="arr">2
    <input type="checkbox" value="3" name="arr">3
    <input type="checkbox" value="4" name="arr">4
    <input type="submit" value="提交">
--%>

    <br/><br/>
   <%-- <form action="user/list" method="post">
        <input type="text"  name="map[1].name">姓名
        <input type="text"  name="map[1].sex"> 性别
        <input type="text"  name="map[1].age"> 年龄

        <br><br>
        <input type="text"  name="map['one'].name">姓名
        <input type="text"  name="map['one'].sex"> 性别
        <input type="text"  name="map['one'].age"> 年龄


        <input type="submit" value="提交">
</form>--%>
<form action="user/toDate" method="post">
    <input type="text"  name="name">姓名
    <input type="text"  name="time"> 生日
    <input type="text"  name=age"> 年龄

    <input type="submit" value="提交">

    </form>
</body>
</html>
