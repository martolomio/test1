package testservelet;

import dao.service.BucketService;
import dao.service.ProductService;
import dao.service.implService.BucketServiceImpl;
import dao.service.implService.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "BucketServlet", value = "/BucketServlet")
public class BucketServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BucketService bucketService = new BucketServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("product_id");
        String purchaseDate = request.getParameter("purchase_date");

    }
}
