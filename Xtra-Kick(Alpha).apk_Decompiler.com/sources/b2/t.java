package b2;

import android.view.Surface;
import j1.l0;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final b f2484a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final p f2485b;

    /* renamed from: c  reason: collision with root package name */
    public final s f2486c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2487d;

    /* renamed from: e  reason: collision with root package name */
    public Surface f2488e;

    /* renamed from: f  reason: collision with root package name */
    public float f2489f;

    /* renamed from: g  reason: collision with root package name */
    public float f2490g;

    /* renamed from: h  reason: collision with root package name */
    public float f2491h;

    /* renamed from: i  reason: collision with root package name */
    public float f2492i;

    /* renamed from: j  reason: collision with root package name */
    public int f2493j;

    /* renamed from: k  reason: collision with root package name */
    public long f2494k;

    /* renamed from: l  reason: collision with root package name */
    public long f2495l;

    /* renamed from: m  reason: collision with root package name */
    public long f2496m;

    /* renamed from: n  reason: collision with root package name */
    public long f2497n;

    /* renamed from: o  reason: collision with root package name */
    public long f2498o;

    /* renamed from: p  reason: collision with root package name */
    public long f2499p;

    /* renamed from: q  reason: collision with root package name */
    public long f2500q;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public t(android.content.Context r4) {
        /*
            r3 = this;
            r3.<init>()
            b2.b r0 = new b2.b
            r0.<init>()
            r3.f2484a = r0
            r0 = 0
            if (r4 == 0) goto L_0x003a
            android.content.Context r4 = r4.getApplicationContext()
            int r1 = j1.l0.f8453a
            r2 = 17
            if (r1 < r2) goto L_0x0027
            java.lang.String r1 = "display"
            java.lang.Object r1 = r4.getSystemService(r1)
            android.hardware.display.DisplayManager r1 = (android.hardware.display.DisplayManager) r1
            if (r1 == 0) goto L_0x0027
            b2.r r2 = new b2.r
            r2.<init>(r1)
            goto L_0x0028
        L_0x0027:
            r2 = r0
        L_0x0028:
            if (r2 != 0) goto L_0x003b
            java.lang.String r1 = "window"
            java.lang.Object r4 = r4.getSystemService(r1)
            android.view.WindowManager r4 = (android.view.WindowManager) r4
            if (r4 == 0) goto L_0x003a
            b2.q r2 = new b2.q
            r2.<init>(r4)
            goto L_0x003b
        L_0x003a:
            r2 = r0
        L_0x003b:
            r3.f2485b = r2
            if (r2 == 0) goto L_0x0041
            b2.s r0 = b2.s.f2479l
        L_0x0041:
            r3.f2486c = r0
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.f2494k = r0
            r3.f2495l = r0
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3.f2489f = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.f2492i = r4
            r4 = 0
            r3.f2493j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.t.<init>(android.content.Context):void");
    }

    public final void a() {
        Surface surface;
        if (l0.f8453a >= 30 && (surface = this.f2488e) != null && this.f2493j != Integer.MIN_VALUE && this.f2491h != 0.0f) {
            this.f2491h = 0.0f;
            o.a(surface, 0.0f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007d, code lost:
        if (java.lang.Math.abs(r2 - r9.f2490g) < r0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        if (r0.f2427e >= 30) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r9 = this;
            int r0 = j1.l0.f8453a
            r1 = 30
            if (r0 < r1) goto L_0x0090
            android.view.Surface r0 = r9.f2488e
            if (r0 != 0) goto L_0x000c
            goto L_0x0090
        L_0x000c:
            b2.b r0 = r9.f2484a
            boolean r2 = r0.a()
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == 0) goto L_0x0036
            boolean r2 = r0.a()
            if (r2 == 0) goto L_0x0033
            b2.a r2 = r0.f2423a
            long r4 = r2.f2419e
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            long r6 = r2.f2420f
            long r6 = r6 / r4
        L_0x002a:
            double r4 = (double) r6
            r6 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r6 = r6 / r4
            float r2 = (float) r6
            goto L_0x0038
        L_0x0033:
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0038
        L_0x0036:
            float r2 = r9.f2489f
        L_0x0038:
            float r4 = r9.f2490g
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x003f
            return
        L_0x003f:
            r5 = 1
            r6 = 0
            int r7 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0080
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0080
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x006a
            boolean r1 = r0.a()
            if (r1 == 0) goto L_0x005a
            b2.a r0 = r0.f2423a
            long r0 = r0.f2420f
            goto L_0x005f
        L_0x005a:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x005f:
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x006a
            r0 = 1
            goto L_0x006b
        L_0x006a:
            r0 = 0
        L_0x006b:
            if (r0 == 0) goto L_0x0071
            r0 = 1017370378(0x3ca3d70a, float:0.02)
            goto L_0x0073
        L_0x0071:
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x0073:
            float r1 = r9.f2490g
            float r1 = r2 - r1
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0088
            goto L_0x0089
        L_0x0080:
            if (r7 == 0) goto L_0x0083
            goto L_0x0089
        L_0x0083:
            int r0 = r0.f2427e
            if (r0 < r1) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r5 = 0
        L_0x0089:
            if (r5 == 0) goto L_0x0090
            r9.f2490g = r2
            r9.c(r6)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.t.b():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(boolean r4) {
        /*
            r3 = this;
            int r0 = j1.l0.f8453a
            r1 = 30
            if (r0 < r1) goto L_0x0031
            android.view.Surface r0 = r3.f2488e
            if (r0 == 0) goto L_0x0031
            int r1 = r3.f2493j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L_0x0011
            goto L_0x0031
        L_0x0011:
            boolean r1 = r3.f2487d
            if (r1 == 0) goto L_0x0022
            float r1 = r3.f2490g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0022
            float r2 = r3.f2492i
            float r1 = r1 * r2
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            if (r4 != 0) goto L_0x002c
            float r4 = r3.f2491h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x002c
            return
        L_0x002c:
            r3.f2491h = r1
            b2.o.a(r0, r1)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.t.c(boolean):void");
    }
}
