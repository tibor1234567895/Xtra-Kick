package v2;

import d2.w;
import j1.b0;
import java.io.EOFException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final g f15859a = new g();

    /* renamed from: b  reason: collision with root package name */
    public final b0 f15860b = new b0(0, new byte[65025]);

    /* renamed from: c  reason: collision with root package name */
    public int f15861c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f15862d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15863e;

    public final boolean a(w wVar) {
        boolean z10;
        int i10;
        int i11;
        boolean z11;
        int i12;
        boolean z12 = this.f15863e;
        b0 b0Var = this.f15860b;
        if (z12) {
            this.f15863e = false;
            b0Var.D(0);
        }
        while (true) {
            boolean z13 = true;
            if (this.f15863e) {
                return true;
            }
            int i13 = this.f15861c;
            g gVar = this.f15859a;
            if (i13 < 0) {
                if (!gVar.b(wVar, -1) || !gVar.a(wVar, true)) {
                    return false;
                }
                int i14 = gVar.f15867d;
                if ((gVar.f15864a & 1) == 1 && b0Var.f8416c == 0) {
                    this.f15862d = 0;
                    int i15 = 0;
                    do {
                        int i16 = this.f15862d;
                        int i17 = 0 + i16;
                        if (i17 >= gVar.f15866c) {
                            break;
                        }
                        this.f15862d = i16 + 1;
                        i12 = gVar.f15869f[i17];
                        i15 += i12;
                    } while (i12 == 255);
                    i14 += i15;
                    i11 = this.f15862d + 0;
                } else {
                    i11 = 0;
                }
                try {
                    wVar.g(i14);
                    z11 = true;
                } catch (EOFException unused) {
                    z11 = false;
                }
                if (!z11) {
                    return false;
                }
                this.f15861c = i11;
            }
            int i18 = this.f15861c;
            this.f15862d = 0;
            int i19 = 0;
            do {
                int i20 = this.f15862d;
                int i21 = i18 + i20;
                if (i21 >= gVar.f15866c) {
                    break;
                }
                this.f15862d = i20 + 1;
                i10 = gVar.f15869f[i21];
                i19 += i10;
            } while (i10 == 255);
            int i22 = this.f15861c + this.f15862d;
            if (i19 > 0) {
                b0Var.a(b0Var.f8416c + i19);
                try {
                    wVar.readFully(b0Var.f8414a, b0Var.f8416c, i19);
                    z10 = true;
                } catch (EOFException unused2) {
                    z10 = false;
                }
                if (!z10) {
                    return false;
                }
                b0Var.F(b0Var.f8416c + i19);
                if (gVar.f15869f[i22 - 1] == 255) {
                    z13 = false;
                }
                this.f15863e = z13;
            }
            if (i22 == gVar.f15866c) {
                i22 = -1;
            }
            this.f15861c = i22;
        }
        return false;
    }
}
