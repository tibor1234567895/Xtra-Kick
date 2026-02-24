package z4;

import android.util.Log;
import b5.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import h5.x;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import pb.f1;
import pb.h;
import pb.i;
import pb.i1;
import pb.j;
import pb.j1;
import pb.r1;
import pb.u1;
import tb.o;
import w5.c;
import w5.n;

public final class b implements e, j {

    /* renamed from: h  reason: collision with root package name */
    public final h f17569h;

    /* renamed from: i  reason: collision with root package name */
    public final x f17570i;

    /* renamed from: j  reason: collision with root package name */
    public c f17571j;

    /* renamed from: k  reason: collision with root package name */
    public u1 f17572k;

    /* renamed from: l  reason: collision with root package name */
    public d f17573l;

    /* renamed from: m  reason: collision with root package name */
    public volatile o f17574m;

    public b(h hVar, x xVar) {
        this.f17569h = hVar;
        this.f17570i = xVar;
    }

    public final Class a() {
        return InputStream.class;
    }

    public final void c() {
        try {
            c cVar = this.f17571j;
            if (cVar != null) {
                cVar.close();
            }
        } catch (IOException unused) {
        }
        u1 u1Var = this.f17572k;
        if (u1Var != null) {
            u1Var.close();
        }
        this.f17573l = null;
    }

    public final void cancel() {
        o oVar = this.f17574m;
        if (oVar != null) {
            oVar.cancel();
        }
    }

    public final a d() {
        return a.REMOTE;
    }

    public final void f(com.bumptech.glide.j jVar, d dVar) {
        i1 i1Var = new i1();
        i1Var.g(this.f17570i.d());
        for (Map.Entry entry : this.f17570i.f7619b.a().entrySet()) {
            i1Var.a((String) entry.getKey(), (String) entry.getValue());
        }
        j1 j1Var = new j1(i1Var);
        this.f17573l = dVar;
        this.f17574m = ((f1) this.f17569h).a(j1Var);
        this.f17574m.d(this);
    }

    public final void onFailure(i iVar, IOException iOException) {
        Log.isLoggable("OkHttpFetcher", 3);
        this.f17573l.e(iOException);
    }

    public final void onResponse(i iVar, r1 r1Var) {
        u1 u1Var = r1Var.f12967n;
        this.f17572k = u1Var;
        if (r1Var.f12976w) {
            n.b(u1Var);
            c cVar = new c(this.f17572k.byteStream(), u1Var.contentLength());
            this.f17571j = cVar;
            this.f17573l.g(cVar);
            return;
        }
        this.f17573l.e(new p1.d(r1Var.f12964k, r1Var.f12963j, (IOException) null));
    }
}
