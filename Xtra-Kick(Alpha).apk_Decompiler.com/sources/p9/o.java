package p9;

public final class o {
    private o() {
    }

    public /* synthetic */ o(int i10) {
        this();
    }

    public static p a(int i10) {
        if (i10 == -1) {
            return p.GLOBAL_OFF;
        }
        if (i10 != 0) {
            if (i10 == 1) {
                return p.WIFI_ONLY;
            }
            if (i10 == 2) {
                return p.UNMETERED;
            }
        }
        return p.ALL;
    }
}
