package testservelet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserServece userService = UserServece.getUserServece();
        User user = userService.getUser(email);

        if(user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else if(user.getPassword().equals(password)) {
            request.setAttribute("userEmail", email);
            request.getRequestDispatcher("cadinet.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }
}
