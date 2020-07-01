package hu.codecool.remote;

import hu.codecool.player.song.Song;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Spotify extends Remote {
    List<Song> getTrackList() throws RemoteException;
}
