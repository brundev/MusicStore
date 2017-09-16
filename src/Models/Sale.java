package Models;


import java.time.LocalDateTime;

/**
 * Created by riccardo on 16/09/17.
 */
public class Sale {
    public enum PaymentType { Bonifico, CrediCard, Paypal}
    public enum DeliveryType { CourierService, PostalService}
    private Cart _cart;
    private LocalDateTime _saleDate;
    private PaymentType _paymentType;
    private DeliveryType _deliveryType;
}
