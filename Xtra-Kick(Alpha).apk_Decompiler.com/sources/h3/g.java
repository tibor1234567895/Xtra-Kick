package h3;

import d9.r0;
import g1.g1;
import j1.a;
import j1.l0;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import q.e;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f7037a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final e f7038b = new e();

    /* renamed from: c  reason: collision with root package name */
    public final e f7039c = new e();

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference f7040d;

    public g(n2 n2Var) {
        this.f7040d = new WeakReference(n2Var);
    }

    public final void a(Object obj, e2 e2Var, h4 h4Var, g1 g1Var) {
        synchronized (this.f7037a) {
            e2 e10 = e(obj);
            if (e10 == null) {
                this.f7038b.put(obj, e2Var);
                this.f7039c.put(e2Var, new f(obj, new e4(), h4Var, g1Var));
            } else {
                f fVar = (f) this.f7039c.getOrDefault(e10, (Object) null);
                a.f(fVar);
                fVar.f7015d = h4Var;
                fVar.f7016e = g1Var;
            }
        }
    }

    public final void b(f fVar) {
        n2 n2Var = (n2) this.f7040d.get();
        if (n2Var != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            while (atomicBoolean.get()) {
                atomicBoolean.set(false);
                g3 g3Var = (g3) fVar.f7014c.poll();
                if (g3Var == null) {
                    fVar.f7017f = false;
                    return;
                }
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
                l0.L(n2Var.f7239l, new e(this, g3Var, atomicBoolean2, fVar, atomicBoolean));
                atomicBoolean2.set(false);
            }
        }
    }

    public final g1 c(e2 e2Var) {
        synchronized (this.f7037a) {
            f fVar = (f) this.f7039c.getOrDefault(e2Var, (Object) null);
            if (fVar == null) {
                return null;
            }
            g1 g1Var = fVar.f7016e;
            return g1Var;
        }
    }

    public final r0 d() {
        r0 j10;
        synchronized (this.f7037a) {
            j10 = r0.j(this.f7038b.values());
        }
        return j10;
    }

    public final e2 e(Object obj) {
        e2 e2Var;
        synchronized (this.f7037a) {
            e2Var = (e2) this.f7038b.getOrDefault(obj, (Object) null);
        }
        return e2Var;
    }

    public final e4 f(e2 e2Var) {
        f fVar;
        synchronized (this.f7037a) {
            fVar = (f) this.f7039c.getOrDefault(e2Var, (Object) null);
        }
        if (fVar != null) {
            return fVar.f7013b;
        }
        return null;
    }

    public final boolean g(e2 e2Var) {
        boolean z10;
        synchronized (this.f7037a) {
            if (this.f7039c.getOrDefault(e2Var, (Object) null) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public final boolean h(int i10, e2 e2Var) {
        f fVar;
        synchronized (this.f7037a) {
            fVar = (f) this.f7039c.getOrDefault(e2Var, (Object) null);
        }
        n2 n2Var = (n2) this.f7040d.get();
        if (fVar == null || !fVar.f7016e.i(i10) || n2Var == null || !n2Var.f7246s.w().i(i10)) {
            return false;
        }
        return true;
    }

    public final boolean i(int i10, e2 e2Var) {
        f fVar;
        synchronized (this.f7037a) {
            fVar = (f) this.f7039c.getOrDefault(e2Var, (Object) null);
        }
        if (fVar == null || !fVar.f7015d.i(i10)) {
            return false;
        }
        return true;
    }

    public final boolean j(e2 e2Var, f4 f4Var) {
        f fVar;
        synchronized (this.f7037a) {
            fVar = (f) this.f7039c.getOrDefault(e2Var, (Object) null);
        }
        if (fVar != null) {
            h4 h4Var = fVar.f7015d;
            h4Var.getClass();
            if (h4Var.f7078h.contains(f4Var)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r0.f() == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        j1.l0.L(r0.f7239l, new g.r0(r0, 20, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r1.f7013b.b();
        r0 = (h3.n2) r4.f7040d.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(h3.e2 r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f7037a
            monitor-enter(r0)
            q.e r1 = r4.f7039c     // Catch:{ all -> 0x003a }
            java.lang.Object r1 = r1.remove(r5)     // Catch:{ all -> 0x003a }
            h3.f r1 = (h3.f) r1     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x000f:
            q.e r2 = r4.f7038b     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r1.f7012a     // Catch:{ all -> 0x003a }
            r2.remove(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            h3.e4 r0 = r1.f7013b
            r0.b()
            java.lang.ref.WeakReference r0 = r4.f7040d
            java.lang.Object r0 = r0.get()
            h3.n2 r0 = (h3.n2) r0
            if (r0 == 0) goto L_0x0039
            boolean r1 = r0.f()
            if (r1 == 0) goto L_0x002d
            goto L_0x0039
        L_0x002d:
            android.os.Handler r1 = r0.f7239l
            g.r0 r2 = new g.r0
            r3 = 20
            r2.<init>(r0, r3, r5)
            j1.l0.L(r1, r2)
        L_0x0039:
            return
        L_0x003a:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.g.k(h3.e2):void");
    }
}
