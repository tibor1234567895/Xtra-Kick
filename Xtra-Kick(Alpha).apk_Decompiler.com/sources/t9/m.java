package t9;

import android.os.Handler;
import androidx.fragment.app.y;
import java.util.LinkedHashSet;
import java.util.List;
import la.v;
import p9.a;
import p9.h;
import p9.j;
import y9.l;
import y9.p;
import z5.i;

public final class m implements h {

    /* renamed from: n  reason: collision with root package name */
    public static final c f14874n = new c(0);

    /* renamed from: b  reason: collision with root package name */
    public final Object f14875b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f14876c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashSet f14877d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public final e f14878e;

    /* renamed from: f  reason: collision with root package name */
    public final String f14879f;

    /* renamed from: g  reason: collision with root package name */
    public final j f14880g;

    /* renamed from: h  reason: collision with root package name */
    public final p f14881h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f14882i;

    /* renamed from: j  reason: collision with root package name */
    public final a f14883j;

    /* renamed from: k  reason: collision with root package name */
    public final l f14884k;

    /* renamed from: l  reason: collision with root package name */
    public final i f14885l;

    /* renamed from: m  reason: collision with root package name */
    public final q9.h f14886m;

    public m(String str, j jVar, p pVar, Handler handler, a aVar, l lVar, i iVar, q9.h hVar) {
        xa.j.g("namespace", str);
        xa.j.g("fetchConfiguration", jVar);
        xa.j.g("handlerWrapper", pVar);
        xa.j.g("uiHandler", handler);
        xa.j.g("fetchHandler", aVar);
        xa.j.g("logger", lVar);
        xa.j.g("listenerCoordinator", iVar);
        xa.j.g("fetchDatabaseManagerWrapper", hVar);
        this.f14879f = str;
        this.f14880g = jVar;
        this.f14881h = pVar;
        this.f14882i = handler;
        this.f14883j = aVar;
        this.f14884k = lVar;
        this.f14885l = iVar;
        this.f14886m = hVar;
        e eVar = new e(0, this);
        this.f14878e = eVar;
        pVar.d(new b(this, 0));
        long j10 = jVar.f12690o;
        synchronized (pVar.f17276a) {
            if (!pVar.f17277b) {
                pVar.f17279d.postDelayed(eVar, j10);
            }
            v vVar = v.f9814a;
        }
    }

    public final m a(a aVar) {
        synchronized (this.f14875b) {
            e();
            this.f14881h.d(new f(this, aVar));
        }
        return this;
    }

    public final void b(List list, i iVar, i iVar2) {
        synchronized (this.f14875b) {
            e();
            this.f14881h.d(new k(this, list, iVar, iVar2, 0));
            v vVar = v.f9814a;
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f14875b) {
            z10 = this.f14876c;
        }
        return z10;
    }

    public final m d(int i10) {
        Integer valueOf = Integer.valueOf(i10);
        synchronized (this.f14875b) {
            e();
            this.f14881h.d(new l(this, valueOf, 1));
            v vVar = v.f9814a;
        }
        return this;
    }

    public final void e() {
        if (this.f14876c) {
            throw new y("This fetch instance has been closed. Create a new instance using the builder.");
        }
    }
}
