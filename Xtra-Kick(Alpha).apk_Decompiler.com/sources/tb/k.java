package tb;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import qb.h;
import sb.g;
import xa.j;

public final class k implements h {

    /* renamed from: a  reason: collision with root package name */
    public final v f14969a;

    /* renamed from: b  reason: collision with root package name */
    public final g f14970b;

    /* renamed from: c  reason: collision with root package name */
    public final long f14971c = TimeUnit.MILLISECONDS.toNanos(250);

    /* renamed from: d  reason: collision with root package name */
    public long f14972d = Long.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public final CopyOnWriteArrayList f14973e = new CopyOnWriteArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final LinkedBlockingDeque f14974f;

    public k(v vVar, g gVar) {
        j.f("taskRunner", gVar);
        this.f14969a = vVar;
        this.f14970b = gVar;
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        gVar.f14473a.getClass();
        this.f14974f = linkedBlockingDeque;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0078 A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a6 A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b9 A[Catch:{ all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0002 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final tb.r a() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.util.concurrent.CopyOnWriteArrayList r2 = r10.f14973e     // Catch:{ all -> 0x00ca }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00ca }
            r3 = 1
            r2 = r2 ^ r3
            if (r2 != 0) goto L_0x001c
            tb.v r2 = r10.f14969a     // Catch:{ all -> 0x00ca }
            boolean r2 = r2.a(r0)     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0015
            goto L_0x001c
        L_0x0015:
            r10.c()
            xa.j.c(r1)
            throw r1
        L_0x001c:
            tb.v r2 = r10.f14969a     // Catch:{ all -> 0x00ca }
            tb.o r2 = r2.f15029c     // Catch:{ all -> 0x00ca }
            boolean r2 = r2.f14995w     // Catch:{ all -> 0x00ca }
            if (r2 != 0) goto L_0x00c2
            sb.g r2 = r10.f14970b     // Catch:{ all -> 0x00ca }
            sb.e r2 = r2.f14473a     // Catch:{ all -> 0x00ca }
            r2.getClass()     // Catch:{ all -> 0x00ca }
            long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00ca }
            long r6 = r10.f14972d     // Catch:{ all -> 0x00ca }
            long r6 = r6 - r4
            java.util.concurrent.CopyOnWriteArrayList r2 = r10.f14973e     // Catch:{ all -> 0x00ca }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00ca }
            if (r2 != 0) goto L_0x0043
            r8 = 0
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r2 = r0
            goto L_0x004c
        L_0x0043:
            tb.y r2 = r10.d()     // Catch:{ all -> 0x00ca }
            long r6 = r10.f14971c     // Catch:{ all -> 0x00ca }
            long r4 = r4 + r6
            r10.f14972d = r4     // Catch:{ all -> 0x00ca }
        L_0x004c:
            if (r2 != 0) goto L_0x006d
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00ca }
            java.util.concurrent.CopyOnWriteArrayList r4 = r10.f14973e     // Catch:{ all -> 0x00ca }
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x00ca }
            if (r5 == 0) goto L_0x0059
            goto L_0x0063
        L_0x0059:
            java.util.concurrent.LinkedBlockingDeque r5 = r10.f14974f     // Catch:{ all -> 0x00ca }
            java.lang.Object r2 = r5.poll(r6, r2)     // Catch:{ all -> 0x00ca }
            tb.y r2 = (tb.y) r2     // Catch:{ all -> 0x00ca }
            if (r2 != 0) goto L_0x0065
        L_0x0063:
            r2 = r0
            goto L_0x006a
        L_0x0065:
            tb.z r5 = r2.f15038a     // Catch:{ all -> 0x00ca }
            r4.remove(r5)     // Catch:{ all -> 0x00ca }
        L_0x006a:
            if (r2 != 0) goto L_0x006d
            goto L_0x0002
        L_0x006d:
            tb.z r4 = r2.f15039b     // Catch:{ all -> 0x00ca }
            r5 = 0
            if (r4 != 0) goto L_0x0078
            java.lang.Throwable r4 = r2.f15040c     // Catch:{ all -> 0x00ca }
            if (r4 != 0) goto L_0x0078
            r4 = 1
            goto L_0x0079
        L_0x0078:
            r4 = 0
        L_0x0079:
            if (r4 == 0) goto L_0x00a2
            r10.c()     // Catch:{ all -> 0x00ca }
            tb.z r4 = r2.f15038a     // Catch:{ all -> 0x00ca }
            boolean r4 = r4.b()     // Catch:{ all -> 0x00ca }
            if (r4 != 0) goto L_0x008c
            tb.z r2 = r2.f15038a     // Catch:{ all -> 0x00ca }
            tb.y r2 = r2.c()     // Catch:{ all -> 0x00ca }
        L_0x008c:
            tb.z r4 = r2.f15039b     // Catch:{ all -> 0x00ca }
            if (r4 != 0) goto L_0x0095
            java.lang.Throwable r4 = r2.f15040c     // Catch:{ all -> 0x00ca }
            if (r4 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r3 = 0
        L_0x0096:
            if (r3 == 0) goto L_0x00a2
            tb.z r0 = r2.f15038a     // Catch:{ all -> 0x00ca }
            tb.r r0 = r0.d()     // Catch:{ all -> 0x00ca }
            r10.c()
            return r0
        L_0x00a2:
            java.lang.Throwable r3 = r2.f15040c     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x00b5
            boolean r4 = r3 instanceof java.io.IOException     // Catch:{ all -> 0x00ca }
            if (r4 == 0) goto L_0x00b4
            if (r1 != 0) goto L_0x00b0
            java.io.IOException r3 = (java.io.IOException) r3     // Catch:{ all -> 0x00ca }
            r1 = r3
            goto L_0x00b5
        L_0x00b0:
            la.a.a(r1, r3)     // Catch:{ all -> 0x00ca }
            goto L_0x00b5
        L_0x00b4:
            throw r3     // Catch:{ all -> 0x00ca }
        L_0x00b5:
            tb.z r2 = r2.f15039b     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0002
            tb.v r3 = r10.f14969a     // Catch:{ all -> 0x00ca }
            ma.l r3 = r3.f15034h     // Catch:{ all -> 0x00ca }
            r3.c(r2)     // Catch:{ all -> 0x00ca }
            goto L_0x0002
        L_0x00c2:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch:{ all -> 0x00ca }
            throw r0     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r0 = move-exception
            r10.c()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.k.a():tb.r");
    }

    public final v b() {
        return this.f14969a;
    }

    public final void c() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f14973e;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            zVar.cancel();
            z a10 = zVar.a();
            if (a10 != null) {
                this.f14969a.f15034h.d(a10);
            }
        }
        copyOnWriteArrayList.clear();
    }

    public final y d() {
        z zVar;
        v vVar = this.f14969a;
        if (vVar.a((r) null)) {
            try {
                zVar = vVar.b();
            } catch (Throwable th) {
                zVar = new i(th);
            }
            if (zVar.b()) {
                return new y(zVar, (d) null, (Throwable) null, 6);
            }
            if (zVar instanceof i) {
                return ((i) zVar).f14966a;
            }
            this.f14973e.add(zVar);
            this.f14970b.f().d(new j(h.f13495c + " connect " + vVar.f15028b.f12763i.g(), zVar, this), 0);
        }
        return null;
    }
}
