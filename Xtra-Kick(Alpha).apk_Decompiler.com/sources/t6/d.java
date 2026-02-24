package t6;

import android.view.View;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14578h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f14579i;

    public /* synthetic */ d(l lVar, int i10) {
        this.f14578h = i10;
        this.f14579i = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bc, code lost:
        r1 = android.os.Bundle.EMPTY;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r8 = r7.f14578h
            r0 = 1
            r1 = 0
            t6.l r2 = r7.f14579i
            java.lang.String r3 = "this$0"
            switch(r8) {
                case 0: goto L_0x00ff;
                case 1: goto L_0x00f6;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00d7;
                case 5: goto L_0x00b1;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                case 10: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0108
        L_0x000d:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.M0(r0)
            return
        L_0x0016:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.M0(r1)
            return
        L_0x001f:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.F0()
            return
        L_0x0028:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.I0()
            return
        L_0x0031:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            android.view.View r8 = r2.h0()
            r3 = 2131362236(0x7f0a01bc, float:1.8344247E38)
            android.view.View r8 = r8.findViewById(r3)
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00b0
            int r3 = r8.getVisibility()
            if (r3 != 0) goto L_0x004d
            r3 = 1
            goto L_0x004e
        L_0x004d:
            r3 = 0
        L_0x004e:
            java.lang.String r4 = "key_chat_bar_visible"
            java.lang.String r5 = "editor"
            if (r3 == 0) goto L_0x009c
            android.view.ViewGroup r0 = r2.f14627n0
            r3 = 0
            java.lang.String r6 = "chatLayout"
            if (r0 == 0) goto L_0x0098
            hb.h0.P0(r0)
            android.view.ViewGroup r0 = r2.f14627n0
            if (r0 == 0) goto L_0x0094
            r0.clearFocus()
            boolean r0 = r2 instanceof w6.f
            if (r0 == 0) goto L_0x0082
            r0 = r2
            w6.f r0 = (w6.f) r0
            boolean r3 = r0.O0()
            if (r3 == 0) goto L_0x0082
            i6.e r0 = r0.P0()
            k5.a r0 = r0.f8315o0
            xa.j.c(r0)
            java.lang.Object r0 = r0.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r0 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r0
            r0.y(r1)
        L_0x0082:
            hb.h0.J0(r8)
            android.content.SharedPreferences r8 = r2.t0()
            android.content.SharedPreferences$Editor r8 = r8.edit()
            xa.j.e(r5, r8)
            r8.putBoolean(r4, r1)
            goto L_0x00ad
        L_0x0094:
            xa.j.l(r6)
            throw r3
        L_0x0098:
            xa.j.l(r6)
            throw r3
        L_0x009c:
            r8.setVisibility(r1)
            android.content.SharedPreferences r8 = r2.t0()
            android.content.SharedPreferences$Editor r8 = r8.edit()
            xa.j.e(r5, r8)
            r8.putBoolean(r4, r0)
        L_0x00ad:
            r8.apply()
        L_0x00b0:
            return
        L_0x00b1:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            h3.b0 r8 = r2.s0()
            if (r8 == 0) goto L_0x00d6
            h3.f4 r0 = new h3.f4
            android.os.Bundle r1 = android.os.Bundle.EMPTY
            java.lang.String r3 = "switchAudioMode"
            r0.<init>(r1, r3)
            h9.e0 r8 = r8.T0(r0, r1)
            if (r8 == 0) goto L_0x00d6
            t6.c r0 = new t6.c
            r1 = 3
            r0.<init>(r8, r2, r1)
            h9.q r1 = h9.q.f7765h
            r8.a(r0, r1)
        L_0x00d6:
            return
        L_0x00d7:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.G0()
            return
        L_0x00e0:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.K0()
            return
        L_0x00e9:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            com.github.andreyasadchy.xtra.ui.view.SlidingLayout r8 = r2.u0()
            r8.g()
            return
        L_0x00f6:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.D0()
            return
        L_0x00ff:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.H0()
            return
        L_0x0108:
            t6.f r8 = t6.l.f14620w0
            xa.j.f(r3, r2)
            r2.w0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.d.onClick(android.view.View):void");
    }
}
