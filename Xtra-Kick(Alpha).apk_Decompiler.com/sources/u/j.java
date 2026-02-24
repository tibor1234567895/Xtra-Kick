package u;

import java.util.ArrayList;
import s.c;
import s.e;

public final class j extends f {

    /* renamed from: r0  reason: collision with root package name */
    public float f15152r0 = -1.0f;

    /* renamed from: s0  reason: collision with root package name */
    public int f15153s0 = -1;

    /* renamed from: t0  reason: collision with root package name */
    public int f15154t0 = -1;

    /* renamed from: u0  reason: collision with root package name */
    public e f15155u0 = this.K;

    /* renamed from: v0  reason: collision with root package name */
    public int f15156v0;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f15157w0;

    public j() {
        this.f15156v0 = 0;
        this.S.clear();
        this.S.add(this.f15155u0);
        int length = this.R.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.R[i10] = this.f15155u0;
        }
    }

    public final boolean A() {
        return this.f15157w0;
    }

    public final boolean B() {
        return this.f15157w0;
    }

    public final void P(e eVar, boolean z10) {
        if (this.U != null) {
            e eVar2 = this.f15155u0;
            eVar.getClass();
            int o10 = e.o(eVar2);
            if (this.f15156v0 == 1) {
                this.Z = o10;
                this.f15081a0 = 0;
                K(this.U.l());
                N(0);
                return;
            }
            this.Z = 0;
            this.f15081a0 = o10;
            N(this.U.q());
            K(0);
        }
    }

    public final void Q(int i10) {
        if (this.f15156v0 != i10) {
            this.f15156v0 = i10;
            ArrayList arrayList = this.S;
            arrayList.clear();
            this.f15155u0 = this.f15156v0 == 1 ? this.J : this.K;
            arrayList.add(this.f15155u0);
            e[] eVarArr = this.R;
            int length = eVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                eVarArr[i11] = this.f15155u0;
            }
        }
    }

    public final void c(e eVar, boolean z10) {
        boolean z11;
        g gVar = (g) this.U;
        if (gVar != null) {
            e j10 = gVar.j(d.LEFT);
            e j11 = gVar.j(d.RIGHT);
            f fVar = this.U;
            boolean z12 = true;
            if (fVar == null || fVar.f15113q0[0] != 2) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (this.f15156v0 == 0) {
                j10 = gVar.j(d.TOP);
                j11 = gVar.j(d.BOTTOM);
                f fVar2 = this.U;
                if (fVar2 == null || fVar2.f15113q0[1] != 2) {
                    z12 = false;
                }
                z11 = z12;
            }
            if (this.f15157w0) {
                e eVar2 = this.f15155u0;
                if (eVar2.f15073c) {
                    s.j l10 = eVar.l(eVar2);
                    eVar.d(l10, this.f15155u0.d());
                    if (this.f15153s0 != -1) {
                        if (z11) {
                            eVar.f(eVar.l(j11), l10, 0, 5);
                        }
                    } else if (this.f15154t0 != -1 && z11) {
                        s.j l11 = eVar.l(j11);
                        eVar.f(l10, eVar.l(j10), 0, 5);
                        eVar.f(l11, l10, 0, 5);
                    }
                    this.f15157w0 = false;
                    return;
                }
            }
            if (this.f15153s0 != -1) {
                s.j l12 = eVar.l(this.f15155u0);
                eVar.e(l12, eVar.l(j10), this.f15153s0, 8);
                if (z11) {
                    eVar.f(eVar.l(j11), l12, 0, 5);
                }
            } else if (this.f15154t0 != -1) {
                s.j l13 = eVar.l(this.f15155u0);
                s.j l14 = eVar.l(j11);
                eVar.e(l13, l14, -this.f15154t0, 8);
                if (z11) {
                    eVar.f(l13, eVar.l(j10), 0, 5);
                    eVar.f(l14, l13, 0, 5);
                }
            } else if (this.f15152r0 != -1.0f) {
                s.j l15 = eVar.l(this.f15155u0);
                s.j l16 = eVar.l(j11);
                float f10 = this.f15152r0;
                c m10 = eVar.m();
                m10.f13927d.b(l15, -1.0f);
                m10.f13927d.b(l16, f10);
                eVar.c(m10);
            }
        }
    }

    public final boolean d() {
        return true;
    }

    public final e j(d dVar) {
        int ordinal = dVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                }
            }
            if (this.f15156v0 == 0) {
                return this.f15155u0;
            }
            return null;
        }
        if (this.f15156v0 == 1) {
            return this.f15155u0;
        }
        return null;
    }
}
