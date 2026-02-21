package b8;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import u0.g;

public final class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f2662a;

    public a(BottomSheetBehavior bottomSheetBehavior) {
        this.f2662a = bottomSheetBehavior;
    }

    public final int a(View view, int i10) {
        return view.getLeft();
    }

    public final int b(View view, int i10) {
        return h0.a.a(i10, this.f2662a.y(), d());
    }

    public final int d() {
        BottomSheetBehavior bottomSheetBehavior = this.f2662a;
        if (bottomSheetBehavior.I) {
            return bottomSheetBehavior.T;
        }
        return bottomSheetBehavior.G;
    }

    public final void f(int i10) {
        if (i10 == 1) {
            BottomSheetBehavior bottomSheetBehavior = this.f2662a;
            if (bottomSheetBehavior.K) {
                bottomSheetBehavior.F(1);
            }
        }
    }

    public final void g(View view, int i10, int i11) {
        this.f2662a.u(i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (java.lang.Math.abs(r5.getTop() - r1.y()) < java.lang.Math.abs(r5.getTop() - r1.E)) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0099, code lost:
        if (java.lang.Math.abs(r6 - r1.E) < java.lang.Math.abs(r6 - r1.G)) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b3, code lost:
        if (java.lang.Math.abs(r6 - r1.D) < java.lang.Math.abs(r6 - r1.G)) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c2, code lost:
        if (r6 < java.lang.Math.abs(r6 - r1.G)) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d3, code lost:
        if (java.lang.Math.abs(r6 - r7) < java.lang.Math.abs(r6 - r1.G)) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r6 > r1.E) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(android.view.View r5, float r6, float r7) {
        /*
            r4 = this;
            r0 = 1
            com.google.android.material.bottomsheet.BottomSheetBehavior r1 = r4.f2662a
            r2 = 0
            int r3 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x001b
            boolean r6 = r1.f3663b
            if (r6 == 0) goto L_0x000e
            goto L_0x00c4
        L_0x000e:
            int r6 = r5.getTop()
            java.lang.System.currentTimeMillis()
            int r7 = r1.E
            if (r6 <= r7) goto L_0x00c4
            goto L_0x00d5
        L_0x001b:
            boolean r3 = r1.I
            if (r3 == 0) goto L_0x0070
            boolean r3 = r1.G(r5, r7)
            if (r3 == 0) goto L_0x0070
            float r6 = java.lang.Math.abs(r6)
            float r2 = java.lang.Math.abs(r7)
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0038
            int r6 = r1.f3667d
            float r6 = (float) r6
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x004c
        L_0x0038:
            int r6 = r5.getTop()
            int r7 = r1.T
            int r2 = r1.y()
            int r2 = r2 + r7
            int r2 = r2 / 2
            if (r6 <= r2) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            if (r6 == 0) goto L_0x004f
        L_0x004c:
            r6 = 5
            goto L_0x00d8
        L_0x004f:
            boolean r6 = r1.f3663b
            if (r6 == 0) goto L_0x0055
            goto L_0x00c4
        L_0x0055:
            int r6 = r5.getTop()
            int r7 = r1.y()
            int r6 = r6 - r7
            int r6 = java.lang.Math.abs(r6)
            int r7 = r5.getTop()
            int r2 = r1.E
            int r7 = r7 - r2
            int r7 = java.lang.Math.abs(r7)
            if (r6 >= r7) goto L_0x00d5
            goto L_0x00c4
        L_0x0070:
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x009c
            float r6 = java.lang.Math.abs(r6)
            float r7 = java.lang.Math.abs(r7)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x0081
            goto L_0x009c
        L_0x0081:
            boolean r6 = r1.f3663b
            if (r6 == 0) goto L_0x0086
            goto L_0x00d7
        L_0x0086:
            int r6 = r5.getTop()
            int r7 = r1.E
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r2 = r1.G
            int r6 = r6 - r2
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto L_0x00d7
            goto L_0x00d5
        L_0x009c:
            int r6 = r5.getTop()
            boolean r7 = r1.f3663b
            if (r7 == 0) goto L_0x00b6
            int r7 = r1.D
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r2 = r1.G
            int r6 = r6 - r2
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto L_0x00d7
            goto L_0x00c4
        L_0x00b6:
            int r7 = r1.E
            if (r6 >= r7) goto L_0x00c6
            int r7 = r1.G
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            if (r6 >= r7) goto L_0x00d5
        L_0x00c4:
            r6 = 3
            goto L_0x00d8
        L_0x00c6:
            int r7 = r6 - r7
            int r7 = java.lang.Math.abs(r7)
            int r2 = r1.G
            int r6 = r6 - r2
            int r6 = java.lang.Math.abs(r6)
            if (r7 >= r6) goto L_0x00d7
        L_0x00d5:
            r6 = 6
            goto L_0x00d8
        L_0x00d7:
            r6 = 4
        L_0x00d8:
            r1.getClass()
            r1.H(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.a.h(android.view.View, float, float):void");
    }

    public final boolean i(View view, int i10) {
        BottomSheetBehavior bottomSheetBehavior = this.f2662a;
        int i11 = bottomSheetBehavior.L;
        if (i11 == 1 || bottomSheetBehavior.f3662a0) {
            return false;
        }
        if (i11 == 3 && bottomSheetBehavior.Y == i10) {
            WeakReference weakReference = bottomSheetBehavior.V;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        System.currentTimeMillis();
        WeakReference weakReference2 = bottomSheetBehavior.U;
        return weakReference2 != null && weakReference2.get() == view;
    }
}
