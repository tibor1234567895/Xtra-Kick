package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import i0.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.WeakHashMap;
import la.v;
import m0.c1;
import m0.g1;
import m0.l0;
import m0.o0;
import ma.z;
import q.e;
import xa.j;

public final class n {

    /* renamed from: f  reason: collision with root package name */
    public static final c2 f1505f = new c2(0);

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f1506a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1507b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1508c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1509d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1510e;

    public n(ViewGroup viewGroup) {
        j.f("container", viewGroup);
        this.f1506a = viewGroup;
    }

    public static void a(ArrayList arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!g1.b(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt.getVisibility() == 0) {
                        a(arrayList, childAt);
                    }
                }
                return;
            } else if (arrayList.contains(view)) {
                return;
            }
        } else if (arrayList.contains(view)) {
            return;
        }
        arrayList.add(view);
    }

    public static void e(e eVar, View view) {
        WeakHashMap weakHashMap = c1.f10054a;
        String k10 = o0.k(view);
        if (k10 != null) {
            eVar.put(k10, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    e(eVar, childAt);
                }
            }
        }
    }

    public static final n h(ViewGroup viewGroup, c1 c1Var) {
        f1505f.getClass();
        j.f("container", viewGroup);
        j.f("fragmentManager", c1Var);
        p0 H = c1Var.H();
        j.e("fragmentManager.specialEffectsControllerFactory", H);
        return c2.a(viewGroup, H);
    }

    public final void b(g2 g2Var, e2 e2Var, m1 m1Var) {
        synchronized (this.f1507b) {
            f fVar = new f();
            c0 c0Var = m1Var.f1502c;
            j.e("fragmentStateManager.fragment", c0Var);
            h2 f10 = f(c0Var);
            if (f10 != null) {
                f10.c(g2Var, e2Var);
            } else {
                d2 d2Var = new d2(g2Var, e2Var, m1Var, fVar);
                this.f1507b.add(d2Var);
                d2Var.f1456d.add(new b2(this, d2Var, 0));
                d2Var.f1456d.add(new b2(this, d2Var, 1));
                v vVar = v.f9814a;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.fragment.app.h2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: androidx.fragment.app.h2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v46, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v82, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: androidx.fragment.app.h2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v89, resolved type: androidx.fragment.app.h2} */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x07f2, code lost:
        if (androidx.fragment.app.c1.I(2) != false) goto L_0x07fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x07fc, code lost:
        if (androidx.fragment.app.c1.I(2) != false) goto L_0x07fe;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0580  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x05a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(boolean r34, java.util.ArrayList r35) {
        /*
            r33 = this;
            r6 = r33
            r0 = r34
            java.util.Iterator r1 = r35.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            r7 = 1
            java.lang.String r4 = "operation.fragment.mView"
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r1.next()
            r5 = r2
            androidx.fragment.app.h2 r5 = (androidx.fragment.app.h2) r5
            androidx.fragment.app.f2 r9 = androidx.fragment.app.g2.f1435h
            androidx.fragment.app.c0 r10 = r5.f1455c
            android.view.View r10 = r10.M
            xa.j.e(r4, r10)
            r9.getClass()
            androidx.fragment.app.g2 r9 = androidx.fragment.app.f2.a(r10)
            androidx.fragment.app.g2 r10 = androidx.fragment.app.g2.VISIBLE
            if (r9 != r10) goto L_0x0032
            androidx.fragment.app.g2 r5 = r5.f1453a
            if (r5 == r10) goto L_0x0032
            r5 = 1
            goto L_0x0033
        L_0x0032:
            r5 = 0
        L_0x0033:
            if (r5 == 0) goto L_0x0008
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            r9 = r2
            androidx.fragment.app.h2 r9 = (androidx.fragment.app.h2) r9
            int r1 = r35.size()
            r2 = r35
            java.util.ListIterator r1 = r2.listIterator(r1)
        L_0x0044:
            boolean r5 = r1.hasPrevious()
            if (r5 == 0) goto L_0x006f
            java.lang.Object r5 = r1.previous()
            r10 = r5
            androidx.fragment.app.h2 r10 = (androidx.fragment.app.h2) r10
            androidx.fragment.app.f2 r11 = androidx.fragment.app.g2.f1435h
            androidx.fragment.app.c0 r12 = r10.f1455c
            android.view.View r12 = r12.M
            xa.j.e(r4, r12)
            r11.getClass()
            androidx.fragment.app.g2 r11 = androidx.fragment.app.f2.a(r12)
            androidx.fragment.app.g2 r12 = androidx.fragment.app.g2.VISIBLE
            if (r11 == r12) goto L_0x006b
            androidx.fragment.app.g2 r10 = r10.f1453a
            if (r10 != r12) goto L_0x006b
            r10 = 1
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x0044
            goto L_0x0070
        L_0x006f:
            r5 = 0
        L_0x0070:
            r10 = r5
            androidx.fragment.app.h2 r10 = (androidx.fragment.app.h2) r10
            r11 = 2
            boolean r1 = androidx.fragment.app.c1.I(r11)
            if (r1 == 0) goto L_0x0080
            java.util.Objects.toString(r9)
            java.util.Objects.toString(r10)
        L_0x0080:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r12 = ma.z.K(r35)
            java.lang.Object r13 = ma.z.z(r35)
            androidx.fragment.app.h2 r13 = (androidx.fragment.app.h2) r13
            androidx.fragment.app.c0 r13 = r13.f1455c
            java.util.Iterator r14 = r35.iterator()
        L_0x009a:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x00be
            java.lang.Object r15 = r14.next()
            androidx.fragment.app.h2 r15 = (androidx.fragment.app.h2) r15
            androidx.fragment.app.c0 r15 = r15.f1455c
            androidx.fragment.app.x r15 = r15.P
            androidx.fragment.app.x r8 = r13.P
            int r11 = r8.f1598b
            r15.f1598b = r11
            int r11 = r8.f1599c
            r15.f1599c = r11
            int r11 = r8.f1600d
            r15.f1600d = r11
            int r8 = r8.f1601e
            r15.f1601e = r8
            r11 = 2
            goto L_0x009a
        L_0x00be:
            java.util.Iterator r2 = r35.iterator()
        L_0x00c2:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x010d
            java.lang.Object r8 = r2.next()
            androidx.fragment.app.h2 r8 = (androidx.fragment.app.h2) r8
            i0.f r11 = new i0.f
            r11.<init>()
            r8.d()
            java.util.LinkedHashSet r13 = r8.f1457e
            r13.add(r11)
            androidx.fragment.app.i r13 = new androidx.fragment.app.i
            r13.<init>(r8, r11, r0)
            r1.add(r13)
            i0.f r11 = new i0.f
            r11.<init>()
            r8.d()
            java.util.LinkedHashSet r13 = r8.f1457e
            r13.add(r11)
            androidx.fragment.app.j r13 = new androidx.fragment.app.j
            if (r0 == 0) goto L_0x00f7
            if (r8 != r9) goto L_0x00fb
            goto L_0x00f9
        L_0x00f7:
            if (r8 != r10) goto L_0x00fb
        L_0x00f9:
            r14 = 1
            goto L_0x00fc
        L_0x00fb:
            r14 = 0
        L_0x00fc:
            r13.<init>(r8, r11, r0, r14)
            r5.add(r13)
            androidx.emoji2.text.r r11 = new androidx.emoji2.text.r
            r11.<init>(r12, r8, r6, r7)
            java.util.ArrayList r8 = r8.f1456d
            r8.add(r11)
            goto L_0x00c2
        L_0x010d:
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r11 = r5.iterator()
        L_0x011b:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0132
            java.lang.Object r13 = r11.next()
            r14 = r13
            androidx.fragment.app.j r14 = (androidx.fragment.app.j) r14
            boolean r14 = r14.e()
            if (r14 != 0) goto L_0x011b
            r2.add(r13)
            goto L_0x011b
        L_0x0132:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x013b:
            boolean r13 = r2.hasNext()
            if (r13 == 0) goto L_0x0157
            java.lang.Object r13 = r2.next()
            r14 = r13
            androidx.fragment.app.j r14 = (androidx.fragment.app.j) r14
            androidx.fragment.app.x1 r14 = r14.h()
            if (r14 == 0) goto L_0x0150
            r14 = 1
            goto L_0x0151
        L_0x0150:
            r14 = 0
        L_0x0151:
            if (r14 == 0) goto L_0x013b
            r11.add(r13)
            goto L_0x013b
        L_0x0157:
            java.util.Iterator r2 = r11.iterator()
            r11 = 0
        L_0x015c:
            boolean r13 = r2.hasNext()
            if (r13 == 0) goto L_0x01a5
            java.lang.Object r13 = r2.next()
            androidx.fragment.app.j r13 = (androidx.fragment.app.j) r13
            androidx.fragment.app.x1 r14 = r13.h()
            if (r11 == 0) goto L_0x0173
            if (r14 != r11) goto L_0x0171
            goto L_0x0173
        L_0x0171:
            r11 = 0
            goto L_0x0174
        L_0x0173:
            r11 = 1
        L_0x0174:
            if (r11 == 0) goto L_0x0178
            r11 = r14
            goto L_0x015c
        L_0x0178:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            r0.<init>(r1)
            java.lang.Object r1 = r13.f6079a
            androidx.fragment.app.h2 r1 = (androidx.fragment.app.h2) r1
            androidx.fragment.app.c0 r1 = r1.f1455c
            r0.append(r1)
            java.lang.String r1 = " returned Transition "
            r0.append(r1)
            java.lang.Object r1 = r13.f1465c
            r0.append(r1)
            java.lang.String r1 = " which uses a different Transition type than other Fragments."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x01a5:
            android.view.ViewGroup r13 = r6.f1506a
            if (r11 != 0) goto L_0x01ce
            java.util.Iterator r0 = r5.iterator()
        L_0x01ad:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01c6
            java.lang.Object r2 = r0.next()
            androidx.fragment.app.j r2 = (androidx.fragment.app.j) r2
            java.lang.Object r3 = r2.f6079a
            androidx.fragment.app.h2 r3 = (androidx.fragment.app.h2) r3
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r8.put(r3, r4)
            r2.b()
            goto L_0x01ad
        L_0x01c6:
            r24 = r1
            r28 = r10
            r25 = r12
            goto L_0x0721
        L_0x01ce:
            android.view.View r2 = new android.view.View
            android.content.Context r14 = r13.getContext()
            r2.<init>(r14)
            android.graphics.Rect r14 = new android.graphics.Rect
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            q.e r3 = new q.e
            r3.<init>()
            java.util.Iterator r22 = r5.iterator()
            r24 = r1
            r1 = 0
            r6 = 0
            r23 = 0
        L_0x01f5:
            boolean r16 = r22.hasNext()
            if (r16 == 0) goto L_0x04ac
            java.lang.Object r16 = r22.next()
            r35 = r6
            r6 = r16
            androidx.fragment.app.j r6 = (androidx.fragment.app.j) r6
            java.lang.Object r6 = r6.f1467e
            if (r6 == 0) goto L_0x020c
            r16 = 1
            goto L_0x020e
        L_0x020c:
            r16 = 0
        L_0x020e:
            if (r16 == 0) goto L_0x0497
            if (r9 == 0) goto L_0x0497
            if (r10 == 0) goto L_0x0497
            java.lang.Object r1 = r11.f(r6)
            java.lang.Object r1 = r11.r(r1)
            androidx.fragment.app.c0 r6 = r10.f1455c
            r25 = r12
            androidx.fragment.app.x r12 = r6.P
            if (r12 == 0) goto L_0x0228
            java.util.ArrayList r12 = r12.f1603g
            if (r12 != 0) goto L_0x022d
        L_0x0228:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L_0x022d:
            r26 = r4
            androidx.fragment.app.c0 r4 = r9.f1455c
            r27 = r5
            androidx.fragment.app.x r5 = r4.P
            if (r5 == 0) goto L_0x023b
            java.util.ArrayList r5 = r5.f1603g
            if (r5 != 0) goto L_0x0240
        L_0x023b:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0240:
            r28 = r8
            androidx.fragment.app.x r8 = r4.P
            if (r8 == 0) goto L_0x024a
            java.util.ArrayList r8 = r8.f1604h
            if (r8 != 0) goto L_0x024f
        L_0x024a:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x024f:
            r29 = r2
            int r2 = r8.size()
            r31 = r1
            r30 = r14
            r14 = 0
        L_0x025a:
            r1 = -1
            if (r14 >= r2) goto L_0x0275
            r16 = r2
            java.lang.Object r2 = r8.get(r14)
            int r2 = r12.indexOf(r2)
            if (r2 == r1) goto L_0x0270
            java.lang.Object r1 = r5.get(r14)
            r12.set(r2, r1)
        L_0x0270:
            int r14 = r14 + 1
            r2 = r16
            goto L_0x025a
        L_0x0275:
            androidx.fragment.app.x r2 = r6.P
            if (r2 == 0) goto L_0x027d
            java.util.ArrayList r2 = r2.f1604h
            if (r2 != 0) goto L_0x0282
        L_0x027d:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0282:
            if (r0 != 0) goto L_0x028b
            la.i r5 = new la.i
            r8 = 0
            r5.<init>(r8, r8)
            goto L_0x0291
        L_0x028b:
            r8 = 0
            la.i r5 = new la.i
            r5.<init>(r8, r8)
        L_0x0291:
            java.lang.Object r8 = r5.f9799h
            b0.p0 r8 = (b0.p0) r8
            java.lang.Object r5 = r5.f9800i
            b0.p0 r5 = (b0.p0) r5
            int r14 = r12.size()
            r1 = 0
        L_0x029e:
            if (r1 >= r14) goto L_0x02be
            java.lang.Object r17 = r12.get(r1)
            r18 = r14
            r14 = r17
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r17 = r2.get(r1)
            r32 = r11
            r11 = r17
            java.lang.String r11 = (java.lang.String) r11
            r3.put(r14, r11)
            int r1 = r1 + 1
            r14 = r18
            r11 = r32
            goto L_0x029e
        L_0x02be:
            r32 = r11
            r1 = 2
            boolean r11 = androidx.fragment.app.c1.I(r1)
            if (r11 == 0) goto L_0x02e9
            java.util.Iterator r1 = r2.iterator()
        L_0x02cb:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x02d8
            java.lang.Object r11 = r1.next()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x02cb
        L_0x02d8:
            java.util.Iterator r1 = r12.iterator()
        L_0x02dc:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x02e9
            java.lang.Object r11 = r1.next()
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x02dc
        L_0x02e9:
            q.e r1 = new q.e
            r1.<init>()
            android.view.View r4 = r4.M
            java.lang.String r11 = "firstOut.fragment.mView"
            xa.j.e(r11, r4)
            e(r1, r4)
            r1.m(r12)
            if (r8 == 0) goto L_0x0342
            r4 = 2
            boolean r8 = androidx.fragment.app.c1.I(r4)
            if (r8 == 0) goto L_0x0307
            r9.toString()
        L_0x0307:
            int r4 = r12.size()
            r8 = -1
            int r4 = r4 + r8
            if (r4 < 0) goto L_0x0349
        L_0x030f:
            int r8 = r4 + -1
            java.lang.Object r4 = r12.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r11 = 0
            java.lang.Object r14 = r1.getOrDefault(r4, r11)
            android.view.View r14 = (android.view.View) r14
            if (r14 != 0) goto L_0x0324
            r3.remove(r4)
            goto L_0x033d
        L_0x0324:
            java.util.WeakHashMap r11 = m0.c1.f10054a
            java.lang.String r11 = m0.o0.k(r14)
            boolean r11 = xa.j.a(r4, r11)
            if (r11 != 0) goto L_0x033d
            java.lang.Object r4 = r3.remove(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r11 = m0.o0.k(r14)
            r3.put(r11, r4)
        L_0x033d:
            if (r8 >= 0) goto L_0x0340
            goto L_0x0349
        L_0x0340:
            r4 = r8
            goto L_0x030f
        L_0x0342:
            java.util.Set r4 = r1.keySet()
            r3.m(r4)
        L_0x0349:
            q.e r4 = new q.e
            r4.<init>()
            android.view.View r6 = r6.M
            java.lang.String r8 = "lastIn.fragment.mView"
            xa.j.e(r8, r6)
            e(r4, r6)
            r4.m(r2)
            java.util.Collection r6 = r3.values()
            r4.m(r6)
            if (r5 == 0) goto L_0x03b7
            r5 = 2
            boolean r6 = androidx.fragment.app.c1.I(r5)
            if (r6 == 0) goto L_0x036e
            r10.toString()
        L_0x036e:
            int r5 = r2.size()
            r6 = -1
            int r5 = r5 + r6
            if (r5 < 0) goto L_0x03d1
        L_0x0376:
            int r6 = r5 + -1
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r8 = 0
            java.lang.Object r11 = r4.getOrDefault(r5, r8)
            android.view.View r11 = (android.view.View) r11
            java.lang.String r8 = "name"
            if (r11 != 0) goto L_0x0396
            xa.j.e(r8, r5)
            java.lang.String r5 = androidx.fragment.app.q1.a(r3, r5)
            if (r5 == 0) goto L_0x03b2
            r3.remove(r5)
            goto L_0x03b2
        L_0x0396:
            java.util.WeakHashMap r14 = m0.c1.f10054a
            java.lang.String r14 = m0.o0.k(r11)
            boolean r14 = xa.j.a(r5, r14)
            if (r14 != 0) goto L_0x03b2
            xa.j.e(r8, r5)
            java.lang.String r5 = androidx.fragment.app.q1.a(r3, r5)
            if (r5 == 0) goto L_0x03b2
            java.lang.String r8 = m0.o0.k(r11)
            r3.put(r5, r8)
        L_0x03b2:
            if (r6 >= 0) goto L_0x03b5
            goto L_0x03d1
        L_0x03b5:
            r5 = r6
            goto L_0x0376
        L_0x03b7:
            androidx.fragment.app.v1 r5 = androidx.fragment.app.q1.f1552a
            int r5 = r3.f13081j
            r6 = -1
            int r5 = r5 + r6
        L_0x03bd:
            if (r6 >= r5) goto L_0x03d1
            java.lang.Object r8 = r3.l(r5)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r4.containsKey(r8)
            if (r8 != 0) goto L_0x03ce
            r3.j(r5)
        L_0x03ce:
            int r5 = r5 + -1
            goto L_0x03bd
        L_0x03d1:
            java.util.Set r5 = r3.keySet()
            java.util.Set r6 = r1.entrySet()
            androidx.fragment.app.k r8 = new androidx.fragment.app.k
            r11 = 0
            r8.<init>(r11, r5)
            ma.w.l(r6, r8, r11)
            java.util.Collection r5 = r3.values()
            java.util.Set r6 = r4.entrySet()
            androidx.fragment.app.k r8 = new androidx.fragment.app.k
            r8.<init>(r11, r5)
            ma.w.l(r6, r8, r11)
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0411
            r15.clear()
            r7.clear()
            r6 = r35
            r12 = r25
            r4 = r26
            r5 = r27
            r8 = r28
            r2 = r29
            r14 = r30
            r11 = r32
            r1 = 0
            goto L_0x01f5
        L_0x0411:
            androidx.fragment.app.v1 r5 = androidx.fragment.app.q1.f1552a
            androidx.fragment.app.f r5 = new androidx.fragment.app.f
            r5.<init>((androidx.fragment.app.h2) r10, (androidx.fragment.app.h2) r9, (boolean) r0, (q.e) r4)
            m0.b0.a(r13, r5)
            java.util.Collection r5 = r1.values()
            r15.addAll(r5)
            boolean r5 = r12.isEmpty()
            r6 = 1
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x0441
            r5 = 0
            java.lang.Object r6 = r12.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            r5 = 0
            java.lang.Object r1 = r1.getOrDefault(r6, r5)
            r6 = r1
            android.view.View r6 = (android.view.View) r6
            r1 = r31
            r14 = r32
            r14.m(r6, r1)
            goto L_0x0447
        L_0x0441:
            r1 = r31
            r14 = r32
            r6 = r35
        L_0x0447:
            java.util.Collection r5 = r4.values()
            r7.addAll(r5)
            boolean r5 = r2.isEmpty()
            r11 = 1
            r5 = r5 ^ r11
            if (r5 == 0) goto L_0x0476
            r5 = 0
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            r5 = 0
            java.lang.Object r2 = r4.getOrDefault(r2, r5)
            android.view.View r2 = (android.view.View) r2
            if (r2 == 0) goto L_0x0476
            androidx.emoji2.text.r r4 = new androidx.emoji2.text.r
            r5 = r30
            r8 = 2
            r4.<init>(r14, r2, r5, r8)
            m0.b0.a(r13, r4)
            r2 = r29
            r23 = 1
            goto L_0x047a
        L_0x0476:
            r5 = r30
            r2 = r29
        L_0x047a:
            r14.p(r1, r2, r15)
            r18 = 0
            r19 = 0
            r16 = r14
            r17 = r1
            r20 = r1
            r21 = r7
            r16.l(r17, r18, r19, r20, r21)
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r8 = r28
            r8.put(r9, r4)
            r8.put(r10, r4)
            goto L_0x04a2
        L_0x0497:
            r26 = r4
            r27 = r5
            r25 = r12
            r5 = r14
            r14 = r11
            r11 = 1
            r6 = r35
        L_0x04a2:
            r11 = r14
            r12 = r25
            r4 = r26
            r14 = r5
            r5 = r27
            goto L_0x01f5
        L_0x04ac:
            r26 = r4
            r27 = r5
            r35 = r6
            r25 = r12
            r5 = r14
            r14 = r11
            r11 = 1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r4 = r27.iterator()
            r6 = 0
            r12 = 0
        L_0x04c2:
            boolean r16 = r4.hasNext()
            if (r16 == 0) goto L_0x05b7
            java.lang.Object r16 = r4.next()
            r11 = r16
            androidx.fragment.app.j r11 = (androidx.fragment.app.j) r11
            boolean r16 = r11.e()
            r34 = r4
            if (r16 == 0) goto L_0x04df
            java.lang.Object r4 = r11.f6079a
            androidx.fragment.app.h2 r4 = (androidx.fragment.app.h2) r4
            r22 = r3
            goto L_0x04fb
        L_0x04df:
            java.lang.Object r4 = r11.f1465c
            java.lang.Object r4 = r14.f(r4)
            r22 = r3
            java.lang.Object r3 = r11.f6079a
            androidx.fragment.app.h2 r3 = (androidx.fragment.app.h2) r3
            if (r1 == 0) goto L_0x04f4
            if (r3 == r9) goto L_0x04f1
            if (r3 != r10) goto L_0x04f4
        L_0x04f1:
            r16 = 1
            goto L_0x04f6
        L_0x04f4:
            r16 = 0
        L_0x04f6:
            if (r4 != 0) goto L_0x0509
            if (r16 != 0) goto L_0x0503
            r4 = r3
        L_0x04fb:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r8.put(r4, r3)
            r11.b()
        L_0x0503:
            r4 = r34
            r3 = r22
            r11 = 1
            goto L_0x04c2
        L_0x0509:
            r28 = r10
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r29 = r1
            androidx.fragment.app.c0 r1 = r3.f1455c
            android.view.View r1 = r1.M
            r30 = r6
            r6 = r26
            xa.j.e(r6, r1)
            a(r10, r1)
            if (r16 == 0) goto L_0x0530
            if (r3 != r9) goto L_0x0529
            java.util.Set r1 = ma.z.N(r15)
            goto L_0x052d
        L_0x0529:
            java.util.Set r1 = ma.z.N(r7)
        L_0x052d:
            r10.removeAll(r1)
        L_0x0530:
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x053c
            r14.a(r2, r4)
            r16 = r2
            goto L_0x0578
        L_0x053c:
            r14.b(r4, r10)
            r20 = 0
            r21 = 0
            r16 = r14
            r17 = r4
            r18 = r4
            r19 = r10
            r16.l(r17, r18, r19, r20, r21)
            androidx.fragment.app.g2 r1 = r3.f1453a
            r16 = r2
            androidx.fragment.app.g2 r2 = androidx.fragment.app.g2.GONE
            if (r1 != r2) goto L_0x0578
            r2 = r25
            r2.remove(r3)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r10)
            r26 = r6
            androidx.fragment.app.c0 r6 = r3.f1455c
            android.view.View r2 = r6.M
            r1.remove(r2)
            android.view.View r2 = r6.M
            r14.k(r4, r2, r1)
            androidx.activity.e r1 = new androidx.activity.e
            r2 = 5
            r1.<init>(r2, r10)
            m0.b0.a(r13, r1)
            goto L_0x057a
        L_0x0578:
            r26 = r6
        L_0x057a:
            androidx.fragment.app.g2 r1 = r3.f1453a
            androidx.fragment.app.g2 r2 = androidx.fragment.app.g2.VISIBLE
            if (r1 != r2) goto L_0x058b
            r0.addAll(r10)
            if (r23 == 0) goto L_0x0588
            r14.n(r4, r5)
        L_0x0588:
            r6 = r35
            goto L_0x0590
        L_0x058b:
            r6 = r35
            r14.m(r6, r4)
        L_0x0590:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r8.put(r3, r1)
            boolean r1 = r11.f1466d
            if (r1 == 0) goto L_0x05a1
            java.lang.Object r1 = r14.j(r12, r4)
            r12 = r1
            r1 = r30
            goto L_0x05a7
        L_0x05a1:
            r1 = r30
            java.lang.Object r1 = r14.j(r1, r4)
        L_0x05a7:
            r4 = r34
            r35 = r6
            r2 = r16
            r3 = r22
            r10 = r28
            r11 = 1
            r6 = r1
            r1 = r29
            goto L_0x04c2
        L_0x05b7:
            r2 = r1
            r22 = r3
            r1 = r6
            r28 = r10
            java.lang.Object r1 = r14.i(r12, r1, r2)
            if (r1 != 0) goto L_0x05c7
            r10 = r28
            goto L_0x0645
        L_0x05c7:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r4 = r27.iterator()
        L_0x05d0:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x05e7
            java.lang.Object r5 = r4.next()
            r6 = r5
            androidx.fragment.app.j r6 = (androidx.fragment.app.j) r6
            boolean r6 = r6.e()
            if (r6 != 0) goto L_0x05d0
            r3.add(r5)
            goto L_0x05d0
        L_0x05e7:
            java.util.Iterator r3 = r3.iterator()
        L_0x05eb:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x063b
            java.lang.Object r4 = r3.next()
            androidx.fragment.app.j r4 = (androidx.fragment.app.j) r4
            java.lang.Object r5 = r4.f1465c
            java.lang.Object r6 = r4.f6079a
            androidx.fragment.app.h2 r6 = (androidx.fragment.app.h2) r6
            r10 = r28
            if (r2 == 0) goto L_0x0607
            if (r6 == r9) goto L_0x0605
            if (r6 != r10) goto L_0x0607
        L_0x0605:
            r11 = 1
            goto L_0x0608
        L_0x0607:
            r11 = 0
        L_0x0608:
            if (r5 != 0) goto L_0x060c
            if (r11 == 0) goto L_0x0638
        L_0x060c:
            java.util.WeakHashMap r5 = m0.c1.f10054a
            boolean r5 = m0.l0.c(r13)
            if (r5 != 0) goto L_0x0625
            r5 = 2
            boolean r11 = androidx.fragment.app.c1.I(r5)
            if (r11 == 0) goto L_0x0621
            java.util.Objects.toString(r13)
            java.util.Objects.toString(r6)
        L_0x0621:
            r4.b()
            goto L_0x0638
        L_0x0625:
            java.lang.Object r5 = r4.f6079a
            androidx.fragment.app.h2 r5 = (androidx.fragment.app.h2) r5
            androidx.fragment.app.c0 r5 = r5.f1455c
            java.lang.Object r5 = r4.f6080b
            i0.f r5 = (i0.f) r5
            g.r0 r11 = new g.r0
            r12 = 2
            r11.<init>(r4, r12, r6)
            r14.o(r1, r5, r11)
        L_0x0638:
            r28 = r10
            goto L_0x05eb
        L_0x063b:
            r10 = r28
            java.util.WeakHashMap r3 = m0.c1.f10054a
            boolean r3 = m0.l0.c(r13)
            if (r3 != 0) goto L_0x0649
        L_0x0645:
            r28 = r10
            goto L_0x0721
        L_0x0649:
            r3 = 4
            androidx.fragment.app.q1.b(r0, r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r7.size()
            r5 = 0
        L_0x0657:
            if (r5 >= r4) goto L_0x066f
            java.lang.Object r6 = r7.get(r5)
            android.view.View r6 = (android.view.View) r6
            java.util.WeakHashMap r11 = m0.c1.f10054a
            java.lang.String r11 = m0.o0.k(r6)
            r3.add(r11)
            r11 = 0
            m0.o0.v(r6, r11)
            int r5 = r5 + 1
            goto L_0x0657
        L_0x066f:
            r5 = 2
            boolean r4 = androidx.fragment.app.c1.I(r5)
            if (r4 == 0) goto L_0x06ae
            java.util.Iterator r4 = r15.iterator()
        L_0x067a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0692
            java.lang.Object r5 = r4.next()
            java.lang.String r6 = "sharedElementFirstOutViews"
            xa.j.e(r6, r5)
            android.view.View r5 = (android.view.View) r5
            r5.toString()
            m0.o0.k(r5)
            goto L_0x067a
        L_0x0692:
            java.util.Iterator r4 = r7.iterator()
        L_0x0696:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x06ae
            java.lang.Object r5 = r4.next()
            java.lang.String r6 = "sharedElementLastInViews"
            xa.j.e(r6, r5)
            android.view.View r5 = (android.view.View) r5
            r5.toString()
            m0.o0.k(r5)
            goto L_0x0696
        L_0x06ae:
            r14.c(r13, r1)
            int r1 = r7.size()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x06bb:
            if (r5 >= r1) goto L_0x0704
            java.lang.Object r6 = r15.get(r5)
            android.view.View r6 = (android.view.View) r6
            java.util.WeakHashMap r11 = m0.c1.f10054a
            java.lang.String r11 = m0.o0.k(r6)
            r4.add(r11)
            if (r11 != 0) goto L_0x06d1
        L_0x06ce:
            r28 = r10
            goto L_0x06ff
        L_0x06d1:
            r12 = 0
            m0.o0.v(r6, r12)
            r6 = r22
            java.lang.Object r16 = r6.getOrDefault(r11, r12)
            r12 = r16
            java.lang.String r12 = (java.lang.String) r12
            r22 = r6
            r6 = 0
        L_0x06e2:
            if (r6 >= r1) goto L_0x06ce
            r28 = r10
            java.lang.Object r10 = r3.get(r6)
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x06fa
            java.lang.Object r6 = r7.get(r6)
            android.view.View r6 = (android.view.View) r6
            m0.o0.v(r6, r11)
            goto L_0x06ff
        L_0x06fa:
            int r6 = r6 + 1
            r10 = r28
            goto L_0x06e2
        L_0x06ff:
            int r5 = r5 + 1
            r10 = r28
            goto L_0x06bb
        L_0x0704:
            r28 = r10
            androidx.fragment.app.w1 r5 = new androidx.fragment.app.w1
            r16 = r5
            r17 = r1
            r18 = r7
            r19 = r3
            r20 = r15
            r21 = r4
            r16.<init>(r17, r18, r19, r20, r21)
            m0.b0.a(r13, r5)
            r1 = 0
            androidx.fragment.app.q1.b(r0, r1)
            r14.q(r2, r15, r7)
        L_0x0721:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r6 = r8.containsValue(r0)
            android.content.Context r7 = r13.getContext()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r11 = r24.iterator()
            r12 = 0
        L_0x0735:
            boolean r0 = r11.hasNext()
            java.lang.String r14 = "context"
            if (r0 == 0) goto L_0x07d1
            java.lang.Object r0 = r11.next()
            r15 = r0
            androidx.fragment.app.i r15 = (androidx.fragment.app.i) r15
            boolean r0 = r15.e()
            if (r0 == 0) goto L_0x074b
            goto L_0x077d
        L_0x074b:
            xa.j.e(r14, r7)
            androidx.fragment.app.n0 r0 = r15.h(r7)
            if (r0 != 0) goto L_0x0755
            goto L_0x077d
        L_0x0755:
            java.lang.Object r0 = r0.f1512b
            r14 = r0
            android.animation.Animator r14 = (android.animation.Animator) r14
            if (r14 != 0) goto L_0x0760
            r10.add(r15)
            goto L_0x0735
        L_0x0760:
            java.lang.Object r0 = r15.f6079a
            r5 = r0
            androidx.fragment.app.h2 r5 = (androidx.fragment.app.h2) r5
            androidx.fragment.app.c0 r0 = r5.f1455c
            java.lang.Object r1 = r8.get(r5)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = xa.j.a(r1, r2)
            if (r1 == 0) goto L_0x0781
            r1 = 2
            boolean r2 = androidx.fragment.app.c1.I(r1)
            if (r2 == 0) goto L_0x077d
            java.util.Objects.toString(r0)
        L_0x077d:
            r15.b()
            goto L_0x0735
        L_0x0781:
            androidx.fragment.app.g2 r1 = r5.f1453a
            androidx.fragment.app.g2 r2 = androidx.fragment.app.g2.GONE
            if (r1 != r2) goto L_0x0789
            r3 = 1
            goto L_0x078a
        L_0x0789:
            r3 = 0
        L_0x078a:
            r2 = r25
            if (r3 == 0) goto L_0x0791
            r2.remove(r5)
        L_0x0791:
            android.view.View r12 = r0.M
            r13.startViewTransition(r12)
            androidx.fragment.app.l r4 = new androidx.fragment.app.l
            r0 = r4
            r1 = r33
            r16 = r2
            r2 = r12
            r17 = r8
            r8 = r4
            r4 = r5
            r34 = r5
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r14.addListener(r8)
            r14.setTarget(r12)
            r14.start()
            r0 = 2
            boolean r1 = androidx.fragment.app.c1.I(r0)
            if (r1 == 0) goto L_0x07bb
            r34.toString()
        L_0x07bb:
            java.lang.Object r0 = r15.f6080b
            i0.f r0 = (i0.f) r0
            androidx.fragment.app.g r1 = new androidx.fragment.app.g
            r2 = r34
            r3 = 0
            r1.<init>(r14, r3, r2)
            r0.b(r1)
            r25 = r16
            r8 = r17
            r12 = 1
            goto L_0x0735
        L_0x07d1:
            r16 = r25
            java.util.Iterator r8 = r10.iterator()
        L_0x07d7:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0871
            java.lang.Object r0 = r8.next()
            r3 = r0
            androidx.fragment.app.i r3 = (androidx.fragment.app.i) r3
            java.lang.Object r0 = r3.f6079a
            r4 = r0
            androidx.fragment.app.h2 r4 = (androidx.fragment.app.h2) r4
            androidx.fragment.app.c0 r0 = r4.f1455c
            if (r6 == 0) goto L_0x07f5
            r1 = 2
            boolean r2 = androidx.fragment.app.c1.I(r1)
            if (r2 == 0) goto L_0x0801
            goto L_0x07fe
        L_0x07f5:
            r1 = 2
            if (r12 == 0) goto L_0x0805
            boolean r2 = androidx.fragment.app.c1.I(r1)
            if (r2 == 0) goto L_0x0801
        L_0x07fe:
            java.util.Objects.toString(r0)
        L_0x0801:
            r3.b()
            goto L_0x07d7
        L_0x0805:
            android.view.View r1 = r0.M
            xa.j.e(r14, r7)
            androidx.fragment.app.n0 r0 = r3.h(r7)
            java.lang.String r2 = "Required value was null."
            if (r0 == 0) goto L_0x0865
            java.lang.Cloneable r0 = r0.f1511a
            android.view.animation.Animation r0 = (android.view.animation.Animation) r0
            if (r0 == 0) goto L_0x0859
            androidx.fragment.app.g2 r2 = r4.f1453a
            androidx.fragment.app.g2 r5 = androidx.fragment.app.g2.REMOVED
            if (r2 == r5) goto L_0x0827
            r1.startAnimation(r0)
            r3.b()
            r10 = r33
            goto L_0x0846
        L_0x0827:
            r13.startViewTransition(r1)
            androidx.fragment.app.g0 r2 = new androidx.fragment.app.g0
            r2.<init>(r0, r13, r1)
            androidx.fragment.app.m r0 = new androidx.fragment.app.m
            r10 = r33
            r0.<init>(r1, r3, r10, r4)
            r2.setAnimationListener(r0)
            r1.startAnimation(r2)
            r0 = 2
            boolean r2 = androidx.fragment.app.c1.I(r0)
            if (r2 == 0) goto L_0x0846
            r4.toString()
        L_0x0846:
            java.lang.Object r0 = r3.f6080b
            r11 = r0
            i0.f r11 = (i0.f) r11
            androidx.fragment.app.h r15 = new androidx.fragment.app.h
            r5 = 0
            r0 = r15
            r2 = r33
            r0.<init>(r1, r2, r3, r4, r5)
            r11.b(r15)
            goto L_0x07d7
        L_0x0859:
            r10 = r33
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0865:
            r10 = r33
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0871:
            r10 = r33
            java.util.Iterator r0 = r16.iterator()
        L_0x0877:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0892
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.h2 r1 = (androidx.fragment.app.h2) r1
            androidx.fragment.app.c0 r2 = r1.f1455c
            android.view.View r2 = r2.M
            androidx.fragment.app.g2 r1 = r1.f1453a
            java.lang.String r3 = "view"
            xa.j.e(r3, r2)
            r1.a(r2)
            goto L_0x0877
        L_0x0892:
            r16.clear()
            r0 = 2
            boolean r0 = androidx.fragment.app.c1.I(r0)
            if (r0 == 0) goto L_0x08a2
            java.util.Objects.toString(r9)
            java.util.Objects.toString(r28)
        L_0x08a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.c(boolean, java.util.ArrayList):void");
    }

    public final void d() {
        if (!this.f1510e) {
            ViewGroup viewGroup = this.f1506a;
            WeakHashMap weakHashMap = c1.f10054a;
            if (!l0.b(viewGroup)) {
                g();
                this.f1509d = false;
                return;
            }
            synchronized (this.f1507b) {
                if (!this.f1507b.isEmpty()) {
                    ArrayList K = z.K(this.f1508c);
                    this.f1508c.clear();
                    Iterator it = K.iterator();
                    while (it.hasNext()) {
                        h2 h2Var = (h2) it.next();
                        if (c1.I(2)) {
                            Objects.toString(h2Var);
                        }
                        h2Var.a();
                        if (!h2Var.f1459g) {
                            this.f1508c.add(h2Var);
                        }
                    }
                    j();
                    ArrayList K2 = z.K(this.f1507b);
                    this.f1507b.clear();
                    this.f1508c.addAll(K2);
                    c1.I(2);
                    Iterator it2 = K2.iterator();
                    while (it2.hasNext()) {
                        ((h2) it2.next()).d();
                    }
                    c(this.f1509d, K2);
                    this.f1509d = false;
                    c1.I(2);
                }
                v vVar = v.f9814a;
            }
        }
    }

    public final h2 f(c0 c0Var) {
        Object obj;
        boolean z10;
        Iterator it = this.f1507b.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            h2 h2Var = (h2) obj;
            if (!j.a(h2Var.f1455c, c0Var) || h2Var.f1458f) {
                z10 = false;
                continue;
            } else {
                z10 = true;
                continue;
            }
            if (z10) {
                break;
            }
        }
        return (h2) obj;
    }

    public final void g() {
        c1.I(2);
        ViewGroup viewGroup = this.f1506a;
        WeakHashMap weakHashMap = c1.f10054a;
        boolean b10 = l0.b(viewGroup);
        synchronized (this.f1507b) {
            j();
            Iterator it = this.f1507b.iterator();
            while (it.hasNext()) {
                ((h2) it.next()).d();
            }
            Iterator it2 = z.K(this.f1508c).iterator();
            while (it2.hasNext()) {
                h2 h2Var = (h2) it2.next();
                if (c1.I(2)) {
                    if (!b10) {
                        Objects.toString(this.f1506a);
                    }
                    Objects.toString(h2Var);
                }
                h2Var.a();
            }
            Iterator it3 = z.K(this.f1507b).iterator();
            while (it3.hasNext()) {
                h2 h2Var2 = (h2) it3.next();
                if (c1.I(2)) {
                    if (!b10) {
                        Objects.toString(this.f1506a);
                    }
                    Objects.toString(h2Var2);
                }
                h2Var2.a();
            }
            v vVar = v.f9814a;
        }
    }

    public final void i() {
        c0 c0Var;
        Object obj;
        boolean z10;
        synchronized (this.f1507b) {
            j();
            ArrayList arrayList = this.f1507b;
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                c0Var = null;
                if (!listIterator.hasPrevious()) {
                    obj = null;
                    break;
                }
                obj = listIterator.previous();
                h2 h2Var = (h2) obj;
                f2 f2Var = g2.f1435h;
                View view = h2Var.f1455c.M;
                j.e("operation.fragment.mView", view);
                f2Var.getClass();
                g2 a10 = f2.a(view);
                g2 g2Var = h2Var.f1453a;
                g2 g2Var2 = g2.VISIBLE;
                if (g2Var != g2Var2 || a10 == g2Var2) {
                    z10 = false;
                    continue;
                } else {
                    z10 = true;
                    continue;
                }
                if (z10) {
                    break;
                }
            }
            h2 h2Var2 = (h2) obj;
            if (h2Var2 != null) {
                c0Var = h2Var2.f1455c;
            }
            if (c0Var != null) {
                x xVar = c0Var.P;
            }
            this.f1510e = false;
            v vVar = v.f9814a;
        }
    }

    public final void j() {
        Iterator it = this.f1507b.iterator();
        while (it.hasNext()) {
            h2 h2Var = (h2) it.next();
            if (h2Var.f1454b == e2.ADDING) {
                View h02 = h2Var.f1455c.h0();
                f2 f2Var = g2.f1435h;
                int visibility = h02.getVisibility();
                f2Var.getClass();
                h2Var.c(f2.b(visibility), e2.NONE);
            }
        }
    }
}
