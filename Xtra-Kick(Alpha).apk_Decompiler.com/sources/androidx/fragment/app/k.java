package androidx.fragment.app;

import android.widget.TextView;
import j3.w0;
import kb.k0;
import n3.k5;
import ob.i;
import wa.l;
import z5.f;

public final class k extends xa.k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1469h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1470i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(int i10, Object obj) {
        super(1);
        this.f1469h = i10;
        this.f1470i = obj;
    }

    public final void a(CharSequence charSequence) {
        int i10 = this.f1469h;
        Object obj = this.f1470i;
        switch (i10) {
            case 8:
                ((TextView) ((f) obj).f17639c.f9450l).setText(charSequence);
                return;
            default:
                ((TextView) ((f) obj).f17639c.f9450l).setText(charSequence);
                return;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v69, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v70, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v71, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v72, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v67, types: [la.k] */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x018f, code lost:
        if (r4 != false) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01f2, code lost:
        if (r3 != false) goto L_0x01f4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            int r2 = r1.f1469h
            java.lang.String r5 = "Sequence is empty."
            r6 = 7
            r7 = 5
            r8 = 2131362493(0x7f0a02bd, float:1.8344768E38)
            r9 = 2131362357(0x7f0a0235, float:1.8344492E38)
            r10 = 3
            java.lang.String r12 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout"
            java.lang.String r13 = "entry"
            r14 = 0
            java.lang.String r15 = "it"
            r3 = 1
            r11 = 0
            switch(r2) {
                case 0: goto L_0x053a;
                case 1: goto L_0x04ec;
                case 2: goto L_0x04dd;
                case 3: goto L_0x04c9;
                case 4: goto L_0x04c1;
                case 5: goto L_0x04b9;
                case 6: goto L_0x0456;
                case 7: goto L_0x044b;
                case 8: goto L_0x0443;
                case 9: goto L_0x0432;
                case 10: goto L_0x03f9;
                case 11: goto L_0x0351;
                case 12: goto L_0x0235;
                case 13: goto L_0x022d;
                case 14: goto L_0x0144;
                case 15: goto L_0x009f;
                case 16: goto L_0x0086;
                case 17: goto L_0x0078;
                case 18: goto L_0x0069;
                case 19: goto L_0x005b;
                case 20: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0558
        L_0x001f:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r2 = r1.f1470i
            wa.l r2 = (wa.l) r2
            int r3 = la.l.f9802h     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.invoke(r0)     // Catch:{ all -> 0x004b }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x004b }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x004b }
            java.lang.String r4 = r2.getMessage()     // Catch:{ all -> 0x004b }
            boolean r3 = xa.j.a(r3, r4)     // Catch:{ all -> 0x004b }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x004b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004b }
            boolean r0 = xa.j.a(r3, r0)     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0052
            r2 = r14
            goto L_0x0052
        L_0x004b:
            r0 = move-exception
            int r2 = la.l.f9802h
            la.k r2 = hb.h0.I(r0)
        L_0x0052:
            boolean r0 = r2 instanceof la.k
            if (r0 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r14 = r2
        L_0x0058:
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            return r14
        L_0x005b:
            cb.e r0 = (cb.e) r0
            xa.j.f(r15, r0)
            java.lang.Object r2 = r1.f1470i
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r0 = fb.y.I(r2, r0)
            return r0
        L_0x0069:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            java.lang.Object r2 = r1.f1470i
            fb.g r2 = (fb.g) r2
            fb.f r0 = r2.b(r0)
            return r0
        L_0x0078:
            java.lang.Object r2 = r1.f1470i
            ma.a r2 = (ma.a) r2
            if (r0 != r2) goto L_0x0081
            java.lang.String r0 = "(this Collection)"
            goto L_0x0085
        L_0x0081:
            java.lang.String r0 = java.lang.String.valueOf(r17)
        L_0x0085:
            return r0
        L_0x0086:
            t9.x r0 = (t9.x) r0
            xa.j.g(r15, r0)
            boolean r2 = r0.f14916b
            if (r2 != 0) goto L_0x009c
            java.lang.Object r2 = r1.f1470i
            q9.g r2 = (q9.g) r2
            java.util.List r4 = r2.get()
            r2.c(r3, r4)
            r0.f14916b = r3
        L_0x009c:
            la.v r0 = la.v.f9814a
            return r0
        L_0x009f:
            l0.c r0 = (l0.c) r0
            if (r0 == 0) goto L_0x0141
            java.lang.Object r2 = r0.f9498a
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x00b3
            boolean r5 = fb.w.h(r5)
            if (r5 == 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r5 = 0
            goto L_0x00b4
        L_0x00b3:
            r5 = 1
        L_0x00b4:
            java.lang.Object r8 = r1.f1470i
            if (r5 != 0) goto L_0x013a
            l6.b r5 = l6.d.f9592u0
            com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment) r8
            androidx.fragment.app.c1 r9 = r8.u()
            java.lang.String r12 = "childFragmentManager"
            xa.j.e(r12, r9)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.f9499b
            java.lang.String r0 = (java.lang.String) r0
            r12 = 2131952439(0x7f130337, float:1.954132E38)
            java.lang.String r12 = r8.z(r12)
            java.lang.String r13 = "getString(R.string.view_profile)"
            xa.j.e(r13, r12)
            r13 = 17039360(0x1040000, float:2.424457E-38)
            java.lang.String r8 = r8.z(r13)
            r5.getClass()
            l6.d r5 = new l6.d
            r5.<init>()
            la.i[] r6 = new la.i[r6]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            la.i r15 = new la.i
            java.lang.String r4 = "requestCode"
            r15.<init>(r4, r13)
            r6[r11] = r15
            la.i r4 = new la.i
            java.lang.String r11 = "title"
            r4.<init>(r11, r2)
            r6[r3] = r4
            la.i r2 = new la.i
            java.lang.String r3 = "message"
            r2.<init>(r3, r0)
            r0 = 2
            r6[r0] = r2
            la.i r0 = new la.i
            java.lang.String r2 = "positive"
            r0.<init>(r2, r12)
            r6[r10] = r0
            la.i r0 = new la.i
            java.lang.String r2 = "negative"
            r0.<init>(r2, r8)
            r2 = 4
            r6[r2] = r0
            la.i r0 = new la.i
            java.lang.String r2 = "neutral"
            r0.<init>(r2, r14)
            r6[r7] = r0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            la.i r2 = new la.i
            java.lang.String r3 = "cancelable"
            r2.<init>(r3, r0)
            r0 = 6
            r6[r0] = r2
            android.os.Bundle r0 = hb.h0.r(r6)
            r5.j0(r0)
            r5.q0(r9, r14)
            goto L_0x0141
        L_0x013a:
            com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment r8 = (com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment) r8
            int r0 = com.github.andreyasadchy.xtra.ui.search.SearchPagerFragment.f3468s0
            r8.s0()
        L_0x0141:
            la.v r0 = la.v.f9814a
            return r0
        L_0x0144:
            com.github.andreyasadchy.xtra.model.ui.Stream r0 = (com.github.andreyasadchy.xtra.model.ui.Stream) r0
            java.lang.Object r2 = r1.f1470i
            w6.f r2 = (w6.f) r2
            i6.e r4 = r2.P0()
            if (r0 == 0) goto L_0x0153
            r0.getId()
        L_0x0153:
            r4.q0()
            android.content.SharedPreferences r4 = r2.t0()
            java.lang.String r5 = "chat_disable"
            boolean r4 = r4.getBoolean(r5, r11)
            java.lang.String r6 = "chat_pubsub_enabled"
            if (r4 != 0) goto L_0x0191
            android.content.SharedPreferences r4 = r2.t0()
            boolean r4 = r4.getBoolean(r6, r3)
            if (r4 == 0) goto L_0x0191
            android.view.View r4 = r2.h0()
            r7 = 2131362606(0x7f0a032e, float:1.8344997E38)
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0182
            java.lang.CharSequence r4 = r4.getText()
            goto L_0x0183
        L_0x0182:
            r4 = r14
        L_0x0183:
            if (r4 == 0) goto L_0x018e
            boolean r4 = fb.w.h(r4)
            if (r4 == 0) goto L_0x018c
            goto L_0x018e
        L_0x018c:
            r4 = 0
            goto L_0x018f
        L_0x018e:
            r4 = 1
        L_0x018f:
            if (r4 == 0) goto L_0x019c
        L_0x0191:
            if (r0 == 0) goto L_0x0198
            java.lang.Integer r4 = r0.getViewerCount()
            goto L_0x0199
        L_0x0198:
            r4 = r14
        L_0x0199:
            r2.W0(r4)
        L_0x019c:
            android.content.SharedPreferences r4 = r2.t0()
            boolean r4 = r4.getBoolean(r5, r11)
            if (r4 != 0) goto L_0x01f4
            android.content.SharedPreferences r4 = r2.t0()
            boolean r4 = r4.getBoolean(r6, r3)
            if (r4 == 0) goto L_0x01f4
            android.view.View r4 = r2.h0()
            r5 = 2131362347(0x7f0a022b, float:1.8344472E38)
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x01c4
            java.lang.CharSequence r4 = r4.getText()
            goto L_0x01c5
        L_0x01c4:
            r4 = r14
        L_0x01c5:
            if (r4 == 0) goto L_0x01d0
            boolean r4 = fb.w.h(r4)
            if (r4 == 0) goto L_0x01ce
            goto L_0x01d0
        L_0x01ce:
            r4 = 0
            goto L_0x01d1
        L_0x01d0:
            r4 = 1
        L_0x01d1:
            if (r4 != 0) goto L_0x01f4
            android.view.View r4 = r2.h0()
            r5 = 2131362329(0x7f0a0219, float:1.8344436E38)
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x01e7
            java.lang.CharSequence r4 = r4.getText()
            goto L_0x01e8
        L_0x01e7:
            r4 = r14
        L_0x01e8:
            if (r4 == 0) goto L_0x01f2
            boolean r4 = fb.w.h(r4)
            if (r4 == 0) goto L_0x01f1
            goto L_0x01f2
        L_0x01f1:
            r3 = 0
        L_0x01f2:
            if (r3 == 0) goto L_0x022a
        L_0x01f4:
            com.github.andreyasadchy.xtra.model.ui.BroadcastSettings r3 = new com.github.andreyasadchy.xtra.model.ui.BroadcastSettings
            if (r0 == 0) goto L_0x01fe
            java.lang.String r4 = r0.getTitle()
            r5 = r4
            goto L_0x01ff
        L_0x01fe:
            r5 = r14
        L_0x01ff:
            if (r0 == 0) goto L_0x0207
            java.lang.String r4 = r0.getGameName()
            r6 = r4
            goto L_0x0208
        L_0x0207:
            r6 = r14
        L_0x0208:
            if (r0 == 0) goto L_0x0210
            int r11 = r0.getGameId()
            r7 = r11
            goto L_0x0211
        L_0x0210:
            r7 = 0
        L_0x0211:
            if (r0 == 0) goto L_0x0219
            java.lang.String r4 = r0.getGameSlug()
            if (r4 != 0) goto L_0x021b
        L_0x0219:
            java.lang.String r4 = ""
        L_0x021b:
            r8 = r4
            if (r0 == 0) goto L_0x0222
            java.lang.String r14 = r0.getBoxArtUrl()
        L_0x0222:
            r9 = r14
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9)
            r2.V0(r3)
        L_0x022a:
            la.v r0 = la.v.f9814a
            return r0
        L_0x022d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.a(r0)
            la.v r0 = la.v.f9814a
            return r0
        L_0x0235:
            com.github.andreyasadchy.xtra.model.VideoDownloadInfo r0 = (com.github.andreyasadchy.xtra.model.VideoDownloadInfo) r0
            java.lang.Object r2 = r1.f1470i
            if (r0 == 0) goto L_0x0349
            r4 = r2
            m6.z r4 = (m6.z) r4
            android.view.View r2 = r4.h0()
            androidx.core.widget.NestedScrollView r2 = (androidx.core.widget.NestedScrollView) r2
            m0.h1 r2 = hb.h0.b0(r2)
            java.util.Iterator r2 = r2.iterator()
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x0343
            java.lang.Object r2 = r2.next()
            xa.j.d(r12, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            m0.h1 r2 = hb.h0.b0(r2)
            java.util.Iterator r2 = r2.iterator()
        L_0x0263:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0288
            java.lang.Object r5 = r2.next()
            android.view.View r5 = (android.view.View) r5
            int r10 = r5.getId()
            if (r10 == r9) goto L_0x027d
            int r10 = r5.getId()
            if (r10 == r8) goto L_0x027d
            r10 = 1
            goto L_0x027e
        L_0x027d:
            r10 = 0
        L_0x027e:
            if (r10 == 0) goto L_0x0282
            r10 = 0
            goto L_0x0284
        L_0x0282:
            r10 = 8
        L_0x0284:
            r5.setVisibility(r10)
            goto L_0x0263
        L_0x0288:
            z5.c r5 = r4.B0
            xa.j.c(r5)
            android.content.Context r2 = r4.f0()
            java.lang.Object r8 = r5.f17606l
            android.support.v4.media.session.u r8 = (android.support.v4.media.session.u) r8
            java.lang.String r9 = "storageSelectionContainer"
            xa.j.e(r9, r8)
            r4.s0(r2, r8)
            android.view.ViewGroup r8 = r5.f17605k
            android.widget.Spinner r8 = (android.widget.Spinner) r8
            android.widget.ArrayAdapter r9 = new android.widget.ArrayAdapter
            java.util.Map r10 = r0.getQualities()
            java.util.Set r10 = r10.keySet()
            java.lang.String[] r12 = new java.lang.String[r11]
            java.lang.Object[] r10 = r10.toArray(r12)
            r12 = 2131558594(0x7f0d00c2, float:1.8742508E38)
            r9.<init>(r2, r12, r10)
            r8.setAdapter(r9)
            long r8 = r0.getTotalDuration()
            r12 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r12
            java.lang.String r8 = android.text.format.DateUtils.formatElapsedTime(r8)
            java.lang.Object[] r9 = new java.lang.Object[r3]
            r9[r11] = r8
            r10 = 2131951764(0x7f130094, float:1.9539952E38)
            java.lang.String r2 = r2.getString(r10, r9)
            android.widget.TextView r9 = r5.f17595a
            r9.setText(r2)
            android.widget.TextView r2 = r5.f17608n
            com.github.andreyasadchy.xtra.ui.view.StrictEditText r2 = (com.github.andreyasadchy.xtra.ui.view.StrictEditText) r2
            int r9 = r8.length()
            java.lang.String r10 = "00:"
            if (r9 == r7) goto L_0x02e2
            goto L_0x02e6
        L_0x02e2:
            java.lang.String r8 = r10.concat(r8)
        L_0x02e6:
            r2.setHint(r8)
            android.view.View r8 = r5.f17607m
            com.github.andreyasadchy.xtra.ui.view.StrictEditText r8 = (com.github.andreyasadchy.xtra.ui.view.StrictEditText) r8
            long r14 = r0.getCurrentPosition()
            long r14 = r14 / r12
            java.lang.String r9 = android.text.format.DateUtils.formatElapsedTime(r14)
            int r11 = r9.length()
            if (r11 != r7) goto L_0x0300
            java.lang.String r9 = r10.concat(r9)
        L_0x0300:
            r8.setHint(r9)
            androidx.appcompat.widget.u3 r7 = new androidx.appcompat.widget.u3
            r7.<init>(r3, r5)
            r8.addTextChangedListener(r7)
            m6.x r3 = new m6.x
            r3.<init>(r8)
            r8.addTextChangedListener(r3)
            m6.x r3 = new m6.x
            r3.<init>(r2)
            r2.addTextChangedListener(r3)
            android.widget.TextView r3 = r5.f17600f
            android.widget.Button r3 = (android.widget.Button) r3
            i3.i r7 = new i3.i
            r7.<init>(r6, r4)
            r3.setOnClickListener(r7)
            m6.v r3 = new m6.v
            r3.<init>(r4, r5, r0, r0)
            r2.setOnEditorActionListener(r3)
            android.widget.TextView r2 = r5.f17601g
            r8 = r2
            android.widget.Button r8 = (android.widget.Button) r8
            i3.t r9 = new i3.t
            r7 = 1
            r2 = r9
            r3 = r4
            r4 = r5
            r5 = r0
            r6 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r8.setOnClickListener(r9)
            goto L_0x034e
        L_0x0343:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>(r5)
            throw r0
        L_0x0349:
            m6.z r2 = (m6.z) r2
            r2.m0(r11, r11)
        L_0x034e:
            la.v r0 = la.v.f9814a
            return r0
        L_0x0351:
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r2 = r1.f1470i
            m6.d r2 = (m6.d) r2
            android.view.View r4 = r2.h0()
            androidx.core.widget.NestedScrollView r4 = (androidx.core.widget.NestedScrollView) r4
            m0.h1 r4 = hb.h0.b0(r4)
            java.util.Iterator r4 = r4.iterator()
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x03f3
            java.lang.Object r4 = r4.next()
            xa.j.d(r12, r4)
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            m0.h1 r4 = hb.h0.b0(r4)
            java.util.Iterator r4 = r4.iterator()
        L_0x037c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x03a1
            java.lang.Object r5 = r4.next()
            android.view.View r5 = (android.view.View) r5
            int r6 = r5.getId()
            if (r6 == r9) goto L_0x0396
            int r6 = r5.getId()
            if (r6 == r8) goto L_0x0396
            r6 = 1
            goto L_0x0397
        L_0x0396:
            r6 = 0
        L_0x0397:
            if (r6 == 0) goto L_0x039b
            r6 = 0
            goto L_0x039d
        L_0x039b:
            r6 = 8
        L_0x039d:
            r5.setVisibility(r6)
            goto L_0x037c
        L_0x03a1:
            xa.j.e(r15, r0)
            androidx.appcompat.widget.i5 r3 = r2.B0
            xa.j.c(r3)
            android.content.Context r4 = r2.f0()
            androidx.appcompat.widget.i5 r5 = r2.B0
            xa.j.c(r5)
            java.lang.Object r5 = r5.f880h
            android.support.v4.media.session.u r5 = (android.support.v4.media.session.u) r5
            java.lang.String r6 = "binding.storageSelectionContainer"
            xa.j.e(r6, r5)
            r2.s0(r4, r5)
            java.lang.Object r5 = r3.f879g
            android.widget.Spinner r5 = (android.widget.Spinner) r5
            android.widget.ArrayAdapter r6 = new android.widget.ArrayAdapter
            java.util.Set r7 = r0.keySet()
            java.lang.String[] r8 = new java.lang.String[r11]
            java.lang.Object[] r7 = r7.toArray(r8)
            r8 = 2131558594(0x7f0d00c2, float:1.8742508E38)
            r6.<init>(r4, r8, r7)
            r5.setAdapter(r6)
            java.lang.Object r4 = r3.f875c
            android.widget.Button r4 = (android.widget.Button) r4
            i3.i r5 = new i3.i
            r6 = 6
            r5.<init>(r6, r2)
            r4.setOnClickListener(r5)
            java.lang.Object r4 = r3.f877e
            android.widget.Button r4 = (android.widget.Button) r4
            h6.d r5 = new h6.d
            r5.<init>(r3, r2, r0, r10)
            r4.setOnClickListener(r5)
            la.v r0 = la.v.f9814a
            return r0
        L_0x03f3:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>(r5)
            throw r0
        L_0x03f9:
            s7.e r0 = (s7.e) r0
            java.lang.Object r0 = r0.f14370a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.Object r2 = r1.f1470i
            l6.f r2 = (l6.f) r2
            if (r0 == 0) goto L_0x0426
            boolean r4 = r2.f9596f0
            if (r4 != 0) goto L_0x042d
            boolean r4 = r2.I()
            if (r4 == 0) goto L_0x0423
            boolean r4 = r2.f9598h0
            if (r4 == 0) goto L_0x041b
            r2.o0()
            goto L_0x0422
        L_0x041b:
            r2.m0()
            r2.f9598h0 = r3
            r2.f9599i0 = r3
        L_0x0422:
            r3 = 0
        L_0x0423:
            r2.f9597g0 = r3
            goto L_0x042d
        L_0x0426:
            boolean r3 = r2.f9598h0
            if (r3 == 0) goto L_0x042d
            r2.n0()
        L_0x042d:
            r2.f9596f0 = r0
            la.v r0 = la.v.f9814a
            return r0
        L_0x0432:
            com.github.andreyasadchy.xtra.model.ui.Clip r0 = (com.github.andreyasadchy.xtra.model.ui.Clip) r0
            xa.j.f(r15, r0)
            java.lang.Object r2 = r1.f1470i
            k6.e r2 = (k6.e) r2
            r2.f8809k0 = r0
            r2.b()
            la.v r0 = la.v.f9814a
            return r0
        L_0x0443:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.a(r0)
            la.v r0 = la.v.f9814a
            return r0
        L_0x044b:
            java.io.IOException r0 = (java.io.IOException) r0
            java.lang.Object r0 = r1.f1470i
            k4.i r0 = (k4.i) r0
            r0.f9110r = r3
            la.v r0 = la.v.f9814a
            return r0
        L_0x0456:
            n3.c r0 = (n3.c) r0
            java.lang.String r2 = "accessorState"
            xa.j.f(r2, r0)
            n3.d1 r2 = n3.d1.REFRESH
            n3.a1 r4 = r0.b(r2)
            n3.d1 r5 = n3.d1.APPEND
            n3.a1 r6 = r0.b(r5)
            n3.d1 r7 = n3.d1.PREPEND
            n3.a1 r8 = r0.b(r7)
            n3.c1 r9 = new n3.c1
            r9.<init>(r4, r8, r6)
            n3.a1 r4 = r9.f11079a
            boolean r4 = r4 instanceof n3.w0
            n3.w0[] r6 = r0.f11071b
            int r8 = r6.length
            int r8 = r8 + -1
            if (r8 < 0) goto L_0x0488
        L_0x047f:
            int r10 = r11 + 1
            r6[r11] = r14
            if (r10 <= r8) goto L_0x0486
            goto L_0x0488
        L_0x0486:
            r11 = r10
            goto L_0x047f
        L_0x0488:
            java.lang.Object r6 = r1.f1470i
            if (r4 == 0) goto L_0x0495
            r8 = r6
            java.util.List r8 = (java.util.List) r8
            r8.add(r2)
            r0.c(r2, r3)
        L_0x0495:
            n3.a1 r2 = r9.f11081c
            boolean r2 = r2 instanceof n3.w0
            if (r2 == 0) goto L_0x04a6
            if (r4 != 0) goto L_0x04a3
            r2 = r6
            java.util.List r2 = (java.util.List) r2
            r2.add(r5)
        L_0x04a3:
            r0.a(r5)
        L_0x04a6:
            n3.a1 r2 = r9.f11080b
            boolean r2 = r2 instanceof n3.w0
            if (r2 == 0) goto L_0x04b6
            if (r4 != 0) goto L_0x04b3
            java.util.List r6 = (java.util.List) r6
            r6.add(r7)
        L_0x04b3:
            r0.a(r7)
        L_0x04b6:
            la.v r0 = la.v.f9814a
            return r0
        L_0x04b9:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.invoke((java.lang.Throwable) r0)
            la.v r0 = la.v.f9814a
            return r0
        L_0x04c1:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.invoke((java.lang.Throwable) r0)
            la.v r0 = la.v.f9814a
            return r0
        L_0x04c9:
            n3.a r0 = (n3.a) r0
            xa.j.f(r15, r0)
            java.lang.Object r2 = r1.f1470i
            n3.d1 r2 = (n3.d1) r2
            n3.d1 r0 = r0.f11034a
            if (r0 != r2) goto L_0x04d7
            goto L_0x04d8
        L_0x04d7:
            r3 = 0
        L_0x04d8:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            return r0
        L_0x04dd:
            j3.r r0 = (j3.r) r0
            xa.j.f(r13, r0)
            java.lang.Object r2 = r1.f1470i
            l3.m r2 = (l3.m) r2
            androidx.lifecycle.u r4 = new androidx.lifecycle.u
            r4.<init>(r2, r3, r0)
            return r4
        L_0x04ec:
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "key"
            xa.j.f(r2, r0)
            java.lang.Object r2 = r1.f1470i
            j3.u0 r2 = (j3.u0) r2
            java.util.ArrayList r4 = r2.f8697d
            la.e r5 = r2.f8701h
            java.lang.Object r5 = r5.getValue()
            java.util.Map r5 = (java.util.Map) r5
            java.util.Collection r5 = r5.values()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x050e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0520
            java.lang.Object r7 = r5.next()
            j3.r0 r7 = (j3.r0) r7
            java.util.ArrayList r7 = r7.f8673b
            ma.w.k(r7, r6)
            goto L_0x050e
        L_0x0520:
            java.util.ArrayList r4 = ma.z.C(r6, r4)
            la.e r2 = r2.f8704k
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.ArrayList r2 = ma.z.C(r2, r4)
            boolean r0 = r2.contains(r0)
            r0 = r0 ^ r3
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x053a:
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            xa.j.f(r13, r0)
            java.lang.Object r2 = r1.f1470i
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r0 = r0.getValue()
            android.view.View r0 = (android.view.View) r0
            java.util.WeakHashMap r3 = m0.c1.f10054a
            java.lang.String r0 = m0.o0.k(r0)
            boolean r0 = ma.z.n(r2, r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x0558:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.invoke((java.lang.Throwable) r0)
            la.v r0 = la.v.f9814a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.k.invoke(java.lang.Object):java.lang.Object");
    }

    public final void invoke(Throwable th) {
        int i10 = this.f1469h;
        Object obj = this.f1470i;
        switch (i10) {
            case 4:
                ((k0) ((w0) obj).f8715b).h((Object) null);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                ((k5) obj).b((Throwable) null);
                return;
            default:
                ((i) obj).c();
                return;
        }
    }
}
