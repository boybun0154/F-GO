/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminControl;

import DAO.AdminDAO;
import entity.Admin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "AddAdminControl", urlPatterns = {"/addadmin"})
public class AddAdminControl extends HttpServlet {

    private static final long SerialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        AdminDAO admindao = new AdminDAO();
        List<Admin> list = admindao.getAllAdmin();
        request.setAttribute("listAdmin", list);
        request.getRequestDispatcher("manage-admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String aimage = request.getParameter("link");

        System.out.println(username + " " + password + " " + name + " " + phone + " " + aimage);

        AdminDAO admindao = new AdminDAO();

        try {
            admindao.addAdminacc(username, password, name, phone, aimage);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        out.println("<meta http-equiv='refresh' content='3;URL=manageadmin'>");//redirects after 3 seconds
        out.println("<div style=\"width: 100vw; height: 100vh;\">\n"
                + "<div class=\"success-msg\" style=\"color: #270;background-color: #DFF2BF;margin: 10px 0;padding: 10px;border-radius: 3px 3px 3px 3px; width: 640px; margin:0 auto;\">\n"
                + "  <img src=\"https://cdn-icons-png.flaticon.com/512/5290/5290058.png\" style=\"width: 16px;\">\n"
                + "  Cập nhật thông tin thành công! Hệ thống đang cập nhật thông tin của bạn.\n"
                + "</div>\n"
                + "</div>");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
