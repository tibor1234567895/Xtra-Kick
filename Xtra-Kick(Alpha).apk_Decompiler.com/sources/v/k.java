package v;

import java.util.ArrayList;
import java.util.Iterator;
import u.a;
import u.f;

public final class k extends q {
    public k(f fVar) {
        super(fVar);
    }

    public final void a(d dVar) {
        a aVar = (a) this.f15542b;
        int i10 = aVar.f15041t0;
        f fVar = this.f15548h;
        Iterator it = fVar.f15519l.iterator();
        int i11 = 0;
        int i12 = -1;
        while (it.hasNext()) {
            int i13 = ((f) it.next()).f15514g;
            if (i12 == -1 || i13 < i12) {
                i12 = i13;
            }
            if (i11 < i13) {
                i11 = i13;
            }
        }
        if (i10 == 0 || i10 == 2) {
            fVar.d(i12 + aVar.f15043v0);
        } else {
            fVar.d(i11 + aVar.f15043v0);
        }
    }

    public final void d() {
        q qVar;
        f fVar = this.f15542b;
        if (fVar instanceof a) {
            f fVar2 = this.f15548h;
            fVar2.f15509b = true;
            a aVar = (a) fVar;
            int i10 = aVar.f15041t0;
            boolean z10 = aVar.f15042u0;
            ArrayList arrayList = fVar2.f15519l;
            int i11 = 0;
            if (i10 == 0) {
                fVar2.f15512e = 4;
                while (i11 < aVar.f15159s0) {
                    f fVar3 = aVar.f15158r0[i11];
                    if (z10 || fVar3.f15095h0 != 8) {
                        f fVar4 = fVar3.f15086d.f15548h;
                        fVar4.f15518k.add(fVar2);
                        arrayList.add(fVar4);
                    }
                    i11++;
                }
            } else if (i10 != 1) {
                if (i10 == 2) {
                    fVar2.f15512e = 6;
                    while (i11 < aVar.f15159s0) {
                        f fVar5 = aVar.f15158r0[i11];
                        if (z10 || fVar5.f15095h0 != 8) {
                            f fVar6 = fVar5.f15088e.f15548h;
                            fVar6.f15518k.add(fVar2);
                            arrayList.add(fVar6);
                        }
                        i11++;
                    }
                } else if (i10 == 3) {
                    fVar2.f15512e = 7;
                    while (i11 < aVar.f15159s0) {
                        f fVar7 = aVar.f15158r0[i11];
                        if (z10 || fVar7.f15095h0 != 8) {
                            f fVar8 = fVar7.f15088e.f15549i;
                            fVar8.f15518k.add(fVar2);
                            arrayList.add(fVar8);
                        }
                        i11++;
                    }
                } else {
                    return;
                }
                m(this.f15542b.f15088e.f15548h);
                qVar = this.f15542b.f15088e;
                m(qVar.f15549i);
            } else {
                fVar2.f15512e = 5;
                while (i11 < aVar.f15159s0) {
                    f fVar9 = aVar.f15158r0[i11];
                    if (z10 || fVar9.f15095h0 != 8) {
                        f fVar10 = fVar9.f15086d.f15549i;
                        fVar10.f15518k.add(fVar2);
                        arrayList.add(fVar10);
                    }
                    i11++;
                }
            }
            m(this.f15542b.f15086d.f15548h);
            qVar = this.f15542b.f15086d;
            m(qVar.f15549i);
        }
    }

    public final void e() {
        f fVar = this.f15542b;
        if (fVar instanceof a) {
            int i10 = ((a) fVar).f15041t0;
            f fVar2 = this.f15548h;
            if (i10 == 0 || i10 == 1) {
                fVar.Z = fVar2.f15514g;
            } else {
                fVar.f15081a0 = fVar2.f15514g;
            }
        }
    }

    public final void f() {
        this.f15543c = null;
        this.f15548h.c();
    }

    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f15548h;
        fVar2.f15518k.add(fVar);
        fVar.f15519l.add(fVar2);
    }
}
