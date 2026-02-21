package t6;

import android.view.View;

public final /* synthetic */ class b0 implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14573h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d0 f14574i;

    public /* synthetic */ b0(d0 d0Var, int i10) {
        this.f14573h = i10;
        this.f14574i = d0Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: i6.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: w6.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: w6.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: i6.m} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: w6.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: w6.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: x6.h} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v4, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v7, types: [m6.r] */
    /* JADX WARNING: type inference failed for: r3v10, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v13, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v16, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v28, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v31, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v46, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v49, types: [t6.l] */
    /* JADX WARNING: type inference failed for: r3v52 */
    /* JADX WARNING: type inference failed for: r3v53 */
    /* JADX WARNING: type inference failed for: r3v54 */
    /* JADX WARNING: type inference failed for: r3v55 */
    /* JADX WARNING: type inference failed for: r3v56 */
    /* JADX WARNING: type inference failed for: r3v57 */
    /* JADX WARNING: type inference failed for: r3v58 */
    /* JADX WARNING: type inference failed for: r3v59 */
    /* JADX WARNING: type inference failed for: r3v60 */
    /* JADX WARNING: type inference failed for: r3v61 */
    /* JADX WARNING: type inference failed for: r3v62 */
    /* JADX WARNING: type inference failed for: r3v63 */
    /* JADX WARNING: type inference failed for: r3v64 */
    /* JADX WARNING: type inference failed for: r3v65 */
    /* JADX WARNING: type inference failed for: r3v66 */
    /* JADX WARNING: type inference failed for: r3v67 */
    /* JADX WARNING: type inference failed for: r3v68 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r10) {
        /*
            r9 = this;
            r10 = 3
            int r0 = r9.f14573h
            r1 = 0
            r2 = 1
            r3 = 0
            t6.d0 r4 = r9.f14574i
            java.lang.String r5 = "this$0"
            switch(r0) {
                case 0: goto L_0x0254;
                case 1: goto L_0x023d;
                case 2: goto L_0x0226;
                case 3: goto L_0x020f;
                case 4: goto L_0x01f8;
                case 5: goto L_0x01b5;
                case 6: goto L_0x01ac;
                case 7: goto L_0x0195;
                case 8: goto L_0x017e;
                case 9: goto L_0x0167;
                case 10: goto L_0x0150;
                case 11: goto L_0x00df;
                case 12: goto L_0x00b4;
                case 13: goto L_0x009d;
                case 14: goto L_0x0086;
                case 15: goto L_0x006f;
                case 16: goto L_0x003d;
                case 17: goto L_0x0026;
                case 18: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x026b
        L_0x000f:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x001d
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x001d:
            if (r3 == 0) goto L_0x0022
            r3.M0(r1)
        L_0x0022:
            r4.l0()
            return
        L_0x0026:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x0034
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x0034:
            if (r3 == 0) goto L_0x0039
            r3.G0()
        L_0x0039:
            r4.l0()
            return
        L_0x003d:
            t6.c0 r0 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r0 = r4.C
            boolean r2 = r0 instanceof x6.h
            if (r2 == 0) goto L_0x004b
            x6.h r0 = (x6.h) r0
            goto L_0x004c
        L_0x004b:
            r0 = r3
        L_0x004c:
            if (r0 == 0) goto L_0x006b
            com.github.andreyasadchy.xtra.ui.player.video.VideoPlayerViewModel r2 = r0.v0()
            android.content.Context r5 = r0.f0()
            com.github.andreyasadchy.xtra.model.ui.Video r0 = r0.F0
            if (r0 == 0) goto L_0x0065
            hb.d1 r6 = hb.d1.f7786h
            x6.n r7 = new x6.n
            r7.<init>(r2, r5, r0, r3)
            hb.h0.b1(r6, r3, r1, r7, r10)
            goto L_0x006b
        L_0x0065:
            java.lang.String r10 = "video"
            xa.j.l(r10)
            throw r3
        L_0x006b:
            r4.l0()
            return
        L_0x006f:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof x6.h
            if (r0 == 0) goto L_0x007d
            r3 = r10
            x6.h r3 = (x6.h) r3
        L_0x007d:
            if (r3 == 0) goto L_0x0082
            r3.P0()
        L_0x0082:
            r4.l0()
            return
        L_0x0086:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof w6.f
            if (r0 == 0) goto L_0x0094
            r3 = r10
            w6.f r3 = (w6.f) r3
        L_0x0094:
            if (r3 == 0) goto L_0x0099
            r3.U0(r1)
        L_0x0099:
            r4.l0()
            return
        L_0x009d:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof w6.f
            if (r0 == 0) goto L_0x00ab
            r3 = r10
            w6.f r3 = (w6.f) r3
        L_0x00ab:
            if (r3 == 0) goto L_0x00b0
            r3.U0(r2)
        L_0x00b0:
            r4.l0()
            return
        L_0x00b4:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof w6.f
            if (r0 == 0) goto L_0x00c2
            w6.f r10 = (w6.f) r10
            goto L_0x00c3
        L_0x00c2:
            r10 = r3
        L_0x00c3:
            if (r10 == 0) goto L_0x00db
            i6.e r10 = r10.P0()
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r10 = r10.q0()
            i6.h r10 = r10.f3368y
            boolean r0 = r10 instanceof i6.m
            if (r0 == 0) goto L_0x00d6
            r3 = r10
            i6.m r3 = (i6.m) r3
        L_0x00d6:
            if (r3 == 0) goto L_0x00db
            r3.h()
        L_0x00db:
            r4.l0()
            return
        L_0x00df:
            t6.c0 r0 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r0 = r4.C
            boolean r5 = r0 instanceof w6.f
            if (r5 == 0) goto L_0x00ed
            w6.f r0 = (w6.f) r0
            goto L_0x00ee
        L_0x00ed:
            r0 = r3
        L_0x00ee:
            if (r0 == 0) goto L_0x014c
            i6.e r0 = r0.P0()
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r5 = r0.q0()
            i6.h r5 = r5.f3368y
            boolean r6 = r5 instanceof i6.m
            if (r6 == 0) goto L_0x0101
            i6.m r5 = (i6.m) r5
            goto L_0x0102
        L_0x0101:
            r5 = r3
        L_0x0102:
            if (r5 == 0) goto L_0x0107
            r5.d()
        L_0x0107:
            android.os.Bundle r5 = r0.e0()
            java.lang.String r6 = "channelId"
            int r5 = r5.getInt(r6)
            android.content.Context r6 = r0.f0()
            android.content.SharedPreferences r6 = hb.h0.l1(r6)
            java.lang.String r7 = "chat_recent"
            boolean r2 = r6.getBoolean(r7, r2)
            android.content.Context r6 = r0.f0()
            android.content.SharedPreferences r6 = hb.h0.l1(r6)
            java.lang.String r7 = "chat_recent_limit"
            r8 = 100
            int r6 = r6.getInt(r7, r8)
            if (r5 == 0) goto L_0x014c
            if (r2 == 0) goto L_0x014c
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r0 = r0.q0()
            java.lang.String r2 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "recentMsgLimit"
            xa.j.f(r6, r2)
            hb.f0 r6 = hb.h0.I0(r0)
            i6.b0 r7 = new i6.b0
            r7.<init>(r0, r5, r2, r3)
            hb.h0.b1(r6, r3, r1, r7, r10)
        L_0x014c:
            r4.l0()
            return
        L_0x0150:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x015e
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x015e:
            if (r3 == 0) goto L_0x0163
            r3.F0()
        L_0x0163:
            r4.l0()
            return
        L_0x0167:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x0175
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x0175:
            if (r3 == 0) goto L_0x017a
            r3.w0()
        L_0x017a:
            r4.l0()
            return
        L_0x017e:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof w6.f
            if (r0 == 0) goto L_0x018c
            r3 = r10
            w6.f r3 = (w6.f) r3
        L_0x018c:
            if (r3 == 0) goto L_0x0191
            r3.T0()
        L_0x0191:
            r4.l0()
            return
        L_0x0195:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof w6.f
            if (r0 == 0) goto L_0x01a3
            r3 = r10
            w6.f r3 = (w6.f) r3
        L_0x01a3:
            if (r3 == 0) goto L_0x01a8
            r3.S0()
        L_0x01a8:
            r4.l0()
            return
        L_0x01ac:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            r4.l0()
            return
        L_0x01b5:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof w6.f
            if (r0 == 0) goto L_0x01c4
            r0 = r10
            w6.f r0 = (w6.f) r0
            goto L_0x01c5
        L_0x01c4:
            r0 = r3
        L_0x01c5:
            if (r0 == 0) goto L_0x01cf
            i6.e r10 = r0.P0()
            r10.s0()
            goto L_0x01f4
        L_0x01cf:
            boolean r0 = r10 instanceof x6.h
            if (r0 == 0) goto L_0x01d6
            x6.h r10 = (x6.h) r10
            goto L_0x01d7
        L_0x01d6:
            r10 = r3
        L_0x01d7:
            if (r10 == 0) goto L_0x01e7
            androidx.fragment.app.c1 r10 = r10.u()
            if (r10 == 0) goto L_0x01e7
            r0 = 2131361958(0x7f0a00a6, float:1.8343683E38)
            androidx.fragment.app.c0 r10 = r10.D(r0)
            goto L_0x01e8
        L_0x01e7:
            r10 = r3
        L_0x01e8:
            boolean r0 = r10 instanceof i6.e
            if (r0 == 0) goto L_0x01ef
            r3 = r10
            i6.e r3 = (i6.e) r3
        L_0x01ef:
            if (r3 == 0) goto L_0x01f4
            r3.s0()
        L_0x01f4:
            r4.l0()
            return
        L_0x01f8:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x0206
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x0206:
            if (r3 == 0) goto L_0x020b
            r3.K0()
        L_0x020b:
            r4.l0()
            return
        L_0x020f:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x021d
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x021d:
            if (r3 == 0) goto L_0x0222
            r3.D0()
        L_0x0222:
            r4.l0()
            return
        L_0x0226:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x0234
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x0234:
            if (r3 == 0) goto L_0x0239
            r3.H0()
        L_0x0239:
            r4.l0()
            return
        L_0x023d:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof m6.r
            if (r0 == 0) goto L_0x024b
            r3 = r10
            m6.r r3 = (m6.r) r3
        L_0x024b:
            if (r3 == 0) goto L_0x0250
            r3.b()
        L_0x0250:
            r4.l0()
            return
        L_0x0254:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x0262
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x0262:
            if (r3 == 0) goto L_0x0267
            r3.I0()
        L_0x0267:
            r4.l0()
            return
        L_0x026b:
            t6.c0 r10 = t6.d0.f14580w0
            xa.j.f(r5, r4)
            androidx.fragment.app.c0 r10 = r4.C
            boolean r0 = r10 instanceof t6.l
            if (r0 == 0) goto L_0x0279
            r3 = r10
            t6.l r3 = (t6.l) r3
        L_0x0279:
            if (r3 == 0) goto L_0x027e
            r3.M0(r2)
        L_0x027e:
            r4.l0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.b0.onClick(android.view.View):void");
    }
}
