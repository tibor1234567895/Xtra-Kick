package com.github.andreyasadchy.xtra.ui.videos.game;

import androidx.lifecycle.o0;
import e6.f2;
import kb.e1;
import kb.m0;
import m7.e;
import q6.f;

public final class GameVideosViewModel extends e {

    /* renamed from: h  reason: collision with root package name */
    public final f2 f3524h;

    /* renamed from: i  reason: collision with root package name */
    public final o0 f3525i;

    /* renamed from: j  reason: collision with root package name */
    public final f f3526j;

    /* renamed from: k  reason: collision with root package name */
    public final e1 f3527k;

    /* renamed from: l  reason: collision with root package name */
    public final m0 f3528l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0127, code lost:
        if (xa.j.a(r15, r2.getValue()) != false) goto L_0x0129;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016f  */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GameVideosViewModel(android.content.Context r10, e6.f2 r11, e6.x r12, e6.z1 r13, e6.e0 r14, androidx.lifecycle.j1 r15) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            xa.j.f(r0, r10)
            java.lang.String r0 = "sortGameRepository"
            xa.j.f(r0, r11)
            java.lang.String r0 = "repository"
            xa.j.f(r0, r12)
            java.lang.String r0 = "playerRepository"
            xa.j.f(r0, r13)
            java.lang.String r0 = "bookmarksRepository"
            xa.j.f(r0, r14)
            java.lang.String r0 = "savedStateHandle"
            xa.j.f(r0, r15)
            r9.<init>(r13, r14, r12)
            r9.f3524h = r11
            androidx.lifecycle.o0 r11 = new androidx.lifecycle.o0
            r11.<init>()
            r9.f3525i = r11
            q6.e r12 = q6.f.f13352i
            r12.getClass()
            q6.f r12 = q6.e.a(r15)
            r9.f3526j = r12
            p7.h r13 = new p7.h
            int r12 = r12.f13353a
            r14 = 0
            r13.<init>(r9, r12, r14)
            java.lang.Object r12 = hb.h0.v1(pa.l.f12754h, r13)
            com.github.andreyasadchy.xtra.model.offline.SortGame r12 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r12
            r13 = 0
            if (r12 == 0) goto L_0x0051
            java.lang.Boolean r15 = r12.getSaveSort()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r15 = xa.j.a(r15, r0)
            goto L_0x0052
        L_0x0051:
            r15 = 0
        L_0x0052:
            if (r15 != 0) goto L_0x005f
            p7.g r12 = new p7.g
            r12.<init>(r9, r14)
            java.lang.Object r12 = hb.h0.v1(pa.l.f12754h, r12)
            com.github.andreyasadchy.xtra.model.offline.SortGame r12 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r12
        L_0x005f:
            r15 = 2
            java.lang.Object[] r15 = new java.lang.Object[r15]
            if (r12 == 0) goto L_0x0069
            java.lang.String r0 = r12.getVideoSort()
            goto L_0x006a
        L_0x0069:
            r0 = r14
        L_0x006a:
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r1 = com.github.andreyasadchy.xtra.model.ui.VideoSortEnum.TIME
            java.lang.String r2 = r1.getValue()
            boolean r0 = xa.j.a(r0, r2)
            if (r0 == 0) goto L_0x007a
            r0 = 2131952412(0x7f13031c, float:1.9541266E38)
            goto L_0x007d
        L_0x007a:
            r0 = 2131952438(0x7f130336, float:1.9541319E38)
        L_0x007d:
            java.lang.String r0 = r10.getString(r0)
            r15[r13] = r0
            if (r12 == 0) goto L_0x008a
            java.lang.String r0 = r12.getVideoPeriod()
            goto L_0x008b
        L_0x008a:
            r0 = r14
        L_0x008b:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r2 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.DAY
            java.lang.String r3 = r2.getValue()
            boolean r3 = xa.j.a(r0, r3)
            if (r3 == 0) goto L_0x009b
            r0 = 2131952397(0x7f13030d, float:1.9541236E38)
            goto L_0x00be
        L_0x009b:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r3 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.MONTH
            java.lang.String r3 = r3.getValue()
            boolean r3 = xa.j.a(r0, r3)
            if (r3 == 0) goto L_0x00ab
            r0 = 2131952379(0x7f1302fb, float:1.95412E38)
            goto L_0x00be
        L_0x00ab:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r3 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.ALL
            java.lang.String r3 = r3.getValue()
            boolean r0 = xa.j.a(r0, r3)
            if (r0 == 0) goto L_0x00bb
            r0 = 2131951647(0x7f13001f, float:1.9539714E38)
            goto L_0x00be
        L_0x00bb:
            r0 = 2131952380(0x7f1302fc, float:1.9541201E38)
        L_0x00be:
            java.lang.String r0 = r10.getString(r0)
            r3 = 1
            r15[r3] = r0
            r0 = 2131952345(0x7f1302d9, float:1.954113E38)
            java.lang.String r15 = r10.getString(r0, r15)
            r11.l(r15)
            p7.e r11 = new p7.e
            if (r12 == 0) goto L_0x00d9
            java.lang.Boolean r15 = r12.getSaveSort()
            r4 = r15
            goto L_0x00da
        L_0x00d9:
            r4 = r14
        L_0x00da:
            if (r12 == 0) goto L_0x00e1
            java.lang.String r15 = r12.getVideoSort()
            goto L_0x00e2
        L_0x00e1:
            r15 = r14
        L_0x00e2:
            java.lang.String r0 = r1.getValue()
            boolean r15 = xa.j.a(r15, r0)
            if (r15 == 0) goto L_0x00ed
            goto L_0x00ef
        L_0x00ed:
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r1 = com.github.andreyasadchy.xtra.model.ui.VideoSortEnum.VIEWS
        L_0x00ef:
            r5 = r1
            com.github.andreyasadchy.xtra.model.Account$Companion r15 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r15 = r15.get(r10)
            int r15 = r15.getId()
            if (r15 == 0) goto L_0x00fd
            goto L_0x012b
        L_0x00fd:
            if (r12 == 0) goto L_0x0104
            java.lang.String r15 = r12.getVideoPeriod()
            goto L_0x0105
        L_0x0104:
            r15 = r14
        L_0x0105:
            java.lang.String r0 = r2.getValue()
            boolean r0 = xa.j.a(r15, r0)
            if (r0 == 0) goto L_0x0110
            goto L_0x0129
        L_0x0110:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r2 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.MONTH
            java.lang.String r0 = r2.getValue()
            boolean r0 = xa.j.a(r15, r0)
            if (r0 == 0) goto L_0x011d
            goto L_0x0129
        L_0x011d:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r2 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.ALL
            java.lang.String r0 = r2.getValue()
            boolean r15 = xa.j.a(r15, r0)
            if (r15 == 0) goto L_0x012b
        L_0x0129:
            r6 = r2
            goto L_0x012e
        L_0x012b:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r15 = com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum.WEEK
            r6 = r15
        L_0x012e:
            if (r12 == 0) goto L_0x0135
            java.lang.String r15 = r12.getVideoType()
            goto L_0x0136
        L_0x0135:
            r15 = r14
        L_0x0136:
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r0 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.ARCHIVE
            java.lang.String r1 = r0.getValue()
            boolean r1 = xa.j.a(r15, r1)
            if (r1 == 0) goto L_0x0143
            goto L_0x015c
        L_0x0143:
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r0 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.HIGHLIGHT
            java.lang.String r1 = r0.getValue()
            boolean r1 = xa.j.a(r15, r1)
            if (r1 == 0) goto L_0x0150
            goto L_0x015c
        L_0x0150:
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r0 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.UPLOAD
            java.lang.String r1 = r0.getValue()
            boolean r15 = xa.j.a(r15, r1)
            if (r15 == 0) goto L_0x015e
        L_0x015c:
            r7 = r0
            goto L_0x0161
        L_0x015e:
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r15 = com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum.ALL
            r7 = r15
        L_0x0161:
            if (r12 == 0) goto L_0x016f
            java.lang.Integer r12 = r12.getVideoLanguageIndex()
            if (r12 == 0) goto L_0x016f
            int r13 = r12.intValue()
            r8 = r13
            goto L_0x0170
        L_0x016f:
            r8 = 0
        L_0x0170:
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            kb.e1 r11 = kb.f1.a(r11)
            r9.f3527k = r11
            n3.z1 r12 = new n3.z1
            r13 = 3
            r12.<init>(r14, r10, r9, r13)
            lb.n r10 = hb.h0.Y1(r11, r12)
            hb.f0 r11 = hb.h0.I0(r9)
            kb.m0 r10 = hb.h0.s(r10, r11)
            r9.f3528l = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel.<init>(android.content.Context, e6.f2, e6.x, e6.z1, e6.e0, androidx.lifecycle.j1):void");
    }
}
