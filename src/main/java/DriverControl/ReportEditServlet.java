/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package DriverControl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AddFeeDAO;
import DAO.DriverDAO;
import DAO.ReportDAO;
import entity.Report;
import entity.additionFee;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ReportEditServlet", urlPatterns = { "/ReportEditServlet" })
public class ReportEditServlet extends HttpServlet {

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
            out.println("<title>Servlet ReportEditServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportEditServlet at " + request.getContextPath() + "</h1>");
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
        int accid;
        if (request.getParameter("accountID") != null) {
            accid = Integer.parseInt(request.getParameter("accountID"));
        } else {
            HttpSession session = request.getSession();
            accid = (int) session.getAttribute("accountID");
        }
        String action = request.getParameter("action");
        DriverDAO dao = new DriverDAO();
        int driver_id = dao.getDriverId(accid);
        ReportDAO rdao = new ReportDAO();
        List<Report> reports = rdao.getReportsbyDriverId(driver_id);
        AddFeeDAO fdao = new AddFeeDAO();
        List<additionFee> fees = null;
        try {
            fees = fdao.getFeeList();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (action != null)
            if (action.equals("paid")) {
                int reportId = Integer.parseInt(request.getParameter("reportID"));
                try {
                    fdao.updateStatus(reportId);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        HttpSession session = request.getSession();
        session.setAttribute("accountID", accid);
        request.setAttribute("accid", accid);
        request.setAttribute("reports", reports);
        request.setAttribute("feeList", fees);
        request.getRequestDispatcher("viewReport.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        ReportDAO rdao = new ReportDAO();
        rdao.deleteReportById(id);
        request.getRequestDispatcher("viewReport.jsp").forward(request, response);
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
