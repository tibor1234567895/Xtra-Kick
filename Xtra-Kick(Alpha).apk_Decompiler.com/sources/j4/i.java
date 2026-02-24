package j4;

import la.g;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f8763a = 0;

    static {
        new i();
    }

    private i() {
    }

    public static final double a(int i10, int i11, int i12, int i13, int i14) {
        double d10 = ((double) i12) / ((double) i10);
        double d11 = ((double) i13) / ((double) i11);
        if (i14 != 0) {
            int i15 = i14 - 1;
            if (i15 == 0) {
                return Math.max(d10, d11);
            }
            if (i15 == 1) {
                return Math.min(d10, d11);
            }
            throw new g();
        }
        throw null;
    }
}
