package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public final class l0 implements LayoutInflater.Factory2 {

    /* renamed from: h  reason: collision with root package name */
    public final c1 f1479h;

    public l0(c1 c1Var) {
        this.f1479h = c1Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ca, code lost:
        if (androidx.fragment.app.c1.I(2) != false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e8, code lost:
        if (androidx.fragment.app.c1.I(2) != false) goto L_0x00ea;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r11, java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r10 = this;
            java.lang.Class<androidx.fragment.app.FragmentContainerView> r0 = androidx.fragment.app.FragmentContainerView.class
            java.lang.String r0 = r0.getName()
            boolean r0 = r0.equals(r12)
            androidx.fragment.app.c1 r1 = r10.f1479h
            if (r0 == 0) goto L_0x0014
            androidx.fragment.app.FragmentContainerView r11 = new androidx.fragment.app.FragmentContainerView
            r11.<init>(r13, r14, r1)
            return r11
        L_0x0014:
            java.lang.String r0 = "fragment"
            boolean r12 = r0.equals(r12)
            r0 = 0
            if (r12 != 0) goto L_0x001e
            return r0
        L_0x001e:
            java.lang.String r12 = "class"
            java.lang.String r12 = r14.getAttributeValue(r0, r12)
            int[] r2 = y0.a.f16856a
            android.content.res.TypedArray r2 = r13.obtainStyledAttributes(r14, r2)
            r3 = 0
            if (r12 != 0) goto L_0x0031
            java.lang.String r12 = r2.getString(r3)
        L_0x0031:
            r4 = 1
            r5 = -1
            int r6 = r2.getResourceId(r4, r5)
            r7 = 2
            java.lang.String r8 = r2.getString(r7)
            r2.recycle()
            if (r12 == 0) goto L_0x0195
            java.lang.ClassLoader r2 = r13.getClassLoader()
            java.lang.Class r2 = androidx.fragment.app.j0.b(r2, r12)     // Catch:{ ClassNotFoundException -> 0x0050 }
            java.lang.Class<androidx.fragment.app.c0> r9 = androidx.fragment.app.c0.class
            boolean r2 = r9.isAssignableFrom(r2)     // Catch:{ ClassNotFoundException -> 0x0050 }
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            if (r2 != 0) goto L_0x0055
            goto L_0x0195
        L_0x0055:
            if (r11 == 0) goto L_0x005c
            int r2 = r11.getId()
            goto L_0x005d
        L_0x005c:
            r2 = 0
        L_0x005d:
            if (r2 != r5) goto L_0x0082
            if (r6 != r5) goto L_0x0082
            if (r8 == 0) goto L_0x0064
            goto L_0x0082
        L_0x0064:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r14.getPositionDescription()
            r13.append(r14)
            java.lang.String r14 = ": Must specify unique android:id, android:tag, or have a parent with an id for "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r11.<init>(r12)
            throw r11
        L_0x0082:
            if (r6 == r5) goto L_0x0088
            androidx.fragment.app.c0 r0 = r1.D(r6)
        L_0x0088:
            if (r0 != 0) goto L_0x0090
            if (r8 == 0) goto L_0x0090
            androidx.fragment.app.c0 r0 = r1.E(r8)
        L_0x0090:
            if (r0 != 0) goto L_0x0098
            if (r2 == r5) goto L_0x0098
            androidx.fragment.app.c0 r0 = r1.D(r2)
        L_0x0098:
            if (r0 != 0) goto L_0x00cd
            androidx.fragment.app.j0 r0 = r1.G()
            java.lang.ClassLoader r13 = r13.getClassLoader()
            androidx.fragment.app.c0 r0 = r0.a(r13, r12)
            r0.f1365u = r4
            if (r6 == 0) goto L_0x00ac
            r13 = r6
            goto L_0x00ad
        L_0x00ac:
            r13 = r2
        L_0x00ad:
            r0.D = r13
            r0.E = r2
            r0.F = r8
            r0.f1366v = r4
            r0.f1370z = r1
            androidx.fragment.app.e0 r13 = r1.f1392v
            r0.A = r13
            android.content.Context r13 = r13.f1403i
            android.os.Bundle r2 = r0.f1353i
            r0.T(r13, r14, r2)
            androidx.fragment.app.m1 r13 = r1.a(r0)
            boolean r14 = androidx.fragment.app.c1.I(r7)
            if (r14 == 0) goto L_0x00f0
            goto L_0x00ea
        L_0x00cd:
            boolean r13 = r0.f1366v
            if (r13 != 0) goto L_0x0157
            r0.f1366v = r4
            r0.f1370z = r1
            androidx.fragment.app.e0 r13 = r1.f1392v
            r0.A = r13
            android.content.Context r13 = r13.f1403i
            android.os.Bundle r2 = r0.f1353i
            r0.T(r13, r14, r2)
            androidx.fragment.app.m1 r13 = r1.f(r0)
            boolean r14 = androidx.fragment.app.c1.I(r7)
            if (r14 == 0) goto L_0x00f0
        L_0x00ea:
            r0.toString()
            java.lang.Integer.toHexString(r6)
        L_0x00f0:
            android.view.ViewGroup r11 = (android.view.ViewGroup) r11
            z0.d r14 = z0.d.f17359a
            z0.e r14 = new z0.e
            r14.<init>(r0, r11, r3)
            z0.d r1 = z0.d.f17359a
            r1.getClass()
            z0.d.c(r14)
            z0.c r1 = z0.d.a(r0)
            java.util.Set r2 = r1.f17357a
            z0.a r3 = z0.a.DETECT_FRAGMENT_TAG_USAGE
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x011e
            java.lang.Class r2 = r0.getClass()
            java.lang.Class<z0.e> r3 = z0.e.class
            boolean r2 = z0.d.e(r1, r2, r3)
            if (r2 == 0) goto L_0x011e
            z0.d.b(r1, r14)
        L_0x011e:
            r0.L = r11
            r13.k()
            r13.j()
            android.view.View r11 = r0.M
            if (r11 == 0) goto L_0x0149
            if (r6 == 0) goto L_0x012f
            r11.setId(r6)
        L_0x012f:
            android.view.View r11 = r0.M
            java.lang.Object r11 = r11.getTag()
            if (r11 != 0) goto L_0x013c
            android.view.View r11 = r0.M
            r11.setTag(r8)
        L_0x013c:
            android.view.View r11 = r0.M
            androidx.fragment.app.k0 r12 = new androidx.fragment.app.k0
            r12.<init>((androidx.fragment.app.l0) r10, (androidx.fragment.app.m1) r13)
            r11.addOnAttachStateChangeListener(r12)
            android.view.View r11 = r0.M
            return r11
        L_0x0149:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r13 = "Fragment "
            java.lang.String r14 = " did not create a view."
            java.lang.String r12 = android.support.v4.media.h.n(r13, r12, r14)
            r11.<init>(r12)
            throw r11
        L_0x0157:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r14.getPositionDescription()
            r13.append(r14)
            java.lang.String r14 = ": Duplicate id 0x"
            r13.append(r14)
            java.lang.String r14 = java.lang.Integer.toHexString(r6)
            r13.append(r14)
            java.lang.String r14 = ", tag "
            r13.append(r14)
            r13.append(r8)
            java.lang.String r14 = ", or parent id 0x"
            r13.append(r14)
            java.lang.String r14 = java.lang.Integer.toHexString(r2)
            r13.append(r14)
            java.lang.String r14 = " with another fragment for "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r11.<init>(r12)
            throw r11
        L_0x0195:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }
}
