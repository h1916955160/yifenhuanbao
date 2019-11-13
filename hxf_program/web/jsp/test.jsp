
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="user.invitation" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.UserDaoImpl" %>
<%@ page import="user.Message_port" %>
<%@ page import="user.user_reg" %>
<%--
  Created by IntelliJ IDEA.
  User: Tay
  Date: 2019/11/2
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <a>.....</a>
    <a href="invitation.jsp">返回帖子页面</a>
</div>

<%
        user_reg user = (user_reg)session.getAttribute("user");
        int U_id= user.getAcount();//得到登录用户ID
        UserDao dao = new UserDaoImpl();
        ArrayList<Message_port> m_list = dao.port_Message(-1,U_id);//评论

        if(m_list.size()>0)
        {
            for (int j=0;j<m_list.size();j++)
            {
                ArrayList<invitation> list1 = dao.post_invitation(m_list.get(j).getUser_id(),m_list.get(j).getPost_id());//帖子
                if(list1.size()>0)
                {
    %>
<div class="container">
    <div class="row">
        <p><a><%=m_list.get(j).getMessage_port_id()%></a>评论或者回复了你</p>
    </div>
    <div class="row">
        <p><%= m_list.get(j).getMessage_time()%></p>
        <br>
    </div>
    <div class="row">
        <p><a><%=list1.get(0).getUser_id()%></a>：<%=list1.get(0).getPost_content()%></p>
        <br>
    </div>
    <%
        ArrayList<Message_port> R_list = dao.port_Message1(list1.get(0).getPost_id(),list1.get(0).getUser_id(),m_list.get(j).getMessage_port_id());
        if(R_list.size()>0)
        for(int k=0;k<R_list.size();k++)
        {
    %><!-- 循环打印该条帖子及这个评论人相关的所有评论-->
    <div class="row">
        <%
            if(R_list.get(k).getMessage_port_id()==m_list.get(j).getMessage_port_id())
            {
        %>
        <p><a><%=R_list.get(k).getMessage_port_id()%></a>评论你：<%=R_list.get(k).getMessage_content()%></p>
        <%
            }else
            {
        %>
        <p><a><%=R_list.get(k).getMessage_port_id()%></a>回复<a><%=R_list.get(k).getB_id()%></a>：<%=R_list.get(k).getMessage_content()%></p>
        <% } %>
    </div>
    <%
            }
    %>
    <div class="row" id='input_box' >
        <form action="${pageContext.request.contextPath}/servlet.CommentServlet?T_id=<%=m_list.get(j).getPost_id()%>&U_id=<%=m_list.get(j).getUser_id()%>&B_id=<%=m_list.get(j).getMessage_port_id()%>" method="post" id="message_text">
                <textarea class="form-control" rows="1" name="comment_message" ></textarea>
                <input type="submit" value="回复" style="float: right">
        </form>
    </div>
</div>
    <%
                }
            }
        }
    %>

</body> 
</html>
