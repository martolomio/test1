package testservelet;

import dao.service.UserService;
import dao.service.implService.UserServiceImpl;
import domain.User;
import domain.UserAccess;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("regist.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
//        String access = null;
//
//        if("user".equals(request.getParameter("access"))){
//            access = UserAccess.USER.toString();
//        } else if("admin".equals(request.getParameter("access"))){
//            access = UserAccess.ADMIN.toString();
//        }

//        try {
//            userServece.saveUser(new User(firstName, lastName, email, password, access));
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            userService.create(new User(firstName, lastName, email, password, UserAccess.USER.toString()));
        }
//        HttpSession session = request.getSession(true);
//        session.setAttribute("userEmail", email);
//        session.setAttribute("userFirstname", firstName);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
        request.getRequestDispatcher("cadinet.jsp").forward(request, response);
	
	}

}
