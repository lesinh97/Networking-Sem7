package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Controller.CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = null;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserBean user = new UserBean();
            user.setUserName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user = UserDAO.login(user);
            if (user.isValid())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser",user);
                response.sendRedirect("userLogged.jsp");
            }
            else {
                response.sendRedirect("invailLogin.jsp");
            }
        } catch (Throwable ex) {
            System.out.println(ex);
        }
    }
}
