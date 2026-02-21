package tb;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import la.v;
import pb.a0;
import pb.f1;
import pb.g0;
import pb.i;
import pb.j1;
import pb.p0;
import pb.r1;
import qb.h;
import sb.c;
import xa.j;
import xb.s;

public final class o implements i, Cloneable {

    /* renamed from: h  reason: collision with root package name */
    public final f1 f14980h;

    /* renamed from: i  reason: collision with root package name */
    public final j1 f14981i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f14982j;

    /* renamed from: k  reason: collision with root package name */
    public final u f14983k;

    /* renamed from: l  reason: collision with root package name */
    public final g0 f14984l;

    /* renamed from: m  reason: collision with root package name */
    public final n f14985m;

    /* renamed from: n  reason: collision with root package name */
    public final AtomicBoolean f14986n = new AtomicBoolean();

    /* renamed from: o  reason: collision with root package name */
    public Object f14987o;

    /* renamed from: p  reason: collision with root package name */
    public h f14988p;

    /* renamed from: q  reason: collision with root package name */
    public r f14989q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f14990r;

    /* renamed from: s  reason: collision with root package name */
    public g f14991s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f14992t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f14993u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f14994v = true;

    /* renamed from: w  reason: collision with root package name */
    public volatile boolean f14995w;

    /* renamed from: x  reason: collision with root package name */
    public volatile g f14996x;

    /* renamed from: y  reason: collision with root package name */
    public final CopyOnWriteArrayList f14997y = new CopyOnWriteArrayList();

    public o(f1 f1Var, j1 j1Var, boolean z10) {
        j.f("client", f1Var);
        j.f("originalRequest", j1Var);
        this.f14980h = f1Var;
        this.f14981i = j1Var;
        this.f14982j = z10;
        this.f14983k = f1Var.f12821b.f12933a;
        g0 g0Var = (g0) f1Var.f12824e.f5295i;
        p0 p0Var = h.f13493a;
        j.f("$this_asFactory", g0Var);
        this.f14984l = g0Var;
        n nVar = new n(this);
        nVar.g((long) f1Var.f12843x, TimeUnit.MILLISECONDS);
        this.f14985m = nVar;
    }

