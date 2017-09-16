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

    public Cart get_cart() {
        return _cart;
    }

    public void set_cart(Cart _cart) {
        this._cart = _cart;
    }

    public LocalDateTime get_saleDate() {
        return _saleDate;
    }

    public void set_saleDate(LocalDateTime _saleDate) {
        this._saleDate = _saleDate;
    }

    public PaymentType get_paymentType() {
        return _paymentType;
    }

    public void set_paymentType(PaymentType _paymentType) {
        this._paymentType = _paymentType;
    }

    public DeliveryType get_deliveryType() {
        return _deliveryType;
    }

    public void set_deliveryType(DeliveryType _deliveryType) {
        this._deliveryType = _deliveryType;
    }

}
