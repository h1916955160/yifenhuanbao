package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import user.Message_port;
import user.invitation;
import user.user_reg;
import utils.DBUtil;

@WebServlet(name = "ReplyServlet")
public class ReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        //获取帖子的相关信息
        int user_id =(int)request.getSession().getAttribute("user_id");//用户id
        String T_topic = request.getParameter("post_topic");//帖子标题
        String T_content = request.getParameter("post_message");//帖子内容
        Date date = new Date();//发表帖子时间

        List<Object> list = new ArrayList<>();//对象数组，用于后面给sql语句传参
        list.add(user_id);
        list.add(T_topic);
        list.add(T_content);
        list.add(date);

        //从帖子表中查找本用户已发帖子数，后面把值加一，存进对象数组，然后，供帖子插入数据库用
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        int temp=1;//临时变量，存储帖子数
        try {
            con = DBUtil.getCon();
            String sql1 = "SELECT COUNT(*) as num FROM invitation.post_t WHERE user_id = ? ";//取出帖子数
            ps=con.prepareStatement(sql1);
            ps.setObject(1,user_id);
            rs=ps.executeQuery();
            while (rs.next())
            {
                temp=rs.getInt("num")+1;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        //插入帖子的数据进帖子表
        boolean flag = false;
        String sql = "INSERT INTO post_t VALUE(?,?,?,?,? )";
        list.add(temp);
        try {
            flag = DBUtil.addUpdateDelete(sql, list.toArray());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if(flag)
        {
            //request.setAttribute("flag",true);

            request.getRequestDispatcher("/jsp/invitation.jsp").forward(request, response);
            //request.getRequestDispatcher("/jsp/invitation.jsp").forward(request, response);
        }
        else
        {
            //request.setAttribute("flag",false);
            request.getRequestDispatcher("/jsp/invitation.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
