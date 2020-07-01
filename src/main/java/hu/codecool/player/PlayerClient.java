package hu.codecool.player;

import hu.codecool.player.Player;
import hu.codecool.player.activity.*;
import hu.codecool.player.cd.AudioCd;
import hu.codecool.player.cd.Cd;
import hu.codecool.player.cd.Mp3Cd;
import hu.codecool.player.menu.Menu;
import hu.codecool.player.menu.MenuItem;
import hu.codecool.player.reader.ConsoleReader;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.song.AudioSong;
import hu.codecool.player.song.Mp3Song;
import hu.codecool.player.writer.ConsoleWriter;
import hu.codecool.player.writer.Writer;
import hu.codecool.remote.Spotify;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class PlayerClient {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");

        Cd cd1 = new AudioCd("80s glam rock");
        cd1.addTrack(new AudioSong("Sweet - Ballroom Blitz", 43));
        cd1.addTrack(new AudioSong("T. Rex - Hot Love", 54));
        cd1.addTrack(new AudioSong("The Darkness - I Believe in a Thing Called Love", 31));

        Cd cd2 = new Mp3Cd("Top house");
        cd2.addTrack(new Mp3Song("Daft Punk - One More Time", 3));
        cd2.addTrack(new Mp3Song("Eric Prydz - Call on Me", 3));

        Cd cd3 = new AudioCd("English lessons");
        cd3.addTrack(new AudioSong("English Lessons - Track 1", 10));
        cd3.addTrack(new AudioSong("English Lessons - Track 2", 23));
        cd3.addTrack(new AudioSong("English Lessons - Track 3", 53));
        cd3.addTrack(new AudioSong("English Lessons - Track 4", 88));
        cd3.addTrack(new AudioSong("English Lessons - Track 5", 37));
        cd3.addTrack(new AudioSong("English Lessons - Track 6", 33));
        cd3.addTrack(new AudioSong("English Lessons - Track 7", 64));
        cd3.addTrack(new AudioSong("English Lessons - Track 8", 11));
        cd3.addTrack(new AudioSong("English Lessons - Track 9", 63));
        cd3.addTrack(new AudioSong("English Lessons - Track 10", 54));

        List<Cd> cds = new ArrayList<Cd>();
        cds.add(cd1);
        cds.add(cd2);
        cds.add(cd3);

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Player player = new Player(registry, writer);
        Menu menu = new Menu(reader, writer);
        menu.addItem(new MenuItem("play", new PlayActivity(player, reader, writer)));
        menu.addItem(new MenuItem("stop", new StopActivity(player, reader, writer)));
        menu.addItem(new MenuItem("show", new ShowActivity(player, reader, writer)));
        menu.addItem(new MenuItem("mode", new ChangeModeActivity(player, reader, writer)));
        menu.addItem(new MenuItem("cd", new ChangeCdActivity(player, reader, writer, cds)));
        menu.addItem(new MenuItem("next", new NextActivity(player, reader, writer)));
        menu.addItem(new MenuItem("prev", new PrevActivity(player, reader, writer)));
        menu.addItem(new MenuItem("exit", new ExitActivity(player, reader, writer)));
        menu.show();
    }
}
