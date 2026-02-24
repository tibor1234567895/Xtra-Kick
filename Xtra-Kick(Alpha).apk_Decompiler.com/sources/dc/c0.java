package dc;

import java.util.ArrayList;

public final class c0 {
    private c0() {
    }

    public /* synthetic */ c0(int i10) {
        this();
    }

    public static void a(long j10, j jVar, int i10, ArrayList arrayList, int i11, int i12, ArrayList arrayList2) {
        boolean z10;
        int i13;
        int i14;
        j jVar2;
        boolean z11;
        int i15;
        long j11;
        int i16;
        j jVar3;
        boolean z12;
        j jVar4 = jVar;
        int i17 = i10;
        ArrayList arrayList3 = arrayList;
        int i18 = i11;
        int i19 = i12;
        ArrayList arrayList4 = arrayList2;
        if (i18 < i19) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i20 = i18;
            while (i20 < i19) {
                if (((n) arrayList3.get(i20)).d() >= i17) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    i20++;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            n nVar = (n) arrayList.get(i11);
            n nVar2 = (n) arrayList3.get(i19 - 1);
            if (i17 == nVar.d()) {
                int intValue = ((Number) arrayList4.get(i18)).intValue();
                int i21 = i18 + 1;
                n nVar3 = (n) arrayList3.get(i21);
                i13 = i21;
                i14 = intValue;
                nVar = nVar3;
            } else {
                i13 = i18;
                i14 = -1;
            }
            if (nVar.i(i17) != nVar2.i(i17)) {
                int i22 = 1;
                for (int i23 = i13 + 1; i23 < i19; i23++) {
                    if (((n) arrayList3.get(i23 - 1)).i(i17) != ((n) arrayList3.get(i23)).i(i17)) {
                        i22++;
                    }
                }
                long j12 = (long) 4;
                long j13 = ((long) (i22 * 2)) + (jVar4.f4787i / j12) + j10 + ((long) 2);
                jVar4.T0(i22);
                jVar4.T0(i14);
                for (int i24 = i13; i24 < i19; i24++) {
                    byte i25 = ((n) arrayList3.get(i24)).i(i17);
                    if (i24 == i13 || i25 != ((n) arrayList3.get(i24 - 1)).i(i17)) {
                        jVar4.T0(i25 & 255);
                    }
                }
                j jVar5 = new j();
                while (i13 < i19) {
                    byte i26 = ((n) arrayList3.get(i13)).i(i17);
                    int i27 = i13 + 1;
                    int i28 = i27;
                    while (true) {
                        if (i28 >= i19) {
                            i15 = i19;
                            break;
                        } else if (i26 != ((n) arrayList3.get(i28)).i(i17)) {
                            i15 = i28;
                            break;
                        } else {
                            i28++;
                        }
                    }
                    if (i27 == i15 && i17 + 1 == ((n) arrayList3.get(i13)).d()) {
                        jVar4.T0(((Number) arrayList4.get(i13)).intValue());
                        i16 = i15;
                        jVar3 = jVar5;
                        j11 = j12;
                    } else {
                        jVar4.T0(((int) ((jVar5.f4787i / j12) + j13)) * -1);
                        i16 = i15;
                        jVar3 = jVar5;
                        j11 = j12;
                        a(j13, jVar5, i17 + 1, arrayList, i13, i16, arrayList2);
                    }
                    jVar5 = jVar3;
                    i13 = i16;
                    j12 = j11;
                }
                jVar2 = jVar5;
            } else {
                int min = Math.min(nVar.d(), nVar2.d());
                int i29 = i17;
                int i30 = 0;
                while (i29 < min && nVar.i(i29) == nVar2.i(i29)) {
                    i30++;
                    i29++;
                }
                long j14 = (long) 4;
                long j15 = (jVar4.f4787i / j14) + j10 + ((long) 2) + ((long) i30) + 1;
                jVar4.T0(-i30);
                jVar4.T0(i14);
                int i31 = i17 + i30;
                while (i17 < i31) {
                    jVar4.T0(nVar.i(i17) & 255);
                    i17++;
                }
                if (i13 + 1 == i19) {
                    if (i31 == ((n) arrayList3.get(i13)).d()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        jVar4.T0(((Number) arrayList4.get(i13)).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                jVar2 = new j();
                jVar4.T0(((int) ((jVar2.f4787i / j14) + j15)) * -1);
                a(j15, jVar2, i31, arrayList, i13, i12, arrayList2);
            }
            jVar4.F0(jVar2);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
