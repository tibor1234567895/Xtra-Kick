package i0;

import android.os.Bundle;
import android.os.IBinder;
import xa.j;

public final class c {
    static {
        new c();
    }

    private c() {
    }

    public static final void a(Bundle bundle, String str, IBinder iBinder) {
        j.f("bundle", bundle);
        j.f("key", str);
        bundle.putBinder(str, iBinder);
    }
}
