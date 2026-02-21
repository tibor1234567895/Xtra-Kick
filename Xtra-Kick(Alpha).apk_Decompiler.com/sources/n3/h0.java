package n3;

import cb.b;
import cb.c;
import java.util.ArrayList;
import java.util.List;
import ma.b0;
import ma.l;
import ma.z;
import xa.j;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public int f11215a;

    /* renamed from: b  reason: collision with root package name */
    public int f11216b;

    /* renamed from: c  reason: collision with root package name */
    public final l f11217c = new l();

    /* renamed from: d  reason: collision with root package name */
    public final h1 f11218d = new h1();

    /* renamed from: e  reason: collision with root package name */
    public c1 f11219e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11220f;

    public final void a(s1 s1Var) {
        j.f("event", s1Var);
        this.f11220f = true;
        boolean z10 = s1Var instanceof q1;
        int i10 = 0;
        l lVar = this.f11217c;
        h1 h1Var = this.f11218d;
        if (z10) {
            q1 q1Var = (q1) s1Var;
            h1Var.b(q1Var.f11426e);
            this.f11219e = q1Var.f11427f;
            int ordinal = q1Var.f11422a.ordinal();
            int i11 = q1Var.f11425d;
            int i12 = q1Var.f11424c;
            List list = q1Var.f11423b;
            if (ordinal == 0) {
                lVar.clear();
                this.f11216b = i11;
                this.f11215a = i12;
            } else if (ordinal == 1) {
                this.f11215a = i12;
                b.f3062k.getClass();
                c a10 = new b(list.size() - 1, 0, -1).iterator();
                while (a10.f3068j) {
                    lVar.c(list.get(a10.a()));
                }
                return;
            } else if (ordinal == 2) {
                this.f11216b = i11;
            } else {
                return;
            }
            lVar.addAll(list);
        } else if (s1Var instanceof o1) {
            o1 o1Var = (o1) s1Var;
            z0.f11599b.getClass();
            z0 z0Var = z0.f11601d;
            d1 d1Var = o1Var.f11371a;
            h1Var.c(d1Var, z0Var);
            int ordinal2 = d1Var.ordinal();
            int i13 = o1Var.f11374d;
            if (ordinal2 == 1) {
                this.f11215a = i13;
                int a11 = o1Var.a();
                while (i10 < a11) {
                    lVar.j();
                    i10++;
                }
            } else if (ordinal2 == 2) {
                this.f11216b = i13;
                int a12 = o1Var.a();
                while (i10 < a12) {
                    lVar.k();
                    i10++;
                }
            } else {
                throw new IllegalArgumentException("Page drop type must be prepend or append");
            }
        } else if (s1Var instanceof r1) {
            r1 r1Var = (r1) s1Var;
            h1Var.b(r1Var.f11453a);
            this.f11219e = r1Var.f11454b;
        }
    }

    public final List b() {
        Object obj;
        if (!this.f11220f) {
            return b0.f10801h;
        }
        ArrayList arrayList = new ArrayList();
        c1 d10 = this.f11218d.d();
        l lVar = this.f11217c;
        if (!lVar.isEmpty()) {
            p1 p1Var = q1.f11420g;
            List J = z.J(lVar);
            int i10 = this.f11215a;
            int i11 = this.f11216b;
            c1 c1Var = this.f11219e;
            p1Var.getClass();
            obj = p1.a(J, i10, i11, d10, c1Var);
        } else {
            obj = new r1(d10, this.f11219e);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
