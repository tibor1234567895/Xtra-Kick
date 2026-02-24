package x6;

import wa.l;
import xa.k;

public final class g extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16691h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h f16692i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(h hVar, int i10) {
        super(1);
        this.f16691h = i10;
        this.f16692i = hVar;
    }

    /* JADX WARNING: type inference failed for: r7v9, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: type inference failed for: r1v6, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r6.f16691h
            r2 = 1
            r3 = 0
            java.lang.String r4 = "closeOnPip"
            x6.h r5 = r6.f16692i
            switch(r1) {
                case 0: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0054
        L_0x000d:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r7 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r7
            androidx.fragment.app.c1 r1 = r5.u()
            androidx.fragment.app.c0 r1 = r1.E(r4)
            boolean r4 = r1 instanceof t6.d0
            if (r4 == 0) goto L_0x001e
            r3 = r1
            t6.d0 r3 = (t6.d0) r3
        L_0x001e:
            if (r3 == 0) goto L_0x0051
            if (r7 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            z5.l r7 = r3.f14581v0
            xa.j.c(r7)
            java.lang.String r1 = "menuBookmark"
            android.widget.TextView r7 = r7.f17696a
            xa.j.e(r1, r7)
            r7.setVisibility(r0)
            android.content.Context r0 = r3.f0()
            if (r2 == 0) goto L_0x003d
            r1 = 2131952264(0x7f130288, float:1.9540966E38)
            goto L_0x0040
        L_0x003d:
            r1 = 2131951644(0x7f13001c, float:1.9539708E38)
        L_0x0040:
            java.lang.String r0 = r0.getString(r1)
            r7.setText(r0)
            t6.b0 r0 = new t6.b0
            r1 = 16
            r0.<init>(r3, r1)
            r7.setOnClickListener(r0)
        L_0x0051:
            la.v r7 = la.v.f9814a
            return r7
        L_0x0054:
            java.util.List r7 = (java.util.List) r7
            java.lang.String r1 = "list"
            xa.j.e(r1, r7)
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x009f
            x6.d r7 = x6.h.H0
            android.content.SharedPreferences r7 = r5.t0()
            java.lang.String r1 = "player_gamesbutton"
            boolean r7 = r7.getBoolean(r1, r2)
            if (r7 == 0) goto L_0x008b
            android.view.View r7 = r5.h0()
            r1 = 2131362337(0x7f0a0221, float:1.8344452E38)
            android.view.View r7 = r7.findViewById(r1)
            android.widget.ImageButton r7 = (android.widget.ImageButton) r7
            if (r7 == 0) goto L_0x008b
            r7.setVisibility(r0)
            x6.b r0 = new x6.b
            r1 = 4
            r0.<init>(r5, r1)
            r7.setOnClickListener(r0)
        L_0x008b:
            androidx.fragment.app.c1 r7 = r5.u()
            androidx.fragment.app.c0 r7 = r7.E(r4)
            boolean r0 = r7 instanceof t6.d0
            if (r0 == 0) goto L_0x009a
            r3 = r7
            t6.d0 r3 = (t6.d0) r3
        L_0x009a:
            if (r3 == 0) goto L_0x009f
            r3.s0()
        L_0x009f:
            la.v r7 = la.v.f9814a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.g.invoke(java.lang.Object):java.lang.Object");
    }
}
