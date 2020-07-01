package hu.codecool.player.cd;

import hu.codecool.player.exception.PlayerException;
import hu.codecool.player.song.AudioSong;
import hu.codecool.player.song.Song;

public class AudioCd extends Cd {

    public AudioCd(String label) {
        super(label, 10);
    }

    public void addTrack(Song track) throws PlayerException {
        if (track instanceof AudioSong) {
            if (tracks.size() < limit) {
                tracks.add(track);
                return;
            }
            throw new PlayerException("audio CD is full");
        }
        throw new PlayerException("only audio songs can be added to the CD");
    }
}
