<%@ page import="user.user_reg" %><%--
  Created by IntelliJ IDEA.
  User: Tay
  Date: 2019/11/3
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%
    user_reg user =(user_reg) request.getAttribute("user_info");
    session.setAttribute("user",user);
%>
<a href="${pageContext.request.contextPath}/jsp/invitation.jsp">进入论坛界面</a>

<!-- 帖子提交表单 -->
<div class="container">
    <form action="${pageContext.request.contextPath}/servlet.ReplyServlet">
        <div class="row">
            <p>输入标题：<input type="text" name = "post_topic" id="post_topic "></p>
            <p>输入内容：<textarea class="form-control" rows="3" name="post_message"></textarea></p>
            <% session.setAttribute("user_id",user.getAcount());%>
            <input type="submit" value="发表帖子" style="text-align: right"/>
        </div>
    </form>
</div>
</body>
</html>
