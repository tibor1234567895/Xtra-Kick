package r3;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import g.s0;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import la.v;
import ma.b0;
import ma.d0;
import ma.j0;
import u3.f;
import u3.l;
import u3.n;
import v3.d;
import xa.j;

public abstract class n0 {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f13717n = 0;

    /* renamed from: a  reason: collision with root package name */
    public volatile f f13718a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f13719b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f13720c;

    /* renamed from: d  reason: collision with root package name */
    public l f13721d;

    /* renamed from: e  reason: collision with root package name */
    public final y f13722e = e();

    /* renamed from: f  reason: collision with root package name */
    public boolean f13723f;

    /* renamed from: g  reason: collision with root package name */
    public List f13724g;

    /* renamed from: h  reason: collision with root package name */
    public final LinkedHashMap f13725h = new LinkedHashMap();

    /* renamed from: i  reason: collision with root package name */
    public final ReentrantReadWriteLock f13726i = new ReentrantReadWriteLock();

    /* renamed from: j  reason: collision with root package name */
    public b f13727j;

    /* renamed from: k  reason: collision with root package name */
    public final ThreadLocal f13728k = new ThreadLocal();

    /* renamed from: l  reason: collision with root package name */
    public final Map f13729l;

    /* renamed from: m  reason: collision with root package name */
    public final LinkedHashMap f13730m;

    static {
        new k0(0);
    }

    public n0() {
        Map synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        j.e("synchronizedMap(mutableMapOf())", synchronizedMap);
        this.f13729l = synchronizedMap;
        this.f13730m = new LinkedHashMap();
    }

    public static Object s(Class cls, l lVar) {
        if (cls.isInstance(lVar)) {
            return lVar;
        }
        if (lVar instanceof k) {
            return s(cls, ((k) lVar).d());
        }
        return null;
    }

    public final void a() {
        boolean z10;
        if (!this.f13723f) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!(!z10)) {
                throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
            }
        }
    }

    public final void b() {
        if (!(l() || this.f13728k.get() == null)) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
        }
    }

    public final void c() {
        a();
        b bVar = this.f13727j;
        if (bVar == null) {
            m();
        } else {
            bVar.a(new m0(this, 0));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r2 = this;
            r3.b r0 = r2.f13727j
            if (r0 == 0) goto L_0x000b
            r1 = 0
            r0.getClass()
            r0 = r1 ^ 1
            goto L_0x0013
        L_0x000b:
            u3.f r0 = r2.f13718a
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.isOpen()
        L_0x0013:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0044
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r2.f13726i
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            java.lang.String r1 = "readWriteLock.writeLock()"
            xa.j.e(r1, r0)
            r0.lock()
            r3.y r1 = r2.f13722e     // Catch:{ all -> 0x003f }
            r1.g()     // Catch:{ all -> 0x003f }
            u3.l r1 = r2.i()     // Catch:{ all -> 0x003f }
            r1.close()     // Catch:{ all -> 0x003f }
            r0.unlock()
            goto L_0x0044
        L_0x003f:
            r1 = move-exception
            r0.unlock()
            throw r1
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.n0.d():void");
    }

    public abstract y e();

    public abstract l f(j jVar);

    public final void g() {
        b bVar = this.f13727j;
        if (bVar == null) {
            n();
        } else {
            bVar.a(new m0(this, 1));
        }
    }

    public List h(LinkedHashMap linkedHashMap) {
        j.f("autoMigrationSpecs", linkedHashMap);
        return b0.f10801h;
    }

    public final l i() {
        l lVar = this.f13721d;
        if (lVar != null) {
            return lVar;
        }
        j.l("internalOpenHelper");
        throw null;
    }

    public Set j() {
        return d0.f10804h;
    }

    public Map k() {
        return j0.d();
    }

    public final boolean l() {
        return i().x0().U();
    }

    public final void m() {
        a();
        f x02 = i().x0();
        this.f13722e.i(x02);
        if (x02.c0()) {
            x02.n0();
        } else {
            x02.h();
        }
    }

    public final void n() {
        i().x0().g();
        if (!l()) {
            y yVar = this.f13722e;
            if (!yVar.f13781g.compareAndSet(false, true)) {
                return;
            }
            if (yVar.f13780f == null) {
                Executor executor = yVar.f13775a.f13719b;
                if (executor != null) {
                    executor.execute(yVar.f13790p);
                } else {
                    j.l("internalQueryExecutor");
                    throw null;
                }
            } else {
                throw null;
            }
        }
    }

    public final void o(d dVar) {
        y yVar = this.f13722e;
        yVar.getClass();
        synchronized (yVar.f13789o) {
            if (yVar.f13782h) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
            } else {
                dVar.p("PRAGMA temp_store = MEMORY;");
                dVar.p("PRAGMA recursive_triggers='ON';");
                dVar.p("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                yVar.i(dVar);
                yVar.f13783i = dVar.y("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
                yVar.f13782h = true;
                v vVar = v.f9814a;
            }
        }
    }

    public final boolean p() {
        f fVar = this.f13718a;
        return fVar != null && fVar.isOpen();
    }

    public final Cursor q(n nVar, CancellationSignal cancellationSignal) {
        j.f("query", nVar);
        a();
        b();
        return cancellationSignal != null ? i().x0().t0(nVar, cancellationSignal) : i().x0().T(nVar);
    }

    public final void r() {
        i().x0().h0();
    }
}
