package k4;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f9098i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(i iVar, e eVar) {
        super(2, eVar);
        this.f9098i = iVar;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f9098i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:7|8|9|10|11|12|13|(1:15)(1:16)|(1:18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f9114v = true;
        r4.f9109q = hb.h0.n(new dc.f());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0025 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x0014=Splitter:B:10:0x0014, B:12:0x0016=Splitter:B:12:0x0016, B:24:0x0036=Splitter:B:24:0x0036} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            hb.h0.O1(r4)
            k4.i r4 = r3.f9098i
            monitor-enter(r4)
            boolean r0 = r4.f9111s     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0036
            boolean r0 = r4.f9112t     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x000f
            goto L_0x0036
        L_0x000f:
            r0 = 1
            r4.j0()     // Catch:{ IOException -> 0x0014 }
            goto L_0x0016
        L_0x0014:
            r4.f9113u = r0     // Catch:{ all -> 0x003a }
        L_0x0016:
            int r1 = r4.f9108p     // Catch:{ IOException -> 0x0025 }
            r2 = 2000(0x7d0, float:2.803E-42)
            if (r1 < r2) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            if (r1 == 0) goto L_0x0032
            r4.I0()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0032
        L_0x0025:
            r4.f9114v = r0     // Catch:{ all -> 0x003a }
            dc.f r0 = new dc.f     // Catch:{ all -> 0x003a }
            r0.<init>()     // Catch:{ all -> 0x003a }
            dc.h0 r0 = hb.h0.n(r0)     // Catch:{ all -> 0x003a }
            r4.f9109q = r0     // Catch:{ all -> 0x003a }
        L_0x0032:
            monitor-exit(r4)
            la.v r4 = la.v.f9814a
            return r4
        L_0x0036:
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x003a }
            monitor-exit(r4)
            return r0
        L_0x003a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.h.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
