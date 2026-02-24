package sb;

import java.util.ArrayList;
import java.util.logging.Logger;
import la.v;
import pb.p0;
import qb.f;
import qb.h;
import xa.j;

public final class g {

    /* renamed from: i  reason: collision with root package name */
    public static final Logger f14471i;

    /* renamed from: j  reason: collision with root package name */
    public static final g f14472j;

    /* renamed from: a  reason: collision with root package name */
    public final e f14473a;

    /* renamed from: b  reason: collision with root package name */
    public final Logger f14474b;

    /* renamed from: c  reason: collision with root package name */
    public int f14475c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14476d;

    /* renamed from: e  reason: collision with root package name */
    public long f14477e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f14478f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f14479g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final f f14480h = new f(this);

    static {
        new d(0);
        Logger logger = Logger.getLogger(g.class.getName());
        j.e("getLogger(TaskRunner::class.java.name)", logger);
        f14471i = logger;
        String str = h.f13495c + " TaskRunner";
        j.f("name", str);
        f14472j = new g(new e(new qb.g(str, true)));
    }

    public g(e eVar) {
        Logger logger = f14471i;
        j.f("logger", logger);
        this.f14473a = eVar;
        this.f14474b = logger;
    }

    public static final void a(g gVar, a aVar) {
        gVar.getClass();
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(aVar.f14457a);
        try {
            long a10 = aVar.a();
            synchronized (gVar) {
                gVar.b(aVar, a10);
                v vVar = v.f9814a;
            }
            currentThread.setName(name);
        } catch (Throwable th) {
            synchronized (gVar) {
                gVar.b(aVar, -1);
                v vVar2 = v.f9814a;
                currentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(a aVar, long j10) {
        boolean z10;
        p0 p0Var = h.f13493a;
        c cVar = aVar.f14459c;
        j.c(cVar);
        if (cVar.f14466d == aVar) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            boolean z11 = cVar.f14468f;
            cVar.f14468f = false;
            cVar.f14466d = null;
            this.f14478f.remove(cVar);
            if (j10 != -1 && !z11 && !cVar.f14465c) {
                cVar.e(aVar, j10, true);
            }
            if (!cVar.f14467e.isEmpty()) {
                this.f14479g.add(cVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final sb.a c() {
        /*
            r16 = this;
            r1 = r16
            pb.p0 r0 = qb.h.f13493a
        L_0x0004:
            java.util.ArrayList r0 = r1.f14479g
            boolean r2 = r0.isEmpty()
            r3 = 0
            if (r2 == 0) goto L_0x000e
            return r3
        L_0x000e:
            sb.e r2 = r1.f14473a
            r2.getClass()
            long r4 = java.lang.System.nanoTime()
            java.util.Iterator r6 = r0.iterator()
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r9 = r3
        L_0x0021:
            boolean r10 = r6.hasNext()
            r12 = 0
            r13 = 0
            if (r10 == 0) goto L_0x004e
            java.lang.Object r10 = r6.next()
            sb.c r10 = (sb.c) r10
            java.util.ArrayList r10 = r10.f14467e
            java.lang.Object r10 = r10.get(r12)
            sb.a r10 = (sb.a) r10
            long r11 = r10.f14460d
            long r11 = r11 - r4
            long r11 = java.lang.Math.max(r13, r11)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x0048
            long r7 = java.lang.Math.min(r11, r7)
            goto L_0x0021
        L_0x0048:
            if (r9 == 0) goto L_0x004c
            r6 = 1
            goto L_0x004f
        L_0x004c:
            r9 = r10
            goto L_0x0021
        L_0x004e:
            r6 = 0
        L_0x004f:
            if (r9 == 0) goto L_0x0086
            pb.p0 r3 = qb.h.f13493a
            r3 = -1
            r9.f14460d = r3
            sb.c r3 = r9.f14459c
            xa.j.c(r3)
            java.util.ArrayList r4 = r3.f14467e
            r4.remove(r9)
            r0.remove(r3)
            r3.f14466d = r9
            java.util.ArrayList r4 = r1.f14478f
            r4.add(r3)
            if (r6 != 0) goto L_0x0079
            boolean r3 = r1.f14476d
            if (r3 != 0) goto L_0x0085
            boolean r0 = r0.isEmpty()
            r3 = 1
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0085
        L_0x0079:
            java.lang.String r0 = "runnable"
            sb.f r3 = r1.f14480h
            xa.j.f(r0, r3)
            java.util.concurrent.ThreadPoolExecutor r0 = r2.f14469a
            r0.execute(r3)
        L_0x0085:
            return r9
        L_0x0086:
            boolean r0 = r1.f14476d
            if (r0 == 0) goto L_0x0095
            long r9 = r1.f14477e
            long r9 = r9 - r4
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x0094
            r16.notify()
        L_0x0094:
            return r3
        L_0x0095:
            r0 = 1
            r1.f14476d = r0
            long r4 = r4 + r7
            r1.f14477e = r4
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r7 / r2
            java.lang.Long.signum(r4)
            long r2 = r2 * r4
            long r2 = r7 - r2
            int r0 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x00af
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ba
        L_0x00af:
            int r0 = (int) r2
            r1.wait(r4, r0)     // Catch:{ InterruptedException -> 0x00b7 }
            goto L_0x00ba
        L_0x00b4:
            r0 = move-exception
            r2 = 0
            goto L_0x00bf
        L_0x00b7:
            r16.d()     // Catch:{ all -> 0x00b4 }
        L_0x00ba:
            r2 = 0
            r1.f14476d = r2
            goto L_0x0004
        L_0x00bf:
            r1.f14476d = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.g.c():sb.a");
    }

    public final void d() {
        p0 p0Var = h.f13493a;
        ArrayList arrayList = this.f14478f;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            ((c) arrayList.get(size)).b();
        }
        ArrayList arrayList2 = this.f14479g;
        for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
            c cVar = (c) arrayList2.get(size2);
            cVar.b();
            if (cVar.f14467e.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
    }

    public final void e(c cVar) {
        j.f("taskQueue", cVar);
        p0 p0Var = h.f13493a;
        if (cVar.f14466d == null) {
            boolean z10 = !cVar.f14467e.isEmpty();
            ArrayList arrayList = this.f14479g;
            if (z10) {
                byte[] bArr = f.f13487a;
                j.f("<this>", arrayList);
                if (!arrayList.contains(cVar)) {
                    arrayList.add(cVar);
                }
            } else {
                arrayList.remove(cVar);
            }
        }
        boolean z11 = this.f14476d;
        e eVar = this.f14473a;
        eVar.getClass();
        if (z11) {
            notify();
            return;
        }
        f fVar = this.f14480h;
        j.f("runnable", fVar);
        eVar.f14469a.execute(fVar);
    }

    public final c f() {
        int i10;
        synchronized (this) {
            i10 = this.f14475c;
            this.f14475c = i10 + 1;
        }
        return new c(this, android.support.v4.media.h.i("Q", i10));
    }
}
