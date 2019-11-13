<%@ page import="java.util.ArrayList" %>
<%@ page import="user.invitation" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dao.UserDaoImpl" %>
<%@ page import="user.Message_port" %>
<%@ page import="user.user_reg" %><%--
  Created by IntelliJ IDEA.
  User: Tay
  Date: 2019/11/2
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>帖子实现评论</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    //取出用户ID，并从帖子表中找出所有帖子
    ArrayList<invitation> inv_list;
    UserDao dao = new UserDaoImpl();
    user_reg user =(user_reg) session.getAttribute("user");
    inv_list = dao.post_invitation(user.getAcount(),-1);//帖子集合
    if(inv_list.isEmpty())
    {
        request.setAttribute("post_info","没有帖子或者显示失败");
    }
    else{
        request.setAttribute("post_info","显示成功");
        session.setAttribute("inv_list",inv_list);
    }

%>
<div class="container">
    <div class="row">
        <p><%=request.getAttribute("post_info")%></p>
        <a href="test.jsp">与我相关</a>
    </div>
</div>
    <%
        //循环输出帖子
        for(int i=0;i<inv_list.size();i++)
        {
    %>
    <!-- 打印帖子 标题、时间、内容、作者-->
<div class="container">

    <!-- 打印文章标题，作者，时间-->
    <div class="row">
        <div class="col-md -3">
            <a href="search.jsp">文章标题：<%= inv_list.get(i).getPost_topic()%></a>
        </div>
        <div class="col-md-3">
            <a>作者：<%=inv_list.get(i).getUser_id()%></a>
        </div>
        <div class="col-md-3">
            <p> <%=inv_list.get(i).getPost_time()%></p>
        </div>
    </div>

    <!-- 打印文章帖子内容-->
    <div class="row">
        <p >文章内容：<%=inv_list.get(i).getPost_content()%></p>
    </div>

    <%
        //获取这个帖子的评论，并打印出来
        int t_id=inv_list.get(i).getPost_id();
        int u_id=inv_list.get(i).getUser_id();
        ArrayList<Message_port> message_list = dao.port_Message(t_id,u_id);
        //session.setAttribute("message_list",message_list);
        if(message_list.size()>0)
        {
        for(int j=0;j<message_list.size();j++)
        {
    %>
    <!-- 打印输出这个帖子的评论信息-->
    <div class="row">
            <%

                if(message_list.get(j).getMessage_port_id()==inv_list.get(i).getUser_id())
                {
            %>
            <div class="row">
                <p><a><%=message_list.get(j).getMessage_port_id()%></a>回复<a><%=message_list.get(j).getB_id()%></a>：<%=message_list.get(j).getMessage_content()%></p>
            </div>
            <%
                }else {
            %>
            <div>
                <p><a><%=message_list.get(j).getMessage_port_id()%></a>评论<a><%=message_list.get(j).getB_id()%></a>：<%=message_list.get(j).getMessage_content()%></p>
            </div>
            <%
                }
            %>
    </div>

    //打印评论时间
    <div class="row">
        <p><%=message_list.get(j).getMessage_time()%></p>
    </div>
    <%
        }
        }
    %>

    <!-- 表单传参，注意是在url后加的参数，如要该请注意-->
    <div class="row">
        <form action="${pageContext.request.contextPath}/servlet.CommentServlet?T_id=<%=inv_list.get(i).getPost_id()%>&U_id=<%=inv_list.get(i).getUser_id()%>&B_id=<%=inv_list.get(i).getUser_id()%>" method="post" >
            <div class="form-group">
                <textarea class="form-control" rows="3" name="comment_message"></textarea>
                <%
                    session.setAttribute("M_id",user.getAcount());
                %>
                <input type="submit" value="评论" style="text-align: right"/>
            </div>
        </form>
    </div>
</div>
    <%
        }
    %>


</body>
</html>
