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

import DAO.AddFeeDAO;
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
        response.setContentType("text/html;charset=UTF-8");
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
                
                request.setAttribute("accid", accid);
                String action = request.getParameter("action");
                
                if (action != null)
                    if (action.equals("paid")) {
                    int orderID = Integer.parseInt(request.getParameter("orderID"));
                    try {
                        odao.updateStatus(orderID);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
        response.setContentType("text/html;charset=UTF-8");
        String orderId = request.getParameter("orderid");
        String dmgPercent = request.getParameter("damagePercent");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String afterPic = request.getParameter("afterLink");
        String prePic = request.getParameter("preLink");
        int exDistance = Integer.parseInt(request.getParameter("exDistance"));
        // get accountID from session
        int accid = Integer.parseInt(request.getParameter("accountID"));
        ReportDAO rdao = new ReportDAO();
        int orderIdS = Integer.parseInt(orderId);
        int reportPercent = Integer.parseInt(dmgPercent);
        // redirect to driverOrderList.jsp
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
        // add report
        rdao.addReport(orderIdS, reportPercent, title, content, afterPic, prePic, exDistance);
        ProductDAO pdao = new ProductDAO();
        // TODO add fee
        AddFeeDAO fdao = new AddFeeDAO();
        int reportID = rdao.getreportIdByOrderId(orderIdS);
        int fee = 0;
        fee = exDistance * 1000 + reportPercent * 100;// change fee calculation
        if (exDistance > 0 || reportPercent > 0) {
            try {
                if (exDistance > 0 && reportPercent == 0) {
                    fdao.addFee(reportID, "extra distance", fee, "charge for extra distance", 1);
                } else if (exDistance == 0 && reportPercent > 0) {
                    fdao.addFee(reportID, "vehicle damage", fee, "charge for vehicle damage", 1);
                } else
                    fdao.addFee(reportID, "extra Fee", fee, "charge for damage and extra distance", 1);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // update product status after submit report
//        pdao.changeProductStatus(o.getProductId(), "1");

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
                pdao = new ProductDAO();
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
