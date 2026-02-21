package android.support.v4.media;

import p9.l;
import q9.e;
import t9.a;

public final class i implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f328h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f329i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f330j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f331k;

    public /* synthetic */ i(Object obj, Object obj2, Object obj3, int i10) {
        this.f328h = i10;
        this.f331k = obj;
        this.f329i = obj2;
        this.f330j = obj3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        r2 = (x7.l) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            int r0 = r5.f328h
            r1 = 0
            java.lang.Object r2 = r5.f331k
            java.lang.Object r3 = r5.f330j
            java.lang.Object r4 = r5.f329i
            switch(r0) {
                case 0: goto L_0x005e;
                case 1: goto L_0x0056;
                case 2: goto L_0x0050;
                case 3: goto L_0x003c;
                case 4: goto L_0x0017;
                case 5: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x007c
        L_0x000d:
            y7.a r2 = (y7.a) r2
            android.view.View r4 = (android.view.View) r4
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2.h(r4, r3)
            return
        L_0x0017:
            android.view.View r3 = (android.view.View) r3
            if (r3 == 0) goto L_0x003b
            x7.l r2 = (x7.l) r2
            android.widget.OverScroller r0 = r2.f16731d
            if (r0 == 0) goto L_0x003b
            boolean r0 = r0.computeScrollOffset()
            androidx.coordinatorlayout.widget.CoordinatorLayout r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r4
            if (r0 == 0) goto L_0x0038
            android.widget.OverScroller r0 = r2.f16731d
            int r0 = r0.getCurrY()
            r2.A(r4, r3, r0)
            java.util.WeakHashMap r0 = m0.c1.f10054a
            m0.i0.m(r3, r5)
            goto L_0x003b
        L_0x0038:
            r2.y(r3, r4)
        L_0x003b:
            return
        L_0x003c:
            java.util.concurrent.Callable r4 = (java.util.concurrent.Callable) r4     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r1 = r4.call()     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            l0.a r3 = (l0.a) r3
            android.os.Handler r2 = (android.os.Handler) r2
            android.support.v4.media.i r0 = new android.support.v4.media.i
            r4 = 2
            r0.<init>(r5, r3, r1, r4)
            r2.post(r0)
            return
        L_0x0050:
            l0.a r4 = (l0.a) r4
            r4.b(r3)
            return
        L_0x0056:
            j0.j r4 = (j0.j) r4
            android.graphics.Typeface r3 = (android.graphics.Typeface) r3
            r4.b(r3)
            return
        L_0x005e:
            boolean r0 = android.support.v4.media.s.f343b
            if (r0 != 0) goto L_0x006a
            android.support.v4.media.k r2 = (android.support.v4.media.k) r2
            java.lang.String r0 = "onServiceConnected"
            r2.a(r0)
            throw r1
        L_0x006a:
            android.content.ComponentName r4 = (android.content.ComponentName) r4
            java.util.Objects.toString(r4)
            android.os.IBinder r3 = (android.os.IBinder) r3
            java.util.Objects.toString(r3)
            android.support.v4.media.k r2 = (android.support.v4.media.k) r2
            java.lang.Object r0 = r2.f335h
            android.support.v4.media.h.y(r0)
            throw r1
        L_0x007c:
            q9.e r4 = (q9.e) r4
            p9.x r0 = r4.f13442q
            int r0 = r0.ordinal()
            switch(r0) {
                case 1: goto L_0x00b4;
                case 2: goto L_0x0087;
                case 3: goto L_0x00ae;
                case 4: goto L_0x00a8;
                case 5: goto L_0x00a2;
                case 6: goto L_0x009a;
                case 7: goto L_0x0094;
                case 8: goto L_0x008e;
                case 9: goto L_0x0088;
                default: goto L_0x0087;
            }
        L_0x0087:
            goto L_0x00ba
        L_0x0088:
            p9.l r2 = (p9.l) r2
            r2.f(r4)
            goto L_0x00ba
        L_0x008e:
            p9.l r2 = (p9.l) r2
            r2.j(r4)
            goto L_0x00ba
        L_0x0094:
            p9.l r2 = (p9.l) r2
            r2.e(r4)
            goto L_0x00ba
        L_0x009a:
            p9.l r2 = (p9.l) r2
            p9.f r0 = r4.f13443r
            r2.b(r4, r0, r1)
            goto L_0x00ba
        L_0x00a2:
            p9.l r2 = (p9.l) r2
            r2.m(r4)
            goto L_0x00ba
        L_0x00a8:
            p9.l r2 = (p9.l) r2
            r2.a(r4)
            goto L_0x00ba
        L_0x00ae:
            p9.l r2 = (p9.l) r2
            r2.k(r4)
            goto L_0x00ba
        L_0x00b4:
            p9.l r2 = (p9.l) r2
            r0 = 0
            r2.c(r4, r0)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.i.run():void");
    }

    public i(e eVar, a aVar, l lVar) {
        this.f328h = 6;
        this.f329i = eVar;
        this.f330j = aVar;
        this.f331k = lVar;
    }
}
