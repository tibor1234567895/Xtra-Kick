package n1;

import c9.w;
import g1.r1;
import g1.t1;
import g1.u1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import m1.s;
import v1.a0;

public final class z {

    /* renamed from: h  reason: collision with root package name */
    public static final s f11013h = new s(1);

    /* renamed from: i  reason: collision with root package name */
    public static final Random f11014i = new Random();

    /* renamed from: a  reason: collision with root package name */
    public final t1 f11015a = new t1();

    /* renamed from: b  reason: collision with root package name */
    public final r1 f11016b = new r1();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f11017c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final w f11018d = f11013h;

    /* renamed from: e  reason: collision with root package name */
    public d0 f11019e;

    /* renamed from: f  reason: collision with root package name */
    public u1 f11020f = u1.f6622h;

    /* renamed from: g  reason: collision with root package name */
    public String f11021g;

    public final synchronized void a(b bVar) {
        d0 d0Var;
        this.f11021g = null;
        Iterator it = this.f11017c.values().iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            it.remove();
            if (yVar.f11010e && (d0Var = this.f11019e) != null) {
                ((c0) d0Var).i(bVar, yVar.f11006a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r1 == r8.f11007b) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0016 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final n1.y b(int r19, v1.a0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = r0.f11017c
            java.util.Collection r4 = r3.values()
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0016:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0082
            java.lang.Object r8 = r4.next()
            n1.y r8 = (n1.y) r8
            long r9 = r8.f11008c
            r11 = -1
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0034
            int r9 = r8.f11007b
            if (r1 != r9) goto L_0x0034
            if (r2 == 0) goto L_0x0034
            long r9 = r2.f6681d
            r8.f11008c = r9
        L_0x0034:
            r9 = 0
            v1.a0 r10 = r8.f11009d
            r13 = 1
            if (r2 != 0) goto L_0x0040
            int r14 = r8.f11007b
            if (r1 != r14) goto L_0x0064
        L_0x003e:
            r9 = 1
            goto L_0x0064
        L_0x0040:
            long r14 = r2.f6681d
            if (r10 != 0) goto L_0x0051
            boolean r16 = r20.a()
            if (r16 != 0) goto L_0x0064
            long r11 = r8.f11008c
            int r17 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r17 != 0) goto L_0x0064
            goto L_0x003e
        L_0x0051:
            long r11 = r10.f6681d
            int r17 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r17 != 0) goto L_0x0064
            int r11 = r2.f6679b
            int r12 = r10.f6679b
            if (r11 != r12) goto L_0x0064
            int r11 = r2.f6680c
            int r12 = r10.f6680c
            if (r11 != r12) goto L_0x0064
            goto L_0x003e
        L_0x0064:
            if (r9 == 0) goto L_0x0016
            long r11 = r8.f11008c
            r13 = -1
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x007f
            int r9 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0073
            goto L_0x007f
        L_0x0073:
            if (r9 != 0) goto L_0x0016
            int r9 = j1.l0.f8453a
            v1.a0 r9 = r5.f11009d
            if (r9 == 0) goto L_0x0016
            if (r10 == 0) goto L_0x0016
            r5 = r8
            goto L_0x0016
        L_0x007f:
            r5 = r8
            r6 = r11
            goto L_0x0016
        L_0x0082:
            if (r5 != 0) goto L_0x0094
            c9.w r4 = r0.f11018d
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            n1.y r5 = new n1.y
            r5.<init>(r0, r4, r1, r2)
            r3.put(r4, r5)
        L_0x0094:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.z.b(int, v1.a0):n1.y");
    }

