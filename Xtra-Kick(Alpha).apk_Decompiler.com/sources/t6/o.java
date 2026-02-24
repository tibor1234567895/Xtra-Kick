package t6;

import e6.x;
import hb.c2;
import hb.f0;
import hb.h0;
import hb.p0;
import java.util.LinkedList;
import java.util.Timer;
import javax.inject.Inject;
import pa.e;
import t7.m;
import wa.a;
import xa.j;
import xa.r;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final a f14641a;

    /* renamed from: b  reason: collision with root package name */
    public final a f14642b;

    /* renamed from: c  reason: collision with root package name */
    public final f0 f14643c;

    /* renamed from: d  reason: collision with root package name */
    public final Timer f14644d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList f14645e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public c2 f14646f;

    @Inject
    public o(x xVar, String str, double d10, a aVar, m mVar, a aVar2, f0 f0Var) {
        j.f("repository", xVar);
        j.f("videoId", str);
        j.f("currentPosition", aVar);
        j.f("messageListener", mVar);
        j.f("clearMessages", aVar2);
        j.f("coroutineScope", f0Var);
        this.f14641a = aVar;
        this.f14642b = aVar2;
        this.f14643c = f0Var;
        this.f14646f = h0.b1(f0Var, p0.f7834b, 0, new m((e) null), 2);
        r rVar = new r();
        Timer timer = new Timer(false);
        timer.scheduleAtFixedRate(new n(this, rVar), 0, 1000);
        this.f14644d = timer;
    }
}
