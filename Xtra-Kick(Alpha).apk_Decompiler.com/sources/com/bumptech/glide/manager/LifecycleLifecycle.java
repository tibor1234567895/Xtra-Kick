package com.bumptech.glide.manager;

import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import java.util.HashSet;
import java.util.Iterator;
import w5.p;

final class LifecycleLifecycle implements l, c0 {

    /* renamed from: h  reason: collision with root package name */
    public final HashSet f3243h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public final t f3244i;

    public LifecycleLifecycle(g0 g0Var) {
        this.f3244i = g0Var;
        g0Var.a(this);
    }

    public final void c(m mVar) {
        this.f3243h.add(mVar);
        t tVar = this.f3244i;
        if (tVar.b() == s.DESTROYED) {
            mVar.k();
        } else if (tVar.b().a(s.STARTED)) {
            mVar.j();
        } else {
            mVar.c();
        }
    }

    public final void h(m mVar) {
        this.f3243h.remove(mVar);
    }

    @q0(r.ON_DESTROY)
    public void onDestroy(d0 d0Var) {
        Iterator it = p.d(this.f3243h).iterator();
        while (it.hasNext()) {
            ((m) it.next()).k();
        }
        d0Var.o().c(this);
    }

    @q0(r.ON_START)
    public void onStart(d0 d0Var) {
        Iterator it = p.d(this.f3243h).iterator();
        while (it.hasNext()) {
            ((m) it.next()).j();
        }
    }

    @q0(r.ON_STOP)
    public void onStop(d0 d0Var) {
        Iterator it = p.d(this.f3243h).iterator();
        while (it.hasNext()) {
            ((m) it.next()).c();
        }
    }
}
