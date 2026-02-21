package androidx.appcompat.widget;

import android.view.View;

public final class a3 implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f725h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f726i;

    public /* synthetic */ a3(int i10, Object obj) {
        this.f725h = i10;
        this.f726i = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        r3 = (androidx.appcompat.widget.b3) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            int r7 = r6.f725h
            r0 = 1
            switch(r7) {
                case 0: goto L_0x0007;
                default: goto L_0x0006;
            }
        L_0x0006:
            return r0
        L_0x0007:
            int r7 = r8.getAction()
            float r1 = r8.getX()
            int r1 = (int) r1
            float r8 = r8.getY()
            int r8 = (int) r8
            java.lang.Object r2 = r6.f726i
            if (r7 != 0) goto L_0x0042
            r3 = r2
            androidx.appcompat.widget.b3 r3 = (androidx.appcompat.widget.b3) r3
            androidx.appcompat.widget.q0 r4 = r3.G
            if (r4 == 0) goto L_0x0042
            boolean r4 = r4.isShowing()
            if (r4 == 0) goto L_0x0042
            if (r1 < 0) goto L_0x0042
            androidx.appcompat.widget.q0 r4 = r3.G
            int r5 = r4.getWidth()
            if (r1 >= r5) goto L_0x0042
            if (r8 < 0) goto L_0x0042
            int r1 = r4.getHeight()
            if (r8 >= r1) goto L_0x0042
            android.os.Handler r7 = r3.C
            androidx.appcompat.widget.u2 r8 = r3.f768y
            r0 = 250(0xfa, double:1.235E-321)
            r7.postDelayed(r8, r0)
            goto L_0x004d
        L_0x0042:
            if (r7 != r0) goto L_0x004d
            androidx.appcompat.widget.b3 r2 = (androidx.appcompat.widget.b3) r2
            android.os.Handler r7 = r2.C
            androidx.appcompat.widget.u2 r8 = r2.f768y
            r7.removeCallbacks(r8)
        L_0x004d:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.a3.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
