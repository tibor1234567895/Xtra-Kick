package l1;

public final class g extends IllegalStateException {
    public g(int i10, int i11) {
        super("Buffer too small (" + i10 + " < " + i11 + ")");
    }
}
