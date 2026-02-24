package n3;

import java.util.List;
import ma.q;
import xa.j;

public final class q1 extends s1 {

    /* renamed from: g  reason: collision with root package name */
    public static final p1 f11420g = new p1(0);

    /* renamed from: h  reason: collision with root package name */
    public static final q1 f11421h;

    /* renamed from: a  reason: collision with root package name */
    public final d1 f11422a;

    /* renamed from: b  reason: collision with root package name */
    public final List f11423b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11424c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11425d;

    /* renamed from: e  reason: collision with root package name */
    public final c1 f11426e;

    /* renamed from: f  reason: collision with root package name */
    public final c1 f11427f;

    static {
        u5.f11511d.getClass();
        List b10 = q.b(u5.f11512e);
        z0.f11599b.getClass();
        z0 z0Var = z0.f11601d;
        z0 z0Var2 = z0.f11600c;
        f11421h = p1.a(b10, 0, 0, new c1(z0Var, z0Var2, z0Var2), (c1) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q1(d1 d1Var, List list, int i10, int i11, c1 c1Var, c1 c1Var2) {
        super(0);
        boolean z10 = false;
        this.f11422a = d1Var;
        this.f11423b = list;
        this.f11424c = i10;
        this.f11425d = i11;
        this.f11426e = c1Var;
        this.f11427f = c1Var2;
        if (d1Var == d1.APPEND || i10 >= 0) {
            if (d1Var == d1.PREPEND || i11 >= 0) {
                if (!((d1Var != d1.REFRESH || (list.isEmpty() ^ true)) ? true : z10)) {
                    throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
                }
                return;
            }
            throw new IllegalArgumentException(j.k("Append insert defining placeholdersAfter must be > 0, but was ", Integer.valueOf(i11)).toString());
        }
        throw new IllegalArgumentException(j.k("Prepend insert defining placeholdersBefore must be > 0, but was ", Integer.valueOf(i10)).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (n3.q1) r5;
        r1 = r5.f11422a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof n3.q1
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            n3.q1 r5 = (n3.q1) r5
            n3.d1 r1 = r5.f11422a
            n3.d1 r3 = r4.f11422a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.util.List r1 = r4.f11423b
            java.util.List r3 = r5.f11423b
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x001e
            return r2
        L_0x001e:
            int r1 = r4.f11424c
            int r3 = r5.f11424c
            if (r1 == r3) goto L_0x0025
            return r2
        L_0x0025:
            int r1 = r4.f11425d
            int r3 = r5.f11425d
            if (r1 == r3) goto L_0x002c
            return r2
        L_0x002c:
            n3.c1 r1 = r4.f11426e
            n3.c1 r3 = r5.f11426e
            boolean r1 = xa.j.a(r1, r3)
            if (r1 != 0) goto L_0x0037
            return r2
        L_0x0037:
            n3.c1 r1 = r4.f11427f
            n3.c1 r5 = r5.f11427f
            boolean r5 = xa.j.a(r1, r5)
            if (r5 != 0) goto L_0x0042
            return r2
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.q1.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.f11426e.hashCode() + ((((((this.f11423b.hashCode() + (this.f11422a.hashCode() * 31)) * 31) + this.f11424c) * 31) + this.f11425d) * 31)) * 31;
        c1 c1Var = this.f11427f;
        return hashCode + (c1Var == null ? 0 : c1Var.hashCode());
    }

    public final String toString() {
        return "Insert(loadType=" + this.f11422a + ", pages=" + this.f11423b + ", placeholdersBefore=" + this.f11424c + ", placeholdersAfter=" + this.f11425d + ", sourceLoadStates=" + this.f11426e + ", mediatorLoadStates=" + this.f11427f + ')';
    }
}
