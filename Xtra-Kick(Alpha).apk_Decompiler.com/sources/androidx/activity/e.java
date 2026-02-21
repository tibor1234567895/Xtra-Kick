package androidx.activity;

import h3.b3;
import la.v;
import r3.y;
import u3.o;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f477h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f478i;

    public /* synthetic */ e(int i10, Object obj) {
        this.f477h = i10;
        this.f478i = obj;
    }

    private final void a() {
        synchronized (((b3) this.f478i).f6934h) {
        }
    }

    private final void b() {
        y yVar = (y) this.f478i;
        synchronized (yVar.f13789o) {
            yVar.f13782h = false;
            yVar.f13784j.d();
            o oVar = yVar.f13783i;
            if (oVar != null) {
                oVar.close();
                v vVar = v.f9814a;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r16 = this;
            r1 = r16
            int r0 = r1.f477h
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 0
            r7 = 1
            switch(r0) {
                case 0: goto L_0x0249;
                case 1: goto L_0x0241;
                case 2: goto L_0x0239;
                case 3: goto L_0x0186;
                case 4: goto L_0x0172;
                case 5: goto L_0x0163;
                case 6: goto L_0x0153;
                case 7: goto L_0x0129;
                case 8: goto L_0x011f;
                case 9: goto L_0x0107;
                case 10: goto L_0x00eb;
                case 11: goto L_0x00e3;
                case 12: goto L_0x00b6;
                case 13: goto L_0x0085;
                case 14: goto L_0x006e;
                case 15: goto L_0x006a;
                case 16: goto L_0x0062;
                case 17: goto L_0x0058;
                case 18: goto L_0x004e;
                case 19: goto L_0x004a;
                case 20: goto L_0x003b;
                case 21: goto L_0x000d;
                case 22: goto L_0x0017;
                case 23: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0251
        L_0x000f:
            java.lang.Object r0 = r1.f478i
            y8.d r0 = (y8.d) r0
            r0.t(r7)
            return
        L_0x0017:
            java.lang.Object r0 = r1.f478i
            b8.e r0 = (b8.e) r0
            r0.f2670c = r6
            z.b r2 = r0.f2672e
            com.google.android.material.sidesheet.SideSheetBehavior r2 = (com.google.android.material.sidesheet.SideSheetBehavior) r2
            u0.h r3 = r2.f3843i
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.g()
            if (r3 == 0) goto L_0x0031
            int r2 = r0.f2669b
            r0.a(r2)
            goto L_0x003a
        L_0x0031:
            int r3 = r2.f3842h
            if (r3 != r4) goto L_0x003a
            int r0 = r0.f2669b
            r2.s(r0)
        L_0x003a:
            return
        L_0x003b:
            java.lang.Object r0 = r1.f478i
            com.github.andreyasadchy.xtra.ui.view.CustomPlayerView r0 = (com.github.andreyasadchy.xtra.ui.view.CustomPlayerView) r0
            int r2 = com.github.andreyasadchy.xtra.ui.view.CustomPlayerView.K
            java.lang.String r2 = "this$0"
            xa.j.f(r2, r0)
            r0.performClick()
            return
        L_0x004a:
            r16.b()
            return
        L_0x004e:
            java.lang.Object r0 = r1.f478i
            i3.w r0 = (i3.w) r0
            float[] r2 = i3.w.E0
            r0.p()
            return
        L_0x0058:
            java.lang.Object r0 = r1.f478i
            androidx.media3.ui.DefaultTimeBar r0 = (androidx.media3.ui.DefaultTimeBar) r0
            int r2 = androidx.media3.ui.DefaultTimeBar.W
            r0.e(r6)
            return
        L_0x0062:
            java.lang.Object r0 = r1.f478i
            h3.e4 r0 = (h3.e4) r0
            r0.b()
            return
        L_0x006a:
            r16.a()
            return
        L_0x006e:
            java.lang.Object r0 = r1.f478i
            h3.y0 r0 = (h3.y0) r0
            h3.v0 r2 = r0.f7464l
            if (r2 == 0) goto L_0x007d
            android.content.Context r3 = r0.f7456d
            r3.unbindService(r2)
            r0.f7464l = r5
        L_0x007d:
            h3.o1 r0 = r0.f7455c
            java.lang.ref.WeakReference r0 = r0.f7266d
            r0.clear()
            return
        L_0x0085:
            java.lang.Object r0 = r1.f478i
            c2.m r0 = (c2.m) r0
            android.view.Surface r2 = r0.f2787o
            if (r2 == 0) goto L_0x00a5
            java.util.concurrent.CopyOnWriteArrayList r3 = r0.f2780h
            java.util.Iterator r3 = r3.iterator()
        L_0x0093:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00a5
            java.lang.Object r4 = r3.next()
            m1.k0 r4 = (m1.k0) r4
            m1.n0 r4 = r4.f10314h
            r4.q1(r5)
            goto L_0x0093
        L_0x00a5:
            android.graphics.SurfaceTexture r3 = r0.f2786n
            if (r3 == 0) goto L_0x00ac
            r3.release()
        L_0x00ac:
            if (r2 == 0) goto L_0x00b1
            r2.release()
        L_0x00b1:
            r0.f2786n = r5
            r0.f2787o = r5
            return
        L_0x00b6:
            java.lang.Object r0 = r1.f478i
            s1.f r0 = (s1.f) r0
            java.lang.Object r2 = r0.f14003a
            monitor-enter(r2)
            boolean r3 = r0.f14014l     // Catch:{ all -> 0x00e0 }
            if (r3 == 0) goto L_0x00c2
            goto L_0x00de
        L_0x00c2:
            long r3 = r0.f14013k     // Catch:{ all -> 0x00e0 }
            r5 = 1
            long r3 = r3 - r5
            r0.f14013k = r3     // Catch:{ all -> 0x00e0 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d0
            goto L_0x00de
        L_0x00d0:
            if (r7 >= 0) goto L_0x00db
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e0 }
            r3.<init>()     // Catch:{ all -> 0x00e0 }
            r0.b(r3)     // Catch:{ all -> 0x00e0 }
            goto L_0x00de
        L_0x00db:
            r0.a()     // Catch:{ all -> 0x00e0 }
        L_0x00de:
            monitor-exit(r2)     // Catch:{ all -> 0x00e0 }
            return
        L_0x00e0:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00e0 }
            throw r0
        L_0x00e3:
            java.lang.Object r0 = r1.f478i
            p1.e r0 = (p1.e) r0
            r0.d(r5)
            return
        L_0x00eb:
            java.lang.Object r0 = r1.f478i
            p1.j r0 = (p1.j) r0
            boolean r2 = r0.f12470j
            if (r2 == 0) goto L_0x00f4
            goto L_0x0106
        L_0x00f4:
            p1.n r2 = r0.f12469i
            if (r2 == 0) goto L_0x00fd
            p1.q r3 = r0.f12468h
            r2.d(r3)
        L_0x00fd:
            p1.k r2 = r0.f12471k
            java.util.Set r2 = r2.f12484n
            r2.remove(r0)
            r0.f12470j = r7
        L_0x0106:
            return
        L_0x0107:
            java.lang.Object r0 = r1.f478i
            n1.x r0 = (n1.x) r0
            n1.b r2 = r0.b()
            n1.w r4 = new n1.w
            r4.<init>(r2, r3)
            r3 = 1028(0x404, float:1.44E-42)
            r0.d0(r2, r3, r4)
            v.e r0 = r0.f11002m
            r0.k()
            return
        L_0x011f:
            java.lang.Object r0 = r1.f478i
            m1.s1 r0 = (m1.s1) r0
            int r2 = g.g0.f6073c
            r0.d()
            return
        L_0x0129:
            java.lang.Object r0 = r1.f478i
            androidx.lifecycle.y0 r0 = (androidx.lifecycle.y0) r0
            androidx.lifecycle.u0 r2 = androidx.lifecycle.y0.f1792p
            java.lang.String r2 = "this$0"
            xa.j.f(r2, r0)
            int r2 = r0.f1795i
            if (r2 != 0) goto L_0x0141
            r0.f1796j = r7
            androidx.lifecycle.g0 r2 = r0.f1799m
            androidx.lifecycle.r r3 = androidx.lifecycle.r.ON_PAUSE
            r2.f(r3)
        L_0x0141:
            int r2 = r0.f1794h
            if (r2 != 0) goto L_0x0152
            boolean r2 = r0.f1796j
            if (r2 == 0) goto L_0x0152
            androidx.lifecycle.g0 r2 = r0.f1799m
            androidx.lifecycle.r r3 = androidx.lifecycle.r.ON_STOP
            r2.f(r3)
            r0.f1797k = r7
        L_0x0152:
            return
        L_0x0153:
            java.lang.Object r0 = r1.f478i
            androidx.fragment.app.c0 r0 = (androidx.fragment.app.c0) r0
            androidx.fragment.app.y1 r2 = r0.W
            android.os.Bundle r3 = r0.f1355k
            t3.g r2 = r2.f1620m
            r2.b(r3)
            r0.f1355k = r5
            return
        L_0x0163:
            java.lang.Object r0 = r1.f478i
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            androidx.fragment.app.c2 r3 = androidx.fragment.app.n.f1505f
            java.lang.String r3 = "$transitioningViews"
            xa.j.f(r3, r0)
            androidx.fragment.app.q1.b(r0, r2)
            return
        L_0x0172:
            java.lang.Object r0 = r1.f478i
            android.view.View r0 = (android.view.View) r0
            android.content.Context r2 = r0.getContext()
            java.lang.String r3 = "input_method"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.view.inputmethod.InputMethodManager r2 = (android.view.inputmethod.InputMethodManager) r2
            r2.showSoftInput(r0, r6)
            return
        L_0x0186:
            java.lang.Object r0 = r1.f478i
            r8 = r0
            android.app.Activity r8 = (android.app.Activity) r8
            int r0 = b0.e.f2338b
            boolean r0 = r8.isFinishing()
            if (r0 != 0) goto L_0x0238
            int r0 = android.os.Build.VERSION.SDK_INT
            r9 = 28
            if (r0 < r9) goto L_0x01a0
            java.lang.Class r0 = b0.g.f2346a
            r8.recreate()
            goto L_0x0225
        L_0x01a0:
            java.lang.Class r9 = b0.g.f2346a
            r9 = 27
            r10 = 26
            if (r0 == r10) goto L_0x01ad
            if (r0 != r9) goto L_0x01ab
            goto L_0x01ad
        L_0x01ab:
            r11 = 0
            goto L_0x01ae
        L_0x01ad:
            r11 = 1
        L_0x01ae:
            java.lang.reflect.Method r12 = b0.g.f2351f
            if (r11 == 0) goto L_0x01b6
            if (r12 != 0) goto L_0x01b6
            goto L_0x0233
        L_0x01b6:
            java.lang.reflect.Method r11 = b0.g.f2350e
            if (r11 != 0) goto L_0x01c0
            java.lang.reflect.Method r11 = b0.g.f2349d
            if (r11 != 0) goto L_0x01c0
            goto L_0x0233
        L_0x01c0:
            java.lang.reflect.Field r11 = b0.g.f2348c     // Catch:{ all -> 0x0232 }
            java.lang.Object r11 = r11.get(r8)     // Catch:{ all -> 0x0232 }
            if (r11 != 0) goto L_0x01c9
            goto L_0x0233
        L_0x01c9:
            java.lang.reflect.Field r13 = b0.g.f2347b     // Catch:{ all -> 0x0232 }
            java.lang.Object r13 = r13.get(r8)     // Catch:{ all -> 0x0232 }
            if (r13 != 0) goto L_0x01d2
            goto L_0x0233
        L_0x01d2:
            android.app.Application r14 = r8.getApplication()     // Catch:{ all -> 0x0232 }
            b0.f r15 = new b0.f     // Catch:{ all -> 0x0232 }
            r15.<init>(r8)     // Catch:{ all -> 0x0232 }
            r14.registerActivityLifecycleCallbacks(r15)     // Catch:{ all -> 0x0232 }
            android.os.Handler r2 = b0.g.f2352g
            android.support.v4.media.j r3 = new android.support.v4.media.j     // Catch:{ all -> 0x0232 }
            r3.<init>((java.lang.Object) r15, (java.lang.Object) r11, (int) r4)     // Catch:{ all -> 0x0232 }
            r2.post(r3)     // Catch:{ all -> 0x0232 }
            if (r0 == r10) goto L_0x01ef
            if (r0 != r9) goto L_0x01ed
            goto L_0x01ef
        L_0x01ed:
            r0 = 0
            goto L_0x01f0
        L_0x01ef:
            r0 = 1
        L_0x01f0:
            if (r0 == 0) goto L_0x0219
            r0 = 9
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0227 }
            r0[r6] = r11     // Catch:{ all -> 0x0227 }
            r0[r7] = r5     // Catch:{ all -> 0x0227 }
            r0[r4] = r5     // Catch:{ all -> 0x0227 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0227 }
            r4 = 3
            r0[r4] = r3     // Catch:{ all -> 0x0227 }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0227 }
            r4 = 4
            r0[r4] = r3     // Catch:{ all -> 0x0227 }
            r4 = 5
            r0[r4] = r5     // Catch:{ all -> 0x0227 }
            r4 = 6
            r0[r4] = r5     // Catch:{ all -> 0x0227 }
            r4 = 7
            r0[r4] = r3     // Catch:{ all -> 0x0227 }
            r4 = 8
            r0[r4] = r3     // Catch:{ all -> 0x0227 }
            r12.invoke(r13, r0)     // Catch:{ all -> 0x0227 }
            goto L_0x021c
        L_0x0219:
            r8.recreate()     // Catch:{ all -> 0x0227 }
        L_0x021c:
            android.support.v4.media.j r0 = new android.support.v4.media.j     // Catch:{ all -> 0x0232 }
            r3 = 3
            r0.<init>((java.lang.Object) r14, (java.lang.Object) r15, (int) r3)     // Catch:{ all -> 0x0232 }
            r2.post(r0)     // Catch:{ all -> 0x0232 }
        L_0x0225:
            r6 = 1
            goto L_0x0233
        L_0x0227:
            r0 = move-exception
            android.support.v4.media.j r3 = new android.support.v4.media.j     // Catch:{ all -> 0x0232 }
            r4 = 3
            r3.<init>((java.lang.Object) r14, (java.lang.Object) r15, (int) r4)     // Catch:{ all -> 0x0232 }
            r2.post(r3)     // Catch:{ all -> 0x0232 }
            throw r0     // Catch:{ all -> 0x0232 }
        L_0x0232:
        L_0x0233:
            if (r6 != 0) goto L_0x0238
            r8.recreate()
        L_0x0238:
            return
        L_0x0239:
            java.lang.Object r0 = r1.f478i
            androidx.activity.r r0 = (androidx.activity.r) r0
            r0.b()
            return
        L_0x0241:
            java.lang.Object r0 = r1.f478i
            androidx.activity.m r0 = (androidx.activity.m) r0
            androidx.activity.m.b(r0)
            return
        L_0x0249:
            java.lang.Object r0 = r1.f478i
            androidx.activity.ComponentActivity r0 = (androidx.activity.ComponentActivity) r0
            r0.invalidateOptionsMenu()
            return
        L_0x0251:
            java.lang.Object r0 = r1.f478i
            y8.k r0 = (y8.k) r0
            android.widget.AutoCompleteTextView r2 = r0.f17142h
            boolean r2 = r2.isPopupShowing()
            r0.t(r2)
            r0.f17147m = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.e.run():void");
    }
}
