package q7;

import android.view.View;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import h0.a;
import java.lang.ref.WeakReference;
import u0.g;
import xa.j;

public final class d extends g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f13405a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f13406b;

    public /* synthetic */ d(int i10, Object obj) {
        this.f13405a = i10;
        this.f13406b = obj;
    }

    public final int a(View view, int i10) {
        int i11 = this.f13405a;
        Object obj = this.f13406b;
        switch (i11) {
            case 0:
                j.f("child", view);
                if (!((SlidingLayout) obj).f3546v) {
                    return i10;
                }
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                return a.a(i10, sideSheetBehavior.f3835a.a(), sideSheetBehavior.f3847m);
        }
    }

    public final int b(View view, int i10) {
        switch (this.f13405a) {
            case 0:
                j.f("child", view);
                SlidingLayout slidingLayout = (SlidingLayout) this.f13406b;
                if (slidingLayout.f3546v) {
                    return Math.min(Math.max(i10, slidingLayout.f3537m), slidingLayout.f3538n);
                }
                if (slidingLayout.f3532h) {
                    return i10;
                }
                return view.getTop();
            default:
                return view.getTop();
        }
    }

    public final int c(View view) {
        switch (this.f13405a) {
            case 1:
                return ((SideSheetBehavior) this.f13406b).f3847m;
            default:
                return 0;
        }
    }

    public final void f(int i10) {
        switch (this.f13405a) {
            case 1:
                if (i10 == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f13406b;
                    if (sideSheetBehavior.f3841g) {
                        sideSheetBehavior.s(1);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(android.view.View r4, int r5, int r6) {
        /*
            r3 = this;
            int r0 = r3.f13405a
            r1 = 0
            java.lang.Object r2 = r3.f13406b
            switch(r0) {
                case 0: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x003d
        L_0x0009:
            java.lang.String r0 = "changedView"
            xa.j.f(r0, r4)
            com.github.andreyasadchy.xtra.ui.view.SlidingLayout r2 = (com.github.andreyasadchy.xtra.ui.view.SlidingLayout) r2
            r2.f3541q = r6
            r2.f3542r = r5
            android.view.View r4 = r2.getSecondView()
            if (r4 == 0) goto L_0x003c
            boolean r5 = r2.d()
            if (r5 == 0) goto L_0x0030
            android.view.View r5 = r2.f3534j
            if (r5 == 0) goto L_0x002a
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r6
            goto L_0x0031
        L_0x002a:
            java.lang.String r4 = "dragView"
            xa.j.l(r4)
            throw r1
        L_0x0030:
            r5 = r6
        L_0x0031:
            r4.setTop(r5)
            int r5 = r2.getHeight()
            int r5 = r5 + r6
            r4.setBottom(r5)
        L_0x003c:
            return
        L_0x003d:
            com.google.android.material.sidesheet.SideSheetBehavior r2 = (com.google.android.material.sidesheet.SideSheetBehavior) r2
            java.lang.ref.WeakReference r5 = r2.f3850p
            if (r5 == 0) goto L_0x004a
            java.lang.Object r5 = r5.get()
            r1 = r5
            android.view.View r1 = (android.view.View) r1
        L_0x004a:
            if (r1 == 0) goto L_0x0069
            android.view.ViewGroup$LayoutParams r5 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            if (r5 == 0) goto L_0x0069
            u8.a r6 = r2.f3835a
            int r0 = r4.getLeft()
            r4.getRight()
            com.google.android.material.sidesheet.SideSheetBehavior r4 = r6.f15438a
            int r4 = r4.f3847m
            if (r0 > r4) goto L_0x0066
            int r4 = r4 - r0
            r5.rightMargin = r4
        L_0x0066:
            r1.setLayoutParams(r5)
        L_0x0069:
            java.util.LinkedHashSet r4 = r2.f3854t
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x008e
            u8.a r5 = r2.f3835a
            com.google.android.material.sidesheet.SideSheetBehavior r6 = r5.f15438a
            int r6 = r6.f3847m
            r5.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x007e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x008e
            java.lang.Object r5 = r4.next()
            u8.e r5 = (u8.e) r5
            r5.a()
            goto L_0x007e
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.d.g(android.view.View, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d8, code lost:
        if (r2 != false) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        if (r2 == false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0103, code lost:
        if (java.lang.Math.abs(r10 - r0.a()) < java.lang.Math.abs(r10 - r6.f3847m)) goto L_0x0105;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            int r0 = r8.f13405a
            java.lang.Object r1 = r8.f13406b
            r2 = 0
            switch(r0) {
                case 0: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0081
        L_0x000a:
            java.lang.String r11 = "releasedChild"
            xa.j.f(r11, r9)
            com.github.andreyasadchy.xtra.ui.view.SlidingLayout r1 = (com.github.andreyasadchy.xtra.ui.view.SlidingLayout) r1
            boolean r11 = r1.f3546v
            if (r11 == 0) goto L_0x0021
            int r9 = r9.getTop()
            int r10 = r1.f3539o
            if (r9 < r10) goto L_0x007d
            r1.g()
            goto L_0x0080
        L_0x0021:
            boolean r11 = r1.f3532h
            if (r11 == 0) goto L_0x003f
            float r11 = r1.getPivotX()
            int r0 = r9.getLeft()
            float r0 = (float) r0
            float r11 = r11 + r0
            r1.setPivotX(r11)
            float r11 = r1.getPivotY()
            int r9 = r9.getTop()
            float r9 = (float) r9
            float r11 = r11 + r9
            r1.setPivotY(r11)
        L_0x003f:
            r9 = 1153138688(0x44bb8000, float:1500.0)
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x004b
            int r9 = r1.getWidth()
            goto L_0x005b
        L_0x004b:
            r9 = -994344960(0xffffffffc4bb8000, float:-1500.0)
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x007d
            android.view.View r9 = r1.f3534j
            if (r9 == 0) goto L_0x0076
            int r9 = r9.getWidth()
            int r9 = -r9
        L_0x005b:
            int r10 = r1.f3541q
            r1.h(r9, r10)
            java.util.ArrayList r9 = r1.f3550z
            java.util.Iterator r9 = r9.iterator()
        L_0x0066:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0080
            java.lang.Object r10 = r9.next()
            q7.c r10 = (q7.c) r10
            r10.q()
            goto L_0x0066
        L_0x0076:
            java.lang.String r9 = "dragView"
            xa.j.l(r9)
            r9 = 0
            throw r9
        L_0x007d:
            r1.h(r2, r2)
        L_0x0080:
            return
        L_0x0081:
            com.google.android.material.sidesheet.SideSheetBehavior r1 = (com.google.android.material.sidesheet.SideSheetBehavior) r1
            u8.a r0 = r1.f3835a
            r0.getClass()
            r3 = 1
            r4 = 0
            int r5 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0090
            goto L_0x0105
        L_0x0090:
            int r5 = r9.getRight()
            float r5 = (float) r5
            com.google.android.material.sidesheet.SideSheetBehavior r6 = r0.f15438a
            float r7 = r6.f3845k
            float r7 = r7 * r10
            float r7 = r7 + r5
            float r5 = java.lang.Math.abs(r7)
            r7 = 1056964608(0x3f000000, float:0.5)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a8
            r5 = 1
            goto L_0x00a9
        L_0x00a8:
            r5 = 0
        L_0x00a9:
            if (r5 == 0) goto L_0x00db
            float r10 = java.lang.Math.abs(r10)
            float r4 = java.lang.Math.abs(r11)
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x00b9
            r10 = 1
            goto L_0x00ba
        L_0x00b9:
            r10 = 0
        L_0x00ba:
            if (r10 == 0) goto L_0x00c5
            r10 = 500(0x1f4, float:7.0E-43)
            float r10 = (float) r10
            int r10 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r10 <= 0) goto L_0x00c5
            r10 = 1
            goto L_0x00c6
        L_0x00c5:
            r10 = 0
        L_0x00c6:
            if (r10 != 0) goto L_0x0107
            int r10 = r9.getLeft()
            int r11 = r6.f3847m
            int r0 = r0.a()
            int r11 = r11 - r0
            int r11 = r11 / 2
            if (r10 <= r11) goto L_0x00d8
            r2 = 1
        L_0x00d8:
            if (r2 == 0) goto L_0x0105
            goto L_0x0107
        L_0x00db:
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00ee
            float r10 = java.lang.Math.abs(r10)
            float r11 = java.lang.Math.abs(r11)
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00ec
            r2 = 1
        L_0x00ec:
            if (r2 != 0) goto L_0x0107
        L_0x00ee:
            int r10 = r9.getLeft()
            int r11 = r0.a()
            int r11 = r10 - r11
            int r11 = java.lang.Math.abs(r11)
            int r0 = r6.f3847m
            int r10 = r10 - r0
            int r10 = java.lang.Math.abs(r10)
            if (r11 >= r10) goto L_0x0107
        L_0x0105:
            r10 = 3
            goto L_0x0108
        L_0x0107:
            r10 = 5
        L_0x0108:
            r1.t(r9, r10, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.d.h(android.view.View, float, float):void");
    }

    public final boolean i(View view, int i10) {
        WeakReference weakReference;
        int i11 = this.f13405a;
        Object obj = this.f13406b;
        switch (i11) {
            case 0:
                j.f("child", view);
                View view2 = ((SlidingLayout) obj).f3534j;
                if (view2 != null) {
                    return j.a(view, view2);
                }
                j.l("dragView");
                throw null;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                if (sideSheetBehavior.f3842h == 1 || (weakReference = sideSheetBehavior.f3849o) == null || weakReference.get() != view) {
                    return false;
                }
                return true;
        }
    }
}