    public static final String a(o oVar) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        if (oVar.f14995w) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (oVar.f14982j) {
            str2 = "web socket";
        } else {
            str2 = "call";
        }
        sb2.append(str2);
        sb2.append(" to ");
        sb2.append(oVar.f14981i.f12884a.g());
        return sb2.toString();
    }

    public final void b(r rVar) {
        boolean z10;
        p0 p0Var = h.f13493a;
        if (this.f14989q == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f14989q = rVar;
            rVar.f15018r.add(new m(this, this.f14987o));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final IOException c(IOException iOException) {
        IOException iOException2;
        g0 g0Var;
        Socket j10;
        boolean z10;
        p0 p0Var = h.f13493a;
        r rVar = this.f14989q;
        if (rVar != null) {
            synchronized (rVar) {
                j10 = j();
            }
            if (this.f14989q == null) {
                if (j10 != null) {
                    h.c(j10);
                }
                this.f14984l.getClass();
            } else {
                if (j10 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (!this.f14990r && this.f14985m.j()) {
            iOException2 = new InterruptedIOException("timeout");
            if (iOException != null) {
                iOException2.initCause(iOException);
            }
        } else {
            iOException2 = iOException;
        }
        if (iOException != null) {
            g0Var = this.f14984l;
            j.c(iOException2);
        } else {
            g0Var = this.f14984l;
        }
        g0Var.getClass();
        return iOException2;
    }

    public final void cancel() {
        if (!this.f14995w) {
            this.f14995w = true;
            g gVar = this.f14996x;
            if (gVar != null) {
                gVar.f14963d.cancel();
            }
            Iterator it = this.f14997y.iterator();
            while (it.hasNext()) {
                ((z) it.next()).cancel();
            }
            this.f14984l.getClass();
        }
    }

    public final Object clone() {
        return new o(this.f14980h, this.f14981i, this.f14982j);
    }

    public final void d(pb.j jVar) {
        l lVar;
        j.f("responseCallback", jVar);
        if (this.f14986n.compareAndSet(false, true)) {
            s.f16851a.getClass();
            this.f14987o = s.f16852b.g();
            this.f14984l.getClass();
            a0 a0Var = this.f14980h.f12820a;
            l lVar2 = new l(this, jVar);
            a0Var.getClass();
            synchronized (a0Var) {
                a0Var.f12769d.add(lVar2);
                o oVar = lVar2.f14977j;
                if (!oVar.f14982j) {
                    String str = oVar.f14981i.f12884a.f12992d;
                    Iterator it = a0Var.f12770e.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            Iterator it2 = a0Var.f12769d.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    lVar = null;
                                    break;
                                }
                                lVar = (l) it2.next();
                                if (j.a(lVar.f14977j.f14981i.f12884a.f12992d, str)) {
                                    break;
                                }
                            }
                        } else {
                            lVar = (l) it.next();
                            if (j.a(lVar.f14977j.f14981i.f12884a.f12992d, str)) {
                                break;
                            }
                        }
                    }
                    if (lVar != null) {
                        lVar2.f14976i = lVar.f14976i;
                    }
                }
                v vVar = v.f9814a;
            }
            a0Var.d();
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final r1 e() {
        if (this.f14986n.compareAndSet(false, true)) {
            this.f14985m.i();
            s.f16851a.getClass();
            this.f14987o = s.f16852b.g();
            this.f14984l.getClass();
            try {
                a0 a0Var = this.f14980h.f12820a;
                synchronized (a0Var) {
                    a0Var.f12771f.add(this);
                }
                r1 g10 = g();
                this.f14980h.f12820a.c(this);
                return g10;
            } catch (Throwable th) {
                this.f14980h.f12820a.c(this);
                throw th;
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    public final void f(boolean z10) {
        g gVar;
        synchronized (this) {
            if (this.f14994v) {
                v vVar = v.f9814a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z10 && (gVar = this.f14996x) != null) {
            gVar.f14963d.cancel();
            gVar.f14960a.h(gVar, true, true, (IOException) null);
        }
        this.f14991s = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final pb.r1 g() {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            pb.f1 r0 = r10.f14980h
            java.util.List r0 = r0.f12822c
            ma.w.k(r0, r2)
            ub.l r0 = new ub.l
            pb.f1 r1 = r10.f14980h
            r0.<init>(r1)
            r2.add(r0)
            ub.a r0 = new ub.a
            pb.f1 r1 = r10.f14980h
            pb.z r1 = r1.f12830k
            r0.<init>(r1)
            r2.add(r0)
            rb.b r0 = new rb.b
            pb.f1 r1 = r10.f14980h
            r1.getClass()
            r0.<init>()
            r2.add(r0)
            tb.a r0 = tb.a.f14918a
            r2.add(r0)
            boolean r0 = r10.f14982j
            if (r0 != 0) goto L_0x003f
            pb.f1 r0 = r10.f14980h
            java.util.List r0 = r0.f12823d
            ma.w.k(r0, r2)
        L_0x003f:
            ub.b r0 = new ub.b
            boolean r1 = r10.f14982j
            r0.<init>(r1)
            r2.add(r0)
            ub.i r9 = new ub.i
            r3 = 0
            r4 = 0
            pb.j1 r5 = r10.f14981i
            pb.f1 r0 = r10.f14980h
            int r6 = r0.f12844y
            int r7 = r0.f12845z
            int r8 = r0.A
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            pb.j1 r1 = r10.f14981i     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            pb.r1 r1 = r9.b(r1)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            boolean r2 = r10.f14995w     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            if (r2 != 0) goto L_0x006b
            r10.i(r0)
            return r1
        L_0x006b:
            qb.f.b(r1)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            java.lang.String r2 = "Canceled"
            r1.<init>(r2)     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
            throw r1     // Catch:{ IOException -> 0x0079, all -> 0x0076 }
        L_0x0076:
            r1 = move-exception
            r2 = 0
            goto L_0x0086
        L_0x0079:
            r1 = move-exception
            java.io.IOException r1 = r10.i(r1)     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Throwable"
            xa.j.d(r2, r1)     // Catch:{ all -> 0x0084 }
            throw r1     // Catch:{ all -> 0x0084 }
        L_0x0084:
            r1 = move-exception
            r2 = 1
        L_0x0086:
            if (r2 != 0) goto L_0x008b
            r10.i(r0)
        L_0x008b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o.g():pb.r1");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[Catch:{ all -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.IOException h(tb.g r2, boolean r3, boolean r4, java.io.IOException r5) {
        /*
            r1 = this;
            java.lang.String r0 = "exchange"
            xa.j.f(r0, r2)
            tb.g r0 = r1.f14996x
            boolean r2 = xa.j.a(r2, r0)
            if (r2 != 0) goto L_0x000e
            return r5
        L_0x000e:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L_0x0019
            boolean r0 = r1.f14992t     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x001f
            goto L_0x0019
        L_0x0017:
            r2 = move-exception
            goto L_0x0059
        L_0x0019:
            if (r4 == 0) goto L_0x0041
            boolean r0 = r1.f14993u     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0041
        L_0x001f:
            if (r3 == 0) goto L_0x0023
            r1.f14992t = r2     // Catch:{ all -> 0x0017 }
        L_0x0023:
            if (r4 == 0) goto L_0x0027
            r1.f14993u = r2     // Catch:{ all -> 0x0017 }
        L_0x0027:
            boolean r3 = r1.f14992t     // Catch:{ all -> 0x0017 }
            r4 = 1
            if (r3 != 0) goto L_0x0032
            boolean r0 = r1.f14993u     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.f14993u     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.f14994v     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            r2 = 1
        L_0x003e:
            r3 = r2
            r2 = r0
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            la.v r4 = la.v.f9814a     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0051
            r2 = 0
            r1.f14996x = r2
            tb.r r2 = r1.f14989q
            if (r2 == 0) goto L_0x0051
            r2.d()
        L_0x0051:
            if (r3 == 0) goto L_0x0058
            java.io.IOException r2 = r1.c(r5)
            return r2
        L_0x0058:
            return r5
        L_0x0059:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o.h(tb.g, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException i(IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.f14994v) {
                this.f14994v = false;
                if (!this.f14992t && !this.f14993u) {
                    z10 = true;
                }
            }
            v vVar = v.f9814a;
        }
        return z10 ? c(iOException) : iOException;
    }

    public final Socket j() {
        boolean z10;
        r rVar = this.f14989q;
        j.c(rVar);
        p0 p0Var = h.f13493a;
        ArrayList arrayList = rVar.f15018r;
        Iterator it = arrayList.iterator();
        boolean z11 = false;
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (j.a(((Reference) it.next()).get(), this)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            arrayList.remove(i10);
            this.f14989q = null;
            if (arrayList.isEmpty()) {
                rVar.f15019s = System.nanoTime();
                u uVar = this.f14983k;
                uVar.getClass();
                p0 p0Var2 = h.f13493a;
                boolean z12 = rVar.f15012l;
                c cVar = uVar.f15024c;
                if (z12 || uVar.f15022a == 0) {
                    rVar.f15012l = true;
                    ConcurrentLinkedQueue concurrentLinkedQueue = uVar.f15026e;
                    concurrentLinkedQueue.remove(rVar);
                    if (concurrentLinkedQueue.isEmpty()) {
                        cVar.a();
                    }
                    z11 = true;
                } else {
                    cVar.d(uVar.f15025d, 0);
                }
                if (z11) {
                    Socket socket = rVar.f15005e;
                    j.c(socket);
                    return socket;
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
