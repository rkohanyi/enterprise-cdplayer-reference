package hu.codecool.player.song;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import java.util.Objects;

public abstract class Song implements Serializable {

    @XmlAttribute
    protected String title;

    protected Song() {
        this(null);
    }

    protected Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getLength();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title)
            && getLength() == song.getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, getLength());
    }
}
