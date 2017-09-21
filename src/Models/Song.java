package Models;

import java.time.Duration;
import java.util.Date;

/**
 * Created by riccardo on 16/09/17.
 */
public class Song {
    private String _id;
    private String _title;
    private Duration _duration;
    private Date _releaseDate;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public Duration get_duration() {
        return _duration;
    }

    public void set_duration(Duration _duration) {
        this._duration = _duration;
    }

    public Date get_releaseDate() {
        return _releaseDate;
    }

    public void set_releaseDate(Date _releaseDate) {
        this._releaseDate = _releaseDate;
    }
}
