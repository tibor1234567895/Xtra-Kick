package k6;

import android.os.Parcelable;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public Parcelable f9222i;

    /* renamed from: j  reason: collision with root package name */
    public int f9223j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ClipsViewModel f9224k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f9225l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ VideoPeriodEnum f9226m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f9227n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f9228o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(ClipsViewModel clipsViewModel, boolean z10, VideoPeriodEnum videoPeriodEnum, int i10, boolean z11, e eVar) {
        super(2, eVar);
        this.f9224k = clipsViewModel;
        this.f9225l = z10;
        this.f9226m = videoPeriodEnum;
        this.f9227n = i10;
        this.f9228o = z11;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f9224k, this.f9225l, this.f9226m, this.f9227n, this.f9228o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x028c, code lost:
        if (r8 == hb.h0.l1(r1).getBoolean(r3, false)) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x028e, code lost:
        r1 = hb.h0.l1(r1).edit();
        xa.j.e("editor", r1);
        r1.putBoolean(r3, r8);
        r1.apply();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a3, code lost:
        return la.v.f9814a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        if (r13 == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
        r2 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
        if (r9 == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a8, code lost:
        if (r2 == null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r2.setSaveSort(java.lang.Boolean.TRUE);
        r2.setClipPeriod(r10.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b7, code lost:
        r7 = new com.github.andreyasadchy.xtra.model.offline.SortChannel(java.lang.String.valueOf(r11.f3374h.f13359g), java.lang.Boolean.TRUE, (java.lang.String) null, (java.lang.String) null, r10.getValue(), 12, (xa.f) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d6, code lost:
        if (r2 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d8, code lost:
        r2.setSaveSort(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00dd, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00df, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e0, code lost:
        if (r7 == null) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e2, code lost:
        r12 = r11.f3370d;
        r0.f9222i = r2;
        r0.f9223j = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
        if (r12.b(r7, r0) != r1) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ef, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f0, code lost:
        if (r8 == false) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f2, code lost:
        if (r2 == null) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f4, code lost:
        r2.setSaveSort(java.lang.Boolean.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fc, code lost:
        r12 = new com.github.andreyasadchy.xtra.model.offline.SortChannel(java.lang.String.valueOf(r11.f3374h.f13359g), java.lang.Boolean.valueOf(r9), (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, 28, (xa.f) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0117, code lost:
        r7 = r11.f3370d;
        r0.f9222i = null;
        r0.f9223j = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0123, code lost:
        if (r7.b(r2, r0) != r1) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0125, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0126, code lost:
        r2 = r11.f3370d;
        r0.f9223j = 9;
        r2 = r2.a("default", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0130, code lost:
        if (r2 != r1) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0132, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0133, code lost:
        r2 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0135, code lost:
        if (r2 == null) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0137, code lost:
        r2.setClipPeriod(r10.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013f, code lost:
        r12 = new com.github.andreyasadchy.xtra.model.offline.SortChannel("default", (java.lang.Boolean) null, (java.lang.String) null, (java.lang.String) null, r10.getValue(), 14, (xa.f) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0153, code lost:
        r4 = r11.f3370d;
        r0.f9223j = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015d, code lost:
        if (r4.b(r2, r0) != r1) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0160, code lost:
        com.github.andreyasadchy.xtra.XtraApp.f3319k.getClass();
        r1 = y5.v.a().getApplicationContext();
        xa.j.e("appContext", r1);
        r3 = "sort_default_channel_clips";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x017a, code lost:
        if (r8 == hb.h0.l1(r1).getBoolean(r3, false)) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x018f, code lost:
        r2 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0191, code lost:
        if (r9 == false) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0193, code lost:
        if (r2 == null) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0195, code lost:
        r2.setSaveSort(java.lang.Boolean.TRUE);
        r2.setClipPeriod(r10.getValue());
        r2.setClipLanguageIndex(new java.lang.Integer(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01aa, code lost:
        r13 = new com.github.andreyasadchy.xtra.model.offline.SortGame(java.lang.String.valueOf(r11.f3374h.f13353a), java.lang.Boolean.TRUE, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.Integer) null, r10.getValue(), new java.lang.Integer(r7), 60, (xa.f) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d2, code lost:
        if (r2 == null) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01d4, code lost:
        r2.setSaveSort(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01d9, code lost:
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01db, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01dc, code lost:
        if (r12 == null) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01de, code lost:
        r13 = r11.f3371e;
        r0.f9222i = r2;
        r0.f9223j = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01e9, code lost:
        if (r13.b(r12, r0) != r1) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01eb, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01ec, code lost:
        if (r8 == false) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ee, code lost:
        if (r2 == null) goto L_0x01f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01f0, code lost:
        r2.setSaveSort(java.lang.Boolean.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f8, code lost:
        r12 = new com.github.andreyasadchy.xtra.model.offline.SortGame(java.lang.String.valueOf(r11.f3374h.f13353a), java.lang.Boolean.valueOf(r9), (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.Integer) null, (java.lang.String) null, (java.lang.Integer) null, 252, (xa.f) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0219, code lost:
        r9 = r11.f3371e;
        r0.f9222i = null;
        r0.f9223j = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0224, code lost:
        if (r9.b(r2, r0) != r1) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0226, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0227, code lost:
        r2 = r11.f3371e;
        r0.f9223j = 4;
        r2 = r2.a("default", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0230, code lost:
        if (r2 != r1) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0232, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0233, code lost:
        r2 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0235, code lost:
        if (r2 == null) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0237, code lost:
        r2.setClipPeriod(r10.getValue());
        r2.setClipLanguageIndex(new java.lang.Integer(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0247, code lost:
        r12 = new com.github.andreyasadchy.xtra.model.offline.SortGame("default", (java.lang.Boolean) null, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null, (java.lang.Integer) null, r10.getValue(), new java.lang.Integer(r7), 62, (xa.f) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0266, code lost:
        r4 = r11.f3371e;
        r0.f9223j = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x026f, code lost:
        if (r4.b(r2, r0) != r1) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0271, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0272, code lost:
        com.github.andreyasadchy.xtra.XtraApp.f3319k.getClass();
        r1 = y5.v.a().getApplicationContext();
        xa.j.e("appContext", r1);
        r3 = "sort_default_game_clips";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9223j
            java.lang.String r3 = "appContext"
            java.lang.String r4 = "default"
            r5 = 0
            r6 = 0
            int r7 = r0.f9227n
            boolean r8 = r0.f9228o
            boolean r9 = r0.f9225l
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r10 = r0.f9226m
            com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel r11 = r0.f9224k
            switch(r2) {
                case 0: goto L_0x0062;
                case 1: goto L_0x005b;
                case 2: goto L_0x0052;
                case 3: goto L_0x004d;
                case 4: goto L_0x0046;
                case 5: goto L_0x0041;
                case 6: goto L_0x003b;
                case 7: goto L_0x0032;
                case 8: goto L_0x002d;
                case 9: goto L_0x0026;
                case 10: goto L_0x0021;
                default: goto L_0x0019;
            }
        L_0x0019:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0021:
            hb.h0.O1(r25)
            goto L_0x0160
        L_0x0026:
            hb.h0.O1(r25)
            r2 = r25
            goto L_0x0133
        L_0x002d:
            hb.h0.O1(r25)
            goto L_0x0126
        L_0x0032:
            android.os.Parcelable r2 = r0.f9222i
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r2
            hb.h0.O1(r25)
            goto L_0x00f0
        L_0x003b:
            hb.h0.O1(r25)
            r2 = r25
            goto L_0x00a4
        L_0x0041:
            hb.h0.O1(r25)
            goto L_0x0272
        L_0x0046:
            hb.h0.O1(r25)
            r2 = r25
            goto L_0x0233
        L_0x004d:
            hb.h0.O1(r25)
            goto L_0x0227
        L_0x0052:
            android.os.Parcelable r2 = r0.f9222i
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r2
            hb.h0.O1(r25)
            goto L_0x01ec
        L_0x005b:
            hb.h0.O1(r25)
            r2 = r25
            goto L_0x018f
        L_0x0062:
            hb.h0.O1(r25)
            q6.f r2 = r11.f3374h
            int r12 = r2.f13353a
            r13 = 1
            q6.f r14 = r11.f3374h
            if (r12 != 0) goto L_0x017e
            java.lang.String r2 = r2.f13354b
            if (r2 == 0) goto L_0x007b
            boolean r2 = fb.w.h(r2)
            if (r2 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r2 = 0
            goto L_0x007c
        L_0x007b:
            r2 = 1
        L_0x007c:
            if (r2 != 0) goto L_0x0080
            goto L_0x017e
        L_0x0080:
            int r2 = r14.f13359g
            if (r2 != 0) goto L_0x0092
            java.lang.String r2 = r14.f13360h
            if (r2 == 0) goto L_0x0090
            boolean r2 = fb.w.h(r2)
            if (r2 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r13 = 0
        L_0x0090:
            if (r13 != 0) goto L_0x02a1
        L_0x0092:
            int r2 = r14.f13359g
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r7 = 6
            r0.f9223j = r7
            e6.c2 r7 = r11.f3370d
            java.lang.Object r2 = r7.a(r2, r0)
            if (r2 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r2
            if (r9 == 0) goto L_0x00d6
            if (r2 == 0) goto L_0x00b7
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r2.setSaveSort(r7)
            java.lang.String r7 = r10.getValue()
            r2.setClipPeriod(r7)
            goto L_0x00dd
        L_0x00b7:
            q6.f r7 = r11.f3374h
            int r7 = r7.f13359g
            com.github.andreyasadchy.xtra.model.offline.SortChannel r20 = new com.github.andreyasadchy.xtra.model.offline.SortChannel
            java.lang.String r13 = java.lang.String.valueOf(r7)
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            r15 = 0
            r16 = 0
            java.lang.String r17 = r10.getValue()
            r18 = 12
            r19 = 0
            r12 = r20
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            r7 = r20
            goto L_0x00e0
        L_0x00d6:
            if (r2 == 0) goto L_0x00df
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r2.setSaveSort(r7)
        L_0x00dd:
            r7 = r2
            goto L_0x00e0
        L_0x00df:
            r7 = r5
        L_0x00e0:
            if (r7 == 0) goto L_0x00f0
            e6.c2 r12 = r11.f3370d
            r0.f9222i = r2
            r13 = 7
            r0.f9223j = r13
            java.lang.Object r7 = r12.b(r7, r0)
            if (r7 != r1) goto L_0x00f0
            return r1
        L_0x00f0:
            if (r8 == 0) goto L_0x0160
            if (r2 == 0) goto L_0x00fc
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r9)
            r2.setSaveSort(r7)
            goto L_0x0117
        L_0x00fc:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = new com.github.andreyasadchy.xtra.model.offline.SortChannel
            q6.f r7 = r11.f3374h
            int r7 = r7.f13359g
            java.lang.String r13 = java.lang.String.valueOf(r7)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r9)
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 28
            r19 = 0
            r12 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
        L_0x0117:
            e6.c2 r7 = r11.f3370d
            r0.f9222i = r5
            r5 = 8
            r0.f9223j = r5
            java.lang.Object r2 = r7.b(r2, r0)
            if (r2 != r1) goto L_0x0126
            return r1
        L_0x0126:
            e6.c2 r2 = r11.f3370d
            r5 = 9
            r0.f9223j = r5
            java.lang.Object r2 = r2.a(r4, r0)
            if (r2 != r1) goto L_0x0133
            return r1
        L_0x0133:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r2
            if (r2 == 0) goto L_0x013f
            java.lang.String r4 = r10.getValue()
            r2.setClipPeriod(r4)
            goto L_0x0153
        L_0x013f:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = new com.github.andreyasadchy.xtra.model.offline.SortChannel
            java.lang.String r13 = "default"
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r17 = r10.getValue()
            r18 = 14
            r19 = 0
            r12 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
        L_0x0153:
            e6.c2 r4 = r11.f3370d
            r5 = 10
            r0.f9223j = r5
            java.lang.Object r2 = r4.b(r2, r0)
            if (r2 != r1) goto L_0x0160
            return r1
        L_0x0160:
            y5.v r1 = com.github.andreyasadchy.xtra.XtraApp.f3319k
            r1.getClass()
            android.app.Application r1 = y5.v.a()
            android.content.Context r1 = r1.getApplicationContext()
            xa.j.e(r3, r1)
            android.content.SharedPreferences r2 = hb.h0.l1(r1)
            java.lang.String r3 = "sort_default_channel_clips"
            boolean r2 = r2.getBoolean(r3, r6)
            if (r8 == r2) goto L_0x02a1
            goto L_0x028e
        L_0x017e:
            int r2 = r14.f13353a
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.f9223j = r13
            e6.f2 r12 = r11.f3371e
            java.lang.Object r2 = r12.a(r2, r0)
            if (r2 != r1) goto L_0x018f
            return r1
        L_0x018f:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r2
            if (r9 == 0) goto L_0x01d2
            if (r2 == 0) goto L_0x01aa
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r2.setSaveSort(r12)
            java.lang.String r12 = r10.getValue()
            r2.setClipPeriod(r12)
            java.lang.Integer r12 = new java.lang.Integer
            r12.<init>(r7)
            r2.setClipLanguageIndex(r12)
            goto L_0x01d9
        L_0x01aa:
            com.github.andreyasadchy.xtra.model.offline.SortGame r12 = new com.github.andreyasadchy.xtra.model.offline.SortGame
            q6.f r13 = r11.f3374h
            int r13 = r13.f13353a
            java.lang.String r14 = java.lang.String.valueOf(r13)
            java.lang.Boolean r15 = java.lang.Boolean.TRUE
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            java.lang.String r20 = r10.getValue()
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r7)
            r22 = 60
            r23 = 0
            r21 = r13
            r13 = r12
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            goto L_0x01dc
        L_0x01d2:
            if (r2 == 0) goto L_0x01db
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            r2.setSaveSort(r12)
        L_0x01d9:
            r12 = r2
            goto L_0x01dc
        L_0x01db:
            r12 = r5
        L_0x01dc:
            if (r12 == 0) goto L_0x01ec
            e6.f2 r13 = r11.f3371e
            r0.f9222i = r2
            r14 = 2
            r0.f9223j = r14
            java.lang.Object r12 = r13.b(r12, r0)
            if (r12 != r1) goto L_0x01ec
            return r1
        L_0x01ec:
            if (r8 == 0) goto L_0x0272
            if (r2 == 0) goto L_0x01f8
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r2.setSaveSort(r9)
            goto L_0x0219
        L_0x01f8:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = new com.github.andreyasadchy.xtra.model.offline.SortGame
            q6.f r12 = r11.f3374h
            int r12 = r12.f13353a
            java.lang.String r13 = java.lang.String.valueOf(r12)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r9)
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 252(0xfc, float:3.53E-43)
            r22 = 0
            r12 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L_0x0219:
            e6.f2 r9 = r11.f3371e
            r0.f9222i = r5
            r5 = 3
            r0.f9223j = r5
            java.lang.Object r2 = r9.b(r2, r0)
            if (r2 != r1) goto L_0x0227
            return r1
        L_0x0227:
            e6.f2 r2 = r11.f3371e
            r5 = 4
            r0.f9223j = r5
            java.lang.Object r2 = r2.a(r4, r0)
            if (r2 != r1) goto L_0x0233
            return r1
        L_0x0233:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r2
            if (r2 == 0) goto L_0x0247
            java.lang.String r4 = r10.getValue()
            r2.setClipPeriod(r4)
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r7)
            r2.setClipLanguageIndex(r4)
            goto L_0x0266
        L_0x0247:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = new com.github.andreyasadchy.xtra.model.offline.SortGame
            java.lang.String r13 = "default"
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            java.lang.String r19 = r10.getValue()
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r7)
            r21 = 62
            r22 = 0
            r12 = r2
            r20 = r4
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L_0x0266:
            e6.f2 r4 = r11.f3371e
            r5 = 5
            r0.f9223j = r5
            java.lang.Object r2 = r4.b(r2, r0)
            if (r2 != r1) goto L_0x0272
            return r1
        L_0x0272:
            y5.v r1 = com.github.andreyasadchy.xtra.XtraApp.f3319k
            r1.getClass()
            android.app.Application r1 = y5.v.a()
            android.content.Context r1 = r1.getApplicationContext()
            xa.j.e(r3, r1)
            android.content.SharedPreferences r2 = hb.h0.l1(r1)
            java.lang.String r3 = "sort_default_game_clips"
            boolean r2 = r2.getBoolean(r3, r6)
            if (r8 == r2) goto L_0x02a1
        L_0x028e:
            android.content.SharedPreferences r1 = hb.h0.l1(r1)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.lang.String r2 = "editor"
            xa.j.e(r2, r1)
            r1.putBoolean(r3, r8)
            r1.apply()
        L_0x02a1:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.h.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
