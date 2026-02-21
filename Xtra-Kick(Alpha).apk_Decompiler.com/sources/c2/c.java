package c2;

import android.opengl.Matrix;
import j1.g0;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f2727a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f2728b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    public final g0 f2729c = new g0();

    /* renamed from: d  reason: collision with root package name */
    public boolean f2730d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f10 = fArr2[10];
        float f11 = fArr2[8];
        float sqrt = (float) Math.sqrt((double) ((f11 * f11) + (f10 * f10)));
        float f12 = fArr2[10];
        fArr[0] = f12 / sqrt;
        float f13 = fArr2[8];
        fArr[2] = f13 / sqrt;
        fArr[8] = (-f13) / sqrt;
        fArr[10] = f12 / sqrt;
    }
}
