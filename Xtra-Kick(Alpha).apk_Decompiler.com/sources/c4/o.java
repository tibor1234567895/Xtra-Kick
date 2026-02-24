package c4;

import e0.h;
import e0.i;

public abstract class o extends n {

    /* renamed from: a  reason: collision with root package name */
    public h[] f2916a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f2917b;

    /* renamed from: c  reason: collision with root package name */
    public int f2918c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f2919d;

    public o() {
        super(0);
    }

    public h[] getPathData() {
        return this.f2916a;
    }

    public String getPathName() {
        return this.f2917b;
    }

    public void setPathData(h[] hVarArr) {
        if (!i.a(this.f2916a, hVarArr)) {
            this.f2916a = i.e(hVarArr);
            return;
        }
        h[] hVarArr2 = this.f2916a;
        for (int i10 = 0; i10 < hVarArr.length; i10++) {
            hVarArr2[i10].f4862a = hVarArr[i10].f4862a;
            int i11 = 0;
            while (true) {
                float[] fArr = hVarArr[i10].f4863b;
                if (i11 >= fArr.length) {
                    break;
                }
                hVarArr2[i10].f4863b[i11] = fArr[i11];
                i11++;
            }
        }
    }

    public o(o oVar) {
        super(0);
        this.f2917b = oVar.f2917b;
        this.f2919d = oVar.f2919d;
        this.f2916a = i.e(oVar.f2916a);
    }
}
