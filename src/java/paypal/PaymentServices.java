/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paypal;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thaiq
 */
public class PaymentServices {
    private static final String CLIENT_ID = "AbbW00o_jg9_2uCBmoUlBXUo3Yr6AlypT-1JkvTW-xzPinZLKRy_22ifReZwPy-KsQ5thhMDjhAnKNNh";
    private static final String CLIENT_SECRET = "ECLNeyye668_b_0lA2Dl_sVkQgtOrJCAMEJIZRqS3v44MbR0A1hIFc9n2Cda2uJ48yG2NEoaCUCgd9jy";
    private static final String MODE = "sandbox";
    
    
    public String authorizePayment(OrderDetail orderDetail)        
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
 
        String approvalLink = approvedPayment.getLinks().stream()
            .filter(link -> link.getRel().equals("approval_url"))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No approval URL found"))
            .getHref();

    // Use the approval link later in your code
    System.out.println(approvalLink);
        return null;
 
    }
    
    private Payer getPayerInformation() {
    Payer payer = new Payer();
    payer.setPaymentMethod("paypal");
     
    PayerInfo payerInfo = new PayerInfo();
    payerInfo.setFirstName("William")
             .setLastName("Peterson")
             .setEmail("william.peterson@company.com");
     
    payer.setPayerInfo(payerInfo);
     
    return payer;
}
    
    private RedirectUrls getRedirectURLs() {
    RedirectUrls redirectUrls = new RedirectUrls();
    redirectUrls.setCancelUrl("http://localhost:8080/AmoraShop/viewCart.jsp");
    redirectUrls.setReturnUrl("http://localhost:8080/AmoraShop/success.jsp");
     
    return redirectUrls;
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
    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
        String total = String.valueOf(orderDetail.getTotal());
        String quantity = String.valueOf(orderDetail.getQuantity());
    Details details = new Details();
    details.setShipping(orderDetail.getProductName());
    details.setSubtotal(total);
    
 
    Amount amount = new Amount();
    amount.setCurrency("USD");
    amount.setTotal(total);
    amount.setDetails(details);
 
    Transaction transaction = new Transaction();
    transaction.setAmount(amount);
    transaction.setDescription(orderDetail.getProductName());
     
    ItemList itemList = new ItemList();
    List<Item> items = new ArrayList<>();
     
    Item item = new Item();
    item.setCurrency("USD");
    item.setName(orderDetail.getProductName());
    item.setPrice(total);

    item.setQuantity(quantity);
     
    items.add(item);
    itemList.setItems(items);
    transaction.setItemList(itemList);
 
    List<Transaction> listTransaction = new ArrayList<>();
    listTransaction.add(transaction);  
     
    return listTransaction;
}
    
    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
    return Payment.get(apiContext, paymentId);
}
}
