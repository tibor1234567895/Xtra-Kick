package pb;

import qb.f;
import tb.g;
import wa.a;
import xa.j;

public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    public j1 f12934a;

    /* renamed from: b  reason: collision with root package name */
    public h1 f12935b;

    /* renamed from: c  reason: collision with root package name */
    public int f12936c;

    /* renamed from: d  reason: collision with root package name */
    public String f12937d;

    /* renamed from: e  reason: collision with root package name */
    public m0 f12938e;

    /* renamed from: f  reason: collision with root package name */
    public n0 f12939f;

    /* renamed from: g  reason: collision with root package name */
    public u1 f12940g;

    /* renamed from: h  reason: collision with root package name */
    public r1 f12941h;

    /* renamed from: i  reason: collision with root package name */
    public r1 f12942i;

    /* renamed from: j  reason: collision with root package name */
    public r1 f12943j;

    /* renamed from: k  reason: collision with root package name */
    public long f12944k;

    /* renamed from: l  reason: collision with root package name */
    public long f12945l;

    /* renamed from: m  reason: collision with root package name */
    public g f12946m;

    /* renamed from: n  reason: collision with root package name */
    public a f12947n;

    public q1() {
        this.f12936c = -1;
        this.f12940g = f.f13490d;
        this.f12947n = p1.f12932h;
        this.f12939f = new n0();
    }

    public final r1 a() {
        int i10 = this.f12936c;
        if (i10 >= 0) {
            j1 j1Var = this.f12934a;
            if (j1Var != null) {
                h1 h1Var = this.f12935b;
                if (h1Var != null) {
                    String str = this.f12937d;
                    if (str != null) {
                        return new r1(j1Var, h1Var, str, i10, this.f12938e, this.f12939f.b(), this.f12940g, this.f12941h, this.f12942i, this.f12943j, this.f12944k, this.f12945l, this.f12946m, this.f12947n);
                    }
                    throw new IllegalStateException("message == null".toString());
                }
                throw new IllegalStateException("protocol == null".toString());
            }
            throw new IllegalStateException("request == null".toString());
        }
        throw new IllegalStateException(("code < 0: " + this.f12936c).toString());
    }

    public final void b(p0 p0Var) {
        j.f("headers", p0Var);
        this.f12939f = p0Var.d();
    }

    public final void c(String str) {
        j.f("message", str);
        this.f12937d = str;
    }

    public final void d(h1 h1Var) {
        j.f("protocol", h1Var);
        this.f12935b = h1Var;
    }

    public final void e(j1 j1Var) {
        j.f("request", j1Var);
        this.f12934a = j1Var;
    }

    public q1(r1 r1Var) {
        j.f("response", r1Var);
        this.f12936c = -1;
        this.f12940g = f.f13490d;
        this.f12947n = p1.f12932h;
        this.f12934a = r1Var.f12961h;
        this.f12935b = r1Var.f12962i;
        this.f12936c = r1Var.f12964k;
        this.f12937d = r1Var.f12963j;
        this.f12938e = r1Var.f12965l;
        this.f12939f = r1Var.f12966m.d();
        this.f12940g = r1Var.f12967n;
        this.f12941h = r1Var.f12968o;
        this.f12942i = r1Var.f12969p;
        this.f12943j = r1Var.f12970q;
        this.f12944k = r1Var.f12971r;
        this.f12945l = r1Var.f12972s;
        this.f12946m = r1Var.f12973t;
        this.f12947n = r1Var.f12974u;
    }
}
