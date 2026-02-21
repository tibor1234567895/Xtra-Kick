package z6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.c0;
import androidx.lifecycle.u1;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.w0;
import java.util.List;
import java.util.Map;
import wa.l;
import xa.j;
import z5.c;

public final class d extends w0 {

    /* renamed from: b  reason: collision with root package name */
    public final c0 f17742b;

    /* renamed from: c  reason: collision with root package name */
    public final l f17743c;

    /* renamed from: d  reason: collision with root package name */
    public final l f17744d;

    /* renamed from: e  reason: collision with root package name */
    public final l f17745e;

    /* renamed from: f  reason: collision with root package name */
    public final l f17746f;

    /* renamed from: g  reason: collision with root package name */
    public Map f17747g;

    /* renamed from: h  reason: collision with root package name */
    public List f17748h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c0 c0Var, e eVar, e eVar2, e eVar3, u1 u1Var) {
        super(new a());
        j.f("fragment", c0Var);
        this.f17742b = c0Var;
        this.f17743c = eVar;
        this.f17744d = eVar2;
        this.f17745e = eVar3;
        this.f17746f = u1Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x028f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r29, int r30) {
        /*
            r28 = this;
            r0 = r29
            z6.c r0 = (z6.c) r0
            java.lang.String r1 = "holder"
            xa.j.f(r1, r0)
            r1 = r28
            androidx.recyclerview.widget.h r2 = r1.f2224a
            java.util.List r2 = r2.f2038f
            r3 = r30
            java.lang.Object r2 = r2.get(r3)
            com.github.andreyasadchy.xtra.model.offline.Bookmark r2 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r2
            if (r2 == 0) goto L_0x0313
            androidx.fragment.app.c0 r3 = r0.f17740i
            android.content.Context r3 = r3.f0()
            androidx.lifecycle.u1 r4 = new androidx.lifecycle.u1
            r5 = 14
            r4.<init>(r0, r5, r2)
            j3.m2 r6 = new j3.m2
            r6.<init>(r0, r3, r2, r5)
            java.lang.String r7 = r2.getDuration()
            if (r7 == 0) goto L_0x003b
            s7.h r9 = s7.h.f14375a
            r9.getClass()
            java.lang.Long r7 = s7.h.g(r7)
            goto L_0x003c
        L_0x003b:
            r7 = 0
        L_0x003c:
            java.lang.String r9 = r2.getVideoId()
            z6.d r10 = r0.f17741j
            if (r9 == 0) goto L_0x005d
            java.lang.Long r9 = fb.v.e(r9)
            if (r9 == 0) goto L_0x005d
            long r11 = r9.longValue()
            java.util.Map r9 = r10.f17747g
            if (r9 == 0) goto L_0x005d
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            java.lang.Object r9 = r9.get(r11)
            java.lang.Long r9 = (java.lang.Long) r9
            goto L_0x005e
        L_0x005d:
            r9 = 0
        L_0x005e:
            java.util.List r11 = r10.f17748h
            if (r11 == 0) goto L_0x008a
            java.util.Iterator r11 = r11.iterator()
        L_0x0066:
            boolean r14 = r11.hasNext()
            if (r14 == 0) goto L_0x0086
            java.lang.Object r14 = r11.next()
            r15 = r14
            com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser r15 = (com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser) r15
            int r15 = r15.getUser_id()
            int r5 = r2.getUserId()
            if (r15 != r5) goto L_0x007f
            r5 = 1
            goto L_0x0080
        L_0x007f:
            r5 = 0
        L_0x0080:
            if (r5 == 0) goto L_0x0083
            goto L_0x0087
        L_0x0083:
            r5 = 14
            goto L_0x0066
        L_0x0086:
            r14 = 0
        L_0x0087:
            com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser r14 = (com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser) r14
            goto L_0x008b
        L_0x008a:
            r14 = 0
        L_0x008b:
            if (r14 == 0) goto L_0x008f
            r5 = 1
            goto L_0x0090
        L_0x008f:
            r5 = 0
        L_0x0090:
            java.lang.String r11 = r2.getUserType()
            if (r11 != 0) goto L_0x009a
            java.lang.String r11 = r2.getUserBroadcasterType()
        L_0x009a:
            z5.c r14 = r0.f17739h
            android.widget.FrameLayout r15 = r14.f17599e
            androidx.cardview.widget.CardView r15 = (androidx.cardview.widget.CardView) r15
            h6.d r8 = new h6.d
            r12 = 13
            r8.<init>(r0, r2, r9, r12)
            r15.setOnClickListener(r8)
            android.widget.FrameLayout r8 = r14.f17599e
            androidx.cardview.widget.CardView r8 = (androidx.cardview.widget.CardView) r8
            j6.c r12 = new j6.c
            r15 = 2
            r12.<init>(r10, r2, r15)
            r8.setOnLongClickListener(r12)
            android.view.View r8 = r14.f17604j
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            java.lang.String r12 = "thumbnail"
            xa.j.e(r12, r8)
            androidx.fragment.app.c0 r12 = r0.f17740i
            java.lang.String r18 = r2.getThumbnail()
            r19 = 0
            r20 = 0
            d5.q r15 = d5.u.f4491a
            java.lang.String r13 = "NONE"
            xa.j.e(r13, r15)
            r22 = 12
            r16 = r8
            r17 = r12
            r21 = r15
            hb.h0.c1(r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r8 = r2.getCreatedAt()
            java.lang.String r12 = "date"
            android.widget.TextView r13 = r14.f17600f
            if (r8 == 0) goto L_0x0102
            s7.h r8 = s7.h.f14375a
            java.lang.String r1 = r2.getCreatedAt()
            r8.getClass()
            java.lang.String r1 = s7.h.d(r3, r1)
            if (r1 == 0) goto L_0x0102
            com.github.andreyasadchy.xtra.util.TextWithCanvas r13 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r13
            xa.j.e(r12, r13)
            r8 = 0
            r13.setVisibility(r8)
            r13.setText(r1)
            goto L_0x010a
        L_0x0102:
            com.github.andreyasadchy.xtra.util.TextWithCanvas r13 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r13
            xa.j.e(r12, r13)
            hb.h0.J0(r13)
        L_0x010a:
            java.lang.String r1 = r2.getType()
            java.lang.String r8 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            if (r1 == 0) goto L_0x011c
            java.util.Locale r12 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r12)
            xa.j.e(r8, r1)
            goto L_0x011d
        L_0x011c:
            r1 = 0
        L_0x011d:
            java.lang.String r12 = "archive"
            boolean r1 = xa.j.a(r1, r12)
            android.widget.TextView r12 = r14.f17608n
            r16 = 0
            java.lang.String r13 = "views"
            if (r1 == 0) goto L_0x01f2
            if (r11 == 0) goto L_0x01f2
            java.lang.String r1 = r2.getCreatedAt()
            if (r1 == 0) goto L_0x01f2
            android.content.SharedPreferences r1 = hb.h0.l1(r3)
            r19 = r10
            java.lang.String r10 = "ui_bookmark_time_left"
            r20 = r6
            r6 = 1
            boolean r1 = r1.getBoolean(r10, r6)
            if (r1 == 0) goto L_0x01ed
            if (r5 != 0) goto L_0x01ed
            s7.h r1 = s7.h.f14375a
            java.lang.String r6 = r2.getCreatedAt()
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r10 = r11.toLowerCase(r10)
            xa.j.e(r8, r10)
            java.lang.String r8 = ""
            boolean r8 = xa.j.a(r10, r8)
            if (r8 == 0) goto L_0x015e
            goto L_0x0166
        L_0x015e:
            java.lang.String r8 = "affiliate"
            boolean r8 = xa.j.a(r10, r8)
            if (r8 == 0) goto L_0x0169
        L_0x0166:
            r8 = 14
            goto L_0x016b
        L_0x0169:
            r8 = 60
        L_0x016b:
            r1.getClass()
            if (r6 == 0) goto L_0x0175
            java.lang.Long r1 = s7.h.l(r6)
            goto L_0x0176
        L_0x0175:
            r1 = 0
        L_0x0176:
            if (r1 == 0) goto L_0x01c1
            java.lang.String r6 = "UTC"
            java.util.TimeZone r10 = java.util.TimeZone.getTimeZone(r6)
            java.util.Calendar r10 = java.util.Calendar.getInstance(r10)
            java.util.Date r10 = r10.getTime()
            long r10 = r10.getTime()
            java.util.TimeZone r6 = java.util.TimeZone.getTimeZone(r6)
            java.util.Calendar r6 = java.util.Calendar.getInstance(r6)
            r29 = r5
            java.util.Date r5 = new java.util.Date
            r21 = r0
            long r0 = r1.longValue()
            r5.<init>(r0)
            r6.setTime(r5)
            r0 = 5
            r6.add(r0, r8)
            java.util.Date r0 = r6.getTime()
            long r0 = r0.getTime()
            long r0 = r0 - r10
            r5 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r5
            long r0 = r0 / r5
            int r5 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r5 < 0) goto L_0x01c5
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1 = 1
            java.lang.String r8 = s7.h.h(r3, r0, r1)
            goto L_0x01c6
        L_0x01c1:
            r21 = r0
            r29 = r5
        L_0x01c5:
            r8 = 0
        L_0x01c6:
            if (r8 == 0) goto L_0x01d1
            boolean r0 = fb.w.h(r8)
            if (r0 == 0) goto L_0x01cf
            goto L_0x01d1
        L_0x01cf:
            r0 = 0
            goto L_0x01d2
        L_0x01d1:
            r0 = 1
        L_0x01d2:
            if (r0 != 0) goto L_0x01fa
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r12
            xa.j.e(r13, r12)
            r0 = 0
            r12.setVisibility(r0)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r8
            r0 = 2131952450(0x7f130342, float:1.9541343E38)
            java.lang.String r0 = r3.getString(r0, r1)
            r12.setText(r0)
            goto L_0x0202
        L_0x01ed:
            r21 = r0
            r29 = r5
            goto L_0x01fa
        L_0x01f2:
            r21 = r0
            r29 = r5
            r20 = r6
            r19 = r10
        L_0x01fa:
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r12
            xa.j.e(r13, r12)
            hb.h0.J0(r12)
        L_0x0202:
            android.widget.TextView r0 = r14.f17601g
            com.github.andreyasadchy.xtra.util.TextWithCanvas r0 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r0
            java.lang.String r1 = "duration"
            xa.j.e(r1, r0)
            if (r7 == 0) goto L_0x021d
            r1 = 0
            r0.setVisibility(r1)
            long r5 = r7.longValue()
            java.lang.String r1 = android.text.format.DateUtils.formatElapsedTime(r5)
            r0.setText(r1)
            goto L_0x0220
        L_0x021d:
            hb.h0.J0(r0)
        L_0x0220:
            r2.getType()
            java.lang.Object r0 = r14.f17606l
            com.github.andreyasadchy.xtra.util.TextWithCanvas r0 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r0
            java.lang.String r1 = "type"
            xa.j.e(r1, r0)
            hb.h0.J0(r0)
            java.lang.String r0 = r2.getUserLogo()
            android.view.View r1 = r14.f17607m
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r5 = "userImage"
            xa.j.e(r5, r1)
            if (r0 == 0) goto L_0x0263
            r0 = 0
            r1.setVisibility(r0)
            r0 = r21
            androidx.fragment.app.c0 r0 = r0.f17740i
            java.lang.String r23 = r2.getUserLogo()
            r24 = 0
            r25 = 1
            r27 = 4
            r21 = r1
            r22 = r0
            r26 = r15
            hb.h0.c1(r21, r22, r23, r24, r25, r26, r27)
            j6.d r0 = new j6.d
            r5 = 4
            r0.<init>(r5, r4)
            r1.setOnClickListener(r0)
            goto L_0x0266
        L_0x0263:
            hb.h0.J0(r1)
        L_0x0266:
            java.lang.String r0 = r2.getUserName()
            java.lang.String r1 = "username"
            android.widget.TextView r5 = r14.f17598d
            xa.j.e(r1, r5)
            if (r0 == 0) goto L_0x0288
            r0 = 0
            r5.setVisibility(r0)
            java.lang.String r0 = r2.getUserName()
            r5.setText(r0)
            j6.d r0 = new j6.d
            r1 = 5
            r0.<init>(r1, r4)
            r5.setOnClickListener(r0)
            goto L_0x028b
        L_0x0288:
            hb.h0.J0(r5)
        L_0x028b:
            android.widget.ProgressBar r0 = r14.f17596b
            if (r9 == 0) goto L_0x02b0
            if (r7 == 0) goto L_0x02b0
            long r4 = r7.longValue()
            int r1 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x02b0
            long r4 = r9.longValue()
            long r6 = r7.longValue()
            r1 = 10
            long r8 = (long) r1
            long r6 = r6 * r8
            long r4 = r4 / r6
            int r1 = (int) r4
            r0.setProgress(r1)
            r1 = 0
            r0.setVisibility(r1)
            goto L_0x02b8
        L_0x02b0:
            java.lang.String r1 = "progressBar"
            xa.j.e(r1, r0)
            hb.h0.J0(r0)
        L_0x02b8:
            java.lang.String r0 = r2.getTitle()
            java.lang.String r1 = "title"
            android.widget.TextView r4 = r14.f17597c
            xa.j.e(r1, r4)
            if (r0 == 0) goto L_0x02d9
            r0 = 0
            r4.setVisibility(r0)
            java.lang.String r0 = r2.getTitle()
            java.lang.CharSequence r0 = fb.y.R(r0)
            java.lang.String r0 = r0.toString()
            r4.setText(r0)
            goto L_0x02dc
        L_0x02d9:
            hb.h0.J0(r4)
        L_0x02dc:
            java.lang.String r0 = r2.getGameName()
            java.lang.String r1 = "gameName"
            android.widget.TextView r4 = r14.f17595a
            xa.j.e(r1, r4)
            if (r0 == 0) goto L_0x0300
            r0 = 0
            r4.setVisibility(r0)
            java.lang.String r0 = r2.getGameName()
            r4.setText(r0)
            j6.d r0 = new j6.d
            r1 = 6
            r5 = r20
            r0.<init>(r1, r5)
            r4.setOnClickListener(r0)
            goto L_0x0303
        L_0x0300:
            hb.h0.J0(r4)
        L_0x0303:
            android.view.View r0 = r14.f17602h
            android.widget.ImageButton r0 = (android.widget.ImageButton) r0
            z6.b r1 = new z6.b
            r13 = r29
            r4 = r19
            r1.<init>(r3, r2, r13, r4)
            r0.setOnClickListener(r1)
        L_0x0313:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.d.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        return new c(this, c.a(LayoutInflater.from(viewGroup.getContext()), viewGroup), this.f17742b);
    }
}
