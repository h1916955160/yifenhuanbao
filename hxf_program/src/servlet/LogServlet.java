package servlet;
import user.user_reg;
import dao.UserDao;
import dao.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogServlet")
public class LogServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        user_reg user=new user_reg();
        //获取login.jsp页面提交的账号和密码
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        //测试数据
        System.out.println(account+" "+password);
        //获取login.jsp页面提交的账号和密码设置到实体类User中
        user.setAcount(Integer.parseInt(account));
        user.setPassward(Integer.parseInt(password));

        //引入数据交互层
        UserDao dao=new UserDaoImpl();
        user_reg us=dao.login(user);
        //测试返回的值
        System.out.println(us);
        if(us!=null){
            request.setAttribute("info", "登陆成功");
            request.setAttribute("user_info",us);
            request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        }else{
            request.setAttribute("info", "登录失败");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }


    }
}
