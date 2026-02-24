package v;

import java.util.HashSet;
import java.util.Iterator;
import u.d;
import u.e;
import u.f;
import u.g;
import u.j;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final b f15521a = new b();

    public static boolean a(f fVar) {
        g gVar;
        boolean z10;
        boolean z11;
        int[] iArr = fVar.f15113q0;
        int i10 = iArr[0];
        int i11 = iArr[1];
        f fVar2 = fVar.U;
        if (fVar2 != null) {
            gVar = (g) fVar2;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            int i12 = gVar.f15113q0[0];
        }
        if (gVar != null) {
            int i13 = gVar.f15113q0[1];
        }
        if (i10 == 1 || fVar.A() || i10 == 2 || ((i10 == 3 && fVar.f15115s == 0 && fVar.X == 0.0f && fVar.t(0)) || (i10 == 3 && fVar.f15115s == 1 && fVar.u(0, fVar.q())))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 == 1 || fVar.B() || i11 == 2 || ((i11 == 3 && fVar.f15116t == 0 && fVar.X == 0.0f && fVar.t(1)) || (i11 == 3 && fVar.f15116t == 1 && fVar.u(1, fVar.l())))) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (fVar.X > 0.0f && (z10 || z11)) {
            return true;
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    public static void b(int i10, f fVar, o oVar, boolean z10) {
        boolean z11;
        e eVar;
        e eVar2;
        Iterator it;
        boolean z12;
        e eVar3;
        e eVar4;
        f fVar2 = fVar;
        o oVar2 = oVar;
        boolean z13 = z10;
        if (!fVar2.f15106n) {
            if (!(fVar2 instanceof g) && fVar.z() && a(fVar)) {
                g.U(fVar2, oVar2, new b());
            }
            e j10 = fVar2.j(d.LEFT);
            e j11 = fVar2.j(d.RIGHT);
            int d10 = j10.d();
            int d11 = j11.d();
            HashSet hashSet = j10.f15071a;
            if (hashSet != null && j10.f15073c) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    e eVar5 = (e) it2.next();
                    f fVar3 = eVar5.f15074d;
                    int i11 = i10 + 1;
                    boolean a10 = a(fVar3);
                    if (fVar3.z() && a10) {
                        g.U(fVar3, oVar2, new b());
                    }
                    e eVar6 = fVar3.J;
                    e eVar7 = fVar3.L;
                    if ((eVar5 != eVar6 || (eVar4 = eVar7.f15076f) == null || !eVar4.f15073c) && (eVar5 != eVar7 || (eVar3 = eVar6.f15076f) == null || !eVar3.f15073c)) {
                        it = it2;
                        z12 = false;
                    } else {
                        it = it2;
                        z12 = true;
                    }
                    int i12 = fVar3.f15113q0[0];
                    if (i12 != 3 || a10) {
                        if (!fVar3.z()) {
                            if (eVar5 == eVar6 && eVar7.f15076f == null) {
                                int e10 = eVar6.e() + d10;
                                fVar3.I(e10, fVar3.q() + e10);
                            } else if (eVar5 == eVar7 && eVar6.f15076f == null) {
                                int e11 = d10 - eVar7.e();
                                fVar3.I(e11 - fVar3.q(), e11);
                            } else if (z12 && !fVar3.x()) {
                                c(i11, fVar3, oVar2, z13);
                            }
                            b(i11, fVar3, oVar2, z13);
                        }
                    } else if (i12 == 3 && fVar3.f15119w >= 0 && fVar3.f15118v >= 0 && ((fVar3.f15095h0 == 8 || (fVar3.f15115s == 0 && fVar3.X == 0.0f)) && !fVar3.x() && !fVar3.G && z12 && !fVar3.x())) {
                        d(i11, fVar2, oVar2, fVar3, z13);
                    }
                    it2 = it;
                }
            }
            if (!(fVar2 instanceof j)) {
                HashSet hashSet2 = j11.f15071a;
                if (hashSet2 != null && j11.f15073c) {
                    Iterator it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        e eVar8 = (e) it3.next();
                        f fVar4 = eVar8.f15074d;
                        int i13 = i10 + 1;
                        boolean a11 = a(fVar4);
                        if (fVar4.z() && a11) {
                            g.U(fVar4, oVar2, new b());
                        }
                        e eVar9 = fVar4.J;
                        e eVar10 = fVar4.L;
                        if ((eVar8 != eVar9 || (eVar2 = eVar10.f15076f) == null || !eVar2.f15073c) && (eVar8 != eVar10 || (eVar = eVar9.f15076f) == null || !eVar.f15073c)) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        int i14 = fVar4.f15113q0[0];
                        if (i14 != 3 || a11) {
                            if (!fVar4.z()) {
                                if (eVar8 == eVar9 && eVar10.f15076f == null) {
                                    int e12 = eVar9.e() + d11;
                                    fVar4.I(e12, fVar4.q() + e12);
                                } else if (eVar8 == eVar10 && eVar9.f15076f == null) {
                                    int e13 = d11 - eVar10.e();
                                    fVar4.I(e13 - fVar4.q(), e13);
                                } else if (z11 && !fVar4.x()) {
                                    c(i13, fVar4, oVar2, z13);
                                }
                                b(i13, fVar4, oVar2, z13);
                            }
                        } else if (i14 == 3 && fVar4.f15119w >= 0 && fVar4.f15118v >= 0) {
                            if (fVar4.f15095h0 != 8) {
                                if (fVar4.f15115s == 0) {
                                    if (fVar4.X != 0.0f) {
                                    }
                                }
                            }
                            if (!fVar4.x() && !fVar4.G && z11 && !fVar4.x()) {
                                d(i13, fVar2, oVar2, fVar4, z13);
                            }
                        }
                    }
                }
                fVar2.f15106n = true;
            }
        }
    }

    public static void c(int i10, f fVar, o oVar, boolean z10) {
        float f10;
        float f11 = fVar.f15089e0;
        e eVar = fVar.J;
        int d10 = eVar.f15076f.d();
        e eVar2 = fVar.L;
        int d11 = eVar2.f15076f.d();
        int e10 = eVar.e() + d10;
        int e11 = d11 - eVar2.e();
        if (d10 == d11) {
            f11 = 0.5f;
        } else {
            d10 = e10;
            d11 = e11;
        }
        int q10 = fVar.q();
        int i11 = (d11 - d10) - q10;
        if (d10 > d11) {
            i11 = (d10 - d11) - q10;
        }
        if (i11 > 0) {
            f10 = (f11 * ((float) i11)) + 0.5f;
        } else {
            f10 = f11 * ((float) i11);
        }
        int i12 = ((int) f10) + d10;
        int i13 = i12 + q10;
        if (d10 > d11) {
            i13 = i12 - q10;
        }
        fVar.I(i12, i13);
        b(i10 + 1, fVar, oVar, z10);
    }

    public static void d(int i10, f fVar, o oVar, f fVar2, boolean z10) {
        float f10 = fVar2.f15089e0;
        e eVar = fVar2.J;
        int e10 = eVar.e() + eVar.f15076f.d();
        e eVar2 = fVar2.L;
        int d10 = eVar2.f15076f.d() - eVar2.e();
        if (d10 >= e10) {
            int q10 = fVar2.q();
            if (fVar2.f15095h0 != 8) {
                int i11 = fVar2.f15115s;
                if (i11 == 2) {
                    if (!(fVar instanceof g)) {
                        fVar = fVar.U;
                    }
                    q10 = (int) (fVar2.f15089e0 * 0.5f * ((float) fVar.q()));
                } else if (i11 == 0) {
                    q10 = d10 - e10;
                }
                q10 = Math.max(fVar2.f15118v, q10);
                int i12 = fVar2.f15119w;
                if (i12 > 0) {
                    q10 = Math.min(i12, q10);
                }
            }
            int i13 = e10 + ((int) ((f10 * ((float) ((d10 - e10) - q10))) + 0.5f));
            fVar2.I(i13, q10 + i13);
            b(i10 + 1, fVar2, oVar, z10);
        }
    }

    public static void e(int i10, f fVar, o oVar) {
        float f10;
        float f11 = fVar.f15091f0;
        e eVar = fVar.K;
        int d10 = eVar.f15076f.d();
        e eVar2 = fVar.M;
        int d11 = eVar2.f15076f.d();
        int e10 = eVar.e() + d10;
        int e11 = d11 - eVar2.e();
        if (d10 == d11) {
            f11 = 0.5f;
        } else {
            d10 = e10;
            d11 = e11;
        }
        int l10 = fVar.l();
        int i11 = (d11 - d10) - l10;
        if (d10 > d11) {
            i11 = (d10 - d11) - l10;
        }
        if (i11 > 0) {
            f10 = (f11 * ((float) i11)) + 0.5f;
        } else {
            f10 = f11 * ((float) i11);
        }
        int i12 = (int) f10;
        int i13 = d10 + i12;
        int i14 = i13 + l10;
        if (d10 > d11) {
            i13 = d10 - i12;
            i14 = i13 - l10;
        }
        fVar.J(i13, i14);
        g(i10 + 1, fVar, oVar);
    }

    public static void f(int i10, f fVar, o oVar, f fVar2) {
        float f10 = fVar2.f15091f0;
        e eVar = fVar2.K;
        int e10 = eVar.e() + eVar.f15076f.d();
        e eVar2 = fVar2.M;
        int d10 = eVar2.f15076f.d() - eVar2.e();
        if (d10 >= e10) {
            int l10 = fVar2.l();
            if (fVar2.f15095h0 != 8) {
                int i11 = fVar2.f15116t;
                if (i11 == 2) {
                    if (!(fVar instanceof g)) {
                        fVar = fVar.U;
                    }
                    l10 = (int) (f10 * 0.5f * ((float) fVar.l()));
                } else if (i11 == 0) {
                    l10 = d10 - e10;
                }
                l10 = Math.max(fVar2.f15121y, l10);
                int i12 = fVar2.f15122z;
                if (i12 > 0) {
                    l10 = Math.min(i12, l10);
                }
            }
            int i13 = e10 + ((int) ((f10 * ((float) ((d10 - e10) - l10))) + 0.5f));
            fVar2.J(i13, l10 + i13);
            g(i10 + 1, fVar2, oVar);
        }
    }

    public static void g(int i10, f fVar, o oVar) {
        e eVar;
        boolean z10;
        e eVar2;
        e eVar3;
        boolean z11;
        e eVar4;
        e eVar5;
        f fVar2 = fVar;
        o oVar2 = oVar;
        if (!fVar2.f15108o) {
            if (!(fVar2 instanceof g) && fVar.z() && a(fVar)) {
                g.U(fVar2, oVar2, new b());
            }
            e j10 = fVar2.j(d.TOP);
            e j11 = fVar2.j(d.BOTTOM);
            int d10 = j10.d();
            int d11 = j11.d();
            HashSet hashSet = j10.f15071a;
            if (hashSet != null && j10.f15073c) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    e eVar6 = (e) it.next();
                    f fVar3 = eVar6.f15074d;
                    int i11 = i10 + 1;
                    boolean a10 = a(fVar3);
                    if (fVar3.z() && a10) {
                        g.U(fVar3, oVar2, new b());
                    }
                    e eVar7 = fVar3.K;
                    e eVar8 = fVar3.M;
                    if ((eVar6 != eVar7 || (eVar5 = eVar8.f15076f) == null || !eVar5.f15073c) && (eVar6 != eVar8 || (eVar4 = eVar7.f15076f) == null || !eVar4.f15073c)) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    int i12 = fVar3.f15113q0[1];
                    if (i12 != 3 || a10) {
                        if (!fVar3.z()) {
                            if (eVar6 == eVar7 && eVar8.f15076f == null) {
                                int e10 = eVar7.e() + d10;
                                fVar3.J(e10, fVar3.l() + e10);
                            } else if (eVar6 == eVar8 && eVar7.f15076f == null) {
                                int e11 = d10 - eVar8.e();
                                fVar3.J(e11 - fVar3.l(), e11);
                            } else if (z11 && !fVar3.y()) {
                                e(i11, fVar3, oVar2);
                            }
                            g(i11, fVar3, oVar2);
                        }
                    } else if (i12 == 3 && fVar3.f15122z >= 0 && fVar3.f15121y >= 0) {
                        if ((fVar3.f15095h0 == 8 || (fVar3.f15116t == 0 && fVar3.X == 0.0f)) && !fVar3.y() && !fVar3.G && z11 && !fVar3.y()) {
                            f(i11, fVar2, oVar2, fVar3);
                        }
                    }
                }
            }
            if (!(fVar2 instanceof j)) {
                HashSet hashSet2 = j11.f15071a;
                if (hashSet2 != null && j11.f15073c) {
                    Iterator it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        e eVar9 = (e) it2.next();
                        f fVar4 = eVar9.f15074d;
                        int i13 = i10 + 1;
                        boolean a11 = a(fVar4);
                        if (fVar4.z() && a11) {
                            g.U(fVar4, oVar2, new b());
                        }
                        e eVar10 = fVar4.K;
                        e eVar11 = fVar4.M;
                        if ((eVar9 != eVar10 || (eVar3 = eVar11.f15076f) == null || !eVar3.f15073c) && (eVar9 != eVar11 || (eVar2 = eVar10.f15076f) == null || !eVar2.f15073c)) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        int i14 = fVar4.f15113q0[1];
                        if (i14 != 3 || a11) {
                            if (!fVar4.z()) {
                                if (eVar9 == eVar10 && eVar11.f15076f == null) {
                                    int e12 = eVar10.e() + d11;
                                    fVar4.J(e12, fVar4.l() + e12);
                                } else if (eVar9 == eVar11 && eVar10.f15076f == null) {
                                    int e13 = d11 - eVar11.e();
                                    fVar4.J(e13 - fVar4.l(), e13);
                                } else if (z10 && !fVar4.y()) {
                                    e(i13, fVar4, oVar2);
                                }
                                g(i13, fVar4, oVar2);
                            }
                        } else if (i14 == 3 && fVar4.f15122z >= 0 && fVar4.f15121y >= 0) {
                            if (fVar4.f15095h0 != 8) {
                                if (fVar4.f15116t == 0) {
                                    if (fVar4.X != 0.0f) {
                                    }
                                }
                            }
                            if (!fVar4.y() && !fVar4.G && z10 && !fVar4.y()) {
                                f(i13, fVar2, oVar2, fVar4);
                            }
                        }
                    }
                }
                e j12 = fVar2.j(d.BASELINE);
                if (j12.f15071a != null && j12.f15073c) {
                    int d12 = j12.d();
                    Iterator it3 = j12.f15071a.iterator();
                    while (it3.hasNext()) {
                        e eVar12 = (e) it3.next();
                        f fVar5 = eVar12.f15074d;
                        int i15 = i10 + 1;
                        boolean a12 = a(fVar5);
                        if (fVar5.z() && a12) {
                            g.U(fVar5, oVar2, new b());
                        }
                        if ((fVar5.f15113q0[1] != 3 || a12) && !fVar5.z() && eVar12 == (eVar = fVar5.N)) {
                            int e14 = eVar12.e() + d12;
                            if (fVar5.F) {
                                int i16 = e14 - fVar5.f15083b0;
                                int i17 = fVar5.W + i16;
                                fVar5.f15081a0 = i16;
                                fVar5.K.l(i16);
                                fVar5.M.l(i17);
                                eVar.l(e14);
                                fVar5.f15104m = true;
                            }
                            g(i15, fVar5, oVar2);
                        }
                    }
                }
                fVar2.f15108o = true;
            }
        }
    }
}
