package v;

import java.util.ArrayList;
import u.e;
import u.f;
import u.j;
import u.l;

public final class i {
    public static p a(f fVar, int i10, ArrayList arrayList, p pVar) {
        int i11;
        boolean z10;
        e eVar;
        int i12;
        if (i10 == 0) {
            i11 = fVar.f15109o0;
        } else {
            i11 = fVar.f15111p0;
        }
        int i13 = 0;
        if (i11 != -1 && (pVar == null || i11 != pVar.f15537b)) {
            int i14 = 0;
            while (true) {
                if (i14 >= arrayList.size()) {
                    break;
                }
                p pVar2 = (p) arrayList.get(i14);
                if (pVar2.f15537b == i11) {
                    if (pVar != null) {
                        pVar.c(i10, pVar2);
                        arrayList.remove(pVar);
                    }
                    pVar = pVar2;
                } else {
                    i14++;
                }
            }
        } else if (i11 != -1) {
            return pVar;
        }
        if (pVar == null) {
            if (fVar instanceof l) {
                l lVar = (l) fVar;
                int i15 = 0;
                while (true) {
                    if (i15 >= lVar.f15159s0) {
                        i12 = -1;
                        break;
                    }
                    f fVar2 = lVar.f15158r0[i15];
                    if ((i10 == 0 && (i12 = fVar2.f15109o0) != -1) || (i10 == 1 && (i12 = fVar2.f15111p0) != -1)) {
                        break;
                    }
                    i15++;
                }
                if (i12 != -1) {
                    int i16 = 0;
                    while (true) {
                        if (i16 >= arrayList.size()) {
                            break;
                        }
                        p pVar3 = (p) arrayList.get(i16);
                        if (pVar3.f15537b == i12) {
                            pVar = pVar3;
                            break;
                        }
                        i16++;
                    }
                }
            }
            if (pVar == null) {
                pVar = new p(i10);
            }
            arrayList.add(pVar);
        }
        ArrayList arrayList2 = pVar.f15536a;
        if (arrayList2.contains(fVar)) {
            z10 = false;
        } else {
            arrayList2.add(fVar);
            z10 = true;
        }
        if (z10) {
            if (fVar instanceof j) {
                j jVar = (j) fVar;
                e eVar2 = jVar.f15155u0;
                if (jVar.f15156v0 == 0) {
                    i13 = 1;
                }
                eVar2.c(i13, pVar, arrayList);
            }
            int i17 = pVar.f15537b;
            if (i10 == 0) {
                fVar.f15109o0 = i17;
                fVar.J.c(i10, pVar, arrayList);
                eVar = fVar.L;
            } else {
                fVar.f15111p0 = i17;
                fVar.K.c(i10, pVar, arrayList);
                fVar.N.c(i10, pVar, arrayList);
                eVar = fVar.M;
            }
            eVar.c(i10, pVar, arrayList);
            fVar.Q.c(i10, pVar, arrayList);
        }
        return pVar;
    }

    public static boolean b(int i10, int i11, int i12, int i13) {
        return (i12 == 1 || i12 == 2 || (i12 == 4 && i10 != 2)) || (i13 == 1 || i13 == 2 || (i13 == 4 && i11 != 2));
    }
}
