package z1;

import a2.d;
import a2.h;
import android.os.SystemClock;
import d9.o0;
import d9.r0;
import d9.v0;
import g1.a0;
import g1.v1;
import j1.d0;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.List;
import x1.b;

public final class c extends d {

    /* renamed from: g  reason: collision with root package name */
    public final d f17372g;

    /* renamed from: h  reason: collision with root package name */
    public final long f17373h;

    /* renamed from: i  reason: collision with root package name */
    public final long f17374i;

    /* renamed from: j  reason: collision with root package name */
    public final long f17375j;

    /* renamed from: k  reason: collision with root package name */
    public final int f17376k;

    /* renamed from: l  reason: collision with root package name */
    public final int f17377l;

    /* renamed from: m  reason: collision with root package name */
    public final float f17378m;

    /* renamed from: n  reason: collision with root package name */
    public final float f17379n;

    /* renamed from: o  reason: collision with root package name */
    public final r0 f17380o;

    /* renamed from: p  reason: collision with root package name */
    public final j1.d f17381p;

    /* renamed from: q  reason: collision with root package name */
    public float f17382q;

    /* renamed from: r  reason: collision with root package name */
    public int f17383r;

    /* renamed from: s  reason: collision with root package name */
    public int f17384s;

    /* renamed from: t  reason: collision with root package name */
    public long f17385t;

    /* renamed from: u  reason: collision with root package name */
    public b f17386u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(v1 v1Var, int[] iArr, int i10, d dVar, long j10, long j11, long j12, int i11, int i12, float f10, float f11, r0 r0Var, j1.d dVar2) {
        super(v1Var, iArr);
        d dVar3;
        long j13;
        if (j12 < j10) {
            v.g("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            dVar3 = dVar;
            j13 = j10;
        } else {
            dVar3 = dVar;
            j13 = j12;
        }
        this.f17372g = dVar3;
        this.f17373h = j10 * 1000;
        this.f17374i = j11 * 1000;
        this.f17375j = j13 * 1000;
        this.f17376k = i11;
        this.f17377l = i12;
        this.f17378m = f10;
        this.f17379n = f11;
        this.f17380o = r0.j(r0Var);
        this.f17381p = dVar2;
        this.f17382q = 1.0f;
        this.f17384s = 0;
        this.f17385t = -9223372036854775807L;
    }

    public static void u(ArrayList arrayList, long[] jArr) {
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            o0 o0Var = (o0) arrayList.get(i10);
            if (o0Var != null) {
                o0Var.c(new a(j10, jArr[i10]));
            }
        }
    }

