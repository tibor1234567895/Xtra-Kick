package u9;

import android.content.Context;
import android.content.IntentFilter;
import androidx.activity.h;
import g.g0;
import la.v;
import p9.p;
import p9.s;
import s9.b;
import w9.a;
import xa.j;
import y9.l;
import z5.i;

public final class f implements c {

    /* renamed from: h  reason: collision with root package name */
    public final Object f15447h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public volatile p f15448i = p.GLOBAL_OFF;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f15449j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f15450k = true;

    /* renamed from: l  reason: collision with root package name */
    public volatile long f15451l = 500;

    /* renamed from: m  reason: collision with root package name */
    public final e f15452m;

    /* renamed from: n  reason: collision with root package name */
    public final g0 f15453n;

    /* renamed from: o  reason: collision with root package name */
    public final h f15454o;

    /* renamed from: p  reason: collision with root package name */
    public final y9.p f15455p;

    /* renamed from: q  reason: collision with root package name */
    public final a f15456q;

    /* renamed from: r  reason: collision with root package name */
    public final b f15457r;

    /* renamed from: s  reason: collision with root package name */
    public final a f15458s;

    /* renamed from: t  reason: collision with root package name */
    public final l f15459t;

    /* renamed from: u  reason: collision with root package name */
    public final i f15460u;

    /* renamed from: v  reason: collision with root package name */
    public volatile int f15461v;

    /* renamed from: w  reason: collision with root package name */
    public final Context f15462w;

    /* renamed from: x  reason: collision with root package name */
    public final String f15463x;

    /* renamed from: y  reason: collision with root package name */
    public final s f15464y;

    static {
        new d(0);
    }

    public f(y9.p pVar, a aVar, b bVar, a aVar2, l lVar, i iVar, int i10, Context context, String str, s sVar) {
        j.g("handlerWrapper", pVar);
        j.g("downloadProvider", aVar);
        j.g("logger", lVar);
        j.g("listenerCoordinator", iVar);
        j.g("context", context);
        j.g("namespace", str);
        j.g("prioritySort", sVar);
        this.f15455p = pVar;
        this.f15456q = aVar;
        this.f15457r = bVar;
        this.f15458s = aVar2;
        this.f15459t = lVar;
        this.f15460u = iVar;
        this.f15461v = i10;
        this.f15462w = context;
        this.f15463x = str;
        this.f15464y = sVar;
        e eVar = new e(this);
        this.f15452m = eVar;
        g0 g0Var = new g0(7, this);
        this.f15453n = g0Var;
        synchronized (aVar2.f16171a) {
            aVar2.f16172b.add(eVar);
        }
        context.registerReceiver(g0Var, new IntentFilter("com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET"));
        this.f15454o = new h(19, this);
    }

    public static final boolean c(f fVar) {
        if (fVar.f15450k || fVar.f15449j) {
            return false;
        }
        return true;
    }

    public final void close() {
        synchronized (this.f15447h) {
            this.f15458s.d(this.f15452m);
            this.f15462w.unregisterReceiver(this.f15453n);
            v vVar = v.f9814a;
        }
    }

    public final void e() {
        if (this.f15461v > 0) {
            y9.p pVar = this.f15455p;
            h hVar = this.f15454o;
            long j10 = this.f15451l;
            pVar.getClass();
            j.g("runnable", hVar);
            synchronized (pVar.f17276a) {
                if (!pVar.f17277b) {
                    pVar.f17279d.postDelayed(hVar, j10);
                }
                v vVar = v.f9814a;
            }
        }
    }

    public final void k() {
        synchronized (this.f15447h) {
            this.f15451l = 500;
            if (this.f15461v > 0) {
                this.f15455p.e(this.f15454o);
            }
            e();
            l lVar = this.f15459t;
            lVar.a("PriorityIterator backoffTime reset to " + this.f15451l + " milliseconds");
            v vVar = v.f9814a;
        }
    }

    public final void v() {
        synchronized (this.f15447h) {
            k();
            this.f15449j = false;
            this.f15450k = false;
            e();
            this.f15459t.a("PriorityIterator resumed");
            v vVar = v.f9814a;
        }
    }

    public final void w() {
        synchronized (this.f15447h) {
            k();
            this.f15450k = false;
            this.f15449j = false;
            e();
            this.f15459t.a("PriorityIterator started");
            v vVar = v.f9814a;
        }
    }

    public final void z() {
        synchronized (this.f15447h) {
            if (this.f15461v > 0) {
                this.f15455p.e(this.f15454o);
            }
            this.f15449j = false;
            this.f15450k = true;
            this.f15457r.k();
            this.f15459t.a("PriorityIterator stop");
            v vVar = v.f9814a;
        }
    }
}
