/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package DriverControl;

import DAO.CustomerDAO;
import DAO.DriverDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import entity.Customer;
import entity.Order;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "NullDriverControl", urlPatterns = {"/nulldriver"})
public class NullDriverControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NullDriverControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NullDriverControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accid = request.getParameter("accountID");
        String action = request.getParameter("action");
        
        if(action != null)
        if (action.equals("update")){
                doPost(request, response);
            } 
        int id = 0;
        if(accid != null)
        id = Integer.parseInt(accid);
        OrderDAO odao = new OrderDAO();
        CustomerDAO custormerdao = new CustomerDAO();
        ProductDAO pdao = new ProductDAO();
        DriverDAO ddao = new DriverDAO();
        
//        Order o = odao.getAllOrder();
//        int driverid = Order.getDriverId();
        List<Order> listo = odao.getAllOrder();
        List<Order> listNull = new ArrayList<Order>();
        List<Customer> listc = custormerdao.getAllCustomer();
        List<Product> listp = pdao.getAllProduct();
        for(Order o : listo){
            if(o.getDriverId() == 0 ){
                listNull.add(o);
            }
        }
        int driverID = ddao.getDriverId(id);
        request.setAttribute("driverID", driverID);
        request.setAttribute("listO", listNull);
        request.setAttribute("listC", listc);
        request.setAttribute("listP", listp);
        request.setAttribute("accid", accid);
        request.getRequestDispatcher("listNullDriver.jsp").forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
