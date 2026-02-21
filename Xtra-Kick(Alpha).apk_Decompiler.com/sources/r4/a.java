package r4;

import pb.f;
import pb.g;
import pb.p0;
import pb.x0;
import qb.c;
import xa.k;

public final class a extends k implements wa.a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f13794i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b bVar, int i10) {
        super(0);
        this.f13793h = i10;
        this.f13794i = bVar;
    }

    public final Object b() {
        int i10 = this.f13793h;
        b bVar = this.f13794i;
        switch (i10) {
            case 0:
                f fVar = g.f12846n;
                p0 p0Var = bVar.f13800f;
                fVar.getClass();
                return f.a(p0Var);
            default:
                String a10 = bVar.f13800f.a("Content-Type");
                if (a10 == null) {
                    return null;
                }
                x0.f13023d.getClass();
                try {
                    return c.a(a10);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
        }
    }
}
