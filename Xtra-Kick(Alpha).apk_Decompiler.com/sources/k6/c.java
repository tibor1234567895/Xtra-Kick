package k6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.i5;
import androidx.fragment.app.c0;
import androidx.fragment.app.k;
import androidx.recyclerview.widget.k2;
import f7.b;
import f7.d;
import n3.x3;
import xa.j;

public final class c extends x3 {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f9203d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f9204e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f9205f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, k kVar) {
        super(new a());
        j.f("fragment", c0Var);
        this.f9204e = c0Var;
        this.f9205f = kVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            r2 = 0
            int r3 = r0.f9203d
            r4 = 1
            java.lang.String r5 = "holder"
            switch(r3) {
                case 0: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0148
        L_0x000f:
            r3 = r20
            k6.b r3 = (k6.b) r3
            xa.j.f(r5, r3)
            java.lang.Object r1 = r0.a(r1)
            com.github.andreyasadchy.xtra.model.ui.Clip r1 = (com.github.andreyasadchy.xtra.model.ui.Clip) r1
            if (r1 == 0) goto L_0x0147
            androidx.fragment.app.c0 r5 = r3.f9201i
            android.content.Context r5 = r5.f0()
            j3.m2 r6 = new j3.m2
            r7 = 7
            r6.<init>(r3, r5, r1, r7)
            z5.c r7 = r3.f9200h
            android.widget.FrameLayout r8 = r7.f17599e
            androidx.cardview.widget.CardView r8 = (androidx.cardview.widget.CardView) r8
            h6.b r9 = new h6.b
            r10 = 2
            r9.<init>(r3, r10, r1)
            r8.setOnClickListener(r9)
            android.widget.FrameLayout r8 = r7.f17599e
            androidx.cardview.widget.CardView r8 = (androidx.cardview.widget.CardView) r8
            j6.c r9 = new j6.c
            k6.c r11 = r3.f9202j
            r9.<init>(r11, r1, r4)
            r8.setOnLongClickListener(r9)
            android.view.View r4 = r7.f17604j
            r12 = r4
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            java.lang.String r4 = "thumbnail"
            xa.j.e(r4, r12)
            androidx.fragment.app.c0 r13 = r3.f9201i
            java.lang.String r14 = r1.getThumbnail()
            r15 = 0
            r16 = 0
            d5.q r3 = d5.u.f4491a
            java.lang.String r4 = "NONE"
            xa.j.e(r4, r3)
            r18 = 12
            r17 = r3
            hb.h0.c1(r12, r13, r14, r15, r16, r17, r18)
            java.lang.String r3 = r1.getUploadDate()
            java.lang.String r4 = "date"
            android.widget.TextView r8 = r7.f17600f
            if (r3 == 0) goto L_0x008d
            java.lang.String r3 = r1.getUploadDate()
            s7.h r9 = s7.h.f14375a
            r9.getClass()
            java.lang.String r3 = s7.h.d(r5, r3)
            if (r3 == 0) goto L_0x008d
            com.github.andreyasadchy.xtra.util.TextWithCanvas r8 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r8
            xa.j.e(r4, r8)
            r8.setVisibility(r2)
            r8.setText(r3)
            goto L_0x0095
        L_0x008d:
            com.github.andreyasadchy.xtra.util.TextWithCanvas r8 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r8
            xa.j.e(r4, r8)
            hb.h0.J0(r8)
        L_0x0095:
            java.lang.Integer r3 = r1.getViewCount()
            android.widget.TextView r4 = r7.f17608n
            com.github.andreyasadchy.xtra.util.TextWithCanvas r4 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r4
            java.lang.String r8 = "views"
            xa.j.e(r8, r4)
            if (r3 == 0) goto L_0x00bc
            r4.setVisibility(r2)
            s7.h r3 = s7.h.f14375a
            java.lang.Integer r8 = r1.getViewCount()
            int r8 = r8.intValue()
            r3.getClass()
            java.lang.String r3 = s7.h.f(r5, r8)
            r4.setText(r3)
            goto L_0x00bf
        L_0x00bc:
            hb.h0.J0(r4)
        L_0x00bf:
            java.lang.Double r3 = r1.getDuration()
            android.widget.TextView r4 = r7.f17601g
            com.github.andreyasadchy.xtra.util.TextWithCanvas r4 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r4
            java.lang.String r8 = "duration"
            xa.j.e(r8, r4)
            if (r3 == 0) goto L_0x00e2
            r4.setVisibility(r2)
            java.lang.Double r3 = r1.getDuration()
            double r8 = r3.doubleValue()
            long r8 = (long) r8
            java.lang.String r3 = android.text.format.DateUtils.formatElapsedTime(r8)
            r4.setText(r3)
            goto L_0x00e5
        L_0x00e2:
            hb.h0.J0(r4)
        L_0x00e5:
            java.lang.String r3 = r1.getTitle()
            java.lang.String r4 = "title"
            android.widget.TextView r8 = r7.f17597c
            if (r3 == 0) goto L_0x0111
            java.lang.String r3 = r1.getTitle()
            java.lang.String r9 = ""
            boolean r3 = xa.j.a(r3, r9)
            if (r3 != 0) goto L_0x0111
            xa.j.e(r4, r8)
            r8.setVisibility(r2)
            java.lang.String r3 = r1.getTitle()
            java.lang.CharSequence r3 = fb.y.R(r3)
            java.lang.String r3 = r3.toString()
            r8.setText(r3)
            goto L_0x0117
        L_0x0111:
            xa.j.e(r4, r8)
            hb.h0.J0(r8)
        L_0x0117:
            java.lang.String r3 = r1.getGameName()
            java.lang.String r4 = "gameName"
            android.widget.TextView r8 = r7.f17595a
            xa.j.e(r4, r8)
            if (r3 == 0) goto L_0x0138
            r8.setVisibility(r2)
            java.lang.String r2 = r1.getGameName()
            r8.setText(r2)
            j6.d r2 = new j6.d
            r3 = 3
            r2.<init>(r3, r6)
            r8.setOnClickListener(r2)
            goto L_0x013b
        L_0x0138:
            hb.h0.J0(r8)
        L_0x013b:
            android.view.View r2 = r7.f17602h
            android.widget.ImageButton r2 = (android.widget.ImageButton) r2
            h6.d r3 = new h6.d
            r3.<init>(r5, r11, r1, r10)
            r2.setOnClickListener(r3)
        L_0x0147:
            return
        L_0x0148:
            r3 = r20
            f7.d r3 = (f7.d) r3
            xa.j.f(r5, r3)
            java.lang.Object r1 = r0.a(r1)
            com.github.andreyasadchy.xtra.model.ui.Tag r1 = (com.github.andreyasadchy.xtra.model.ui.Tag) r1
            if (r1 == 0) goto L_0x01cf
            androidx.fragment.app.c0 r5 = r3.f5916i
            android.content.Context r5 = r5.f0()
            java.lang.String r6 = r1.getName()
            java.lang.String r7 = "userName"
            androidx.appcompat.widget.i5 r8 = r3.f5915h
            if (r6 == 0) goto L_0x017d
            java.lang.Object r6 = r8.f880h
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r7, r6)
            r6.setVisibility(r2)
            java.lang.Object r6 = r8.f880h
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r7 = r1.getName()
            r6.setText(r7)
            goto L_0x0187
        L_0x017d:
            java.lang.Object r6 = r8.f880h
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r7, r6)
            hb.h0.J0(r6)
        L_0x0187:
            java.lang.String r6 = r1.getScope()
            java.lang.String r7 = "CATEGORY"
            boolean r6 = xa.j.a(r6, r7)
            if (r6 == 0) goto L_0x01a3
            java.lang.String r4 = r1.getId()
            if (r4 == 0) goto L_0x01cf
            androidx.cardview.widget.CardView r4 = r8.a()
            f7.c r5 = new f7.c
            r5.<init>(r3, r1, r2)
            goto L_0x01cc
        L_0x01a3:
            java.lang.String r2 = r1.getName()
            if (r2 == 0) goto L_0x01cf
            f7.k r2 = r3.f5917j
            int r6 = r2.f5933a
            if (r6 == 0) goto L_0x01c2
            java.lang.String r2 = r2.f5934b
            if (r2 == 0) goto L_0x01c2
            androidx.cardview.widget.CardView r2 = r8.a()
            h6.d r4 = new h6.d
            r6 = 15
            r4.<init>(r3, r5, r1, r6)
            r2.setOnClickListener(r4)
            goto L_0x01cf
        L_0x01c2:
            androidx.cardview.widget.CardView r2 = r8.a()
            f7.c r5 = new f7.c
            r5.<init>(r3, r1, r4)
            r4 = r2
        L_0x01cc:
            r4.setOnClickListener(r5)
        L_0x01cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.c.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        int i11 = this.f9203d;
        c0 c0Var = this.f9204e;
        switch (i11) {
            case 0:
                j.f("parent", viewGroup);
                return new b(this, z5.c.a(LayoutInflater.from(viewGroup.getContext()), viewGroup), c0Var);
            default:
                j.f("parent", viewGroup);
                return new d(i5.c(LayoutInflater.from(viewGroup.getContext()), viewGroup), c0Var, (f7.k) this.f9205f);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, f7.k kVar) {
        super(new b());
        j.f("fragment", c0Var);
        this.f9204e = c0Var;
        this.f9205f = kVar;
    }
}
