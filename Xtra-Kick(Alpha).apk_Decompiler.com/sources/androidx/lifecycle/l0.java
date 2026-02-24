package androidx.lifecycle;

public final class l0 implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final k0 f1729a;

    /* renamed from: b  reason: collision with root package name */
    public final p0 f1730b;

    /* renamed from: c  reason: collision with root package name */
    public int f1731c = -1;

    public l0(k0 k0Var, v1 v1Var) {
        this.f1729a = k0Var;
        this.f1730b = v1Var;
    }

    public final void b(Object obj) {
        int i10 = this.f1731c;
        int i11 = this.f1729a.f1725g;
        if (i10 != i11) {
            this.f1731c = i11;
            this.f1730b.b(obj);
        }
    }
}
