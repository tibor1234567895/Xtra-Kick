package d2;

import j1.a;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final f f4219a;

    /* renamed from: b  reason: collision with root package name */
    public final k f4220b;

    /* renamed from: c  reason: collision with root package name */
    public h f4221c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4222d;

    public l(i iVar, k kVar, long j10, long j11, long j12, long j13, long j14, int i10) {
        this.f4220b = kVar;
        this.f4222d = i10;
        this.f4219a = new f(iVar, j10, j11, j12, j13, j14);
    }

    public static int b(w wVar, long j10, s0 s0Var) {
        if (j10 == wVar.p()) {
            return 0;
        }
        s0Var.f4296a = j10;
        return 1;
    }

    public final int a(w wVar, s0 s0Var) {
        boolean z10;
        w wVar2 = wVar;
        s0 s0Var2 = s0Var;
        while (true) {
            h hVar = this.f4221c;
            a.f(hVar);
            long j10 = hVar.f4193f;
            long j11 = hVar.f4194g;
            long j12 = hVar.f4195h;
            k kVar = this.f4220b;
            if (j11 - j10 <= ((long) this.f4222d)) {
                this.f4221c = null;
                kVar.i();
                return b(wVar2, j10, s0Var2);
            }
            long p10 = j12 - wVar.p();
            if (p10 < 0 || p10 > 262144) {
                z10 = false;
            } else {
                wVar2.g((int) p10);
                z10 = true;
            }
            if (!z10) {
                return b(wVar2, j12, s0Var2);
            }
            wVar.f();
            j h10 = kVar.h(wVar2, hVar.f4189b);
            int i10 = h10.f4205a;
            if (i10 != -3) {
                long j13 = h10.f4206b;
                long j14 = h10.f4207c;
                if (i10 == -2) {
                    hVar.f4191d = j13;
                    long j15 = j14;
                    hVar.f4193f = j15;
                    long j16 = hVar.f4189b;
                    long j17 = hVar.f4192e;
                    hVar.f4195h = h.a(j16, j13, j17, j15, hVar.f4194g, hVar.f4190c);
                } else if (i10 == -1) {
                    hVar.f4192e = j13;
                    hVar.f4194g = j14;
                    long j18 = hVar.f4189b;
                    long j19 = hVar.f4191d;
                    hVar.f4195h = h.a(j18, j19, j13, hVar.f4193f, j14, hVar.f4190c);
                } else if (i10 == 0) {
                    long p11 = j14 - wVar.p();
                    if (p11 >= 0 && p11 <= 262144) {
                        wVar2.g((int) p11);
                    }
                    this.f4221c = null;
                    kVar.i();
                    return b(wVar2, j14, s0Var2);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            } else {
                this.f4221c = null;
                kVar.i();
                return b(wVar2, j12, s0Var2);
            }
        }
    }

    public final void c(long j10) {
        long j11 = j10;
        h hVar = this.f4221c;
        if (hVar == null || hVar.f4188a != j11) {
            f fVar = this.f4219a;
            h hVar2 = r1;
            h hVar3 = new h(j10, fVar.f4166a.d(j11), fVar.f4168c, fVar.f4169d, fVar.f4170e, fVar.f4171f, fVar.f4172g);
            this.f4221c = hVar2;
        }
    }
}
