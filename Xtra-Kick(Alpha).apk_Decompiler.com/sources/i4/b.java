package i4;

import hb.h0;
import j4.j;
import java.util.ArrayList;
import la.i;
import ma.z;
import p4.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f8232a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f8233b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f8234c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f8235d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f8236e;

    public b() {
        this.f8232a = new ArrayList();
        this.f8233b = new ArrayList();
        this.f8234c = new ArrayList();
        this.f8235d = new ArrayList();
        this.f8236e = new ArrayList();
    }

    public final void a(j jVar) {
        this.f8236e.add(jVar);
    }

    public final void b(m4.j jVar, Class cls) {
        this.f8235d.add(new i(jVar, cls));
    }

    public final void c(d dVar, Class cls) {
        this.f8233b.add(new i(dVar, cls));
    }

    public final c d() {
        return new c(h0.U1(this.f8232a), h0.U1(this.f8233b), h0.U1(this.f8234c), h0.U1(this.f8235d), h0.U1(this.f8236e));
    }

    public b(c cVar) {
        this.f8232a = z.K(cVar.f8237a);
        this.f8233b = z.K(cVar.f8238b);
        this.f8234c = z.K(cVar.f8239c);
        this.f8235d = z.K(cVar.f8240d);
        this.f8236e = z.K(cVar.f8241e);
    }
}
