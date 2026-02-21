package r3;

import java.util.Collections;
import java.util.Set;
import ma.d0;
import xa.j;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public final v f13766a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f13767b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f13768c;

    /* renamed from: d  reason: collision with root package name */
    public final Set f13769d;

    public w(v vVar, int[] iArr, String[] strArr) {
        boolean z10;
        Set set;
        this.f13766a = vVar;
        this.f13767b = iArr;
        this.f13768c = strArr;
        boolean z11 = true;
        if (strArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            set = Collections.singleton(strArr[0]);
            j.e("singleton(element)", set);
        } else {
            set = d0.f10804h;
        }
        this.f13769d = set;
        if (!(iArr.length != strArr.length ? false : z11)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Set r9) {
        /*
            r8 = this;
            java.lang.String r0 = "invalidatedTablesIds"
            xa.j.f(r0, r9)
            int[] r0 = r8.f13767b
            int r1 = r0.length
            r2 = 1
            if (r1 == 0) goto L_0x0043
            r3 = 0
            if (r1 == r2) goto L_0x0034
            na.l r1 = new na.l
            r1.<init>()
            int r4 = r0.length
            r5 = 0
        L_0x0015:
            if (r3 >= r4) goto L_0x0030
            r6 = r0[r3]
            int r7 = r5 + 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r6 = r9.contains(r6)
            if (r6 == 0) goto L_0x002c
            java.lang.String[] r6 = r8.f13768c
            r5 = r6[r5]
            r1.add(r5)
        L_0x002c:
            int r3 = r3 + 1
            r5 = r7
            goto L_0x0015
        L_0x0030:
            ma.n0.a(r1)
            goto L_0x0045
        L_0x0034:
            r0 = r0[r3]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r9 = r9.contains(r0)
            if (r9 == 0) goto L_0x0043
            java.util.Set r1 = r8.f13769d
            goto L_0x0045
        L_0x0043:
            ma.d0 r1 = ma.d0.f10804h
        L_0x0045:
            boolean r9 = r1.isEmpty()
            r9 = r9 ^ r2
            if (r9 == 0) goto L_0x0051
            r3.v r9 = r8.f13766a
            r9.b(r1)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.w.a(java.util.Set):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String[] r12) {
        /*
            r11 = this;
            java.lang.String[] r0 = r11.f13768c
            int r1 = r0.length
            r2 = 1
            if (r1 == 0) goto L_0x0045
            r3 = 0
            if (r1 == r2) goto L_0x002d
            na.l r1 = new na.l
            r1.<init>()
            int r4 = r12.length
            r5 = 0
        L_0x0010:
            if (r5 >= r4) goto L_0x0029
            r6 = r12[r5]
            int r7 = r0.length
            r8 = 0
        L_0x0016:
            if (r8 >= r7) goto L_0x0026
            r9 = r0[r8]
            boolean r10 = fb.w.g(r9, r6)
            if (r10 == 0) goto L_0x0023
            r1.add(r9)
        L_0x0023:
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0026:
            int r5 = r5 + 1
            goto L_0x0010
        L_0x0029:
            ma.n0.a(r1)
            goto L_0x0047
        L_0x002d:
            int r1 = r12.length
            r4 = 0
        L_0x002f:
            if (r4 >= r1) goto L_0x0040
            r5 = r12[r4]
            r6 = r0[r3]
            boolean r5 = fb.w.g(r5, r6)
            if (r5 == 0) goto L_0x003d
            r3 = 1
            goto L_0x0040
        L_0x003d:
            int r4 = r4 + 1
            goto L_0x002f
        L_0x0040:
            if (r3 == 0) goto L_0x0045
            java.util.Set r1 = r11.f13769d
            goto L_0x0047
        L_0x0045:
            ma.d0 r1 = ma.d0.f10804h
        L_0x0047:
            boolean r12 = r1.isEmpty()
            r12 = r12 ^ r2
            if (r12 == 0) goto L_0x0053
            r3.v r12 = r11.f13766a
            r12.b(r1)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.w.b(java.lang.String[]):void");
    }
}
