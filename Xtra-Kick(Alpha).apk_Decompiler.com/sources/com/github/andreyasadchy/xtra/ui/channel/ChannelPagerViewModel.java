package com.github.andreyasadchy.xtra.ui.channel;

import androidx.lifecycle.o0;
import androidx.lifecycle.w1;
import e6.e0;
import e6.o1;
import e6.x;
import e6.y0;
import h6.q;

public final class ChannelPagerViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f3338d;

    /* renamed from: e  reason: collision with root package name */
    public final y0 f3339e;

    /* renamed from: f  reason: collision with root package name */
    public final o1 f3340f;

    /* renamed from: g  reason: collision with root package name */
    public final e0 f3341g;

    /* renamed from: h  reason: collision with root package name */
    public final q f3342h;

    /* renamed from: i  reason: collision with root package name */
    public final o0 f3343i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3344j;

    /* renamed from: k  reason: collision with root package name */
    public final o0 f3345k;

    /* renamed from: l  reason: collision with root package name */
    public final o0 f3346l;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChannelPagerViewModel(e6.x r9, e6.y0 r10, e6.o1 r11, e6.e0 r12, androidx.lifecycle.j1 r13) {
        /*
            r8 = this;
            java.lang.String r0 = "repository"
            xa.j.f(r0, r9)
            java.lang.String r0 = "localFollowsChannel"
            xa.j.f(r0, r10)
            java.lang.String r0 = "offlineRepository"
            xa.j.f(r0, r11)
            java.lang.String r0 = "bookmarksRepository"
            xa.j.f(r0, r12)
            java.lang.String r0 = "savedStateHandle"
            xa.j.f(r0, r13)
            r8.<init>()
            r8.f3338d = r9
            r8.f3339e = r10
            r8.f3340f = r11
            r8.f3341g = r12
            h6.p r9 = h6.q.f7679g
            r9.getClass()
            java.lang.String r9 = "channelId"
            boolean r10 = r13.b(r9)
            r11 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            if (r10 == 0) goto L_0x0047
            java.lang.Object r9 = r13.c(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            if (r9 == 0) goto L_0x003f
            goto L_0x0048
        L_0x003f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Argument \"channelId\" of type integer does not support null values"
            r9.<init>(r10)
            throw r9
        L_0x0047:
            r9 = r11
        L_0x0048:
            java.lang.String r10 = "channelLogin"
            boolean r12 = r13.b(r10)
            r0 = 0
            if (r12 == 0) goto L_0x0059
            java.lang.Object r10 = r13.c(r10)
            java.lang.String r10 = (java.lang.String) r10
            r4 = r10
            goto L_0x005a
        L_0x0059:
            r4 = r0
        L_0x005a:
            java.lang.String r10 = "channelName"
            boolean r12 = r13.b(r10)
            if (r12 == 0) goto L_0x006a
            java.lang.Object r10 = r13.c(r10)
            java.lang.String r10 = (java.lang.String) r10
            r5 = r10
            goto L_0x006b
        L_0x006a:
            r5 = r0
        L_0x006b:
            java.lang.String r10 = "channelLogo"
            boolean r12 = r13.b(r10)
            if (r12 == 0) goto L_0x007a
            java.lang.Object r10 = r13.c(r10)
            r0 = r10
            java.lang.String r0 = (java.lang.String) r0
        L_0x007a:
            r6 = r0
            java.lang.String r10 = "updateLocal"
            boolean r12 = r13.b(r10)
            if (r12 == 0) goto L_0x0094
            java.lang.Object r10 = r13.c(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r10 == 0) goto L_0x008c
            goto L_0x0096
        L_0x008c:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Argument \"updateLocal\" of type boolean does not support null values"
            r9.<init>(r10)
            throw r9
        L_0x0094:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
        L_0x0096:
            java.lang.String r12 = "streamId"
            boolean r0 = r13.b(r12)
            if (r0 == 0) goto L_0x00af
            java.lang.Object r11 = r13.c(r12)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L_0x00a7
            goto L_0x00af
        L_0x00a7:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Argument \"streamId\" of type integer does not support null values"
            r9.<init>(r10)
            throw r9
        L_0x00af:
            h6.q r12 = new h6.q
            int r2 = r9.intValue()
            boolean r7 = r10.booleanValue()
            int r3 = r11.intValue()
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f3342h = r12
            androidx.lifecycle.o0 r9 = new androidx.lifecycle.o0
            r9.<init>()
            r8.f3343i = r9
            androidx.lifecycle.o0 r9 = new androidx.lifecycle.o0
            r9.<init>()
            r8.f3345k = r9
            androidx.lifecycle.o0 r9 = new androidx.lifecycle.o0
            r9.<init>()
            r8.f3346l = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel.<init>(e6.x, e6.y0, e6.o1, e6.e0, androidx.lifecycle.j1):void");
    }
}
