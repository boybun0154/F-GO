/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package DriverControl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AddFeeDAO;
import DAO.DriverDAO;
import DAO.OrderDAO;
import DAO.ReportDAO;
import Service.Mail;
import entity.Report;
import entity.additionFee;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "EmailServlet", urlPatterns = { "/EmailServlet" })
public class EmailServlet extends HttpServlet {

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
            out.println("<title>Servlet EmailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmailServlet at " + request.getContextPath() + "</h1>");
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
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        int reportID = Integer.parseInt(request.getParameter("reportID"));
        OrderDAO orderDAO = new OrderDAO();
        String mail = orderDAO.getCustomerMail(orderID);
        String customerName = orderDAO.getCustomerName(orderID);
        DriverDAO driverDAO = new DriverDAO();
        String driverName = driverDAO.getDriverName(orderID);
        ReportDAO reportDAO = new ReportDAO();
        Report report = reportDAO.getReportById(reportID);
        AddFeeDAO addFeeDAO = new AddFeeDAO();
        additionFee additionFee = null;
        try {
            additionFee = addFeeDAO.getFeeByReportID(reportID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Mail service = new Mail();
        if (report != null || additionFee != null) {

            service.sendMail(mail, orderID, report, additionFee, customerName, driverName);
            request.getRequestDispatcher("/ReportEditServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/ReportEditServlet").forward(request, response);
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
