package coil.request;

import android.support.v4.media.h;
import androidx.lifecycle.d0;
import androidx.lifecycle.t;
import hb.l1;
import java.util.concurrent.CancellationException;
import s4.q;
import xa.j;

public final class BaseRequestDelegate implements q {

    /* renamed from: h  reason: collision with root package name */
    public final t f3152h;

    /* renamed from: i  reason: collision with root package name */
    public final l1 f3153i;

    public BaseRequestDelegate(t tVar, l1 l1Var) {
        this.f3152h = tVar;
        this.f3153i = l1Var;
    }

    public final void a(d0 d0Var) {
        j.f("owner", d0Var);
    }

    public final /* synthetic */ void b(d0 d0Var) {
        h.b(d0Var);
    }

    public final void e() {
        this.f3152h.c(this);
    }

    public final /* synthetic */ void f(d0 d0Var) {
    }

    public final /* synthetic */ void g() {
    }

    public final void onDestroy(d0 d0Var) {
        this.f3153i.e((CancellationException) null);
    }

    public final void onStart(d0 d0Var) {
        j.f("owner", d0Var);
    }

    public final /* synthetic */ void onStop(d0 d0Var) {
    }

    public final void start() {
        this.f3152h.a(this);
    }
}
