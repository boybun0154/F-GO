package UserControl;

import DAO.CustomerDAO;
import Service.Mail;
import entity.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserVerify", urlPatterns = {"/UserVerify"})
public class UserVerify extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //fetch params value
            String id = request.getParameter("cusid");
            CustomerDAO cdao = new CustomerDAO();

            Customer c = cdao.getCustomerByID(id);

            //create instance object of the SendEmail Class
            Mail service = new Mail();
            //get the 6-digit code
            String code = service.getRandom();

            //call the send email method
            boolean test = service.sendAuth(c,code);

            //check if the email send successfully
            if(test){
                HttpSession session  = request.getSession();
                session.setAttribute("authcode", code);
                request.setAttribute("detail", c);
                request.getRequestDispatcher("verify.jsp").forward(request,response);
            }else{
                out.println("Failed to send verification email");
            }

        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

