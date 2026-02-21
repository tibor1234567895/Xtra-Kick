package u2;

import j1.a;
import j1.l0;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final u f15338a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15339b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f15340c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f15341d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15342e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f15343f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f15344g;

    /* renamed from: h  reason: collision with root package name */
    public final long f15345h;

    public x(u uVar, long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2, long j10) {
        boolean z10 = false;
        a.b(iArr.length == jArr2.length);
        a.b(jArr.length == jArr2.length);
        a.b(iArr2.length == jArr2.length ? true : z10);
        this.f15338a = uVar;
        this.f15340c = jArr;
        this.f15341d = iArr;
        this.f15342e = i10;
        this.f15343f = jArr2;
        this.f15344g = iArr2;
        this.f15345h = j10;
        this.f15339b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j10) {
        long[] jArr = this.f15343f;
        for (int b10 = l0.b(jArr, j10, true); b10 < jArr.length; b10++) {
            if ((this.f15344g[b10] & 1) != 0) {
                return b10;
            }
        }
        return -1;
    }
}
