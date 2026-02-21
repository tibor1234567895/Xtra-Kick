package z7;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import u0.g;

public final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public int f17781a;

    /* renamed from: b  reason: collision with root package name */
    public int f17782b = -1;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f17783c;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f17783c = swipeDismissBehavior;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r0 = r3.f17781a - r4.getWidth();
        r4 = r3.f17781a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if (r0 != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(android.view.View r4, int r5) {
        /*
            r3 = this;
            java.util.WeakHashMap r0 = m0.c1.f10054a
            int r0 = m0.j0.d(r4)
            r1 = 1
            if (r0 != r1) goto L_0x000b
            r0 = 1
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            com.google.android.material.behavior.SwipeDismissBehavior r2 = r3.f17783c
            int r2 = r2.f3656d
            if (r2 != 0) goto L_0x0015
            if (r0 == 0) goto L_0x0019
            goto L_0x0021
        L_0x0015:
            if (r2 != r1) goto L_0x002b
            if (r0 == 0) goto L_0x0021
        L_0x0019:
            int r0 = r3.f17781a
            int r4 = r4.getWidth()
            int r4 = r4 + r0
            goto L_0x0039
        L_0x0021:
            int r0 = r3.f17781a
            int r4 = r4.getWidth()
            int r0 = r0 - r4
            int r4 = r3.f17781a
            goto L_0x0039
        L_0x002b:
            int r0 = r3.f17781a
            int r1 = r4.getWidth()
            int r0 = r0 - r1
            int r1 = r3.f17781a
            int r4 = r4.getWidth()
            int r4 = r4 + r1
        L_0x0039:
            int r5 = java.lang.Math.max(r0, r5)
            int r4 = java.lang.Math.min(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.a.a(android.view.View, int):int");
    }

    public final int b(View view, int i10) {
        return view.getTop();
    }

    public final int c(View view) {
        return view.getWidth();
    }

    public final void e(View view, int i10) {
        this.f17782b = i10;
        this.f17781a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f17783c;
            swipeDismissBehavior.f3655c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f3655c = false;
        }
    }

    public final void f(int i10) {
        this.f17783c.getClass();
    }

    public final void g(View view, int i10, int i11) {
        SwipeDismissBehavior swipeDismissBehavior = this.f17783c;
        float width = ((float) view.getWidth()) * swipeDismissBehavior.f3658f;
        float width2 = ((float) view.getWidth()) * swipeDismissBehavior.f3659g;
        float abs = (float) Math.abs(i10 - this.f17781a);
        if (abs <= width) {
            view.setAlpha(1.0f);
        } else if (abs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - width) / (width2 - width))), 1.0f));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (java.lang.Math.abs(r4) >= java.lang.Math.round(((float) r9.getWidth()) * r2.f3657e)) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f17782b = r11
            int r11 = r9.getWidth()
            r0 = 0
            r1 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r2 = r8.f17783c
            r3 = 1
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0039
            java.util.WeakHashMap r5 = m0.c1.f10054a
            int r5 = m0.j0.d(r9)
            if (r5 != r3) goto L_0x001a
            r5 = 1
            goto L_0x001b
        L_0x001a:
            r5 = 0
        L_0x001b:
            int r6 = r2.f3656d
            r7 = 2
            if (r6 != r7) goto L_0x0021
            goto L_0x0053
        L_0x0021:
            if (r6 != 0) goto L_0x002d
            if (r5 == 0) goto L_0x002a
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x0055
            goto L_0x0053
        L_0x002a:
            if (r4 <= 0) goto L_0x0055
            goto L_0x0053
        L_0x002d:
            if (r6 != r3) goto L_0x0055
            if (r5 == 0) goto L_0x0034
            if (r4 <= 0) goto L_0x0055
            goto L_0x0053
        L_0x0034:
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x0055
            goto L_0x0053
        L_0x0039:
            int r4 = r9.getLeft()
            int r5 = r8.f17781a
            int r4 = r4 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r2.f3657e
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r4 = java.lang.Math.abs(r4)
            if (r4 < r5) goto L_0x0055
        L_0x0053:
            r4 = 1
            goto L_0x0056
        L_0x0055:
            r4 = 0
        L_0x0056:
            if (r4 == 0) goto L_0x006c
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 < 0) goto L_0x0067
            int r10 = r9.getLeft()
            int r0 = r8.f17781a
            if (r10 >= r0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            int r0 = r0 + r11
            goto L_0x0070
        L_0x0067:
            int r10 = r8.f17781a
            int r0 = r10 - r11
            goto L_0x0070
        L_0x006c:
            int r10 = r8.f17781a
            r0 = r10
            r3 = 0
        L_0x0070:
            u0.h r10 = r2.f3653a
            int r11 = r9.getTop()
            boolean r10 = r10.r(r0, r11)
            if (r10 == 0) goto L_0x0086
            z7.b r10 = new z7.b
            r10.<init>(r2, r9, r3)
            java.util.WeakHashMap r11 = m0.c1.f10054a
            m0.i0.m(r9, r10)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.a.h(android.view.View, float, float):void");
    }

    public final boolean i(View view, int i10) {
        int i11 = this.f17782b;
        return (i11 == -1 || i11 == i10) && this.f17783c.s(view);
    }
}
