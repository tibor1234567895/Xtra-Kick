package m6;

import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DownloadService f10646i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(DownloadService downloadService, e eVar) {
        super(2, eVar);
        this.f10646i = downloadService;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f10646i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            com.github.andreyasadchy.xtra.ui.download.DownloadService r0 = r9.f10646i
            hb.h0.O1(r10)
            m6.i r10 = com.github.andreyasadchy.xtra.ui.download.DownloadService.f3380w     // Catch:{ Exception -> 0x004f }
            r10.getClass()     // Catch:{ Exception -> 0x004f }
            java.util.HashSet r10 = com.github.andreyasadchy.xtra.ui.download.DownloadService.f3381x     // Catch:{ Exception -> 0x004f }
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r1 = r0.f3389r     // Catch:{ Exception -> 0x004f }
            r2 = 0
            if (r1 == 0) goto L_0x0049
            int r1 = r1.getId()     // Catch:{ Exception -> 0x004f }
            java.lang.Integer r3 = new java.lang.Integer     // Catch:{ Exception -> 0x004f }
            r3.<init>(r1)     // Catch:{ Exception -> 0x004f }
            r10.remove(r3)     // Catch:{ Exception -> 0x004f }
            p9.h r10 = r0.f3385n     // Catch:{ Exception -> 0x004f }
            if (r10 == 0) goto L_0x0043
            r4 = r10
            t9.m r4 = (t9.m) r4     // Catch:{ Exception -> 0x004f }
            t9.b r5 = new t9.b     // Catch:{ Exception -> 0x004f }
            r10 = 1
            r5.<init>(r4, r10)     // Catch:{ Exception -> 0x004f }
            r6 = 0
            r7 = 0
            java.lang.Object r10 = r4.f14875b     // Catch:{ Exception -> 0x004f }
            monitor-enter(r10)     // Catch:{ Exception -> 0x004f }
            r4.e()     // Catch:{ all -> 0x0040 }
            y9.p r0 = r4.f14881h     // Catch:{ all -> 0x0040 }
            t9.k r1 = new t9.k     // Catch:{ all -> 0x0040 }
            r8 = 1
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0040 }
            r0.d(r1)     // Catch:{ all -> 0x0040 }
            monitor-exit(r10)     // Catch:{ Exception -> 0x004f }
            goto L_0x004f
        L_0x0040:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ Exception -> 0x004f }
            throw r0     // Catch:{ Exception -> 0x004f }
        L_0x0043:
            java.lang.String r10 = "fetch"
            xa.j.l(r10)     // Catch:{ Exception -> 0x004f }
            throw r2     // Catch:{ Exception -> 0x004f }
        L_0x0049:
            java.lang.String r10 = "offlineVideo"
            xa.j.l(r10)     // Catch:{ Exception -> 0x004f }
            throw r2     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            la.v r10 = la.v.f9814a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: m6.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
