package wb;

public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public int f16292a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f16293b = new int[10];

    static {
        new o0(0);
    }

    public final int a() {
        if ((this.f16292a & 128) != 0) {
            return this.f16293b[7];
        }
        return 65535;
    }

    public final void b(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f16293b;
            if (i10 < iArr.length) {
                this.f16292a = (1 << i10) | this.f16292a;
                iArr[i10] = i11;
            }
        }
    }
}
