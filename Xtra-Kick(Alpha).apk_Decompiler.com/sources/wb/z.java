package wb;

import java.io.IOException;

public final class z {
    private z() {
    }

    public /* synthetic */ z(int i10) {
        this();
    }

    public static int a(int i10, int i11, int i12) {
        if ((i11 & 8) != 0) {
            i10--;
        }
        if (i12 <= i10) {
            return i10 - i12;
        }
        throw new IOException("PROTOCOL_ERROR padding " + i12 + " > remaining length " + i10);
    }
}
