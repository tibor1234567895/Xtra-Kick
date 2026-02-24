package k1;

import java.io.IOException;

public final class k {
    private k() {
    }

    public static void a(h hVar) {
        if (hVar != null) {
            try {
                hVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
