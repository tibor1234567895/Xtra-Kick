package j3;

import xa.j;

public final class n1 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f8632a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f8633b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8634c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f8635d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f8636e;

    /* renamed from: f  reason: collision with root package name */
    public final int f8637f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8638g;

    /* renamed from: h  reason: collision with root package name */
    public final int f8639h;

    /* renamed from: i  reason: collision with root package name */
    public final int f8640i;

    /* renamed from: j  reason: collision with root package name */
    public final String f8641j;

    public n1(boolean z10, boolean z11, int i10, boolean z12, boolean z13, int i11, int i12, int i13, int i14) {
        this.f8632a = z10;
        this.f8633b = z11;
        this.f8634c = i10;
        this.f8635d = z12;
        this.f8636e = z13;
        this.f8637f = i11;
        this.f8638g = i12;
        this.f8639h = i13;
        this.f8640i = i14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !j.a(n1.class, obj.getClass())) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return this.f8632a == n1Var.f8632a && this.f8633b == n1Var.f8633b && this.f8634c == n1Var.f8634c && j.a(this.f8641j, n1Var.f8641j) && this.f8635d == n1Var.f8635d && this.f8636e == n1Var.f8636e && this.f8637f == n1Var.f8637f && this.f8638g == n1Var.f8638g && this.f8639h == n1Var.f8639h && this.f8640i == n1Var.f8640i;
    }

    public final int hashCode() {
        int i10 = (((((this.f8632a ? 1 : 0) * true) + (this.f8633b ? 1 : 0)) * 31) + this.f8634c) * 31;
        String str = this.f8641j;
        return ((((((((((((i10 + (str != null ? str.hashCode() : 0)) * 31) + (this.f8635d ? 1 : 0)) * 31) + (this.f8636e ? 1 : 0)) * 31) + this.f8637f) * 31) + this.f8638g) * 31) + this.f8639h) * 31) + this.f8640i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n1(boolean z10, boolean z11, String str, boolean z12, boolean z13, int i10, int i11, int i12, int i13) {
        this(z10, z11, a1.a(str).hashCode(), z12, z13, i10, i11, i12, i13);
        c1.f8505q.getClass();
        this.f8641j = str;
    }
}
