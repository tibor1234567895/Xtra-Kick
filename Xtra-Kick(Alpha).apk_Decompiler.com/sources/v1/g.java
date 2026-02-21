package v1;

import a2.e;
import g1.t1;
import g1.u1;
import j1.a;
import java.util.ArrayList;

public final class g extends m1 {

    /* renamed from: l  reason: collision with root package name */
    public final long f15636l;

    /* renamed from: m  reason: collision with root package name */
    public final long f15637m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f15638n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f15639o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f15640p;

    /* renamed from: q  reason: collision with root package name */
    public final ArrayList f15641q;

    /* renamed from: r  reason: collision with root package name */
    public final t1 f15642r;

    /* renamed from: s  reason: collision with root package name */
    public e f15643s;

    /* renamed from: t  reason: collision with root package name */
    public f f15644t;

    /* renamed from: u  reason: collision with root package name */
    public long f15645u;

    /* renamed from: v  reason: collision with root package name */
    public long f15646v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(a aVar, long j10, long j11, boolean z10, boolean z11, boolean z12) {
        super(aVar);
        boolean z13;
        aVar.getClass();
        if (j10 >= 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        a.b(z13);
        this.f15636l = j10;
        this.f15637m = j11;
        this.f15638n = z10;
        this.f15639o = z11;
        this.f15640p = z12;
        this.f15641q = new ArrayList();
        this.f15642r = new t1();
    }

    public final void A(u1 u1Var) {
        long j10;
        long j11;
        long j12;
        t1 t1Var = this.f15642r;
        u1Var.v(0, t1Var);
        long j13 = t1Var.f6591x;
        e eVar = this.f15643s;
        long j14 = this.f15637m;
        long j15 = Long.MIN_VALUE;
        ArrayList arrayList = this.f15641q;
        if (eVar == null || arrayList.isEmpty() || this.f15639o) {
            boolean z10 = this.f15640p;
            long j16 = this.f15636l;
            if (z10) {
                long j17 = t1Var.f6587t;
                j16 += j17;
                j12 = j17 + j14;
            } else {
                j12 = j14;
            }
            this.f15645u = j13 + j16;
            if (j14 != Long.MIN_VALUE) {
                j15 = j13 + j12;
            }
            this.f15646v = j15;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                d dVar = (d) arrayList.get(i10);
                long j18 = this.f15645u;
                long j19 = this.f15646v;
                dVar.f15601l = j18;
                dVar.f15602m = j19;
            }
            j11 = j16;
            j10 = j12;
        } else {
            long j20 = this.f15645u - j13;
            if (j14 != Long.MIN_VALUE) {
                j15 = this.f15646v - j13;
            }
            j10 = j15;
            j11 = j20;
        }
        try {
            e eVar2 = new e(u1Var, j11, j10);
            this.f15643s = eVar2;
            m(eVar2);
        } catch (f e10) {
            this.f15644t = e10;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                ((d) arrayList.get(i11)).f15603n = this.f15644t;
            }
        }
    }

    public final y b(a0 a0Var, e eVar, long j10) {
        d dVar = new d(this.f15722k.b(a0Var, eVar, j10), this.f15638n, this.f15645u, this.f15646v);
        this.f15641q.add(dVar);
        return dVar;
    }

    public final void j() {
        f fVar = this.f15644t;
        if (fVar == null) {
            super.j();
            return;
        }
        throw fVar;
    }

    public final void n(y yVar) {
        ArrayList arrayList = this.f15641q;
        a.e(arrayList.remove(yVar));
        this.f15722k.n(((d) yVar).f15597h);
        if (arrayList.isEmpty() && !this.f15639o) {
            e eVar = this.f15643s;
            eVar.getClass();
            A(eVar.f15746m);
        }
    }

    public final void p() {
        super.p();
        this.f15644t = null;
        this.f15643s = null;
    }

    public final void y(u1 u1Var) {
        if (this.f15644t == null) {
            A(u1Var);
        }
    }
}
