package u;

import v.b;
import v.o;

public class n extends l {
    public int A0 = 0;
    public int B0 = 0;
    public final b C0 = new b();
    public o D0 = null;

    /* renamed from: t0  reason: collision with root package name */
    public int f15161t0 = 0;

    /* renamed from: u0  reason: collision with root package name */
    public int f15162u0 = 0;

    /* renamed from: v0  reason: collision with root package name */
    public int f15163v0 = 0;

    /* renamed from: w0  reason: collision with root package name */
    public int f15164w0 = 0;

    /* renamed from: x0  reason: collision with root package name */
    public int f15165x0 = 0;

    /* renamed from: y0  reason: collision with root package name */
    public int f15166y0 = 0;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f15167z0 = false;

    public void R(int i10, int i11, int i12, int i13) {
    }

    public final void S(f fVar, int i10, int i11, int i12, int i13) {
        o oVar;
        boolean z10;
        f fVar2;
        while (true) {
            oVar = this.D0;
            if (oVar != null || (fVar2 = this.U) == null) {
                b bVar = this.C0;
                bVar.f15487a = i10;
                bVar.f15488b = i12;
                bVar.f15489c = i11;
                bVar.f15490d = i13;
                oVar.b(fVar, bVar);
                fVar.N(bVar.f15491e);
                fVar.K(bVar.f15492f);
                fVar.F = bVar.f15494h;
                int i14 = bVar.f15493g;
                fVar.f15083b0 = i14;
            } else {
                this.D0 = ((g) fVar2).f15126v0;
            }
        }
        b bVar2 = this.C0;
        bVar2.f15487a = i10;
        bVar2.f15488b = i12;
        bVar2.f15489c = i11;
        bVar2.f15490d = i13;
        oVar.b(fVar, bVar2);
        fVar.N(bVar2.f15491e);
        fVar.K(bVar2.f15492f);
        fVar.F = bVar2.f15494h;
        int i142 = bVar2.f15493g;
        fVar.f15083b0 = i142;
        if (i142 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        fVar.F = z10;
    }

    public final void a() {
        for (int i10 = 0; i10 < this.f15159s0; i10++) {
            f fVar = this.f15158r0[i10];
            if (fVar != null) {
                fVar.G = true;
            }
        }
    }
}
