package h6;

import android.view.View;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7647h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f7648i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7649j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f7650k;

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, int i10) {
        this.f7647h = i10;
        this.f7648i = obj;
        this.f7649j = obj2;
        this.f7650k = obj3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v33, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v34, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v36, resolved type: com.github.andreyasadchy.xtra.model.offline.Bookmark} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r39) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            int r10 = r0.f7647h
            r11 = 2131361930(0x7f0a008a, float:1.8343626E38)
            java.lang.String r12 = "$tag"
            java.lang.String r13 = "null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.main.MainActivity"
            java.lang.String r14 = "ui_gamepager"
            r15 = 2131689472(0x7f0f0000, float:1.900796E38)
            java.lang.String r2 = "$context"
            r3 = 1
            java.lang.String r4 = "$account"
            java.lang.String r5 = "$activity"
            java.lang.String r9 = "this$0"
            java.lang.Object r8 = r0.f7650k
            java.lang.Object r6 = r0.f7649j
            java.lang.Object r7 = r0.f7648i
            switch(r10) {
                case 0: goto L_0x06a0;
                case 1: goto L_0x067e;
                case 2: goto L_0x065c;
                case 3: goto L_0x0605;
                case 4: goto L_0x05c0;
                case 5: goto L_0x057a;
                case 6: goto L_0x051d;
                case 7: goto L_0x04d7;
                case 8: goto L_0x0491;
                case 9: goto L_0x043a;
                case 10: goto L_0x03f0;
                case 11: goto L_0x03aa;
                case 12: goto L_0x0364;
                case 13: goto L_0x02f3;
                case 14: goto L_0x02cd;
                case 15: goto L_0x026c;
                case 16: goto L_0x020f;
                case 17: goto L_0x01d1;
                case 18: goto L_0x018b;
                case 19: goto L_0x0164;
                case 20: goto L_0x00d8;
                case 21: goto L_0x00b1;
                case 22: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x06ea
        L_0x0025:
            android.content.Context r7 = (android.content.Context) r7
            com.github.andreyasadchy.xtra.model.ui.Video r6 = (com.github.andreyasadchy.xtra.model.ui.Video) r6
            n7.c r8 = (n7.c) r8
            int r4 = n7.b.f11710k
            xa.j.f(r2, r7)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r2.f(r15)
            java.lang.String r1 = r6.getUuid()
            if (r1 == 0) goto L_0x004b
            boolean r1 = fb.w.h(r1)
            if (r1 == 0) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r17 = 0
            goto L_0x004d
        L_0x004b:
            r17 = 1
        L_0x004d:
            if (r17 != 0) goto L_0x00a4
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            android.view.MenuItem r1 = r1.findItem(r11)
            r1.setVisible(r3)
            java.util.List r1 = r8.f10680e
            if (r1 == 0) goto L_0x0083
            java.util.Iterator r1 = r1.iterator()
        L_0x0062:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x007f
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.github.andreyasadchy.xtra.model.offline.Bookmark r4 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r4
            java.lang.String r4 = r4.getVideoId()
            java.lang.String r5 = r6.getUuid()
            boolean r4 = xa.j.a(r4, r5)
            if (r4 == 0) goto L_0x0062
            r9 = r3
            goto L_0x0080
        L_0x007f:
            r9 = 0
        L_0x0080:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r9 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r9
            goto L_0x0084
        L_0x0083:
            r9 = 0
        L_0x0084:
            if (r9 == 0) goto L_0x0092
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            android.view.MenuItem r1 = r1.findItem(r11)
            r3 = 2131952264(0x7f130288, float:1.9540966E38)
            goto L_0x009d
        L_0x0092:
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            android.view.MenuItem r1 = r1.findItem(r11)
            r3 = 2131951644(0x7f13001c, float:1.9539708E38)
        L_0x009d:
            java.lang.String r3 = r7.getString(r3)
            r1.setTitle(r3)
        L_0x00a4:
            h3.f0 r1 = new h3.f0
            r3 = 18
            r1.<init>(r8, r6, r2, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x00b1:
            n7.b r7 = (n7.b) r7
            com.github.andreyasadchy.xtra.model.ui.Video r6 = (com.github.andreyasadchy.xtra.model.ui.Video) r6
            java.lang.Long r8 = (java.lang.Long) r8
            int r1 = n7.b.f11710k
            xa.j.f(r9, r7)
            androidx.fragment.app.c0 r1 = r7.f11712i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r13, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            if (r8 == 0) goto L_0x00d3
            long r2 = r8.longValue()
            double r2 = (double) r2
            java.lang.Double r9 = java.lang.Double.valueOf(r2)
            goto L_0x00d4
        L_0x00d3:
            r9 = 0
        L_0x00d4:
            r1.M(r6, r9)
            return
        L_0x00d8:
            android.content.Context r7 = (android.content.Context) r7
            com.github.andreyasadchy.xtra.model.ui.Video r6 = (com.github.andreyasadchy.xtra.model.ui.Video) r6
            m7.h r8 = (m7.h) r8
            int r4 = m7.g.f10692l
            xa.j.f(r2, r7)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r2.f(r15)
            java.lang.String r1 = r6.getUuid()
            if (r1 == 0) goto L_0x00fe
            boolean r1 = fb.w.h(r1)
            if (r1 == 0) goto L_0x00fb
            goto L_0x00fe
        L_0x00fb:
            r17 = 0
            goto L_0x0100
        L_0x00fe:
            r17 = 1
        L_0x0100:
            if (r17 != 0) goto L_0x0157
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            android.view.MenuItem r1 = r1.findItem(r11)
            r1.setVisible(r3)
            java.util.List r1 = r8.f10680e
            if (r1 == 0) goto L_0x0136
            java.util.Iterator r1 = r1.iterator()
        L_0x0115:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0132
            java.lang.Object r3 = r1.next()
            r4 = r3
            com.github.andreyasadchy.xtra.model.offline.Bookmark r4 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r4
            java.lang.String r4 = r4.getVideoId()
            java.lang.String r5 = r6.getUuid()
            boolean r4 = xa.j.a(r4, r5)
            if (r4 == 0) goto L_0x0115
            r9 = r3
            goto L_0x0133
        L_0x0132:
            r9 = 0
        L_0x0133:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r9 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r9
            goto L_0x0137
        L_0x0136:
            r9 = 0
        L_0x0137:
            if (r9 == 0) goto L_0x0145
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            android.view.MenuItem r1 = r1.findItem(r11)
            r3 = 2131952264(0x7f130288, float:1.9540966E38)
            goto L_0x0150
        L_0x0145:
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            android.view.MenuItem r1 = r1.findItem(r11)
            r3 = 2131951644(0x7f13001c, float:1.9539708E38)
        L_0x0150:
            java.lang.String r3 = r7.getString(r3)
            r1.setTitle(r3)
        L_0x0157:
            h3.f0 r1 = new h3.f0
            r3 = 17
            r1.<init>(r8, r6, r2, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x0164:
            m7.g r7 = (m7.g) r7
            com.github.andreyasadchy.xtra.model.ui.Video r6 = (com.github.andreyasadchy.xtra.model.ui.Video) r6
            java.lang.Long r8 = (java.lang.Long) r8
            int r1 = m7.g.f10692l
            xa.j.f(r9, r7)
            androidx.fragment.app.c0 r1 = r7.f10694i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r13, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            if (r8 == 0) goto L_0x0186
            long r2 = r8.longValue()
            double r2 = (double) r2
            java.lang.Double r9 = java.lang.Double.valueOf(r2)
            goto L_0x0187
        L_0x0186:
            r9 = 0
        L_0x0187:
            r1.M(r6, r9)
            return
        L_0x018b:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account r6 = (com.github.andreyasadchy.xtra.model.Account) r6
            com.github.andreyasadchy.xtra.ui.top.TopFragment r8 = (com.github.andreyasadchy.xtra.ui.top.TopFragment) r8
            int r2 = com.github.andreyasadchy.xtra.ui.top.TopFragment.f3513h0
            xa.j.f(r5, r7)
            xa.j.f(r4, r6)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r6 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x01ba
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x01bd
        L_0x01ba:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x01bd:
            java.lang.String r3 = r8.z(r4)
            r1.setTitle(r3)
            h3.f0 r1 = new h3.f0
            r3 = 16
            r1.<init>(r7, r8, r6, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x01d1:
            i7.e r7 = (i7.e) r7
            com.github.andreyasadchy.xtra.model.ui.Stream r6 = (com.github.andreyasadchy.xtra.model.ui.Stream) r6
            java.lang.String r8 = (java.lang.String) r8
            int r1 = i7.e.f8367l
            xa.j.f(r9, r7)
            xa.j.f(r12, r8)
            androidx.fragment.app.c0 r1 = r7.f8369i
            j3.k0 r1 = hb.h0.V(r1)
            q6.g r9 = q6.h.f13361a
            q6.f r2 = r7.f8370j
            if (r2 == 0) goto L_0x01ef
            int r4 = r2.f13353a
            r10 = r4
            goto L_0x01f0
        L_0x01ef:
            r10 = 0
        L_0x01f0:
            if (r2 == 0) goto L_0x01f6
            java.lang.String r2 = r2.f13354b
            r11 = r2
            goto L_0x01f7
        L_0x01f6:
            r11 = 0
        L_0x01f7:
            java.lang.String r12 = r6.getGameName()
            java.lang.String r13 = r6.getBoxArtUrl()
            java.lang.String[] r14 = new java.lang.String[r3]
            r2 = 0
            r14[r2] = r8
            r15 = 0
            r16 = 224(0xe0, float:3.14E-43)
            y5.q r2 = q6.g.a(r9, r10, r11, r12, r13, r14, r15, r16)
            r1.m(r2)
            return
        L_0x020f:
            i7.b r7 = (i7.b) r7
            com.github.andreyasadchy.xtra.model.ui.Stream r6 = (com.github.andreyasadchy.xtra.model.ui.Stream) r6
            java.lang.String r8 = (java.lang.String) r8
            int r1 = i7.b.f8358l
            xa.j.f(r9, r7)
            xa.j.f(r12, r8)
            q6.f r1 = r7.f8361j
            if (r1 == 0) goto L_0x0228
            int r2 = r1.f13353a
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            goto L_0x0229
        L_0x0228:
            r9 = 0
        L_0x0229:
            androidx.fragment.app.c0 r2 = r7.f8360i
            if (r9 == 0) goto L_0x0250
            java.lang.String r4 = r1.f13354b
            if (r4 == 0) goto L_0x0250
            j3.k0 r2 = hb.h0.V(r2)
            q6.g r9 = q6.h.f13361a
            int r10 = r1.f13353a
            java.lang.String r11 = r1.f13354b
            java.lang.String r12 = r6.getGameName()
            java.lang.String r13 = r6.getBoxArtUrl()
            java.lang.String[] r14 = new java.lang.String[r3]
            r1 = 0
            r14[r1] = r8
            r15 = 0
            r16 = 224(0xe0, float:3.14E-43)
            y5.q r1 = q6.g.a(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0268
        L_0x0250:
            j3.k0 r2 = hb.h0.V(r2)
            l7.a r1 = l7.b.f9685a
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r8
            r1.getClass()
            y5.t r1 = y5.u.f17067a
            r1.getClass()
            y5.s r1 = new y5.s
            r1.<init>(r3)
        L_0x0268:
            r2.m(r1)
            return
        L_0x026c:
            f7.d r7 = (f7.d) r7
            android.content.Context r6 = (android.content.Context) r6
            com.github.andreyasadchy.xtra.model.ui.Tag r8 = (com.github.andreyasadchy.xtra.model.ui.Tag) r8
            int r1 = f7.d.f5914k
            xa.j.f(r9, r7)
            xa.j.f(r2, r6)
            androidx.fragment.app.c0 r1 = r7.f5916i
            j3.k0 r1 = hb.h0.V(r1)
            android.content.SharedPreferences r2 = hb.h0.l1(r6)
            boolean r2 = r2.getBoolean(r14, r3)
            f7.k r4 = r7.f5917j
            if (r2 == 0) goto L_0x02a7
            q6.g r9 = q6.h.f13361a
            int r10 = r4.f5933a
            java.lang.String r11 = r4.f5934b
            java.lang.String r12 = r4.f5935c
            java.lang.String r13 = r4.f5936d
            java.lang.String[] r14 = new java.lang.String[r3]
            java.lang.String r2 = r8.getName()
            r3 = 0
            r14[r3] = r2
            r15 = 0
            r16 = 224(0xe0, float:3.14E-43)
            y5.q r2 = q6.g.a(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x02c9
        L_0x02a7:
            q6.a r2 = q6.b.f13350a
            int r5 = r4.f5933a
            java.lang.String r6 = r4.f5934b
            java.lang.String r7 = r4.f5935c
            java.lang.String r9 = r4.f5936d
            java.lang.String[] r10 = new java.lang.String[r3]
            java.lang.String r3 = r8.getName()
            r4 = 0
            r10[r4] = r3
            r11 = 0
            r12 = 224(0xe0, float:3.14E-43)
            r3 = r2
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r9
            r8 = r10
            r9 = r11
            r10 = r12
            y5.p r2 = q6.a.a(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x02c9:
            r1.m(r2)
            return
        L_0x02cd:
            android.content.Context r7 = (android.content.Context) r7
            a7.d r6 = (a7.d) r6
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r8 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r8
            int r3 = a7.c.f271k
            xa.j.f(r2, r7)
            xa.j.f(r9, r6)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689473(0x7f0f0001, float:1.9007962E38)
            r2.f(r1)
            h3.f0 r1 = new h3.f0
            r3 = 14
            r1.<init>(r6, r8, r2, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x02f3:
            z6.c r7 = (z6.c) r7
            com.github.andreyasadchy.xtra.model.offline.Bookmark r6 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r6
            java.lang.Long r8 = (java.lang.Long) r8
            int r1 = z6.c.f17738k
            xa.j.f(r9, r7)
            androidx.fragment.app.c0 r1 = r7.f17740i
            androidx.fragment.app.f0 r1 = r1.t()
            xa.j.d(r13, r1)
            com.github.andreyasadchy.xtra.ui.main.MainActivity r1 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r1
            java.lang.String r18 = r6.getVideoId()
            int r19 = r6.getUserId()
            java.lang.String r20 = r6.getUserLogin()
            java.lang.String r21 = r6.getUserName()
            java.lang.String r33 = r6.getUserLogo()
            int r29 = r6.getGameId()
            java.lang.String r30 = r6.getGameName()
            java.lang.String r22 = r6.getTitle()
            java.lang.String r23 = r6.getCreatedAt()
            java.lang.String r24 = r6.getThumbnail()
            java.lang.String r26 = r6.getType()
            java.lang.String r27 = r6.getDuration()
            java.lang.String r35 = r6.getAnimatedPreviewURL()
            com.github.andreyasadchy.xtra.model.ui.Video r2 = new com.github.andreyasadchy.xtra.model.ui.Video
            r17 = r2
            r25 = 0
            r28 = 0
            r31 = 0
            r34 = r31
            r32 = r31
            r36 = 91264(0x16480, float:1.27888E-40)
            r37 = 0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            if (r8 == 0) goto L_0x035f
            long r3 = r8.longValue()
            double r3 = (double) r3
            java.lang.Double r9 = java.lang.Double.valueOf(r3)
            goto L_0x0360
        L_0x035f:
            r9 = 0
        L_0x0360:
            r1.M(r2, r9)
            return
        L_0x0364:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account r6 = (com.github.andreyasadchy.xtra.model.Account) r6
            com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment) r8
            int r2 = com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment.f3454k0
            xa.j.f(r5, r7)
            xa.j.f(r4, r6)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r6 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x0393
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x0396
        L_0x0393:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x0396:
            java.lang.String r3 = r8.z(r4)
            r1.setTitle(r3)
            h3.f0 r1 = new h3.f0
            r3 = 12
            r1.<init>(r7, r8, r6, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x03aa:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account r6 = (com.github.andreyasadchy.xtra.model.Account) r6
            com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment r8 = (com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment) r8
            int r2 = com.github.andreyasadchy.xtra.ui.saved.SavedMediaFragment.f3452h0
            xa.j.f(r5, r7)
            xa.j.f(r4, r6)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r6 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x03d9
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x03dc
        L_0x03d9:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x03dc:
            java.lang.String r3 = r8.z(r4)
            r1.setTitle(r3)
            h3.f0 r1 = new h3.f0
            r3 = 11
            r1.<init>(r7, r8, r6, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x03f0:
            r10 = r7
            com.github.andreyasadchy.xtra.ui.main.MainActivity r10 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r10
            r12 = r6
            com.github.andreyasadchy.xtra.model.Account r12 = (com.github.andreyasadchy.xtra.model.Account) r12
            r11 = r8
            com.github.andreyasadchy.xtra.ui.games.GamesFragment r11 = (com.github.andreyasadchy.xtra.ui.games.GamesFragment) r11
            int r2 = com.github.andreyasadchy.xtra.ui.games.GamesFragment.f3425t0
            xa.j.f(r5, r10)
            xa.j.f(r4, r12)
            xa.j.f(r9, r11)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r10, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r12 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x0422
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x0425
        L_0x0422:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x0425:
            java.lang.String r3 = r11.z(r4)
            r1.setTitle(r3)
            androidx.fragment.app.h r1 = new androidx.fragment.app.h
            r14 = 3
            r9 = r1
            r13 = r2
            r9.<init>(r10, r11, r12, r13, r14)
            r2.f898e = r1
            r2.h()
            return
        L_0x043a:
            q6.q r7 = (q6.q) r7
            android.content.Context r6 = (android.content.Context) r6
            com.github.andreyasadchy.xtra.model.ui.Game r8 = (com.github.andreyasadchy.xtra.model.ui.Game) r8
            int r1 = q6.q.f13385j
            xa.j.f(r9, r7)
            xa.j.f(r2, r6)
            androidx.fragment.app.c0 r1 = r7.f13387i
            j3.k0 r1 = hb.h0.V(r1)
            android.content.SharedPreferences r2 = hb.h0.l1(r6)
            boolean r2 = r2.getBoolean(r14, r3)
            if (r2 == 0) goto L_0x0473
            q6.g r9 = q6.h.f13361a
            int r10 = r8.getGameId()
            java.lang.String r11 = r8.getGameSlug()
            java.lang.String r12 = r8.getGameName()
            java.lang.String r13 = r8.getBoxArtUrl()
            r14 = 0
            r15 = 0
            r16 = 240(0xf0, float:3.36E-43)
            y5.q r2 = q6.g.a(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x048d
        L_0x0473:
            q6.a r3 = q6.b.f13350a
            int r4 = r8.getGameId()
            java.lang.String r5 = r8.getGameSlug()
            java.lang.String r6 = r8.getGameName()
            java.lang.String r7 = r8.getBoxArtUrl()
            r8 = 0
            r9 = 0
            r10 = 240(0xf0, float:3.36E-43)
            y5.p r2 = q6.a.a(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x048d:
            r1.m(r2)
            return
        L_0x0491:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account r6 = (com.github.andreyasadchy.xtra.model.Account) r6
            com.github.andreyasadchy.xtra.ui.games.GamePagerFragment r8 = (com.github.andreyasadchy.xtra.ui.games.GamePagerFragment) r8
            int r2 = com.github.andreyasadchy.xtra.ui.games.GamePagerFragment.f3417s0
            xa.j.f(r5, r7)
            xa.j.f(r4, r6)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r6 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x04c0
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x04c3
        L_0x04c0:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x04c3:
            java.lang.String r3 = r8.z(r4)
            r1.setTitle(r3)
            h3.f0 r1 = new h3.f0
            r3 = 10
            r1.<init>(r7, r8, r6, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x04d7:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account r6 = (com.github.andreyasadchy.xtra.model.Account) r6
            com.github.andreyasadchy.xtra.ui.games.GameMediaFragment r8 = (com.github.andreyasadchy.xtra.ui.games.GameMediaFragment) r8
            int r2 = com.github.andreyasadchy.xtra.ui.games.GameMediaFragment.f3411t0
            xa.j.f(r5, r7)
            xa.j.f(r4, r6)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r6 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x0506
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x0509
        L_0x0506:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x0509:
            java.lang.String r3 = r8.z(r4)
            r1.setTitle(r3)
            h3.f0 r1 = new h3.f0
            r3 = 9
            r1.<init>(r7, r8, r6, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x051d:
            p6.b r7 = (p6.b) r7
            android.content.Context r6 = (android.content.Context) r6
            com.github.andreyasadchy.xtra.model.ui.Game r8 = (com.github.andreyasadchy.xtra.model.ui.Game) r8
            int r1 = p6.b.f12575j
            xa.j.f(r9, r7)
            xa.j.f(r2, r6)
            androidx.fragment.app.c0 r1 = r7.f12577i
            j3.k0 r1 = hb.h0.V(r1)
            android.content.SharedPreferences r2 = hb.h0.l1(r6)
            boolean r2 = r2.getBoolean(r14, r3)
            if (r2 == 0) goto L_0x0559
            q6.g r9 = q6.h.f13361a
            int r10 = r8.getGameId()
            java.lang.String r11 = r8.getGameSlug()
            boolean r15 = r8.getFollowLocal()
            java.lang.String r12 = r8.getGameName()
            java.lang.String r13 = r8.getBoxArtUrl()
            r14 = 0
            r16 = 208(0xd0, float:2.91E-43)
            y5.q r2 = q6.g.a(r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0576
        L_0x0559:
            q6.a r3 = q6.b.f13350a
            int r4 = r8.getGameId()
            java.lang.String r5 = r8.getGameSlug()
            boolean r9 = r8.getFollowLocal()
            java.lang.String r6 = r8.getGameName()
            java.lang.String r7 = r8.getBoxArtUrl()
            r8 = 0
            r10 = 208(0xd0, float:2.91E-43)
            y5.p r2 = q6.a.a(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x0576:
            r1.m(r2)
            return
        L_0x057a:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account r6 = (com.github.andreyasadchy.xtra.model.Account) r6
            com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment) r8
            int r2 = com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment.f3399k0
            xa.j.f(r5, r7)
            xa.j.f(r4, r6)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r6 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x05a9
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x05ac
        L_0x05a9:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x05ac:
            java.lang.String r3 = r8.z(r4)
            r1.setTitle(r3)
            h3.f0 r1 = new h3.f0
            r3 = 8
            r1.<init>(r7, r8, r6, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x05c0:
            com.github.andreyasadchy.xtra.ui.main.MainActivity r7 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r7
            com.github.andreyasadchy.xtra.model.Account r6 = (com.github.andreyasadchy.xtra.model.Account) r6
            com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment r8 = (com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment) r8
            int r2 = com.github.andreyasadchy.xtra.ui.follow.FollowMediaFragment.f3397h0
            xa.j.f(r5, r7)
            xa.j.f(r4, r6)
            xa.j.f(r9, r8)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r6 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x05ef
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x05f2
        L_0x05ef:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x05f2:
            java.lang.String r3 = r8.z(r4)
            r1.setTitle(r3)
            h3.f0 r1 = new h3.f0
            r3 = 7
            r1.<init>(r7, r8, r6, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x0605:
            androidx.appcompat.widget.i5 r7 = (androidx.appcompat.widget.i5) r7
            m6.d r6 = (m6.d) r6
            java.util.Map r8 = (java.util.Map) r8
            m6.c r1 = m6.d.D0
            java.lang.String r1 = "$this_with"
            xa.j.f(r1, r7)
            xa.j.f(r9, r6)
            java.lang.String r1 = "$qualities"
            xa.j.f(r1, r8)
            java.lang.Object r1 = r7.f879g
            android.widget.Spinner r1 = (android.widget.Spinner) r1
            java.lang.Object r1 = r1.getSelectedItem()
            java.lang.String r12 = r1.toString()
            androidx.lifecycle.x1 r1 = r6.C0
            java.lang.Object r1 = r1.getValue()
            r10 = r1
            com.github.andreyasadchy.xtra.ui.download.ClipDownloadViewModel r10 = (com.github.andreyasadchy.xtra.ui.download.ClipDownloadViewModel) r10
            java.lang.Object r1 = ma.j0.e(r8, r12)
            r13 = r1
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r11 = r6.r0()
            java.lang.String r1 = "url"
            xa.j.f(r1, r13)
            java.lang.String r1 = "path"
            xa.j.f(r1, r11)
            java.lang.String r1 = "quality"
            xa.j.f(r1, r12)
            hb.d1 r1 = hb.d1.f7786h
            m6.f r2 = new m6.f
            r14 = 0
            r9 = r2
            r9.<init>(r10, r11, r12, r13, r14)
            r3 = 3
            r4 = 0
            r5 = 0
            hb.h0.b1(r1, r5, r4, r2, r3)
            r6.m0(r4, r4)
            return
        L_0x065c:
            android.content.Context r7 = (android.content.Context) r7
            k6.c r6 = (k6.c) r6
            com.github.andreyasadchy.xtra.model.ui.Clip r8 = (com.github.andreyasadchy.xtra.model.ui.Clip) r8
            int r3 = k6.b.f9199k
            xa.j.f(r2, r7)
            xa.j.f(r9, r6)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r2.f(r15)
            h3.f0 r1 = new h3.f0
            r3 = 6
            r1.<init>(r6, r8, r2, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x067e:
            android.content.Context r7 = (android.content.Context) r7
            j6.f r6 = (j6.f) r6
            com.github.andreyasadchy.xtra.model.ui.Clip r8 = (com.github.andreyasadchy.xtra.model.ui.Clip) r8
            int r3 = j6.e.f8815l
            xa.j.f(r2, r7)
            xa.j.f(r9, r6)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r7, (android.view.View) r1)
            r2.f(r15)
            h3.f0 r1 = new h3.f0
            r3 = 5
            r1.<init>(r6, r8, r2, r3)
            r2.f898e = r1
            r2.h()
            return
        L_0x06a0:
            r10 = r7
            com.github.andreyasadchy.xtra.ui.main.MainActivity r10 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r10
            r12 = r6
            com.github.andreyasadchy.xtra.model.Account r12 = (com.github.andreyasadchy.xtra.model.Account) r12
            r11 = r8
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment r11 = (com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment) r11
            int r2 = com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment.f3334r0
            xa.j.f(r5, r10)
            xa.j.f(r4, r12)
            xa.j.f(r9, r11)
            androidx.appcompat.widget.j3 r2 = new androidx.appcompat.widget.j3
            r2.<init>((android.content.Context) r10, (android.view.View) r1)
            r1 = 2131689474(0x7f0f0002, float:1.9007964E38)
            r2.f(r1)
            java.lang.Object r1 = r2.f895b
            m.o r1 = (m.o) r1
            r3 = 2131362187(0x7f0a018b, float:1.8344147E38)
            android.view.MenuItem r1 = r1.findItem(r3)
            boolean r3 = r12 instanceof com.github.andreyasadchy.xtra.model.NotLoggedIn
            if (r3 != 0) goto L_0x06d2
            r4 = 2131952071(0x7f1301c7, float:1.9540574E38)
            goto L_0x06d5
        L_0x06d2:
            r4 = 2131952070(0x7f1301c6, float:1.9540572E38)
        L_0x06d5:
            java.lang.String r3 = r11.z(r4)
            r1.setTitle(r3)
            androidx.fragment.app.h r1 = new androidx.fragment.app.h
            r14 = 2
            r9 = r1
            r13 = r2
            r9.<init>(r10, r11, r12, r13, r14)
            r2.f898e = r1
            r2.h()
            return
        L_0x06ea:
            android.content.ClipboardManager r7 = (android.content.ClipboardManager) r7
            java.lang.String r6 = (java.lang.String) r6
            r7.z r8 = (r7.z) r8
            r7.w r1 = r7.z.D0
            xa.j.f(r9, r8)
            if (r7 == 0) goto L_0x0700
            java.lang.String r1 = "label"
            android.content.ClipData r1 = android.content.ClipData.newPlainText(r1, r6)
            r7.setPrimaryClip(r1)
        L_0x0700:
            r8.l0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.d.onClick(android.view.View):void");
    }
}
