package i2;

import d2.e0;
import d2.v;
import d2.w;
import d2.x0;
import d2.y;
import g1.a0;
import g1.y0;
import g1.z;
import g1.z0;
import j1.b0;
import p2.d;
import u2.p;

public final class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f8001a = new b0(6);

    /* renamed from: b  reason: collision with root package name */
    public y f8002b;

    /* renamed from: c  reason: collision with root package name */
    public int f8003c;

    /* renamed from: d  reason: collision with root package name */
    public int f8004d;

    /* renamed from: e  reason: collision with root package name */
    public int f8005e;

    /* renamed from: f  reason: collision with root package name */
    public long f8006f = -1;

    /* renamed from: g  reason: collision with root package name */
    public d f8007g;

    /* renamed from: h  reason: collision with root package name */
    public w f8008h;

    /* renamed from: i  reason: collision with root package name */
    public d f8009i;

    /* renamed from: j  reason: collision with root package name */
    public p f8010j;

    public final void a() {
        p pVar = this.f8010j;
        if (pVar != null) {
            pVar.getClass();
        }
    }

    public final void b() {
        f(new y0[0]);
        y yVar = this.f8002b;
        yVar.getClass();
        yVar.a();
        this.f8002b.g(new e0(-9223372036854775807L));
        this.f8003c = 6;
    }

    public final void c(long j10, long j11) {
        if (j10 == 0) {
            this.f8003c = 0;
            this.f8010j = null;
        } else if (this.f8003c == 5) {
            p pVar = this.f8010j;
            pVar.getClass();
            pVar.c(j10, j11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r25, d2.s0 r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            int r3 = r0.f8003c
            r4 = 4
            r5 = -1
            j1.b0 r7 = r0.f8001a
            r8 = 2
            r9 = 1
            r10 = 0
            if (r3 == 0) goto L_0x017a
            if (r3 == r9) goto L_0x0167
            r11 = -1
            if (r3 == r8) goto L_0x00a6
            r5 = 5
            if (r3 == r4) goto L_0x004e
            if (r3 == r5) goto L_0x0026
            r1 = 6
            if (r3 != r1) goto L_0x0020
            return r11
        L_0x0020:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0026:
            i2.d r3 = r0.f8009i
            if (r3 == 0) goto L_0x002e
            d2.w r3 = r0.f8008h
            if (r1 == r3) goto L_0x0039
        L_0x002e:
            r0.f8008h = r1
            i2.d r3 = new i2.d
            long r4 = r0.f8006f
            r3.<init>(r1, r4)
            r0.f8009i = r3
        L_0x0039:
            u2.p r1 = r0.f8010j
            r1.getClass()
            i2.d r3 = r0.f8009i
            int r1 = r1.d(r3, r2)
            if (r1 != r9) goto L_0x004d
            long r3 = r2.f4296a
            long r5 = r0.f8006f
            long r3 = r3 + r5
            r2.f4296a = r3
        L_0x004d:
            return r1
        L_0x004e:
            long r3 = r25.p()
            long r11 = r0.f8006f
            int r6 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x005b
            r2.f4296a = r11
            return r9
        L_0x005b:
            byte[] r2 = r7.f8414a
            boolean r2 = r1.k(r2, r10, r9, r9)
            if (r2 != 0) goto L_0x0064
            goto L_0x00a2
        L_0x0064:
            r25.f()
            u2.p r2 = r0.f8010j
            if (r2 != 0) goto L_0x0072
            u2.p r2 = new u2.p
            r2.<init>()
            r0.f8010j = r2
        L_0x0072:
            i2.d r2 = new i2.d
            long r3 = r0.f8006f
            r2.<init>(r1, r3)
            r0.f8009i = r2
            u2.p r1 = r0.f8010j
            boolean r1 = r1.h(r2)
            if (r1 == 0) goto L_0x00a2
            u2.p r1 = r0.f8010j
            i2.f r2 = new i2.f
            long r3 = r0.f8006f
            d2.y r6 = r0.f8002b
            r6.getClass()
            r2.<init>(r3, r6)
            r1.f15290r = r2
            g1.y0[] r1 = new g1.y0[r9]
            p2.d r2 = r0.f8007g
            r2.getClass()
            r1[r10] = r2
            r0.f(r1)
            r0.f8003c = r5
            goto L_0x00a5
        L_0x00a2:
            r24.b()
        L_0x00a5:
            return r10
        L_0x00a6:
            int r2 = r0.f8004d
            r3 = 65505(0xffe1, float:9.1792E-41)
            if (r2 != r3) goto L_0x015e
            j1.b0 r2 = new j1.b0
            int r3 = r0.f8005e
            r2.<init>((int) r3)
            byte[] r3 = r2.f8414a
            int r4 = r0.f8005e
            r1.readFully(r3, r10, r4)
            p2.d r3 = r0.f8007g
            if (r3 != 0) goto L_0x0163
            java.lang.String r3 = "http://ns.adobe.com/xap/1.0/"
            java.lang.String r4 = r2.p()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0163
            java.lang.String r2 = r2.p()
            if (r2 == 0) goto L_0x0163
            long r3 = r25.c()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x00db
            goto L_0x0154
        L_0x00db:
            i2.c r2 = i2.g.a(r2)     // Catch:{ b1 | NumberFormatException | XmlPullParserException -> 0x00e0 }
            goto L_0x00e8
        L_0x00e0:
            java.lang.String r2 = "MotionPhotoXmpParser"
            java.lang.String r7 = "Ignoring unexpected XMP metadata"
            j1.v.g(r2, r7)
            r2 = 0
        L_0x00e8:
            if (r2 != 0) goto L_0x00ec
            goto L_0x0154
        L_0x00ec:
            java.util.List r7 = r2.f8015b
            int r9 = r7.size()
            if (r9 >= r8) goto L_0x00f6
            goto L_0x0154
        L_0x00f6:
            int r8 = r7.size()
            int r8 = r8 + r11
            r12 = r5
            r14 = r12
            r18 = r14
            r20 = r18
            r9 = 0
        L_0x0102:
            if (r8 < 0) goto L_0x0138
            java.lang.Object r11 = r7.get(r8)
            i2.b r11 = (i2.b) r11
            java.lang.String r1 = r11.f8011a
            java.lang.String r10 = "video/mp4"
            boolean r1 = r10.equals(r1)
            r1 = r1 | r9
            if (r8 != 0) goto L_0x011b
            long r9 = r11.f8013c
            long r3 = r3 - r9
            r9 = 0
            goto L_0x011f
        L_0x011b:
            long r9 = r11.f8012b
            long r9 = r3 - r9
        L_0x011f:
            r22 = r3
            r3 = r9
            r9 = r22
            if (r1 == 0) goto L_0x012f
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x012f
            long r20 = r9 - r3
            r18 = r3
            r1 = 0
        L_0x012f:
            if (r8 != 0) goto L_0x0133
            r12 = r3
            r14 = r9
        L_0x0133:
            int r8 = r8 + -1
            r9 = r1
            r10 = 0
            goto L_0x0102
        L_0x0138:
            int r1 = (r18 > r5 ? 1 : (r18 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0154
            int r1 = (r20 > r5 ? 1 : (r20 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0154
            int r1 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x0154
            int r1 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0149
            goto L_0x0154
        L_0x0149:
            p2.d r1 = new p2.d
            long r2 = r2.f8014a
            r11 = r1
            r16 = r2
            r11.<init>(r12, r14, r16, r18, r20)
            goto L_0x0155
        L_0x0154:
            r1 = 0
        L_0x0155:
            r0.f8007g = r1
            if (r1 == 0) goto L_0x0163
            long r1 = r1.f12518k
            r0.f8006f = r1
            goto L_0x0163
        L_0x015e:
            int r2 = r0.f8005e
            r1.g(r2)
        L_0x0163:
            r2 = 0
            r0.f8003c = r2
            return r2
        L_0x0167:
            r2 = 0
            r7.D(r8)
            byte[] r3 = r7.f8414a
            r1.readFully(r3, r2, r8)
            int r1 = r7.A()
            int r1 = r1 - r8
            r0.f8005e = r1
            r0.f8003c = r8
            return r2
        L_0x017a:
            r2 = 0
            r7.D(r8)
            byte[] r3 = r7.f8414a
            r1.readFully(r3, r2, r8)
            int r1 = r7.A()
            r0.f8004d = r1
            r2 = 65498(0xffda, float:9.1782E-41)
            if (r1 != r2) goto L_0x0199
            long r1 = r0.f8006f
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0195
            goto L_0x01a9
        L_0x0195:
            r24.b()
            goto L_0x01ab
        L_0x0199:
            r2 = 65488(0xffd0, float:9.1768E-41)
            if (r1 < r2) goto L_0x01a3
            r2 = 65497(0xffd9, float:9.1781E-41)
            if (r1 <= r2) goto L_0x01ab
        L_0x01a3:
            r2 = 65281(0xff01, float:9.1478E-41)
            if (r1 == r2) goto L_0x01ab
            r4 = 1
        L_0x01a9:
            r0.f8003c = r4
        L_0x01ab:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.a.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        this.f8002b = yVar;
    }

    public final void f(y0... y0VarArr) {
        y yVar = this.f8002b;
        yVar.getClass();
        x0 d10 = yVar.d(1024, 4);
        z zVar = new z();
        zVar.f6753j = "image/jpeg";
        zVar.f6752i = new z0(y0VarArr);
        d10.a(new a0(zVar));
    }

    public final int g(d2.p pVar) {
        b0 b0Var = this.f8001a;
        b0Var.D(2);
        pVar.k(b0Var.f8414a, 0, 2, false);
        return b0Var.A();
    }

    public final boolean h(w wVar) {
        d2.p pVar = (d2.p) wVar;
        if (g(pVar) != 65496) {
            return false;
        }
        int g10 = g(pVar);
        this.f8004d = g10;
        b0 b0Var = this.f8001a;
        if (g10 == 65504) {
            b0Var.D(2);
            pVar.k(b0Var.f8414a, 0, 2, false);
            pVar.h(b0Var.A() - 2, false);
            this.f8004d = g(pVar);
        }
        if (this.f8004d != 65505) {
            return false;
        }
        pVar.h(2, false);
        b0Var.D(6);
        pVar.k(b0Var.f8414a, 0, 6, false);
        if (b0Var.w() == 1165519206 && b0Var.A() == 0) {
            return true;
        }
        return false;
    }
}
