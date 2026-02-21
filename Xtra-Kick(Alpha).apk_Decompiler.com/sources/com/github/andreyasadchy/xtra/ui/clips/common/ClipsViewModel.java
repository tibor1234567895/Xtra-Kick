package com.github.andreyasadchy.xtra.ui.clips.common;

import androidx.lifecycle.o0;
import androidx.lifecycle.w1;
import e6.c2;
import e6.f2;
import e6.x;
import kb.e1;
import kb.m0;
import q6.f;

public final class ClipsViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final c2 f3370d;

    /* renamed from: e  reason: collision with root package name */
    public final f2 f3371e;

    /* renamed from: f  reason: collision with root package name */
    public final x f3372f;

    /* renamed from: g  reason: collision with root package name */
    public final o0 f3373g;

    /* renamed from: h  reason: collision with root package name */
    public final f f3374h;

    /* renamed from: i  reason: collision with root package name */
    public final e1 f3375i;

    /* renamed from: j  reason: collision with root package name */
    public final m0 f3376j;

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0140  */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClipsViewModel(android.content.Context r8, e6.c2 r9, e6.f2 r10, e6.x r11, androidx.lifecycle.j1 r12) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            xa.j.f(r0, r8)
            java.lang.String r0 = "sortChannelRepository"
            xa.j.f(r0, r9)
            java.lang.String r0 = "sortGameRepository"
            xa.j.f(r0, r10)
            java.lang.String r0 = "apiRepository"
            xa.j.f(r0, r11)
            java.lang.String r0 = "savedStateHandle"
            xa.j.f(r0, r12)
            r7.<init>()
            r7.f3370d = r9
            r7.f3371e = r10
            r7.f3372f = r11
            androidx.lifecycle.o0 r9 = new androidx.lifecycle.o0
            r9.<init>()
            r7.f3373g = r9
            q6.e r10 = q6.f.f13352i
            r10.getClass()
            q6.f r10 = q6.e.a(r12)
            r7.f3374h = r10
            r11 = 0
            r12 = 1
            r0 = 0
            int r1 = r10.f13353a
            if (r1 != 0) goto L_0x008d
            java.lang.String r2 = r10.f13354b
            if (r2 == 0) goto L_0x0048
            boolean r2 = fb.w.h(r2)
            if (r2 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r2 = 0
            goto L_0x0049
        L_0x0048:
            r2 = 1
        L_0x0049:
            if (r2 != 0) goto L_0x004c
            goto L_0x008d
        L_0x004c:
            int r1 = r10.f13359g
            if (r1 != 0) goto L_0x0064
            java.lang.String r10 = r10.f13360h
            if (r10 == 0) goto L_0x005d
            boolean r10 = fb.w.h(r10)
            if (r10 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r10 = 0
            goto L_0x005e
        L_0x005d:
            r10 = 1
        L_0x005e:
            if (r10 != 0) goto L_0x0061
            goto L_0x0064
        L_0x0061:
            r10 = r11
            r1 = r10
            goto L_0x00b4
        L_0x0064:
            k6.l r10 = new k6.l
            r10.<init>(r7, r1, r11)
            java.lang.Object r10 = hb.h0.v1(pa.l.f12754h, r10)
            com.github.andreyasadchy.xtra.model.offline.SortChannel r10 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r10
            if (r10 == 0) goto L_0x007c
            java.lang.Boolean r1 = r10.getSaveSort()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = xa.j.a(r1, r2)
            goto L_0x007d
        L_0x007c:
            r1 = 0
        L_0x007d:
            if (r1 != 0) goto L_0x008a
            k6.m r10 = new k6.m
            r10.<init>(r7, r11)
            java.lang.Object r10 = hb.h0.v1(pa.l.f12754h, r10)
            com.github.andreyasadchy.xtra.model.offline.SortChannel r10 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r10
        L_0x008a:
            r1 = r10
            r10 = r11
            goto L_0x00b4
        L_0x008d:
            k6.j r10 = new k6.j
            r10.<init>(r7, r1, r11)
            java.lang.Object r10 = hb.h0.v1(pa.l.f12754h, r10)
            com.github.andreyasadchy.xtra.model.offline.SortGame r10 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r10
            if (r10 == 0) goto L_0x00a5
            java.lang.Boolean r1 = r10.getSaveSort()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = xa.j.a(r1, r2)
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            if (r1 != 0) goto L_0x00b3
            k6.k r10 = new k6.k
            r10.<init>(r7, r11)
            java.lang.Object r10 = hb.h0.v1(pa.l.f12754h, r10)
            com.github.andreyasadchy.xtra.model.offline.SortGame r10 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r10
        L_0x00b3:
            r1 = r11
        L_0x00b4:
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 2131952438(0x7f130336, float:1.9541319E38)
            java.lang.String r4 = r8.getString(r4)
            r3[r0] = r4
            if (r10 == 0) goto L_0x00c8
            java.lang.String r4 = r10.getClipPeriod()
            if (r4 != 0) goto L_0x00d0
        L_0x00c8:
            if (r1 == 0) goto L_0x00cf
            java.lang.String r4 = r1.getClipPeriod()
            goto L_0x00d0
        L_0x00cf:
            r4 = r11
        L_0x00d0:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r5 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.DAY
            java.lang.String r6 = r5.getValue()
            boolean r6 = xa.j.a(r4, r6)
            if (r6 == 0) goto L_0x00e0
            r4 = 2131952397(0x7f13030d, float:1.9541236E38)
            goto L_0x0103
        L_0x00e0:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r6 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.MONTH
            java.lang.String r6 = r6.getValue()
            boolean r6 = xa.j.a(r4, r6)
            if (r6 == 0) goto L_0x00f0
            r4 = 2131952379(0x7f1302fb, float:1.95412E38)
            goto L_0x0103
        L_0x00f0:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r6 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.ALL
            java.lang.String r6 = r6.getValue()
            boolean r4 = xa.j.a(r4, r6)
            if (r4 == 0) goto L_0x0100
            r4 = 2131951647(0x7f13001f, float:1.9539714E38)
            goto L_0x0103
        L_0x0100:
            r4 = 2131952380(0x7f1302fc, float:1.9541201E38)
        L_0x0103:
            java.lang.String r4 = r8.getString(r4)
            r3[r12] = r4
            r12 = 2131952345(0x7f1302d9, float:1.954113E38)
            java.lang.String r8 = r8.getString(r12, r3)
            r9.l(r8)
            k6.g r8 = new k6.g
            if (r10 == 0) goto L_0x011d
            java.lang.Boolean r9 = r10.getSaveSort()
            if (r9 != 0) goto L_0x0125
        L_0x011d:
            if (r1 == 0) goto L_0x0124
            java.lang.Boolean r9 = r1.getSaveSort()
            goto L_0x0125
        L_0x0124:
            r9 = r11
        L_0x0125:
            if (r10 == 0) goto L_0x012d
            java.lang.String r12 = r10.getClipPeriod()
            if (r12 != 0) goto L_0x0135
        L_0x012d:
            if (r1 == 0) goto L_0x0134
            java.lang.String r12 = r1.getClipPeriod()
            goto L_0x0135
        L_0x0134:
            r12 = r11
        L_0x0135:
            java.lang.String r1 = r5.getValue()
            boolean r1 = xa.j.a(r12, r1)
            if (r1 == 0) goto L_0x0140
            goto L_0x015c
        L_0x0140:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r5 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.MONTH
            java.lang.String r1 = r5.getValue()
            boolean r1 = xa.j.a(r12, r1)
            if (r1 == 0) goto L_0x014d
            goto L_0x015c
        L_0x014d:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r5 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.ALL
            java.lang.String r1 = r5.getValue()
            boolean r12 = xa.j.a(r12, r1)
            if (r12 == 0) goto L_0x015a
            goto L_0x015c
        L_0x015a:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r5 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.WEEK
        L_0x015c:
            if (r10 == 0) goto L_0x0168
            java.lang.Integer r10 = r10.getClipLanguageIndex()
            if (r10 == 0) goto L_0x0168
            int r0 = r10.intValue()
        L_0x0168:
            r8.<init>(r9, r5, r0)
            kb.e1 r8 = kb.f1.a(r8)
            r7.f3375i = r8
            n3.t r9 = new n3.t
            r9.<init>((pa.e) r11, (java.lang.Object) r7, (int) r2)
            lb.n r8 = hb.h0.Y1(r8, r9)
            hb.f0 r9 = hb.h0.I0(r7)
            kb.m0 r8 = hb.h0.s(r8, r9)
            r7.f3376j = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel.<init>(android.content.Context, e6.c2, e6.f2, e6.x, androidx.lifecycle.j1):void");
    }
}
