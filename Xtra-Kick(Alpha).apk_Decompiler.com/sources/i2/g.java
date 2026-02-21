package i2;

import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import j1.m0;
import org.xmlpull.v1.XmlPullParser;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f8022a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f8023b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f8024c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    private g() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        if (r9 == -1) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        r9 = -9223372036854775807L;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static i2.c a(java.lang.String r23) {
        /*
            org.xmlpull.v1.XmlPullParserFactory r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance()
            org.xmlpull.v1.XmlPullParser r0 = r0.newPullParser()
            java.io.StringReader r1 = new java.io.StringReader
            r2 = r23
            r1.<init>(r2)
            r0.setInput(r1)
            r0.next()
            java.lang.String r1 = "x:xmpmeta"
            boolean r2 = j1.m0.c(r0, r1)
            r3 = 0
            if (r2 == 0) goto L_0x00db
            d9.p0 r2 = d9.r0.f4657i
            d9.r1 r2 = d9.r1.f4658l
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r4
        L_0x0028:
            r0.next()
            java.lang.String r8 = "rdf:Description"
            boolean r8 = j1.m0.c(r0, r8)
            if (r8 == 0) goto L_0x00ab
            java.lang.String[] r2 = f8022a
            r6 = 0
            r7 = 0
        L_0x0037:
            r8 = 1
            r9 = 4
            if (r7 >= r9) goto L_0x004e
            r10 = r2[r7]
            java.lang.String r10 = j1.m0.a(r0, r10)
            if (r10 == 0) goto L_0x004b
            int r2 = java.lang.Integer.parseInt(r10)
            if (r2 != r8) goto L_0x004e
            r2 = 1
            goto L_0x004f
        L_0x004b:
            int r7 = r7 + 1
            goto L_0x0037
        L_0x004e:
            r2 = 0
        L_0x004f:
            if (r2 != 0) goto L_0x0052
            return r3
        L_0x0052:
            java.lang.String[] r2 = f8023b
            r7 = 0
        L_0x0055:
            if (r7 >= r9) goto L_0x006d
            r10 = r2[r7]
            java.lang.String r10 = j1.m0.a(r0, r10)
            if (r10 == 0) goto L_0x006a
            long r9 = java.lang.Long.parseLong(r10)
            r11 = -1
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x006e
            goto L_0x006d
        L_0x006a:
            int r7 = r7 + 1
            goto L_0x0055
        L_0x006d:
            r9 = r4
        L_0x006e:
            java.lang.String[] r2 = f8024c
            r7 = 0
        L_0x0071:
            r11 = 2
            if (r7 >= r11) goto L_0x00a5
            r12 = r2[r7]
            java.lang.String r12 = j1.m0.a(r0, r12)
            if (r12 == 0) goto L_0x00a2
            long r15 = java.lang.Long.parseLong(r12)
            i2.b r2 = new i2.b
            java.lang.String r18 = "image/jpeg"
            r19 = 0
            r21 = 0
            r17 = r2
            r17.<init>(r18, r19, r21)
            i2.b r7 = new i2.b
            java.lang.String r14 = "video/mp4"
            r17 = 0
            r13 = r7
            r13.<init>(r14, r15, r17)
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r11[r6] = r2
            r11[r8] = r7
            d9.r1 r2 = d9.r0.i(r11)
            goto L_0x00a9
        L_0x00a2:
            int r7 = r7 + 1
            goto L_0x0071
        L_0x00a5:
            d9.p0 r2 = d9.r0.f4657i
            d9.r1 r2 = d9.r1.f4658l
        L_0x00a9:
            r6 = r9
            goto L_0x00c8
        L_0x00ab:
            java.lang.String r8 = "Container:Directory"
            boolean r8 = j1.m0.c(r0, r8)
            if (r8 == 0) goto L_0x00b8
            java.lang.String r2 = "Container"
            java.lang.String r8 = "Item"
            goto L_0x00c4
        L_0x00b8:
            java.lang.String r8 = "GContainer:Directory"
            boolean r8 = j1.m0.c(r0, r8)
            if (r8 == 0) goto L_0x00c8
            java.lang.String r2 = "GContainer"
            java.lang.String r8 = "GContainerItem"
        L_0x00c4:
            d9.r1 r2 = b(r0, r2, r8)
        L_0x00c8:
            boolean r8 = j1.m0.b(r0, r1)
            if (r8 == 0) goto L_0x0028
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x00d5
            return r3
        L_0x00d5:
            i2.c r0 = new i2.c
            r0.<init>(r6, r2)
            return r0
        L_0x00db:
            java.lang.String r0 = "Couldn't find xmp metadata"
            g1.b1 r0 = g1.b1.a(r0, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.g.a(java.lang.String):i2.c");
    }

    public static r1 b(XmlPullParser xmlPullParser, String str, String str2) {
        long j10;
        long j11;
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        String concat = str.concat(":Item");
        String concat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (m0.c(xmlPullParser, concat)) {
                String concat3 = str2.concat(":Mime");
                String concat4 = str2.concat(":Semantic");
                String concat5 = str2.concat(":Length");
                String concat6 = str2.concat(":Padding");
                String a10 = m0.a(xmlPullParser, concat3);
                String a11 = m0.a(xmlPullParser, concat4);
                String a12 = m0.a(xmlPullParser, concat5);
                String a13 = m0.a(xmlPullParser, concat6);
                if (a10 == null || a11 == null) {
                    return r1.f4658l;
                }
                if (a12 != null) {
                    j10 = Long.parseLong(a12);
                } else {
                    j10 = 0;
                }
                if (a13 != null) {
                    j11 = Long.parseLong(a13);
                } else {
                    j11 = 0;
                }
                o0Var.c(new b(a10, j10, j11));
            }
        } while (!m0.b(xmlPullParser, concat2));
        return o0Var.e();
    }
}
