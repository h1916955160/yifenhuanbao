<%@ page import="user.garbage" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Tay
  Date: 2019/10/30
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>垃圾搜索</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table">
    <caption>垃圾搜索为模糊搜索，，如“土”对应“土豆”、“渣土”、“尘土”等</caption>
    <thead>
    <tr>
        <th>#</th>
        <th>查询垃圾名</th>
        <th>垃圾分类</th>
        <th>垃圾详情</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<garbage> garbageList = (ArrayList<garbage>)request.getAttribute("user_list");
        session.setAttribute("detail_garbage",garbageList);
        int len = (int)request.getAttribute("list_size");
        for(int i=0;i<len;i++){
    %>
    <tr>
        <td><%= i%></td>
        <td><%=garbageList.get(i).getGarbage_name()%></td>
        <td><%=garbageList.get(i).getGarbage_type()%></td>
        <td><a href="jsp/main.jsp?id=<%=i%>&name=id">详情</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
