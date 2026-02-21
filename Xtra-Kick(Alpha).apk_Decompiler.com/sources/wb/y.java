package wb;

import dc.n;
import dc.n0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import la.v;
import pb.f1;
import pb.h1;
import pb.j1;
import pb.p0;
import pb.r1;
import pb.t0;
import qb.h;
import tb.r;
import ub.e;
import ub.f;
import ub.g;
import ub.i;
import ub.j;

public final class y implements f {

    /* renamed from: g  reason: collision with root package name */
    public static final x f16331g = new x(0);

    /* renamed from: h  reason: collision with root package name */
    public static final List f16332h = h.g("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: i  reason: collision with root package name */
    public static final List f16333i = h.g("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a  reason: collision with root package name */
    public final e f16334a;

    /* renamed from: b  reason: collision with root package name */
    public final i f16335b;

    /* renamed from: c  reason: collision with root package name */
    public final v f16336c;

    /* renamed from: d  reason: collision with root package name */
    public volatile g0 f16337d;

    /* renamed from: e  reason: collision with root package name */
    public final h1 f16338e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f16339f;

    public y(f1 f1Var, r rVar, i iVar, v vVar) {
        this.f16334a = rVar;
        this.f16335b = iVar;
        this.f16336c = vVar;
        h1 h1Var = h1.H2_PRIOR_KNOWLEDGE;
        this.f16338e = !f1Var.f12839t.contains(h1Var) ? h1.HTTP_2 : h1Var;
    }

    public final long a(r1 r1Var) {
        if (!g.a(r1Var)) {
            return 0;
        }
        return h.f(r1Var);
    }

    public final void b(j1 j1Var) {
        boolean z10;
        int i10;
        g0 g0Var;
        if (this.f16337d == null) {
            boolean z11 = false;
            if (j1Var.f12887d != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            f16331g.getClass();
            p0 p0Var = j1Var.f12886c;
            ArrayList arrayList = new ArrayList((p0Var.f12931h.length / 2) + 4);
            arrayList.add(new e(e.f16206f, j1Var.f12885b));
            n nVar = e.f16207g;
            j jVar = j.f15481a;
            t0 t0Var = j1Var.f12884a;
            jVar.getClass();
            arrayList.add(new e(nVar, j.a(t0Var)));
            String b10 = j1Var.b("Host");
            if (b10 != null) {
                arrayList.add(new e(e.f16209i, b10));
            }
            arrayList.add(new e(e.f16208h, t0Var.f12989a));
            int length = p0Var.f12931h.length / 2;
            for (int i11 = 0; i11 < length; i11++) {
                String c10 = p0Var.c(i11);
                Locale locale = Locale.US;
                xa.j.e("US", locale);
                String lowerCase = c10.toLowerCase(locale);
                xa.j.e("this as java.lang.String).toLowerCase(locale)", lowerCase);
                if (!f16332h.contains(lowerCase) || (xa.j.a(lowerCase, "te") && xa.j.a(p0Var.f(i11), "trailers"))) {
                    arrayList.add(new e(lowerCase, p0Var.f(i11)));
                }
            }
            v vVar = this.f16336c;
            vVar.getClass();
            boolean z12 = !z10;
            synchronized (vVar.F) {
                synchronized (vVar) {
                    if (vVar.f16316m > 1073741823) {
                        vVar.z(c.REFUSED_STREAM);
                    }
                    if (!vVar.f16317n) {
                        i10 = vVar.f16316m;
                        vVar.f16316m = i10 + 2;
                        g0Var = new g0(i10, vVar, z12, false, (p0) null);
                        if (!z10 || vVar.C >= vVar.D || g0Var.f16242e >= g0Var.f16243f) {
                            z11 = true;
                        }
                        if (g0Var.i()) {
                            vVar.f16313j.put(Integer.valueOf(i10), g0Var);
                        }
                        v vVar2 = v.f9814a;
                    } else {
                        throw new a();
                    }
                }
                vVar.F.w(i10, arrayList, z12);
            }
            if (z11) {
                vVar.F.flush();
            }
            this.f16337d = g0Var;
            if (!this.f16339f) {
                g0 g0Var2 = this.f16337d;
                xa.j.c(g0Var2);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                g0Var2.f16248k.g((long) this.f16335b.f15478g, timeUnit);
                g0 g0Var3 = this.f16337d;
                xa.j.c(g0Var3);
                g0Var3.f16249l.g((long) this.f16335b.f15479h, timeUnit);
                return;
            }
            g0 g0Var4 = this.f16337d;
            xa.j.c(g0Var4);
            g0Var4.e(c.CANCEL);
            throw new IOException("Canceled");
        }
    }

    public final void c() {
        g0 g0Var = this.f16337d;
        xa.j.c(g0Var);
        g0Var.g().close();
    }

    public final void cancel() {
        this.f16339f = true;
        g0 g0Var = this.f16337d;
        if (g0Var != null) {
            g0Var.e(c.CANCEL);
        }
    }

    public final void d() {
        this.f16336c.flush();
    }

    public final e e() {
        return this.f16334a;
    }

    public final dc.p0 f(r1 r1Var) {
        g0 g0Var = this.f16337d;
        xa.j.c(g0Var);
        return g0Var.f16246i;
    }

    public final p0 g() {
        p0 p0Var;
        g0 g0Var = this.f16337d;
        xa.j.c(g0Var);
        synchronized (g0Var) {
            e0 e0Var = g0Var.f16246i;
            if (e0Var.f16214i && e0Var.f16215j.R() && g0Var.f16246i.f16216k.R()) {
                p0Var = g0Var.f16246i.f16217l;
                if (p0Var == null) {
                    p0Var = h.f13493a;
                }
            } else if (g0Var.f16250m != null) {
                Throwable th = g0Var.f16251n;
                if (th == null) {
                    c cVar = g0Var.f16250m;
                    xa.j.c(cVar);
                    th = new q0(cVar);
                }
                throw th;
            } else {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
        }
        return p0Var;
    }

    public final n0 h(j1 j1Var, long j10) {
        g0 g0Var = this.f16337d;
        xa.j.c(g0Var);
        return g0Var.g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        if (r1 == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003e, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003f, code lost:
        if (r2 != 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        r0.f16248k.m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0046, code lost:
        throw r11;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final pb.q1 i(boolean r11) {
        /*
            r10 = this;
            wb.g0 r0 = r10.f16337d
            if (r0 == 0) goto L_0x00ef
            monitor-enter(r0)
        L_0x0005:
            java.util.ArrayDeque r1 = r0.f16244g     // Catch:{ all -> 0x00ec }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00ec }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0047
            wb.c r1 = r0.f16250m     // Catch:{ all -> 0x00ec }
            if (r1 != 0) goto L_0x0047
            if (r11 != 0) goto L_0x002b
            wb.v r1 = r0.f16239b     // Catch:{ all -> 0x00ec }
            boolean r1 = r1.f16311h     // Catch:{ all -> 0x00ec }
            if (r1 == 0) goto L_0x0028
            wb.d0 r1 = r0.f16247j     // Catch:{ all -> 0x00ec }
            boolean r4 = r1.f16202j     // Catch:{ all -> 0x00ec }
            if (r4 != 0) goto L_0x0028
            boolean r1 = r1.f16200h     // Catch:{ all -> 0x00ec }
            if (r1 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = 0
            goto L_0x0029
        L_0x0028:
            r1 = 1
        L_0x0029:
            if (r1 == 0) goto L_0x002c
        L_0x002b:
            r2 = 1
        L_0x002c:
            if (r2 == 0) goto L_0x0033
            wb.f0 r1 = r0.f16248k     // Catch:{ all -> 0x00ec }
            r1.i()     // Catch:{ all -> 0x00ec }
        L_0x0033:
            r0.l()     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0005
            wb.f0 r1 = r0.f16248k     // Catch:{ all -> 0x00ec }
            r1.m()     // Catch:{ all -> 0x00ec }
            goto L_0x0005
        L_0x003e:
            r11 = move-exception
            if (r2 == 0) goto L_0x0046
            wb.f0 r1 = r0.f16248k     // Catch:{ all -> 0x00ec }
            r1.m()     // Catch:{ all -> 0x00ec }
        L_0x0046:
            throw r11     // Catch:{ all -> 0x00ec }
        L_0x0047:
            java.util.ArrayDeque r1 = r0.f16244g     // Catch:{ all -> 0x00ec }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00ec }
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x00dc
            java.util.ArrayDeque r1 = r0.f16244g     // Catch:{ all -> 0x00ec }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "headersQueue.removeFirst()"
            xa.j.e(r3, r1)     // Catch:{ all -> 0x00ec }
            pb.p0 r1 = (pb.p0) r1     // Catch:{ all -> 0x00ec }
            monitor-exit(r0)
            wb.x r0 = f16331g
            pb.h1 r3 = r10.f16338e
            r0.getClass()
            java.lang.String r0 = "protocol"
            xa.j.f(r0, r3)
            pb.n0 r0 = new pb.n0
            r0.<init>()
            java.lang.String[] r4 = r1.f12931h
            int r4 = r4.length
            int r4 = r4 / 2
            r5 = 0
            r6 = r5
        L_0x0076:
            if (r2 >= r4) goto L_0x00a6
            java.lang.String r7 = r1.c(r2)
            java.lang.String r8 = r1.f(r2)
            java.lang.String r9 = ":status"
            boolean r9 = xa.j.a(r7, r9)
            if (r9 == 0) goto L_0x0098
            ub.m r6 = ub.n.f15483d
            java.lang.String r7 = "HTTP/1.1 "
            java.lang.String r7 = r7.concat(r8)
            r6.getClass()
            ub.n r6 = ub.m.a(r7)
            goto L_0x00a3
        L_0x0098:
            java.util.List r9 = f16333i
            boolean r9 = r9.contains(r7)
            if (r9 != 0) goto L_0x00a3
            hb.h0.C(r0, r7, r8)
        L_0x00a3:
            int r2 = r2 + 1
            goto L_0x0076
        L_0x00a6:
            if (r6 == 0) goto L_0x00d4
            pb.q1 r1 = new pb.q1
            r1.<init>()
            r1.d(r3)
            int r2 = r6.f15485b
            r1.f12936c = r2
            java.lang.String r2 = r6.f15486c
            r1.c(r2)
            pb.p0 r0 = r0.b()
            r1.b(r0)
            wb.w r0 = wb.w.f16330h
            java.lang.String r2 = "trailersFn"
            xa.j.f(r2, r0)
            r1.f12947n = r0
            if (r11 == 0) goto L_0x00d2
            int r11 = r1.f12936c
            r0 = 100
            if (r11 != r0) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r5 = r1
        L_0x00d3:
            return r5
        L_0x00d4:
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r0 = "Expected ':status' header not present"
            r11.<init>(r0)
            throw r11
        L_0x00dc:
            java.io.IOException r11 = r0.f16251n     // Catch:{ all -> 0x00ec }
            if (r11 == 0) goto L_0x00e1
            goto L_0x00eb
        L_0x00e1:
            wb.q0 r11 = new wb.q0     // Catch:{ all -> 0x00ec }
            wb.c r1 = r0.f16250m     // Catch:{ all -> 0x00ec }
            xa.j.c(r1)     // Catch:{ all -> 0x00ec }
            r11.<init>(r1)     // Catch:{ all -> 0x00ec }
        L_0x00eb:
            throw r11     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        L_0x00ef:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "stream wasn't created"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: wb.y.i(boolean):pb.q1");
    }
}
