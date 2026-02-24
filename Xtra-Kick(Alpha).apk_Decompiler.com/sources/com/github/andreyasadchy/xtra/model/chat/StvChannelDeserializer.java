package com.github.andreyasadchy.xtra.model.chat;

import j9.r;

public final class StvChannelDeserializer implements r {
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0205  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.github.andreyasadchy.xtra.model.chat.StvChannelResponse deserialize(j9.s r17, java.lang.reflect.Type r18, j9.q r19) throws androidx.fragment.app.y {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "json"
            xa.j.f(r1, r0)
            java.lang.String r1 = "typeOfT"
            r2 = r18
            xa.j.f(r1, r2)
            java.lang.String r1 = "context"
            r2 = r19
            xa.j.f(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = r0 instanceof j9.v
            r3 = 0
            if (r2 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = r3
        L_0x0021:
            if (r0 == 0) goto L_0x0241
            j9.v r0 = r0.c()
            java.lang.String r2 = "emote_set"
            j9.s r0 = r0.f(r2)
            if (r0 == 0) goto L_0x0241
            boolean r2 = r0 instanceof j9.v
            if (r2 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r0 = r3
        L_0x0035:
            if (r0 == 0) goto L_0x0241
            j9.v r0 = r0.c()
            java.lang.String r2 = "emotes"
            j9.s r0 = r0.f(r2)
            if (r0 == 0) goto L_0x0241
            boolean r2 = r0 instanceof j9.p
            if (r2 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r0 = r3
        L_0x0049:
            if (r0 == 0) goto L_0x0241
            j9.p r0 = r0.b()
            java.util.Iterator r0 = r0.iterator()
        L_0x0053:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x023f
            java.lang.Object r2 = r0.next()
            j9.s r2 = (j9.s) r2
            r2.getClass()
            boolean r4 = r2 instanceof j9.v
            if (r4 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r2 = r3
        L_0x0068:
            if (r2 == 0) goto L_0x0053
            j9.v r2 = r2.c()
            java.lang.String r4 = "name"
            j9.s r5 = r2.f(r4)
            if (r5 == 0) goto L_0x023b
            boolean r6 = r5 instanceof j9.x
            if (r6 == 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r5 = r3
        L_0x007c:
            if (r5 == 0) goto L_0x023b
            j9.x r5 = r5.d()
            java.lang.Object r6 = r5.f8880h
            boolean r6 = r6 instanceof java.lang.String
            if (r6 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r5 = r3
        L_0x008a:
            if (r5 == 0) goto L_0x023b
            java.lang.String r7 = r5.e()
            if (r7 == 0) goto L_0x023b
            java.lang.String r5 = "data"
            j9.s r5 = r2.f(r5)
            if (r5 == 0) goto L_0x0239
            boolean r6 = r5 instanceof j9.v
            if (r6 == 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r5 = r3
        L_0x00a0:
            if (r5 == 0) goto L_0x0239
            j9.v r5 = r5.c()
            java.lang.String r6 = "host"
            j9.s r6 = r5.f(r6)
            if (r6 == 0) goto L_0x0237
            boolean r8 = r6 instanceof j9.v
            if (r8 == 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r6 = r3
        L_0x00b4:
            if (r6 == 0) goto L_0x0237
            j9.v r6 = r6.c()
            java.lang.String r8 = "url"
            j9.s r8 = r6.f(r8)
            if (r8 == 0) goto L_0x0235
            boolean r9 = r8 instanceof j9.x
            if (r9 == 0) goto L_0x00c7
            goto L_0x00c8
        L_0x00c7:
            r8 = r3
        L_0x00c8:
            if (r8 == 0) goto L_0x0235
            j9.x r8 = r8.d()
            java.lang.Object r9 = r8.f8880h
            boolean r9 = r9 instanceof java.lang.String
            if (r9 == 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r8 = r3
        L_0x00d6:
            if (r8 == 0) goto L_0x0235
            java.lang.String r8 = r8.e()
            if (r8 == 0) goto L_0x0235
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r10 = "files"
            j9.s r6 = r6.f(r10)
            r10 = 1
            java.lang.String r11 = "https:"
            if (r6 == 0) goto L_0x0161
            boolean r12 = r6 instanceof j9.p
            if (r12 == 0) goto L_0x00f3
            goto L_0x00f4
        L_0x00f3:
            r6 = r3
        L_0x00f4:
            if (r6 == 0) goto L_0x0161
            j9.p r6 = r6.b()
            java.util.Iterator r6 = r6.iterator()
        L_0x00fe:
            boolean r12 = r6.hasNext()
            if (r12 == 0) goto L_0x015f
            java.lang.Object r12 = r6.next()
            j9.s r12 = (j9.s) r12
            r12.getClass()
            boolean r13 = r12 instanceof j9.v
            if (r13 == 0) goto L_0x0112
            goto L_0x0113
        L_0x0112:
            r12 = r3
        L_0x0113:
            if (r12 == 0) goto L_0x00fe
            j9.v r12 = r12.c()
            j9.s r12 = r12.f(r4)
            if (r12 == 0) goto L_0x015c
            boolean r13 = r12 instanceof j9.x
            if (r13 == 0) goto L_0x0124
            goto L_0x0125
        L_0x0124:
            r12 = r3
        L_0x0125:
            if (r12 == 0) goto L_0x015c
            j9.x r12 = r12.d()
            java.lang.Object r13 = r12.f8880h
            boolean r13 = r13 instanceof java.lang.String
            if (r13 == 0) goto L_0x0132
            goto L_0x0133
        L_0x0132:
            r12 = r3
        L_0x0133:
            if (r12 == 0) goto L_0x015c
            java.lang.String r12 = r12.e()
            if (r12 == 0) goto L_0x015c
            java.lang.String r13 = "avif"
            boolean r13 = fb.y.n(r12, r13, r10)
            if (r13 != 0) goto L_0x015a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r13.append(r8)
            java.lang.String r14 = "/"
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r9.add(r12)
        L_0x015a:
            la.v r12 = la.v.f9814a
        L_0x015c:
            la.v r12 = la.v.f9814a
            goto L_0x00fe
        L_0x015f:
            la.v r4 = la.v.f9814a
        L_0x0161:
            r4 = 0
            java.lang.Object r6 = ma.z.v(r9, r4)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0170
            java.lang.String r6 = "/1x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
        L_0x0170:
            r12 = r6
            java.lang.Object r6 = ma.z.v(r9, r10)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0188
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x0186
            java.lang.String r6 = "/2x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
            goto L_0x0188
        L_0x0186:
            r13 = r3
            goto L_0x0189
        L_0x0188:
            r13 = r6
        L_0x0189:
            r6 = 2
            java.lang.Object r6 = ma.z.v(r9, r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x01a1
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x019f
            java.lang.String r6 = "/3x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
            goto L_0x01a1
        L_0x019f:
            r14 = r3
            goto L_0x01a2
        L_0x01a1:
            r14 = r6
        L_0x01a2:
            r6 = 3
            java.lang.Object r6 = ma.z.v(r9, r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x01ba
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x01b8
            java.lang.String r6 = "/4x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
            goto L_0x01ba
        L_0x01b8:
            r11 = r3
            goto L_0x01bb
        L_0x01ba:
            r11 = r6
        L_0x01bb:
            java.lang.Object r6 = ma.z.v(r9, r4)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x01ca
            java.lang.String r8 = "."
            java.lang.String r6 = fb.y.L(r6, r8)
            goto L_0x01cc
        L_0x01ca:
            java.lang.String r6 = "webp"
        L_0x01cc:
            r15 = r6
            java.lang.String r6 = "animated"
            j9.s r5 = r5.f(r6)
            if (r5 == 0) goto L_0x01fc
            boolean r6 = r5 instanceof j9.x
            if (r6 == 0) goto L_0x01da
            goto L_0x01db
        L_0x01da:
            r5 = r3
        L_0x01db:
            if (r5 == 0) goto L_0x01fc
            j9.x r5 = r5.d()
            java.lang.Object r6 = r5.f8880h
            boolean r6 = r6 instanceof java.lang.Boolean
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x01f0
            goto L_0x01f1
        L_0x01f0:
            r5 = r3
        L_0x01f1:
            if (r5 == 0) goto L_0x01fc
            boolean r5 = r5.f()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x01fd
        L_0x01fc:
            r5 = r3
        L_0x01fd:
            java.lang.String r6 = "flags"
            j9.s r2 = r2.f(r6)
            if (r2 == 0) goto L_0x0223
            boolean r6 = r2 instanceof j9.x
            if (r6 == 0) goto L_0x020a
            goto L_0x020b
        L_0x020a:
            r2 = r3
        L_0x020b:
            if (r2 == 0) goto L_0x0223
            j9.x r2 = r2.d()
            java.lang.Object r6 = r2.f8880h
            boolean r6 = r6 instanceof java.lang.Number
            if (r6 == 0) goto L_0x0218
            goto L_0x0219
        L_0x0218:
            r2 = r3
        L_0x0219:
            if (r2 == 0) goto L_0x0223
            int r2 = r2.a()
            if (r2 != r10) goto L_0x0223
            r2 = 1
            goto L_0x0224
        L_0x0223:
            r2 = 0
        L_0x0224:
            com.github.andreyasadchy.xtra.model.chat.StvEmote r4 = new com.github.andreyasadchy.xtra.model.chat.StvEmote
            r6 = r4
            r8 = r12
            r9 = r13
            r10 = r14
            r12 = r15
            r13 = r5
            r14 = r2
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
            r1.add(r4)
            la.v r2 = la.v.f9814a
        L_0x0235:
            la.v r2 = la.v.f9814a
        L_0x0237:
            la.v r2 = la.v.f9814a
        L_0x0239:
            la.v r2 = la.v.f9814a
        L_0x023b:
            la.v r2 = la.v.f9814a
            goto L_0x0053
        L_0x023f:
            la.v r0 = la.v.f9814a
        L_0x0241:
            com.github.andreyasadchy.xtra.model.chat.StvChannelResponse r0 = new com.github.andreyasadchy.xtra.model.chat.StvChannelResponse
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.chat.StvChannelDeserializer.deserialize(j9.s, java.lang.reflect.Type, j9.q):com.github.andreyasadchy.xtra.model.chat.StvChannelResponse");
    }
}
