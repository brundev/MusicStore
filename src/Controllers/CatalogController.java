package Controllers;

import Models.Catalog;
import Models.Product;

import java.util.ArrayList;

public class CatalogController
{
    private Catalog _catalog;

    public CatalogController(Catalog catalog)
    {
        _catalog = catalog;
        set_productList();
    }

    public void set_productList()
    {
        //TODO query per ottenere la lista dei prodotti
        //simulo una query aggiungendo dei prodotti alla lista
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        p1.set_title("shadilay");
        p2.set_title("brainpower");
        p3.set_title("boh");
        _catalog.add(p1);
        _catalog.add(p2);
        _catalog.add(p3);
    }
}
