/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminControl;

import AdminDAO.ProductDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
        location = "E:\\study\\Semester_5\\SWP391\\Project_FGO\\F-Go\\src\\main\\webapp\\images",
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet(name = "EditProductControl", urlPatterns = {"/edit_product"})
public class EditProductControl extends HttpServlet {

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
        String pid = request.getParameter("id");
        String pname = request.getParameter("name");
        String pcategory = request.getParameter("category");
        String pprice = request.getParameter("price");
        String pstatus = request.getParameter("status");
        String pseat = request.getParameter("seat");
        String pgear = request.getParameter("gear");
        String plicensePlate = request.getParameter("licensePlate");
        String pfuel = request.getParameter("fuel");
        String pcolor = request.getParameter("color");
        String pyearRelease = request.getParameter("yearRelease");
        String pdes = request.getParameter("des");
        
        Part partImg = request.getPart("image");
        String pimage = getFileName(partImg);
        try {
            Part partUpload = request.getPart("image");
            partUpload.write(getFileName(partUpload));
        } catch (Exception e) {
        }
        
        ProductDAO pdao = new ProductDAO();
        pdao.editProduct(pname, pdes, pimage, pprice, pstatus, pcategory, pseat, pgear, pcolor, plicensePlate, pfuel, pyearRelease, pid);
        System.out.println(pname + " " + pcategory + " " + pprice + " " + pseat + " " + pgear + " " + plicensePlate + " " + pfuel + " " + pcolor + " " + pimage + " " + pyearRelease + " " + pdes + " " + pstatus + " " + pid);
        response.sendRedirect("manageproduct");
    }


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


    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}