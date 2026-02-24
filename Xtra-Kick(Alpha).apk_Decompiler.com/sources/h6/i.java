package h6;

import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import wa.l;
import xa.k;

public final class i extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7662h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChannelPagerFragment f7663i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(ChannelPagerFragment channelPagerFragment, int i10) {
        super(1);
        this.f7662h = i10;
        this.f7663i = channelPagerFragment;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x020c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.f7662h
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment r9 = r0.f7663i
            switch(r1) {
                case 0: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x02c0
        L_0x000b:
            r1 = r18
            com.github.andreyasadchy.xtra.model.ui.Stream r1 = (com.github.andreyasadchy.xtra.model.ui.Stream) r1
            z5.e r10 = r9.f3335o0
            xa.j.c(r10)
            androidx.fragment.app.f0 r2 = r9.d0()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r2 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r2
            if (r1 == 0) goto L_0x002e
            java.lang.String r3 = r1.getType()
            if (r3 == 0) goto L_0x002e
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r4 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            xa.j.e(r4, r3)
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            java.lang.String r4 = "rerun"
            boolean r3 = xa.j.a(r3, r4)
            r12 = 1
            r13 = 0
            android.widget.TextView r4 = r10.f17636u
            if (r3 == 0) goto L_0x004b
            r3 = 2131952454(0x7f130346, float:1.9541351E38)
            java.lang.String r3 = r9.z(r3)
            r4.setText(r3)
            h6.e r3 = new h6.e
            r3.<init>(r2, r1, r13)
            goto L_0x0064
        L_0x004b:
            if (r1 == 0) goto L_0x0052
            java.lang.Integer r3 = r1.getViewerCount()
            goto L_0x0053
        L_0x0052:
            r3 = 0
        L_0x0053:
            if (r3 == 0) goto L_0x0068
            r3 = 2131952453(0x7f130345, float:1.954135E38)
            java.lang.String r3 = r9.z(r3)
            r4.setText(r3)
            h6.e r3 = new h6.e
            r3.<init>(r2, r1, r12)
        L_0x0064:
            r4.setOnClickListener(r3)
            goto L_0x00b2
        L_0x0068:
            if (r1 == 0) goto L_0x0075
            com.github.andreyasadchy.xtra.model.ui.User r2 = r1.getUser()
            if (r2 == 0) goto L_0x0075
            java.lang.String r2 = r2.getLastBroadcast()
            goto L_0x0076
        L_0x0075:
            r2 = 0
        L_0x0076:
            if (r2 == 0) goto L_0x00b2
            s7.h r2 = s7.h.f14375a
            android.content.Context r3 = r9.f0()
            com.github.andreyasadchy.xtra.model.ui.User r4 = r1.getUser()
            java.lang.String r4 = r4.getLastBroadcast()
            xa.j.c(r4)
            r2.getClass()
            java.lang.String r2 = s7.h.d(r3, r4)
            java.lang.String r3 = "lastBroadcast"
            android.widget.TextView r4 = r10.f17621f
            xa.j.e(r3, r4)
            if (r2 == 0) goto L_0x00af
            r4.setVisibility(r13)
            android.content.Context r3 = r9.f0()
            java.lang.Object[] r5 = new java.lang.Object[r12]
            r5[r13] = r2
            r2 = 2131952066(0x7f1301c2, float:1.9540564E38)
            java.lang.String r2 = r3.getString(r2, r5)
            r4.setText(r2)
            goto L_0x00b2
        L_0x00af:
            hb.h0.J0(r4)
        L_0x00b2:
            if (r1 == 0) goto L_0x00ba
            java.lang.String r2 = r1.getChannelLogo()
            r14 = r2
            goto L_0x00bb
        L_0x00ba:
            r14 = 0
        L_0x00bb:
            java.lang.String r15 = "userLayout"
            java.lang.String r2 = "userImage"
            androidx.constraintlayout.widget.ConstraintLayout r8 = r10.f17632q
            android.widget.ImageView r3 = r10.f17631p
            if (r14 == 0) goto L_0x00e9
            xa.j.e(r15, r8)
            r8.setVisibility(r13)
            xa.j.e(r2, r3)
            r3.setVisibility(r13)
            r5 = 0
            r6 = 1
            r7 = 0
            r16 = 20
            r2 = r3
            r3 = r9
            r4 = r14
            r11 = r8
            r8 = r16
            hb.h0.c1(r2, r3, r4, r5, r6, r7, r8)
            android.os.Bundle r2 = r9.e0()
            java.lang.String r3 = "channelLogo"
            r2.putString(r3, r14)
            goto L_0x00f0
        L_0x00e9:
            r11 = r8
            xa.j.e(r2, r3)
            hb.h0.J0(r3)
        L_0x00f0:
            if (r1 == 0) goto L_0x00f7
            java.lang.String r2 = r1.getChannelName()
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            if (r2 == 0) goto L_0x0122
            h6.q r3 = r9.r0()
            java.lang.String r3 = r3.f7682c
            boolean r3 = xa.j.a(r2, r3)
            if (r3 != 0) goto L_0x0122
            xa.j.e(r15, r11)
            r11.setVisibility(r13)
            java.lang.String r3 = "userName"
            android.widget.TextView r4 = r10.f17633r
            xa.j.e(r3, r4)
            r4.setVisibility(r13)
            r4.setText(r2)
            android.os.Bundle r3 = r9.e0()
            java.lang.String r4 = "channelName"
            r3.putString(r4, r2)
        L_0x0122:
            if (r1 == 0) goto L_0x0129
            java.lang.String r2 = r1.getChannelSlug()
            goto L_0x012a
        L_0x0129:
            r2 = 0
        L_0x012a:
            if (r2 == 0) goto L_0x0141
            h6.q r3 = r9.r0()
            java.lang.String r3 = r3.f7681b
            boolean r3 = xa.j.a(r2, r3)
            if (r3 != 0) goto L_0x0141
            android.os.Bundle r3 = r9.e0()
            java.lang.String r4 = "channelLogin"
            r3.putString(r4, r2)
        L_0x0141:
            if (r1 == 0) goto L_0x014c
            int r2 = r1.getId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x014d
        L_0x014c:
            r2 = 0
        L_0x014d:
            if (r2 == 0) goto L_0x0168
            h6.q r3 = r9.r0()
            int r3 = r3.f7685f
            int r4 = r2.intValue()
            if (r4 == r3) goto L_0x0168
            android.os.Bundle r3 = r9.e0()
            java.lang.String r4 = "streamId"
            int r2 = r2.intValue()
            r3.putInt(r4, r2)
        L_0x0168:
            if (r1 == 0) goto L_0x016f
            java.lang.String r2 = r1.getTitle()
            goto L_0x0170
        L_0x016f:
            r2 = 0
        L_0x0170:
            if (r2 == 0) goto L_0x017b
            boolean r2 = fb.w.h(r2)
            if (r2 == 0) goto L_0x0179
            goto L_0x017b
        L_0x0179:
            r2 = 0
            goto L_0x017c
        L_0x017b:
            r2 = 1
        L_0x017c:
            java.lang.String r3 = "title"
            java.lang.String r8 = "streamLayout"
            android.widget.TextView r4 = r10.f17626k
            androidx.constraintlayout.widget.ConstraintLayout r11 = r10.f17625j
            if (r2 != 0) goto L_0x01a8
            xa.j.e(r8, r11)
            r11.setVisibility(r13)
            xa.j.e(r3, r4)
            r4.setVisibility(r13)
            if (r1 == 0) goto L_0x01a3
            java.lang.String r2 = r1.getTitle()
            if (r2 == 0) goto L_0x01a3
            java.lang.CharSequence r2 = fb.y.R(r2)
            java.lang.String r2 = r2.toString()
            goto L_0x01a4
        L_0x01a3:
            r2 = 0
        L_0x01a4:
            r4.setText(r2)
            goto L_0x01ae
        L_0x01a8:
            xa.j.e(r3, r4)
            hb.h0.J0(r4)
        L_0x01ae:
            if (r1 == 0) goto L_0x01b5
            java.lang.String r2 = r1.getGameName()
            goto L_0x01b6
        L_0x01b5:
            r2 = 0
        L_0x01b6:
            if (r2 == 0) goto L_0x01c1
            boolean r2 = fb.w.h(r2)
            if (r2 == 0) goto L_0x01bf
            goto L_0x01c1
        L_0x01bf:
            r2 = 0
            goto L_0x01c2
        L_0x01c1:
            r2 = 1
        L_0x01c2:
            java.lang.String r3 = "gameName"
            android.widget.TextView r14 = r10.f17620e
            if (r2 != 0) goto L_0x01f8
            xa.j.e(r8, r11)
            r11.setVisibility(r13)
            xa.j.e(r3, r14)
            r14.setVisibility(r13)
            if (r1 == 0) goto L_0x01db
            java.lang.String r2 = r1.getGameName()
            goto L_0x01dc
        L_0x01db:
            r2 = 0
        L_0x01dc:
            r14.setText(r2)
            if (r1 == 0) goto L_0x01fe
            int r4 = r1.getGameId()
            java.lang.String r5 = r1.getGameSlug()
            if (r5 == 0) goto L_0x01fe
            h6.f r15 = new h6.f
            r7 = 0
            r2 = r15
            r3 = r9
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            r14.setOnClickListener(r15)
            goto L_0x01fe
        L_0x01f8:
            xa.j.e(r3, r14)
            hb.h0.J0(r14)
        L_0x01fe:
            if (r1 == 0) goto L_0x0205
            java.lang.Integer r2 = r1.getViewerCount()
            goto L_0x0206
        L_0x0205:
            r2 = 0
        L_0x0206:
            java.lang.String r3 = "viewers"
            android.widget.TextView r4 = r10.f17635t
            if (r2 == 0) goto L_0x0235
            xa.j.e(r8, r11)
            r11.setVisibility(r13)
            xa.j.e(r3, r4)
            r4.setVisibility(r13)
            s7.h r2 = s7.h.f14375a
            android.content.Context r3 = r9.f0()
            java.lang.Integer r5 = r1.getViewerCount()
            if (r5 == 0) goto L_0x0229
            int r5 = r5.intValue()
            goto L_0x022a
        L_0x0229:
            r5 = 0
        L_0x022a:
            r2.getClass()
            java.lang.String r2 = s7.h.e(r3, r5)
            r4.setText(r2)
            goto L_0x023b
        L_0x0235:
            xa.j.e(r3, r4)
            hb.h0.J0(r4)
        L_0x023b:
            android.content.Context r2 = r9.f0()
            android.content.SharedPreferences r2 = hb.h0.l1(r2)
            java.lang.String r3 = "ui_uptime"
            boolean r2 = r2.getBoolean(r3, r12)
            if (r2 == 0) goto L_0x0291
            if (r1 == 0) goto L_0x0252
            java.lang.String r2 = r1.getStartedAt()
            goto L_0x0253
        L_0x0252:
            r2 = 0
        L_0x0253:
            if (r2 == 0) goto L_0x0291
            s7.h r2 = s7.h.f14375a
            android.content.Context r3 = r9.f0()
            java.lang.String r4 = r1.getStartedAt()
            r2.getClass()
            java.lang.String r2 = s7.h.j(r3, r4)
            java.lang.String r3 = "uptime"
            android.widget.TextView r4 = r10.f17628m
            if (r2 == 0) goto L_0x028b
            xa.j.e(r8, r11)
            r11.setVisibility(r13)
            xa.j.e(r3, r4)
            r4.setVisibility(r13)
            android.content.Context r3 = r9.f0()
            java.lang.Object[] r5 = new java.lang.Object[r12]
            r5[r13] = r2
            r2 = 2131952414(0x7f13031e, float:1.954127E38)
            java.lang.String r2 = r3.getString(r2, r5)
            r4.setText(r2)
            goto L_0x0291
        L_0x028b:
            xa.j.e(r3, r4)
            hb.h0.J0(r4)
        L_0x0291:
            if (r1 == 0) goto L_0x0298
            com.github.andreyasadchy.xtra.model.ui.User r2 = r1.getUser()
            goto L_0x0299
        L_0x0298:
            r2 = 0
        L_0x0299:
            if (r2 == 0) goto L_0x02a3
            com.github.andreyasadchy.xtra.model.ui.User r1 = r1.getUser()
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment.q0(r9, r1)
            goto L_0x02bd
        L_0x02a3:
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel r1 = r9.s0()
            androidx.lifecycle.o0 r2 = r1.f3346l
            boolean r2 = r2.e()
            if (r2 != 0) goto L_0x02bd
            hb.f0 r2 = hb.h0.I0(r1)
            h6.x r3 = new h6.x
            r4 = 0
            r3.<init>(r1, r4)
            r1 = 3
            hb.h0.b1(r2, r4, r13, r3, r1)
        L_0x02bd:
            la.v r1 = la.v.f9814a
            return r1
        L_0x02c0:
            r1 = r18
            com.github.andreyasadchy.xtra.model.ui.User r1 = (com.github.andreyasadchy.xtra.model.ui.User) r1
            if (r1 == 0) goto L_0x02c9
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment.q0(r9, r1)
        L_0x02c9:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.i.invoke(java.lang.Object):java.lang.Object");
    }
}
