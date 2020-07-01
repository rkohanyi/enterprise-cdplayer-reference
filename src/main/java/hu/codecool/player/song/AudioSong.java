package hu.codecool.player.song;

public class AudioSong extends Song {

    private static final int BIT_DEPTH = 16;
    private static final int CHANNELS = 2;

    private final float samplingFrequency;
    private final int size;

    // duration [seconds] = size [bits] / (bitdepth [bits] * samples [Hz] * channels)
    public AudioSong(String title, float samplingFrequency, int size) {
        super(title);
        this.samplingFrequency = samplingFrequency;
        this.size = size;
    }

    public AudioSong(String title, int size) {
        this(title, 44.1f, size);
    }

    @Override
    public int getLength() {
        return (int) ((size * 1024 * 1024 * 8) / (BIT_DEPTH * samplingFrequency * 1000 * CHANNELS));
    }

    public float getSamplingFrequency() {
        return samplingFrequency;
    }
}
