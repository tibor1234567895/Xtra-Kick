package n7;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.k2;
import m7.a;
import wa.l;
import xa.j;

public final class c extends a {

    /* renamed from: f  reason: collision with root package name */
    public final c0 f11714f;

    /* renamed from: g  reason: collision with root package name */
    public final l f11715g;

    /* renamed from: h  reason: collision with root package name */
    public final l f11716h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, f fVar, f fVar2) {
        super(new a());
        j.f("fragment", c0Var);
        this.f11714f = c0Var;
        this.f11715g = fVar;
        this.f11716h = fVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r19, int r20) {
        /*
            r18 = this;
            r0 = r19
            n7.b r0 = (n7.b) r0
            java.lang.String r1 = "holder"
            xa.j.f(r1, r0)
            r1 = r18
            r2 = r20
            java.lang.Object r2 = r1.a(r2)
            com.github.andreyasadchy.xtra.model.ui.Video r2 = (com.github.andreyasadchy.xtra.model.ui.Video) r2
            if (r2 == 0) goto L_0x020f
            androidx.fragment.app.c0 r3 = r0.f11712i
            android.content.Context r3 = r3.f0()
            j3.m2 r4 = new j3.m2
            r5 = 19
            r4.<init>(r0, r3, r2, r5)
            java.lang.String r6 = r2.getDuration()
            r7 = 0
            if (r6 == 0) goto L_0x0033
            s7.h r8 = s7.h.f14375a
            r8.getClass()
            java.lang.Long r6 = s7.h.g(r6)
            goto L_0x0034
        L_0x0033:
            r6 = r7
        L_0x0034:
            java.lang.String r8 = r2.getUuid()
            n7.c r9 = r0.f11713j
            if (r8 == 0) goto L_0x0054
            java.lang.Long r8 = fb.v.e(r8)
            if (r8 == 0) goto L_0x0054
            long r10 = r8.longValue()
            java.util.Map r8 = r9.f10679d
            if (r8 == 0) goto L_0x0054
            java.lang.Long r7 = java.lang.Long.valueOf(r10)
            java.lang.Object r7 = r8.get(r7)
            java.lang.Long r7 = (java.lang.Long) r7
        L_0x0054:
            z5.c r8 = r0.f11711h
            android.widget.FrameLayout r10 = r8.f17599e
            androidx.cardview.widget.CardView r10 = (androidx.cardview.widget.CardView) r10
            h6.d r11 = new h6.d
            r12 = 21
            r11.<init>(r0, r2, r7, r12)
            r10.setOnClickListener(r11)
            android.widget.FrameLayout r10 = r8.f17599e
            androidx.cardview.widget.CardView r10 = (androidx.cardview.widget.CardView) r10
            j6.c r11 = new j6.c
            r12 = 4
            r11.<init>(r9, r2, r12)
            r10.setOnLongClickListener(r11)
            android.view.View r10 = r8.f17604j
            r11 = r10
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            java.lang.String r10 = "thumbnail"
            xa.j.e(r10, r11)
            androidx.fragment.app.c0 r12 = r0.f11712i
            java.lang.String r13 = r2.getThumbnail()
            r14 = 0
            r15 = 0
            d5.q r10 = d5.u.f4491a
            java.lang.String r5 = "NONE"
            xa.j.e(r5, r10)
            r17 = 12
            r16 = r10
            hb.h0.c1(r11, r12, r13, r14, r15, r16, r17)
            java.lang.String r5 = r2.getUploadDate()
            r10 = 0
            java.lang.String r11 = "date"
            android.widget.TextView r12 = r8.f17600f
            if (r5 == 0) goto L_0x00b7
            s7.h r5 = s7.h.f14375a
            java.lang.String r13 = r2.getUploadDate()
            r5.getClass()
            java.lang.String r5 = s7.h.d(r3, r13)
            if (r5 == 0) goto L_0x00b7
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r12
            xa.j.e(r11, r12)
            r12.setVisibility(r10)
            r12.setText(r5)
            goto L_0x00bf
        L_0x00b7:
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r12
            xa.j.e(r11, r12)
            hb.h0.J0(r12)
        L_0x00bf:
            java.lang.Integer r5 = r2.getViewCount()
            android.widget.TextView r11 = r8.f17608n
            com.github.andreyasadchy.xtra.util.TextWithCanvas r11 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r11
            java.lang.String r12 = "views"
            xa.j.e(r12, r11)
            if (r5 == 0) goto L_0x00e6
            r11.setVisibility(r10)
            s7.h r5 = s7.h.f14375a
            java.lang.Integer r12 = r2.getViewCount()
            int r12 = r12.intValue()
            r5.getClass()
            java.lang.String r5 = s7.h.f(r3, r12)
            r11.setText(r5)
            goto L_0x00e9
        L_0x00e6:
            hb.h0.J0(r11)
        L_0x00e9:
            android.widget.TextView r5 = r8.f17601g
            com.github.andreyasadchy.xtra.util.TextWithCanvas r5 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r5
            java.lang.String r11 = "duration"
            xa.j.e(r11, r5)
            if (r6 == 0) goto L_0x0103
            r5.setVisibility(r10)
            long r11 = r6.longValue()
            java.lang.String r11 = android.text.format.DateUtils.formatElapsedTime(r11)
            r5.setText(r11)
            goto L_0x0106
        L_0x0103:
            hb.h0.J0(r5)
        L_0x0106:
            r2.getType()
            java.lang.Object r5 = r8.f17606l
            com.github.andreyasadchy.xtra.util.TextWithCanvas r5 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r5
            java.lang.String r11 = "type"
            xa.j.e(r11, r5)
            hb.h0.J0(r5)
            android.widget.ProgressBar r5 = r8.f17596b
            if (r7 == 0) goto L_0x013b
            if (r6 == 0) goto L_0x013b
            long r11 = r6.longValue()
            r13 = 0
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x013b
            long r11 = r7.longValue()
            long r6 = r6.longValue()
            r13 = 10
            long r13 = (long) r13
            long r6 = r6 * r13
            long r11 = r11 / r6
            int r6 = (int) r11
            r5.setProgress(r6)
            r5.setVisibility(r10)
            goto L_0x0143
        L_0x013b:
            java.lang.String r6 = "progressBar"
            xa.j.e(r6, r5)
            hb.h0.J0(r5)
        L_0x0143:
            java.lang.String r5 = r2.getTitle()
            java.lang.String r6 = "title"
            android.widget.TextView r7 = r8.f17597c
            if (r5 == 0) goto L_0x016f
            java.lang.String r5 = r2.getTitle()
            java.lang.String r11 = ""
            boolean r5 = xa.j.a(r5, r11)
            if (r5 != 0) goto L_0x016f
            xa.j.e(r6, r7)
            r7.setVisibility(r10)
            java.lang.String r5 = r2.getTitle()
            java.lang.CharSequence r5 = fb.y.R(r5)
            java.lang.String r5 = r5.toString()
            r7.setText(r5)
            goto L_0x0175
        L_0x016f:
            xa.j.e(r6, r7)
            hb.h0.J0(r7)
        L_0x0175:
            java.lang.String r5 = r2.getGameName()
            java.lang.String r6 = "gameName"
            android.widget.TextView r7 = r8.f17595a
            xa.j.e(r6, r7)
            if (r5 == 0) goto L_0x0197
            r7.setVisibility(r10)
            java.lang.String r5 = r2.getGameName()
            r7.setText(r5)
            j6.d r5 = new j6.d
            r6 = 19
            r5.<init>(r6, r4)
            r7.setOnClickListener(r5)
            goto L_0x019a
        L_0x0197:
            hb.h0.J0(r7)
        L_0x019a:
            java.util.List r4 = r2.getTags()
            r5 = 1
            if (r4 == 0) goto L_0x01aa
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x01a8
            goto L_0x01aa
        L_0x01a8:
            r4 = 0
            goto L_0x01ab
        L_0x01aa:
            r4 = 1
        L_0x01ab:
            android.view.View r6 = r8.f17603i
            if (r4 != 0) goto L_0x01f7
            android.content.SharedPreferences r4 = hb.h0.l1(r3)
            java.lang.String r7 = "ui_tags"
            boolean r4 = r4.getBoolean(r7, r5)
            if (r4 == 0) goto L_0x01f7
            com.google.android.flexbox.FlexboxLayout r6 = (com.google.android.flexbox.FlexboxLayout) r6
            r6.removeAllViews()
            r6.setVisibility(r10)
            java.util.List r4 = r2.getTags()
            java.util.Iterator r4 = r4.iterator()
        L_0x01cb:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0201
            java.lang.Object r5 = r4.next()
            com.github.andreyasadchy.xtra.model.ui.Tag r5 = (com.github.andreyasadchy.xtra.model.ui.Tag) r5
            android.widget.TextView r7 = new android.widget.TextView
            r7.<init>(r3)
            java.lang.String r10 = r5.getName()
            r7.setText(r10)
            java.lang.String r10 = r5.getName()
            if (r10 == 0) goto L_0x01f3
            h6.b r10 = new h6.b
            r11 = 18
            r10.<init>(r0, r11, r5)
            r7.setOnClickListener(r10)
        L_0x01f3:
            r6.addView(r7)
            goto L_0x01cb
        L_0x01f7:
            com.google.android.flexbox.FlexboxLayout r6 = (com.google.android.flexbox.FlexboxLayout) r6
            java.lang.String r0 = "tagsLayout"
            xa.j.e(r0, r6)
            hb.h0.J0(r6)
        L_0x0201:
            android.view.View r0 = r8.f17602h
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            h6.d r4 = new h6.d
            r5 = 22
            r4.<init>(r3, r2, r9, r5)
            r0.setOnClickListener(r4)
        L_0x020f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.c.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        return new b(this, z5.c.a(LayoutInflater.from(viewGroup.getContext()), viewGroup), this.f11714f);
    }
}
