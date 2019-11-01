<%--
  Created by IntelliJ IDEA.
  User: Tay
  Date: 2019/10/28
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
        <form action="servlet.SearchServlet" method="post">
            <table align="left">
                <tr>

                    <td><input type="text" name="addr" id="addr"></td>
                </tr>

                <tr>
                    <td colspan="1">
                    </td>
                    <td>
                        <input type="submit" value="搜索"/>

                    </td>
                </tr>
            </table>
        </form>
</body>
</html>
