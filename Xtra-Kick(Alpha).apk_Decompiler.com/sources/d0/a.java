package d0;

import android.graphics.Color;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final float f4079a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4080b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4081c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4082d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4083e;

    /* renamed from: f  reason: collision with root package name */
    public final float f4084f;

    public a(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f4079a = f10;
        this.f4080b = f11;
        this.f4081c = f12;
        this.f4082d = f13;
        this.f4083e = f14;
        this.f4084f = f15;
    }

    public static a a(int i10) {
        float f10;
        u uVar = u.f4118k;
        float a10 = b.a(Color.red(i10));
        float a11 = b.a(Color.green(i10));
        float a12 = b.a(Color.blue(i10));
        float[][] fArr = b.f4088d;
        float[] fArr2 = fArr[0];
        float f11 = fArr2[1] * a11;
        float f12 = (fArr2[2] * a12) + f11 + (fArr2[0] * a10);
        float[] fArr3 = fArr[1];
        float f13 = fArr3[1] * a11;
        float f14 = (fArr3[2] * a12) + f13 + (fArr3[0] * a10);
        float[] fArr4 = fArr[2];
        float f15 = (a12 * fArr4[2]) + (a11 * fArr4[1]) + (a10 * fArr4[0]);
        float[][] fArr5 = b.f4085a;
        float[] fArr6 = fArr5[0];
        float f16 = fArr6[1] * f14;
        float f17 = (fArr6[2] * f15) + f16 + (fArr6[0] * f12);
        float[] fArr7 = fArr5[1];
        float f18 = fArr7[1] * f14;
        float f19 = fArr7[2] * f15;
        float[] fArr8 = fArr5[2];
        float f20 = f12 * fArr8[0];
        float f21 = f15 * fArr8[2];
        float[] fArr9 = uVar.f4125g;
        float f22 = fArr9[0] * f17;
        float f23 = fArr9[1] * (f19 + f18 + (fArr7[0] * f12));
        float f24 = fArr9[2] * (f21 + (f14 * fArr8[1]) + f20);
        float abs = Math.abs(f22);
        float f25 = uVar.f4126h;
        float pow = (float) Math.pow(((double) (abs * f25)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (Math.abs(f23) * f25)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (Math.abs(f24) * f25)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f22) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f23) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f24) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d10 = (double) signum3;
        float f26 = ((float) (((((double) signum2) * -12.0d) + (((double) signum) * 11.0d)) + d10)) / 11.0f;
        float f27 = ((float) (((double) (signum + signum2)) - (d10 * 2.0d))) / 9.0f;
        float f28 = signum2 * 20.0f;
        float f29 = ((21.0f * signum3) + ((signum * 20.0f) + f28)) / 20.0f;
        float f30 = (((signum * 40.0f) + f28) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f27, (double) f26)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f31 = atan2;
        float f32 = (3.1415927f * f31) / 180.0f;
        float f33 = f30 * uVar.f4120b;
        float f34 = uVar.f4119a;
        double d11 = (double) (f33 / f34);
        float f35 = uVar.f4128j;
        float f36 = uVar.f4122d;
        float pow4 = ((float) Math.pow(d11, (double) (f35 * f36))) * 100.0f;
        Math.sqrt((double) (pow4 / 100.0f));
        float f37 = f34 + 4.0f;
        if (((double) f31) < 20.14d) {
            f10 = 360.0f + f31;
        } else {
            f10 = f31;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) uVar.f4124f), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) f10) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * uVar.f4123e) * uVar.f4121c) * ((float) Math.sqrt((double) ((f27 * f27) + (f26 * f26))))) / (f29 + 0.305f)), 0.9d));
        float sqrt = pow5 * ((float) Math.sqrt(((double) pow4) / 100.0d));
        Math.sqrt((double) ((pow5 * f36) / f37));
        float f38 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((uVar.f4127i * sqrt * 0.0228f) + 1.0f))) * 43.85965f;
        double d12 = (double) f32;
        return new a(f31, sqrt, pow4, f38, log * ((float) Math.cos(d12)), log * ((float) Math.sin(d12)));
    }

    public static a b(float f10, float f11, float f12) {
        u uVar = u.f4118k;
        float f13 = uVar.f4122d;
        double d10 = ((double) f10) / 100.0d;
        Math.sqrt(d10);
        Math.sqrt((double) (((f11 / ((float) Math.sqrt(d10))) * uVar.f4122d) / (uVar.f4119a + 4.0f)));
        float f14 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float log = ((float) Math.log((((double) (uVar.f4127i * f11)) * 0.0228d) + 1.0d)) * 43.85965f;
        double d11 = (double) ((3.1415927f * f12) / 180.0f);
        return new a(f12, f11, f10, f14, log * ((float) Math.cos(d11)), log * ((float) Math.sin(d11)));
    }

    public final int c(u uVar) {
        float f10;
        u uVar2 = uVar;
        float f11 = this.f4080b;
        float f12 = this.f4081c;
        if (((double) f11) != 0.0d) {
            double d10 = (double) f12;
            if (d10 != 0.0d) {
                f10 = f11 / ((float) Math.sqrt(d10 / 100.0d));
                float pow = (float) Math.pow(((double) f10) / Math.pow(1.64d - Math.pow(0.29d, (double) uVar2.f4124f), 0.73d), 1.1111111111111112d);
                double d11 = (double) ((this.f4079a * 3.1415927f) / 180.0f);
                float pow2 = uVar2.f4119a * ((float) Math.pow(((double) f12) / 100.0d, (1.0d / ((double) uVar2.f4122d)) / ((double) uVar2.f4128j)));
                float cos = ((float) (Math.cos(2.0d + d11) + 3.8d)) * 0.25f * 3846.1538f * uVar2.f4123e * uVar2.f4121c;
                float f13 = pow2 / uVar2.f4120b;
                float sin = (float) Math.sin(d11);
                float cos2 = (float) Math.cos(d11);
                float f14 = 11.0f * pow * cos2;
                float f15 = (((0.305f + f13) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (f14 + (cos * 23.0f)));
                float f16 = cos2 * f15;
                float f17 = f15 * sin;
                float f18 = f13 * 460.0f;
                float f19 = ((288.0f * f17) + ((451.0f * f16) + f18)) / 1403.0f;
                float f20 = ((f18 - (891.0f * f16)) - (261.0f * f17)) / 1403.0f;
                float f21 = ((f18 - (f16 * 220.0f)) - (f17 * 6300.0f)) / 1403.0f;
                float signum = Math.signum(f19);
                float f22 = 100.0f / uVar2.f4126h;
                float pow3 = signum * f22 * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f19)) * 27.13d) / (400.0d - ((double) Math.abs(f19))))), 2.380952380952381d));
                float signum2 = Math.signum(f20) * f22 * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f20)) * 27.13d) / (400.0d - ((double) Math.abs(f20))))), 2.380952380952381d));
                float[] fArr = uVar2.f4125g;
                float f23 = pow3 / fArr[0];
                float f24 = signum2 / fArr[1];
                float signum3 = ((Math.signum(f21) * f22) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f21)) * 27.13d) / (400.0d - ((double) Math.abs(f21))))), 2.380952380952381d))) / fArr[2];
                float[][] fArr2 = b.f4086b;
                float[] fArr3 = fArr2[0];
                float f25 = fArr3[1] * f24;
                float f26 = (fArr3[2] * signum3) + f25 + (fArr3[0] * f23);
                float[] fArr4 = fArr2[1];
                float f27 = fArr4[1] * f24;
                float f28 = fArr4[2] * signum3;
                float[] fArr5 = fArr2[2];
                float f29 = f23 * fArr5[0];
                return e0.a.a((double) f26, (double) (f28 + f27 + (fArr4[0] * f23)), (double) ((signum3 * fArr5[2]) + (f24 * fArr5[1]) + f29));
            }
        }
        f10 = 0.0f;
        float pow4 = (float) Math.pow(((double) f10) / Math.pow(1.64d - Math.pow(0.29d, (double) uVar2.f4124f), 0.73d), 1.1111111111111112d);
        double d112 = (double) ((this.f4079a * 3.1415927f) / 180.0f);
        float pow22 = uVar2.f4119a * ((float) Math.pow(((double) f12) / 100.0d, (1.0d / ((double) uVar2.f4122d)) / ((double) uVar2.f4128j)));
        float cos3 = ((float) (Math.cos(2.0d + d112) + 3.8d)) * 0.25f * 3846.1538f * uVar2.f4123e * uVar2.f4121c;
        float f132 = pow22 / uVar2.f4120b;
        float sin2 = (float) Math.sin(d112);
        float cos22 = (float) Math.cos(d112);
        float f142 = 11.0f * pow4 * cos22;
        float f152 = (((0.305f + f132) * 23.0f) * pow4) / (((pow4 * 108.0f) * sin2) + (f142 + (cos3 * 23.0f)));
        float f162 = cos22 * f152;
        float f172 = f152 * sin2;
        float f182 = f132 * 460.0f;
        float f192 = ((288.0f * f172) + ((451.0f * f162) + f182)) / 1403.0f;
        float f202 = ((f182 - (891.0f * f162)) - (261.0f * f172)) / 1403.0f;
        float f212 = ((f182 - (f162 * 220.0f)) - (f172 * 6300.0f)) / 1403.0f;
        float signum4 = Math.signum(f192);
        float f222 = 100.0f / uVar2.f4126h;
        float pow32 = signum4 * f222 * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f192)) * 27.13d) / (400.0d - ((double) Math.abs(f192))))), 2.380952380952381d));
        float signum22 = Math.signum(f202) * f222 * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f202)) * 27.13d) / (400.0d - ((double) Math.abs(f202))))), 2.380952380952381d));
        float[] fArr6 = uVar2.f4125g;
        float f232 = pow32 / fArr6[0];
        float f242 = signum22 / fArr6[1];
        float signum32 = ((Math.signum(f212) * f222) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f212)) * 27.13d) / (400.0d - ((double) Math.abs(f212))))), 2.380952380952381d))) / fArr6[2];
        float[][] fArr22 = b.f4086b;
        float[] fArr32 = fArr22[0];
        float f252 = fArr32[1] * f242;
        float f262 = (fArr32[2] * signum32) + f252 + (fArr32[0] * f232);
        float[] fArr42 = fArr22[1];
        float f272 = fArr42[1] * f242;
        float f282 = fArr42[2] * signum32;
        float[] fArr52 = fArr22[2];
        float f292 = f232 * fArr52[0];
        return e0.a.a((double) f262, (double) (f282 + f272 + (fArr42[0] * f232)), (double) ((signum32 * fArr52[2]) + (f242 * fArr52[1]) + f292));
    }
}
