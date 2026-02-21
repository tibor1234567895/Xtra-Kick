package f3;

import d2.x0;
import d2.y;
import j1.a0;
import j1.b0;

public final class e implements k {

    /* renamed from: a  reason: collision with root package name */
    public final a0 f5520a;

    /* renamed from: b  reason: collision with root package name */
    public final b0 f5521b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5522c;

    /* renamed from: d  reason: collision with root package name */
    public String f5523d;

    /* renamed from: e  reason: collision with root package name */
    public x0 f5524e;

    /* renamed from: f  reason: collision with root package name */
    public int f5525f;

    /* renamed from: g  reason: collision with root package name */
    public int f5526g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5527h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5528i;

    /* renamed from: j  reason: collision with root package name */
    public long f5529j;

    /* renamed from: k  reason: collision with root package name */
    public g1.a0 f5530k;

    /* renamed from: l  reason: collision with root package name */
    public int f5531l;

    /* renamed from: m  reason: collision with root package name */
    public long f5532m;

    public e() {
        this((String) null);
    }

    public final void a() {
        this.f5525f = 0;
        this.f5526g = 0;
        this.f5527h = false;
        this.f5528i = false;
        this.f5532m = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(j1.b0 r12) {
        /*
            r11 = this;
            d2.x0 r0 = r11.f5524e
            j1.a.f(r0)
        L_0x0005:
            int r0 = r12.f8416c
            int r1 = r12.f8415b
            int r0 = r0 - r1
            if (r0 <= 0) goto L_0x0117
            int r1 = r11.f5525f
            r2 = 1
            r3 = 0
            j1.b0 r4 = r11.f5521b
            r5 = 2
            if (r1 == 0) goto L_0x00ca
            if (r1 == r2) goto L_0x004e
            if (r1 == r5) goto L_0x001a
            goto L_0x0005
        L_0x001a:
            int r1 = r11.f5531l
            int r2 = r11.f5526g
            int r1 = r1 - r2
            int r0 = java.lang.Math.min(r0, r1)
            d2.x0 r1 = r11.f5524e
            r1.d(r0, r12)
            int r1 = r11.f5526g
            int r1 = r1 + r0
            r11.f5526g = r1
            int r8 = r11.f5531l
            if (r1 != r8) goto L_0x0005
            long r5 = r11.f5532m
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x004b
            d2.x0 r4 = r11.f5524e
            r7 = 1
            r9 = 0
            r10 = 0
            r4.e(r5, r7, r8, r9, r10)
            long r0 = r11.f5532m
            long r4 = r11.f5529j
            long r0 = r0 + r4
            r11.f5532m = r0
        L_0x004b:
            r11.f5525f = r3
            goto L_0x0005
        L_0x004e:
            byte[] r1 = r4.f8414a
            int r6 = r11.f5526g
            r7 = 16
            int r6 = 16 - r6
            int r0 = java.lang.Math.min(r0, r6)
            int r6 = r11.f5526g
            r12.d(r1, r6, r0)
            int r1 = r11.f5526g
            int r1 = r1 + r0
            r11.f5526g = r1
            if (r1 != r7) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r2 = 0
        L_0x0068:
            if (r2 == 0) goto L_0x0005
            j1.a0 r0 = r11.f5520a
            r0.k(r3)
            b2.e r0 = d2.d.b(r0)
            g1.a0 r1 = r11.f5530k
            java.lang.String r2 = "audio/ac4"
            int r6 = r0.f2428a
            if (r1 == 0) goto L_0x008b
            int r8 = r1.F
            if (r5 != r8) goto L_0x008b
            int r8 = r1.G
            if (r6 != r8) goto L_0x008b
            java.lang.String r1 = r1.f6276s
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x00aa
        L_0x008b:
            g1.z r1 = new g1.z
            r1.<init>()
            java.lang.String r8 = r11.f5523d
            r1.f6744a = r8
            r1.f6754k = r2
            r1.f6767x = r5
            r1.f6768y = r6
            java.lang.String r2 = r11.f5522c
            r1.f6746c = r2
            g1.a0 r2 = new g1.a0
            r2.<init>(r1)
            r11.f5530k = r2
            d2.x0 r1 = r11.f5524e
            r1.a(r2)
        L_0x00aa:
            int r1 = r0.f2429b
            r11.f5531l = r1
            int r0 = r0.f2430c
            long r0 = (long) r0
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 * r8
            g1.a0 r2 = r11.f5530k
            int r2 = r2.G
            long r8 = (long) r2
            long r0 = r0 / r8
            r11.f5529j = r0
            r4.G(r3)
            d2.x0 r0 = r11.f5524e
            r0.d(r7, r4)
            r11.f5525f = r5
            goto L_0x0005
        L_0x00ca:
            int r0 = r12.f8416c
            int r1 = r12.f8415b
            int r0 = r0 - r1
            r1 = 64
            r6 = 65
            if (r0 <= 0) goto L_0x00ff
            boolean r0 = r11.f5527h
            r7 = 172(0xac, float:2.41E-43)
            if (r0 != 0) goto L_0x00e7
            int r0 = r12.v()
            if (r0 != r7) goto L_0x00e3
            r0 = 1
            goto L_0x00e4
        L_0x00e3:
            r0 = 0
        L_0x00e4:
            r11.f5527h = r0
            goto L_0x00ca
        L_0x00e7:
            int r0 = r12.v()
            if (r0 != r7) goto L_0x00ef
            r7 = 1
            goto L_0x00f0
        L_0x00ef:
            r7 = 0
        L_0x00f0:
            r11.f5527h = r7
            if (r0 == r1) goto L_0x00f6
            if (r0 != r6) goto L_0x00ca
        L_0x00f6:
            if (r0 != r6) goto L_0x00fa
            r0 = 1
            goto L_0x00fb
        L_0x00fa:
            r0 = 0
        L_0x00fb:
            r11.f5528i = r0
            r0 = 1
            goto L_0x0100
        L_0x00ff:
            r0 = 0
        L_0x0100:
            if (r0 == 0) goto L_0x0005
            r11.f5525f = r2
            byte[] r0 = r4.f8414a
            r4 = -84
            r0[r3] = r4
            boolean r3 = r11.f5528i
            if (r3 == 0) goto L_0x0110
            r1 = 65
        L_0x0110:
            byte r1 = (byte) r1
            r0[r2] = r1
            r11.f5526g = r5
            goto L_0x0005
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.e.c(j1.b0):void");
    }

    public final void d(y yVar, j0 j0Var) {
        j0Var.a();
        j0Var.b();
        this.f5523d = j0Var.f5631e;
        j0Var.b();
        this.f5524e = yVar.d(j0Var.f5630d, 1);
    }

    public final void e(int i10, long j10) {
        if (j10 != -9223372036854775807L) {
            this.f5532m = j10;
        }
    }

    public final void f() {
    }

    public e(String str) {
        a0 a0Var = new a0(16, new byte[16]);
        this.f5520a = a0Var;
        this.f5521b = new b0(a0Var.f8405a);
        this.f5525f = 0;
        this.f5526g = 0;
        this.f5527h = false;
        this.f5528i = false;
        this.f5532m = -9223372036854775807L;
        this.f5522c = str;
    }
}
