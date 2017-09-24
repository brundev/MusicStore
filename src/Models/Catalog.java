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

    public void add(ArrayList<Product> list)
    {

    }


    public void remove(Product p)
    {
        _catalogList.remove(p);
        //notifyAllObservers();
    }

    public void clear()
    {
        _catalogList.clear();
    }

    public ArrayList<Product> getCatalogProducts()
    {
        return _catalogList;
    }
}
