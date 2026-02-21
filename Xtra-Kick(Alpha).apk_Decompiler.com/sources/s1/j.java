package s1;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public int f14022a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f14023b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f14024c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int[] f14025d;

    /* renamed from: e  reason: collision with root package name */
    public int f14026e;

    public j() {
        int[] iArr = new int[16];
        this.f14025d = iArr;
        this.f14026e = iArr.length - 1;
    }

    public final void a(int i10) {
        int i11 = this.f14024c;
        int[] iArr = this.f14025d;
        if (i11 == iArr.length) {
            int length = iArr.length << 1;
            if (length >= 0) {
                int[] iArr2 = new int[length];
                int length2 = iArr.length;
                int i12 = this.f14022a;
                int i13 = length2 - i12;
                System.arraycopy(iArr, i12, iArr2, 0, i13);
                System.arraycopy(this.f14025d, 0, iArr2, i13, i12);
                this.f14022a = 0;
                this.f14023b = this.f14024c - 1;
                this.f14025d = iArr2;
                this.f14026e = length - 1;
            } else {
                throw new IllegalStateException();
            }
        }
        int i14 = (this.f14023b + 1) & this.f14026e;
        this.f14023b = i14;
        this.f14025d[i14] = i10;
        this.f14024c++;
    }
}
