package hu.codecool.spotify;

import hu.codecool.player.song.Song;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "songs")
public class SpotifyTrackList {

    @XmlElements({
        @XmlElement(name = "song", type = SpotifySong.class)
    })
    private List<Song> songs = new ArrayList<>();

    public List<Song> getSongs() {
        return songs;
    }
}
