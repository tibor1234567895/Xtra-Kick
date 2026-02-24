package androidx.lifecycle;

public abstract class j0 {

    /* renamed from: h  reason: collision with root package name */
    public final p0 f1707h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1708i;

    /* renamed from: j  reason: collision with root package name */
    public int f1709j = -1;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ k0 f1710k;

    public j0(k0 k0Var, p0 p0Var) {
        this.f1710k = k0Var;
        this.f1707h = p0Var;
    }

    public final void c(boolean z10) {
        int i10;
        boolean z11;
        boolean z12;
        if (z10 != this.f1708i) {
            this.f1708i = z10;
            if (z10) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            k0 k0Var = this.f1710k;
            int i11 = k0Var.f1721c;
            k0Var.f1721c = i10 + i11;
            if (!k0Var.f1722d) {
                k0Var.f1722d = true;
                while (true) {
                    try {
                        int i12 = k0Var.f1721c;
                        if (i11 == i12) {
                            break;
                        }
                        if (i11 != 0 || i12 <= 0) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (i11 <= 0 || i12 != 0) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        if (z11) {
                            k0Var.h();
                        } else if (z12) {
                            k0Var.i();
                        }
                        i11 = i12;
                    } finally {
                        k0Var.f1722d = false;
                    }
                }
            }
            if (this.f1708i) {
                k0Var.c(this);
            }
        }
    }

    public void h() {
    }

    public boolean i(d0 d0Var) {
        return false;
    }

    public abstract boolean j();
}
