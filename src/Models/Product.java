package Models;

import SupportClasses.Subject;
import javafx.beans.Observable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by riccardo on 14/09/17.
 */
public class Product extends Subject{

    private String _code;
    private String _title;
    private ArrayList<String> _songList;
    private BufferedImage _coverImage; //per prelevare immagine da un URL
    private float _price;
    private LocalDateTime _firstAddedInStore;
    private String _artist;
    private Musician _description;
    private String _genre;
    private ArrayList<Musician> _involvedArtists;
    private ArrayList<String> _usedInstruments;
    private int _productStocks;

    public void set_code(String _code) {
        this._code = _code;
        notifyAllObservers();
    }

    public void set_title(String _title) {

        this._title = _title;
        notifyAllObservers();
    }

    public void set_songList(ArrayList<String> _songList) {

        this._songList = _songList;
        notifyAllObservers();
    }

    public void set_coverImage(BufferedImage _coverImage) {

        this._coverImage = _coverImage;
        notifyAllObservers();
    }

    public void set_price(float _price) {

        this._price = _price;
        notifyAllObservers();
    }

    public void set_firstAddedInStore(LocalDateTime _firstAddedInStore) {

        this._firstAddedInStore = _firstAddedInStore;
        notifyAllObservers();
    }

    public void set_artist(String _artist) {

        this._artist = _artist;
        notifyAllObservers();
    }

    public void set_description(Musician _description) {

        this._description = _description;
        notifyAllObservers();
    }

    public void set_genre(String _genre) {

        this._genre = _genre;
        notifyAllObservers();
    }

    public void set_involvedArtists(ArrayList<Musician> _involvedArtists) {

        this._involvedArtists = _involvedArtists;
        notifyAllObservers();
    }

    public void set_usedInstruments(ArrayList<String> _usedInstruments) {

        this._usedInstruments = _usedInstruments;
        notifyAllObservers();
    }

    public void set_productStocks(int _productStocks) {

        this._productStocks = _productStocks;
        notifyAllObservers();
    }

    public String get_code() {
        return _code;
    }

    public String get_title() {
        return _title;
    }

    public ArrayList<String> get_songList() {
        return _songList;
    }

    public BufferedImage get_coverImage() {
        return _coverImage;
    }

    public float get_price() {
        return _price;
    }

    public LocalDateTime get_firstAddedInStore() {
        return _firstAddedInStore;
    }

    public String get_artist() {
        return _artist;
    }

    public Musician get_description() {
        return _description;
    }

    public String get_genre() {
        return _genre;
    }

    public ArrayList<Musician> get_involvedArtists() {
        return _involvedArtists;
    }

    public ArrayList<String> get_usedInstruments() {
        return _usedInstruments;
    }

    public int get_productStocks() {
        return _productStocks;
    }
}