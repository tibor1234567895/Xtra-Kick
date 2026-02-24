package q;

public final class l implements Cloneable {

    /* renamed from: l  reason: collision with root package name */
    public static final Object f13082l = new Object();

    /* renamed from: h  reason: collision with root package name */
    public boolean f13083h = false;

    /* renamed from: i  reason: collision with root package name */
    public int[] f13084i;

    /* renamed from: j  reason: collision with root package name */
    public Object[] f13085j;

    /* renamed from: k  reason: collision with root package name */
    public int f13086k;

    public l() {
        int i10;
        int i11 = 4;
        while (true) {
            i10 = 40;
            if (i11 >= 32) {
                break;
            }
            int i12 = (1 << i11) - 12;
            if (40 <= i12) {
                i10 = i12;
                break;
            }
            i11++;
        }
        int i13 = i10 / 4;
        this.f13084i = new int[i13];
        this.f13085j = new Object[i13];
    }

    public final void a(int i10, Object obj) {
        int i11 = this.f13086k;
        if (i11 == 0 || i10 > this.f13084i[i11 - 1]) {
            if (this.f13083h && i11 >= this.f13084i.length) {
                c();
            }
            int i12 = this.f13086k;
            if (i12 >= this.f13084i.length) {
                int i13 = (i12 + 1) * 4;
                int i14 = 4;
                while (true) {
                    if (i14 >= 32) {
                        break;
                    }
                    int i15 = (1 << i14) - 12;
                    if (i13 <= i15) {
                        i13 = i15;
                        break;
                    }
                    i14++;
                }
                int i16 = i13 / 4;
                int[] iArr = new int[i16];
                Object[] objArr = new Object[i16];
                int[] iArr2 = this.f13084i;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f13085j;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f13084i = iArr;
                this.f13085j = objArr;
            }
            this.f13084i[i12] = i10;
            this.f13085j[i12] = obj;
            this.f13086k = i12 + 1;
            return;
        }
        f(i10, obj);
    }

    /* renamed from: b */
    public final l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.f13084i = (int[]) this.f13084i.clone();
            lVar.f13085j = (Object[]) this.f13085j.clone();
            return lVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void c() {
        int i10 = this.f13086k;
        int[] iArr = this.f13084i;
        Object[] objArr = this.f13085j;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f13082l) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f13083h = false;
        this.f13086k = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.f13085j[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(int r3, java.lang.Integer r4) {
        /*
            r2 = this;
            int[] r0 = r2.f13084i
            int r1 = r2.f13086k
            int r3 = q.g.a(r1, r3, r0)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r0 = r2.f13085j
            r3 = r0[r3]
            java.lang.Object r0 = f13082l
            if (r3 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q.l.d(int, java.lang.Integer):java.lang.Object");
    }

    public final int e(int i10) {
        if (this.f13083h) {
            c();
        }
        return this.f13084i[i10];
    }

    public final void f(int i10, Object obj) {
        int a10 = g.a(this.f13086k, i10, this.f13084i);
        if (a10 >= 0) {
            this.f13085j[a10] = obj;
            return;
        }
        int i11 = ~a10;
        int i12 = this.f13086k;
        if (i11 < i12) {
            Object[] objArr = this.f13085j;
            if (objArr[i11] == f13082l) {
                this.f13084i[i11] = i10;
                objArr[i11] = obj;
                return;
            }
        }
        if (this.f13083h && i12 >= this.f13084i.length) {
            c();
            i11 = ~g.a(this.f13086k, i10, this.f13084i);
        }
        int i13 = this.f13086k;
        if (i13 >= this.f13084i.length) {
            int i14 = (i13 + 1) * 4;
            int i15 = 4;
            while (true) {
                if (i15 >= 32) {
                    break;
                }
                int i16 = (1 << i15) - 12;
                if (i14 <= i16) {
                    i14 = i16;
                    break;
                }
                i15++;
            }
            int i17 = i14 / 4;
            int[] iArr = new int[i17];
            Object[] objArr2 = new Object[i17];
            int[] iArr2 = this.f13084i;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f13085j;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f13084i = iArr;
            this.f13085j = objArr2;
        }
        int i18 = this.f13086k - i11;
        if (i18 != 0) {
            int[] iArr3 = this.f13084i;
            int i19 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i19, i18);
            Object[] objArr4 = this.f13085j;
            System.arraycopy(objArr4, i11, objArr4, i19, this.f13086k - i11);
        }
        this.f13084i[i11] = i10;
        this.f13085j[i11] = obj;
        this.f13086k++;
    }

    public final int g() {
        if (this.f13083h) {
            c();
        }
        return this.f13086k;
    }

    public final Object h(int i10) {
        if (this.f13083h) {
            c();
        }
        return this.f13085j[i10];
    }

    public final String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f13086k * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f13086k; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(e(i10));
            sb2.append('=');
            Object h10 = h(i10);
            if (h10 != this) {
                sb2.append(h10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
