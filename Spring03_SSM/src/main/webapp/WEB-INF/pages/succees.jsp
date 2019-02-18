<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/12 0012
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.11.0.min.js"></script>
    <script>
      /*  $(function () {
            $("#submi").click(function () {
                alert("hehhe")
                var id= $("#delete").value;
                alert(id)
                $.get("user/delet",{id:id})
            })
        })
*/
    </script>
</head>
<body>

   <c:if test="${! empty requestScope.list}">

    <table border="1" align="center">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>sex</th>
            <th>money</th>
        </tr>
    <c:forEach items="${requestScope.list}" var="ssm">
        <tr>
            <td>${ssm.id}</td>
            <td>${ssm.name}</td>
            <td>${ssm.sex}</td>
            <td>${ssm.money}</td>
        </tr>
    </c:forEach>
    </table>


   </c:if>
       <form action="/user/delete" method="post">
       <input type="text" name="ssmid" id="delete">
       <input type="submit" value="确定" id="submi">
       </form>
</body>
</html>
