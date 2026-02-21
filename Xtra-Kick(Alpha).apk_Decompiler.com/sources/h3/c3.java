package h3;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$Token;
import e1.a0;
import e1.c0;
import e1.d0;
import e1.h;
import e1.n;
import e1.u;
import j1.g;
import j1.l0;
import j1.v;
import java.util.concurrent.atomic.AtomicReference;

public final class c3 extends a0 {

    /* renamed from: p  reason: collision with root package name */
    public final d0 f6957p;

    /* renamed from: q  reason: collision with root package name */
    public final n2 f6958q;

    /* renamed from: r  reason: collision with root package name */
    public final g f6959r;

    public c3(n2 n2Var) {
        this.f6957p = d0.a(n2Var.f7232e);
        this.f6958q = n2Var;
        this.f6959r = new g(n2Var);
    }

    public final h a(Bundle bundle) {
        c0 a10 = this.f4887h.a();
        if (bundle == null) {
            Bundle bundle2 = Bundle.EMPTY;
        }
        e2 e2Var = new e2(a10, 0, this.f6957p.b(a10), (d2) null);
        AtomicReference atomicReference = new AtomicReference();
        g gVar = new g();
        l0.L(this.f6958q.f7239l, new v1.c0(this, atomicReference, e2Var, gVar, 3));
        try {
            synchronized (gVar) {
                while (!gVar.f8430a) {
                    gVar.wait();
                }
            }
            c2 c2Var = (c2) atomicReference.get();
            c2Var.getClass();
            this.f6959r.a(a10, e2Var, c2Var.f6955a, c2Var.f6956b);
            return t3.f7332a;
        } catch (InterruptedException e10) {
            v.d("MSSLegacyStub", "Couldn't get a result from onConnect", e10);
            return null;
        }
    }

    public final void b(e1.v vVar) {
        vVar.c();
    }

    public final void c(MediaSessionCompat$Token mediaSessionCompat$Token) {
        attachBaseContext(this.f6958q.f7232e);
        onCreate();
        if (mediaSessionCompat$Token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        } else if (this.f4893n == null) {
            this.f4893n = mediaSessionCompat$Token;
            n nVar = this.f4887h;
            nVar.f4932d.f4892m.a(new u(nVar, mediaSessionCompat$Token, 1));
        } else {
            throw new IllegalStateException("The session token has already been set");
        }
    }
}
