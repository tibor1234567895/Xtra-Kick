package androidx.lifecycle;

import xa.j;

public final class p {
    private p() {
    }

    public /* synthetic */ p(int i10) {
        this();
    }

    public static r a(s sVar) {
        j.f("state", sVar);
        int ordinal = sVar.ordinal();
        if (ordinal == 2) {
            return r.ON_DESTROY;
        }
        if (ordinal == 3) {
            return r.ON_STOP;
        }
        if (ordinal != 4) {
            return null;
        }
        return r.ON_PAUSE;
    }

    public static r b(s sVar) {
        j.f("state", sVar);
        int ordinal = sVar.ordinal();
        if (ordinal == 1) {
            return r.ON_CREATE;
        }
        if (ordinal == 2) {
            return r.ON_START;
        }
        if (ordinal != 3) {
            return null;
        }
        return r.ON_RESUME;
    }

    public static r c(s sVar) {
        j.f("state", sVar);
        int ordinal = sVar.ordinal();
        if (ordinal == 2) {
            return r.ON_CREATE;
        }
        if (ordinal == 3) {
            return r.ON_START;
        }
        if (ordinal != 4) {
            return null;
        }
        return r.ON_RESUME;
    }
}
