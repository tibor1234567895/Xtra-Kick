package wb;

public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final j0[] f16270a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16271b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16272c;

    public j0() {
        this.f16270a = new j0[256];
        this.f16271b = 0;
        this.f16272c = 0;
    }

    public j0(int i10, int i11) {
        this.f16270a = null;
        this.f16271b = i10;
        int i12 = i11 & 7;
        this.f16272c = i12 == 0 ? 8 : i12;
    }
}
