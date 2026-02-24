package fb;

public class p extends n {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r12) {
        /*
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r12)
            java.lang.String r0 = "|"
            boolean r1 = fb.w.h(r0)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x00a4
            java.util.List r1 = fb.y.y(r12)
            int r12 = r12.length()
            int r2 = r1.size()
            r3 = 0
            int r2 = r2 * 0
            int r2 = r2 + r12
            int r12 = ma.r.d(r1)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r1 = r1.iterator()
            r5 = 0
        L_0x002d:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0092
            java.lang.Object r6 = r1.next()
            int r7 = r5 + 1
            r8 = 0
            if (r5 < 0) goto L_0x008e
            java.lang.String r6 = (java.lang.String) r6
            if (r5 == 0) goto L_0x0042
            if (r5 != r12) goto L_0x0049
        L_0x0042:
            boolean r5 = fb.w.h(r6)
            if (r5 == 0) goto L_0x0049
            goto L_0x0087
        L_0x0049:
            int r5 = r6.length()
            r9 = 0
        L_0x004e:
            r10 = -1
            if (r9 >= r5) goto L_0x0061
            char r11 = r6.charAt(r9)
            boolean r11 = fb.a.b(r11)
            r11 = r11 ^ 1
            if (r11 == 0) goto L_0x005e
            goto L_0x0062
        L_0x005e:
            int r9 = r9 + 1
            goto L_0x004e
        L_0x0061:
            r9 = -1
        L_0x0062:
            if (r9 != r10) goto L_0x0065
            goto L_0x0079
        L_0x0065:
            boolean r5 = fb.w.l(r6, r0, r9, r3)
            if (r5 == 0) goto L_0x0079
            int r5 = r0.length()
            int r5 = r5 + r9
            java.lang.String r8 = r6.substring(r5)
            java.lang.String r5 = "this as java.lang.String).substring(startIndex)"
            xa.j.e(r5, r8)
        L_0x0079:
            if (r8 == 0) goto L_0x0086
            fb.o r5 = fb.o.f6015h
            java.lang.Object r5 = r5.invoke(r8)
            r8 = r5
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x0087
        L_0x0086:
            r8 = r6
        L_0x0087:
            if (r8 == 0) goto L_0x008c
            r4.add(r8)
        L_0x008c:
            r5 = r7
            goto L_0x002d
        L_0x008e:
            ma.r.h()
            throw r8
        L_0x0092:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r2)
            ma.z.w(r4, r12, com.iheartradio.m3u8.Constants.WRITE_NEW_LINE, "", "", -1, "...", (wa.l) null)
            java.lang.String r12 = r12.toString()
            java.lang.String r0 = "mapIndexedNotNull { inde…\"\\n\")\n        .toString()"
            xa.j.e(r0, r12)
            return r12
        L_0x00a4:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "marginPrefix must be non-blank string."
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.p.b(java.lang.String):java.lang.String");
    }
}
