package ub;

import pb.h1;
import xa.j;

public final class n {

    /* renamed from: d  reason: collision with root package name */
    public static final m f15483d = new m(0);

    /* renamed from: a  reason: collision with root package name */
    public final h1 f15484a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15485b;

    /* renamed from: c  reason: collision with root package name */
    public final String f15486c;

    public n(h1 h1Var, int i10, String str) {
        this.f15484a = h1Var;
        this.f15485b = i10;
        this.f15486c = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15484a == h1.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.f15485b);
        sb2.append(' ');
        sb2.append(this.f15486c);
        String sb3 = sb2.toString();
        j.e("StringBuilder().apply(builderAction).toString()", sb3);
        return sb3;
    }
}
