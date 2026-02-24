package androidx.recyclerview.widget;

public final class z2 {

    /* renamed from: a  reason: collision with root package name */
    public int f2273a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f2274b;

    /* renamed from: c  reason: collision with root package name */
    public int f2275c;

    /* renamed from: d  reason: collision with root package name */
    public int f2276d;

    /* renamed from: e  reason: collision with root package name */
    public int f2277e;

    public final boolean a() {
        int i10 = this.f2273a;
        int i11 = 2;
        if ((i10 & 7) != 0) {
            int i12 = this.f2276d;
            int i13 = this.f2274b;
            if ((((i12 > i13 ? 1 : i12 == i13 ? 2 : 4) << 0) & i10) == 0) {
                return false;
            }
        }
        if ((i10 & 112) != 0) {
            int i14 = this.f2276d;
            int i15 = this.f2275c;
            if ((((i14 > i15 ? 1 : i14 == i15 ? 2 : 4) << 4) & i10) == 0) {
                return false;
            }
        }
        if ((i10 & 1792) != 0) {
            int i16 = this.f2277e;
            int i17 = this.f2274b;
            if ((((i16 > i17 ? 1 : i16 == i17 ? 2 : 4) << 8) & i10) == 0) {
                return false;
            }
        }
        if ((i10 & 28672) != 0) {
            int i18 = this.f2277e;
            int i19 = this.f2275c;
            if (i18 > i19) {
                i11 = 1;
            } else if (i18 != i19) {
                i11 = 4;
            }
            if ((i10 & (i11 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
