package x7;

import android.support.v4.media.i;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import h0.a;

public abstract class l extends n {

    /* renamed from: c  reason: collision with root package name */
    public i f16730c;

    /* renamed from: d  reason: collision with root package name */
    public OverScroller f16731d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16732e;

    /* renamed from: f  reason: collision with root package name */
    public int f16733f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f16734g;

    /* renamed from: h  reason: collision with root package name */
    public int f16735h = -1;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f16736i;

    public l() {
    }

    public final void A(CoordinatorLayout coordinatorLayout, View view, int i10) {
        z(coordinatorLayout, view, i10, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
    }

    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z10;
        int findPointerIndex;
        if (this.f16735h < 0) {
            this.f16735h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f16732e) {
            int i10 = this.f16733f;
            if (i10 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y10 - this.f16734g) > this.f16735h) {
                this.f16734g = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f16733f = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (!v(view) || !coordinatorLayout.p(view, x10, y11)) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.f16732e = z10;
            if (z10) {
                this.f16734g = y11;
                this.f16733f = motionEvent.getPointerId(0);
                if (this.f16736i == null) {
                    this.f16736i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f16731d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f16731d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f16736i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean r(androidx.coordinatorlayout.widget.CoordinatorLayout r20, android.view.View r21, android.view.MotionEvent r22) {
        /*
            r19 = this;
            r6 = r19
            r1 = r20
            r2 = r21
            r7 = r22
            int r0 = r22.getActionMasked()
            r3 = 0
            r4 = -1
            r8 = 1
            r9 = 0
            if (r0 == r8) goto L_0x005f
            r5 = 2
            if (r0 == r5) goto L_0x0036
            r1 = 3
            if (r0 == r1) goto L_0x00c3
            r1 = 6
            if (r0 == r1) goto L_0x001c
            goto L_0x005d
        L_0x001c:
            int r0 = r22.getActionIndex()
            if (r0 != 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            int r1 = r7.getPointerId(r0)
            r6.f16733f = r1
            float r0 = r7.getY(r0)
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            int r0 = (int) r0
            r6.f16734g = r0
            goto L_0x005d
        L_0x0036:
            int r0 = r6.f16733f
            int r0 = r7.findPointerIndex(r0)
            if (r0 != r4) goto L_0x003f
            return r9
        L_0x003f:
            float r0 = r7.getY(r0)
            int r0 = (int) r0
            int r3 = r6.f16734g
            int r3 = r3 - r0
            r6.f16734g = r0
            int r4 = r6.w(r2)
            r5 = 0
            int r0 = r19.t()
            int r3 = r0 - r3
            r0 = r19
            r1 = r20
            r2 = r21
            r0.z(r1, r2, r3, r4, r5)
        L_0x005d:
            r0 = 0
            goto L_0x00d1
        L_0x005f:
            android.view.VelocityTracker r0 = r6.f16736i
            if (r0 == 0) goto L_0x00c3
            r0.addMovement(r7)
            android.view.VelocityTracker r0 = r6.f16736i
            r5 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r5)
            android.view.VelocityTracker r0 = r6.f16736i
            int r5 = r6.f16733f
            float r0 = r0.getYVelocity(r5)
            int r5 = r6.x(r2)
            int r5 = -r5
            r18 = 0
            android.support.v4.media.i r10 = r6.f16730c
            if (r10 == 0) goto L_0x0085
            r2.removeCallbacks(r10)
            r6.f16730c = r3
        L_0x0085:
            android.widget.OverScroller r10 = r6.f16731d
            if (r10 != 0) goto L_0x0094
            android.widget.OverScroller r10 = new android.widget.OverScroller
            android.content.Context r11 = r21.getContext()
            r10.<init>(r11)
            r6.f16731d = r10
        L_0x0094:
            android.widget.OverScroller r10 = r6.f16731d
            r11 = 0
            int r12 = r19.s()
            r13 = 0
            int r14 = java.lang.Math.round(r0)
            r15 = 0
            r16 = 0
            r17 = r5
            r10.fling(r11, r12, r13, r14, r15, r16, r17, r18)
            android.widget.OverScroller r0 = r6.f16731d
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto L_0x00be
            android.support.v4.media.i r0 = new android.support.v4.media.i
            r5 = 4
            r0.<init>(r6, r1, r2, r5)
            r6.f16730c = r0
            java.util.WeakHashMap r1 = m0.c1.f10054a
            m0.i0.m(r2, r0)
            goto L_0x00c1
        L_0x00be:
            r6.y(r2, r1)
        L_0x00c1:
            r0 = 1
            goto L_0x00c4
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            r6.f16732e = r9
            r6.f16733f = r4
            android.view.VelocityTracker r1 = r6.f16736i
            if (r1 == 0) goto L_0x00d1
            r1.recycle()
            r6.f16736i = r3
        L_0x00d1:
            android.view.VelocityTracker r1 = r6.f16736i
            if (r1 == 0) goto L_0x00d8
            r1.addMovement(r7)
        L_0x00d8:
            boolean r1 = r6.f16732e
            if (r1 != 0) goto L_0x00e0
            if (r0 == 0) goto L_0x00df
            goto L_0x00e0
        L_0x00df:
            r8 = 0
        L_0x00e0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x7.l.r(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean v(View view) {
        return false;
    }

    public int w(View view) {
        return -view.getHeight();
    }

    public int x(View view) {
        return view.getHeight();
    }

    public void y(View view, CoordinatorLayout coordinatorLayout) {
    }

    public int z(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
        int a10;
        int s10 = s();
        if (i11 == 0 || s10 < i11 || s10 > i12 || s10 == (a10 = a.a(i10, i11, i12))) {
            return 0;
        }
        o oVar = this.f16741a;
        if (oVar == null) {
            this.f16742b = a10;
        } else if (oVar.f16746d != a10) {
            oVar.f16746d = a10;
            oVar.a();
        }
        return s10 - a10;
    }

    public l(int i10) {
        super(0);
    }
}
