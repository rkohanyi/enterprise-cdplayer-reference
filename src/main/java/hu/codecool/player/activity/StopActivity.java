package hu.codecool.player.activity;

import hu.codecool.player.Player;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.writer.Writer;

public class StopActivity extends PlayerActivity {

    public StopActivity(Player player, Reader reader, Writer writer) {
        super(player, reader, writer);
    }

    @Override
    public void activate() {
        player.stop();
    }
}
