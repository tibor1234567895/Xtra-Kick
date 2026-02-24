package w7;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import q0.f;

public class e implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f16160a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f16161b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f16162c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
        float[] fArr = this.f16160a;
        matrix.getValues(fArr);
        float[] fArr2 = this.f16161b;
        matrix2.getValues(fArr2);
        for (int i10 = 0; i10 < 9; i10++) {
            float f11 = fArr2[i10];
            float f12 = fArr[i10];
            fArr2[i10] = f.f(f11, f12, f10, f12);
        }
        Matrix matrix3 = this.f16162c;
        matrix3.setValues(fArr2);
        return matrix3;
    }
}
