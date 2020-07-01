package hu.codecool.player.writer;

public class ConsoleWriter extends Writer {

    @Override
    public void write(String message) {
        System.out.println("INFO " + message);
    }
}
