package o1;

public final class g0 implements v {

    /* renamed from: b  reason: collision with root package name */
    public final int f11919b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11920c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11921d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11922e;

    /* renamed from: f  reason: collision with root package name */
    public final int f11923f;

    /* renamed from: g  reason: collision with root package name */
    public final int f11924g;

    public g0(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f11919b = i10;
        this.f11920c = i11;
        this.f11921d = i12;
        this.f11922e = i13;
        this.f11923f = i14;
        this.f11924g = i15;
    }

    public static int a(int i10) {
        switch (i10) {
            case Constants.MAX_COMPATIBILITY_VERSION:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case Constants.IV_SIZE:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
            default:
                throw new IllegalArgumentException();
        }
    }

    public g0(f0 f0Var) {
        this.f11919b = f0Var.f11911a;
        this.f11920c = f0Var.f11912b;
        this.f11921d = f0Var.f11913c;
        this.f11922e = f0Var.f11914d;
        this.f11923f = f0Var.f11915e;
        this.f11924g = f0Var.f11916f;
    }
}
