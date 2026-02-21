package i0;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import xa.j;

public final class d {
    static {
        new d();
    }

    private d() {
    }

    public static final void a(Bundle bundle, String str, Size size) {
        j.f("bundle", bundle);
        j.f("key", str);
        bundle.putSize(str, size);
    }

    public static final void b(Bundle bundle, String str, SizeF sizeF) {
        j.f("bundle", bundle);
        j.f("key", str);
        bundle.putSizeF(str, sizeF);
    }
}
