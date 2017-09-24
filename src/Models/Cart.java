package Models;

import SupportClasses.Subject;

import java.util.ArrayList;

/**
 * Created by riccardo on 16/09/17.
 */
public class Cart extends Subject{

    private ArrayList<Product> _cartList;
    private Customer _user;
    private float _totalPrice;

    public Cart(Customer user)
    {
        _totalPrice = 0;
        _user = user;
        _cartList = new ArrayList<Product>();
    }

    public ArrayList<Product> get_cartList() {
        return _cartList;
    }

    public void addToCart(Product p){
        _cartList.add(p);
        _totalPrice += p.get_price();
        notifyAllObservers();
    }

    public void removeFromCart(int position)
    {
        _totalPrice -= -_cartList.get(position).get_price();
        _cartList.remove(position);
    }

    public Customer get_user() {
        return _user;
    }

    public float get_totalPrice() {
        return _totalPrice;
    }
}
