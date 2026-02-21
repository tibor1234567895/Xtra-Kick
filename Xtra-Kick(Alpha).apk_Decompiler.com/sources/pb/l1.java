package pb;

import dc.f0;
import dc.r;

public final class l1 extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x0 f12896a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r f12897b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f0 f12898c;

    public l1(f0 f0Var, r rVar, x0 x0Var) {
        this.f12896a = x0Var;
        this.f12897b = rVar;
        this.f12898c = f0Var;
    }

    public final long contentLength() {
        Long l10 = this.f12897b.h(this.f12898c).f4814d;
        if (l10 != null) {
            return l10.longValue();
        }
        return -1;
    }

    public final x0 contentType() {
        return this.f12896a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        hb.h0.A(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeTo(dc.k r3) {
        /*
            r2 = this;
            java.lang.String r0 = "sink"
            xa.j.f(r0, r3)
            dc.r r0 = r2.f12897b
            dc.f0 r1 = r2.f12898c
            dc.p0 r0 = r0.l(r1)
            r3.F0(r0)     // Catch:{ all -> 0x0015 }
            r3 = 0
            hb.h0.A(r0, r3)
            return
        L_0x0015:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r1 = move-exception
            hb.h0.A(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.l1.writeTo(dc.k):void");
    }
}
