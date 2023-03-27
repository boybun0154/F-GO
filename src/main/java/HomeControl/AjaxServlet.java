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

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AjaxServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        ProductDAO pDao = new ProductDAO();
        List<Product> products = pDao.getProductFList();
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(products));
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}