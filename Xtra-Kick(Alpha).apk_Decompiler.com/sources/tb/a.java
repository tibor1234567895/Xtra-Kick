package tb;

import dc.k;
import dc.l;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import la.v;
import pb.f1;
import pb.j1;
import pb.r1;
import pb.u0;
import ub.f;
import ub.i;
import wb.y;
import xa.j;

public final class a implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f14918a = new a();

    private a() {
    }

    public final r1 a(i iVar) {
        f fVar;
        o oVar = iVar.f15472a;
        oVar.getClass();
        synchronized (oVar) {
            if (!oVar.f14994v) {
                throw new IllegalStateException("released".toString());
            } else if (!(!oVar.f14993u)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!oVar.f14992t) {
                v vVar = v.f9814a;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        h hVar = oVar.f14988p;
        j.c(hVar);
        r a10 = hVar.a();
        f1 f1Var = oVar.f14980h;
        a10.getClass();
        j.f("client", f1Var);
        Socket socket = a10.f15005e;
        j.c(socket);
        l lVar = a10.f15008h;
        j.c(lVar);
        k kVar = a10.f15009i;
        j.c(kVar);
        wb.v vVar2 = a10.f15011k;
        if (vVar2 != null) {
            fVar = new y(f1Var, a10, iVar, vVar2);
        } else {
            int i10 = iVar.f15478g;
            socket.setSoTimeout(i10);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            lVar.timeout().g((long) i10, timeUnit);
            kVar.timeout().g((long) iVar.f15479h, timeUnit);
            fVar = new vb.k(f1Var, a10, lVar, kVar);
        }
        g gVar = new g(oVar, oVar.f14984l, hVar, fVar);
        oVar.f14991s = gVar;
        oVar.f14996x = gVar;
        synchronized (oVar) {
            oVar.f14992t = true;
            oVar.f14993u = true;
        }
        if (!oVar.f14995w) {
            return i.a(iVar, 0, gVar, (j1) null, 61).b(iVar.f15476e);
        }
        throw new IOException("Canceled");
    }
}
