package y5;

import a6.d0;
import a6.j;
import a6.m;
import a6.p;
import a6.t;
import a6.v;
import a6.z;
import android.app.Application;
import b6.e;
import com.github.andreyasadchy.xtra.api.KickApi;
import com.github.andreyasadchy.xtra.api.MiscApi;
import com.github.andreyasadchy.xtra.db.AppDatabase;
import e6.c2;
import e6.e0;
import e6.e1;
import e6.f2;
import e6.j2;
import e6.o1;
import e6.s0;
import e6.x;
import e6.y0;
import e6.z1;
import javax.inject.Provider;
import ka.b;
import p9.i;
import pb.f1;
import retrofit2.converter.gson.GsonConverterFactory;
import s7.f;
import s7.h;

public final class g implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final h f16975a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16976b;

    public g(h hVar, int i10) {
        this.f16975a = hVar;
        this.f16976b = i10;
    }

    public final Object get() {
        h hVar = this.f16975a;
        int i10 = this.f16976b;
        switch (i10) {
            case 0:
                f1 f10 = hVar.f16977a.f();
                b.a(f10);
                return f10;
            case 1:
                return new x((s0) hVar.f16984h.get(), (c6.b) hVar.f16986j.get());
            case 2:
                return new s0((KickApi) hVar.f16983g.get());
            case 3:
                KickApi d10 = hVar.f16977a.d((f1) hVar.f16981e.get(), (GsonConverterFactory) hVar.f16982f.get());
                b.a(d10);
                return d10;
            case 4:
                GsonConverterFactory c10 = hVar.f16977a.c();
                b.a(c10);
                return c10;
            case Constants.MAX_COMPATIBILITY_VERSION:
                return new c6.b((h) hVar.f16985i.get());
            case 6:
                h g10 = hVar.f16977a.g();
                b.a(g10);
                return g10;
            case 7:
                e0 c11 = hVar.f16978b.c((a6.b) hVar.f16989m.get(), (a6.g) hVar.f16990n.get(), (z) hVar.f16991o.get());
                b.a(c11);
                return c11;
            case 8:
                a6.b b10 = hVar.f16978b.b((AppDatabase) hVar.f16988l.get());
                b.a(b10);
                return b10;
            case 9:
                e eVar = hVar.f16978b;
                Application a10 = hVar.f16979c.a();
                b.a(a10);
                AppDatabase a11 = eVar.a(a10);
                b.a(a11);
                return a11;
            case 10:
                a6.g d11 = hVar.f16978b.d((AppDatabase) hVar.f16988l.get());
                b.a(d11);
                return d11;
            case 11:
                z p10 = hVar.f16978b.p((AppDatabase) hVar.f16988l.get());
                b.a(p10);
                return p10;
            case 12:
                return new z1((MiscApi) hVar.f16993q.get(), (m) hVar.f16994r.get(), (a6.x) hVar.f16995s.get(), (x) hVar.f16987k.get(), (c6.b) hVar.f16986j.get(), (s0) hVar.f16984h.get());
            case 13:
                MiscApi e10 = hVar.f16977a.e((f1) hVar.f16981e.get(), (GsonConverterFactory) hVar.f16982f.get());
                b.a(e10);
                return e10;
            case 14:
                m h10 = hVar.f16978b.h((AppDatabase) hVar.f16988l.get());
                b.a(h10);
                return h10;
            case 15:
                a6.x o10 = hVar.f16978b.o((AppDatabase) hVar.f16988l.get());
                b.a(o10);
                return o10;
            case Constants.IV_SIZE:
                j2 r10 = hVar.f16978b.r((d0) hVar.f16997u.get());
                b.a(r10);
                return r10;
            case 17:
                d0 q10 = hVar.f16978b.q((AppDatabase) hVar.f16988l.get());
                b.a(q10);
                return q10;
            case 18:
                y0 e11 = hVar.f16978b.e((a6.g) hVar.f16990n.get(), (z) hVar.f16991o.get(), (a6.b) hVar.f16989m.get());
                b.a(e11);
                return e11;
            case 19:
                o1 i11 = hVar.f16978b.i((z) hVar.f16991o.get(), (p) hVar.f17000x.get(), (a6.g) hVar.f16990n.get(), (a6.b) hVar.f16989m.get());
                b.a(i11);
                return i11;
            case 20:
                p j10 = hVar.f16978b.j((AppDatabase) hVar.f16988l.get());
                b.a(j10);
                return j10;
            case 21:
                c2 l10 = hVar.f16978b.l((t) hVar.f17002z.get());
                b.a(l10);
                return l10;
            case 22:
                t k10 = hVar.f16978b.k((AppDatabase) hVar.f16988l.get());
                b.a(k10);
                return k10;
            case 23:
                f2 n10 = hVar.f16978b.n((v) hVar.B.get());
                b.a(n10);
                return n10;
            case 24:
                v m10 = hVar.f16978b.m((AppDatabase) hVar.f16988l.get());
                b.a(m10);
                return m10;
            case 25:
                f b11 = hVar.f16977a.b((i) hVar.D.get());
                b.a(b11);
                return b11;
            case 26:
                b6.g gVar = hVar.f16977a;
                Application a12 = hVar.f16979c.a();
                b.a(a12);
                i a13 = gVar.a(a12, (f1) hVar.f16981e.get());
                b.a(a13);
                return a13;
            case 27:
                e1 g11 = hVar.f16978b.g((j) hVar.F.get());
                b.a(g11);
                return g11;
            case 28:
                j f11 = hVar.f16978b.f((AppDatabase) hVar.f16988l.get());
                b.a(f11);
                return f11;
            default:
                throw new AssertionError(i10);
        }
    }
}
