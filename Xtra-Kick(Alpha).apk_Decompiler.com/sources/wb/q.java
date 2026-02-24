package wb;

import java.io.IOException;
import la.v;
import qb.f;
import wa.a;

public final class q implements a {

    /* renamed from: h  reason: collision with root package name */
    public final b0 f16294h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ v f16295i;

    public q(v vVar, b0 b0Var) {
        this.f16295i = vVar;
        this.f16294h = b0Var;
    }

    public final Object b() {
        c cVar;
        v vVar = this.f16295i;
        b0 b0Var = this.f16294h;
        c cVar2 = c.INTERNAL_ERROR;
        e = null;
        try {
            b0Var.e(this);
            do {
            } while (b0Var.c(false, this));
            cVar = c.NO_ERROR;
            try {
                vVar.c(cVar, c.CANCEL, (IOException) null);
            } catch (IOException e10) {
                e = e10;
                try {
                    c cVar3 = c.PROTOCOL_ERROR;
                    vVar.c(cVar3, cVar3, e);
                    f.b(b0Var);
                    return v.f9814a;
                } catch (Throwable th) {
                    th = th;
                    vVar.c(cVar, cVar2, e);
                    f.b(b0Var);
                    throw th;
                }
            }
        } catch (IOException e11) {
            e = e11;
            cVar = cVar2;
            c cVar32 = c.PROTOCOL_ERROR;
            vVar.c(cVar32, cVar32, e);
            f.b(b0Var);
            return v.f9814a;
        } catch (Throwable th2) {
            th = th2;
            cVar = cVar2;
            vVar.c(cVar, cVar2, e);
            f.b(b0Var);
            throw th;
        }
        f.b(b0Var);
        return v.f9814a;
    }
}
