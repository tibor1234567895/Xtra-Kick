package r3;

import android.content.Context;
import fb.w;
import xa.j;

public final class h0 {
    static {
        new h0();
    }

    private h0() {
    }

    public static final i0 a(Context context, Class cls, String str) {
        j.f("context", context);
        if (true ^ (str == null || w.h(str))) {
            return new i0(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }
}
