package s1;

public final class y extends Exception {
    public y(Exception exc) {
        super("Failed to query underlying media codecs", exc);
    }
}
