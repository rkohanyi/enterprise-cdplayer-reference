package hu.codecool.player.menu;

import hu.codecool.player.exception.PlayerException;
import hu.codecool.player.reader.Reader;
import hu.codecool.player.writer.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private final List<MenuItem> items;
    private Reader reader;
    private Writer writer;

    public Menu(Reader reader, Writer writer) {
        this.items = new ArrayList<>();
        this.reader = reader;
        this.writer = writer;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public void show() {
        while (true) {
            String line = reader.read("enter menu item title (" + items.stream()
                .map(mi -> mi.getTitle())
                .collect(Collectors.joining(", ")) + "): ");
            MenuItem menuItem = items.stream()
                .filter(mi -> mi.getTitle().toLowerCase().equals(line.toLowerCase()))
                .findFirst()
                .orElse(null);
            if (menuItem == null) {
                writer.write("no such menu item: " + line);
            } else {
                try {
                    menuItem.getActivity().activate();
                } catch (PlayerException ex) {
                    writer.write("player error: " + ex.getMessage());
                } catch (Exception ex) {
                    writer.write("unknown error: " + ex);
                }
            }
        }
    }
}
