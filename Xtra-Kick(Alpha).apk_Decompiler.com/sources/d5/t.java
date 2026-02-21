package d5;

import b5.a;
import b5.c;

public final class t extends u {
    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return true;
    }

    public final boolean c(a aVar) {
        return aVar == a.REMOTE;
    }

    public final boolean d(boolean z10, a aVar, c cVar) {
        return ((z10 && aVar == a.DATA_DISK_CACHE) || aVar == a.LOCAL) && cVar == c.TRANSFORMED;
    }
}
