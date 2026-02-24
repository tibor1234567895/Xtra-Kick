package u;

import s.e;
import s.j;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean[] f15160a = new boolean[3];

    public static void a(g gVar, e eVar, f fVar) {
        fVar.f15110p = -1;
        fVar.f15112q = -1;
        int i10 = gVar.f15113q0[0];
        int[] iArr = fVar.f15113q0;
        if (i10 != 2 && iArr[0] == 4) {
            e eVar2 = fVar.J;
            int i11 = eVar2.f15077g;
            int q10 = gVar.q();
            e eVar3 = fVar.L;
            int i12 = q10 - eVar3.f15077g;
            eVar2.f15079i = eVar.l(eVar2);
            eVar3.f15079i = eVar.l(eVar3);
            eVar.d(eVar2.f15079i, i11);
            eVar.d(eVar3.f15079i, i12);
            fVar.f15110p = 2;
            fVar.Z = i11;
            int i13 = i12 - i11;
            fVar.V = i13;
            int i14 = fVar.f15085c0;
            if (i13 < i14) {
                fVar.V = i14;
            }
        }
        if (gVar.f15113q0[1] != 2 && iArr[1] == 4) {
            e eVar4 = fVar.K;
            int i15 = eVar4.f15077g;
            int l10 = gVar.l();
            e eVar5 = fVar.M;
            int i16 = l10 - eVar5.f15077g;
            eVar4.f15079i = eVar.l(eVar4);
            eVar5.f15079i = eVar.l(eVar5);
            eVar.d(eVar4.f15079i, i15);
            eVar.d(eVar5.f15079i, i16);
            if (fVar.f15083b0 > 0 || fVar.f15095h0 == 8) {
                e eVar6 = fVar.N;
                j l11 = eVar.l(eVar6);
                eVar6.f15079i = l11;
                eVar.d(l11, fVar.f15083b0 + i15);
            }
            fVar.f15112q = 2;
            fVar.f15081a0 = i15;
            int i17 = i16 - i15;
            fVar.W = i17;
            int i18 = fVar.f15087d0;
            if (i17 < i18) {
                fVar.W = i18;
            }
        }
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
