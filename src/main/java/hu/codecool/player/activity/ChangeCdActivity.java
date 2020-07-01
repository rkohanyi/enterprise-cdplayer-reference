package hu.codecool.player.activity;

import hu.codecool.player.Player;
import hu.codecool.player.cd.Cd;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.writer.Writer;

import java.util.List;

public class ChangeCdActivity extends PlayerActivity {

    private final List<Cd> cds;

    public ChangeCdActivity(Player player, Reader reader, Writer writer, List<Cd> cds) {
        super(player, reader, writer);
        this.cds = cds;
    }

    @Override
    public void activate() {
        if (cds.isEmpty()) {
            throw new IllegalStateException("need CDs");
        }
        writer.write("available CDs are:");
        for (int i = 0; i < cds.size(); i++) {
            Cd cd = cds.get(i);
            writer.write(String.format("%s - %s (%s tracks)", i + 1, cd.getLabel(), cd.getTracks().size()));
        }
        String input = reader.read("pick a CD: ");
        try {
            int cdNumber = Integer.valueOf(input);
            if (cdNumber < 1 || cdNumber > cds.size()) {
                throw new IllegalArgumentException();
            }
            player.setCd(cds.get(cdNumber - 1));
        } catch (IllegalArgumentException ex) {
            writer.write("enter a number between 1 and " + cds.size());
        }
    }
}
