package com.github.andreyasadchy.xtra.model.chat;

import j9.r;

public final class StvGlobalDeserializer implements r {
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse deserialize(j9.s r17, java.lang.reflect.Type r18, j9.q r19) throws androidx.fragment.app.y {
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
            if (r0 == 0) goto L_0x022d
            j9.v r0 = r0.c()
            java.lang.String r2 = "emotes"
            j9.s r0 = r0.f(r2)
            if (r0 == 0) goto L_0x022d
            boolean r2 = r0 instanceof j9.p
            if (r2 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r0 = r3
        L_0x0035:
            if (r0 == 0) goto L_0x022d
            j9.p r0 = r0.b()
            java.util.Iterator r0 = r0.iterator()
        L_0x003f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x022b
            java.lang.Object r2 = r0.next()
            j9.s r2 = (j9.s) r2
            r2.getClass()
            boolean r4 = r2 instanceof j9.v
            if (r4 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r3
        L_0x0054:
            if (r2 == 0) goto L_0x003f
            j9.v r2 = r2.c()
            java.lang.String r4 = "name"
            j9.s r5 = r2.f(r4)
            if (r5 == 0) goto L_0x0227
            boolean r6 = r5 instanceof j9.x
            if (r6 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r5 = r3
        L_0x0068:
            if (r5 == 0) goto L_0x0227
            j9.x r5 = r5.d()
            java.lang.Object r6 = r5.f8880h
            boolean r6 = r6 instanceof java.lang.String
            if (r6 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r5 = r3
        L_0x0076:
            if (r5 == 0) goto L_0x0227
            java.lang.String r7 = r5.e()
            if (r7 == 0) goto L_0x0227
            java.lang.String r5 = "data"
            j9.s r5 = r2.f(r5)
            if (r5 == 0) goto L_0x0225
            boolean r6 = r5 instanceof j9.v
            if (r6 == 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r5 = r3
        L_0x008c:
            if (r5 == 0) goto L_0x0225
            j9.v r5 = r5.c()
            java.lang.String r6 = "host"
            j9.s r6 = r5.f(r6)
            if (r6 == 0) goto L_0x0223
            boolean r8 = r6 instanceof j9.v
            if (r8 == 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r6 = r3
        L_0x00a0:
            if (r6 == 0) goto L_0x0223
            j9.v r6 = r6.c()
            java.lang.String r8 = "url"
            j9.s r8 = r6.f(r8)
            if (r8 == 0) goto L_0x0221
            boolean r9 = r8 instanceof j9.x
            if (r9 == 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r8 = r3
        L_0x00b4:
            if (r8 == 0) goto L_0x0221
            j9.x r8 = r8.d()
            java.lang.Object r9 = r8.f8880h
            boolean r9 = r9 instanceof java.lang.String
            if (r9 == 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r8 = r3
        L_0x00c2:
            if (r8 == 0) goto L_0x0221
            java.lang.String r8 = r8.e()
            if (r8 == 0) goto L_0x0221
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r10 = "files"
            j9.s r6 = r6.f(r10)
            r10 = 1
            java.lang.String r11 = "https:"
            if (r6 == 0) goto L_0x014d
            boolean r12 = r6 instanceof j9.p
            if (r12 == 0) goto L_0x00df
            goto L_0x00e0
        L_0x00df:
            r6 = r3
        L_0x00e0:
            if (r6 == 0) goto L_0x014d
            j9.p r6 = r6.b()
            java.util.Iterator r6 = r6.iterator()
        L_0x00ea:
            boolean r12 = r6.hasNext()
            if (r12 == 0) goto L_0x014b
            java.lang.Object r12 = r6.next()
            j9.s r12 = (j9.s) r12
            r12.getClass()
            boolean r13 = r12 instanceof j9.v
            if (r13 == 0) goto L_0x00fe
            goto L_0x00ff
        L_0x00fe:
            r12 = r3
        L_0x00ff:
            if (r12 == 0) goto L_0x00ea
            j9.v r12 = r12.c()
            j9.s r12 = r12.f(r4)
            if (r12 == 0) goto L_0x0148
            boolean r13 = r12 instanceof j9.x
            if (r13 == 0) goto L_0x0110
            goto L_0x0111
        L_0x0110:
            r12 = r3
        L_0x0111:
            if (r12 == 0) goto L_0x0148
            j9.x r12 = r12.d()
            java.lang.Object r13 = r12.f8880h
            boolean r13 = r13 instanceof java.lang.String
            if (r13 == 0) goto L_0x011e
            goto L_0x011f
        L_0x011e:
            r12 = r3
        L_0x011f:
            if (r12 == 0) goto L_0x0148
            java.lang.String r12 = r12.e()
            if (r12 == 0) goto L_0x0148
            java.lang.String r13 = "avif"
            boolean r13 = fb.y.n(r12, r13, r10)
            if (r13 != 0) goto L_0x0146
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r13.append(r8)
            java.lang.String r14 = "/"
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r9.add(r12)
        L_0x0146:
            la.v r12 = la.v.f9814a
        L_0x0148:
            la.v r12 = la.v.f9814a
            goto L_0x00ea
        L_0x014b:
            la.v r4 = la.v.f9814a
        L_0x014d:
            r4 = 0
            java.lang.Object r6 = ma.z.v(r9, r4)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x015c
            java.lang.String r6 = "/1x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
        L_0x015c:
            r12 = r6
            java.lang.Object r6 = ma.z.v(r9, r10)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0174
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x0172
            java.lang.String r6 = "/2x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
            goto L_0x0174
        L_0x0172:
            r13 = r3
            goto L_0x0175
        L_0x0174:
            r13 = r6
        L_0x0175:
            r6 = 2
            java.lang.Object r6 = ma.z.v(r9, r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x018d
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x018b
            java.lang.String r6 = "/3x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
            goto L_0x018d
        L_0x018b:
            r14 = r3
            goto L_0x018e
        L_0x018d:
            r14 = r6
        L_0x018e:
            r6 = 3
            java.lang.Object r6 = ma.z.v(r9, r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x01a6
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L_0x01a4
            java.lang.String r6 = "/4x.webp"
            java.lang.String r6 = android.support.v4.media.h.n(r11, r8, r6)
            goto L_0x01a6
        L_0x01a4:
            r11 = r3
            goto L_0x01a7
        L_0x01a6:
            r11 = r6
        L_0x01a7:
            java.lang.Object r6 = ma.z.v(r9, r4)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x01b6
            java.lang.String r8 = "."
            java.lang.String r6 = fb.y.L(r6, r8)
            goto L_0x01b8
        L_0x01b6:
            java.lang.String r6 = "webp"
        L_0x01b8:
            r15 = r6
            java.lang.String r6 = "animated"
            j9.s r5 = r5.f(r6)
            if (r5 == 0) goto L_0x01e8
            boolean r6 = r5 instanceof j9.x
            if (r6 == 0) goto L_0x01c6
            goto L_0x01c7
        L_0x01c6:
            r5 = r3
        L_0x01c7:
            if (r5 == 0) goto L_0x01e8
            j9.x r5 = r5.d()
            java.lang.Object r6 = r5.f8880h
            boolean r6 = r6 instanceof java.lang.Boolean
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x01dc
            goto L_0x01dd
        L_0x01dc:
            r5 = r3
        L_0x01dd:
            if (r5 == 0) goto L_0x01e8
            boolean r5 = r5.f()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x01e9
        L_0x01e8:
            r5 = r3
        L_0x01e9:
            java.lang.String r6 = "flags"
            j9.s r2 = r2.f(r6)
            if (r2 == 0) goto L_0x020f
            boolean r6 = r2 instanceof j9.x
            if (r6 == 0) goto L_0x01f6
            goto L_0x01f7
        L_0x01f6:
            r2 = r3
        L_0x01f7:
            if (r2 == 0) goto L_0x020f
            j9.x r2 = r2.d()
            java.lang.Object r6 = r2.f8880h
            boolean r6 = r6 instanceof java.lang.Number
            if (r6 == 0) goto L_0x0204
            goto L_0x0205
        L_0x0204:
            r2 = r3
        L_0x0205:
            if (r2 == 0) goto L_0x020f
            int r2 = r2.a()
            if (r2 != r10) goto L_0x020f
            r2 = 1
            goto L_0x0210
        L_0x020f:
            r2 = 0
        L_0x0210:
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
        L_0x0221:
            la.v r2 = la.v.f9814a
        L_0x0223:
            la.v r2 = la.v.f9814a
        L_0x0225:
            la.v r2 = la.v.f9814a
        L_0x0227:
            la.v r2 = la.v.f9814a
            goto L_0x003f
        L_0x022b:
            la.v r0 = la.v.f9814a
        L_0x022d:
            com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse r0 = new com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.model.chat.StvGlobalDeserializer.deserialize(j9.s, java.lang.reflect.Type, j9.q):com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse");
    }
}
