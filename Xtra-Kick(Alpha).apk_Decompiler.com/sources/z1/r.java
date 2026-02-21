package z1;

import g1.v1;
import j1.v;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final v1 f17476a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f17477b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17478c;

    public r(int i10, v1 v1Var, int[] iArr) {
        if (iArr.length == 0) {
            v.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.f17476a = v1Var;
        this.f17477b = iArr;
        this.f17478c = i10;
    }
}
