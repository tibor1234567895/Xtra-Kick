package o1;

public final class k extends Exception {
    public k(long j10, long j11) {
        super("Unexpected audio track timestamp discontinuity: expected " + j11 + ", got " + j10);
    }
}
