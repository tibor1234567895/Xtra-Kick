package pb;

import java.io.Closeable;
import tb.g;
import wa.a;
import xa.j;

public final class r1 implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final j1 f12961h;

    /* renamed from: i  reason: collision with root package name */
    public final h1 f12962i;

    /* renamed from: j  reason: collision with root package name */
    public final String f12963j;

    /* renamed from: k  reason: collision with root package name */
    public final int f12964k;

    /* renamed from: l  reason: collision with root package name */
    public final m0 f12965l;

    /* renamed from: m  reason: collision with root package name */
    public final p0 f12966m;

    /* renamed from: n  reason: collision with root package name */
    public final u1 f12967n;

    /* renamed from: o  reason: collision with root package name */
    public final r1 f12968o;

    /* renamed from: p  reason: collision with root package name */
    public final r1 f12969p;

    /* renamed from: q  reason: collision with root package name */
    public final r1 f12970q;

    /* renamed from: r  reason: collision with root package name */
    public final long f12971r;

    /* renamed from: s  reason: collision with root package name */
    public final long f12972s;

    /* renamed from: t  reason: collision with root package name */
    public final g f12973t;

    /* renamed from: u  reason: collision with root package name */
    public final a f12974u;

    /* renamed from: v  reason: collision with root package name */
    public g f12975v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f12976w;

    public r1(j1 j1Var, h1 h1Var, String str, int i10, m0 m0Var, p0 p0Var, u1 u1Var, r1 r1Var, r1 r1Var2, r1 r1Var3, long j10, long j11, g gVar, a aVar) {
        int i11 = i10;
        a aVar2 = aVar;
        j.f("body", u1Var);
        j.f("trailersFn", aVar2);
        this.f12961h = j1Var;
        this.f12962i = h1Var;
        this.f12963j = str;
        this.f12964k = i11;
        this.f12965l = m0Var;
        this.f12966m = p0Var;
        this.f12967n = u1Var;
        this.f12968o = r1Var;
        this.f12969p = r1Var2;
        this.f12970q = r1Var3;
        this.f12971r = j10;
        this.f12972s = j11;
        this.f12973t = gVar;
        this.f12974u = aVar2;
        this.f12976w = 200 <= i11 && i11 < 300;
    }

    public static String e(r1 r1Var, String str) {
        r1Var.getClass();
        String a10 = r1Var.f12966m.a(str);
        if (a10 == null) {
            return null;
        }
        return a10;
    }

    public final g c() {
        g gVar = this.f12975v;
        if (gVar != null) {
            return gVar;
        }
        g.f12846n.getClass();
        g a10 = f.a(this.f12966m);
        this.f12975v = a10;
        return a10;
    }

    public final void close() {
        this.f12967n.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.f12962i + ", code=" + this.f12964k + ", message=" + this.f12963j + ", url=" + this.f12961h.f12884a + '}';
    }
}
