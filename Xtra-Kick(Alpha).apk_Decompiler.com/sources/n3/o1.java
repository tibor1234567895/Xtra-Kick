package n3;

import xa.j;

public final class o1 extends s1 {

    /* renamed from: a  reason: collision with root package name */
    public final d1 f11371a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11372b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11373c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11374d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o1(d1 d1Var, int i10, int i11, int i12) {
        super(0);
        j.f("loadType", d1Var);
        boolean z10 = false;
        this.f11371a = d1Var;
        this.f11372b = i10;
        this.f11373c = i11;
        this.f11374d = i12;
        if (d1Var != d1.REFRESH) {
            if (a() > 0) {
                if (!(i12 >= 0 ? true : z10)) {
                    throw new IllegalArgumentException(j.k("Invalid placeholdersRemaining ", Integer.valueOf(i12)).toString());
                }
                return;
            }
            throw new IllegalArgumentException(j.k("Drop count must be > 0, but was ", Integer.valueOf(a())).toString());
        }
        throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
    }

    public final int a() {
        return (this.f11373c - this.f11372b) + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (n3.o1) r5;
        r1 = r5.f11371a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof n3.o1
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            n3.o1 r5 = (n3.o1) r5
            n3.d1 r1 = r5.f11371a
            n3.d1 r3 = r4.f11371a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            int r1 = r4.f11372b
            int r3 = r5.f11372b
            if (r1 == r3) goto L_0x001a
            return r2
        L_0x001a:
            int r1 = r4.f11373c
            int r3 = r5.f11373c
            if (r1 == r3) goto L_0x0021
            return r2
        L_0x0021:
            int r1 = r4.f11374d
            int r5 = r5.f11374d
            if (r1 == r5) goto L_0x0028
            return r2
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.o1.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (((((this.f11371a.hashCode() * 31) + this.f11372b) * 31) + this.f11373c) * 31) + this.f11374d;
    }

    public final String toString() {
        return "Drop(loadType=" + this.f11371a + ", minPageOffset=" + this.f11372b + ", maxPageOffset=" + this.f11373c + ", placeholdersRemaining=" + this.f11374d + ')';
    }
}
