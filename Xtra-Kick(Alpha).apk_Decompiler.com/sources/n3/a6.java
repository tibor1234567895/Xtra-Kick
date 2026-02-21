package n3;

import la.g;
import xa.j;

public abstract class a6 {

    /* renamed from: a  reason: collision with root package name */
    public final int f11051a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11052b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11053c;

    /* renamed from: d  reason: collision with root package name */
    public final int f11054d;

    public a6(int i10, int i11, int i12, int i13) {
        this.f11051a = i10;
        this.f11052b = i11;
        this.f11053c = i12;
        this.f11054d = i13;
    }

    public final int a(d1 d1Var) {
        j.f("loadType", d1Var);
        int ordinal = d1Var.ordinal();
        if (ordinal == 0) {
            throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
        } else if (ordinal == 1) {
            return this.f11051a;
        } else {
            if (ordinal == 2) {
                return this.f11052b;
            }
            throw new g();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (n3.a6) r5;
        r1 = r5.f11051a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof n3.a6
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            n3.a6 r5 = (n3.a6) r5
            int r1 = r5.f11051a
            int r3 = r4.f11051a
            if (r3 != r1) goto L_0x0025
            int r1 = r4.f11052b
            int r3 = r5.f11052b
            if (r1 != r3) goto L_0x0025
            int r1 = r4.f11053c
            int r3 = r5.f11053c
            if (r1 != r3) goto L_0x0025
            int r1 = r4.f11054d
            int r5 = r5.f11054d
            if (r1 != r5) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.a6.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return this.f11051a + this.f11052b + this.f11053c + this.f11054d;
    }
}
