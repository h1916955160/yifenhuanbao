package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import user.user_reg;
import dao.UserDao;
import dao.UserDaoImpl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "servlet.RegServlet")
public class RegServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // 数据库连接Connection
    /*private Connection conn;

    // 初始化方法
    public void init() throws ServletException {
        super.init();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 数据库连接url
            String url = "jdbc:mysql://localhost:3307/user_info?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            // 获取数据库连接
            conn = DriverManager.getConnection(url, "root", "1916955160huang");
            System.out.println("数据库连接成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        user_reg user =new user_reg();
        // 获取表单中属性值
        String acount = request.getParameter("account");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String username = request.getParameter("username");
        String addr = request.getParameter("addr");
        String email = request.getParameter("email");

        user.setAcount(Integer.parseInt(acount));
        user.setPassward(Integer.parseInt(password));
        user.setName(username);
        user.setSex(sex);
        user.setAddr(addr);
        user.setEmail(email);

        UserDao U_dao = new UserDaoImpl();
        System.out.println(username);
        boolean flag= false;
        try {
            flag = U_dao.register(user);
            PrintWriter out = response.getWriter();
            if(flag)
            {
                //request.setAttribute("info","注册成功");

                out.print("<script>alert('register success!');window.location.href='jsp/main.jsp'</script>");
            }else
            {
                out.print("<script>alert('register fail!');window.location.href='index.jsp'</script>");
                //request.setAttribute("info","注册失败");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("jsp/main.jsp").forward(request, response);

        /*if (conn != null)
        {
            try {
                // 插入注册信息的SQL语句(使用?占位符)
                // 插入注册信息的SQL语句(使用?占位符)
                String sql = "insert into user(user_id,user_pwd,user_na,user_xb,user_addr,user_em) "
                        + "values(?,?,?,?,?,?)";
                // 创建PreparedStatement对象
                PreparedStatement ps = conn.prepareStatement(sql);
                // 对SQL语句中的参数动态赋值
                ps.setString(1, acount);
                ps.setString(2, password);
                ps.setString(3, username);
                ps.setString(4, sex);
                ps.setString(5, addr);
                ps.setString(6, email);

                // 执行更新操作
                ps.executeUpdate();
                // 获取PrintWriter对象
                PrintWriter out = response.getWriter();
                // 输出注册结果信息
                out.print("<h1 aling='center'>");
                out.print(username + "注册成功！");
                out.print("</h1>");
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            {
                // 发送数据库连接错误提示信息
                response.sendError(500, "数据库连接错误！");
            }*/




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            this.doPost(request,response);
    }
}
