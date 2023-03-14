/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package DriverControl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
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
        Integer id = Integer.parseInt(accid);
        DriverDAO dao = new DriverDAO();
        int driverID = dao.getDriverId(id);
        if (driverID < 0) {
            throw new IllegalStateException("Driver is not available");
        } else {
            int orderID = dao.getDriverOrderID(driverID);
            if (orderID < 0) {
                throw new IllegalStateException("Order is not available");
            } else {
                OrderDAO odao = new OrderDAO();
                Order o = odao.getOrderById(String.valueOf(orderID));
                request.setAttribute("Order", o);
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

        ReportDAO rdao = new ReportDAO();
        int reportId = Integer.parseInt(orderId);
        int reportPercent = Integer.parseInt(dmgPercent);
        rdao.addReport(reportId, reportPercent, title, content, afterPic, prePic);
        System.out.println(orderId + " " + dmgPercent + " " + title + " " + content + " " + afterPic + " " + prePic);
        //TODO: redirect to driverOrderList.jsp
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
