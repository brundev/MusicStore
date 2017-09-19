package Models;

import SupportClasses.Subject;

import java.util.ArrayList;

public class Catalog extends Subject{
    private ArrayList<Product> _catalogList = new ArrayList<Product>();

    public void add(Product p)
    {
        _catalogList.add(p);
        notifyAllObservers();
    }

    public void remove(Product p)
    {
        _catalogList.remove(p);
        //notifyAllObservers();
    }

    public ArrayList<Product> getCatalogProducts()
    {
        return _catalogList;
    }
}
