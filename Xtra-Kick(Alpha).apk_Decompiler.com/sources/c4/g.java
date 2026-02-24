package c4;

import android.animation.TypeEvaluator;
import e0.h;
import e0.i;

public final class g implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public h[] f2890a;

    public final Object evaluate(float f10, Object obj, Object obj2) {
        h[] hVarArr = (h[]) obj;
        h[] hVarArr2 = (h[]) obj2;
        if (i.a(hVarArr, hVarArr2)) {
            if (!i.a(this.f2890a, hVarArr)) {
                this.f2890a = i.e(hVarArr);
            }
            for (int i10 = 0; i10 < hVarArr.length; i10++) {
                h hVar = this.f2890a[i10];
                h hVar2 = hVarArr[i10];
                h hVar3 = hVarArr2[i10];
                hVar.getClass();
                hVar.f4862a = hVar2.f4862a;
                int i11 = 0;
                while (true) {
                    float[] fArr = hVar2.f4863b;
                    if (i11 >= fArr.length) {
                        break;
                    }
                    hVar.f4863b[i11] = (hVar3.f4863b[i11] * f10) + ((1.0f - f10) * fArr[i11]);
                    i11++;
                }
            }
            return this.f2890a;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
