package x;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import u.f;
import u.j;

public final class d extends ViewGroup.MarginLayoutParams {
    public int A = RecyclerView.UNDEFINED_DURATION;
    public int B = RecyclerView.UNDEFINED_DURATION;
    public final int C = RecyclerView.UNDEFINED_DURATION;
    public final int D = 0;
    public float E = 0.5f;
    public float F = 0.5f;
    public String G = null;
    public float H = -1.0f;
    public float I = -1.0f;
    public int J = 0;
    public int K = 0;
    public int L = 0;
    public int M = 0;
    public int N = 0;
    public int O = 0;
    public int P = 0;
    public int Q = 0;
    public float R = 1.0f;
    public float S = 1.0f;
    public int T = -1;
    public int U = -1;
    public int V = -1;
    public boolean W = false;
    public boolean X = false;
    public String Y = null;
    public int Z = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f16355a = -1;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f16356a0 = true;

    /* renamed from: b  reason: collision with root package name */
    public int f16357b = -1;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f16358b0 = true;

    /* renamed from: c  reason: collision with root package name */
    public float f16359c = -1.0f;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f16360c0 = false;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16361d = true;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f16362d0 = false;

    /* renamed from: e  reason: collision with root package name */
    public int f16363e = -1;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f16364e0 = false;

    /* renamed from: f  reason: collision with root package name */
    public int f16365f = -1;

    /* renamed from: f0  reason: collision with root package name */
    public int f16366f0 = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f16367g = -1;

    /* renamed from: g0  reason: collision with root package name */
    public int f16368g0 = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f16369h = -1;

    /* renamed from: h0  reason: collision with root package name */
    public int f16370h0 = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f16371i = -1;

    /* renamed from: i0  reason: collision with root package name */
    public int f16372i0 = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f16373j = -1;

    /* renamed from: j0  reason: collision with root package name */
    public int f16374j0 = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: k  reason: collision with root package name */
    public int f16375k = -1;

    /* renamed from: k0  reason: collision with root package name */
    public int f16376k0 = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: l  reason: collision with root package name */
    public int f16377l = -1;

    /* renamed from: l0  reason: collision with root package name */
    public float f16378l0 = 0.5f;

    /* renamed from: m  reason: collision with root package name */
    public int f16379m = -1;

    /* renamed from: m0  reason: collision with root package name */
    public int f16380m0;

    /* renamed from: n  reason: collision with root package name */
    public int f16381n = -1;

    /* renamed from: n0  reason: collision with root package name */
    public int f16382n0;

    /* renamed from: o  reason: collision with root package name */
    public int f16383o = -1;

    /* renamed from: o0  reason: collision with root package name */
    public float f16384o0;

    /* renamed from: p  reason: collision with root package name */
    public int f16385p = -1;

    /* renamed from: p0  reason: collision with root package name */
    public f f16386p0 = new f();

    /* renamed from: q  reason: collision with root package name */
    public int f16387q = 0;

    /* renamed from: r  reason: collision with root package name */
    public float f16388r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    public int f16389s = -1;

    /* renamed from: t  reason: collision with root package name */
    public int f16390t = -1;

    /* renamed from: u  reason: collision with root package name */
    public int f16391u = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f16392v = -1;

    /* renamed from: w  reason: collision with root package name */
    public final int f16393w = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: x  reason: collision with root package name */
    public int f16394x = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: y  reason: collision with root package name */
    public final int f16395y = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: z  reason: collision with root package name */
    public int f16396z = RecyclerView.UNDEFINED_DURATION;

    public d() {
        super(-2, -2);
    }

