package hu.codecool.player.song;

public class Mp3Song extends Song {

    private static final int CBR = 128;

    private int size;

    // (size [KBs] * 8 [bits]) / bitrate [kbps] = duration [seconds]
    public Mp3Song(String title, int size) {
        super(title);
        this.size = size;
    }

    @Override
    public int getLength() {
        return (int) ((size * 1024 * 8) / CBR);
    }

    public int getSize() {
        return size;
    }
}
