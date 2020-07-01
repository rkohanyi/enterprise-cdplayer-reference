package hu.codecool.player;

import hu.codecool.player.cd.Cd;
import hu.codecool.player.exception.PlayerException;
import hu.codecool.player.song.Song;
import hu.codecool.player.writer.Writer;
import hu.codecool.remote.Spotify;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

public class Player {

    public enum Mode {
        CD,
        SPOTIFY
    }

    private final Registry registry;

    private Writer writer;
    private Cd cd;
    private Mode mode = Mode.CD;
    private boolean playback;
    private Song currentTrack;

    public Player(Registry registry, Writer writer) {
        this.writer = writer;
        this.registry = registry;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        stop();
        this.cd = cd;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        if (this.mode != mode) {
            this.mode = mode;
            stop();
        }
    }

    public void next() throws PlayerException {
        List<Song> songs = getSongs();
        if (songs.isEmpty()) {
            return;
        }
        if (currentTrack == null) {
            currentTrack = songs.get(0);
            return;
        }
        int index = songs.indexOf(currentTrack);
        if (index == songs.size() - 1) {
            return;
        }
        currentTrack = songs.get(index + 1);
    }

    public void prev() throws PlayerException {
        List<Song> songs = getSongs();
        if (songs.isEmpty() || currentTrack == null) {
            return;
        }
        int index = songs.indexOf(currentTrack);
        if (index == 0) {
            return;
        }
        currentTrack = songs.get(index - 1);
    }

    public void show() {
        if (playback) {
            writer.write(String.format(
                "playing %s (%ss)",
                currentTrack.getTitle(),
                currentTrack.getLength()));
        } else {
            writer.write("stopped");
        }
    }

    public void stop() {
        playback = false;
        currentTrack = null;
    }

    public void start() throws PlayerException {
        if (mode == Mode.CD) {
            checkCd();
        }
        if (currentTrack == null) {
            next();
        }
        playback = true;
    }

    private void checkCd() throws PlayerException {
        if (cd == null) {
            throw new PlayerException("need a CD");
        }
    }

    private List<Song> getSongs() throws PlayerException {
        return switch (mode) {
            case CD -> cd.getTracks();
            case SPOTIFY -> getSpotifySongs();
            default -> throw new UnsupportedOperationException();
        };
    }

    private List<Song> getSpotifySongs() throws PlayerException {
        try {
            Spotify spotify = (Spotify) registry.lookup("spotify");
            return spotify.getTrackList();
        } catch (RemoteException | NotBoundException ex) {
            throw new PlayerException("error connecting to spotify: " + ex.getMessage());
        }
    }
}
