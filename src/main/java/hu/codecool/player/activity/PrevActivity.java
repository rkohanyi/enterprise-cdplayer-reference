package hu.codecool.player.activity;

import hu.codecool.player.Player;
import hu.codecool.player.exception.PlayerException;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.writer.Writer;

public class PrevActivity extends PlayerActivity {

    public PrevActivity(Player player, Reader reader, Writer writer) {
        super(player, reader, writer);
    }

    @Override
    public void activate() throws PlayerException {
        player.prev();
    }
}
