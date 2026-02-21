package a6;

import com.github.andreyasadchy.xtra.model.offline.Request;
import java.util.concurrent.Callable;
import la.v;
import r3.n0;

public final class r implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f255a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Request f256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s f257c;

    public /* synthetic */ r(s sVar, Request request, int i10) {
        this.f255a = i10;
        this.f257c = sVar;
        this.f256b = request;
    }

    public final v a() {
        int i10 = this.f255a;
        Request request = this.f256b;
        s sVar = this.f257c;
        switch (i10) {
            case 0:
                n0 n0Var = sVar.f258a;
                n0Var.c();
                try {
                    sVar.f259b.k(request);
                    n0Var.r();
                    return v.f9814a;
                } finally {
                    n0Var.g();
                }
            default:
                n0 n0Var2 = sVar.f258a;
                n0Var2.c();
                try {
                    sVar.f260c.i(request);
                    n0Var2.r();
                    return v.f9814a;
                } finally {
                    n0Var2.g();
                }
        }
    }

    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f255a) {
            case 0:
                return a();
            default:
                return a();
        }
    }
}