    public final void a() {
        this.f16362d0 = false;
        this.f16356a0 = true;
        this.f16358b0 = true;
        int i10 = this.width;
        if (i10 == -2 && this.W) {
            this.f16356a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        int i11 = this.height;
        if (i11 == -2 && this.X) {
            this.f16358b0 = false;
            if (this.M == 0) {
                this.M = 1;
            }
        }
        if (i10 == 0 || i10 == -1) {
            this.f16356a0 = false;
            if (i10 == 0 && this.L == 1) {
                this.width = -2;
                this.W = true;
            }
        }
        if (i11 == 0 || i11 == -1) {
            this.f16358b0 = false;
            if (i11 == 0 && this.M == 1) {
                this.height = -2;
                this.X = true;
            }
        }
        if (this.f16359c != -1.0f || this.f16355a != -1 || this.f16357b != -1) {
            this.f16362d0 = true;
            this.f16356a0 = true;
            this.f16358b0 = true;
            if (!(this.f16386p0 instanceof j)) {
                this.f16386p0 = new j();
            }
            ((j) this.f16386p0).Q(this.V);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d0, code lost:
        if (r1 > 0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00df, code lost:
        if (r1 > 0) goto L_0x00d2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void resolveLayoutDirection(int r11) {
        /*
            r10 = this;
            int r0 = r10.leftMargin
            int r1 = r10.rightMargin
            super.resolveLayoutDirection(r11)
            int r11 = r10.getLayoutDirection()
            r2 = 0
            r3 = 1
            if (r3 != r11) goto L_0x0011
            r11 = 1
            goto L_0x0012
        L_0x0011:
            r11 = 0
        L_0x0012:
            r4 = -1
            r10.f16370h0 = r4
            r10.f16372i0 = r4
            r10.f16366f0 = r4
            r10.f16368g0 = r4
            int r5 = r10.f16393w
            r10.f16374j0 = r5
            int r5 = r10.f16395y
            r10.f16376k0 = r5
            float r5 = r10.E
            r10.f16378l0 = r5
            int r6 = r10.f16355a
            r10.f16380m0 = r6
            int r7 = r10.f16357b
            r10.f16382n0 = r7
            float r8 = r10.f16359c
            r10.f16384o0 = r8
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r11 == 0) goto L_0x0092
            int r11 = r10.f16389s
            if (r11 == r4) goto L_0x003f
            r10.f16370h0 = r11
        L_0x003d:
            r2 = 1
            goto L_0x0046
        L_0x003f:
            int r11 = r10.f16390t
            if (r11 == r4) goto L_0x0046
            r10.f16372i0 = r11
            goto L_0x003d
        L_0x0046:
            int r11 = r10.f16391u
            if (r11 == r4) goto L_0x004d
            r10.f16368g0 = r11
            r2 = 1
        L_0x004d:
            int r11 = r10.f16392v
            if (r11 == r4) goto L_0x0054
            r10.f16366f0 = r11
            r2 = 1
        L_0x0054:
            int r11 = r10.A
            if (r11 == r9) goto L_0x005a
            r10.f16376k0 = r11
        L_0x005a:
            int r11 = r10.B
            if (r11 == r9) goto L_0x0060
            r10.f16374j0 = r11
        L_0x0060:
            r11 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0068
            float r2 = r11 - r5
            r10.f16378l0 = r2
        L_0x0068:
            boolean r2 = r10.f16362d0
            if (r2 == 0) goto L_0x00b6
            int r2 = r10.V
            if (r2 != r3) goto L_0x00b6
            boolean r2 = r10.f16361d
            if (r2 == 0) goto L_0x00b6
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x0082
            float r11 = r11 - r8
            r10.f16384o0 = r11
            r10.f16380m0 = r4
            r10.f16382n0 = r4
            goto L_0x00b6
        L_0x0082:
            if (r6 == r4) goto L_0x008b
            r10.f16382n0 = r6
            r10.f16380m0 = r4
        L_0x0088:
            r10.f16384o0 = r2
            goto L_0x00b6
        L_0x008b:
            if (r7 == r4) goto L_0x00b6
            r10.f16380m0 = r7
            r10.f16382n0 = r4
            goto L_0x0088
        L_0x0092:
            int r11 = r10.f16389s
            if (r11 == r4) goto L_0x0098
            r10.f16368g0 = r11
        L_0x0098:
            int r11 = r10.f16390t
            if (r11 == r4) goto L_0x009e
            r10.f16366f0 = r11
        L_0x009e:
            int r11 = r10.f16391u
            if (r11 == r4) goto L_0x00a4
            r10.f16370h0 = r11
        L_0x00a4:
            int r11 = r10.f16392v
            if (r11 == r4) goto L_0x00aa
            r10.f16372i0 = r11
        L_0x00aa:
            int r11 = r10.A
            if (r11 == r9) goto L_0x00b0
            r10.f16374j0 = r11
        L_0x00b0:
            int r11 = r10.B
            if (r11 == r9) goto L_0x00b6
            r10.f16376k0 = r11
        L_0x00b6:
            int r11 = r10.f16391u
            if (r11 != r4) goto L_0x00fe
            int r11 = r10.f16392v
            if (r11 != r4) goto L_0x00fe
            int r11 = r10.f16390t
            if (r11 != r4) goto L_0x00fe
            int r11 = r10.f16389s
            if (r11 != r4) goto L_0x00fe
            int r11 = r10.f16367g
            if (r11 == r4) goto L_0x00d5
            r10.f16370h0 = r11
            int r11 = r10.rightMargin
            if (r11 > 0) goto L_0x00e2
            if (r1 <= 0) goto L_0x00e2
        L_0x00d2:
            r10.rightMargin = r1
            goto L_0x00e2
        L_0x00d5:
            int r11 = r10.f16369h
            if (r11 == r4) goto L_0x00e2
            r10.f16372i0 = r11
            int r11 = r10.rightMargin
            if (r11 > 0) goto L_0x00e2
            if (r1 <= 0) goto L_0x00e2
            goto L_0x00d2
        L_0x00e2:
            int r11 = r10.f16363e
            if (r11 == r4) goto L_0x00f1
            r10.f16366f0 = r11
            int r11 = r10.leftMargin
            if (r11 > 0) goto L_0x00fe
            if (r0 <= 0) goto L_0x00fe
        L_0x00ee:
            r10.leftMargin = r0
            goto L_0x00fe
        L_0x00f1:
            int r11 = r10.f16365f
            if (r11 == r4) goto L_0x00fe
            r10.f16368g0 = r11
            int r11 = r10.leftMargin
            if (r11 > 0) goto L_0x00fe
            if (r0 <= 0) goto L_0x00fe
            goto L_0x00ee
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x.d.resolveLayoutDirection(int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x014c, code lost:
        android.util.Log.e("ConstraintLayout", r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            r9 = this;
            r9.<init>(r10, r11)
            r0 = -1
            r9.f16355a = r0
            r9.f16357b = r0
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9.f16359c = r1
            r2 = 1
            r9.f16361d = r2
            r9.f16363e = r0
            r9.f16365f = r0
            r9.f16367g = r0
            r9.f16369h = r0
            r9.f16371i = r0
            r9.f16373j = r0
            r9.f16375k = r0
            r9.f16377l = r0
            r9.f16379m = r0
            r9.f16381n = r0
            r9.f16383o = r0
            r9.f16385p = r0
            r3 = 0
            r9.f16387q = r3
            r4 = 0
            r9.f16388r = r4
            r9.f16389s = r0
            r9.f16390t = r0
            r9.f16391u = r0
            r9.f16392v = r0
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r9.f16393w = r5
            r9.f16394x = r5
            r9.f16395y = r5
            r9.f16396z = r5
            r9.A = r5
            r9.B = r5
            r9.C = r5
            r9.D = r3
            r6 = 1056964608(0x3f000000, float:0.5)
            r9.E = r6
            r9.F = r6
            r7 = 0
            r9.G = r7
            r9.H = r1
            r9.I = r1
            r9.J = r3
            r9.K = r3
            r9.L = r3
            r9.M = r3
            r9.N = r3
            r9.O = r3
            r9.P = r3
            r9.Q = r3
            r1 = 1065353216(0x3f800000, float:1.0)
            r9.R = r1
            r9.S = r1
            r9.T = r0
            r9.U = r0
            r9.V = r0
            r9.W = r3
            r9.X = r3
            r9.Y = r7
            r9.Z = r3
            r9.f16356a0 = r2
            r9.f16358b0 = r2
            r9.f16360c0 = r3
            r9.f16362d0 = r3
            r9.f16364e0 = r3
            r9.f16366f0 = r0
            r9.f16368g0 = r0
            r9.f16370h0 = r0
            r9.f16372i0 = r0
            r9.f16374j0 = r5
            r9.f16376k0 = r5
            r9.f16378l0 = r6
            u.f r1 = new u.f
            r1.<init>()
            r9.f16386p0 = r1
            int[] r1 = x.p.f16499b
            android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r11, r1)
            int r11 = r10.getIndexCount()
            r1 = 0
        L_0x00a2:
            if (r1 >= r11) goto L_0x0390
            int r5 = r10.getIndex(r1)
            android.util.SparseIntArray r6 = x.c.f16354a
            int r6 = r6.get(r5)
            r7 = 2
            r8 = -2
            switch(r6) {
                case 1: goto L_0x02f1;
                case 2: goto L_0x02df;
                case 3: goto L_0x02d5;
                case 4: goto L_0x02bf;
                case 5: goto L_0x02b5;
                case 6: goto L_0x02ab;
                case 7: goto L_0x02a1;
                case 8: goto L_0x028f;
                case 9: goto L_0x027d;
                case 10: goto L_0x026b;
                case 11: goto L_0x0259;
                case 12: goto L_0x0247;
                case 13: goto L_0x0235;
                case 14: goto L_0x0223;
                case 15: goto L_0x0211;
                case 16: goto L_0x01ff;
                case 17: goto L_0x01ed;
                case 18: goto L_0x01db;
                case 19: goto L_0x01c9;
                case 20: goto L_0x01b7;
                case 21: goto L_0x01ad;
                case 22: goto L_0x01a3;
                case 23: goto L_0x0199;
                case 24: goto L_0x018f;
                case 25: goto L_0x0185;
                case 26: goto L_0x017b;
                case 27: goto L_0x0171;
                case 28: goto L_0x0167;
                case 29: goto L_0x015d;
                case 30: goto L_0x0153;
                case 31: goto L_0x0142;
                case 32: goto L_0x0137;
                case 33: goto L_0x0120;
                case 34: goto L_0x0109;
                case 35: goto L_0x00f9;
                case 36: goto L_0x00e2;
                case 37: goto L_0x00cb;
                case 38: goto L_0x00bb;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            switch(r6) {
                case 44: goto L_0x036b;
                case 45: goto L_0x0362;
                case 46: goto L_0x0359;
                case 47: goto L_0x0352;
                case 48: goto L_0x034b;
                case 49: goto L_0x0342;
                case 50: goto L_0x0339;
                case 51: goto L_0x0332;
                case 52: goto L_0x0321;
                case 53: goto L_0x030f;
                case 54: goto L_0x0305;
                case 55: goto L_0x02fb;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            switch(r6) {
                case 64: goto L_0x0389;
                case 65: goto L_0x0385;
                case 66: goto L_0x037c;
                case 67: goto L_0x0373;
                default: goto L_0x00b9;
            }
        L_0x00b9:
            goto L_0x038c
        L_0x00bb:
            float r6 = r9.S
            float r5 = r10.getFloat(r5, r6)
            float r5 = java.lang.Math.max(r4, r5)
            r9.S = r5
            r9.M = r7
            goto L_0x038c
        L_0x00cb:
            int r6 = r9.Q     // Catch:{ Exception -> 0x00d5 }
            int r6 = r10.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x00d5 }
            r9.Q = r6     // Catch:{ Exception -> 0x00d5 }
            goto L_0x038c
        L_0x00d5:
            int r6 = r9.Q
            int r5 = r10.getInt(r5, r6)
            if (r5 != r8) goto L_0x038c
            r9.Q = r8
            goto L_0x038c
        L_0x00e2:
            int r6 = r9.O     // Catch:{ Exception -> 0x00ec }
            int r6 = r10.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x00ec }
            r9.O = r6     // Catch:{ Exception -> 0x00ec }
            goto L_0x038c
        L_0x00ec:
            int r6 = r9.O
            int r5 = r10.getInt(r5, r6)
            if (r5 != r8) goto L_0x038c
            r9.O = r8
            goto L_0x038c
        L_0x00f9:
            float r6 = r9.R
            float r5 = r10.getFloat(r5, r6)
            float r5 = java.lang.Math.max(r4, r5)
            r9.R = r5
            r9.L = r7
            goto L_0x038c
        L_0x0109:
            int r6 = r9.P     // Catch:{ Exception -> 0x0113 }
            int r6 = r10.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x0113 }
            r9.P = r6     // Catch:{ Exception -> 0x0113 }
            goto L_0x038c
        L_0x0113:
            int r6 = r9.P
            int r5 = r10.getInt(r5, r6)
            if (r5 != r8) goto L_0x038c
            r9.P = r8
            goto L_0x038c
        L_0x0120:
            int r6 = r9.N     // Catch:{ Exception -> 0x012a }
            int r6 = r10.getDimensionPixelSize(r5, r6)     // Catch:{ Exception -> 0x012a }
            r9.N = r6     // Catch:{ Exception -> 0x012a }
            goto L_0x038c
        L_0x012a:
            int r6 = r9.N
            int r5 = r10.getInt(r5, r6)
            if (r5 != r8) goto L_0x038c
            r9.N = r8
            goto L_0x038c
        L_0x0137:
            int r5 = r10.getInt(r5, r3)
            r9.M = r5
            if (r5 != r2) goto L_0x038c
            java.lang.String r5 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead."
            goto L_0x014c
        L_0x0142:
            int r5 = r10.getInt(r5, r3)
            r9.L = r5
            if (r5 != r2) goto L_0x038c
            java.lang.String r5 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead."
        L_0x014c:
            java.lang.String r6 = "ConstraintLayout"
            android.util.Log.e(r6, r5)
            goto L_0x038c
        L_0x0153:
            float r6 = r9.F
            float r5 = r10.getFloat(r5, r6)
            r9.F = r5
            goto L_0x038c
        L_0x015d:
            float r6 = r9.E
            float r5 = r10.getFloat(r5, r6)
            r9.E = r5
            goto L_0x038c
        L_0x0167:
            boolean r6 = r9.X
            boolean r5 = r10.getBoolean(r5, r6)
            r9.X = r5
            goto L_0x038c
        L_0x0171:
            boolean r6 = r9.W
            boolean r5 = r10.getBoolean(r5, r6)
            r9.W = r5
            goto L_0x038c
        L_0x017b:
            int r6 = r9.B
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.B = r5
            goto L_0x038c
        L_0x0185:
            int r6 = r9.A
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.A = r5
            goto L_0x038c
        L_0x018f:
            int r6 = r9.f16396z
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.f16396z = r5
            goto L_0x038c
        L_0x0199:
            int r6 = r9.f16395y
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.f16395y = r5
            goto L_0x038c
        L_0x01a3:
            int r6 = r9.f16394x
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.f16394x = r5
            goto L_0x038c
        L_0x01ad:
            int r6 = r9.f16393w
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.f16393w = r5
            goto L_0x038c
        L_0x01b7:
            int r6 = r9.f16392v
            int r6 = r10.getResourceId(r5, r6)
            r9.f16392v = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16392v = r5
            goto L_0x038c
        L_0x01c9:
            int r6 = r9.f16391u
            int r6 = r10.getResourceId(r5, r6)
            r9.f16391u = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16391u = r5
            goto L_0x038c
        L_0x01db:
            int r6 = r9.f16390t
            int r6 = r10.getResourceId(r5, r6)
            r9.f16390t = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16390t = r5
            goto L_0x038c
        L_0x01ed:
            int r6 = r9.f16389s
            int r6 = r10.getResourceId(r5, r6)
            r9.f16389s = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16389s = r5
            goto L_0x038c
        L_0x01ff:
            int r6 = r9.f16379m
            int r6 = r10.getResourceId(r5, r6)
            r9.f16379m = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16379m = r5
            goto L_0x038c
        L_0x0211:
            int r6 = r9.f16377l
            int r6 = r10.getResourceId(r5, r6)
            r9.f16377l = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16377l = r5
            goto L_0x038c
        L_0x0223:
            int r6 = r9.f16375k
            int r6 = r10.getResourceId(r5, r6)
            r9.f16375k = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16375k = r5
            goto L_0x038c
        L_0x0235:
            int r6 = r9.f16373j
            int r6 = r10.getResourceId(r5, r6)
            r9.f16373j = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16373j = r5
            goto L_0x038c
        L_0x0247:
            int r6 = r9.f16371i
            int r6 = r10.getResourceId(r5, r6)
            r9.f16371i = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16371i = r5
            goto L_0x038c
        L_0x0259:
            int r6 = r9.f16369h
            int r6 = r10.getResourceId(r5, r6)
            r9.f16369h = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16369h = r5
            goto L_0x038c
        L_0x026b:
            int r6 = r9.f16367g
            int r6 = r10.getResourceId(r5, r6)
            r9.f16367g = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16367g = r5
            goto L_0x038c
        L_0x027d:
            int r6 = r9.f16365f
            int r6 = r10.getResourceId(r5, r6)
            r9.f16365f = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16365f = r5
            goto L_0x038c
        L_0x028f:
            int r6 = r9.f16363e
            int r6 = r10.getResourceId(r5, r6)
            r9.f16363e = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16363e = r5
            goto L_0x038c
        L_0x02a1:
            float r6 = r9.f16359c
            float r5 = r10.getFloat(r5, r6)
            r9.f16359c = r5
            goto L_0x038c
        L_0x02ab:
            int r6 = r9.f16357b
            int r5 = r10.getDimensionPixelOffset(r5, r6)
            r9.f16357b = r5
            goto L_0x038c
        L_0x02b5:
            int r6 = r9.f16355a
            int r5 = r10.getDimensionPixelOffset(r5, r6)
            r9.f16355a = r5
            goto L_0x038c
        L_0x02bf:
            float r6 = r9.f16388r
            float r5 = r10.getFloat(r5, r6)
            r6 = 1135869952(0x43b40000, float:360.0)
            float r5 = r5 % r6
            r9.f16388r = r5
            int r7 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x038c
            float r5 = r6 - r5
            float r5 = r5 % r6
            r9.f16388r = r5
            goto L_0x038c
        L_0x02d5:
            int r6 = r9.f16387q
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.f16387q = r5
            goto L_0x038c
        L_0x02df:
            int r6 = r9.f16385p
            int r6 = r10.getResourceId(r5, r6)
            r9.f16385p = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16385p = r5
            goto L_0x038c
        L_0x02f1:
            int r6 = r9.V
            int r5 = r10.getInt(r5, r6)
            r9.V = r5
            goto L_0x038c
        L_0x02fb:
            int r6 = r9.C
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.C = r5
            goto L_0x038c
        L_0x0305:
            int r6 = r9.D
            int r5 = r10.getDimensionPixelSize(r5, r6)
            r9.D = r5
            goto L_0x038c
        L_0x030f:
            int r6 = r9.f16383o
            int r6 = r10.getResourceId(r5, r6)
            r9.f16383o = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16383o = r5
            goto L_0x038c
        L_0x0321:
            int r6 = r9.f16381n
            int r6 = r10.getResourceId(r5, r6)
            r9.f16381n = r6
            if (r6 != r0) goto L_0x038c
            int r5 = r10.getInt(r5, r0)
            r9.f16381n = r5
            goto L_0x038c
        L_0x0332:
            java.lang.String r5 = r10.getString(r5)
            r9.Y = r5
            goto L_0x038c
        L_0x0339:
            int r6 = r9.U
            int r5 = r10.getDimensionPixelOffset(r5, r6)
            r9.U = r5
            goto L_0x038c
        L_0x0342:
            int r6 = r9.T
            int r5 = r10.getDimensionPixelOffset(r5, r6)
            r9.T = r5
            goto L_0x038c
        L_0x034b:
            int r5 = r10.getInt(r5, r3)
            r9.K = r5
            goto L_0x038c
        L_0x0352:
            int r5 = r10.getInt(r5, r3)
            r9.J = r5
            goto L_0x038c
        L_0x0359:
            float r6 = r9.I
            float r5 = r10.getFloat(r5, r6)
            r9.I = r5
            goto L_0x038c
        L_0x0362:
            float r6 = r9.H
            float r5 = r10.getFloat(r5, r6)
            r9.H = r5
            goto L_0x038c
        L_0x036b:
            java.lang.String r5 = r10.getString(r5)
            x.m.h(r9, r5)
            goto L_0x038c
        L_0x0373:
            boolean r6 = r9.f16361d
            boolean r5 = r10.getBoolean(r5, r6)
            r9.f16361d = r5
            goto L_0x038c
        L_0x037c:
            int r6 = r9.Z
            int r5 = r10.getInt(r5, r6)
            r9.Z = r5
            goto L_0x038c
        L_0x0385:
            x.m.g(r9, r10, r5, r2)
            goto L_0x038c
        L_0x0389:
            x.m.g(r9, r10, r5, r3)
        L_0x038c:
            int r1 = r1 + 1
            goto L_0x00a2
        L_0x0390:
            r10.recycle()
            r9.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x.d.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public d(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }
}
