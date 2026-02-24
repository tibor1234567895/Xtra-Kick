package j6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.c0;
import androidx.fragment.app.k;
import androidx.recyclerview.widget.k2;
import n3.x3;
import wa.l;
import xa.j;
import z5.c;

public final class f extends x3 {

    /* renamed from: d  reason: collision with root package name */
    public final c0 f8820d;

    /* renamed from: e  reason: collision with root package name */
    public final l f8821e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8822f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(c0 c0Var, k kVar, boolean z10) {
        super(new b());
        j.f("fragment", c0Var);
        this.f8820d = c0Var;
        this.f8821e = kVar;
        this.f8822f = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r20, int r21) {
        /*
            r19 = this;
            r0 = r20
            j6.e r0 = (j6.e) r0
            java.lang.String r1 = "holder"
            xa.j.f(r1, r0)
            r1 = r19
            r2 = r21
            java.lang.Object r2 = r1.a(r2)
            com.github.andreyasadchy.xtra.model.ui.Clip r2 = (com.github.andreyasadchy.xtra.model.ui.Clip) r2
            if (r2 == 0) goto L_0x019e
            androidx.fragment.app.c0 r3 = r0.f8817i
            android.content.Context r3 = r3.f0()
            androidx.lifecycle.u1 r4 = new androidx.lifecycle.u1
            r5 = 7
            r4.<init>(r0, r5, r2)
            j3.m2 r5 = new j3.m2
            r6 = 6
            r5.<init>(r0, r3, r2, r6)
            z5.c r6 = r0.f8816h
            android.widget.FrameLayout r7 = r6.f17599e
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            h6.b r8 = new h6.b
            r9 = 1
            r8.<init>(r0, r9, r2)
            r7.setOnClickListener(r8)
            android.widget.FrameLayout r7 = r6.f17599e
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            j6.c r8 = new j6.c
            j6.f r10 = r0.f8819k
            r11 = 0
            r8.<init>(r10, r2, r11)
            r7.setOnLongClickListener(r8)
            android.view.View r7 = r6.f17604j
            r12 = r7
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            java.lang.String r7 = "thumbnail"
            xa.j.e(r7, r12)
            androidx.fragment.app.c0 r13 = r0.f8817i
            java.lang.String r14 = r2.getThumbnail()
            r15 = 0
            r16 = 0
            d5.q r7 = d5.u.f4491a
            java.lang.String r8 = "NONE"
            xa.j.e(r8, r7)
            r18 = 12
            r17 = r7
            hb.h0.c1(r12, r13, r14, r15, r16, r17, r18)
            java.lang.String r7 = r2.getUploadDate()
            java.lang.String r8 = "date"
            android.widget.TextView r12 = r6.f17600f
            if (r7 == 0) goto L_0x008b
            java.lang.String r7 = r2.getUploadDate()
            s7.h r13 = s7.h.f14375a
            r13.getClass()
            java.lang.String r7 = s7.h.d(r3, r7)
            if (r7 == 0) goto L_0x008b
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r12
            xa.j.e(r8, r12)
            r12.setVisibility(r11)
            r12.setText(r7)
            goto L_0x0093
        L_0x008b:
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r12
            xa.j.e(r8, r12)
            hb.h0.J0(r12)
        L_0x0093:
            java.lang.Integer r7 = r2.getViewCount()
            android.widget.TextView r8 = r6.f17608n
            com.github.andreyasadchy.xtra.util.TextWithCanvas r8 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r8
            java.lang.String r12 = "views"
            xa.j.e(r12, r8)
            if (r7 == 0) goto L_0x00ba
            r8.setVisibility(r11)
            s7.h r7 = s7.h.f14375a
            java.lang.Integer r12 = r2.getViewCount()
            int r12 = r12.intValue()
            r7.getClass()
            java.lang.String r7 = s7.h.f(r3, r12)
            r8.setText(r7)
            goto L_0x00bd
        L_0x00ba:
            hb.h0.J0(r8)
        L_0x00bd:
            java.lang.Double r7 = r2.getDuration()
            android.widget.TextView r8 = r6.f17601g
            com.github.andreyasadchy.xtra.util.TextWithCanvas r8 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r8
            java.lang.String r12 = "duration"
            xa.j.e(r12, r8)
            if (r7 == 0) goto L_0x00e0
            r8.setVisibility(r11)
            java.lang.Double r7 = r2.getDuration()
            double r12 = r7.doubleValue()
            long r12 = (long) r12
            java.lang.String r7 = android.text.format.DateUtils.formatElapsedTime(r12)
            r8.setText(r7)
            goto L_0x00e3
        L_0x00e0:
            hb.h0.J0(r8)
        L_0x00e3:
            java.lang.String r7 = r2.getChannelLogo()
            android.view.View r8 = r6.f17607m
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            java.lang.String r12 = "userImage"
            xa.j.e(r12, r8)
            if (r7 == 0) goto L_0x010f
            r8.setVisibility(r11)
            androidx.fragment.app.c0 r13 = r0.f8817i
            java.lang.String r14 = r2.getChannelLogo()
            r15 = 0
            r16 = 1
            r17 = 0
            r18 = 20
            r12 = r8
            hb.h0.c1(r12, r13, r14, r15, r16, r17, r18)
            j6.d r7 = new j6.d
            r7.<init>(r11, r4)
            r8.setOnClickListener(r7)
            goto L_0x0112
        L_0x010f:
            hb.h0.J0(r8)
        L_0x0112:
            java.lang.String r7 = r2.getChannelName()
            java.lang.String r8 = "username"
            android.widget.TextView r12 = r6.f17598d
            xa.j.e(r8, r12)
            if (r7 == 0) goto L_0x0132
            r12.setVisibility(r11)
            java.lang.String r7 = r2.getChannelName()
            r12.setText(r7)
            j6.d r7 = new j6.d
            r7.<init>(r9, r4)
            r12.setOnClickListener(r7)
            goto L_0x0135
        L_0x0132:
            hb.h0.J0(r12)
        L_0x0135:
            java.lang.String r4 = r2.getTitle()
            java.lang.String r7 = "title"
            android.widget.TextView r8 = r6.f17597c
            if (r4 == 0) goto L_0x0161
            java.lang.String r4 = r2.getTitle()
            java.lang.String r12 = ""
            boolean r4 = xa.j.a(r4, r12)
            if (r4 != 0) goto L_0x0161
            xa.j.e(r7, r8)
            r8.setVisibility(r11)
            java.lang.String r4 = r2.getTitle()
            java.lang.CharSequence r4 = fb.y.R(r4)
            java.lang.String r4 = r4.toString()
            r8.setText(r4)
            goto L_0x0167
        L_0x0161:
            xa.j.e(r7, r8)
            hb.h0.J0(r8)
        L_0x0167:
            boolean r0 = r0.f8818j
            java.lang.String r4 = "gameName"
            android.widget.TextView r7 = r6.f17595a
            if (r0 != 0) goto L_0x018c
            java.lang.String r0 = r2.getGameName()
            if (r0 == 0) goto L_0x018c
            xa.j.e(r4, r7)
            r7.setVisibility(r11)
            java.lang.String r0 = r2.getGameName()
            r7.setText(r0)
            j6.d r0 = new j6.d
            r4 = 2
            r0.<init>(r4, r5)
            r7.setOnClickListener(r0)
            goto L_0x0192
        L_0x018c:
            xa.j.e(r4, r7)
            hb.h0.J0(r7)
        L_0x0192:
            android.view.View r0 = r6.f17602h
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            h6.d r4 = new h6.d
            r4.<init>(r3, r10, r2, r9)
            r0.setOnClickListener(r4)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.f.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        return new e(this, c.a(LayoutInflater.from(viewGroup.getContext()), viewGroup), this.f8820d, this.f8822f);
    }
}
