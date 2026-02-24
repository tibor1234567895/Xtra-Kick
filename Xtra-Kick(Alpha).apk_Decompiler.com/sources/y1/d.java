package y1;

import g1.a0;

public final class d implements e {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final w2.e a(g1.a0 r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.f6276s
            if (r0 == 0) goto L_0x00e8
            int r1 = r0.hashCode()
            switch(r1) {
                case -1351681404: goto L_0x0092;
                case -1248334819: goto L_0x0087;
                case -1026075066: goto L_0x007c;
                case -1004728940: goto L_0x0071;
                case 691401887: goto L_0x0066;
                case 822864842: goto L_0x005b;
                case 930165504: goto L_0x0050;
                case 1201784583: goto L_0x0045;
                case 1566015601: goto L_0x0037;
                case 1566016562: goto L_0x0029;
                case 1668750253: goto L_0x001b;
                case 1693976202: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x009d
        L_0x000d:
            java.lang.String r1 = "application/ttml+xml"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0017
            goto L_0x009d
        L_0x0017:
            r1 = 11
            goto L_0x009e
        L_0x001b:
            java.lang.String r1 = "application/x-subrip"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0025
            goto L_0x009d
        L_0x0025:
            r1 = 10
            goto L_0x009e
        L_0x0029:
            java.lang.String r1 = "application/cea-708"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0033
            goto L_0x009d
        L_0x0033:
            r1 = 9
            goto L_0x009e
        L_0x0037:
            java.lang.String r1 = "application/cea-608"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0041
            goto L_0x009d
        L_0x0041:
            r1 = 8
            goto L_0x009e
        L_0x0045:
            java.lang.String r1 = "text/x-exoplayer-cues"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x004e
            goto L_0x009d
        L_0x004e:
            r1 = 7
            goto L_0x009e
        L_0x0050:
            java.lang.String r1 = "application/x-mp4-cea-608"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0059
            goto L_0x009d
        L_0x0059:
            r1 = 6
            goto L_0x009e
        L_0x005b:
            java.lang.String r1 = "text/x-ssa"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0064
            goto L_0x009d
        L_0x0064:
            r1 = 5
            goto L_0x009e
        L_0x0066:
            java.lang.String r1 = "application/x-quicktime-tx3g"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x006f
            goto L_0x009d
        L_0x006f:
            r1 = 4
            goto L_0x009e
        L_0x0071:
            java.lang.String r1 = "text/vtt"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x007a
            goto L_0x009d
        L_0x007a:
            r1 = 3
            goto L_0x009e
        L_0x007c:
            java.lang.String r1 = "application/x-mp4-vtt"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0085
            goto L_0x009d
        L_0x0085:
            r1 = 2
            goto L_0x009e
        L_0x0087:
            java.lang.String r1 = "application/pgs"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0090
            goto L_0x009d
        L_0x0090:
            r1 = 1
            goto L_0x009e
        L_0x0092:
            java.lang.String r1 = "application/dvbsubs"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r1 = 0
            goto L_0x009e
        L_0x009d:
            r1 = -1
        L_0x009e:
            int r2 = r4.K
            java.util.List r4 = r4.f6278u
            switch(r1) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00dc;
                case 2: goto L_0x00d6;
                case 3: goto L_0x00d0;
                case 4: goto L_0x00ca;
                case 5: goto L_0x00c4;
                case 6: goto L_0x00be;
                case 7: goto L_0x00b8;
                case 8: goto L_0x00be;
                case 9: goto L_0x00b2;
                case 10: goto L_0x00ac;
                case 11: goto L_0x00a6;
                default: goto L_0x00a5;
            }
        L_0x00a5:
            goto L_0x00e8
        L_0x00a6:
            c3.d r4 = new c3.d
            r4.<init>()
            return r4
        L_0x00ac:
            b3.a r4 = new b3.a
            r4.<init>()
            return r4
        L_0x00b2:
            x2.f r0 = new x2.f
            r0.<init>(r4, r2)
            return r0
        L_0x00b8:
            y1.c r4 = new y1.c
            r4.<init>()
            return r4
        L_0x00be:
            x2.c r4 = new x2.c
            r4.<init>(r2, r0)
            return r4
        L_0x00c4:
            a3.a r0 = new a3.a
            r0.<init>(r4)
            return r0
        L_0x00ca:
            d3.a r0 = new d3.a
            r0.<init>(r4)
            return r0
        L_0x00d0:
            e3.j r4 = new e3.j
            r4.<init>()
            return r4
        L_0x00d6:
            e3.a r4 = new e3.a
            r4.<init>()
            return r4
        L_0x00dc:
            z2.b r4 = new z2.b
            r4.<init>()
            return r4
        L_0x00e2:
            y2.a r0 = new y2.a
            r0.<init>(r4)
            return r0
        L_0x00e8:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Attempted to create decoder for unsupported MIME type: "
            java.lang.String r0 = android.support.v4.media.h.m(r1, r0)
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.d.a(g1.a0):w2.e");
    }

    public final boolean b(a0 a0Var) {
        String str = a0Var.f6276s;
        return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
    }
}
