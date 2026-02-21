package v1;

import a2.e;
import d9.f1;
import d9.h1;
import d9.j1;
import d9.m1;
import d9.u;
import g1.f0;
import g1.s0;
import g1.u1;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import p1.d;

public final class l0 extends j {

    /* renamed from: r  reason: collision with root package name */
    public static final s0 f15706r;

    /* renamed from: k  reason: collision with root package name */
    public final a[] f15707k;

    /* renamed from: l  reason: collision with root package name */
    public final u1[] f15708l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f15709m;

    /* renamed from: n  reason: collision with root package name */
    public final k f15710n;

    /* renamed from: o  reason: collision with root package name */
    public int f15711o = -1;

    /* renamed from: p  reason: collision with root package name */
    public long[][] f15712p;

    /* renamed from: q  reason: collision with root package name */
    public d f15713q;

    static {
        f0 f0Var = new f0();
        f0Var.f6358a = "MergingMediaSource";
        f15706r = f0Var.a();
    }

    public l0(a... aVarArr) {
        k kVar = new k();
        this.f15707k = aVarArr;
        this.f15710n = kVar;
        this.f15709m = new ArrayList(Arrays.asList(aVarArr));
        this.f15708l = new u1[aVarArr.length];
        this.f15712p = new long[0][];
        new HashMap();
        u.a(8, "expectedKeys");
        f1 f1Var = new f1();
        u.a(2, "expectedValuesPerKey");
        new j1(f1Var);
        new m1(f1Var.a(), new h1(2));
    }

    public final y b(a0 a0Var, e eVar, long j10) {
        a[] aVarArr = this.f15707k;
        int length = aVarArr.length;
        y[] yVarArr = new y[length];
        u1[] u1VarArr = this.f15708l;
        int k10 = u1VarArr[0].k(a0Var.f6678a);
        for (int i10 = 0; i10 < length; i10++) {
            yVarArr[i10] = aVarArr[i10].b(a0Var.b(u1VarArr[i10].u(k10)), eVar, j10 - this.f15712p[k10][i10]);
        }
        return new k0(this.f15710n, this.f15712p[k10], yVarArr);
    }

    public final s0 h() {
        a[] aVarArr = this.f15707k;
        return aVarArr.length > 0 ? aVarArr[0].h() : f15706r;
    }

    public final void j() {
        d dVar = this.f15713q;
        if (dVar == null) {
            super.j();
            return;
        }
        throw dVar;
    }

    public final void l(k1.f0 f0Var) {
        super.l(f0Var);
        int i10 = 0;
        while (true) {
            a[] aVarArr = this.f15707k;
            if (i10 < aVarArr.length) {
                w(Integer.valueOf(i10), aVarArr[i10]);
                i10++;
            } else {
                return;
            }
        }
    }

    public final void n(y yVar) {
        k0 k0Var = (k0) yVar;
        int i10 = 0;
        while (true) {
            a[] aVarArr = this.f15707k;
            if (i10 < aVarArr.length) {
                a aVar = aVarArr[i10];
                y yVar2 = k0Var.f15691h[i10];
                if (yVar2 instanceof i0) {
                    yVar2 = ((i0) yVar2).f15660h;
                }
                aVar.n(yVar2);
                i10++;
            } else {
                return;
            }
        }
    }

    public final void p() {
        super.p();
        Arrays.fill(this.f15708l, (Object) null);
        this.f15711o = -1;
        this.f15713q = null;
        ArrayList arrayList = this.f15709m;
        arrayList.clear();
        Collections.addAll(arrayList, this.f15707k);
    }

    public final a0 s(Object obj, a0 a0Var) {
        if (((Integer) obj).intValue() == 0) {
            return a0Var;
        }
        return null;
    }

    public final void v(Object obj, a aVar, u1 u1Var) {
        Integer num = (Integer) obj;
        if (this.f15713q == null) {
            if (this.f15711o == -1) {
                this.f15711o = u1Var.q();
            } else if (u1Var.q() != this.f15711o) {
                this.f15713q = new d(0, 0);
                return;
            }
            int length = this.f15712p.length;
            u1[] u1VarArr = this.f15708l;
            if (length == 0) {
                int i10 = this.f15711o;
                int[] iArr = new int[2];
                iArr[1] = u1VarArr.length;
                iArr[0] = i10;
                this.f15712p = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            ArrayList arrayList = this.f15709m;
            arrayList.remove(aVar);
            u1VarArr[num.intValue()] = u1Var;
            if (arrayList.isEmpty()) {
                m(u1VarArr[0]);
            }
        }
    }
}
