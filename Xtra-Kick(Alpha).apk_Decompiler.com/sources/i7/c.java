package i7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.k2;
import com.github.andreyasadchy.xtra.util.TextWithCanvas;
import com.google.android.flexbox.FlexboxLayout;
import com.woxthebox.draglistview.R;
import e4.a;
import n3.x3;
import q6.f;
import xa.j;
import z5.i;
import z5.k;

public final class c extends x3 {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f8363d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f8364e;

    /* renamed from: f  reason: collision with root package name */
    public final f f8365f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f8366g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(c0 c0Var, int i10) {
        this(c0Var, (f) null, false, 0);
        this.f8363d = i10;
        if (i10 != 1) {
        } else {
            this(c0Var, (f) null, false, 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0232  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r28, int r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r29
            int r5 = r0.f8363d
            java.lang.String r6 = "ui_tags"
            java.lang.String r7 = "tagsLayout"
            java.lang.String r8 = "uptime"
            java.lang.String r9 = "ui_uptime"
            java.lang.String r10 = "type"
            java.lang.String r11 = "viewers"
            java.lang.String r12 = "gameName"
            java.lang.String r13 = ""
            java.lang.String r14 = "title"
            java.lang.String r15 = "username"
            java.lang.String r2 = "userImage"
            java.lang.String r4 = "holder"
            switch(r5) {
                case 0: goto L_0x0027;
                default: goto L_0x0021;
            }
        L_0x0021:
            r0 = r7
            r3 = r9
            r7 = r6
            r6 = r8
            goto L_0x023d
        L_0x0027:
            r5 = r28
            i7.b r5 = (i7.b) r5
            xa.j.f(r4, r5)
            java.lang.Object r1 = r0.a(r1)
            com.github.andreyasadchy.xtra.model.ui.Stream r1 = (com.github.andreyasadchy.xtra.model.ui.Stream) r1
            if (r1 == 0) goto L_0x023c
            androidx.fragment.app.c0 r4 = r5.f8360i
            android.content.Context r4 = r4.f0()
            androidx.lifecycle.u1 r3 = new androidx.lifecycle.u1
            r0 = 20
            r3.<init>(r5, r0, r1)
            j3.m2 r0 = new j3.m2
            r16 = r7
            r7 = 16
            r0.<init>(r5, r4, r1, r7)
            z5.i r7 = r5.f8359h
            r17 = r6
            androidx.cardview.widget.CardView r6 = r7.c()
            r18 = r8
            h6.b r8 = new h6.b
            r19 = r9
            r9 = 14
            r8.<init>(r5, r9, r1)
            r6.setOnClickListener(r8)
            java.lang.String r6 = r1.getChannelLogo()
            java.lang.Object r8 = r7.f17673k
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            xa.j.e(r2, r8)
            if (r6 == 0) goto L_0x0093
            r2 = 0
            r8.setVisibility(r2)
            androidx.fragment.app.c0 r2 = r5.f8360i
            java.lang.String r22 = r1.getChannelLogo()
            r23 = 0
            r24 = 1
            r25 = 0
            r26 = 20
            r20 = r8
            r21 = r2
            hb.h0.c1(r20, r21, r22, r23, r24, r25, r26)
            j6.d r2 = new j6.d
            r6 = 10
            r2.<init>(r6, r3)
            r8.setOnClickListener(r2)
            goto L_0x0096
        L_0x0093:
            hb.h0.J0(r8)
        L_0x0096:
            java.lang.String r2 = r1.getChannelName()
            java.lang.Object r6 = r7.f17670h
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r15, r6)
            if (r2 == 0) goto L_0x00b9
            r2 = 0
            r6.setVisibility(r2)
            java.lang.String r2 = r1.getChannelName()
            r6.setText(r2)
            j6.d r2 = new j6.d
            r8 = 11
            r2.<init>(r8, r3)
            r6.setOnClickListener(r2)
            goto L_0x00bc
        L_0x00b9:
            hb.h0.J0(r6)
        L_0x00bc:
            java.lang.String r2 = r1.getTitle()
            java.lang.Object r3 = r7.f17668f
            if (r2 == 0) goto L_0x00eb
            java.lang.String r2 = r1.getTitle()
            boolean r2 = xa.j.a(r2, r13)
            if (r2 != 0) goto L_0x00eb
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r14, r3)
            r2 = 0
            r3.setVisibility(r2)
            java.lang.String r2 = r1.getTitle()
            if (r2 == 0) goto L_0x00e6
            java.lang.CharSequence r2 = fb.y.R(r2)
            java.lang.String r2 = r2.toString()
            goto L_0x00e7
        L_0x00e6:
            r2 = 0
        L_0x00e7:
            r3.setText(r2)
            goto L_0x00f3
        L_0x00eb:
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r14, r3)
            hb.h0.J0(r3)
        L_0x00f3:
            boolean r2 = r5.f8362k
            java.lang.Object r3 = r7.f17665c
            if (r2 != 0) goto L_0x011a
            java.lang.String r2 = r1.getGameName()
            if (r2 == 0) goto L_0x011a
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r12, r3)
            r2 = 0
            r3.setVisibility(r2)
            java.lang.String r2 = r1.getGameName()
            r3.setText(r2)
            j6.d r2 = new j6.d
            r6 = 12
            r2.<init>(r6, r0)
            r3.setOnClickListener(r2)
            goto L_0x0122
        L_0x011a:
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r12, r3)
            hb.h0.J0(r3)
        L_0x0122:
            java.lang.String r0 = r1.getThumbnailUrl()
            java.lang.String r2 = "thumbnail"
            java.lang.Object r3 = r7.f17667e
            if (r0 == 0) goto L_0x0153
            r0 = r3
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            xa.j.e(r2, r0)
            r2 = 0
            r0.setVisibility(r2)
            androidx.fragment.app.c0 r2 = r5.f8360i
            java.lang.String r22 = r1.getThumbnail()
            r23 = 1
            r24 = 0
            d5.q r3 = d5.u.f4491a
            java.lang.String r6 = "NONE"
            xa.j.e(r6, r3)
            r26 = 8
            r20 = r0
            r21 = r2
            r25 = r3
            hb.h0.c1(r20, r21, r22, r23, r24, r25, r26)
            goto L_0x015b
        L_0x0153:
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            xa.j.e(r2, r3)
            hb.h0.J0(r3)
        L_0x015b:
            java.lang.Integer r0 = r1.getViewerCount()
            java.lang.Object r2 = r7.f17674l
            com.github.andreyasadchy.xtra.util.TextWithCanvas r2 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r2
            xa.j.e(r11, r2)
            if (r0 == 0) goto L_0x0185
            r0 = 0
            r2.setVisibility(r0)
            s7.h r0 = s7.h.f14375a
            java.lang.Integer r3 = r1.getViewerCount()
            if (r3 == 0) goto L_0x0179
            int r3 = r3.intValue()
            goto L_0x017a
        L_0x0179:
            r3 = 0
        L_0x017a:
            r0.getClass()
            java.lang.String r0 = s7.h.e(r4, r3)
            r2.setText(r0)
            goto L_0x0188
        L_0x0185:
            hb.h0.J0(r2)
        L_0x0188:
            r1.getType()
            java.lang.Object r0 = r7.f17671i
            com.github.andreyasadchy.xtra.util.TextWithCanvas r0 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r0
            xa.j.e(r10, r0)
            hb.h0.J0(r0)
            android.content.SharedPreferences r0 = hb.h0.l1(r4)
            r3 = r19
            r2 = 1
            boolean r0 = r0.getBoolean(r3, r2)
            java.lang.Object r2 = r7.f17672j
            if (r0 == 0) goto L_0x01d4
            java.lang.String r0 = r1.getStartedAt()
            if (r0 == 0) goto L_0x01d4
            s7.h r0 = s7.h.f14375a
            java.lang.String r3 = r1.getStartedAt()
            r0.getClass()
            java.lang.String r0 = s7.h.j(r4, r3)
            if (r0 == 0) goto L_0x01d4
            com.github.andreyasadchy.xtra.util.TextWithCanvas r2 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r2
            r6 = r18
            xa.j.e(r6, r2)
            r3 = 0
            r2.setVisibility(r3)
            r6 = 1
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r8[r3] = r0
            r0 = 2131952414(0x7f13031e, float:1.954127E38)
            java.lang.String r0 = r4.getString(r0, r8)
            r2.setText(r0)
            goto L_0x01de
        L_0x01d4:
            r6 = r18
            com.github.andreyasadchy.xtra.util.TextWithCanvas r2 = (com.github.andreyasadchy.xtra.util.TextWithCanvas) r2
            xa.j.e(r6, r2)
            hb.h0.J0(r2)
        L_0x01de:
            java.util.List r0 = r1.getTags()
            if (r0 == 0) goto L_0x01ed
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01eb
            goto L_0x01ed
        L_0x01eb:
            r0 = 0
            goto L_0x01ee
        L_0x01ed:
            r0 = 1
        L_0x01ee:
            java.lang.Object r2 = r7.f17666d
            if (r0 != 0) goto L_0x0232
            android.content.SharedPreferences r0 = hb.h0.l1(r4)
            r7 = r17
            r3 = 1
            boolean r0 = r0.getBoolean(r7, r3)
            if (r0 == 0) goto L_0x0232
            com.google.android.flexbox.FlexboxLayout r2 = (com.google.android.flexbox.FlexboxLayout) r2
            r2.removeAllViews()
            r0 = 0
            r2.setVisibility(r0)
            java.util.List r0 = r1.getTags()
            java.util.Iterator r0 = r0.iterator()
        L_0x0210:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x023c
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            android.widget.TextView r6 = new android.widget.TextView
            r6.<init>(r4)
            r6.setText(r3)
            h6.d r7 = new h6.d
            r8 = 16
            r7.<init>(r5, r1, r3, r8)
            r6.setOnClickListener(r7)
            r2.addView(r6)
            goto L_0x0210
        L_0x0232:
            com.google.android.flexbox.FlexboxLayout r2 = (com.google.android.flexbox.FlexboxLayout) r2
            r0 = r16
            xa.j.e(r0, r2)
            hb.h0.J0(r2)
        L_0x023c:
            return
        L_0x023d:
            r5 = r28
            i7.e r5 = (i7.e) r5
            xa.j.f(r4, r5)
            r4 = r27
            java.lang.Object r1 = r4.a(r1)
            com.github.andreyasadchy.xtra.model.ui.Stream r1 = (com.github.andreyasadchy.xtra.model.ui.Stream) r1
            if (r1 == 0) goto L_0x040d
            androidx.fragment.app.c0 r8 = r5.f8369i
            android.content.Context r8 = r8.f0()
            androidx.lifecycle.u1 r9 = new androidx.lifecycle.u1
            r4 = 21
            r9.<init>(r5, r4, r1)
            j3.m2 r4 = new j3.m2
            r16 = r0
            r0 = 17
            r4.<init>(r5, r8, r1, r0)
            z5.k r0 = r5.f8368h
            r17 = r7
            java.lang.Object r7 = r0.f17684a
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            r18 = r6
            h6.b r6 = new h6.b
            r19 = r3
            r3 = 15
            r6.<init>(r5, r3, r1)
            r7.setOnClickListener(r6)
            java.lang.String r6 = r1.getChannelLogo()
            java.lang.Object r7 = r0.f17695l
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            xa.j.e(r2, r7)
            if (r6 == 0) goto L_0x02ab
            r2 = 0
            r7.setVisibility(r2)
            androidx.fragment.app.c0 r2 = r5.f8369i
            java.lang.String r22 = r1.getChannelLogo()
            r23 = 0
            r24 = 1
            r25 = 0
            r26 = 20
            r20 = r7
            r21 = r2
            hb.h0.c1(r20, r21, r22, r23, r24, r25, r26)
            j6.d r2 = new j6.d
            r6 = 13
            r2.<init>(r6, r9)
            r7.setOnClickListener(r2)
            goto L_0x02ae
        L_0x02ab:
            hb.h0.J0(r7)
        L_0x02ae:
            java.lang.String r2 = r1.getChannelName()
            java.lang.Object r6 = r0.f17689f
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r15, r6)
            if (r2 == 0) goto L_0x02d1
            r2 = 0
            r6.setVisibility(r2)
            java.lang.String r2 = r1.getChannelName()
            r6.setText(r2)
            j6.d r2 = new j6.d
            r7 = 14
            r2.<init>(r7, r9)
            r6.setOnClickListener(r2)
            goto L_0x02d4
        L_0x02d1:
            hb.h0.J0(r6)
        L_0x02d4:
            java.lang.String r2 = r1.getTitle()
            java.lang.Object r6 = r0.f17686c
            if (r2 == 0) goto L_0x0303
            java.lang.String r2 = r1.getTitle()
            boolean r2 = xa.j.a(r2, r13)
            if (r2 != 0) goto L_0x0303
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r14, r6)
            r2 = 0
            r6.setVisibility(r2)
            java.lang.String r2 = r1.getTitle()
            if (r2 == 0) goto L_0x02fe
            java.lang.CharSequence r2 = fb.y.R(r2)
            java.lang.String r2 = r2.toString()
            goto L_0x02ff
        L_0x02fe:
            r2 = 0
        L_0x02ff:
            r6.setText(r2)
            goto L_0x030b
        L_0x0303:
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r14, r6)
            hb.h0.J0(r6)
        L_0x030b:
            boolean r2 = r5.f8371k
            java.lang.Object r6 = r0.f17685b
            if (r2 != 0) goto L_0x0330
            java.lang.String r2 = r1.getGameName()
            if (r2 == 0) goto L_0x0330
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r12, r6)
            r2 = 0
            r6.setVisibility(r2)
            java.lang.String r2 = r1.getGameName()
            r6.setText(r2)
            j6.d r2 = new j6.d
            r2.<init>(r3, r4)
            r6.setOnClickListener(r2)
            goto L_0x0338
        L_0x0330:
            android.widget.TextView r6 = (android.widget.TextView) r6
            xa.j.e(r12, r6)
            hb.h0.J0(r6)
        L_0x0338:
            java.lang.Integer r2 = r1.getViewerCount()
            java.lang.Object r3 = r0.f17690g
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r11, r3)
            if (r2 == 0) goto L_0x0362
            r2 = 0
            r3.setVisibility(r2)
            s7.h r2 = s7.h.f14375a
            java.lang.Integer r4 = r1.getViewerCount()
            if (r4 == 0) goto L_0x0356
            int r4 = r4.intValue()
            goto L_0x0357
        L_0x0356:
            r4 = 0
        L_0x0357:
            r2.getClass()
            java.lang.String r2 = s7.h.a(r8, r4)
            r3.setText(r2)
            goto L_0x0365
        L_0x0362:
            hb.h0.J0(r3)
        L_0x0365:
            r1.getType()
            java.lang.Object r2 = r0.f17687d
            android.widget.TextView r2 = (android.widget.TextView) r2
            xa.j.e(r10, r2)
            hb.h0.J0(r2)
            android.content.SharedPreferences r2 = hb.h0.l1(r8)
            r4 = r19
            r3 = 1
            boolean r2 = r2.getBoolean(r4, r3)
            java.lang.Object r3 = r0.f17688e
            if (r2 == 0) goto L_0x03a5
            java.lang.String r2 = r1.getStartedAt()
            if (r2 == 0) goto L_0x03a5
            s7.h r2 = s7.h.f14375a
            java.lang.String r4 = r1.getStartedAt()
            r2.getClass()
            java.lang.String r2 = s7.h.j(r8, r4)
            if (r2 == 0) goto L_0x03a5
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = r18
            xa.j.e(r4, r3)
            r4 = 0
            r3.setVisibility(r4)
            r3.setText(r2)
            goto L_0x03af
        L_0x03a5:
            r4 = r18
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r4, r3)
            hb.h0.J0(r3)
        L_0x03af:
            java.util.List r2 = r1.getTags()
            if (r2 == 0) goto L_0x03be
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03bc
            goto L_0x03be
        L_0x03bc:
            r2 = 0
            goto L_0x03bf
        L_0x03be:
            r2 = 1
        L_0x03bf:
            java.lang.Object r0 = r0.f17693j
            if (r2 != 0) goto L_0x0403
            android.content.SharedPreferences r2 = hb.h0.l1(r8)
            r4 = r17
            r3 = 1
            boolean r2 = r2.getBoolean(r4, r3)
            if (r2 == 0) goto L_0x0403
            com.google.android.flexbox.FlexboxLayout r0 = (com.google.android.flexbox.FlexboxLayout) r0
            r0.removeAllViews()
            r2 = 0
            r0.setVisibility(r2)
            java.util.List r2 = r1.getTags()
            java.util.Iterator r2 = r2.iterator()
        L_0x03e1:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x040d
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            android.widget.TextView r4 = new android.widget.TextView
            r4.<init>(r8)
            r4.setText(r3)
            h6.d r6 = new h6.d
            r7 = 17
            r6.<init>(r5, r1, r3, r7)
            r4.setOnClickListener(r6)
            r0.addView(r4)
            goto L_0x03e1
        L_0x0403:
            com.google.android.flexbox.FlexboxLayout r0 = (com.google.android.flexbox.FlexboxLayout) r0
            r1 = r16
            xa.j.e(r1, r0)
            hb.h0.J0(r0)
        L_0x040d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.c.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        int i11;
        int i12;
        ViewGroup viewGroup2 = viewGroup;
        boolean z10 = this.f8366g;
        f fVar = this.f8365f;
        c0 c0Var = this.f8364e;
        switch (this.f8363d) {
            case 0:
                j.f("parent", viewGroup2);
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_streams_list_item, viewGroup2, false);
                TextView textView = (TextView) a.a(inflate, R.id.gameName);
                if (textView != null) {
                    FlexboxLayout flexboxLayout = (FlexboxLayout) a.a(inflate, R.id.tagsLayout);
                    if (flexboxLayout != null) {
                        ImageView imageView = (ImageView) a.a(inflate, R.id.thumbnail);
                        if (imageView != null) {
                            TextView textView2 = (TextView) a.a(inflate, R.id.title);
                            if (textView2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) a.a(inflate, R.id.topLayout);
                                if (constraintLayout != null) {
                                    TextWithCanvas textWithCanvas = (TextWithCanvas) a.a(inflate, R.id.type);
                                    if (textWithCanvas != null) {
                                        TextWithCanvas textWithCanvas2 = (TextWithCanvas) a.a(inflate, R.id.uptime);
                                        if (textWithCanvas2 != null) {
                                            ImageView imageView2 = (ImageView) a.a(inflate, R.id.userImage);
                                            if (imageView2 != null) {
                                                TextView textView3 = (TextView) a.a(inflate, R.id.username);
                                                if (textView3 != null) {
                                                    TextWithCanvas textWithCanvas3 = (TextWithCanvas) a.a(inflate, R.id.viewers);
                                                    if (textWithCanvas3 != null) {
                                                        return new b(new i((CardView) inflate, textView, flexboxLayout, imageView, textView2, constraintLayout, textWithCanvas, textWithCanvas2, imageView2, textView3, textWithCanvas3), c0Var, fVar, z10);
                                                    }
                                                    i12 = R.id.viewers;
                                                } else {
                                                    i12 = R.id.username;
                                                }
                                            } else {
                                                i12 = R.id.userImage;
                                            }
                                        } else {
                                            i12 = R.id.uptime;
                                        }
                                    } else {
                                        i12 = R.id.type;
                                    }
                                } else {
                                    i12 = R.id.topLayout;
                                }
                            } else {
                                i12 = R.id.title;
                            }
                        } else {
                            i12 = R.id.thumbnail;
                        }
                    } else {
                        i12 = R.id.tagsLayout;
                    }
                } else {
                    i12 = R.id.gameName;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i12)));
            default:
                j.f("parent", viewGroup2);
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_streams_list_item_compact, viewGroup2, false);
                TextView textView4 = (TextView) a.a(inflate2, R.id.gameName);
                if (textView4 != null) {
                    LinearLayout linearLayout = (LinearLayout) a.a(inflate2, R.id.layout1);
                    if (linearLayout != null) {
                        LinearLayout linearLayout2 = (LinearLayout) a.a(inflate2, R.id.layout2);
                        if (linearLayout2 != null) {
                            FlexboxLayout flexboxLayout2 = (FlexboxLayout) a.a(inflate2, R.id.tagsLayout);
                            if (flexboxLayout2 != null) {
                                TextView textView5 = (TextView) a.a(inflate2, R.id.title);
                                if (textView5 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) a.a(inflate2, R.id.topLayout);
                                    if (constraintLayout2 != null) {
                                        TextView textView6 = (TextView) a.a(inflate2, R.id.type);
                                        if (textView6 != null) {
                                            TextView textView7 = (TextView) a.a(inflate2, R.id.uptime);
                                            if (textView7 != null) {
                                                ImageView imageView3 = (ImageView) a.a(inflate2, R.id.userImage);
                                                if (imageView3 != null) {
                                                    TextView textView8 = (TextView) a.a(inflate2, R.id.username);
                                                    if (textView8 != null) {
                                                        i11 = R.id.viewers;
                                                        TextView textView9 = (TextView) a.a(inflate2, R.id.viewers);
                                                        if (textView9 != null) {
                                                            return new e(new k((CardView) inflate2, textView4, linearLayout, linearLayout2, flexboxLayout2, textView5, constraintLayout2, textView6, textView7, imageView3, textView8, textView9), c0Var, fVar, z10);
                                                        }
                                                    } else {
                                                        i11 = R.id.username;
                                                    }
                                                } else {
                                                    i11 = R.id.userImage;
                                                }
                                            } else {
                                                i11 = R.id.uptime;
                                            }
                                        } else {
                                            i11 = R.id.type;
                                        }
                                    } else {
                                        i11 = R.id.topLayout;
                                    }
                                } else {
                                    i11 = R.id.title;
                                }
                            } else {
                                i11 = R.id.tagsLayout;
                            }
                        } else {
                            i11 = R.id.layout2;
                        }
                    } else {
                        i11 = R.id.layout1;
                    }
                } else {
                    i11 = R.id.gameName;
                }
                throw new NullPointerException("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i11)));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, f fVar, boolean z10, int i10) {
        super(new a());
        this.f8363d = i10;
        if (i10 != 1) {
            j.f("fragment", c0Var);
            this.f8364e = c0Var;
            this.f8365f = fVar;
            this.f8366g = z10;
            return;
        }
        j.f("fragment", c0Var);
        super(new d());
        this.f8364e = c0Var;
        this.f8365f = fVar;
        this.f8366g = z10;
    }
}
