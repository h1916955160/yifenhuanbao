<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/10/23
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息修改</title>
</head>
<body>
<form action="servlet.UpdateServlet" method="post" >
    <table align="left">
        <tr>
            <td>旧密码：</td>
            <td><input type="text" name="old_password" id="old_password"/></td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td><input type="password" name="new_password" id="new_password"/></td>
        </tr>
        <tr>
            <td>旧邮箱：</td>
            <td><input type="text" name="old_email" id="old_email"/></td>
        </tr>
        <tr>
            <td>新邮箱：</td>
            <td><input type="text" name="new_email" id="new_email"/></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input type="text" name="address" id="address"/></td>
        </tr>
        <tr>
            <td colspan="1">
            </td>
            <td>
                <input type="submit" value="保存"/>
                <input type="reset" value="重置"/>
                <a href="index.jsp" target="_blank">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
