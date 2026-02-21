package j0;

import l0.a;

public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8387a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f8388b;

    public /* synthetic */ e(int i10, Object obj) {
        this.f8387a = i10;
        this.f8388b = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 >= r2.size()) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        ((l0.a) r2.get(r0)).b(r5);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(j0.f r5) {
        /*
            r4 = this;
            int r0 = r4.f8387a
            switch(r0) {
                case 0: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0016
        L_0x0006:
            if (r5 != 0) goto L_0x000e
            j0.f r5 = new j0.f
            r0 = -3
            r5.<init>((int) r0)
        L_0x000e:
            java.lang.Object r0 = r4.f8388b
            android.support.v4.media.n r0 = (android.support.v4.media.n) r0
            r0.z(r5)
            return
        L_0x0016:
            java.lang.Object r0 = j0.g.f8393c
            monitor-enter(r0)
            q.k r1 = j0.g.f8394d     // Catch:{ all -> 0x0046 }
            java.lang.Object r2 = r4.f8388b     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0046 }
            r3 = 0
            java.lang.Object r2 = r1.getOrDefault(r2, r3)     // Catch:{ all -> 0x0046 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x0046 }
            if (r2 != 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            goto L_0x0045
        L_0x002a:
            java.lang.Object r3 = r4.f8388b     // Catch:{ all -> 0x0046 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0046 }
            r1.remove(r3)     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            r0 = 0
        L_0x0033:
            int r1 = r2.size()
            if (r0 >= r1) goto L_0x0045
            java.lang.Object r1 = r2.get(r0)
            l0.a r1 = (l0.a) r1
            r1.b(r5)
            int r0 = r0 + 1
            goto L_0x0033
        L_0x0045:
            return
        L_0x0046:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.e.a(j0.f):void");
    }

    public final /* bridge */ /* synthetic */ void b(Object obj) {
        switch (this.f8387a) {
            case 0:
                a((f) obj);
                return;
            default:
                a((f) obj);
                return;
        }
    }
}
