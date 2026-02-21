package n3;

import androidx.recyclerview.widget.x0;

public final class m1 implements x0 {

    /* renamed from: a  reason: collision with root package name */
    public final j1 f11327a;

    /* renamed from: b  reason: collision with root package name */
    public final x0 f11328b;

    /* renamed from: c  reason: collision with root package name */
    public int f11329c;

    /* renamed from: d  reason: collision with root package name */
    public int f11330d;

    /* renamed from: e  reason: collision with root package name */
    public int f11331e;

    /* renamed from: f  reason: collision with root package name */
    public int f11332f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f11333g = 1;

    static {
        new l1(0);
    }

    public m1(j1 j1Var, j1 j1Var2, x0 x0Var) {
        this.f11327a = j1Var2;
        this.f11328b = x0Var;
        n3 n3Var = (n3) j1Var;
        this.f11329c = n3Var.f11357c;
        this.f11330d = n3Var.f11358d;
        this.f11331e = n3Var.f11356b;
    }

    public final void a(int i10, int i11) {
        boolean z10;
        int i12 = i10 + i11;
        int i13 = this.f11331e;
        boolean z11 = true;
        c0 c0Var = c0.ITEM_TO_PLACEHOLDER;
        j1 j1Var = this.f11327a;
        x0 x0Var = this.f11328b;
        if (i12 >= i13 && this.f11333g != 3) {
            int min = Math.min(((n3) j1Var).f11358d - this.f11330d, i11);
            if (min < 0) {
                min = 0;
            }
            int i14 = i11 - min;
            if (min > 0) {
                this.f11333g = 2;
                x0Var.d(this.f11329c + i10, min, c0Var);
                this.f11330d += min;
            }
            if (i14 > 0) {
                x0Var.a(min + i10 + this.f11329c, i14);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (i10 <= 0 && this.f11332f != 3) {
                int min2 = Math.min(((n3) j1Var).f11357c - this.f11329c, i11);
                if (min2 < 0) {
                    min2 = 0;
                }
                int i15 = i11 - min2;
                if (i15 > 0) {
                    x0Var.a(this.f11329c + 0, i15);
                }
                if (min2 > 0) {
                    this.f11332f = 2;
                    x0Var.d(this.f11329c + 0, min2, c0Var);
                    this.f11329c += min2;
                }
            } else {
                z11 = false;
            }
            if (!z11) {
                x0Var.a(i10 + this.f11329c, i11);
            }
        }
        this.f11331e -= i11;
    }

    public final void b(int i10, int i11) {
        int i12 = this.f11329c;
        this.f11328b.b(i10 + i12, i11 + i12);
    }

    public final void c(int i10, int i11) {
        boolean z10;
        int i12 = this.f11331e;
        boolean z11 = true;
        c0 c0Var = c0.PLACEHOLDER_TO_ITEM;
        x0 x0Var = this.f11328b;
        if (i10 >= i12 && this.f11333g != 2) {
            int min = Math.min(i11, this.f11330d);
            if (min > 0) {
                this.f11333g = 3;
                x0Var.d(this.f11329c + i10, min, c0Var);
                this.f11330d -= min;
            }
            int i13 = i11 - min;
            if (i13 > 0) {
                x0Var.c(min + i10 + this.f11329c, i13);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (i10 <= 0 && this.f11332f != 2) {
                int min2 = Math.min(i11, this.f11329c);
                if (min2 > 0) {
                    this.f11332f = 3;
                    x0Var.d((0 - min2) + this.f11329c, min2, c0Var);
                    this.f11329c -= min2;
                }
                int i14 = i11 - min2;
                if (i14 > 0) {
                    x0Var.c(this.f11329c + 0, i14);
                }
            } else {
                z11 = false;
            }
            if (!z11) {
                x0Var.c(i10 + this.f11329c, i11);
            }
        }
        this.f11331e += i11;
    }

    public final void d(int i10, int i11, Object obj) {
        this.f11328b.d(i10 + this.f11329c, i11, obj);
    }
}
