/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserControl;

import DAO.CustomerDAO;
import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ADMIN
 */
@MultipartConfig(
        location = "D:\\Intellij\\F-GO\\src\\main\\webapp\\images",
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "EditCustomerControl", urlPatterns = {"/edit_customer"})
public class EditCustomerControl extends HttpServlet {

    private static final long SerialVersionUID = 1L;

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String cid = request.getParameter("id");
        String cname = request.getParameter("name");
        String cphone = request.getParameter("phone");
        String cemail = request.getParameter("email");
        String cfaceImg = request.getParameter("faceLink");
        String cnationalId = request.getParameter("idLink");
        String cdrivinglicense = request.getParameter("licenseLink");
//        Part partImg = request.getPart("nationalId");
//        String cnationalId = getFileName(partImg);
//        Part partImg2 = request.getPart("drivinglicense");
//        String cdrivinglicense = getFileName(partImg2);
//        Part partImg3 = request.getPart("faceImg");
//        String cfaceImg = getFileName(partImg3);
//        try {
//            Part partUpload = request.getPart("nationalId");
//            partUpload.write(getFileName(partUpload));
//        } catch (Exception e) {
//        }
//        try {
//            Part partUpload = request.getPart("drivinglicense");
//            partUpload.write(getFileName(partUpload));
//        } catch (Exception e) {
//        }
//        try {
//            Part partUpload = request.getPart("faceImg");
//            partUpload.write(getFileName(partUpload));
//        } catch (Exception e) {
//        }

        CustomerDAO cdao = new CustomerDAO();
        Customer c = cdao.getCustomerByID(cid);

        int caccountId = c.getAccountId();

        System.out.println(cname + " " + cphone + " " + cemail + " " + cnationalId + " " + cdrivinglicense + " " + cid + " " + cfaceImg);

        cdao.editCustomer(cname, cphone, cemail, cnationalId, cdrivinglicense, 0, cfaceImg, cid);
//          response.sendRedirect("viewprofile?accountID=" + caccountId);
        String url = "viewprofile?accountID=" + caccountId;
        out.println("<meta http-equiv='refresh' content='3;URL=" + url + "'>");//redirects after 3 seconds
        out.println("<div style=\"width: 100vw; height: 100vh;\">\n"
                + "<div class=\"success-msg\" style=\"color: #270;background-color: #DFF2BF;margin: 10px 0;padding: 10px;border-radius: 3px 3px 3px 3px; width: 640px; margin:0 auto;\">\n"
                + "  <img src=\"https://cdn-icons-png.flaticon.com/512/5290/5290058.png\" style=\"width: 16px;\">\n"
                + "  Cập nhật thông tin thành công! Hệ thống đang cập nhật thông tin của bạn.\n"
                + "</div>\n"
                + "</div>");
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

//    private String getFileName(Part part) {
//        final String partHeader = part.getHeader("content-disposition");
//        System.out.println("*****partHeader :" + partHeader);
//        for (String content : part.getHeader("content-disposition").split(";")) {
//            if (content.trim().startsWith("filename")) {
//                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
//            }
//        }
//        return null;
//    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
