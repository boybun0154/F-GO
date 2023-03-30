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

    public void sendMail(String to, int orderId, Report report, additionFee additionFee, String customerName, String driverName) {

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
            String content = "<!DOCTYPE html>\n" +
                    "\n" +
                    "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                    "<head>\n" +
                    "<title></title>\n" +
                    "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                    "<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                    "<style>\n" +
                    "\t\t* {\n" +
                    "\t\t\tbox-sizing: border-box;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tbody {\n" +
                    "\t\t\tmargin: 0;\n" +
                    "\t\t\tpadding: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\ta[x-apple-data-detectors] {\n" +
                    "\t\t\tcolor: inherit !important;\n" +
                    "\t\t\ttext-decoration: inherit !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t#MessageViewBody a {\n" +
                    "\t\t\tcolor: inherit;\n" +
                    "\t\t\ttext-decoration: none;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tp {\n" +
                    "\t\t\tline-height: inherit\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.desktop_hide,\n" +
                    "\t\t.desktop_hide table {\n" +
                    "\t\t\tmso-hide: all;\n" +
                    "\t\t\tdisplay: none;\n" +
                    "\t\t\tmax-height: 0px;\n" +
                    "\t\t\toverflow: hidden;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.image_block img+div {\n" +
                    "\t\t\tdisplay: none;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t@media (max-width:660px) {\n" +
                    "\n" +
                    "\t\t\t.desktop_hide table.icons-inner,\n" +
                    "\t\t\t.social_block.desktop_hide .social-table {\n" +
                    "\t\t\t\tdisplay: inline-block !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.icons-inner {\n" +
                    "\t\t\t\ttext-align: center;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.icons-inner td {\n" +
                    "\t\t\t\tmargin: 0 auto;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.image_block img.big,\n" +
                    "\t\t\t.row-content {\n" +
                    "\t\t\t\twidth: 100% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.mobile_hide {\n" +
                    "\t\t\t\tdisplay: none;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.stack .column {\n" +
                    "\t\t\t\twidth: 100%;\n" +
                    "\t\t\t\tdisplay: block;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.mobile_hide {\n" +
                    "\t\t\t\tmin-height: 0;\n" +
                    "\t\t\t\tmax-height: 0;\n" +
                    "\t\t\t\tmax-width: 0;\n" +
                    "\t\t\t\toverflow: hidden;\n" +
                    "\t\t\t\tfont-size: 0px;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.desktop_hide,\n" +
                    "\t\t\t.desktop_hide table {\n" +
                    "\t\t\t\tdisplay: table !important;\n" +
                    "\t\t\t\tmax-height: none !important;\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\t</style>\n" +
                    "</head>\n" +
                    "<body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 20px; padding-top: 20px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><a href=\"http://www.example.com/\" style=\"outline:none\" tabindex=\"-1\" target=\"_blank\"><img alt=\"Logo\" src=\"https://i.ibb.co/pjNm7FV/logo.png\" style=\"display: block; height: auto; border: 0; width: 192px; max-width: 100%;\" title=\"Logo\" width=\"192\"/></a></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 60px; padding-top: 60px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-left:10px;padding-right:10px;padding-top:30px;\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><span style=\"font-size:58px;\"><strong>Chào "+ customerName + ",</strong></span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><span style=\"font-size:34px;\"><strong>Chúng tôi gửi bạn hóa đơn phụ phí</strong></span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Image\" class=\"big\" src=\"https://i.ibb.co/sby67vm/image-01-5.png\" style=\"display: block; height: auto; border: 0; width: 481px; max-width: 100%;\" title=\"Image\" width=\"481\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"divider_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div align=\"center\" class=\"alignment\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 0px solid #FFFFFF;\"><span> </span></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; padding-top: 25px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"33.333333333333336%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Image\" src=\"https://i.ibb.co/FxX3s4R/icon-01-2.png\" style=\"display: block; height: auto; border: 0; width: 24px; max-width: 100%;\" title=\"Image\" width=\"24\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:15px;\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 21px; color: #0c2b5b; line-height: 1.5;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 21px;\">Order ID:</p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 21px;\"><strong>"+ orderId +"</strong></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; padding-top: 25px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"33.333333333333336%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Image\" src=\"https://i.ibb.co/tZ0zJpJ/icon-02-2.png\" style=\"display: block; height: auto; border: 0; width: 22px; max-width: 100%;\" title=\"Image\" width=\"22\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 21px; color: #0c2b5b; line-height: 1.5;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 21px;\">Ngày tạo:</p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 21px;\"><strong>"+ report.getDate() +"</strong></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; padding-top: 25px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"33.333333333333336%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Image\" src=\"https://i.ibb.co/JQnjHSK/icon-03-2.png\" style=\"display: block; height: auto; border: 0; width: 25px; max-width: 100%;\" title=\"Image\" width=\"25\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 21px; color: #0c2b5b; line-height: 1.5;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 21px;\">Tổng Tiền:</p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 21px;\"><strong>"+ additionFee.getFee() +"₫</strong></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 20px; padding-left: 30px; padding-right: 30px; padding-top: 20px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-left:10px;padding-right:10px;padding-top:10px;\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 16.8px;\"><span style=\"font-size:20px;\"><strong>Thông tin khách hàng:</strong></span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 21px; color: #0c2b5b; line-height: 1.5;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 21px;\">"+ customerName +"</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><strong>No.</strong></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><strong>TITTLE</strong></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><strong>CONTENT</strong></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-7\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">01</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">Tiêu đề</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">"+ report.getTitle() +"</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-8\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">02</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">Người tạo</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">"+ driverName +"</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-9\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">03</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">Lý do</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">"+ report.getContent() +"</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-10\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">04</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">Số km vượt giới hạn</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">"+ report.getExDistance() +"</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-11\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">05</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"25%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">Thiệt hại về xe</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; border-bottom: 1px solid #6DA3CD; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\">"+ report.getDamagePercent() +"%</p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-12\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 10px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 21px; color: #0c2b5b; line-height: 1.5;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 30px;\"><span style=\"font-size:16px;\">Phương thức thanh toán:</span><br/><span style=\"font-size:20px;\"><strong>MoMo</strong></span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 10px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"50%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 21px; color: #0c2b5b; line-height: 1.5;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 24px;\"><span style=\"font-size:16px;\">Tổng Tiền: <strong>"+ additionFee.getFee() +"₫</strong></span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-13\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"divider_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div align=\"center\" class=\"alignment\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 0px solid #5C98C7;\"><span> </span></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-14\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffde79; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 45px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img class=\"big\" src=\"https://i.ibb.co/cQwzFKZ/qrcode.jpg\" style=\"display: block; height: auto; border: 0; width: 518px; max-width: 100%;\" width=\"518\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-left:10px;padding-right:10px;padding-top:15px;\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #0c2b5b; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><span style=\"font-size:30px;\"><strong>Thank you!</strong></span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-15\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 15px; padding-top: 25px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"social_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div align=\"center\" class=\"alignment\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"social-table\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\" width=\"210px\">\n" +
                    "<tr>\n" +
                    "<td style=\"padding:0 5px 0 5px;\"><a href=\"http://www.example.com/\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"https://i.ibb.co/X8GTRPz/facebook2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"Facebook\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 5px 0 5px;\"><a href=\"http://www.example.com/\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"https://i.ibb.co/7v4rYC1/twitter2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"Twitter\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 5px 0 5px;\"><a href=\"http://www.example.com/\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"https://i.ibb.co/qptHqZ9/linkedin2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"Instagram\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 5px 0 5px;\"><a href=\"http://www.example.com/\" target=\"_blank\"><img alt=\"LinkedIn\" height=\"32\" src=\"https://i.ibb.co/qptHqZ9/linkedin2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"LinkedIn\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 5px 0 5px;\"><a href=\"https://www.youtube.com/\" target=\"_blank\"><img alt=\"YouTube\" height=\"32\" src=\"https://i.ibb.co/bvV51ff/youtube2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"YouTube\" width=\"32\"/></a></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-16\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\" width=\"640\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #555555; line-height: 1.2;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><span style=\"font-size:11px;\">Copyright © 2023 All Rights Reserved | <a href=\"http://www.example.com/\" rel=\"noopener\" style=\"text-decoration: none; color: #0068A5;\" target=\"_blank\">Unsubscribe</a></span></p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><span style=\"font-size:11px;\">You are receiving this email because you signed up on our website [<a href=\"http://www.example.com/\" rel=\"noopener\" style=\"text-decoration: none; color: #0068A5;\" target=\"_blank\">F-Go.vn</a>]</span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table><!-- End -->\n" +
                    "</body>\n" +
                    "</html>";
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
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

                // Subject
                message.setSubject("F-GO - Authentication");
                String content = "<!DOCTYPE html>\n" +
                        "\n" +
                        "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                        "<head>\n" +
                        "<title></title>\n" +
                        "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                        "<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                        "<style>\n" +
                        "\t\t* {\n" +
                        "\t\t\tbox-sizing: border-box;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\tbody {\n" +
                        "\t\t\tmargin: 0;\n" +
                        "\t\t\tpadding: 0;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\ta[x-apple-data-detectors] {\n" +
                        "\t\t\tcolor: inherit !important;\n" +
                        "\t\t\ttext-decoration: inherit !important;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t#MessageViewBody a {\n" +
                        "\t\t\tcolor: inherit;\n" +
                        "\t\t\ttext-decoration: none;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\tp {\n" +
                        "\t\t\tline-height: inherit\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t.desktop_hide,\n" +
                        "\t\t.desktop_hide table {\n" +
                        "\t\t\tmso-hide: all;\n" +
                        "\t\t\tdisplay: none;\n" +
                        "\t\t\tmax-height: 0px;\n" +
                        "\t\t\toverflow: hidden;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t.image_block img+div {\n" +
                        "\t\t\tdisplay: none;\n" +
                        "\t\t}\n" +
                        "\n" +
                        "\t\t@media (max-width:620px) {\n" +
                        "\n" +
                        "\t\t\t.desktop_hide table.icons-inner,\n" +
                        "\t\t\t.social_block.desktop_hide .social-table {\n" +
                        "\t\t\t\tdisplay: inline-block !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.icons-inner {\n" +
                        "\t\t\t\ttext-align: center;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.icons-inner td {\n" +
                        "\t\t\t\tmargin: 0 auto;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.image_block img.big,\n" +
                        "\t\t\t.row-content {\n" +
                        "\t\t\t\twidth: 100% !important;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tdisplay: none;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.stack .column {\n" +
                        "\t\t\t\twidth: 100%;\n" +
                        "\t\t\t\tdisplay: block;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.mobile_hide {\n" +
                        "\t\t\t\tmin-height: 0;\n" +
                        "\t\t\t\tmax-height: 0;\n" +
                        "\t\t\t\tmax-width: 0;\n" +
                        "\t\t\t\toverflow: hidden;\n" +
                        "\t\t\t\tfont-size: 0px;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.desktop_hide,\n" +
                        "\t\t\t.desktop_hide table {\n" +
                        "\t\t\t\tdisplay: table !important;\n" +
                        "\t\t\t\tmax-height: none !important;\n" +
                        "\t\t\t}\n" +
                        "\t\t}\n" +
                        "\t</style>\n" +
                        "</head>\n" +
                        "<body style=\"background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;\" width=\"100%\">\n" +
                        "<tbody>\n" +
                        "<tr>\n" +
                        "<td>\n" +
                        "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffcc00;\" width=\"100%\">\n" +
                        "<tbody>\n" +
                        "<tr>\n" +
                        "<td>\n" +
                        "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fefef8; color: #000000; width: 600px;\" width=\"600\">\n" +
                        "<tbody>\n" +
                        "<tr>\n" +
                        "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"padding-bottom:30px;padding-top:15px;width:100%;padding-right:0px;padding-left:0px;\">\n" +
                        "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Burger Shop logo\" src=\"https://i.ibb.co/pjNm7FV/logo.png\" style=\"display: block; height: auto; border: 0; width: 150px; max-width: 100%;\" title=\"Burger Shop logo\" width=\"150\"/></div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"padding-left:10px;padding-right:10px;text-align:center;width:100%;\">\n" +
                        "<h1 style=\"margin: 0; color: #191919; direction: ltr; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size: 46px; font-weight: 400; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\">Thông báo xác nhận tài khoản</h1>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"padding-left:10px;padding-right:10px;padding-top:15px;\">\n" +
                        "<div style=\"font-family: Arial, sans-serif\">\n" +
                        "<div class=\"\" style=\"font-size: 14px; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2;\">\n" +
                        "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><span style=\"font-size:18px;\">Bạn đã yêu cầu tạo tài khoản bằng email này.</span></p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<div class=\"spacer_block block-4\" style=\"height:60px;line-height:60px;font-size:1px;\"> </div>\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                        "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Image of three burgers\" class=\"big\" src=\"https://i.ibb.co/2ngDxtQ/pexels-prime-cinematics-2036544.jpg\" style=\"display: block; height: auto; border: 0; width: 510px; max-width: 100%;\" title=\"Image of three burgers\" width=\"510\"/></div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<div class=\"spacer_block block-6\" style=\"height:60px;line-height:60px;font-size:1px;\"> </div>\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-7\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"text-align:center;width:100%;\">\n" +
                        "<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 28px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span style=\"background-color: #ffcc00;\">  Code: " + code + "  </span></h1>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-8\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"padding-left:10px;padding-right:10px;padding-top:15px;\">\n" +
                        "<div style=\"font-family: Arial, sans-serif\">\n" +
                        "<div class=\"\" style=\"font-size: 14px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2;\">\n" +
                        "<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 16.8px;\"><span style=\"font-size:24px;\"> Để hoàn tất quá trình xác nhận, vui lòng sử dụng mã OTP và làm theo các hướng dẫn để kích hoạt tài khoản.</span></p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-9\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\">\n" +
                        "<div style=\"font-family: Arial, sans-serif\">\n" +
                        "<div class=\"\" style=\"font-size: 14px; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; mso-line-height-alt: 16.8px; color: #393d47; line-height: 1.2;\">\n" +
                        "<p style=\"margin: 0; font-size: 13px; mso-line-height-alt: 15.6px;\"><span style=\"font-size:13px;\">Nếu bạn không thực hiện bất kỳ hành động xác nhận nào, tài khoản của bạn sẽ không được kích hoạt và sẽ bị xóa.</span></p>\n" +
                        "<p style=\"margin: 0; font-size: 13px; text-align: left; mso-line-height-alt: 15.6px;\"><span style=\"font-size:13px;\">Nếu bạn gặp bất kỳ khó khăn hoặc vấn đề nào trong quá trình xác nhận tài khoản, vui lòng liên hệ với bộ phận hỗ trợ của chúng tôi để được giúp đỡ.</span></p>\n" +
                        "<p style=\"margin: 0; font-size: 13px; mso-line-height-alt: 15.6px;\"><em><span style=\"font-size:12px;\">Trân trọng,</span></em></p>\n" +
                        "<p style=\"margin: 0; font-size: 13px; mso-line-height-alt: 15.6px;\"><em><span style=\"font-size:12px;\">Bộ phận quản lý tài khoản của chúng tôi</span></em></p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-10\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"padding-top:15px;text-align:center;width:100%;\">\n" +
                        "<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; font-size: 24px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong><span style=\"color: #ffcc00;\">Welcome!</span></strong></h1>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffcc00;\" width=\"100%\">\n" +
                        "<tbody>\n" +
                        "<tr>\n" +
                        "<td>\n" +
                        "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fefef8; color: #000000; width: 600px;\" width=\"600\">\n" +
                        "<tbody>\n" +
                        "<tr>\n" +
                        "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 20px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"divider_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\" style=\"padding-bottom:20px;padding-left:10px;padding-right:10px;padding-top:20px;\">\n" +
                        "<div align=\"center\" class=\"alignment\">\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"90%\">\n" +
                        "<tr>\n" +
                        "<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 2px solid #E8E8E8;\"><span> </span></td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"social_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\">\n" +
                        "<div align=\"center\" class=\"alignment\">\n" +
                        "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"social-table\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\" width=\"210px\">\n" +
                        "<tr>\n" +
                        "<td style=\"padding:0 5px 0 5px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"https://i.ibb.co/X8GTRPz/facebook2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"facebook\" width=\"32\"/></a></td>\n" +
                        "<td style=\"padding:0 5px 0 5px;\"><a href=\"https://www.twitter.com/\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"https://i.ibb.co/7v4rYC1/twitter2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"twitter\" width=\"32\"/></a></td>\n" +
                        "<td style=\"padding:0 5px 0 5px;\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img alt=\"Linkedin\" height=\"32\" src=\"https://i.ibb.co/qptHqZ9/linkedin2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"linkedin\" width=\"32\"/></a></td>\n" +
                        "<td style=\"padding:0 5px 0 5px;\"><a href=\"https://www.instagram.com/\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"https://i.ibb.co/dPDjg3P/instagram2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"instagram\" width=\"32\"/></a></td>\n" +
                        "<td style=\"padding:0 5px 0 5px;\"><a href=\"https://www.youtube.com/\" target=\"_blank\"><img alt=\"YouTube\" height=\"32\" src=\"https://i.ibb.co/bvV51ff/youtube2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"YouTube\" width=\"32\"/></a></td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "</div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                        "<tr>\n" +
                        "<td class=\"pad\">\n" +
                        "<div style=\"font-family: sans-serif\">\n" +
                        "<div class=\"\" style=\"color: #C0C0C0; font-size: 12px; font-family: Helvetica Neue, Helvetica, Arial, sans-serif; mso-line-height-alt: 14.399999999999999px; line-height: 1.2;\">\n" +
                        "<p style=\"margin: 0; font-size: 12px; text-align: center; mso-line-height-alt: 14.399999999999999px;\"><span style=\"color:#C0C0C0;\">Copyright © 2023 F-Go</span></p>\n" +
                        "<p style=\"margin: 0; font-size: 12px; text-align: center; mso-line-height-alt: 14.399999999999999px;\"><span style=\"color:#C0C0C0;\"><br/>Changed your mind?<br/>You can <a href=\"{{ unsubscribe_link }}\" rel=\"noopener\" style=\"color:#c0c0c0;\" target=\"_blank\">unsubscribe</a> at any time.</span></p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</table>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table>\n" +
                        "</td>\n" +
                        "</tr>\n" +
                        "</tbody>\n" +
                        "</table><!-- End -->\n" +
                        "</body>\n" +
                        "</html>";
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
            String content = "<!DOCTYPE html>\n" +
                    "\n" +
                    "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
                    "<head>\n" +
                    "<title></title>\n" +
                    "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
                    "<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/><!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
                    "<style>\n" +
                    "\t\t* {\n" +
                    "\t\t\tbox-sizing: border-box;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tbody {\n" +
                    "\t\t\tmargin: 0;\n" +
                    "\t\t\tpadding: 0;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\ta[x-apple-data-detectors] {\n" +
                    "\t\t\tcolor: inherit !important;\n" +
                    "\t\t\ttext-decoration: inherit !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t#MessageViewBody a {\n" +
                    "\t\t\tcolor: inherit;\n" +
                    "\t\t\ttext-decoration: none;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\tp {\n" +
                    "\t\t\tline-height: inherit\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.desktop_hide,\n" +
                    "\t\t.desktop_hide table {\n" +
                    "\t\t\tmso-hide: all;\n" +
                    "\t\t\tdisplay: none;\n" +
                    "\t\t\tmax-height: 0px;\n" +
                    "\t\t\toverflow: hidden;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.image_block img+div {\n" +
                    "\t\t\tdisplay: none;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t.menu_block.desktop_hide .menu-links span {\n" +
                    "\t\t\tmso-hide: all;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t@media (max-width:700px) {\n" +
                    "\n" +
                    "\t\t\t.desktop_hide table.icons-inner,\n" +
                    "\t\t\t.social_block.desktop_hide .social-table {\n" +
                    "\t\t\t\tdisplay: inline-block !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.icons-inner {\n" +
                    "\t\t\t\ttext-align: center;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.icons-inner td {\n" +
                    "\t\t\t\tmargin: 0 auto;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.fullMobileWidth,\n" +
                    "\t\t\t.image_block img.big,\n" +
                    "\t\t\t.row-content {\n" +
                    "\t\t\t\twidth: 100% !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.menu-checkbox[type=checkbox]~.menu-links {\n" +
                    "\t\t\t\tdisplay: none !important;\n" +
                    "\t\t\t\tpadding: 5px 0;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.menu-checkbox[type=checkbox]:checked~.menu-trigger .menu-open {\n" +
                    "\t\t\t\tdisplay: none !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.menu-checkbox[type=checkbox]:checked~.menu-links,\n" +
                    "\t\t\t.menu-checkbox[type=checkbox]~.menu-trigger {\n" +
                    "\t\t\t\tdisplay: block !important;\n" +
                    "\t\t\t\tmax-width: none !important;\n" +
                    "\t\t\t\tmax-height: none !important;\n" +
                    "\t\t\t\tfont-size: inherit !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.menu-checkbox[type=checkbox]~.menu-links>a,\n" +
                    "\t\t\t.menu-checkbox[type=checkbox]~.menu-links>span.label {\n" +
                    "\t\t\t\tdisplay: block !important;\n" +
                    "\t\t\t\ttext-align: center;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.menu-checkbox[type=checkbox]:checked~.menu-trigger .menu-close {\n" +
                    "\t\t\t\tdisplay: block !important;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.mobile_hide {\n" +
                    "\t\t\t\tdisplay: none;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.stack .column {\n" +
                    "\t\t\t\twidth: 100%;\n" +
                    "\t\t\t\tdisplay: block;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.mobile_hide {\n" +
                    "\t\t\t\tmin-height: 0;\n" +
                    "\t\t\t\tmax-height: 0;\n" +
                    "\t\t\t\tmax-width: 0;\n" +
                    "\t\t\t\toverflow: hidden;\n" +
                    "\t\t\t\tfont-size: 0px;\n" +
                    "\t\t\t}\n" +
                    "\n" +
                    "\t\t\t.desktop_hide,\n" +
                    "\t\t\t.desktop_hide table {\n" +
                    "\t\t\t\tdisplay: table !important;\n" +
                    "\t\t\t\tmax-height: none !important;\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t#memu-r7c0m2:checked~.menu-links {\n" +
                    "\t\t\tbackground-color: #000000 !important;\n" +
                    "\t\t}\n" +
                    "\n" +
                    "\t\t#memu-r7c0m2:checked~.menu-links a,\n" +
                    "\t\t#memu-r7c0m2:checked~.menu-links span {\n" +
                    "\t\t\tcolor: #ffffff !important;\n" +
                    "\t\t}\n" +
                    "\t</style>\n" +
                    "</head>\n" +
                    "<body style=\"background-color: #fff0e3; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #fff0e3;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:30px;line-height:30px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"33.333333333333336%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:0px;line-height:0px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"33.333333333333336%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Company Logo\" src=\"https://i.ibb.co/pjNm7FV/logo.png\" style=\"display: block; height: auto; border: 0; width: 147px; max-width: 100%;\" title=\"Company Logo\" width=\"147\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"33.333333333333336%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:0px;line-height:0px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:10px;line-height:10px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Top round corners\" class=\"big\" src=\"https://i.ibb.co/9T7jcWY/round-corner-top.png\" style=\"display: block; height: auto; border: 0; width: 680px; max-width: 100%;\" title=\"Top round corners\" width=\"680\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"15\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Resetting Password\" class=\"fullMobileWidth\" src=\"https://i.ibb.co/7kz8bL2/password-reset.png\" style=\"display: block; height: auto; border: 0; width: 374px; max-width: 100%;\" title=\"Resetting Password\" width=\"374\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<div class=\"spacer_block block-2\" style=\"height:35px;line-height:35px;font-size:1px;\"> </div>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"text-align:center;width:100%;\">\n" +
                    "<h1 style=\"margin: 0; color: #101010; direction: ltr; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; font-size: 27px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong>Forgot Your Password?</strong></h1>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-6\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"16.666666666666668%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:0px;line-height:0px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"66.66666666666667%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-bottom:10px;padding-left:20px;padding-right:10px;padding-top:10px;\">\n" +
                    "<div style=\"font-family: sans-serif\">\n" +
                    "<div class=\"\" style=\"font-size: 12px; font-family: Arial, Helvetica Neue, Helvetica, sans-serif; mso-line-height-alt: 21.6px; color: #848484; line-height: 1.8;\">\n" +
                    "<p style=\"margin: 0; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Xin chào,</span></p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Chúng tôi nhận được thông tin từ bạn rằng bạn đã quên mật khẩu để truy cập vào tài khoản của mình.</span></p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Để khôi phục tài khoản, vui lòng sử dụng mã OTP bên dưới. Hệ thống sẽ hướng dẫn bạn tiếp tục quá trình khôi phục mật khẩu.</span></p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Trân trọng,</span></p>\n" +
                    "<p style=\"margin: 0; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Bộ phận hỗ trợ của chúng tôi</span></p>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<div class=\"spacer_block block-2\" style=\"height:10px;line-height:10px;font-size:1px;\"> </div>\n" +
                    "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"paragraph_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\">\n" +
                    "<div style=\"color:#000000;font-size:24px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-weight:400;line-height:120%;text-align:center;direction:ltr;letter-spacing:0px;mso-line-height-alt:16.8px;\">\n" +
                    "<p style=\"margin: 0;\">"+ code +
                    "</p>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<div class=\"spacer_block block-4\" style=\"height:20px;line-height:20px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"16.666666666666668%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:0px;line-height:0px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-7\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"width:100%;padding-right:0px;padding-left:0px;\">\n" +
                    "<div align=\"center\" class=\"alignment\" style=\"line-height:10px\"><img alt=\"Bottom round corners\" class=\"big\" src=\"https://i.ibb.co/N6hmCXK/round-corner-bottom.png\" style=\"display: block; height: auto; border: 0; width: 680px; max-width: 100%;\" title=\"Bottom round corners\" width=\"680\"/></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-8\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:20px;line-height:20px;font-size:1px;\"> </div>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"social_block block-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"padding-bottom:15px;padding-left:10px;padding-right:10px;padding-top:10px;text-align:center;\">\n" +
                    "<div align=\"center\" class=\"alignment\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"social-table\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block;\" width=\"180px\">\n" +
                    "<tr>\n" +
                    "<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"https://i.ibb.co/X8GTRPz/facebook2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"facebook\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.twitter.com/\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"https://i.ibb.co/7v4rYC1/twitter2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"twitter\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img alt=\"Linkedin\" height=\"32\" src=\"https://i.ibb.co/qptHqZ9/linkedin2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"linkedin\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.instagram.com/\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"https://i.ibb.co/dPDjg3P/instagram2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"instagram\" width=\"32\"/></a></td>\n" +
                    "<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.youtube.com/\" target=\"_blank\"><img alt=\"YouTube\" height=\"32\" src=\"https://i.ibb.co/bvV51ff/youtube2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"YouTube\" width=\"32\"/></a></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"menu_block block-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"color:#101010;font-family:inherit;font-size:14px;text-align:center;\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"alignment\" style=\"text-align:center;font-size:0px;\"><!--[if !mso]><!--><input class=\"menu-checkbox\" id=\"memu-r7c0m2\" style=\"display:none !important;max-height:0;visibility:hidden;\" type=\"checkbox\"/><!--<![endif]-->\n" +
                    "<div class=\"menu-trigger\" style=\"display:none;max-height:0px;max-width:0px;font-size:0px;overflow:hidden;\"><label class=\"menu-label\" for=\"memu-r7c0m2\" style=\"height: 36px; width: 36px; display: inline-block; cursor: pointer; mso-hide: all; user-select: none; align: center; text-align: center; color: #ffffff; text-decoration: none; background-color: #000000; border-radius: 0;\"><span class=\"menu-open\" style=\"mso-hide:all;font-size:26px;line-height:36px;\">☰</span><span class=\"menu-close\" style=\"display:none;mso-hide:all;font-size:26px;line-height:36px;\">✕</span></label></div>\n" +
                    "<div class=\"menu-links\"><!--[if mso]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" style=\"\"><tr style=\"text-align:center;\"><![endif]--><!--[if mso]><td style=\"padding-top:5px;padding-right:15px;padding-bottom:5px;padding-left:15px\"><![endif]--><a href=\"www.example.com\" style=\"mso-hide:false;padding-top:5px;padding-bottom:5px;padding-left:15px;padding-right:15px;display:inline-block;color:#101010;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:14px;text-decoration:none;letter-spacing:normal;\" target=\"_self\">Unsubscribe</a><!--[if mso]></td><![endif]--><!--[if mso]><td style=\"padding-top:5px;padding-right:15px;padding-bottom:5px;padding-left:15px\"><![endif]--><a href=\"www.example.com\" style=\"mso-hide:false;padding-top:5px;padding-bottom:5px;padding-left:15px;padding-right:15px;display:inline-block;color:#101010;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:14px;text-decoration:none;letter-spacing:normal;\" target=\"_self\">Help</a><!--[if mso]></td><![endif]--><!--[if mso]><td style=\"padding-top:5px;padding-right:15px;padding-bottom:5px;padding-left:15px\"><![endif]--><a href=\"www.example.com\" style=\"mso-hide:false;padding-top:5px;padding-bottom:5px;padding-left:15px;padding-right:15px;display:inline-block;color:#101010;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:14px;text-decoration:none;letter-spacing:normal;\" target=\"_self\">Login</a><!--[if mso]></td><![endif]--><!--[if mso]><td style=\"padding-top:5px;padding-right:15px;padding-bottom:5px;padding-left:15px\"><![endif]--><a href=\"www.example.com\" style=\"mso-hide:false;padding-top:5px;padding-bottom:5px;padding-left:15px;padding-right:15px;display:inline-block;color:#101010;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;font-size:14px;text-decoration:none;letter-spacing:normal;\" target=\"_self\">Privacy</a><!--[if mso]></td><![endif]--><!--[if mso]></tr></table><![endif]--></div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-9\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"16.666666666666668%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:0px;line-height:0px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "<td class=\"column column-2\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"66.66666666666667%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:35px;line-height:35px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "<td class=\"column column-3\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"16.666666666666668%\">\n" +
                    "<div class=\"spacer_block block-1\" style=\"height:0px;line-height:0px;font-size:1px;\"> </div>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-10\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td>\n" +
                    "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td class=\"column column-1\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; padding-bottom: 5px; padding-top: 5px; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\n" +
                    "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block block-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"pad\" style=\"vertical-align: middle; color: #9d9d9d; font-family: inherit; font-size: 15px; padding-bottom: 5px; padding-top: 5px; text-align: center;\">\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "<tr>\n" +
                    "<td class=\"alignment\" style=\"vertical-align: middle; text-align: center;\"><!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n" +
                    "<!--[if !vml]><!-->\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" class=\"icons-inner\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\"><!--<![endif]-->\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table><!-- End -->\n" +
                    "</body>\n" +
                    "</html>";
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