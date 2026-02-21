package o6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.i5;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.k2;
import com.google.android.flexbox.FlexboxLayout;
import com.woxthebox.draglistview.R;
import n3.x3;
import p6.a;
import p6.b;
import q6.p;
import q6.q;
import xa.j;
import z5.h;
import z5.i;

public final class c extends x3 {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12240d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f12241e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(int i10, c0 c0Var) {
        super(new a());
        this.f12240d = i10;
        if (i10 == 1) {
            j.f("fragment", c0Var);
            super(new a());
            this.f12241e = c0Var;
        } else if (i10 == 2) {
            j.f("fragment", c0Var);
            super(new p());
            this.f12241e = c0Var;
        } else if (i10 != 3) {
            j.f("fragment", c0Var);
            this.f12241e = c0Var;
        } else {
            j.f("fragment", c0Var);
            super(new c7.a());
            this.f12241e = c0Var;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0414  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r26, int r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            int r4 = r0.f12240d
            java.lang.String r5 = "ui_tags"
            java.lang.String r6 = "tagsLayout"
            java.lang.String r7 = "ui_broadcasterscount"
            java.lang.String r8 = "broadcastersCount"
            java.lang.String r9 = "viewers"
            java.lang.String r10 = "gameName"
            java.lang.String r11 = "gameImage"
            java.lang.String r12 = "localText"
            java.lang.String r13 = "twitchText"
            java.lang.String r14 = "NONE"
            java.lang.String r15 = "userImage"
            java.lang.String r2 = "holder"
            r3 = 1
            switch(r4) {
                case 0: goto L_0x0300;
                case 1: goto L_0x0184;
                case 2: goto L_0x0025;
                default: goto L_0x0022;
            }
        L_0x0022:
            r4 = r0
            goto L_0x0418
        L_0x0025:
            r4 = r26
            q6.q r4 = (q6.q) r4
            xa.j.f(r2, r4)
            java.lang.Object r1 = r0.a(r1)
            com.github.andreyasadchy.xtra.model.ui.Game r1 = (com.github.andreyasadchy.xtra.model.ui.Game) r1
            if (r1 == 0) goto L_0x0183
            androidx.fragment.app.c0 r2 = r4.f13387i
            android.content.Context r2 = r2.f0()
            androidx.appcompat.widget.i5 r12 = r4.f13386h
            androidx.cardview.widget.CardView r13 = r12.a()
            h6.d r14 = new h6.d
            r15 = 9
            r14.<init>(r4, r2, r1, r15)
            r13.setOnClickListener(r14)
            java.lang.String r13 = r1.getBoxArt()
            java.lang.Object r14 = r12.f875c
            if (r13 == 0) goto L_0x0072
            r13 = r14
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            xa.j.e(r11, r13)
            r11 = 0
            r13.setVisibility(r11)
            androidx.fragment.app.c0 r11 = r4.f13387i
            java.lang.String r18 = r1.getBoxArt()
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 28
            r16 = r13
            r17 = r11
            hb.h0.c1(r16, r17, r18, r19, r20, r21, r22)
            goto L_0x007a
        L_0x0072:
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            xa.j.e(r11, r14)
            hb.h0.J0(r14)
        L_0x007a:
            java.lang.String r11 = r1.getGameName()
            java.lang.Object r13 = r12.f877e
            android.widget.TextView r13 = (android.widget.TextView) r13
            xa.j.e(r10, r13)
            if (r11 == 0) goto L_0x0093
            r10 = 0
            r13.setVisibility(r10)
            java.lang.String r10 = r1.getGameName()
            r13.setText(r10)
            goto L_0x0096
        L_0x0093:
            hb.h0.J0(r13)
        L_0x0096:
            java.lang.Integer r10 = r1.getViewersCount()
            if (r10 == 0) goto L_0x00c3
            java.lang.Object r10 = r12.f880h
            android.widget.TextView r10 = (android.widget.TextView) r10
            xa.j.e(r9, r10)
            r9 = 0
            r10.setVisibility(r9)
            java.lang.Object r9 = r12.f880h
            android.widget.TextView r9 = (android.widget.TextView) r9
            s7.h r10 = s7.h.f14375a
            java.lang.Integer r11 = r1.getViewersCount()
            xa.j.c(r11)
            int r11 = r11.intValue()
            r10.getClass()
            java.lang.String r10 = s7.h.e(r2, r11)
            r9.setText(r10)
            goto L_0x00cd
        L_0x00c3:
            java.lang.Object r10 = r12.f880h
            android.widget.TextView r10 = (android.widget.TextView) r10
            xa.j.e(r9, r10)
            hb.h0.J0(r10)
        L_0x00cd:
            java.lang.Integer r9 = r1.getBroadcastersCount()
            java.lang.Object r10 = r12.f876d
            if (r9 == 0) goto L_0x0109
            android.content.SharedPreferences r9 = hb.h0.l1(r2)
            boolean r7 = r9.getBoolean(r7, r3)
            if (r7 == 0) goto L_0x0109
            android.widget.TextView r10 = (android.widget.TextView) r10
            xa.j.e(r8, r10)
            r7 = 0
            r10.setVisibility(r7)
            android.content.res.Resources r8 = r2.getResources()
            java.lang.Integer r9 = r1.getBroadcastersCount()
            xa.j.c(r9)
            int r9 = r9.intValue()
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.Integer r13 = r1.getBroadcastersCount()
            r11[r7] = r13
            r7 = 2131886080(0x7f120000, float:1.9406729E38)
            java.lang.String r7 = r8.getQuantityString(r7, r9, r11)
            r10.setText(r7)
            goto L_0x0111
        L_0x0109:
            android.widget.TextView r10 = (android.widget.TextView) r10
            xa.j.e(r8, r10)
            hb.h0.J0(r10)
        L_0x0111:
            java.util.List r7 = r1.getTags()
            if (r7 == 0) goto L_0x0120
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x011e
            goto L_0x0120
        L_0x011e:
            r7 = 0
            goto L_0x0121
        L_0x0120:
            r7 = 1
        L_0x0121:
            if (r7 != 0) goto L_0x0179
            android.content.SharedPreferences r7 = hb.h0.l1(r2)
            boolean r3 = r7.getBoolean(r5, r3)
            if (r3 == 0) goto L_0x0179
            java.lang.Object r3 = r12.f878f
            com.google.android.flexbox.FlexboxLayout r3 = (com.google.android.flexbox.FlexboxLayout) r3
            r3.removeAllViews()
            java.lang.Object r3 = r12.f878f
            com.google.android.flexbox.FlexboxLayout r3 = (com.google.android.flexbox.FlexboxLayout) r3
            xa.j.e(r6, r3)
            r5 = 0
            r3.setVisibility(r5)
            java.util.List r1 = r1.getTags()
            xa.j.c(r1)
            java.util.Iterator r1 = r1.iterator()
        L_0x014a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0183
            java.lang.Object r3 = r1.next()
            com.github.andreyasadchy.xtra.model.ui.Tag r3 = (com.github.andreyasadchy.xtra.model.ui.Tag) r3
            android.widget.TextView r5 = new android.widget.TextView
            r5.<init>(r2)
            java.lang.String r6 = r3.getName()
            r5.setText(r6)
            java.lang.String r6 = r3.getId()
            if (r6 == 0) goto L_0x0171
            h6.b r6 = new h6.b
            r7 = 5
            r6.<init>(r4, r7, r3)
            r5.setOnClickListener(r6)
        L_0x0171:
            java.lang.Object r3 = r12.f878f
            com.google.android.flexbox.FlexboxLayout r3 = (com.google.android.flexbox.FlexboxLayout) r3
            r3.addView(r5)
            goto L_0x014a
        L_0x0179:
            java.lang.Object r1 = r12.f878f
            com.google.android.flexbox.FlexboxLayout r1 = (com.google.android.flexbox.FlexboxLayout) r1
            xa.j.e(r6, r1)
            hb.h0.J0(r1)
        L_0x0183:
            return
        L_0x0184:
            r4 = r26
            p6.b r4 = (p6.b) r4
            xa.j.f(r2, r4)
            java.lang.Object r1 = r0.a(r1)
            com.github.andreyasadchy.xtra.model.ui.Game r1 = (com.github.andreyasadchy.xtra.model.ui.Game) r1
            if (r1 == 0) goto L_0x02ff
            androidx.fragment.app.c0 r2 = r4.f12577i
            android.content.Context r2 = r2.f0()
            z5.i r15 = r4.f12576h
            androidx.cardview.widget.CardView r3 = r15.c()
            h6.d r0 = new h6.d
            r17 = r12
            r12 = 6
            r0.<init>(r4, r2, r1, r12)
            r3.setOnClickListener(r0)
            java.lang.String r0 = r1.getBoxArt()
            java.lang.Object r3 = r15.f17667e
            if (r0 == 0) goto L_0x01d7
            r0 = r3
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            xa.j.e(r11, r0)
            r3 = 0
            r0.setVisibility(r3)
            androidx.fragment.app.c0 r3 = r4.f12577i
            java.lang.String r20 = r1.getBoxArt()
            r21 = 0
            r22 = 0
            d5.q r11 = d5.u.f4491a
            xa.j.e(r14, r11)
            r24 = 12
            r18 = r0
            r19 = r3
            r23 = r11
            hb.h0.c1(r18, r19, r20, r21, r22, r23, r24)
            goto L_0x01df
        L_0x01d7:
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            xa.j.e(r11, r3)
            hb.h0.J0(r3)
        L_0x01df:
            java.lang.String r0 = r1.getGameName()
            java.lang.Object r3 = r15.f17668f
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r10, r3)
            if (r0 == 0) goto L_0x01f8
            r0 = 0
            r3.setVisibility(r0)
            java.lang.String r0 = r1.getGameName()
            r3.setText(r0)
            goto L_0x01fb
        L_0x01f8:
            hb.h0.J0(r3)
        L_0x01fb:
            java.lang.Integer r0 = r1.getViewersCount()
            java.lang.Object r3 = r15.f17672j
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r9, r3)
            if (r0 == 0) goto L_0x0224
            r0 = 0
            r3.setVisibility(r0)
            s7.h r0 = s7.h.f14375a
            java.lang.Integer r9 = r1.getViewersCount()
            xa.j.c(r9)
            int r9 = r9.intValue()
            r0.getClass()
            java.lang.String r0 = s7.h.e(r2, r9)
            r3.setText(r0)
            goto L_0x0227
        L_0x0224:
            hb.h0.J0(r3)
        L_0x0227:
            java.lang.Integer r0 = r1.getBroadcastersCount()
            java.lang.Object r3 = r15.f17665c
            if (r0 == 0) goto L_0x0265
            android.content.SharedPreferences r0 = hb.h0.l1(r2)
            r9 = 1
            boolean r0 = r0.getBoolean(r7, r9)
            if (r0 == 0) goto L_0x0265
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r8, r3)
            r0 = 0
            r3.setVisibility(r0)
            android.content.res.Resources r7 = r2.getResources()
            java.lang.Integer r8 = r1.getBroadcastersCount()
            xa.j.c(r8)
            int r8 = r8.intValue()
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]
            java.lang.Integer r9 = r1.getBroadcastersCount()
            r10[r0] = r9
            r0 = 2131886080(0x7f120000, float:1.9406729E38)
            java.lang.String r0 = r7.getQuantityString(r0, r8, r10)
            r3.setText(r0)
            goto L_0x026d
        L_0x0265:
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r8, r3)
            hb.h0.J0(r3)
        L_0x026d:
            java.util.List r0 = r1.getTags()
            if (r0 == 0) goto L_0x027c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x027a
            goto L_0x027c
        L_0x027a:
            r0 = 0
            goto L_0x027d
        L_0x027c:
            r0 = 1
        L_0x027d:
            java.lang.Object r3 = r15.f17666d
            if (r0 != 0) goto L_0x02cb
            android.content.SharedPreferences r0 = hb.h0.l1(r2)
            r7 = 1
            boolean r0 = r0.getBoolean(r5, r7)
            if (r0 == 0) goto L_0x02cb
            com.google.android.flexbox.FlexboxLayout r3 = (com.google.android.flexbox.FlexboxLayout) r3
            r3.removeAllViews()
            r0 = 0
            r3.setVisibility(r0)
            java.util.List r0 = r1.getTags()
            xa.j.c(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x02a0:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x02d3
            java.lang.Object r5 = r0.next()
            com.github.andreyasadchy.xtra.model.ui.Tag r5 = (com.github.andreyasadchy.xtra.model.ui.Tag) r5
            android.widget.TextView r6 = new android.widget.TextView
            r6.<init>(r2)
            java.lang.String r7 = r5.getName()
            r6.setText(r7)
            java.lang.String r7 = r5.getId()
            if (r7 == 0) goto L_0x02c7
            h6.b r7 = new h6.b
            r8 = 4
            r7.<init>(r4, r8, r5)
            r6.setOnClickListener(r7)
        L_0x02c7:
            r3.addView(r6)
            goto L_0x02a0
        L_0x02cb:
            com.google.android.flexbox.FlexboxLayout r3 = (com.google.android.flexbox.FlexboxLayout) r3
            xa.j.e(r6, r3)
            hb.h0.J0(r3)
        L_0x02d3:
            boolean r0 = r1.getFollowAccount()
            java.lang.Object r2 = r15.f17671i
            android.widget.TextView r2 = (android.widget.TextView) r2
            xa.j.e(r13, r2)
            if (r0 == 0) goto L_0x02e5
            r0 = 0
            r2.setVisibility(r0)
            goto L_0x02e8
        L_0x02e5:
            hb.h0.J0(r2)
        L_0x02e8:
            boolean r0 = r1.getFollowLocal()
            java.lang.Object r1 = r15.f17670h
            android.widget.TextView r1 = (android.widget.TextView) r1
            r3 = r17
            xa.j.e(r3, r1)
            if (r0 == 0) goto L_0x02fc
            r0 = 0
            r1.setVisibility(r0)
            goto L_0x02ff
        L_0x02fc:
            hb.h0.J0(r1)
        L_0x02ff:
            return
        L_0x0300:
            r3 = r12
            r0 = r26
            o6.b r0 = (o6.b) r0
            xa.j.f(r2, r0)
            r4 = r25
            java.lang.Object r1 = r4.a(r1)
            com.github.andreyasadchy.xtra.model.ui.User r1 = (com.github.andreyasadchy.xtra.model.ui.User) r1
            if (r1 == 0) goto L_0x0417
            androidx.fragment.app.c0 r2 = r0.f12239i
            android.content.Context r2 = r2.f0()
            z5.h r5 = r0.f12238h
            android.view.ViewGroup r6 = r5.f17656b
            androidx.cardview.widget.CardView r6 = (androidx.cardview.widget.CardView) r6
            h6.b r7 = new h6.b
            r8 = 3
            r7.<init>(r0, r8, r1)
            r6.setOnClickListener(r7)
            java.lang.String r6 = r1.getChannelLogo()
            android.widget.ImageView r7 = r5.f17655a
            xa.j.e(r15, r7)
            if (r6 == 0) goto L_0x0351
            r6 = 0
            r7.setVisibility(r6)
            androidx.fragment.app.c0 r0 = r0.f12239i
            java.lang.String r19 = r1.getChannelLogo()
            r20 = 0
            r21 = 1
            d5.q r6 = d5.u.f4491a
            xa.j.e(r14, r6)
            r23 = 4
            r17 = r7
            r18 = r0
            r22 = r6
            hb.h0.c1(r17, r18, r19, r20, r21, r22, r23)
            goto L_0x0354
        L_0x0351:
            hb.h0.J0(r7)
        L_0x0354:
            java.lang.String r0 = r1.getChannelName()
            android.view.View r6 = r5.f17662h
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r7 = "username"
            xa.j.e(r7, r6)
            if (r0 == 0) goto L_0x036f
            r0 = 0
            r6.setVisibility(r0)
            java.lang.String r0 = r1.getChannelName()
            r6.setText(r0)
            goto L_0x0372
        L_0x036f:
            hb.h0.J0(r6)
        L_0x0372:
            java.lang.String r0 = r1.getLastBroadcast()
            java.lang.String r6 = "userStream"
            android.view.View r7 = r5.f17661g
            if (r0 == 0) goto L_0x03a8
            java.lang.String r0 = r1.getLastBroadcast()
            if (r0 == 0) goto L_0x038c
            s7.h r8 = s7.h.f14375a
            r8.getClass()
            java.lang.String r0 = s7.h.d(r2, r0)
            goto L_0x038d
        L_0x038c:
            r0 = 0
        L_0x038d:
            if (r0 == 0) goto L_0x03a8
            android.widget.TextView r7 = (android.widget.TextView) r7
            xa.j.e(r6, r7)
            r6 = 0
            r7.setVisibility(r6)
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r9[r6] = r0
            r0 = 2131952066(0x7f1301c2, float:1.9540564E38)
            java.lang.String r0 = r2.getString(r0, r9)
            r7.setText(r0)
            goto L_0x03b0
        L_0x03a8:
            android.widget.TextView r7 = (android.widget.TextView) r7
            xa.j.e(r6, r7)
            hb.h0.J0(r7)
        L_0x03b0:
            java.lang.String r0 = r1.getFollowedAt()
            java.lang.String r6 = "userFollowed"
            android.view.View r7 = r5.f17660f
            if (r0 == 0) goto L_0x03e5
            s7.h r0 = s7.h.f14375a
            java.lang.String r8 = r1.getFollowedAt()
            xa.j.c(r8)
            r0.getClass()
            java.lang.String r0 = s7.h.d(r2, r8)
            if (r0 == 0) goto L_0x03e5
            android.widget.TextView r7 = (android.widget.TextView) r7
            xa.j.e(r6, r7)
            r6 = 0
            r7.setVisibility(r6)
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r6] = r0
            r0 = 2131951850(0x7f1300ea, float:1.9540126E38)
            java.lang.String r0 = r2.getString(r0, r8)
            r7.setText(r0)
            goto L_0x03ed
        L_0x03e5:
            android.widget.TextView r7 = (android.widget.TextView) r7
            xa.j.e(r6, r7)
            hb.h0.J0(r7)
        L_0x03ed:
            boolean r0 = r1.getFollowAccount()
            android.view.View r2 = r5.f17659e
            android.widget.TextView r2 = (android.widget.TextView) r2
            xa.j.e(r13, r2)
            if (r0 == 0) goto L_0x03ff
            r0 = 0
            r2.setVisibility(r0)
            goto L_0x0402
        L_0x03ff:
            hb.h0.J0(r2)
        L_0x0402:
            boolean r0 = r1.getFollowLocal()
            android.view.View r1 = r5.f17658d
            android.widget.TextView r1 = (android.widget.TextView) r1
            xa.j.e(r3, r1)
            if (r0 == 0) goto L_0x0414
            r0 = 0
            r1.setVisibility(r0)
            goto L_0x0417
        L_0x0414:
            hb.h0.J0(r1)
        L_0x0417:
            return
        L_0x0418:
            r0 = r26
            c7.b r0 = (c7.b) r0
            xa.j.f(r2, r0)
            java.lang.Object r1 = r4.a(r1)
            com.github.andreyasadchy.xtra.model.ui.User r1 = (com.github.andreyasadchy.xtra.model.ui.User) r1
            if (r1 == 0) goto L_0x0528
            androidx.fragment.app.c0 r2 = r0.f2976i
            android.content.Context r2 = r2.f0()
            androidx.appcompat.widget.i5 r3 = r0.f2975h
            androidx.cardview.widget.CardView r5 = r3.a()
            h6.b r6 = new h6.b
            r7 = 13
            r6.<init>(r0, r7, r1)
            r5.setOnClickListener(r6)
            java.lang.String r5 = r1.getChannelLogo()
            if (r5 == 0) goto L_0x0465
            java.lang.Object r5 = r3.f879g
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            xa.j.e(r15, r5)
            r6 = 0
            r5.setVisibility(r6)
            java.lang.Object r5 = r3.f879g
            r6 = r5
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            xa.j.e(r15, r6)
            androidx.fragment.app.c0 r7 = r0.f2976i
            java.lang.String r8 = r1.getChannelLogo()
            r9 = 0
            r10 = 1
            r11 = 0
            r12 = 20
            hb.h0.c1(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x046f
        L_0x0465:
            java.lang.Object r0 = r3.f879g
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            xa.j.e(r15, r0)
            hb.h0.J0(r0)
        L_0x046f:
            java.lang.String r0 = r1.getChannelName()
            java.lang.String r5 = "userName"
            if (r0 == 0) goto L_0x048e
            java.lang.Object r0 = r3.f880h
            android.widget.TextView r0 = (android.widget.TextView) r0
            xa.j.e(r5, r0)
            r5 = 0
            r0.setVisibility(r5)
            java.lang.Object r0 = r3.f880h
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r5 = r1.getChannelName()
            r0.setText(r5)
            goto L_0x0498
        L_0x048e:
            java.lang.Object r0 = r3.f880h
            android.widget.TextView r0 = (android.widget.TextView) r0
            xa.j.e(r5, r0)
            hb.h0.J0(r0)
        L_0x0498:
            java.lang.Integer r0 = r1.getFollowersCount()
            java.lang.String r5 = "userFollowers"
            if (r0 == 0) goto L_0x04d0
            java.lang.Object r0 = r3.f878f
            android.widget.TextView r0 = (android.widget.TextView) r0
            xa.j.e(r5, r0)
            r5 = 0
            r0.setVisibility(r5)
            java.lang.Object r0 = r3.f878f
            android.widget.TextView r0 = (android.widget.TextView) r0
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            s7.h r8 = s7.h.f14375a
            java.lang.Integer r9 = r1.getFollowersCount()
            int r9 = r9.intValue()
            r8.getClass()
            java.lang.String r8 = s7.h.a(r2, r9)
            r7[r5] = r8
            r5 = 2131951856(0x7f1300f0, float:1.9540138E38)
            java.lang.String r5 = r2.getString(r5, r7)
            r0.setText(r5)
            goto L_0x04db
        L_0x04d0:
            r6 = 1
            java.lang.Object r0 = r3.f878f
            android.widget.TextView r0 = (android.widget.TextView) r0
            xa.j.e(r5, r0)
            hb.h0.J0(r0)
        L_0x04db:
            java.lang.String r0 = r1.getType()
            if (r0 == 0) goto L_0x04e9
            boolean r0 = fb.w.h(r0)
            if (r0 == 0) goto L_0x04e8
            goto L_0x04e9
        L_0x04e8:
            r6 = 0
        L_0x04e9:
            java.lang.String r0 = "typeText"
            java.lang.Object r3 = r3.f876d
            if (r6 == 0) goto L_0x0505
            java.lang.Boolean r5 = r1.isLive()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r5 = xa.j.a(r5, r6)
            if (r5 == 0) goto L_0x04fc
            goto L_0x0505
        L_0x04fc:
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r0, r3)
            hb.h0.J0(r3)
            goto L_0x0528
        L_0x0505:
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r0, r3)
            r0 = 0
            r3.setVisibility(r0)
            java.lang.String r0 = r1.getType()
            java.lang.String r1 = "rerun"
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x051e
            r0 = 2131952435(0x7f130333, float:1.9541313E38)
            goto L_0x0521
        L_0x051e:
            r0 = 2131952068(0x7f1301c4, float:1.9540568E38)
        L_0x0521:
            java.lang.String r0 = r2.getString(r0)
            r3.setText(r0)
        L_0x0528:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.c.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        ViewGroup viewGroup2 = viewGroup;
        int i11 = this.f12240d;
        int i12 = R.id.twitchText;
        c0 c0Var = this.f12241e;
        switch (i11) {
            case 0:
                j.f("parent", viewGroup2);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_followed_channels_list_item, viewGroup2, false);
                LinearLayout linearLayout = (LinearLayout) e4.a.a(inflate, R.id.layout1);
                if (linearLayout == null) {
                    i12 = R.id.layout1;
                } else if (((LinearLayout) e4.a.a(inflate, R.id.layout2)) != null) {
                    TextView textView = (TextView) e4.a.a(inflate, R.id.localText);
                    if (textView != null) {
                        TextView textView2 = (TextView) e4.a.a(inflate, R.id.twitchText);
                        if (textView2 != null) {
                            i12 = R.id.userFollowed;
                            TextView textView3 = (TextView) e4.a.a(inflate, R.id.userFollowed);
                            if (textView3 != null) {
                                i12 = R.id.userImage;
                                ImageView imageView = (ImageView) e4.a.a(inflate, R.id.userImage);
                                if (imageView != null) {
                                    i12 = R.id.userStream;
                                    TextView textView4 = (TextView) e4.a.a(inflate, R.id.userStream);
                                    if (textView4 != null) {
                                        i12 = R.id.username;
                                        TextView textView5 = (TextView) e4.a.a(inflate, R.id.username);
                                        if (textView5 != null) {
                                            return new b(new h((CardView) inflate, linearLayout, textView, textView2, textView3, imageView, textView4, textView5), c0Var);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        i12 = R.id.localText;
                    }
                } else {
                    i12 = R.id.layout2;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i12)));
            case 1:
                j.f("parent", viewGroup2);
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_followed_games_list_item, viewGroup2, false);
                TextView textView6 = (TextView) e4.a.a(inflate2, R.id.broadcastersCount);
                if (textView6 != null) {
                    ImageView imageView2 = (ImageView) e4.a.a(inflate2, R.id.gameImage);
                    if (imageView2 != null) {
                        TextView textView7 = (TextView) e4.a.a(inflate2, R.id.gameName);
                        if (textView7 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) e4.a.a(inflate2, R.id.layout1);
                            if (linearLayout2 != null) {
                                LinearLayout linearLayout3 = (LinearLayout) e4.a.a(inflate2, R.id.layout2);
                                if (linearLayout3 != null) {
                                    TextView textView8 = (TextView) e4.a.a(inflate2, R.id.localText);
                                    if (textView8 != null) {
                                        FlexboxLayout flexboxLayout = (FlexboxLayout) e4.a.a(inflate2, R.id.tagsLayout);
                                        if (flexboxLayout != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) e4.a.a(inflate2, R.id.topLayout);
                                            if (constraintLayout != null) {
                                                TextView textView9 = (TextView) e4.a.a(inflate2, R.id.twitchText);
                                                if (textView9 != null) {
                                                    i12 = R.id.viewers;
                                                    TextView textView10 = (TextView) e4.a.a(inflate2, R.id.viewers);
                                                    if (textView10 != null) {
                                                        return new b(new i((CardView) inflate2, textView6, imageView2, textView7, linearLayout2, linearLayout3, textView8, flexboxLayout, constraintLayout, textView9, textView10), c0Var);
                                                    }
                                                }
                                            } else {
                                                i12 = R.id.topLayout;
                                            }
                                        } else {
                                            i12 = R.id.tagsLayout;
                                        }
                                    } else {
                                        i12 = R.id.localText;
                                    }
                                } else {
                                    i12 = R.id.layout2;
                                }
                            } else {
                                i12 = R.id.layout1;
                            }
                        } else {
                            i12 = R.id.gameName;
                        }
                    } else {
                        i12 = R.id.gameImage;
                    }
                } else {
                    i12 = R.id.broadcastersCount;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i12)));
            case 2:
                j.f("parent", viewGroup2);
                return new q(i5.b(LayoutInflater.from(viewGroup.getContext()), viewGroup2), c0Var);
            default:
                j.f("parent", viewGroup2);
                return new c7.b(i5.c(LayoutInflater.from(viewGroup.getContext()), viewGroup2), c0Var);
        }
    }
}
