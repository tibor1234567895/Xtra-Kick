package a7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.c0;
import androidx.lifecycle.u1;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.w0;
import com.github.andreyasadchy.xtra.util.TextWithCanvas;
import com.woxthebox.draglistview.R;
import e4.a;
import wa.l;
import xa.j;
import z5.g;

public final class d extends w0 {

    /* renamed from: b  reason: collision with root package name */
    public final c0 f275b;

    /* renamed from: c  reason: collision with root package name */
    public final l f276c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c0 c0Var, u1 u1Var) {
        super(new a());
        j.f("fragment", c0Var);
        this.f275b = c0Var;
        this.f276c = u1Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02b5, code lost:
        if (r0 != false) goto L_0x02b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r23, int r24) {
        /*
            r22 = this;
            r0 = r23
            a7.c r0 = (a7.c) r0
            java.lang.String r1 = "holder"
            xa.j.f(r1, r0)
            r1 = r22
            androidx.recyclerview.widget.h r2 = r1.f2224a
            java.util.List r2 = r2.f2038f
            r3 = r24
            java.lang.Object r2 = r2.get(r3)
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r2 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r2
            if (r2 == 0) goto L_0x032d
            androidx.fragment.app.c0 r3 = r0.f273i
            android.content.Context r3 = r3.f0()
            androidx.lifecycle.u1 r4 = new androidx.lifecycle.u1
            r5 = 17
            r4.<init>(r0, r5, r2)
            j3.m2 r5 = new j3.m2
            r6 = 15
            r5.<init>(r0, r3, r2, r6)
            z5.g r6 = r0.f272h
            androidx.cardview.widget.CardView r7 = r6.f17640a
            h6.b r8 = new h6.b
            r9 = 11
            r8.<init>(r0, r9, r2)
            r7.setOnClickListener(r8)
            a7.b r7 = new a7.b
            a7.d r8 = r0.f274j
            r9 = 0
            r7.<init>(r8, r2, r9)
            androidx.cardview.widget.CardView r10 = r6.f17640a
            r10.setOnLongClickListener(r7)
            java.lang.String r7 = "thumbnail"
            android.widget.ImageView r10 = r6.f17650k
            xa.j.e(r7, r10)
            androidx.fragment.app.c0 r11 = r0.f273i
            java.lang.String r12 = r2.getThumbnail()
            r13 = 0
            r14 = 0
            d5.q r7 = d5.u.f4491a
            java.lang.String r15 = "NONE"
            xa.j.e(r15, r7)
            r16 = 12
            r15 = r7
            hb.h0.c1(r10, r11, r12, r13, r14, r15, r16)
            java.lang.Long r10 = r2.getUploadDate()
            java.lang.String r11 = "date"
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = r6.f17641b
            xa.j.e(r11, r12)
            r11 = 1
            if (r10 == 0) goto L_0x0095
            r12.setVisibility(r9)
            java.lang.Object[] r10 = new java.lang.Object[r11]
            s7.h r13 = s7.h.f14375a
            java.lang.Long r14 = r2.getUploadDate()
            long r14 = r14.longValue()
            r13.getClass()
            java.lang.String r13 = s7.h.c(r3, r14)
            r10[r9] = r13
            r13 = 2131952413(0x7f13031d, float:1.9541268E38)
            java.lang.String r10 = r3.getString(r13, r10)
            r12.setText(r10)
            goto L_0x0098
        L_0x0095:
            hb.h0.J0(r12)
        L_0x0098:
            java.lang.Long r10 = r2.getDownloadDate()
            java.lang.String r12 = "downloadDate"
            com.github.andreyasadchy.xtra.util.TextWithCanvas r13 = r6.f17642c
            xa.j.e(r12, r13)
            if (r10 == 0) goto L_0x00c8
            r13.setVisibility(r9)
            java.lang.Object[] r10 = new java.lang.Object[r11]
            s7.h r12 = s7.h.f14375a
            java.lang.Long r14 = r2.getDownloadDate()
            long r14 = r14.longValue()
            r12.getClass()
            java.lang.String r12 = s7.h.c(r3, r14)
            r10[r9] = r12
            r12 = 2131951760(0x7f130090, float:1.9539944E38)
            java.lang.String r10 = r3.getString(r12, r10)
            r13.setText(r10)
            goto L_0x00cb
        L_0x00c8:
            hb.h0.J0(r13)
        L_0x00cb:
            r2.getType()
            java.lang.String r10 = "type"
            com.github.andreyasadchy.xtra.util.TextWithCanvas r12 = r6.f17652m
            xa.j.e(r10, r12)
            hb.h0.J0(r12)
            java.lang.String r10 = r2.getChannelLogo()
            java.lang.String r13 = "userImage"
            android.widget.ImageView r14 = r6.f17653n
            xa.j.e(r13, r14)
            if (r10 == 0) goto L_0x0106
            r14.setVisibility(r9)
            androidx.fragment.app.c0 r0 = r0.f273i
            java.lang.String r17 = r2.getChannelLogo()
            r18 = 0
            r19 = 1
            r21 = 4
            r15 = r14
            r16 = r0
            r20 = r7
            hb.h0.c1(r15, r16, r17, r18, r19, r20, r21)
            j6.d r0 = new j6.d
            r7 = 7
            r0.<init>(r7, r4)
            r14.setOnClickListener(r0)
            goto L_0x0109
        L_0x0106:
            hb.h0.J0(r14)
        L_0x0109:
            java.lang.String r0 = r2.getChannelName()
            java.lang.String r7 = "username"
            android.widget.TextView r10 = r6.f17654o
            xa.j.e(r7, r10)
            if (r0 == 0) goto L_0x012b
            r10.setVisibility(r9)
            java.lang.String r0 = r2.getChannelName()
            r10.setText(r0)
            j6.d r0 = new j6.d
            r7 = 8
            r0.<init>(r7, r4)
            r10.setOnClickListener(r0)
            goto L_0x012e
        L_0x012b:
            hb.h0.J0(r10)
        L_0x012e:
            java.lang.String r0 = r2.getName()
            java.lang.String r4 = "title"
            android.widget.TextView r7 = r6.f17651l
            xa.j.e(r4, r7)
            if (r0 == 0) goto L_0x014e
            r7.setVisibility(r9)
            java.lang.String r0 = r2.getName()
            java.lang.CharSequence r0 = fb.y.R(r0)
            java.lang.String r0 = r0.toString()
            r7.setText(r0)
            goto L_0x0151
        L_0x014e:
            hb.h0.J0(r7)
        L_0x0151:
            java.lang.String r0 = r2.getGameName()
            java.lang.String r4 = "gameName"
            android.widget.TextView r7 = r6.f17644e
            xa.j.e(r4, r7)
            if (r0 == 0) goto L_0x0173
            r7.setVisibility(r9)
            java.lang.String r0 = r2.getGameName()
            r7.setText(r0)
            j6.d r0 = new j6.d
            r4 = 9
            r0.<init>(r4, r5)
            r7.setOnClickListener(r0)
            goto L_0x0176
        L_0x0173:
            hb.h0.J0(r7)
        L_0x0176:
            java.lang.Long r0 = r2.getDuration()
            java.lang.String r4 = "duration"
            java.lang.String r5 = "sourceEnd"
            java.lang.String r7 = "sourceStart"
            com.github.andreyasadchy.xtra.util.TextWithCanvas r10 = r6.f17643d
            android.widget.ProgressBar r13 = r6.f17646g
            com.github.andreyasadchy.xtra.util.TextWithCanvas r14 = r6.f17648i
            com.github.andreyasadchy.xtra.util.TextWithCanvas r15 = r6.f17647h
            if (r0 == 0) goto L_0x0249
            xa.j.e(r4, r10)
            r10.setVisibility(r9)
            java.lang.Long r0 = r2.getDuration()
            long r16 = r0.longValue()
            r18 = 1000(0x3e8, double:4.94E-321)
            long r16 = r16 / r18
            java.lang.String r0 = android.text.format.DateUtils.formatElapsedTime(r16)
            r10.setText(r0)
            java.lang.Long r0 = r2.getSourceStartPosition()
            xa.j.e(r7, r14)
            if (r0 == 0) goto L_0x01f8
            r14.setVisibility(r9)
            java.lang.Object[] r0 = new java.lang.Object[r11]
            java.lang.Long r4 = r2.getSourceStartPosition()
            long r16 = r4.longValue()
            long r16 = r16 / r18
            java.lang.String r4 = android.text.format.DateUtils.formatElapsedTime(r16)
            r0[r9] = r4
            r4 = 2131952348(0x7f1302dc, float:1.9541136E38)
            java.lang.String r0 = r3.getString(r4, r0)
            r14.setText(r0)
            xa.j.e(r5, r15)
            r15.setVisibility(r9)
            java.lang.Object[] r0 = new java.lang.Object[r11]
            java.lang.Long r4 = r2.getSourceStartPosition()
            long r16 = r4.longValue()
            java.lang.Long r4 = r2.getDuration()
            long r20 = r4.longValue()
            long r20 = r20 + r16
            long r20 = r20 / r18
            java.lang.String r4 = android.text.format.DateUtils.formatElapsedTime(r20)
            r0[r9] = r4
            r4 = 2131952347(0x7f1302db, float:1.9541134E38)
            java.lang.String r0 = r3.getString(r4, r0)
            r15.setText(r0)
            goto L_0x0201
        L_0x01f8:
            hb.h0.J0(r14)
            xa.j.e(r5, r15)
            hb.h0.J0(r15)
        L_0x0201:
            android.content.SharedPreferences r0 = hb.h0.l1(r3)
            java.lang.String r4 = "player_use_videopositions"
            boolean r0 = r0.getBoolean(r4, r11)
            if (r0 == 0) goto L_0x0246
            java.lang.Long r0 = r2.getLastWatchPosition()
            if (r0 == 0) goto L_0x0246
            java.lang.Long r0 = r2.getDuration()
            long r16 = r0.longValue()
            r18 = 0
            int r0 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0246
            java.lang.Long r0 = r2.getLastWatchPosition()
            xa.j.c(r0)
            r16 = r12
            long r11 = r0.longValue()
            float r0 = (float) r11
            java.lang.Long r4 = r2.getDuration()
            long r10 = r4.longValue()
            float r4 = (float) r10
            float r0 = r0 / r4
            r4 = 100
            float r4 = (float) r4
            float r0 = r0 * r4
            int r0 = (int) r0
            r13.setProgress(r0)
            r13.setVisibility(r9)
            goto L_0x0265
        L_0x0246:
            r16 = r12
            goto L_0x025d
        L_0x0249:
            r16 = r12
            xa.j.e(r4, r10)
            hb.h0.J0(r10)
            xa.j.e(r7, r14)
            hb.h0.J0(r14)
            xa.j.e(r5, r15)
            hb.h0.J0(r15)
        L_0x025d:
            java.lang.String r0 = "progressBar"
            xa.j.e(r0, r13)
            hb.h0.J0(r13)
        L_0x0265:
            xa.j.e(r5, r15)
            int r0 = r15.getVisibility()
            if (r0 != 0) goto L_0x0270
            r0 = 1
            goto L_0x0271
        L_0x0270:
            r0 = 0
        L_0x0271:
            r4 = 1084227584(0x40a00000, float:5.0)
            r5 = -2
            if (r0 == 0) goto L_0x0293
            xa.j.e(r7, r14)
            int r0 = r14.getVisibility()
            if (r0 != 0) goto L_0x0281
            r0 = 1
            goto L_0x0282
        L_0x0281:
            r0 = 0
        L_0x0282:
            if (r0 == 0) goto L_0x0293
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r0.<init>(r5, r5)
            int r10 = hb.h0.E(r3, r4)
            r0.setMargins(r9, r10, r9, r9)
            r15.setLayoutParams(r0)
        L_0x0293:
            int r0 = r16.getVisibility()
            if (r0 != 0) goto L_0x029b
            r0 = 1
            goto L_0x029c
        L_0x029b:
            r0 = 0
        L_0x029c:
            if (r0 == 0) goto L_0x02c8
            xa.j.e(r7, r14)
            int r0 = r14.getVisibility()
            if (r0 != 0) goto L_0x02a9
            r0 = 1
            goto L_0x02aa
        L_0x02a9:
            r0 = 0
        L_0x02aa:
            if (r0 != 0) goto L_0x02b7
            int r0 = r15.getVisibility()
            if (r0 != 0) goto L_0x02b4
            r0 = 1
            goto L_0x02b5
        L_0x02b4:
            r0 = 0
        L_0x02b5:
            if (r0 == 0) goto L_0x02c8
        L_0x02b7:
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r0.<init>(r5, r5)
            int r4 = hb.h0.E(r3, r4)
            r0.setMargins(r9, r4, r9, r9)
            r4 = r16
            r4.setLayoutParams(r0)
        L_0x02c8:
            h6.d r0 = new h6.d
            r4 = 14
            r0.<init>(r3, r8, r2, r4)
            android.widget.ImageButton r4 = r6.f17645f
            r4.setOnClickListener(r0)
            int r0 = r2.getStatus()
            r4 = 2
            android.widget.TextView r5 = r6.f17649j
            if (r0 != r4) goto L_0x02e6
            java.lang.String r0 = "bind$lambda$11$lambda$10"
            xa.j.e(r0, r5)
            hb.h0.J0(r5)
            goto L_0x032d
        L_0x02e6:
            int r0 = r2.getStatus()
            r4 = 1
            if (r0 != r4) goto L_0x030d
            java.lang.Object[] r0 = new java.lang.Object[r4]
            int r4 = r2.getProgress()
            float r4 = (float) r4
            int r6 = r2.getMaxProgress()
            float r6 = (float) r6
            float r4 = r4 / r6
            r6 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r6
            int r4 = (int) r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0[r9] = r4
            r4 = 2131951762(0x7f130092, float:1.9539948E38)
            java.lang.String r0 = r3.getString(r4, r0)
            goto L_0x0314
        L_0x030d:
            r0 = 2131951758(0x7f13008e, float:1.953994E38)
            java.lang.String r0 = r3.getString(r0)
        L_0x0314:
            r5.setText(r0)
            r5.setVisibility(r9)
            h6.b r0 = new h6.b
            r3 = 12
            r0.<init>(r8, r3, r2)
            r5.setOnClickListener(r0)
            a7.b r0 = new a7.b
            r3 = 1
            r0.<init>(r8, r2, r3)
            r5.setOnLongClickListener(r0)
        L_0x032d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.d.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        ViewGroup viewGroup2 = viewGroup;
        j.f("parent", viewGroup2);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_downloads_list_item, viewGroup2, false);
        int i11 = R.id.date;
        TextWithCanvas textWithCanvas = (TextWithCanvas) a.a(inflate, R.id.date);
        if (textWithCanvas != null) {
            i11 = R.id.downloadDate;
            TextWithCanvas textWithCanvas2 = (TextWithCanvas) a.a(inflate, R.id.downloadDate);
            if (textWithCanvas2 != null) {
                i11 = R.id.duration;
                TextWithCanvas textWithCanvas3 = (TextWithCanvas) a.a(inflate, R.id.duration);
                if (textWithCanvas3 != null) {
                    i11 = R.id.gameName;
                    TextView textView = (TextView) a.a(inflate, R.id.gameName);
                    if (textView != null) {
                        i11 = R.id.options;
                        ImageButton imageButton = (ImageButton) a.a(inflate, R.id.options);
                        if (imageButton != null) {
                            i11 = R.id.progressBar;
                            ProgressBar progressBar = (ProgressBar) a.a(inflate, R.id.progressBar);
                            if (progressBar != null) {
                                i11 = R.id.sourceEnd;
                                TextWithCanvas textWithCanvas4 = (TextWithCanvas) a.a(inflate, R.id.sourceEnd);
                                if (textWithCanvas4 != null) {
                                    i11 = R.id.sourceStart;
                                    TextWithCanvas textWithCanvas5 = (TextWithCanvas) a.a(inflate, R.id.sourceStart);
                                    if (textWithCanvas5 != null) {
                                        i11 = R.id.status;
                                        TextView textView2 = (TextView) a.a(inflate, R.id.status);
                                        if (textView2 != null) {
                                            i11 = R.id.thumbnail;
                                            ImageView imageView = (ImageView) a.a(inflate, R.id.thumbnail);
                                            if (imageView != null) {
                                                i11 = R.id.title;
                                                TextView textView3 = (TextView) a.a(inflate, R.id.title);
                                                if (textView3 != null) {
                                                    i11 = R.id.type;
                                                    TextWithCanvas textWithCanvas6 = (TextWithCanvas) a.a(inflate, R.id.type);
                                                    if (textWithCanvas6 != null) {
                                                        i11 = R.id.userImage;
                                                        ImageView imageView2 = (ImageView) a.a(inflate, R.id.userImage);
                                                        if (imageView2 != null) {
                                                            i11 = R.id.username;
                                                            TextView textView4 = (TextView) a.a(inflate, R.id.username);
                                                            if (textView4 != null) {
                                                                return new c(this, new g((CardView) inflate, textWithCanvas, textWithCanvas2, textWithCanvas3, textView, imageButton, progressBar, textWithCanvas4, textWithCanvas5, textView2, imageView, textView3, textWithCanvas6, imageView2, textView4), this.f275b);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
    }
}
