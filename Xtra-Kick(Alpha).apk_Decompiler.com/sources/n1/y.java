package n1;

import g1.u1;
import v1.a0;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final String f11006a;

    /* renamed from: b  reason: collision with root package name */
    public int f11007b;

    /* renamed from: c  reason: collision with root package name */
    public long f11008c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f11009d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11010e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11011f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ z f11012g;

    public y(z zVar, String str, int i10, a0 a0Var) {
        this.f11012g = zVar;
        this.f11006a = str;
        this.f11007b = i10;
        this.f11008c = a0Var == null ? -1 : a0Var.f6681d;
        if (a0Var != null && a0Var.a()) {
            this.f11009d = a0Var;
        }
    }

    public final boolean a(b bVar) {
        a0 a0Var = bVar.f10924d;
        if (a0Var == null) {
            return this.f11007b != bVar.f10923c;
        }
        long j10 = this.f11008c;
        if (j10 == -1) {
            return false;
        }
        if (a0Var.f6681d > j10) {
            return true;
        }
        a0 a0Var2 = this.f11009d;
        if (a0Var2 == null) {
            return false;
        }
        u1 u1Var = bVar.f10922b;
        int k10 = u1Var.k(a0Var.f6678a);
        int k11 = u1Var.k(a0Var2.f6678a);
        if (a0Var.f6681d < a0Var2.f6681d || k10 < k11) {
            return false;
        }
        if (k10 > k11) {
            return true;
        }
        boolean a10 = a0Var.a();
        int i10 = a0Var2.f6679b;
        if (a10) {
            int i11 = a0Var.f6679b;
            if (i11 <= i10) {
                return i11 == i10 && a0Var.f6680c > a0Var2.f6680c;
            }
            return true;
        }
        int i12 = a0Var.f6682e;
        return i12 == -1 || i12 > i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 < r8.x()) goto L_0x0038;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(g1.u1 r7, g1.u1 r8) {
        /*
            r6 = this;
            int r0 = r6.f11007b
            int r1 = r7.x()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L_0x0013
            int r7 = r8.x()
            if (r0 >= r7) goto L_0x0011
            goto L_0x0038
        L_0x0011:
            r0 = -1
            goto L_0x0038
        L_0x0013:
            n1.z r1 = r6.f11012g
            g1.t1 r4 = r1.f11015a
            r7.v(r0, r4)
            g1.t1 r0 = r1.f11015a
            int r4 = r0.f6589v
        L_0x001e:
            int r5 = r0.f6590w
            if (r4 > r5) goto L_0x0011
            java.lang.Object r5 = r7.u(r4)
            int r5 = r8.k(r5)
            if (r5 == r3) goto L_0x0035
            g1.r1 r7 = r1.f11016b
            g1.r1 r7 = r8.o(r5, r7, r2)
            int r0 = r7.f6544j
            goto L_0x0038
        L_0x0035:
            int r4 = r4 + 1
            goto L_0x001e
        L_0x0038:
            r6.f11007b = r0
            if (r0 != r3) goto L_0x003d
            return r2
        L_0x003d:
            r7 = 1
            v1.a0 r0 = r6.f11009d
            if (r0 != 0) goto L_0x0043
            return r7
        L_0x0043:
            java.lang.Object r0 = r0.f6678a
            int r8 = r8.k(r0)
            if (r8 == r3) goto L_0x004c
            r2 = 1
        L_0x004c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.y.b(g1.u1, g1.u1):boolean");
    }
}
