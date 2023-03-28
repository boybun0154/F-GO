/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PayPal;

/**
 *
 * @author LENOVO
 */
import java.util.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

import DAO.ProductDAO;

public class PaymentServices {

    private static final String CLIENT_ID = "AUPdULQ6-OouyH9_rPZC1e55IcJiqZpim_ycQcDDbUtnFS7dM5k3ypytFwKjpJjOi9SS8R2cCMgeoE0x";
    private static final String CLIENT_SECRET = "EDvAGx7aNGXZ23SNPyw5SHMlXFdig1g-_cm6af2Nf7HT_EfkuunapGpuD5FxNZjN9pH3VyqqtPdNMVcX";
    private static final String MODE = "sandbox";

    public String authorizePayment(entity.Order orderDetail)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("")
                .setLastName("")
                .setEmail("");

        payer.setPayerInfo(payerInfo);

        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/PaypalTest/cancel.html");
        redirectUrls.setReturnUrl("http://localhost:8080/F-Go/reviewPayment");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(entity.Order orderDetail) {

        String money = String.valueOf((orderDetail.getTotalMoney() / 2) / 23000);
        Details details = new Details();
        details.setShipping("0");
        details.setSubtotal(money);
        details.setTax("0");

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(money);
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Vehicle Rental");
        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();
        ProductDAO pDao = new ProductDAO();
        entity.Product product = pDao.getProductById(String.valueOf(orderDetail.getProductId()));
        Item item = new Item();
        item.setCurrency("USD");
        item.setName(product.getProductName());
        item.setDescription("\nAddress: " + orderDetail.getAddress() + " | Start time: " + orderDetail.getTimeBegin()
                + " | End time: " + orderDetail.getTimeEnd());
        item.setPrice(money);
        item.setTax("0");
        item.setQuantity("1");
        items.add(item);
        itemList.setItems(items);

        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }
}
