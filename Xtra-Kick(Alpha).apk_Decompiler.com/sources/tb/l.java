package tb;

import java.util.concurrent.atomic.AtomicInteger;
import pb.j;

public final class l implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final j f14975h;

    /* renamed from: i  reason: collision with root package name */
    public volatile AtomicInteger f14976i = new AtomicInteger(0);

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ o f14977j;

    public l(o oVar, j jVar) {
        xa.j.f("responseCallback", jVar);
        this.f14977j = oVar;
        this.f14975h = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a A[Catch:{ IOException -> 0x0064, all -> 0x0044, all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A[Catch:{ IOException -> 0x0064, all -> 0x0044, all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088 A[Catch:{ IOException -> 0x0064, all -> 0x0044, all -> 0x0086 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            java.lang.String r0 = "canceled due to "
            java.lang.String r1 = "Callback failure for "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "OkHttp "
            r2.<init>(r3)
            tb.o r3 = r8.f14977j
            pb.j1 r3 = r3.f14981i
            pb.t0 r3 = r3.f12884a
            java.lang.String r3 = r3.g()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            tb.o r3 = r8.f14977j
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            java.lang.String r5 = r4.getName()
            r4.setName(r2)
            tb.n r2 = r3.f14985m     // Catch:{ all -> 0x009f }
            r2.i()     // Catch:{ all -> 0x009f }
            r2 = 0
            pb.r1 r2 = r3.g()     // Catch:{ IOException -> 0x0064, all -> 0x0044 }
            r6 = 1
            pb.j r7 = r8.f14975h     // Catch:{ IOException -> 0x0041, all -> 0x003e }
            r7.onResponse(r3, r2)     // Catch:{ IOException -> 0x0041, all -> 0x003e }
            pb.f1 r0 = r3.f14980h     // Catch:{ all -> 0x009f }
        L_0x003b:
            pb.a0 r0 = r0.f12820a     // Catch:{ all -> 0x009f }
            goto L_0x0090
        L_0x003e:
            r1 = move-exception
            r2 = 1
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            r2 = 1
            goto L_0x0065
        L_0x0044:
            r1 = move-exception
        L_0x0045:
            r3.cancel()     // Catch:{ all -> 0x0086 }
            if (r2 != 0) goto L_0x0063
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r6.<init>(r0)     // Catch:{ all -> 0x0086 }
            r6.append(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0086 }
            r2.<init>(r0)     // Catch:{ all -> 0x0086 }
            la.a.a(r2, r1)     // Catch:{ all -> 0x0086 }
            pb.j r0 = r8.f14975h     // Catch:{ all -> 0x0086 }
            r0.onFailure(r3, r2)     // Catch:{ all -> 0x0086 }
        L_0x0063:
            throw r1     // Catch:{ all -> 0x0086 }
        L_0x0064:
            r0 = move-exception
        L_0x0065:
            if (r2 == 0) goto L_0x0088
            xb.r r2 = xb.s.f16851a     // Catch:{ all -> 0x0086 }
            r2.getClass()     // Catch:{ all -> 0x0086 }
            xb.s r2 = xb.s.f16852b     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r6.<init>(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = tb.o.a(r3)     // Catch:{ all -> 0x0086 }
            r6.append(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0086 }
            r2.getClass()     // Catch:{ all -> 0x0086 }
            r2 = 4
            xb.s.i(r2, r1, r0)     // Catch:{ all -> 0x0086 }
            goto L_0x008d
        L_0x0086:
            r0 = move-exception
            goto L_0x0097
        L_0x0088:
            pb.j r1 = r8.f14975h     // Catch:{ all -> 0x0086 }
            r1.onFailure(r3, r0)     // Catch:{ all -> 0x0086 }
        L_0x008d:
            pb.f1 r0 = r3.f14980h     // Catch:{ all -> 0x009f }
            goto L_0x003b
        L_0x0090:
            r0.b(r8)     // Catch:{ all -> 0x009f }
            r4.setName(r5)
            return
        L_0x0097:
            pb.f1 r1 = r3.f14980h     // Catch:{ all -> 0x009f }
            pb.a0 r1 = r1.f12820a     // Catch:{ all -> 0x009f }
            r1.b(r8)     // Catch:{ all -> 0x009f }
            throw r0     // Catch:{ all -> 0x009f }
        L_0x009f:
            r0 = move-exception
            r4.setName(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.l.run():void");
    }
}
