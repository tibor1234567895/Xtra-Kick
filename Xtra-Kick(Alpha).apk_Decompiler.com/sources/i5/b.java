package i5;

import b5.m;
import b5.n;
import f5.h;
import h5.f0;
import h5.g0;
import h5.h0;
import h5.i0;
import h5.x;
import java.util.ArrayDeque;

public final class b implements i0 {

    /* renamed from: b  reason: collision with root package name */
    public static final m f8280b = m.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    public final g0 f8281a;

    public b() {
        this((g0) null);
    }

    public final h0 a(Object obj, int i10, int i11, n nVar) {
        x xVar = (x) obj;
        g0 g0Var = this.f8281a;
        if (g0Var != null) {
            f0 a10 = f0.a(xVar);
            h hVar = g0Var.f7574a;
            Object a11 = hVar.a(a10);
            ArrayDeque arrayDeque = f0.f7570d;
            synchronized (arrayDeque) {
                arrayDeque.offer(a10);
            }
            x xVar2 = (x) a11;
            if (xVar2 == null) {
                hVar.d(f0.a(xVar), xVar);
            } else {
                xVar = xVar2;
            }
        }
        return new h0(xVar, new com.bumptech.glide.load.data.m(xVar, ((Integer) nVar.c(f8280b)).intValue()));
    }

    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        x xVar = (x) obj;
        return true;
    }

    public b(g0 g0Var) {
        this.f8281a = g0Var;
    }
}
