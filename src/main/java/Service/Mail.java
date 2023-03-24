package Service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.Customer;
import entity.Report;
import entity.additionFee;

public class Mail {

    private String host;
    private int port;
    private boolean debug;

    private String username;
    private String password;

    private String senderEmail;

    public Mail() {

        host = "smtp.gmail.com";
        port = 587;
        debug = true;

        username = "fgoandrun@gmail.com";
        password = "vkckesqirtzdcwgp";

        senderEmail = "fgoandrun@gmail.com";
    }

    public Mail(String host, int port, String username, String password, String senderEmail) {

        this.host = host;
        this.port = port;
        this.debug = true;

        this.username = username;
        this.password = password;

        this.senderEmail = senderEmail;
    }

    public void sendMail(String to, int orderId, Report report, additionFee additionFee, String customerName) {

        // Set Properties
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", debug);
        props.put("mail.smtp.socketFactory.port", port);
        // props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.ssl.trust", host);
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create the Session Object
        Session session = Session.getDefaultInstance(
                props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);

            // From
            message.setFrom(new InternetAddress(senderEmail));

            // Reply To
            message.setReplyTo(InternetAddress.parse(senderEmail));

            // Recipient
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Subject
            message.setSubject("F-GO - Addition Fee for order " + orderId);
            String imgLink = "https://i.ibb.co/cQwzFKZ/qrcode.jpg";
            String content = "<html><body><h1>Hi " + customerName + ",</h1><br><br>"
                    + "<p>There is an addition fee for your order (orderID:" + orderId + ").</p>"
                    + "<p>Report: " + additionFee.getTitle() + "</p>"
                    + "<p>Fee: " + additionFee.getFee() + "</p>"
                    + "<p>Reason: " + additionFee.getReason() + "</p>"
                    + "<p>Damage to vehicle(percentage)" + report.getDamagePercent() + "</p>"
                    + "<p>Exceed distance(Km)" + report.getExDistance() + "</p>"
                    + "<p>We accept payment through MoMo</p>"
                    + "<img src=" + imgLink + ">"
                    + "<p>Thanks for using F-GO.</p>"
                    + "<p>Regards,</p>"
                    + "<p>F-GO Team</p>"
                    + "</body></html>";
            // Content
            message.setContent(content, "text/html; charset=utf-8");
            System.out.println("Sending email...");
            Transport.send(message);

        } catch (MessagingException exc) {

            throw new RuntimeException(exc);
        }
    }
    public boolean sendAuth(String email,String code) {
            boolean test = false;
            // Set Properties
            Properties props = new Properties();

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", debug);
            props.put("mail.smtp.socketFactory.port", port);
            // props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.ssl.trust", host);
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

            // Create the Session Object
            Session session = Session.getDefaultInstance(
                    props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                MimeMessage message = new MimeMessage(session);

                // From
                message.setFrom(new InternetAddress(senderEmail));

                // Reply To
                message.setReplyTo(InternetAddress.parse(senderEmail));

                // Recipient
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("fgoandrun@gmail.com"));

                // Subject
                message.setSubject("F-GO - Authentication");
                String content = "Registered successfully.Please verify your account using this code: " + code;
                // Content
                message.setContent(content, "text/html; charset=utf-8");
                System.out.println("Sending email...");
                Transport.send(message);

                test=true;
            } catch (MessagingException exc) {
                throw new RuntimeException(exc);
            }
            return test;
    }
    //generate verification code
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    public boolean sendOtp(String email,String code) {
        boolean test = false;
        // Set Properties
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", debug);
        props.put("mail.smtp.socketFactory.port", port);
        // props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.ssl.trust", host);
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create the Session Object
        Session session = Session.getDefaultInstance(
                props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);

            // From
            message.setFrom(new InternetAddress(senderEmail));

            // Reply To
            message.setReplyTo(InternetAddress.parse(senderEmail));

            // Recipient
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            // Subject
            message.setSubject("F-GO send OTP");
            String content = "Mã OTP: " + code;
            // Content
            message.setContent(content, "text/html; charset=utf-8");
            System.out.println("Sending email...");
            Transport.send(message);
            test=true;
        } catch (MessagingException exc) {
            throw new RuntimeException(exc);
        }
        return test;
    }
}