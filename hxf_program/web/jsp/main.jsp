<%@ page import="java.util.List" %>
<%@ page import="user.garbage" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/10/19
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
    恭喜<%=request.getAttribute("search_info")%><br>
    <%
        ArrayList<garbage> garbageList = (ArrayList<garbage>)session.getAttribute("detail_garbage");
        int i=Integer.parseInt(request.getParameter("id"));

    %>
    <a >垃圾名：<%=garbageList.get(i).getGarbage_name()%></a>
    <br>
    <a>垃圾详情:<%=garbageList.get(i).getGarbage_content()%></a>
    <br>
    <a>垃圾类别:<%=garbageList.get(i).getGarbage_type()%><br></a>
    <%

    %>

</body>
</html>
