package hu.codecool.player.activity;

import hu.codecool.player.Player;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.writer.Writer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeModeActivity extends PlayerActivity {

    public ChangeModeActivity(Player player, Reader reader, Writer writer) {
        super(player, reader, writer);
    }

    @Override
    public void activate() {
        String mode = reader.read("enter new player mode (" +
            Arrays.stream(Player.Mode.values())
                .map(m -> m.name())
                .collect(Collectors.joining(", ")) +
            "): ");
        try {
            player.setMode(Player.Mode.valueOf(mode.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            writer.write("no such player mode: " + mode);
        }
    }
}
