package androidx.lifecycle;

import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.support.v4.media.session.u;
import android.view.View;
import android.widget.TextView;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import h3.b0;
import h3.f4;
import h6.r;
import h6.s;
import hb.h0;
import hb.l1;
import i7.b;
import ib.a;
import j3.m2;
import j6.e;
import java.util.List;
import java.util.concurrent.CancellationException;
import la.i;
import m7.g;
import ma.z;
import r3.d;
import u3.f;
import wa.l;
import x6.h;
import xa.j;
import xa.k;
import z6.c;

public final class u1 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1769h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1770i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1771j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u1(Object obj, int i10, Object obj2) {
        super(1);
        this.f1769h = i10;
        this.f1770i = obj;
        this.f1771j = obj2;
    }

    public final Object a(f fVar) {
        int i10 = this.f1769h;
        Object obj = this.f1771j;
        Object obj2 = this.f1770i;
        switch (i10) {
            case 3:
                j.f("db", fVar);
                fVar.l0((String) obj2, (Object[]) obj);
                return null;
            default:
                j.f("db", fVar);
                d dVar = (d) obj2;
                dVar.getClass();
                fVar.y((String) null);
                dVar.getClass();
                throw null;
        }
    }

    public final void c(Uri uri) {
        int i10 = this.f1769h;
        Object obj = this.f1771j;
        Object obj2 = this.f1770i;
        switch (i10) {
            case 12:
                if (uri != null) {
                    w6.f fVar = (w6.f) obj2;
                    w6.d dVar = w6.f.H0;
                    b0 s02 = fVar.s0();
                    if (s02 != null) {
                        s02.T0(new f4(h0.r(new i("item", (Stream) obj), new i("uri", uri.toString()), new i("headers", (Object) null)), "startStream"), Bundle.EMPTY);
                    }
                    b0 s03 = fVar.s0();
                    if (s03 != null) {
                        s03.e();
                        return;
                    }
                    return;
                }
                return;
            default:
                h hVar = (h) obj2;
                x6.d dVar2 = h.H0;
                b0 s04 = hVar.s0();
                if (s04 != null) {
                    i[] iVarArr = new i[4];
                    Video video = hVar.F0;
                    if (video != null) {
                        iVarArr[0] = new i("item", video);
                        iVarArr[1] = new i("uri", uri.toString());
                        iVarArr[2] = new i("usingPlaylist", Boolean.TRUE);
                        iVarArr[3] = new i("playbackPosition", (Long) obj);
                        s04.T0(new f4(h0.r(iVarArr), "startVideo"), Bundle.EMPTY);
                        return;
                    }
                    j.l("video");
                    throw null;
                }
                return;
        }
    }

    public final void d(View view) {
        int i10 = this.f1769h;
        Object obj = this.f1771j;
        Object obj2 = this.f1770i;
        switch (i10) {
            case 7:
                j.f("it", view);
                Clip clip = (Clip) obj;
                h0.V(((e) obj2).f8817i).m(r.a(s.f7686a, clip.getChannelId(), clip.getChannelSlug(), clip.getChannelName(), clip.getChannelLogo(), false, 0, 48));
                return;
            case 14:
                j.f("it", view);
                Bookmark bookmark = (Bookmark) obj;
                h0.V(((c) obj2).f17740i).m(r.a(s.f7686a, bookmark.getUserId(), bookmark.getUserLogin(), bookmark.getUserName(), bookmark.getUserLogo(), true, 0, 32));
                return;
            case 17:
                j.f("it", view);
                OfflineVideo offlineVideo = (OfflineVideo) obj;
                h0.V(((a7.c) obj2).f273i).m(r.a(s.f7686a, offlineVideo.getChannelId(), offlineVideo.getChannelLogin(), offlineVideo.getChannelName(), offlineVideo.getChannelLogo(), true, 0, 32));
                return;
            case 20:
                j.f("it", view);
                Stream stream = (Stream) obj;
                h0.V(((b) obj2).f8360i).m(r.a(s.f7686a, stream.getChannelId(), stream.getChannelSlug(), stream.getChannelName(), stream.getChannelLogo(), false, stream.getId(), 16));
                return;
            case 21:
                j.f("it", view);
                Stream stream2 = (Stream) obj;
                h0.V(((i7.e) obj2).f8369i).m(r.a(s.f7686a, stream2.getChannelId(), stream2.getChannelSlug(), stream2.getChannelName(), stream2.getChannelLogo(), false, stream2.getId(), 16));
                return;
            default:
                j.f("it", view);
                Video video = (Video) obj;
                h0.V(((g) obj2).f10694i).m(r.a(s.f7686a, video.getChannelId(), video.getChannelSlug(), video.getChannelName(), video.getChannelLogo(), false, 0, 48));
                return;
        }
    }

    public final void f(List list) {
        int i10 = 8;
        int i11 = this.f1769h;
        Object obj = this.f1771j;
        Object obj2 = this.f1770i;
        switch (i11) {
            case 6:
                m0 m0Var = (m0) obj2;
                ChatViewModel chatViewModel = (ChatViewModel) obj;
                l0 l0Var = (l0) m0Var.f1732l.c(chatViewModel.f3353j);
                if (l0Var != null) {
                    l0Var.f1729a.k(l0Var);
                }
                m0Var.m(chatViewModel.f3354k, new v1(4, new m2(m0Var, chatViewModel, list, 5)));
                return;
            case 15:
                z6.d dVar = ((z6.g) obj2).f17756q0;
                if (dVar != null) {
                    j.e("it", list);
                    dVar.a(z.E(list));
                    TextView textView = (TextView) ((u) obj).f429j;
                    j.e("nothingHere", textView);
                    if (list.isEmpty()) {
                        i10 = 0;
                    }
                    textView.setVisibility(i10);
                    return;
                }
                j.l("adapter");
                throw null;
            default:
                a7.d dVar2 = ((a7.e) obj2).f280q0;
                if (dVar2 != null) {
                    dVar2.a(list);
                    TextView textView2 = (TextView) ((u) obj).f429j;
                    j.e("nothingHere", textView2);
                    if (list.isEmpty()) {
                        i10 = 0;
                    }
                    textView2.setVisibility(i10);
                    return;
                }
                j.l("adapter");
                throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x049d, code lost:
        if (r0 != false) goto L_0x04a1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r14) {
        /*
            r13 = this;
            int r0 = r13.f1769h
            r1 = 17039360(0x1040000, float:2.424457E-38)
            r2 = 2131951671(0x7f130037, float:1.9539763E38)
            java.lang.String r3 = "getString(R.string.delete)"
            r4 = 2131951748(0x7f130084, float:1.953992E38)
            r5 = 2
            r6 = 3
            java.lang.String r7 = "it"
            r8 = 0
            r9 = 1
            r10 = 0
            java.lang.Object r11 = r13.f1771j
            java.lang.Object r12 = r13.f1770i
            switch(r0) {
                case 0: goto L_0x04d0;
                case 1: goto L_0x0439;
                case 2: goto L_0x03c7;
                case 3: goto L_0x03c0;
                case 4: goto L_0x03b9;
                case 5: goto L_0x03b1;
                case 6: goto L_0x03a9;
                case 7: goto L_0x03a1;
                case 8: goto L_0x0374;
                case 9: goto L_0x032b;
                case 10: goto L_0x014a;
                case 11: goto L_0x00dc;
                case 12: goto L_0x00d4;
                case 13: goto L_0x00cc;
                case 14: goto L_0x00c4;
                case 15: goto L_0x00bc;
                case 16: goto L_0x0084;
                case 17: goto L_0x007c;
                case 18: goto L_0x0074;
                case 19: goto L_0x003c;
                case 20: goto L_0x0034;
                case 21: goto L_0x002c;
                case 22: goto L_0x0024;
                case 23: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x04de
        L_0x001c:
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            r13.invoke((java.lang.Throwable) r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x0024:
            android.view.View r14 = (android.view.View) r14
            r13.d(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x002c:
            android.view.View r14 = (android.view.View) r14
            r13.d(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x0034:
            android.view.View r14 = (android.view.View) r14
            r13.d(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x003c:
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r14 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r14
            xa.j.f(r7, r14)
            a7.e r12 = (a7.e) r12
            java.lang.String r0 = r12.z(r4)
            xa.j.e(r3, r0)
            android.app.AlertDialog$Builder r3 = new android.app.AlertDialog$Builder
            com.github.andreyasadchy.xtra.ui.main.MainActivity r11 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r11
            r3.<init>(r11)
            android.app.AlertDialog$Builder r3 = r3.setTitle(r0)
            java.lang.String r2 = r12.z(r2)
            android.app.AlertDialog$Builder r2 = r3.setMessage(r2)
            t6.w0 r3 = new t6.w0
            r3.<init>(r12, r14, r6)
            android.app.AlertDialog$Builder r14 = r2.setPositiveButton(r0, r3)
            java.lang.String r0 = r12.z(r1)
            android.app.AlertDialog$Builder r14 = r14.setNegativeButton(r0, r8)
            r14.show()
            la.v r14 = la.v.f9814a
            return r14
        L_0x0074:
            java.util.List r14 = (java.util.List) r14
            r13.f(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x007c:
            android.view.View r14 = (android.view.View) r14
            r13.d(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x0084:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r14 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r14
            xa.j.f(r7, r14)
            z6.g r12 = (z6.g) r12
            java.lang.String r0 = r12.z(r4)
            xa.j.e(r3, r0)
            android.app.AlertDialog$Builder r3 = new android.app.AlertDialog$Builder
            com.github.andreyasadchy.xtra.ui.main.MainActivity r11 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r11
            r3.<init>(r11)
            android.app.AlertDialog$Builder r3 = r3.setTitle(r0)
            java.lang.String r2 = r12.z(r2)
            android.app.AlertDialog$Builder r2 = r3.setMessage(r2)
            t6.w0 r3 = new t6.w0
            r3.<init>(r12, r14, r5)
            android.app.AlertDialog$Builder r14 = r2.setPositiveButton(r0, r3)
            java.lang.String r0 = r12.z(r1)
            android.app.AlertDialog$Builder r14 = r14.setNegativeButton(r0, r8)
            r14.show()
            la.v r14 = la.v.f9814a
            return r14
        L_0x00bc:
            java.util.List r14 = (java.util.List) r14
            r13.f(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x00c4:
            android.view.View r14 = (android.view.View) r14
            r13.d(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x00cc:
            android.net.Uri r14 = (android.net.Uri) r14
            r13.c(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x00d4:
            android.net.Uri r14 = (android.net.Uri) r14
            r13.c(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x00dc:
            java.util.Map r14 = (java.util.Map) r14
            u6.d r12 = (u6.d) r12
            android.content.Context r14 = r12.v()
            if (r14 == 0) goto L_0x00ef
            r0 = 2131952346(0x7f1302da, float:1.9541132E38)
            java.lang.String r14 = r14.getString(r0)
            if (r14 != 0) goto L_0x00f1
        L_0x00ef:
            java.lang.String r14 = "Source"
        L_0x00f1:
            com.github.andreyasadchy.xtra.model.ui.Clip r11 = (com.github.andreyasadchy.xtra.model.ui.Clip) r11
            java.lang.String r0 = r11.getVideoUrl()
            la.i r1 = new la.i
            r1.<init>(r14, r0)
            java.util.Map r14 = ma.i0.b(r1)
            h3.b0 r0 = r12.s0()
            if (r0 == 0) goto L_0x0147
            h3.f4 r1 = new h3.f4
            la.i[] r2 = new la.i[r6]
            la.i r3 = new la.i
            java.lang.String r4 = "item"
            r3.<init>(r4, r11)
            r2[r10] = r3
            java.util.Set r3 = r14.keySet()
            java.lang.String[] r4 = new java.lang.String[r10]
            java.lang.Object[] r3 = r3.toArray(r4)
            la.i r4 = new la.i
            java.lang.String r6 = "urlsKeys"
            r4.<init>(r6, r3)
            r2[r9] = r4
            java.util.Collection r14 = r14.values()
            java.lang.String[] r3 = new java.lang.String[r10]
            java.lang.Object[] r14 = r14.toArray(r3)
            la.i r3 = new la.i
            java.lang.String r4 = "urlsValues"
            r3.<init>(r4, r14)
            r2[r5] = r3
            android.os.Bundle r14 = hb.h0.r(r2)
            java.lang.String r2 = "startClip"
            r1.<init>(r14, r2)
            android.os.Bundle r14 = android.os.Bundle.EMPTY
            r0.T0(r1, r14)
        L_0x0147:
            la.v r14 = la.v.f9814a
            return r14
        L_0x014a:
            com.github.andreyasadchy.xtra.model.ui.ChannelViewerList r14 = (com.github.andreyasadchy.xtra.model.ui.ChannelViewerList) r14
            if (r14 == 0) goto L_0x0328
            java.util.List r0 = r14.getBroadcasters()
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            java.lang.String r1 = "broadcasterList"
            java.lang.String r2 = "broadcasterText"
            if (r0 == 0) goto L_0x0188
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r3 = r0.f17665c
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r2, r3)
            r3.setVisibility(r10)
            java.lang.Object r0 = r0.f17667e
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            xa.j.e(r1, r0)
            r0.setVisibility(r10)
            t6.k0 r1 = new t6.k0
            r2 = r11
            t6.o0 r2 = (t6.o0) r2
            android.content.Context r2 = r2.v()
            java.util.List r3 = r14.getBroadcasters()
            r1.<init>(r2, r3)
            r0.setAdapter(r1)
            goto L_0x019f
        L_0x0188:
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r3 = r0.f17665c
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r2, r3)
            hb.h0.J0(r3)
            java.lang.Object r0 = r0.f17667e
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            xa.j.e(r1, r0)
            hb.h0.J0(r0)
        L_0x019f:
            java.util.List r0 = r14.getModerators()
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            java.lang.String r1 = "moderatorsList"
            java.lang.String r2 = "moderatorsText"
            if (r0 == 0) goto L_0x01df
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r3 = r0.f17668f
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r2, r3)
            r3.setVisibility(r10)
            java.lang.Object r0 = r0.f17673k
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r2 = r11
            t6.o0 r2 = (t6.o0) r2
            java.lang.String r3 = "invoke$lambda$0"
            xa.j.e(r3, r0)
            r0.setVisibility(r10)
            t6.k0 r3 = new t6.k0
            android.content.Context r4 = r0.getContext()
            java.util.ArrayList r5 = r2.B0
            r3.<init>(r4, r5)
            r0.setAdapter(r3)
            xa.j.e(r1, r0)
            t6.o0.s0(r2, r14, r0)
            goto L_0x01f6
        L_0x01df:
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r3 = r0.f17668f
            android.widget.TextView r3 = (android.widget.TextView) r3
            xa.j.e(r2, r3)
            hb.h0.J0(r3)
            java.lang.Object r0 = r0.f17673k
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            xa.j.e(r1, r0)
            hb.h0.J0(r0)
        L_0x01f6:
            java.util.List r0 = r14.getVips()
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            r1 = 100
            java.lang.String r2 = "vipsList"
            java.lang.String r3 = "vipsText"
            if (r0 == 0) goto L_0x0242
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r4 = r0.f17672j
            android.widget.TextView r4 = (android.widget.TextView) r4
            xa.j.e(r3, r4)
            r4.setVisibility(r10)
            java.lang.Object r0 = r0.f17669g
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r3 = r11
            t6.o0 r3 = (t6.o0) r3
            java.lang.String r4 = "invoke$lambda$1"
            xa.j.e(r4, r0)
            r0.setVisibility(r10)
            t6.k0 r4 = new t6.k0
            android.content.Context r5 = r0.getContext()
            java.util.ArrayList r6 = r3.D0
            r4.<init>(r5, r6)
            r0.setAdapter(r4)
            java.util.List r4 = r14.getModerators()
            int r4 = r4.size()
            if (r4 > r1) goto L_0x0259
            xa.j.e(r2, r0)
            t6.o0.s0(r3, r14, r0)
            goto L_0x0259
        L_0x0242:
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r4 = r0.f17672j
            android.widget.TextView r4 = (android.widget.TextView) r4
            xa.j.e(r3, r4)
            hb.h0.J0(r4)
            java.lang.Object r0 = r0.f17669g
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            xa.j.e(r2, r0)
            hb.h0.J0(r0)
        L_0x0259:
            java.util.List r0 = r14.getViewers()
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r9
            java.lang.String r2 = "viewersList"
            java.lang.String r3 = "viewersText"
            if (r0 == 0) goto L_0x02ac
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r4 = r0.f17671i
            android.widget.TextView r4 = (android.widget.TextView) r4
            xa.j.e(r3, r4)
            r4.setVisibility(r10)
            java.lang.Object r0 = r0.f17666d
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r3 = r11
            t6.o0 r3 = (t6.o0) r3
            java.lang.String r4 = "invoke$lambda$2"
            xa.j.e(r4, r0)
            r0.setVisibility(r10)
            t6.k0 r4 = new t6.k0
            android.content.Context r5 = r0.getContext()
            java.util.ArrayList r6 = r3.F0
            r4.<init>(r5, r6)
            r0.setAdapter(r4)
            java.util.List r4 = r14.getModerators()
            int r4 = r4.size()
            java.util.List r5 = r14.getVips()
            int r5 = r5.size()
            int r5 = r5 + r4
            if (r5 > r1) goto L_0x02c3
            xa.j.e(r2, r0)
            t6.o0.s0(r3, r14, r0)
            goto L_0x02c3
        L_0x02ac:
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r1 = r0.f17671i
            android.widget.TextView r1 = (android.widget.TextView) r1
            xa.j.e(r3, r1)
            hb.h0.J0(r1)
            java.lang.Object r0 = r0.f17666d
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            xa.j.e(r2, r0)
            hb.h0.J0(r0)
        L_0x02c3:
            java.lang.Integer r0 = r14.getCount()
            java.lang.String r1 = "userCount"
            if (r0 == 0) goto L_0x0307
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r2 = r0.f17670h
            android.widget.TextView r2 = (android.widget.TextView) r2
            xa.j.e(r1, r2)
            r2.setVisibility(r10)
            java.lang.Object r0 = r0.f17670h
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = r11
            t6.o0 r1 = (t6.o0) r1
            android.content.Context r2 = r1.f0()
            java.lang.Object[] r3 = new java.lang.Object[r9]
            s7.h r4 = s7.h.f14375a
            android.content.Context r1 = r1.f0()
            java.lang.Integer r5 = r14.getCount()
            int r5 = r5.intValue()
            r4.getClass()
            java.lang.String r1 = s7.h.a(r1, r5)
            r3[r10] = r1
            r1 = 2131952423(0x7f130327, float:1.9541288E38)
            java.lang.String r1 = r2.getString(r1, r3)
            r0.setText(r1)
            goto L_0x0314
        L_0x0307:
            r0 = r12
            z5.i r0 = (z5.i) r0
            java.lang.Object r0 = r0.f17670h
            android.widget.TextView r0 = (android.widget.TextView) r0
            xa.j.e(r1, r0)
            hb.h0.J0(r0)
        L_0x0314:
            z5.i r12 = (z5.i) r12
            java.lang.Object r0 = r12.f17674l
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
            t6.o0 r11 = (t6.o0) r11
            t6.n0 r1 = new t6.n0
            r1.<init>(r12, r11, r14)
            r0.addOnScrollChangedListener(r1)
        L_0x0328:
            la.v r14 = la.v.f9814a
            return r14
        L_0x032b:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            t6.l r12 = (t6.l) r12
            r12.l()
            r12.q()
            com.github.andreyasadchy.xtra.ui.main.MainActivity r11 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r11
            r11.E()
            android.content.SharedPreferences r14 = r12.t0()
            java.lang.String r0 = "sleep_timer_lock"
            boolean r14 = r14.getBoolean(r0, r9)
            if (r14 == 0) goto L_0x0371
            android.content.Context r14 = r12.f0()
            java.lang.String r0 = "power"
            java.lang.Object r14 = r14.getSystemService(r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.os.PowerManager"
            xa.j.d(r0, r14)
            android.os.PowerManager r14 = (android.os.PowerManager) r14
            boolean r14 = r14.isInteractive()
            if (r14 == 0) goto L_0x0371
            android.content.Context r14 = r12.f0()     // Catch:{ SecurityException -> 0x0371 }
            java.lang.String r0 = "device_policy"
            java.lang.Object r14 = r14.getSystemService(r0)     // Catch:{ SecurityException -> 0x0371 }
            java.lang.String r0 = "null cannot be cast to non-null type android.app.admin.DevicePolicyManager"
            xa.j.d(r0, r14)     // Catch:{ SecurityException -> 0x0371 }
            android.app.admin.DevicePolicyManager r14 = (android.app.admin.DevicePolicyManager) r14     // Catch:{ SecurityException -> 0x0371 }
            r14.lockNow()     // Catch:{ SecurityException -> 0x0371 }
        L_0x0371:
            la.v r14 = la.v.f9814a
            return r14
        L_0x0374:
            s7.e r14 = (s7.e) r14
            boolean r0 = r14.f14371b
            if (r0 == 0) goto L_0x037b
            goto L_0x037f
        L_0x037b:
            r14.f14371b = r9
            java.lang.Object r8 = r14.f14370a
        L_0x037f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 == 0) goto L_0x039e
            xa.q r12 = (xa.q) r12
            com.github.andreyasadchy.xtra.ui.main.MainActivity r11 = (com.github.andreyasadchy.xtra.ui.main.MainActivity) r11
            boolean r14 = r8.booleanValue()
            boolean r0 = r12.f16814h
            if (r0 == 0) goto L_0x039c
            if (r14 == 0) goto L_0x0395
            r14 = 2131951733(0x7f130075, float:1.9539889E38)
            goto L_0x0398
        L_0x0395:
            r14 = 2131952189(0x7f13023d, float:1.9540814E38)
        L_0x0398:
            hb.h0.C1(r11, r14)
            goto L_0x039e
        L_0x039c:
            r12.f16814h = r9
        L_0x039e:
            la.v r14 = la.v.f9814a
            return r14
        L_0x03a1:
            android.view.View r14 = (android.view.View) r14
            r13.d(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x03a9:
            java.util.List r14 = (java.util.List) r14
            r13.f(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x03b1:
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            r13.invoke((java.lang.Throwable) r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x03b9:
            u3.f r14 = (u3.f) r14
            java.lang.Object r14 = r13.a(r14)
            return r14
        L_0x03c0:
            u3.f r14 = (u3.f) r14
            java.lang.Object r14 = r13.a(r14)
            return r14
        L_0x03c7:
            n3.c r14 = (n3.c) r14
            xa.j.f(r7, r14)
            n3.d1 r12 = (n3.d1) r12
            n3.o4 r11 = (n3.o4) r11
            java.lang.String r0 = "loadType"
            xa.j.f(r0, r12)
            java.lang.String r0 = "pagingState"
            xa.j.f(r0, r11)
            ma.l r0 = r14.f11072c
            java.util.Iterator r1 = r0.iterator()
        L_0x03e0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x03f7
            java.lang.Object r2 = r1.next()
            r3 = r2
            n3.a r3 = (n3.a) r3
            n3.d1 r3 = r3.f11034a
            if (r3 != r12) goto L_0x03f3
            r3 = 1
            goto L_0x03f4
        L_0x03f3:
            r3 = 0
        L_0x03f4:
            if (r3 == 0) goto L_0x03e0
            goto L_0x03f8
        L_0x03f7:
            r2 = r8
        L_0x03f8:
            n3.a r2 = (n3.a) r2
            if (r2 == 0) goto L_0x03ff
            r2.f11035b = r11
            goto L_0x0434
        L_0x03ff:
            int[] r1 = r14.f11070a
            int r2 = r12.ordinal()
            r1 = r1[r2]
            n3.d1 r2 = n3.d1.REFRESH
            if (r1 != r6) goto L_0x0416
            if (r12 == r2) goto L_0x0416
            n3.a r14 = new n3.a
            r14.<init>(r12, r11)
            r0.d(r14)
            goto L_0x0434
        L_0x0416:
            if (r1 == r9) goto L_0x041b
            if (r12 == r2) goto L_0x041b
            goto L_0x0434
        L_0x041b:
            n3.w0[] r14 = r14.f11071b
            if (r12 != r2) goto L_0x0421
            r14[r10] = r8
        L_0x0421:
            int r1 = r12.ordinal()
            r14 = r14[r1]
            if (r14 != 0) goto L_0x0432
            n3.a r14 = new n3.a
            r14.<init>(r12, r11)
            r0.d(r14)
            goto L_0x0433
        L_0x0432:
            r9 = 0
        L_0x0433:
            r10 = r9
        L_0x0434:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r10)
            return r14
        L_0x0439:
            j3.o1 r14 = (j3.o1) r14
            java.lang.String r0 = "$this$navOptions"
            xa.j.f(r0, r14)
            java.lang.String r0 = "animBuilder"
            j3.g0 r1 = j3.g0.f8535h
            xa.j.f(r0, r1)
            j3.f r0 = new j3.f
            r0.<init>()
            r1.invoke(r0)
            int r1 = r0.f8525a
            j3.m1 r2 = r14.f8643a
            r2.f8621g = r1
            int r1 = r0.f8526b
            r2.f8622h = r1
            int r1 = r0.f8527c
            r2.f8623i = r1
            int r0 = r0.f8528d
            r2.f8624j = r0
            j3.c1 r12 = (j3.c1) r12
            boolean r0 = r12 instanceof j3.h1
            if (r0 == 0) goto L_0x04a0
            j3.a1 r0 = j3.c1.f8505q
            r0.getClass()
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r12)
            j3.z0 r0 = j3.z0.f8727h
            eb.h r0 = eb.m.b(r12, r0)
            r1 = r11
            j3.k0 r1 = (j3.k0) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x047e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x049c
            java.lang.Object r2 = r0.next()
            j3.c1 r2 = (j3.c1) r2
            j3.c1 r3 = r1.f()
            if (r3 == 0) goto L_0x0493
            j3.h1 r3 = r3.f8507i
            goto L_0x0494
        L_0x0493:
            r3 = r8
        L_0x0494:
            boolean r2 = xa.j.a(r2, r3)
            if (r2 == 0) goto L_0x047e
            r0 = 0
            goto L_0x049d
        L_0x049c:
            r0 = 1
        L_0x049d:
            if (r0 == 0) goto L_0x04a0
            goto L_0x04a1
        L_0x04a0:
            r9 = 0
        L_0x04a1:
            if (r9 == 0) goto L_0x04cd
            boolean r0 = j3.k0.D
            if (r0 == 0) goto L_0x04cd
            j3.f1 r0 = j3.h1.f8556v
            j3.k0 r11 = (j3.k0) r11
            j3.h1 r1 = r11.h()
            r0.getClass()
            j3.c1 r0 = j3.f1.a(r1)
            int r0 = r0.f8513o
            java.lang.String r1 = "popUpToBuilder"
            j3.h0 r2 = j3.h0.f8555h
            xa.j.f(r1, r2)
            r14.f8646d = r0
            j3.s2 r0 = new j3.s2
            r0.<init>()
            r2.invoke(r0)
            boolean r0 = r0.f8682a
            r14.f8647e = r0
        L_0x04cd:
            la.v r14 = la.v.f9814a
            return r14
        L_0x04d0:
            androidx.lifecycle.m0 r12 = (androidx.lifecycle.m0) r12
            wa.l r11 = (wa.l) r11
            java.lang.Object r14 = r11.invoke(r14)
            r12.l(r14)
            la.v r14 = la.v.f9814a
            return r14
        L_0x04de:
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            r13.invoke((java.lang.Throwable) r14)
            la.v r14 = la.v.f9814a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.u1.invoke(java.lang.Object):java.lang.Object");
    }

    public final void invoke(Throwable th) {
        int i10 = this.f1769h;
        Object obj = this.f1771j;
        Object obj2 = this.f1770i;
        switch (i10) {
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                CancellationSignal cancellationSignal = (CancellationSignal) obj2;
                if (cancellationSignal != null) {
                    int i11 = u3.c.f15348a;
                    cancellationSignal.cancel();
                }
                ((l1) obj).e((CancellationException) null);
                return;
            case 23:
                ((a) obj2).f8373j.removeCallbacks((Runnable) obj);
                return;
            default:
                ((ob.d) obj2).f(obj);
                return;
        }
    }
}
