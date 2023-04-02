package HomeControl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.ProductDAO;
import entity.Product;

@WebServlet("/datefilterajax")
public class DateFilterAjax extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DateFilterAjax() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        ProductDAO pDao = new ProductDAO();
        List<Product> products = pDao.getProductBydate(startDate, endDate);
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(products));
        System.out.println(gson.toJson(products));
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}