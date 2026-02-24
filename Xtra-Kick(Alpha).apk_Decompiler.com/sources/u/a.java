package u;

import android.support.v4.media.h;
import q0.f;
import s.c;
import s.e;
import s.j;

public final class a extends l {

    /* renamed from: t0  reason: collision with root package name */
    public int f15041t0 = 0;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f15042u0 = true;

    /* renamed from: v0  reason: collision with root package name */
    public int f15043v0 = 0;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f15044w0 = false;

    public final boolean A() {
        return this.f15044w0;
    }

    public final boolean B() {
        return this.f15044w0;
    }

    public final boolean R() {
        int i10;
        e j10;
        e j11;
        e j12;
        int i11;
        int i12;
        int i13 = 0;
        boolean z10 = true;
        while (true) {
            i10 = this.f15159s0;
            if (i13 >= i10) {
                break;
            }
            f fVar = this.f15158r0[i13];
            if ((this.f15042u0 || fVar.d()) && ((((i11 = this.f15041t0) == 0 || i11 == 1) && !fVar.A()) || (((i12 = this.f15041t0) == 2 || i12 == 3) && !fVar.B()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int i14 = 0;
        boolean z11 = false;
        for (int i15 = 0; i15 < this.f15159s0; i15++) {
            f fVar2 = this.f15158r0[i15];
            if (this.f15042u0 || fVar2.d()) {
                d dVar = d.BOTTOM;
                d dVar2 = d.TOP;
                d dVar3 = d.RIGHT;
                d dVar4 = d.LEFT;
                if (!z11) {
                    int i16 = this.f15041t0;
                    if (i16 == 0) {
                        j12 = fVar2.j(dVar4);
                    } else if (i16 == 1) {
                        j12 = fVar2.j(dVar3);
                    } else if (i16 == 2) {
                        j12 = fVar2.j(dVar2);
                    } else {
                        if (i16 == 3) {
                            j12 = fVar2.j(dVar);
                        }
                        z11 = true;
                    }
                    i14 = j12.d();
                    z11 = true;
                }
                int i17 = this.f15041t0;
                if (i17 == 0) {
                    j11 = fVar2.j(dVar4);
                } else {
                    if (i17 == 1) {
                        j10 = fVar2.j(dVar3);
                    } else if (i17 == 2) {
                        j11 = fVar2.j(dVar2);
                    } else if (i17 == 3) {
                        j10 = fVar2.j(dVar);
                    }
                    i14 = Math.max(i14, j10.d());
                }
                i14 = Math.min(i14, j11.d());
            }
        }
        int i18 = i14 + this.f15043v0;
        int i19 = this.f15041t0;
        if (i19 == 0 || i19 == 1) {
            I(i18, i18);
        } else {
            J(i18, i18);
        }
        this.f15044w0 = true;
        return true;
    }

    public final int S() {
        int i10 = this.f15041t0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    public final void c(e eVar, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        e eVar2;
        j jVar;
        int i11;
        int i12;
        int i13;
        int i14;
        j jVar2;
        e eVar3 = eVar;
        e[] eVarArr = this.R;
        e eVar4 = this.J;
        eVarArr[0] = eVar4;
        int i15 = 2;
        e eVar5 = this.K;
        eVarArr[2] = eVar5;
        e eVar6 = this.L;
        eVarArr[1] = eVar6;
        e eVar7 = this.M;
        eVarArr[3] = eVar7;
        for (e eVar8 : eVarArr) {
            eVar8.f15079i = eVar3.l(eVar8);
        }
        int i16 = this.f15041t0;
        if (i16 >= 0 && i16 < 4) {
            e eVar9 = eVarArr[i16];
            if (!this.f15044w0) {
                R();
            }
            if (this.f15044w0) {
                this.f15044w0 = false;
                int i17 = this.f15041t0;
                if (i17 == 0 || i17 == 1) {
                    eVar3.d(eVar4.f15079i, this.Z);
                    jVar2 = eVar6.f15079i;
                    i14 = this.Z;
                } else if (i17 == 2 || i17 == 3) {
                    eVar3.d(eVar5.f15079i, this.f15081a0);
                    jVar2 = eVar7.f15079i;
                    i14 = this.f15081a0;
                } else {
                    return;
                }
                eVar3.d(jVar2, i14);
                return;
            }
            int i18 = 0;
            while (true) {
                if (i18 >= this.f15159s0) {
                    z11 = false;
                    break;
                }
                f fVar = this.f15158r0[i18];
                if ((this.f15042u0 || fVar.d()) && ((((i13 = this.f15041t0) == 0 || i13 == 1) && fVar.f15113q0[0] == 3 && fVar.J.f15076f != null && fVar.L.f15076f != null) || ((i13 == 2 || i13 == 3) && fVar.f15113q0[1] == 3 && fVar.K.f15076f != null && fVar.M.f15076f != null))) {
                    z11 = true;
                } else {
                    i18++;
                }
            }
            if (eVar4.g() || eVar6.g()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (eVar5.g() || eVar7.g()) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z11 || (((i12 = this.f15041t0) != 0 || !z12) && ((i12 != 2 || !z13) && ((i12 != 1 || !z12) && (i12 != 3 || !z13))))) {
                z14 = false;
            } else {
                z14 = true;
            }
            if (!z14) {
                i10 = 4;
            } else {
                i10 = 5;
            }
            int i19 = 0;
            while (i19 < this.f15159s0) {
                f fVar2 = this.f15158r0[i19];
                if (this.f15042u0 || fVar2.d()) {
                    j l10 = eVar3.l(fVar2.R[this.f15041t0]);
                    int i20 = this.f15041t0;
                    e eVar10 = fVar2.R[i20];
                    eVar10.f15079i = l10;
                    e eVar11 = eVar10.f15076f;
                    if (eVar11 == null || eVar11.f15074d != this) {
                        i11 = 0;
                    } else {
                        i11 = eVar10.f15077g + 0;
                    }
                    if (i20 == 0 || i20 == i15) {
                        c m10 = eVar.m();
                        j n10 = eVar.n();
                        n10.f13962k = 0;
                        m10.c(eVar9.f15079i, l10, n10, this.f15043v0 - i11);
                        eVar3.c(m10);
                    } else {
                        c m11 = eVar.m();
                        j n11 = eVar.n();
                        n11.f13962k = 0;
                        m11.b(eVar9.f15079i, l10, n11, this.f15043v0 + i11);
                        eVar3.c(m11);
                    }
                    eVar3.e(eVar9.f15079i, l10, this.f15043v0 + i11, i10);
                }
                i19++;
                i15 = 2;
            }
            int i21 = this.f15041t0;
            if (i21 == 0) {
                eVar3.e(eVar6.f15079i, eVar4.f15079i, 0, 8);
                eVar3.e(eVar4.f15079i, this.U.L.f15079i, 0, 4);
                jVar = eVar4.f15079i;
                eVar2 = this.U.J;
            } else if (i21 == 1) {
                eVar3.e(eVar4.f15079i, eVar6.f15079i, 0, 8);
                eVar3.e(eVar4.f15079i, this.U.J.f15079i, 0, 4);
                jVar = eVar4.f15079i;
                eVar2 = this.U.L;
            } else if (i21 == 2) {
                eVar3.e(eVar7.f15079i, eVar5.f15079i, 0, 8);
                eVar3.e(eVar5.f15079i, this.U.M.f15079i, 0, 4);
                jVar = eVar5.f15079i;
                eVar2 = this.U.K;
            } else if (i21 == 3) {
                eVar3.e(eVar5.f15079i, eVar7.f15079i, 0, 8);
                eVar3.e(eVar5.f15079i, this.U.K.f15079i, 0, 4);
                jVar = eVar5.f15079i;
                eVar2 = this.U.M;
            } else {
                return;
            }
            eVar3.e(jVar, eVar2.f15079i, 0, 0);
        }
    }

    public final boolean d() {
        return true;
    }

    public final String toString() {
        String p10 = h.p(new StringBuilder("[Barrier] "), this.f15097i0, " {");
        for (int i10 = 0; i10 < this.f15159s0; i10++) {
            f fVar = this.f15158r0[i10];
            if (i10 > 0) {
                p10 = f.g(p10, ", ");
            }
            StringBuilder q10 = h.q(p10);
            q10.append(fVar.f15097i0);
            p10 = q10.toString();
        }
        return f.g(p10, "}");
    }
}
