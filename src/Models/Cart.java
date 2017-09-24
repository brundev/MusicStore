package Models;

import SupportClasses.Subject;

import java.util.ArrayList;

/**
 * Created by riccardo on 16/09/17.
 */
public class Cart extends Subject{

    private ArrayList<Product> _cartList;
    private User _user;
    private float _totalPrice;

    public ArrayList<Product> get_cartList() {
        return _cartList;
    }

    public void addToCart(Product p){
        _cartList.add(p);
        notifyAllObservers();
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }

    public float get_totalPrice() {
        return _totalPrice;
    }

    public void set_totalPrice(float _totalPrice) {
        this._totalPrice = _totalPrice;
    }
}
