package hu.codecool.spotify;

import hu.codecool.player.song.Song;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serial;
import java.io.Serializable;

public class SpotifySong extends Song implements Serializable {

    @XmlAttribute
    private int length;

    public SpotifySong() {
        super();
    }

    SpotifySong(String title, int length) {
        super(title);
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }
}
