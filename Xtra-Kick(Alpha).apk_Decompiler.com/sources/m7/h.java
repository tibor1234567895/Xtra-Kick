package m7;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.k2;
import wa.l;
import xa.j;
import z5.c;

public final class h extends a {

    /* renamed from: f  reason: collision with root package name */
    public final c0 f10697f;

    /* renamed from: g  reason: collision with root package name */
    public final l f10698g;

    /* renamed from: h  reason: collision with root package name */
    public final l f10699h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10700i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(c0 c0Var, l lVar, l lVar2, boolean z10) {
        super(new f());
        j.f("fragment", c0Var);
        this.f10697f = c0Var;
        this.f10698g = lVar;
        this.f10699h = lVar2;
        this.f10700i = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x025a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r20, int r21) {
        /*
            r19 = this;
            r0 = r20
            m7.g r0 = (m7.g) r0
            java.lang.String r1 = "holder"
            xa.j.f(r1, r0)
            r1 = r19
            r2 = r21
            java.lang.Object r2 = r1.a(r2)
            com.github.andreyasadchy.xtra.model.ui.Video r2 = (com.github.andreyasadchy.xtra.model.ui.Video) r2
            if (r2 == 0) goto L_0x0272
            androidx.fragment.app.c0 r3 = r0.f10694i
            android.content.Context r3 = r3.f0()
            androidx.lifecycle.u1 r4 = new androidx.lifecycle.u1
            r5 = 22
            r4.<init>(r0, r5, r2)
            j3.m2 r5 = new j3.m2
            r6 = 18
            r5.<init>(r0, r3, r2, r6)
            java.lang.String r7 = r2.getDuration()
            r8 = 0
            if (r7 == 0) goto L_0x003a
            s7.h r9 = s7.h.f14375a
            r9.getClass()
            java.lang.Long r7 = s7.h.g(r7)
            goto L_0x003b
        L_0x003a:
            r7 = r8
        L_0x003b:
            java.lang.String r9 = r2.getUuid()
            m7.h r10 = r0.f10696k
            if (r9 == 0) goto L_0x005b
            java.lang.Long r9 = fb.v.e(r9)
            if (r9 == 0) goto L_0x005b
            long r11 = r9.longValue()
            java.util.Map r9 = r10.f10679d
            if (r9 == 0) goto L_0x005b
            java.lang.Long r8 = java.lang.Long.valueOf(r11)
            java.lang.Object r8 = r9.get(r8)
            java.lang.Long r8 = (java.lang.Long) r8
        L_0x005b:
            z5.c r9 = r0.f10693h
            android.widget.FrameLayout r11 = r9.f17599e
            androidx.cardview.widget.CardView r11 = (androidx.cardview.widget.CardView) r11
            h6.d r12 = new h6.d
            r13 = 19
            r12.<init>(r0, r2, r8, r13)
            r11.setOnClickListener(r12)
            android.widget.FrameLayout r11 = r9.f17599e
            androidx.cardview.widget.CardView r11 = (androidx.cardview.widget.CardView) r11
            j6.c r12 = new j6.c
            r13 = 3
            r12.<init>(r10, r2, r13)
            r11.setOnLongClickListener(r12)
            android.view.View r11 = r9.f17604j
            r12 = r11
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            java.lang.String r11 = "thumbnail"
            xa.j.e(r11, r12)
            androidx.fragment.app.c0 r13 = r0.f10694i
            java.lang.String r14 = r2.getThumbnail()
            r15 = 0
            r16 = 0
            d5.q r11 = d5.u.f4491a
            java.lang.String r6 = "NONE"
            xa.j.e(r6, r11)
            r18 = 12
            r17 = r11
            hb.h0.c1(r12, r13, r14, r15, r16, r17, r18)
            java.lang.String r6 = r2.getUploadDate()
            r11 = 0
            java.lang.String r12 = "date"
            android.widget.TextView r13 = r9.f17600f
            if (r6 == 0) goto L_0x00bf
            s7.h r6 = s7.h.f14375a
            java.lang.String r14 = r2.getUploadDate()
            r6.getClass()
            java.lang.String r6 = s7.h.d(r3, r14)
            if (r6 == 0) goto L_0x00bf
            com.github.andreyasadchy.xtra.util.TextWithCanvas r13 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r13
            xa.j.e(r12, r13)
            r13.setVisibility(r11)
            r13.setText(r6)
            goto L_0x00c7
        L_0x00bf:
            com.github.andreyasadchy.xtra.util.TextWithCanvas r13 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r13
            xa.j.e(r12, r13)
            hb.h0.J0(r13)
        L_0x00c7:
            java.lang.Integer r6 = r2.getViewCount()
            android.widget.TextView r12 = r9.f17608n
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r12
            java.lang.String r13 = "views"
            xa.j.e(r13, r12)
            if (r6 == 0) goto L_0x00ee
            r12.setVisibility(r11)
            s7.h r6 = s7.h.f14375a
            java.lang.Integer r13 = r2.getViewCount()
            int r13 = r13.intValue()
            r6.getClass()
            java.lang.String r6 = s7.h.f(r3, r13)
            r12.setText(r6)
            goto L_0x00f1
        L_0x00ee:
            hb.h0.J0(r12)
        L_0x00f1:
            android.widget.TextView r6 = r9.f17601g
            com.github.andreyasadchy.xtra.util.TextWithCanvas r6 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r6
            java.lang.String r12 = "duration"
            xa.j.e(r12, r6)
            if (r7 == 0) goto L_0x010b
            r6.setVisibility(r11)
            long r12 = r7.longValue()
            java.lang.String r12 = android.text.format.DateUtils.formatElapsedTime(r12)
            r6.setText(r12)
            goto L_0x010e
        L_0x010b:
            hb.h0.J0(r6)
        L_0x010e:
            r2.getType()
            java.lang.Object r6 = r9.f17606l
            com.github.andreyasadchy.xtra.util.TextWithCanvas r6 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r6
            java.lang.String r12 = "type"
            xa.j.e(r12, r6)
            hb.h0.J0(r6)
            android.widget.ProgressBar r6 = r9.f17596b
            if (r8 == 0) goto L_0x0143
            if (r7 == 0) goto L_0x0143
            long r12 = r7.longValue()
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x0143
            long r12 = r8.longValue()
            long r7 = r7.longValue()
            r14 = 10
            long r14 = (long) r14
            long r7 = r7 * r14
            long r12 = r12 / r7
            int r7 = (int) r12
            r6.setProgress(r7)
            r6.setVisibility(r11)
            goto L_0x014b
        L_0x0143:
            java.lang.String r7 = "progressBar"
            xa.j.e(r7, r6)
            hb.h0.J0(r6)
        L_0x014b:
            java.lang.String r6 = r2.getChannelLogo()
            android.view.View r7 = r9.f17607m
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            java.lang.String r8 = "userImage"
            xa.j.e(r8, r7)
            r8 = 16
            if (r6 == 0) goto L_0x0179
            r7.setVisibility(r11)
            androidx.fragment.app.c0 r13 = r0.f10694i
            java.lang.String r14 = r2.getChannelLogo()
            r15 = 0
            r16 = 1
            r17 = 0
            r18 = 20
            r12 = r7
            hb.h0.c1(r12, r13, r14, r15, r16, r17, r18)
            j6.d r6 = new j6.d
            r6.<init>(r8, r4)
            r7.setOnClickListener(r6)
            goto L_0x017c
        L_0x0179:
            hb.h0.J0(r7)
        L_0x017c:
            java.lang.String r6 = r2.getChannelName()
            java.lang.String r7 = "username"
            android.widget.TextView r12 = r9.f17598d
            xa.j.e(r7, r12)
            if (r6 == 0) goto L_0x019e
            r12.setVisibility(r11)
            java.lang.String r6 = r2.getChannelName()
            r12.setText(r6)
            j6.d r6 = new j6.d
            r7 = 17
            r6.<init>(r7, r4)
            r12.setOnClickListener(r6)
            goto L_0x01a1
        L_0x019e:
            hb.h0.J0(r12)
        L_0x01a1:
            java.lang.String r4 = r2.getTitle()
            java.lang.String r6 = "title"
            android.widget.TextView r7 = r9.f17597c
            if (r4 == 0) goto L_0x01cd
            java.lang.String r4 = r2.getTitle()
            java.lang.String r12 = ""
            boolean r4 = xa.j.a(r4, r12)
            if (r4 != 0) goto L_0x01cd
            xa.j.e(r6, r7)
            r7.setVisibility(r11)
            java.lang.String r4 = r2.getTitle()
            java.lang.CharSequence r4 = fb.y.R(r4)
            java.lang.String r4 = r4.toString()
            r7.setText(r4)
            goto L_0x01d3
        L_0x01cd:
            xa.j.e(r6, r7)
            hb.h0.J0(r7)
        L_0x01d3:
            boolean r4 = r0.f10695j
            java.lang.String r6 = "gameName"
            android.widget.TextView r7 = r9.f17595a
            if (r4 != 0) goto L_0x01f9
            java.lang.String r4 = r2.getGameName()
            if (r4 == 0) goto L_0x01f9
            xa.j.e(r6, r7)
            r7.setVisibility(r11)
            java.lang.String r4 = r2.getGameName()
            r7.setText(r4)
            j6.d r4 = new j6.d
            r6 = 18
            r4.<init>(r6, r5)
            r7.setOnClickListener(r4)
            goto L_0x01ff
        L_0x01f9:
            xa.j.e(r6, r7)
            hb.h0.J0(r7)
        L_0x01ff:
            java.util.List r4 = r2.getTags()
            r5 = 1
            if (r4 == 0) goto L_0x020f
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x020d
            goto L_0x020f
        L_0x020d:
            r4 = 0
            goto L_0x0210
        L_0x020f:
            r4 = 1
        L_0x0210:
            android.view.View r6 = r9.f17603i
            if (r4 != 0) goto L_0x025a
            android.content.SharedPreferences r4 = hb.h0.l1(r3)
            java.lang.String r7 = "ui_tags"
            boolean r4 = r4.getBoolean(r7, r5)
            if (r4 == 0) goto L_0x025a
            com.google.android.flexbox.FlexboxLayout r6 = (com.google.android.flexbox.FlexboxLayout) r6
            r6.removeAllViews()
            r6.setVisibility(r11)
            java.util.List r4 = r2.getTags()
            java.util.Iterator r4 = r4.iterator()
        L_0x0230:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0264
            java.lang.Object r5 = r4.next()
            com.github.andreyasadchy.xtra.model.ui.Tag r5 = (com.github.andreyasadchy.xtra.model.ui.Tag) r5
            android.widget.TextView r7 = new android.widget.TextView
            r7.<init>(r3)
            java.lang.String r11 = r5.getName()
            r7.setText(r11)
            java.lang.String r11 = r5.getName()
            if (r11 == 0) goto L_0x0256
            h6.b r11 = new h6.b
            r11.<init>(r0, r8, r5)
            r7.setOnClickListener(r11)
        L_0x0256:
            r6.addView(r7)
            goto L_0x0230
        L_0x025a:
            com.google.android.flexbox.FlexboxLayout r6 = (com.google.android.flexbox.FlexboxLayout) r6
            java.lang.String r0 = "tagsLayout"
            xa.j.e(r0, r6)
            hb.h0.J0(r6)
        L_0x0264:
            android.view.View r0 = r9.f17602h
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            h6.d r4 = new h6.d
            r5 = 20
            r4.<init>(r3, r2, r10, r5)
            r0.setOnClickListener(r4)
        L_0x0272:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.h.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        return new g(this, c.a(LayoutInflater.from(viewGroup.getContext()), viewGroup), this.f10697f, this.f10700i);
    }
}
