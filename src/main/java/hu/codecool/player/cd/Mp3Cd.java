package hu.codecool.player.cd;

import hu.codecool.player.exception.PlayerException;
import hu.codecool.player.song.AudioSong;
import hu.codecool.player.song.Mp3Song;
import hu.codecool.player.song.Song;

public class Mp3Cd extends Cd {

    public Mp3Cd(String label) {
        super(label, 100);
    }

    @Override
    public void addTrack(Song track) throws PlayerException {
        if (track instanceof Mp3Song) {
            if (tracks.size() < limit) {
                tracks.add(track);
                return;
            }
            throw new PlayerException("mp3 CD is full");
        }
        throw new PlayerException("only mp3 songs can be added to the CD");
    }
}
