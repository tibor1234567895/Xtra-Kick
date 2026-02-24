package q;

public final class i implements Cloneable {

    /* renamed from: l  reason: collision with root package name */
    public static final Object f13065l = new Object();

    /* renamed from: h  reason: collision with root package name */
    public boolean f13066h = false;

    /* renamed from: i  reason: collision with root package name */
    public long[] f13067i;

    /* renamed from: j  reason: collision with root package name */
    public Object[] f13068j;

    /* renamed from: k  reason: collision with root package name */
    public int f13069k;

    public i() {
        int i10;
        int i11 = 4;
        while (true) {
            i10 = 80;
            if (i11 >= 32) {
                break;
            }
            int i12 = (1 << i11) - 12;
            if (80 <= i12) {
                i10 = i12;
                break;
            }
            i11++;
        }
        int i13 = i10 / 8;
        this.f13067i = new long[i13];
        this.f13068j = new Object[i13];
    }

    public final void a(long j10, Long l10) {
        int i10 = this.f13069k;
        if (i10 == 0 || j10 > this.f13067i[i10 - 1]) {
            if (this.f13066h && i10 >= this.f13067i.length) {
                d();
            }
            int i11 = this.f13069k;
            if (i11 >= this.f13067i.length) {
                int i12 = (i11 + 1) * 8;
                int i13 = 4;
                while (true) {
                    if (i13 >= 32) {
                        break;
                    }
                    int i14 = (1 << i13) - 12;
                    if (i12 <= i14) {
                        i12 = i14;
                        break;
                    }
                    i13++;
                }
                int i15 = i12 / 8;
                long[] jArr = new long[i15];
                Object[] objArr = new Object[i15];
                long[] jArr2 = this.f13067i;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f13068j;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f13067i = jArr;
                this.f13068j = objArr;
            }
            this.f13067i[i11] = j10;
            this.f13068j[i11] = l10;
            this.f13069k = i11 + 1;
            return;
        }
        g(j10, l10);
    }

    public final void b() {
        int i10 = this.f13069k;
        Object[] objArr = this.f13068j;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f13069k = 0;
        this.f13066h = false;
    }

    /* renamed from: c */
    public final i clone() {
        try {
            i iVar = (i) super.clone();
            iVar.f13067i = (long[]) this.f13067i.clone();
            iVar.f13068j = (Object[]) this.f13068j.clone();
            return iVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public final void d() {
        int i10 = this.f13069k;
        long[] jArr = this.f13067i;
        Object[] objArr = this.f13068j;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f13065l) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f13066h = false;
        this.f13069k = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.f13068j[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(long r3, java.lang.Long r5) {
        /*
            r2 = this;
            long[] r0 = r2.f13067i
            int r1 = r2.f13069k
            int r3 = q.g.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r4 = r2.f13068j
            r3 = r4[r3]
            java.lang.Object r4 = f13065l
            if (r3 != r4) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q.i.e(long, java.lang.Long):java.lang.Object");
    }

    public final long f(int i10) {
        if (this.f13066h) {
            d();
        }
        return this.f13067i[i10];
    }

    public final void g(long j10, Object obj) {
        int b10 = g.b(this.f13067i, this.f13069k, j10);
        if (b10 >= 0) {
            this.f13068j[b10] = obj;
            return;
        }
        int i10 = ~b10;
        int i11 = this.f13069k;
        if (i10 < i11) {
            Object[] objArr = this.f13068j;
            if (objArr[i10] == f13065l) {
                this.f13067i[i10] = j10;
                objArr[i10] = obj;
                return;
            }
        }
        if (this.f13066h && i11 >= this.f13067i.length) {
            d();
            i10 = ~g.b(this.f13067i, this.f13069k, j10);
        }
        int i12 = this.f13069k;
        if (i12 >= this.f13067i.length) {
            int i13 = (i12 + 1) * 8;
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
            int i16 = i13 / 8;
            long[] jArr = new long[i16];
            Object[] objArr2 = new Object[i16];
            long[] jArr2 = this.f13067i;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f13068j;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f13067i = jArr;
            this.f13068j = objArr2;
        }
        int i17 = this.f13069k - i10;
        if (i17 != 0) {
            long[] jArr3 = this.f13067i;
            int i18 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i18, i17);
            Object[] objArr4 = this.f13068j;
            System.arraycopy(objArr4, i10, objArr4, i18, this.f13069k - i10);
        }
        this.f13067i[i10] = j10;
        this.f13068j[i10] = obj;
        this.f13069k++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f13068j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f13067i
            int r1 = r2.f13069k
            int r3 = q.g.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f13068j
            r0 = r4[r3]
            java.lang.Object r1 = f13065l
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f13066h = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q.i.h(long):void");
    }

    public final int i() {
        if (this.f13066h) {
            d();
        }
        return this.f13069k;
    }

    public final Object j(int i10) {
        if (this.f13066h) {
            d();
        }
        return this.f13068j[i10];
    }

    public final String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f13069k * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f13069k; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(f(i10));
            sb2.append('=');
            Object j10 = j(i10);
            if (j10 != this) {
                sb2.append(j10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
