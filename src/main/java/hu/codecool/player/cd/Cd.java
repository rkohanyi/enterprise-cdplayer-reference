package hu.codecool.player.cd;

import hu.codecool.player.exception.PlayerException;
import hu.codecool.player.song.Song;

import java.util.ArrayList;
import java.util.List;

public abstract class Cd {

    protected String label;
    protected int limit;
    protected List<Song> tracks;

    protected Cd(String label, int limit) {
        this.label = label;
        this.limit = limit;
        this.tracks = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public int getLimit() {
        return limit;
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public abstract void addTrack(Song song) throws PlayerException;
}
