package v1;

import java.io.IOException;

public final class f extends IOException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(int i10) {
        super("Illegal clipping: ".concat(i10 != 0 ? i10 != 1 ? i10 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count"));
    }
}
