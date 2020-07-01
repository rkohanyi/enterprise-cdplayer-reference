package hu.codecool.player.activity;

import hu.codecool.player.Player;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.writer.Writer;

public abstract class PlayerActivity implements Activity {

    protected Player player;
    protected Reader reader;
    protected Writer writer;

    protected PlayerActivity(Player player, Reader reader, Writer writer) {
        this.player = player;
        this.reader = reader;
        this.writer = writer;
    }
}
