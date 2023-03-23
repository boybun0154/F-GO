package UserControl;

import DAO.CustomerDAO;
import entity.Account;
import entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VerifyCode", urlPatterns = {"/VerifyCode"})
public class VerifyCode extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            int accid = a.getAccountID();

            CustomerDAO cdao = new CustomerDAO();
            Customer c = cdao.getCustomerByAccIDInt(accid);

            String authcode = (String) session.getAttribute("authcode");

            String code = request.getParameter("inputcode");

            if(code.equals(authcode)){
                out.println("Verification Done");
            }else{
                out.println("Incorrect verification code");
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

    