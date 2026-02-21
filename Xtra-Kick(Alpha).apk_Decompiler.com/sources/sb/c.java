package sb;

import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import la.v;
import pb.p0;
import qb.h;
import wa.a;
import xa.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final g f14463a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14464b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14465c;

    /* renamed from: d  reason: collision with root package name */
    public a f14466d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f14467e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public boolean f14468f;

    public c(g gVar, String str) {
        j.f("taskRunner", gVar);
        j.f("name", str);
        this.f14463a = gVar;
        this.f14464b = str;
    }

    public static void c(c cVar, String str, long j10, a aVar, int i10) {
        boolean z10;
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.getClass();
        j.f("name", str);
        j.f("block", aVar);
        cVar.d(new b(str, z10, aVar), j10);
    }

    public final void a() {
        p0 p0Var = h.f13493a;
        synchronized (this.f14463a) {
            if (b()) {
                this.f14463a.e(this);
            }
            v vVar = v.f9814a;
        }
    }

    public final boolean b() {
        a aVar = this.f14466d;
        if (aVar != null && aVar.f14458b) {
            this.f14468f = true;
        }
        ArrayList arrayList = this.f14467e;
        boolean z10 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f14458b) {
                Logger logger = this.f14463a.f14474b;
                a aVar2 = (a) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    h0.e(logger, aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(sb.a r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "task"
            xa.j.f(r0, r3)
            sb.g r0 = r2.f14463a
            monitor-enter(r0)
            boolean r1 = r2.f14465c     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x003a
            boolean r4 = r3.f14458b     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0023
            sb.g r4 = r2.f14463a     // Catch:{ all -> 0x004a }
            java.util.logging.Logger r4 = r4.f14474b     // Catch:{ all -> 0x004a }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x004a }
            boolean r5 = r4.isLoggable(r5)     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x0021
            java.lang.String r5 = "schedule canceled (queue is shutdown)"
            hb.h0.e(r4, r3, r2, r5)     // Catch:{ all -> 0x004a }
        L_0x0021:
            monitor-exit(r0)
            return
        L_0x0023:
            sb.g r4 = r2.f14463a     // Catch:{ all -> 0x004a }
            java.util.logging.Logger r4 = r4.f14474b     // Catch:{ all -> 0x004a }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x004a }
            boolean r5 = r4.isLoggable(r5)     // Catch:{ all -> 0x004a }
            if (r5 == 0) goto L_0x0034
            java.lang.String r5 = "schedule failed (queue is shutdown)"
            hb.h0.e(r4, r3, r2, r5)     // Catch:{ all -> 0x004a }
        L_0x0034:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x004a }
            r3.<init>()     // Catch:{ all -> 0x004a }
            throw r3     // Catch:{ all -> 0x004a }
        L_0x003a:
            r1 = 0
            boolean r3 = r2.e(r3, r4, r1)     // Catch:{ all -> 0x004a }
            if (r3 == 0) goto L_0x0046
            sb.g r3 = r2.f14463a     // Catch:{ all -> 0x004a }
            r3.e(r2)     // Catch:{ all -> 0x004a }
        L_0x0046:
            la.v r3 = la.v.f9814a     // Catch:{ all -> 0x004a }
            monitor-exit(r0)
            return
        L_0x004a:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.c.d(sb.a, long):void");
    }

    public final boolean e(a aVar, long j10, boolean z10) {
        boolean z11;
        String str;
        boolean z12;
        a aVar2 = aVar;
        j.f("task", aVar2);
        c cVar = aVar2.f14459c;
        if (cVar != this) {
            if (cVar == null) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                aVar2.f14459c = this;
            } else {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
        }
        g gVar = this.f14463a;
        gVar.f14473a.getClass();
        long nanoTime = System.nanoTime();
        long j11 = nanoTime + j10;
        ArrayList arrayList = this.f14467e;
        int indexOf = arrayList.indexOf(aVar2);
        Logger logger = gVar.f14474b;
        if (indexOf != -1) {
            if (aVar2.f14460d <= j11) {
                if (logger.isLoggable(Level.FINE)) {
                    h0.e(logger, aVar2, this, "already scheduled");
                }
                return false;
            }
            arrayList.remove(indexOf);
        }
        aVar2.f14460d = j11;
        if (logger.isLoggable(Level.FINE)) {
            String Y = h0.Y(j11 - nanoTime);
            if (z10) {
                str = "run again after ";
            } else {
                str = "scheduled after ";
            }
            h0.e(logger, aVar2, this, str.concat(Y));
        }
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (((a) it.next()).f14460d - nanoTime > j10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            i10 = arrayList.size();
        }
        arrayList.add(i10, aVar2);
        if (i10 == 0) {
            return true;
        }
        return false;
    }

    public final void f() {
        p0 p0Var = h.f13493a;
        synchronized (this.f14463a) {
            this.f14465c = true;
            if (b()) {
                this.f14463a.e(this);
            }
            v vVar = v.f9814a;
        }
    }

    public final String toString() {
        return this.f14464b;
    }
}
