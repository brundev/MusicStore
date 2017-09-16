package Models;

import java.util.ArrayList;

/**
 * Created by riccardo on 16/09/17.
 */
public class Cart {

    private ArrayList<Product> _cartList;
    private User _user;
    private float _totalPrice;

    public ArrayList<Product> get_cartList() {
        return _cartList;
    }

    public void set_cartList(ArrayList<Product> _cartList) {
        this._cartList = _cartList;
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
