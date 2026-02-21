package androidx.fragment.app;

import android.transition.Transition;
import g.h0;

public final class j extends h0 {

    /* renamed from: c  reason: collision with root package name */
    public final Object f1465c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1466d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1467e;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r6 == androidx.fragment.app.c0.f1349c0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r6 == androidx.fragment.app.c0.f1349c0) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(androidx.fragment.app.h2 r5, i0.f r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            r4.<init>(r5, r6)
            androidx.fragment.app.g2 r6 = r5.f1453a
            androidx.fragment.app.g2 r0 = androidx.fragment.app.g2.VISIBLE
            r1 = 0
            androidx.fragment.app.c0 r2 = r5.f1455c
            if (r6 != r0) goto L_0x001a
            if (r7 == 0) goto L_0x0028
            androidx.fragment.app.x r6 = r2.P
            if (r6 != 0) goto L_0x0013
            goto L_0x002b
        L_0x0013:
            java.lang.Object r6 = r6.f1606j
            java.lang.Object r3 = androidx.fragment.app.c0.f1349c0
            if (r6 != r3) goto L_0x002c
            goto L_0x002b
        L_0x001a:
            if (r7 == 0) goto L_0x0028
            androidx.fragment.app.x r6 = r2.P
            if (r6 != 0) goto L_0x0021
            goto L_0x002b
        L_0x0021:
            java.lang.Object r6 = r6.f1605i
            java.lang.Object r3 = androidx.fragment.app.c0.f1349c0
            if (r6 != r3) goto L_0x002c
            goto L_0x002b
        L_0x0028:
            r2.getClass()
        L_0x002b:
            r6 = r1
        L_0x002c:
            r4.f1465c = r6
            androidx.fragment.app.g2 r5 = r5.f1453a
            if (r5 != r0) goto L_0x0039
            if (r7 == 0) goto L_0x0037
            androidx.fragment.app.x r5 = r2.P
            goto L_0x0039
        L_0x0037:
            androidx.fragment.app.x r5 = r2.P
        L_0x0039:
            r5 = 1
            r4.f1466d = r5
            if (r8 == 0) goto L_0x0051
            if (r7 == 0) goto L_0x004e
            androidx.fragment.app.x r5 = r2.P
            if (r5 != 0) goto L_0x0045
            goto L_0x0051
        L_0x0045:
            java.lang.Object r5 = r5.f1607k
            java.lang.Object r6 = androidx.fragment.app.c0.f1349c0
            if (r5 != r6) goto L_0x004c
            goto L_0x0051
        L_0x004c:
            r1 = r5
            goto L_0x0051
        L_0x004e:
            r2.getClass()
        L_0x0051:
            r4.f1467e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.<init>(androidx.fragment.app.h2, i0.f, boolean, boolean):void");
    }

    public final x1 h() {
        boolean z10;
        Object obj = this.f1465c;
        x1 i10 = i(obj);
        Object obj2 = this.f1467e;
        x1 i11 = i(obj2);
        if (i10 == null || i11 == null || i10 == i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + ((h2) this.f6079a).f1455c + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
        } else if (i10 == null) {
            return i11;
        } else {
            return i10;
        }
    }

    public final x1 i(Object obj) {
        if (obj == null) {
            return null;
        }
        v1 v1Var = q1.f1552a;
        if (v1Var != null && (obj instanceof Transition)) {
            return v1Var;
        }
        x1 x1Var = q1.f1553b;
        if (x1Var != null && x1Var.e(obj)) {
            return x1Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + ((h2) this.f6079a).f1455c + " is not a valid framework Transition or AndroidX Transition");
    }
}
