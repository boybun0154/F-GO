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

import DAO.OrderDAO;
import entity.Order;

@WebServlet("/productAjax")
public class ProductAjaxServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ProductAjaxServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        OrderDAO oDao = new OrderDAO();
        List<Order> orders = oDao.getOrdersTime();
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(orders));
        System.out.println(gson.toJson(orders));
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}