package a2;

import java.io.IOException;

public final class p extends IOException {
    public p(Throwable th) {
        super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
    }
}
