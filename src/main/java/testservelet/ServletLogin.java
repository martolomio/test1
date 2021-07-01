package testservelet;

import dao.service.implService.UserServiceImpl;
import domain.User;
import dao.service.UserService;
import domain.UserLog;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)){
            UserLog userLog = new UserLog();
            userLog.pass = "cadinet.jsp";
            userLog.email = user.getEmail();

            request.setAttribute("userEmail", email);
            request.getRequestDispatcher("cadinet.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
