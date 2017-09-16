package Models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by riccardo on 14/09/17.
 */
public class Musician {

    private String _name;
    private String _mainGenre;
    private LocalDate _birthDate;
    private ArrayList<String> _instruments;

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_mainGenre() {
        return _mainGenre;
    }

    public void set_mainGenre(String _mainGenre) {
        this._mainGenre = _mainGenre;
    }

    public LocalDate get_birthDate() {
        return _birthDate;
    }

    public void set_birthDate(LocalDate _birthDate) {
        this._birthDate = _birthDate;
    }

    public ArrayList<String> get_instruments() {
        return _instruments;
    }

    public void set_instruments(ArrayList<String> _instruments) {
        this._instruments = _instruments;
    }
}
