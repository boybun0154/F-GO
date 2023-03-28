package UserControl;

import AdminControl.AddOrderControl;
import DAO.CustomerDAO;
import DAO.ProductDAO;
import PayPal.PaymentServices;
import UserDAO.CheckoutDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.paypal.base.rest.PayPalRESTException;
import com.vnpay.common.Config;
import entity.Customer;
import entity.Order;
import entity.Product;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bin
 */
@WebServlet(name = "CheckoutControl", urlPatterns = { "/checkout" })
public class CheckoutControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String accid = request.getParameter("accid");
        CustomerDAO cdao = new CustomerDAO();
        Customer customer = cdao.getCustomerByAccID(accid);
        int cid = customer.getCustomerId();
        int pid = Integer.parseInt(request.getParameter("pid"));
        String dateBegin = request.getParameter("dateBegin");
        String dateEnd = request.getParameter("dateEnd");
        String oaddress = request.getParameter("address");
        String oarea = request.getParameter("area");
        String ostartLocation = request.getParameter("startLocation");
        String oendLocation = request.getParameter("endLocation");

        // System.out.println(area + " " + startLocation + " " + endLocation);

        String payment_method = request.getParameter("payment_method");

        ProductDAO pdao = new ProductDAO();
        Product p = pdao.getProductById(String.valueOf(pid));

        int price = p.getPrice();

        int totalMoney;
        long diffrence = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date firstDate = sdf.parse(dateBegin);
            Date secondDate = sdf.parse(dateEnd);

            long diff = secondDate.getTime() - firstDate.getTime();
            TimeUnit time = TimeUnit.DAYS;
            diffrence = time.convert(diff, TimeUnit.MILLISECONDS);

        } catch (ParseException ex) {
            Logger.getLogger(AddOrderControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        totalMoney = (int) (price * diffrence);
        // System.out.println(cid + " " + pid + " " + dateBegin + " " + dateEnd + " " +
        // address + " " + totalMoney + " va" + area);

        CheckoutDAO checkoutdao = new CheckoutDAO();
        checkoutdao.addOrder(cid, pid, oaddress, totalMoney, dateBegin, dateEnd, oarea, ostartLocation, oendLocation);

        pdao.changeProductStatus(p.getProductID(), "0");

        if (payment_method.equals("momo")) {
            Order order = checkoutdao.getOrder();
            request.setAttribute("order", order);
            request.getRequestDispatcher("qrcode.jsp").forward(request, response);
        }
        if (payment_method.equals("paypal")) {
            Order order = checkoutdao.getOrder();

            try {
                PaymentServices paymentServices = new PaymentServices();
                String approvalLink = paymentServices.authorizePayment(order);

                response.sendRedirect(approvalLink);

            } catch (PayPalRESTException ex) {
                request.setAttribute("errorMessage", ex.getMessage());
                ex.printStackTrace();
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}