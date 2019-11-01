package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import user.user_reg;
import dao.UserDao;
import dao.UserDaoImpl;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        user_reg user1 =new user_reg();
        user_reg user2 = new user_reg();
        //获取表单属性
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        String old_email = request.getParameter("old_email");
        String new_email = request.getParameter("new_email");
        String addr = request.getParameter("address");

        user1.setPassward(Integer.parseInt(old_password));
        user1.setEmail(old_email);

        user2.setPassward(Integer.parseInt(new_password));
        user2.setEmail(new_email);
        user2.setAddr(addr);

        UserDao U_dao = new UserDaoImpl();
        boolean flag= false;
        try{
            flag =U_dao.update(user1,user2);
            if(flag)
            {
                request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
