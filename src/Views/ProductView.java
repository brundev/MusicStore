package Views;

import Controllers.CartController;
import Controllers.CatalogController;
import Models.Catalog;
import Models.Product;
import SupportClasses.TableFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ProductView extends JFrame{
    private JPanel productPanel;
    private JLabel imageLabel;
    private JLabel title;
    private JButton addToCartButton;
    private JButton annullaButton;
    private JLabel price;
    private JLabel description;
    private JLabel artist;
    private JLabel genre;
    private Product _product;
    private CartController _controller;

    public ProductView(Product product, CartController controller)
    {
        _product = product;
        _controller = controller;
        this.setContentPane(this.productPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(600, 600 );
        SetupView(this);
    }

    public void SetupView(JFrame frame)
    {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(_product.get_coverImage()));
        Image image = imageIcon.getImage();
        imageIcon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        imageLabel.setIcon(imageIcon);
        title.setText(_product.get_title());
        price.setText(_product.get_price() + " €");
        description.setText(_product.get_description());
        artist.setText(_product.get_artist().get_name());
        genre.setText(_product.get_genre());

        annullaButton.addActionListener(e -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));

        addToCartButton.addActionListener( e -> _controller.addToCart(_product));
    }
}