    public static long w(List list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        b bVar = (b) v0.a(list);
        long j10 = bVar.f16560g;
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j11 = bVar.f16561h;
        if (j11 != -9223372036854775807L) {
            return j11 - j10;
        }
        return -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(long r14, long r16, long r18, java.util.List r20, x1.d[] r21) {
        /*
            r13 = this;
            r0 = r13
            r1 = r21
            j1.d r2 = r0.f17381p
            j1.d0 r2 = (j1.d0) r2
            r2.getClass()
            long r2 = android.os.SystemClock.elapsedRealtime()
            int r4 = r0.f17383r
            int r5 = r1.length
            r6 = 0
            if (r4 >= r5) goto L_0x0029
            r4 = r1[r4]
            boolean r4 = r4.next()
            if (r4 == 0) goto L_0x0029
            int r4 = r0.f17383r
            r1 = r1[r4]
            long r4 = r1.a()
            long r7 = r1.b()
            goto L_0x003d
        L_0x0029:
            int r4 = r1.length
            r5 = 0
        L_0x002b:
            if (r5 >= r4) goto L_0x0042
            r7 = r1[r5]
            boolean r8 = r7.next()
            if (r8 == 0) goto L_0x003f
            long r4 = r7.a()
            long r7 = r7.b()
        L_0x003d:
            long r4 = r4 - r7
            goto L_0x0046
        L_0x003f:
            int r5 = r5 + 1
            goto L_0x002b
        L_0x0042:
            long r4 = w(r20)
        L_0x0046:
            int r1 = r0.f17384s
            if (r1 != 0) goto L_0x0054
            r1 = 1
            r0.f17384s = r1
            int r1 = r13.v(r2)
            r0.f17383r = r1
            return
        L_0x0054:
            int r7 = r0.f17383r
            boolean r8 = r20.isEmpty()
            g1.a0[] r9 = r0.f17390d
            r10 = -1
            if (r8 == 0) goto L_0x0061
        L_0x005f:
            r6 = -1
            goto L_0x0075
        L_0x0061:
            java.lang.Object r8 = d9.v0.a(r20)
            x1.b r8 = (x1.b) r8
            g1.a0 r8 = r8.f16557d
        L_0x0069:
            int r11 = r0.f17388b
            if (r6 >= r11) goto L_0x005f
            r11 = r9[r6]
            if (r11 != r8) goto L_0x0072
            goto L_0x0075
        L_0x0072:
            int r6 = r6 + 1
            goto L_0x0069
        L_0x0075:
            if (r6 == r10) goto L_0x0080
            java.lang.Object r1 = d9.v0.a(r20)
            x1.b r1 = (x1.b) r1
            int r1 = r1.f16558e
            r7 = r6
        L_0x0080:
            int r6 = r13.v(r2)
            boolean r2 = r13.b(r7, r2)
            if (r2 != 0) goto L_0x00c1
            r2 = r9[r7]
            r3 = r9[r6]
            long r8 = r0.f17373h
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x009a
            goto L_0x00ad
        L_0x009a:
            int r12 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x00a1
            long r4 = r18 - r4
            goto L_0x00a3
        L_0x00a1:
            r4 = r18
        L_0x00a3:
            float r4 = (float) r4
            float r5 = r0.f17379n
            float r4 = r4 * r5
            long r4 = (long) r4
            long r8 = java.lang.Math.min(r4, r8)
        L_0x00ad:
            int r3 = r3.f6272o
            int r2 = r2.f6272o
            if (r3 <= r2) goto L_0x00b8
            int r4 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b8
            goto L_0x00c0
        L_0x00b8:
            if (r3 >= r2) goto L_0x00c1
            long r2 = r0.f17374i
            int r4 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x00c1
        L_0x00c0:
            r6 = r7
        L_0x00c1:
            if (r6 != r7) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r1 = 3
        L_0x00c5:
            r0.f17384s = r1
            r0.f17383r = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.c.c(long, long, long, java.util.List, x1.d[]):void");
    }

    public final void f() {
        this.f17385t = -9223372036854775807L;
        this.f17386u = null;
    }

    public final int h(long j10, List list) {
        boolean z10;
        b bVar;
        int i10;
        int i11;
        ((d0) this.f17381p).getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = this.f17385t;
        if (j11 == -9223372036854775807L || elapsedRealtime - j11 >= 1000 || (!list.isEmpty() && !((b) v0.a(list)).equals(this.f17386u))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return list.size();
        }
        this.f17385t = elapsedRealtime;
        if (list.isEmpty()) {
            bVar = null;
        } else {
            bVar = (b) v0.a(list);
        }
        this.f17386u = bVar;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long v10 = l0.v(((b) list.get(size - 1)).f16560g - j10, this.f17382q);
        long j12 = this.f17375j;
        if (v10 < j12) {
            return size;
        }
        w(list);
        a0 a0Var = this.f17390d[v(elapsedRealtime)];
        for (int i12 = 0; i12 < size; i12++) {
            b bVar2 = (b) list.get(i12);
            a0 a0Var2 = bVar2.f16557d;
            if (l0.v(bVar2.f16560g - j10, this.f17382q) >= j12 && a0Var2.f6272o < a0Var.f6272o && (i10 = a0Var2.f6282y) != -1 && i10 <= this.f17377l && (i11 = a0Var2.f6281x) != -1 && i11 <= this.f17376k && i10 < a0Var.f6282y) {
                return i12;
            }
        }
        return size;
    }

    public final void j() {
        this.f17386u = null;
    }

    public final int n() {
        return this.f17384s;
    }

    public final int o() {
        return this.f17383r;
    }

    public final void p(float f10) {
        this.f17382q = f10;
    }

    public final Object q() {
        return null;
    }

    public final int v(long j10) {
        long j11;
        boolean z10;
        h hVar = (h) this.f17372g;
        synchronized (hVar) {
            j11 = hVar.f52l;
        }
        this.f17372g.getClass();
        long j12 = (long) (((float) ((long) (((float) j11) * this.f17378m))) / this.f17382q);
        if (!this.f17380o.isEmpty()) {
            int i10 = 1;
            while (i10 < this.f17380o.size() - 1 && ((a) this.f17380o.get(i10)).f17362a < j12) {
                i10++;
            }
            a aVar = (a) this.f17380o.get(i10 - 1);
            a aVar2 = (a) this.f17380o.get(i10);
            long j13 = aVar.f17362a;
            long j14 = aVar.f17363b;
            j12 = ((long) ((((float) (j12 - j13)) / ((float) (aVar2.f17362a - j13))) * ((float) (aVar2.f17363b - j14)))) + j14;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f17388b; i12++) {
            if (j10 == Long.MIN_VALUE || !b(i12, j10)) {
                if (((long) this.f17390d[i12].f6272o) <= j12) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return i12;
                }
                i11 = i12;
            }
        }
        return i11;
    }
}
