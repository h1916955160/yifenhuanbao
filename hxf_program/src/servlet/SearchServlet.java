package servlet;

import dao.UserDao;
import dao.UserDaoImpl;
import user.garbage;
import user.user_reg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user_reg user=new user_reg();
        String user_addr = request.getParameter("addr");
        //user.setAddr(user_addr);

        UserDao dao = new UserDaoImpl();
        List<garbage> user_list = dao.search(user_addr);

        if(user_list.isEmpty())
        {
            request.setAttribute("search_info", "查询失败，数据库中未查询到相关信息");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else {
            request.setAttribute("search_info", "查询信息成功");
            request.setAttribute("user_list",user_list);

            int a = user_list.size();
            request.setAttribute("list_size",a);
            request.getRequestDispatcher("/jsp/show.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