    public final void c(b bVar) {
        a0 a0Var;
        if (bVar.f10922b.y()) {
            this.f11021g = null;
            return;
        }
        y yVar = (y) this.f11017c.get(this.f11021g);
        int i10 = bVar.f10923c;
        a0 a0Var2 = bVar.f10924d;
        this.f11021g = b(i10, a0Var2).f11006a;
        d(bVar);
        if (a0Var2 != null && a0Var2.a()) {
            long j10 = a0Var2.f6681d;
            if (yVar == null || yVar.f11008c != j10 || (a0Var = yVar.f11009d) == null || a0Var.f6679b != a0Var2.f6679b || a0Var.f6680c != a0Var2.f6680c) {
                b(i10, new a0(j10, a0Var2.f6678a));
                this.f11019e.getClass();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r1.f6681d < r3) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bf, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void d(n1.b r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            n1.d0 r0 = r8.f11019e     // Catch:{ all -> 0x00c0 }
            r0.getClass()     // Catch:{ all -> 0x00c0 }
            g1.u1 r0 = r9.f10922b     // Catch:{ all -> 0x00c0 }
            boolean r0 = r0.y()     // Catch:{ all -> 0x00c0 }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r8)
            return
        L_0x0010:
            java.util.HashMap r0 = r8.f11017c     // Catch:{ all -> 0x00c0 }
            java.lang.String r1 = r8.f11021g     // Catch:{ all -> 0x00c0 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c0 }
            n1.y r0 = (n1.y) r0     // Catch:{ all -> 0x00c0 }
            v1.a0 r1 = r9.f10924d     // Catch:{ all -> 0x00c0 }
            r2 = 1
            if (r1 == 0) goto L_0x003d
            if (r0 == 0) goto L_0x003d
            long r3 = r0.f11008c     // Catch:{ all -> 0x00c0 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0030
            int r0 = r0.f11007b     // Catch:{ all -> 0x00c0 }
            int r3 = r9.f10923c     // Catch:{ all -> 0x00c0 }
            if (r0 == r3) goto L_0x0038
            goto L_0x0036
        L_0x0030:
            long r5 = r1.f6681d     // Catch:{ all -> 0x00c0 }
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0038
        L_0x0036:
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x003d
            monitor-exit(r8)
            return
        L_0x003d:
            int r0 = r9.f10923c     // Catch:{ all -> 0x00c0 }
            n1.y r0 = r8.b(r0, r1)     // Catch:{ all -> 0x00c0 }
            java.lang.String r1 = r8.f11021g     // Catch:{ all -> 0x00c0 }
            if (r1 != 0) goto L_0x004b
            java.lang.String r1 = r0.f11006a     // Catch:{ all -> 0x00c0 }
            r8.f11021g = r1     // Catch:{ all -> 0x00c0 }
        L_0x004b:
            v1.a0 r1 = r9.f10924d     // Catch:{ all -> 0x00c0 }
            if (r1 == 0) goto L_0x009a
            boolean r1 = r1.a()     // Catch:{ all -> 0x00c0 }
            if (r1 == 0) goto L_0x009a
            v1.a0 r1 = new v1.a0     // Catch:{ all -> 0x00c0 }
            v1.a0 r3 = r9.f10924d     // Catch:{ all -> 0x00c0 }
            java.lang.Object r4 = r3.f6678a     // Catch:{ all -> 0x00c0 }
            long r5 = r3.f6681d     // Catch:{ all -> 0x00c0 }
            int r3 = r3.f6679b     // Catch:{ all -> 0x00c0 }
            r1.<init>(r3, r5, r4)     // Catch:{ all -> 0x00c0 }
            int r3 = r9.f10923c     // Catch:{ all -> 0x00c0 }
            n1.y r1 = r8.b(r3, r1)     // Catch:{ all -> 0x00c0 }
            boolean r3 = r1.f11010e     // Catch:{ all -> 0x00c0 }
            if (r3 != 0) goto L_0x009a
            r1.f11010e = r2     // Catch:{ all -> 0x00c0 }
            g1.u1 r1 = r9.f10922b     // Catch:{ all -> 0x00c0 }
            v1.a0 r3 = r9.f10924d     // Catch:{ all -> 0x00c0 }
            java.lang.Object r3 = r3.f6678a     // Catch:{ all -> 0x00c0 }
            g1.r1 r4 = r8.f11016b     // Catch:{ all -> 0x00c0 }
            r1.p(r3, r4)     // Catch:{ all -> 0x00c0 }
            g1.r1 r1 = r8.f11016b     // Catch:{ all -> 0x00c0 }
            v1.a0 r3 = r9.f10924d     // Catch:{ all -> 0x00c0 }
            int r3 = r3.f6679b     // Catch:{ all -> 0x00c0 }
            long r3 = r1.l(r3)     // Catch:{ all -> 0x00c0 }
            long r3 = j1.l0.Q(r3)     // Catch:{ all -> 0x00c0 }
            g1.r1 r1 = r8.f11016b     // Catch:{ all -> 0x00c0 }
            long r5 = r1.f6546l     // Catch:{ all -> 0x00c0 }
            long r5 = j1.l0.Q(r5)     // Catch:{ all -> 0x00c0 }
            long r3 = r3 + r5
            r5 = 0
            java.lang.Math.max(r5, r3)     // Catch:{ all -> 0x00c0 }
            n1.d0 r1 = r8.f11019e     // Catch:{ all -> 0x00c0 }
            r1.getClass()     // Catch:{ all -> 0x00c0 }
        L_0x009a:
            boolean r1 = r0.f11010e     // Catch:{ all -> 0x00c0 }
            if (r1 != 0) goto L_0x00a5
            r0.f11010e = r2     // Catch:{ all -> 0x00c0 }
            n1.d0 r1 = r8.f11019e     // Catch:{ all -> 0x00c0 }
            r1.getClass()     // Catch:{ all -> 0x00c0 }
        L_0x00a5:
            java.lang.String r1 = r0.f11006a     // Catch:{ all -> 0x00c0 }
            java.lang.String r3 = r8.f11021g     // Catch:{ all -> 0x00c0 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00c0 }
            if (r1 == 0) goto L_0x00be
            boolean r1 = r0.f11011f     // Catch:{ all -> 0x00c0 }
            if (r1 != 0) goto L_0x00be
            r0.f11011f = r2     // Catch:{ all -> 0x00c0 }
            n1.d0 r1 = r8.f11019e     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = r0.f11006a     // Catch:{ all -> 0x00c0 }
            n1.c0 r1 = (n1.c0) r1     // Catch:{ all -> 0x00c0 }
            r1.h(r9, r0)     // Catch:{ all -> 0x00c0 }
        L_0x00be:
            monitor-exit(r8)
            return
        L_0x00c0:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.z.d(n1.b):void");
    }

    public final synchronized void e(b bVar, int i10) {
        boolean z10;
        this.f11019e.getClass();
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Iterator it = this.f11017c.values().iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            if (yVar.a(bVar)) {
                it.remove();
                if (yVar.f11010e) {
                    boolean equals = yVar.f11006a.equals(this.f11021g);
                    if (z10 && equals) {
                        boolean z11 = yVar.f11011f;
                    }
                    if (equals) {
                        this.f11021g = null;
                    }
                    ((c0) this.f11019e).i(bVar, yVar.f11006a);
                }
            }
        }
        c(bVar);
    }
}
