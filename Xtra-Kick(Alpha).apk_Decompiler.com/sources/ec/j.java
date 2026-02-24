package ec;

import dc.i0;
import dc.l;
import java.io.IOException;
import la.v;
import wa.p;
import xa.k;
import xa.u;

public final class j extends k implements p {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f5381h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ u f5382i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ u f5383j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ u f5384k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(i0 i0Var, u uVar, u uVar2, u uVar3) {
        super(2);
        this.f5381h = i0Var;
        this.f5382i = uVar;
        this.f5383j = uVar2;
        this.f5384k = uVar3;
    }

    public final Object g(Object obj, Object obj2) {
        boolean z10;
        boolean z11;
        int intValue = ((Number) obj).intValue();
        long longValue = ((Number) obj2).longValue();
        if (intValue == 21589) {
            long j10 = 1;
            if (longValue >= 1) {
                l lVar = this.f5381h;
                byte readByte = lVar.readByte() & 255;
                boolean z12 = false;
                if ((readByte & 1) == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((readByte & 2) == 2) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((readByte & 4) == 4) {
                    z12 = true;
                }
                if (z10) {
                    j10 = 5;
                }
                if (z11) {
                    j10 += 4;
                }
                if (z12) {
                    j10 += 4;
                }
                if (longValue >= j10) {
                    if (z10) {
                        this.f5382i.f16818h = Long.valueOf(((long) lVar.O()) * 1000);
                    }
                    if (z11) {
                        this.f5383j.f16818h = Long.valueOf(((long) lVar.O()) * 1000);
                    }
                    if (z12) {
                        this.f5384k.f16818h = Long.valueOf(((long) lVar.O()) * 1000);
                    }
                } else {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
            } else {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
        }
        return v.f9814a;
    }
}
