package b4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

public final class w implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final u f2607h;

    /* renamed from: i  reason: collision with root package name */
    public final ViewGroup f2608i;

    public w(ViewGroup viewGroup, u uVar) {
        this.f2607h = uVar;
        this.f2608i = viewGroup;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: b4.c0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01cf A[EDGE_INSN: B:139:0x01cf->B:87:0x01cf ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onPreDraw() {
        /*
            r17 = this;
            r0 = r17
            android.view.ViewGroup r2 = r0.f2608i
            android.view.ViewTreeObserver r1 = r2.getViewTreeObserver()
            r1.removeOnPreDrawListener(r0)
            r2.removeOnAttachStateChangeListener(r0)
            java.util.ArrayList r1 = b4.x.f2611c
            boolean r1 = r1.remove(r2)
            r7 = 1
            if (r1 != 0) goto L_0x0018
            return r7
        L_0x0018:
            q.e r1 = b4.x.b()
            r3 = 0
            java.lang.Object r4 = r1.getOrDefault(r2, r3)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 != 0) goto L_0x002e
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.put(r2, r4)
            goto L_0x003a
        L_0x002e:
            int r5 = r4.size()
            if (r5 <= 0) goto L_0x003a
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r4)
            goto L_0x003b
        L_0x003a:
            r5 = r3
        L_0x003b:
            b4.u r8 = r0.f2607h
            r4.add(r8)
            b4.g r4 = new b4.g
            r4.<init>(r0, r7, r1)
            r8.a(r4)
            r1 = 0
            r8.h(r2, r1)
            if (r5 == 0) goto L_0x0062
            java.util.Iterator r4 = r5.iterator()
        L_0x0052:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0062
            java.lang.Object r5 = r4.next()
            b4.u r5 = (b4.u) r5
            r5.x(r2)
            goto L_0x0052
        L_0x0062:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r8.f2598r = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r8.f2599s = r4
            b4.d0 r4 = r8.f2594n
            b4.d0 r5 = r8.f2595o
            q.e r6 = new q.e
            q.e r9 = r4.f2526a
            r6.<init>(r9)
            q.e r9 = new q.e
            q.e r10 = r5.f2526a
            r9.<init>(r10)
            r10 = 0
        L_0x0083:
            int[] r11 = r8.f2597q
            int r12 = r11.length
            if (r10 >= r12) goto L_0x01cf
            r11 = r11[r10]
            if (r11 == r7) goto L_0x018f
            r12 = 2
            if (r11 == r12) goto L_0x0141
            r12 = 3
            if (r11 == r12) goto L_0x00ed
            r12 = 4
            if (r11 == r12) goto L_0x0098
        L_0x0095:
            r15 = r2
            goto L_0x01c5
        L_0x0098:
            q.i r11 = r4.f2528c
            int r12 = r11.i()
            r13 = 0
        L_0x009f:
            if (r13 >= r12) goto L_0x0095
            java.lang.Object r14 = r11.j(r13)
            android.view.View r14 = (android.view.View) r14
            if (r14 == 0) goto L_0x00e5
            boolean r15 = r8.s(r14)
            if (r15 == 0) goto L_0x00e5
            r15 = r2
            long r1 = r11.f(r13)
            q.i r7 = r5.f2528c
            java.lang.Object r1 = r7.e(r1, r3)
            android.view.View r1 = (android.view.View) r1
            if (r1 == 0) goto L_0x00e6
            boolean r2 = r8.s(r1)
            if (r2 == 0) goto L_0x00e6
            java.lang.Object r2 = r6.getOrDefault(r14, r3)
            b4.c0 r2 = (b4.c0) r2
            java.lang.Object r7 = r9.getOrDefault(r1, r3)
            b4.c0 r7 = (b4.c0) r7
            if (r2 == 0) goto L_0x00e6
            if (r7 == 0) goto L_0x00e6
            java.util.ArrayList r3 = r8.f2598r
            r3.add(r2)
            java.util.ArrayList r2 = r8.f2599s
            r2.add(r7)
            r6.remove(r14)
            r9.remove(r1)
            goto L_0x00e6
        L_0x00e5:
            r15 = r2
        L_0x00e6:
            int r13 = r13 + 1
            r2 = r15
            r1 = 0
            r3 = 0
            r7 = 1
            goto L_0x009f
        L_0x00ed:
            r15 = r2
            android.util.SparseArray r1 = r4.f2527b
            android.util.SparseArray r2 = r5.f2527b
            int r3 = r1.size()
            r7 = 0
        L_0x00f7:
            if (r7 >= r3) goto L_0x01c5
            java.lang.Object r11 = r1.valueAt(r7)
            android.view.View r11 = (android.view.View) r11
            if (r11 == 0) goto L_0x013c
            boolean r12 = r8.s(r11)
            if (r12 == 0) goto L_0x013c
            int r12 = r1.keyAt(r7)
            java.lang.Object r12 = r2.get(r12)
            android.view.View r12 = (android.view.View) r12
            if (r12 == 0) goto L_0x013c
            boolean r13 = r8.s(r12)
            if (r13 == 0) goto L_0x013c
            r13 = 0
            java.lang.Object r14 = r6.getOrDefault(r11, r13)
            b4.c0 r14 = (b4.c0) r14
            java.lang.Object r16 = r9.getOrDefault(r12, r13)
            r13 = r16
            b4.c0 r13 = (b4.c0) r13
            if (r14 == 0) goto L_0x013c
            if (r13 == 0) goto L_0x013c
            java.util.ArrayList r0 = r8.f2598r
            r0.add(r14)
            java.util.ArrayList r0 = r8.f2599s
            r0.add(r13)
            r6.remove(r11)
            r9.remove(r12)
        L_0x013c:
            int r7 = r7 + 1
            r0 = r17
            goto L_0x00f7
        L_0x0141:
            r15 = r2
            q.e r0 = r4.f2529d
            q.e r1 = r5.f2529d
            int r2 = r0.f13081j
            r3 = 0
        L_0x0149:
            if (r3 >= r2) goto L_0x01c5
            java.lang.Object r7 = r0.l(r3)
            android.view.View r7 = (android.view.View) r7
            if (r7 == 0) goto L_0x018c
            boolean r11 = r8.s(r7)
            if (r11 == 0) goto L_0x018c
            java.lang.Object r11 = r0.h(r3)
            r12 = 0
            java.lang.Object r11 = r1.getOrDefault(r11, r12)
            android.view.View r11 = (android.view.View) r11
            if (r11 == 0) goto L_0x018c
            boolean r13 = r8.s(r11)
            if (r13 == 0) goto L_0x018c
            java.lang.Object r13 = r6.getOrDefault(r7, r12)
            b4.c0 r13 = (b4.c0) r13
            java.lang.Object r14 = r9.getOrDefault(r11, r12)
            b4.c0 r14 = (b4.c0) r14
            if (r13 == 0) goto L_0x018c
            if (r14 == 0) goto L_0x018c
            java.util.ArrayList r12 = r8.f2598r
            r12.add(r13)
            java.util.ArrayList r12 = r8.f2599s
            r12.add(r14)
            r6.remove(r7)
            r9.remove(r11)
        L_0x018c:
            int r3 = r3 + 1
            goto L_0x0149
        L_0x018f:
            r15 = r2
            int r0 = r6.f13081j
        L_0x0192:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x01c5
            java.lang.Object r1 = r6.h(r0)
            android.view.View r1 = (android.view.View) r1
            if (r1 == 0) goto L_0x0192
            boolean r2 = r8.s(r1)
            if (r2 == 0) goto L_0x0192
            java.lang.Object r1 = r9.remove(r1)
            b4.c0 r1 = (b4.c0) r1
            if (r1 == 0) goto L_0x0192
            android.view.View r2 = r1.f2522b
            boolean r2 = r8.s(r2)
            if (r2 == 0) goto L_0x0192
            java.lang.Object r2 = r6.j(r0)
            b4.c0 r2 = (b4.c0) r2
            java.util.ArrayList r3 = r8.f2598r
            r3.add(r2)
            java.util.ArrayList r2 = r8.f2599s
            r2.add(r1)
            goto L_0x0192
        L_0x01c5:
            int r10 = r10 + 1
            r0 = r17
            r2 = r15
            r1 = 0
            r3 = 0
            r7 = 1
            goto L_0x0083
        L_0x01cf:
            r15 = r2
            r0 = 0
        L_0x01d1:
            int r1 = r6.f13081j
            if (r0 >= r1) goto L_0x01f1
            java.lang.Object r1 = r6.l(r0)
            b4.c0 r1 = (b4.c0) r1
            android.view.View r2 = r1.f2522b
            boolean r2 = r8.s(r2)
            if (r2 == 0) goto L_0x01ee
            java.util.ArrayList r2 = r8.f2598r
            r2.add(r1)
            java.util.ArrayList r1 = r8.f2599s
            r2 = 0
            r1.add(r2)
        L_0x01ee:
            int r0 = r0 + 1
            goto L_0x01d1
        L_0x01f1:
            r0 = 0
        L_0x01f2:
            int r1 = r9.f13081j
            if (r0 >= r1) goto L_0x0212
            java.lang.Object r1 = r9.l(r0)
            b4.c0 r1 = (b4.c0) r1
            android.view.View r2 = r1.f2522b
            boolean r2 = r8.s(r2)
            if (r2 == 0) goto L_0x020f
            java.util.ArrayList r2 = r8.f2599s
            r2.add(r1)
            java.util.ArrayList r1 = r8.f2598r
            r2 = 0
            r1.add(r2)
        L_0x020f:
            int r0 = r0 + 1
            goto L_0x01f2
        L_0x0212:
            q.e r0 = b4.u.o()
            int r1 = r0.f13081j
            b4.i0 r2 = b4.g0.f2543a
            android.view.WindowId r2 = r15.getWindowId()
            r3 = 1
            int r1 = r1 - r3
        L_0x0220:
            if (r1 < 0) goto L_0x0293
            java.lang.Object r3 = r0.h(r1)
            android.animation.Animator r3 = (android.animation.Animator) r3
            if (r3 == 0) goto L_0x028f
            r4 = 0
            java.lang.Object r5 = r0.getOrDefault(r3, r4)
            b4.r r5 = (b4.r) r5
            if (r5 == 0) goto L_0x028f
            android.view.View r4 = r5.f2582a
            if (r4 == 0) goto L_0x028f
            b4.s0 r6 = r5.f2585d
            boolean r7 = r6 instanceof b4.r0
            if (r7 == 0) goto L_0x0249
            b4.r0 r6 = (b4.r0) r6
            android.view.WindowId r6 = r6.f2587a
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0249
            r6 = 1
            goto L_0x024a
        L_0x0249:
            r6 = 0
        L_0x024a:
            if (r6 == 0) goto L_0x028f
            r6 = 1
            b4.c0 r7 = r8.q(r4, r6)
            b4.c0 r9 = r8.n(r4, r6)
            if (r7 != 0) goto L_0x0266
            if (r9 != 0) goto L_0x0266
            b4.d0 r6 = r8.f2595o
            q.e r6 = r6.f2526a
            r10 = 0
            java.lang.Object r4 = r6.getOrDefault(r4, r10)
            r9 = r4
            b4.c0 r9 = (b4.c0) r9
            goto L_0x0267
        L_0x0266:
            r10 = 0
        L_0x0267:
            if (r7 != 0) goto L_0x026b
            if (r9 == 0) goto L_0x0277
        L_0x026b:
            b4.u r4 = r5.f2586e
            b4.c0 r5 = r5.f2584c
            boolean r4 = r4.r(r5, r9)
            if (r4 == 0) goto L_0x0277
            r4 = 1
            goto L_0x0278
        L_0x0277:
            r4 = 0
        L_0x0278:
            if (r4 == 0) goto L_0x0290
            boolean r4 = r3.isRunning()
            if (r4 != 0) goto L_0x028b
            boolean r4 = r3.isStarted()
            if (r4 == 0) goto L_0x0287
            goto L_0x028b
        L_0x0287:
            r0.remove(r3)
            goto L_0x0290
        L_0x028b:
            r3.cancel()
            goto L_0x0290
        L_0x028f:
            r10 = 0
        L_0x0290:
            int r1 = r1 + -1
            goto L_0x0220
        L_0x0293:
            b4.d0 r3 = r8.f2594n
            b4.d0 r4 = r8.f2595o
            java.util.ArrayList r5 = r8.f2598r
            java.util.ArrayList r6 = r8.f2599s
            r1 = r8
            r2 = r15
            r1.l(r2, r3, r4, r5, r6)
            r8.y()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.w.onPreDraw():boolean");
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.f2608i;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        x.f2611c.remove(viewGroup);
        ArrayList arrayList = (ArrayList) x.b().getOrDefault(viewGroup, (Object) null);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((u) it.next()).x(viewGroup);
            }
        }
        this.f2607h.i(true);
    }
}
