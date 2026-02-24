package coil.request;

import android.support.v4.media.h;
import android.view.View;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.t;
import coil.target.GenericViewTarget;
import hb.l1;
import i4.m;
import s4.i;
import s4.q;
import w4.e;
import xa.j;

public final class ViewTargetRequestDelegate implements q {

    /* renamed from: h  reason: collision with root package name */
    public final m f3154h;

    /* renamed from: i  reason: collision with root package name */
    public final i f3155i;

    /* renamed from: j  reason: collision with root package name */
    public final GenericViewTarget f3156j;

    /* renamed from: k  reason: collision with root package name */
    public final t f3157k;

    /* renamed from: l  reason: collision with root package name */
    public final l1 f3158l;

    public ViewTargetRequestDelegate(m mVar, i iVar, GenericViewTarget genericViewTarget, t tVar, l1 l1Var) {
        this.f3154h = mVar;
        this.f3155i = iVar;
        this.f3156j = genericViewTarget;
        this.f3157k = tVar;
        this.f3158l = l1Var;
    }

    public final void a(d0 d0Var) {
        j.f("owner", d0Var);
    }

    public final /* synthetic */ void b(d0 d0Var) {
        h.b(d0Var);
    }

    public final /* synthetic */ void e() {
    }

    public final /* synthetic */ void f(d0 d0Var) {
    }

    public final void g() {
        this.f3156j.k();
        throw null;
    }

    public final void onDestroy(d0 d0Var) {
        this.f3156j.k();
        e.c((View) null);
        throw null;
    }

    public final void onStart(d0 d0Var) {
        j.f("owner", d0Var);
    }

    public final /* synthetic */ void onStop(d0 d0Var) {
    }

    public final void start() {
        t tVar = this.f3157k;
        tVar.a(this);
        GenericViewTarget genericViewTarget = this.f3156j;
        if (genericViewTarget instanceof c0) {
            tVar.c(genericViewTarget);
            tVar.a(genericViewTarget);
        }
        genericViewTarget.k();
        e.c((View) null);
        throw null;
    }
}
