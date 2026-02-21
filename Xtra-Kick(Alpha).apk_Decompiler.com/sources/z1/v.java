package z1;

import android.util.Pair;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.a2;
import g1.u1;
import g1.v1;
import g1.z1;
import j1.l0;
import java.util.Arrays;
import java.util.List;
import m1.f;
import m1.o1;
import v1.a0;
import v1.l1;

public abstract class v extends x {
    public final void b(Object obj) {
        u uVar = (u) obj;
    }

    public final y d(f[] fVarArr, l1 l1Var, a0 a0Var, u1 u1Var) {
        int[][][] iArr;
        l1[] l1VarArr;
        boolean z10;
        r1 r1Var;
        g1.a0[] a0VarArr;
        int i10;
        int[] iArr2;
        int i11;
        f[] fVarArr2 = fVarArr;
        l1 l1Var2 = l1Var;
        int[] iArr3 = new int[(fVarArr2.length + 1)];
        int length = fVarArr2.length + 1;
        v1[][] v1VarArr = new v1[length][];
        int[][][] iArr4 = new int[(fVarArr2.length + 1)][][];
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = l1Var2.f15716h;
            v1VarArr[i12] = new v1[i13];
            iArr4[i12] = new int[i13][];
        }
        int length2 = fVarArr2.length;
        int[] iArr5 = new int[length2];
        for (int i14 = 0; i14 < length2; i14++) {
            iArr5[i14] = fVarArr2[i14].y();
        }
        int i15 = 0;
        while (i15 < l1Var2.f15716h) {
            v1 i16 = l1Var2.i(i15);
            boolean z11 = i16.f6675j == 5;
            int length3 = fVarArr2.length;
            int i17 = 0;
            int i18 = 0;
            boolean z12 = true;
            while (true) {
                int length4 = fVarArr2.length;
                a0VarArr = i16.f6676k;
                i10 = i16.f6673h;
                if (i17 >= length4) {
                    break;
                }
                f fVar = fVarArr2[i17];
                int[] iArr6 = iArr5;
                int i19 = 0;
                int i20 = 0;
                while (true) {
                    i11 = i15;
                    if (i19 >= i10) {
                        break;
                    }
                    i20 = Math.max(i20, fVar.x(a0VarArr[i19]) & 7);
                    i19++;
                    i15 = i11;
                }
                boolean z13 = iArr3[i17] == 0;
                if (i20 > i18 || (i20 == i18 && z11 && !z12 && z13)) {
                    z12 = z13;
                    length3 = i17;
                    i18 = i20;
                }
                i17++;
                l1 l1Var3 = l1Var;
                iArr5 = iArr6;
                i15 = i11;
            }
            int i21 = i15;
            int[] iArr7 = iArr5;
            if (length3 == fVarArr2.length) {
                iArr2 = new int[i10];
            } else {
                f fVar2 = fVarArr2[length3];
                int[] iArr8 = new int[i10];
                for (int i22 = 0; i22 < i10; i22++) {
                    iArr8[i22] = fVar2.x(a0VarArr[i22]);
                }
                iArr2 = iArr8;
            }
            int i23 = iArr3[length3];
            v1VarArr[length3][i23] = i16;
            iArr4[length3][i23] = iArr2;
            iArr3[length3] = i23 + 1;
            i15 = i21 + 1;
            l1Var2 = l1Var;
            iArr5 = iArr7;
        }
        int[] iArr9 = iArr5;
        l1[] l1VarArr2 = new l1[fVarArr2.length];
        String[] strArr = new String[fVarArr2.length];
        int[] iArr10 = new int[fVarArr2.length];
        for (int i24 = 0; i24 < fVarArr2.length; i24++) {
            int i25 = iArr3[i24];
            l1VarArr2[i24] = new l1((v1[]) l0.J(i25, v1VarArr[i24]));
            iArr4[i24] = (int[][]) l0.J(i25, iArr4[i24]);
            strArr[i24] = fVarArr2[i24].g();
            iArr10[i24] = fVarArr2[i24].f10216h;
        }
        u uVar = new u(iArr10, l1VarArr2, iArr9, iArr4, new l1((v1[]) l0.J(iArr3[fVarArr2.length], v1VarArr[fVarArr2.length])));
        Pair g10 = g(uVar, iArr4, iArr9);
        s[] sVarArr = (s[]) g10.second;
        List[] listArr = new List[sVarArr.length];
        for (int i26 = 0; i26 < sVarArr.length; i26++) {
            s sVar = sVarArr[i26];
            if (sVar != null) {
                r1Var = r0.n(sVar);
            } else {
                p0 p0Var = r0.f4657i;
                r1Var = r1.f4658l;
            }
            listArr[i26] = r1Var;
        }
        o0 o0Var = new o0();
        int i27 = 0;
        while (i27 < uVar.f17479a) {
            l1[] l1VarArr3 = uVar.f17481c;
            l1 l1Var4 = l1VarArr3[i27];
            List list = listArr[i27];
            int i28 = 0;
            while (i28 < l1Var4.f15716h) {
                v1 i29 = l1Var4.i(i28);
                int i30 = l1VarArr3[i27].i(i28).f6673h;
                int[] iArr11 = new int[i30];
                int i31 = 0;
                int i32 = 0;
                while (true) {
                    iArr = uVar.f17483e;
                    if (i31 >= i30) {
                        break;
                    }
                    if ((iArr[i27][i28][i31] & 7) == 4) {
                        iArr11[i32] = i31;
                        i32++;
                    }
                    i31++;
                }
                int[] copyOf = Arrays.copyOf(iArr11, i32);
                String str = null;
                int i33 = 16;
                List[] listArr2 = listArr;
                int i34 = 0;
                boolean z14 = false;
                int i35 = 0;
                while (i34 < copyOf.length) {
                    int[] iArr12 = copyOf;
                    String str2 = l1VarArr3[i27].i(i28).f6676k[copyOf[i34]].f6276s;
                    int i36 = i35 + 1;
                    if (i35 == 0) {
                        str = str2;
                    } else {
                        z14 |= !l0.a(str, str2);
                    }
                    i33 = Math.min(i33, iArr[i27][i28][i34] & 24);
                    i34++;
                    copyOf = iArr12;
                    i35 = i36;
                }
                if (z14) {
                    i33 = Math.min(i33, uVar.f17482d[i27]);
                }
                boolean z15 = i33 != 0;
                int i37 = i29.f6673h;
                int[] iArr13 = new int[i37];
                boolean[] zArr = new boolean[i37];
                int i38 = 0;
                while (i38 < i37) {
                    iArr13[i38] = iArr[i27][i28][i38] & 7;
                    int i39 = i37;
                    int i40 = 0;
                    while (true) {
                        if (i40 >= list.size()) {
                            l1VarArr = l1VarArr3;
                            z10 = false;
                            break;
                        }
                        s sVar2 = (s) list.get(i40);
                        l1VarArr = l1VarArr3;
                        if (sVar2.l().equals(i29) && sVar2.t(i38) != -1) {
                            z10 = true;
                            break;
                        }
                        i40++;
                        l1VarArr3 = l1VarArr;
                    }
                    zArr[i38] = z10;
                    i38++;
                    i37 = i39;
                    l1VarArr3 = l1VarArr;
                }
                l1[] l1VarArr4 = l1VarArr3;
                o0Var.c(new z1(i29, z15, iArr13, zArr));
                i28++;
                listArr = listArr2;
            }
            List[] listArr3 = listArr;
            i27++;
        }
        int i41 = 0;
        while (true) {
            l1 l1Var5 = uVar.f17484f;
            if (i41 < l1Var5.f15716h) {
                v1 i42 = l1Var5.i(i41);
                int i43 = i42.f6673h;
                int[] iArr14 = new int[i43];
                Arrays.fill(iArr14, 0);
                o0Var.c(new z1(i42, false, iArr14, new boolean[i43]));
                i41++;
            } else {
                return new y((o1[]) g10.first, (s[]) g10.second, new a2(o0Var.e()), uVar);
            }
        }
    }

    public abstract Pair g(u uVar, int[][][] iArr, int[] iArr2);
}
