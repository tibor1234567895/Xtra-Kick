package x6;

import h9.e0;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16685h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e0 f16686i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h f16687j;

    public /* synthetic */ c(e0 e0Var, h hVar, int i10) {
        this.f16685h = i10;
        this.f16686i = e0Var;
        this.f16687j = hVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r22 = this;
            r0 = r22
            r1 = 0
            int r2 = r0.f16685h
            java.lang.String r3 = "result"
            x6.h r4 = r0.f16687j
            java.lang.String r5 = "this$0"
            h9.e0 r6 = r0.f16686i
            java.lang.String r7 = "$result"
            r8 = 0
            switch(r2) {
                case 0: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0095
        L_0x0015:
            x6.d r2 = x6.h.H0
            xa.j.f(r7, r6)
            xa.j.f(r5, r4)
            java.lang.Object r2 = r6.get()
            h3.j4 r2 = (h3.j4) r2
            int r2 = r2.f7143h
            if (r2 != 0) goto L_0x0094
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 33
            if (r2 < r5) goto L_0x003a
            java.lang.Object r2 = r6.get()
            h3.j4 r2 = (h3.j4) r2
            android.os.Bundle r2 = r2.f7144i
            java.lang.Object r2 = r2.getParcelable("result", com.github.andreyasadchy.xtra.model.VideoDownloadInfo.class)
            goto L_0x004a
        L_0x003a:
            java.lang.Object r2 = r6.get()
            h3.j4 r2 = (h3.j4) r2
            android.os.Bundle r2 = r2.f7144i
            android.os.Parcelable r2 = r2.getParcelable(r3)
            boolean r3 = r2 instanceof com.github.andreyasadchy.xtra.model.VideoDownloadInfo
            if (r3 == 0) goto L_0x004e
        L_0x004a:
            com.github.andreyasadchy.xtra.model.VideoDownloadInfo r2 = (com.github.andreyasadchy.xtra.model.VideoDownloadInfo) r2
            r9 = r2
            goto L_0x004f
        L_0x004e:
            r9 = r8
        L_0x004f:
            if (r9 == 0) goto L_0x0094
            m6.w r2 = m6.z.D0
            com.github.andreyasadchy.xtra.model.ui.Video r10 = r4.F0
            if (r10 == 0) goto L_0x008e
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r20 = 126(0x7e, float:1.77E-43)
            r21 = 0
            com.github.andreyasadchy.xtra.model.VideoDownloadInfo r3 = com.github.andreyasadchy.xtra.model.VideoDownloadInfo.copy$default(r9, r10, r11, r12, r13, r14, r16, r18, r20, r21)
            r2.getClass()
            java.lang.String r2 = "videoInfo"
            xa.j.f(r2, r3)
            m6.z r5 = new m6.z
            r5.<init>()
            r6 = 1
            la.i[] r6 = new la.i[r6]
            la.i r7 = new la.i
            r7.<init>(r2, r3)
            r6[r1] = r7
            android.os.Bundle r1 = hb.h0.r(r6)
            r5.j0(r1)
            androidx.fragment.app.c1 r1 = r4.u()
            r5.q0(r1, r8)
            goto L_0x0094
        L_0x008e:
            java.lang.String r1 = "video"
            xa.j.l(r1)
            throw r8
        L_0x0094:
            return
        L_0x0095:
            x6.d r2 = x6.h.H0
            xa.j.f(r7, r6)
            xa.j.f(r5, r4)
            java.lang.Object r2 = r6.get()
            h3.j4 r2 = (h3.j4) r2
            int r2 = r2.f7143h
            if (r2 != 0) goto L_0x00e7
            java.lang.Object r2 = r6.get()
            h3.j4 r2 = (h3.j4) r2
            android.os.Bundle r2 = r2.f7144i
            int r2 = r2.getInt(r3)
            android.content.Context r3 = r4.f0()
            boolean r3 = hb.h0.X0(r3)
            if (r3 == 0) goto L_0x00e7
            r3 = 403(0x193, float:5.65E-43)
            if (r2 != r3) goto L_0x00cc
            android.content.Context r1 = r4.f0()
            r2 = 2131952432(0x7f130330, float:1.9541307E38)
            hb.h0.X1(r1, r2)
            goto L_0x00e7
        L_0x00cc:
            android.content.Context r2 = r4.f0()
            r3 = 2131952229(0x7f130265, float:1.9540895E38)
            hb.h0.C1(r2, r3)
            androidx.fragment.app.y1 r2 = r4.C()
            androidx.lifecycle.LifecycleCoroutineScopeImpl r2 = hb.h0.v0(r2)
            x6.f r3 = new x6.f
            r3.<init>(r4, r8)
            r4 = 3
            hb.h0.b1(r2, r8, r1, r3, r4)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.c.run():void");
    }
}
