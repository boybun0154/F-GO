package Controllers.Authentication.Login;

import Service.Mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bin
 */
@WebServlet(name = "ForgotPassword", urlPatterns = {"/forgotPassword"})
public class ForgotPassword extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        try (PrintWriter out = response.getWriter()) {
            if (email != null || !email.equals("")) {
                //create instance object of the SendEmail Class
                Mail service = new Mail();
                //get the 6-digit code
                String code = service.getRandom();

                boolean test = service.sendOtp(email, code);
                //check if the email send successfully
                if(test){
                    request.setAttribute("message", "Mã OTP đã được gửi vào địa chỉ email của bạn! \nNếu không nhận được mã OTP, vui lòng kiểm tra lại địa chỉ Email của bạn.");
                    //request.setAttribute("connection", con);
                    HttpSession mySession = request.getSession();
                    mySession.setAttribute("otp", code);
                    mySession.setAttribute("email", email);
                    request.getRequestDispatcher("EnterOtp.jsp").forward(request, response);
                }else{
                    out.println("Failed to send verification email");
                }
            }
        }
    }
}
