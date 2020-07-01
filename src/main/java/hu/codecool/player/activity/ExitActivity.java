package hu.codecool.player.activity;

import hu.codecool.player.Player;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.writer.Writer;

public class ExitActivity extends PlayerActivity {

    public ExitActivity(Player player, Reader reader, Writer writer) {
        super(player, reader, writer);
    }

    @Override
    public void activate() {
        writer.write("exiting");
        System.exit(0);
    }
}
