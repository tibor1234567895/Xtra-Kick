package ec;

import dc.i0;
import dc.l;
import java.io.IOException;
import la.v;
import wa.p;
import xa.k;
import xa.q;
import xa.t;

public final class i extends k implements p {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ q f5375h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f5376i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ t f5377j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ l f5378k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ t f5379l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ t f5380m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(q qVar, long j10, t tVar, i0 i0Var, t tVar2, t tVar3) {
        super(2);
        this.f5375h = qVar;
        this.f5376i = j10;
        this.f5377j = tVar;
        this.f5378k = i0Var;
        this.f5379l = tVar2;
        this.f5380m = tVar3;
    }

    public final Object g(Object obj, Object obj2) {
        long j10;
        int intValue = ((Number) obj).intValue();
        long longValue = ((Number) obj2).longValue();
        if (intValue == 1) {
            q qVar = this.f5375h;
            if (!qVar.f16814h) {
                qVar.f16814h = true;
                if (longValue >= this.f5376i) {
                    t tVar = this.f5377j;
                    long j11 = tVar.f16817h;
                    l lVar = this.f5378k;
                    if (j11 == 4294967295L) {
                        j11 = lVar.d0();
                    }
                    tVar.f16817h = j11;
                    t tVar2 = this.f5379l;
                    long j12 = 0;
                    if (tVar2.f16817h == 4294967295L) {
                        j10 = lVar.d0();
                    } else {
                        j10 = 0;
                    }
                    tVar2.f16817h = j10;
                    t tVar3 = this.f5380m;
                    if (tVar3.f16817h == 4294967295L) {
                        j12 = lVar.d0();
                    }
                    tVar3.f16817h = j12;
                } else {
                    throw new IOException("bad zip: zip64 extra too short");
                }
            } else {
                throw new IOException("bad zip: zip64 extra repeated");
            }
        }
        return v.f9814a;
    }
}
