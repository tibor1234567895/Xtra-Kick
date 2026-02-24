package d0;

public final class u {

    /* renamed from: k  reason: collision with root package name */
    public static final u f4118k;

    /* renamed from: a  reason: collision with root package name */
    public final float f4119a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4120b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4121c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4122d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4123e;

    /* renamed from: f  reason: collision with root package name */
    public final float f4124f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f4125g;

    /* renamed from: h  reason: collision with root package name */
    public final float f4126h;

    /* renamed from: i  reason: collision with root package name */
    public final float f4127i;

    /* renamed from: j  reason: collision with root package name */
    public final float f4128j;

    static {
        float f10;
        float f11;
        float[] fArr = b.f4087c;
        float b10 = (float) ((((double) b.b()) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f4085a;
        float f12 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f13 = fArr[1];
        float f14 = fArr3[1] * f13;
        float f15 = fArr[2];
        float f16 = (fArr3[2] * f15) + f14 + (fArr3[0] * f12);
        float[] fArr4 = fArr2[1];
        float f17 = fArr4[1] * f13;
        float f18 = (fArr4[2] * f15) + f17 + (fArr4[0] * f12);
        float[] fArr5 = fArr2[2];
        float f19 = f12 * fArr5[0];
        float f20 = (f15 * fArr5[2]) + (f13 * fArr5[1]) + f19;
        if (((double) 1.0f) >= 0.9d) {
            f11 = 0.100000046f;
            f10 = 0.59f;
        } else {
            f11 = 0.12999998f;
            f10 = 0.525f;
        }
        float f21 = f11 + f10;
        float exp = (1.0f - (((float) Math.exp((double) (((-b10) - 42.0f) / 92.0f))) * 0.2777778f)) * 1.0f;
        double d10 = (double) exp;
        if (d10 > 1.0d) {
            exp = 1.0f;
        } else if (d10 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f16) * exp) + 1.0f) - exp, (((100.0f / f18) * exp) + 1.0f) - exp, (((100.0f / f20) * exp) + 1.0f) - exp};
        float f22 = 1.0f / ((5.0f * b10) + 1.0f);
        float f23 = f22 * f22 * f22 * f22;
        float f24 = 1.0f - f23;
        float cbrt = (0.1f * f24 * f24 * ((float) Math.cbrt(((double) b10) * 5.0d))) + (f23 * b10);
        float b11 = b.b() / fArr[1];
        double d11 = (double) b11;
        float sqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f20)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f16)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f18)) / 100.0d, 0.42d), pow2};
        float f25 = fArr7[0];
        float f26 = fArr7[1];
        float f27 = ((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f;
        f4118k = new u(b11, (f27 + (((f25 * 400.0f) / (f25 + 27.13f)) * 2.0f) + ((f26 * 400.0f) / (f26 + 27.13f))) * pow, pow, pow, f21, 1.0f, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public u(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f4124f = f10;
        this.f4119a = f11;
        this.f4120b = f12;
        this.f4121c = f13;
        this.f4122d = f14;
        this.f4123e = f15;
        this.f4125g = fArr;
        this.f4126h = f16;
        this.f4127i = f17;
        this.f4128j = f18;
    }
}
