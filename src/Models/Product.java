package Models;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by riccardo on 14/09/17.
 */
public class Product {

    protected String _code;
    protected String _title;
    protected ArrayList<String> _songList;
    protected BufferedImage _coverImage; //per prelevare immagine da un URL
    protected float _price;
    protected LocalDateTime _firstAddedInStore;
    protected String _artist;
    protected Musician _description;
    protected String _genre;
    protected ArrayList<Musician> _involvedArtists;
    protected ArrayList<String> _usedInstruments;

}