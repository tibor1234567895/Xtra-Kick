package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewConfiguration;
import m.g0;

public abstract class r2 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final float f1032h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1033i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1034j;

    /* renamed from: k  reason: collision with root package name */
    public final View f1035k;

    /* renamed from: l  reason: collision with root package name */
    public q2 f1036l;

    /* renamed from: m  reason: collision with root package name */
    public q2 f1037m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1038n;

    /* renamed from: o  reason: collision with root package name */
    public int f1039o;

    /* renamed from: p  reason: collision with root package name */
    public final int[] f1040p = new int[2];

    public r2(View view) {
        this.f1035k = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1032h = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1033i = tapTimeout;
        this.f1034j = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        q2 q2Var = this.f1037m;
        View view = this.f1035k;
        if (q2Var != null) {
            view.removeCallbacks(q2Var);
        }
        q2 q2Var2 = this.f1036l;
        if (q2Var2 != null) {
            view.removeCallbacks(q2Var2);
        }
    }

    public abstract g0 b();

    public abstract boolean c();

    public abstract boolean d();

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        if (r4 != 3) goto L_0x00fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            r12 = this;
            boolean r13 = r12.f1038n
            r0 = 3
            android.view.View r1 = r12.f1035k
            r2 = 0
            r3 = 1
            if (r13 == 0) goto L_0x006d
            m.g0 r4 = r12.b()
            if (r4 == 0) goto L_0x005d
            boolean r5 = r4.b()
            if (r5 != 0) goto L_0x0016
            goto L_0x005d
        L_0x0016:
            androidx.appcompat.widget.o2 r4 = r4.f()
            if (r4 == 0) goto L_0x005d
            boolean r5 = r4.isShown()
            if (r5 != 0) goto L_0x0023
            goto L_0x005d
        L_0x0023:
            android.view.MotionEvent r5 = android.view.MotionEvent.obtainNoHistory(r14)
            int[] r6 = r12.f1040p
            r1.getLocationOnScreen(r6)
            r1 = r6[r2]
            float r1 = (float) r1
            r7 = r6[r3]
            float r7 = (float) r7
            r5.offsetLocation(r1, r7)
            r4.getLocationOnScreen(r6)
            r1 = r6[r2]
            int r1 = -r1
            float r1 = (float) r1
            r6 = r6[r3]
            int r6 = -r6
            float r6 = (float) r6
            r5.offsetLocation(r1, r6)
            int r1 = r12.f1039o
            boolean r1 = r4.b(r5, r1)
            r5.recycle()
            int r14 = r14.getActionMasked()
            if (r14 == r3) goto L_0x0056
            if (r14 == r0) goto L_0x0056
            r14 = 1
            goto L_0x0057
        L_0x0056:
            r14 = 0
        L_0x0057:
            if (r1 == 0) goto L_0x005d
            if (r14 == 0) goto L_0x005d
            r14 = 1
            goto L_0x005e
        L_0x005d:
            r14 = 0
        L_0x005e:
            if (r14 != 0) goto L_0x006a
            boolean r14 = r12.d()
            if (r14 != 0) goto L_0x0067
            goto L_0x006a
        L_0x0067:
            r14 = 0
            goto L_0x011f
        L_0x006a:
            r14 = 1
            goto L_0x011f
        L_0x006d:
            boolean r4 = r1.isEnabled()
            if (r4 != 0) goto L_0x0075
            goto L_0x00fe
        L_0x0075:
            int r4 = r14.getActionMasked()
            if (r4 == 0) goto L_0x00d2
            if (r4 == r3) goto L_0x00ce
            r5 = 2
            if (r4 == r5) goto L_0x0084
            if (r4 == r0) goto L_0x00ce
            goto L_0x00fe
        L_0x0084:
            int r0 = r12.f1039o
            int r0 = r14.findPointerIndex(r0)
            if (r0 < 0) goto L_0x00fe
            float r4 = r14.getX(r0)
            float r14 = r14.getY(r0)
            float r0 = r12.f1032h
            float r5 = -r0
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 < 0) goto L_0x00bf
            int r5 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x00bf
            int r5 = r1.getRight()
            int r6 = r1.getLeft()
            int r5 = r5 - r6
            float r5 = (float) r5
            float r5 = r5 + r0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x00bf
            int r4 = r1.getBottom()
            int r5 = r1.getTop()
            int r4 = r4 - r5
            float r4 = (float) r4
            float r4 = r4 + r0
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 >= 0) goto L_0x00bf
            r14 = 1
            goto L_0x00c0
        L_0x00bf:
            r14 = 0
        L_0x00c0:
            if (r14 != 0) goto L_0x00fe
            r12.a()
            android.view.ViewParent r14 = r1.getParent()
            r14.requestDisallowInterceptTouchEvent(r3)
            r14 = 1
            goto L_0x00ff
        L_0x00ce:
            r12.a()
            goto L_0x00fe
        L_0x00d2:
            int r14 = r14.getPointerId(r2)
            r12.f1039o = r14
            androidx.appcompat.widget.q2 r14 = r12.f1036l
            if (r14 != 0) goto L_0x00e3
            androidx.appcompat.widget.q2 r14 = new androidx.appcompat.widget.q2
            r14.<init>(r12, r2)
            r12.f1036l = r14
        L_0x00e3:
            androidx.appcompat.widget.q2 r14 = r12.f1036l
            int r0 = r12.f1033i
            long r4 = (long) r0
            r1.postDelayed(r14, r4)
            androidx.appcompat.widget.q2 r14 = r12.f1037m
            if (r14 != 0) goto L_0x00f6
            androidx.appcompat.widget.q2 r14 = new androidx.appcompat.widget.q2
            r14.<init>(r12, r3)
            r12.f1037m = r14
        L_0x00f6:
            androidx.appcompat.widget.q2 r14 = r12.f1037m
            int r0 = r12.f1034j
            long r4 = (long) r0
            r1.postDelayed(r14, r4)
        L_0x00fe:
            r14 = 0
        L_0x00ff:
            if (r14 == 0) goto L_0x0109
            boolean r14 = r12.c()
            if (r14 == 0) goto L_0x0109
            r14 = 1
            goto L_0x010a
        L_0x0109:
            r14 = 0
        L_0x010a:
            if (r14 == 0) goto L_0x011f
            long r6 = android.os.SystemClock.uptimeMillis()
            r8 = 3
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r6
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r4, r6, r8, r9, r10, r11)
            r1.onTouchEvent(r0)
            r0.recycle()
        L_0x011f:
            r12.f1038n = r14
            if (r14 != 0) goto L_0x0125
            if (r13 == 0) goto L_0x0126
        L_0x0125:
            r2 = 1
        L_0x0126:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r2.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f1038n = false;
        this.f1039o = -1;
        q2 q2Var = this.f1036l;
        if (q2Var != null) {
            this.f1035k.removeCallbacks(q2Var);
        }
    }
}
