<%@ page import="java.util.ArrayList" %>
<%@ page import="user.invitation" %><%--
  Created by IntelliJ IDEA.
  User: Tay
  Date: 2019/11/3
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖子详情页面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    ArrayList<invitation> list = (ArrayList<invitation>)session.getAttribute("inv_list");
    int i=Integer.parseInt(request.getParameter("i"));
%>
<table class="table">
    <caption>用户：<%=list.get(i).getUser_id()%></caption>
    <thead>
    <tr>
        <th>新闻标题：<%=list.get(i).getPost_topic()%>  <%=list.get(i).getPost_time()%></th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%=list.get(i).getPost_content()%></td>
    </tr>
    </tbody>
</table>
</body>
</html>
