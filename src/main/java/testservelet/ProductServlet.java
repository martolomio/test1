package testservelet;

import dao.service.ProductService;
import dao.service.implService.ProductServiceImpl;
import domain.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("regist.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double price = Double.valueOf(request.getParameter("price"));

        Product product = new Product(name, description, price);
        productService.create(product);
//        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
        request.getRequestDispatcher("cadinet.jsp").forward(request, response);
    }
    private double getPrice(String price){
        if (price == null || price.isEmpty()){
            return 0;
        }
        return  Double.parseDouble(price);
    }
    private int getDescription(String description){
        if (description == null|| description.isEmpty()){
            return 0;
        }
        return  Integer.parseInt(description);
    }

    protected  void  doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
    }

}
