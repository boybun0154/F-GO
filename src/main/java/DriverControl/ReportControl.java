/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package DriverControl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CustomerDAO;
import DAO.DriverDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.ReportDAO;
import entity.Customer;
import entity.Order;
import entity.Product;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ReportControl", urlPatterns = { "/ReportControl" })
public class ReportControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReportControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String accid = request.getParameter("accountID");
        int id = Integer.parseInt(accid);
        DriverDAO dao = new DriverDAO();
        int driverID = 0;
        driverID = dao.getDriverId(id);
        if (driverID < 0) {
            throw new IllegalStateException("Driver is not available");
        } else {
            List orderIDList = dao.getDriverOrderID(driverID);
            if (orderIDList.size() == 0) {
                request.setAttribute("message", "You don't have any order");
                request.getRequestDispatcher("driverOrderList.jsp").forward(request, response);
            } else {
                OrderDAO odao = new OrderDAO();
                List<Order> list = new ArrayList<>();
                for (int i = 0; i < orderIDList.size(); i++) {
                    Order o = odao.getOrderById(orderIDList.get(i).toString());
                    list.add(o);
                }
                request.setAttribute("listO", list);
                CustomerDAO custormerdao = new CustomerDAO();
                ProductDAO pdao = new ProductDAO();
                List<Customer> listc = custormerdao.getAllCustomer();
                List<Product> listp = pdao.getAllProduct();
                request.setAttribute("listC", listc);
                request.setAttribute("listP", listp);
                request.setAttribute("accid", accid);
                request.getRequestDispatcher("driverOrderList.jsp").forward(request, response);
            }
        }
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
        String orderId = request.getParameter("orderid");
        String dmgPercent = request.getParameter("damagePercent");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String afterPic = request.getParameter("afterLink");
        String prePic = request.getParameter("preLink");
        // TODO: get accountID from session
        int accid = Integer.parseInt(request.getParameter("accountID"));
        ReportDAO rdao = new ReportDAO();
        int reportId = Integer.parseInt(orderId);
        int reportPercent = Integer.parseInt(dmgPercent);
        // TODO: redirect to driverOrderList.jsp
        // update driver status
        OrderDAO odao = new OrderDAO();
        Order o = odao.getOrderById(orderId);
        DriverDAO dao = new DriverDAO();
        int driverID = 0;
        driverID = dao.getDriverId(accid);
        // check if driver have any order
        if (dao.getDriverCurrentOrderID(accid).isEmpty()) {
            dao.updateDriverStatus(o.getDriverId(), "available");
        }
        // update order status
        odao.updateOrderStatus(Integer.parseInt(orderId), 0);
        // add report and finish order
        rdao.addReport(reportId, reportPercent, title, content, afterPic, prePic);
        //
        // display

        if (driverID < 0) {
            throw new IllegalStateException("Driver is not available");
        } else {
            List orderIDList = dao.getDriverOrderID(driverID);
            if (orderIDList.size() == 0) {
                request.setAttribute("message", "You don't have any order");
                request.getRequestDispatcher("driverOrderList.jsp").forward(request, response);
            } else {
                List<Order> list = new ArrayList<>();
                for (int i = 0; i < orderIDList.size(); i++) {
                    Order t = odao.getOrderById(orderIDList.get(i).toString());
                    list.add(t);
                }
                request.setAttribute("listO", list);
                CustomerDAO custormerdao = new CustomerDAO();
                ProductDAO pdao = new ProductDAO();
                List<Customer> listc = custormerdao.getAllCustomer();
                List<Product> listp = pdao.getAllProduct();
                request.setAttribute("listC", listc);
                request.setAttribute("listP", listp);
                request.getRequestDispatcher("driverOrderList.jsp").forward(request, response);
            }
        }
    }

    /**
     * RePurns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
