package hu.codecool.spotify;

import hu.codecool.player.song.Song;
import hu.codecool.remote.Spotify;

import javax.xml.bind.JAXB;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SpotifyServer implements Spotify {

    public static void main(String[] args) throws Exception {
        SpotifyServer server = new SpotifyServer();
        Spotify stub = (Spotify) UnicastRemoteObject.exportObject(server, 0);

        Registry registry = LocateRegistry.getRegistry();
        registry.bind("spotify", stub);
    }

    @Override
    public List<Song> getTrackList() throws RemoteException {
        try {
            try (InputStream is = new FileInputStream("spotify.xml")) {
                SpotifyTrackList trackList = JAXB.unmarshal(is, SpotifyTrackList.class);
                return trackList.getSongs();
            }
        } catch (IOException ex) {
            throw new RemoteException("tracklist read error", ex);
        }
    }
}
