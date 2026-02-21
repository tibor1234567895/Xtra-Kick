package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.activity.e;
import androidx.lifecycle.a2;
import androidx.lifecycle.b2;
import androidx.lifecycle.g0;
import androidx.lifecycle.g2;
import androidx.lifecycle.h2;
import androidx.lifecycle.m;
import androidx.lifecycle.o1;
import androidx.lifecycle.r;
import androidx.lifecycle.s1;
import androidx.lifecycle.t;
import b1.f;
import t3.g;
import t3.h;

public final class y1 implements m, h, h2 {

    /* renamed from: h  reason: collision with root package name */
    public final c0 f1615h;

    /* renamed from: i  reason: collision with root package name */
    public final g2 f1616i;

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f1617j;

    /* renamed from: k  reason: collision with root package name */
    public b2 f1618k;

    /* renamed from: l  reason: collision with root package name */
    public g0 f1619l = null;

    /* renamed from: m  reason: collision with root package name */
    public g f1620m = null;

    public y1(c0 c0Var, g2 g2Var, e eVar) {
        this.f1615h = c0Var;
        this.f1616i = g2Var;
        this.f1617j = eVar;
    }

    public final t3.e a() {
        c();
        return this.f1620m.f14540b;
    }

    public final void b(r rVar) {
        this.f1619l.f(rVar);
    }

    public final void c() {
        if (this.f1619l == null) {
            this.f1619l = new g0(this);
            g.f14538d.getClass();
            g gVar = new g(this);
            this.f1620m = gVar;
            gVar.a();
            this.f1617j.run();
        }
    }

    public final b2 h() {
        Application application;
        c0 c0Var = this.f1615h;
        b2 h10 = c0Var.h();
        if (!h10.equals(c0Var.Y)) {
            this.f1618k = h10;
            return h10;
        }
        if (this.f1618k == null) {
            Context applicationContext = c0Var.f0().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            this.f1618k = new s1(application, c0Var, c0Var.f1357m);
        }
        return this.f1618k;
    }

    public final f i() {
        Application application;
        c0 c0Var = this.f1615h;
        Context applicationContext = c0Var.f0().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        f fVar = new f();
        if (application != null) {
            fVar.b(a2.f1653g, application);
        }
        fVar.b(o1.f1735a, c0Var);
        fVar.b(o1.f1736b, this);
        Bundle bundle = c0Var.f1357m;
        if (bundle != null) {
            fVar.b(o1.f1737c, bundle);
        }
        return fVar;
    }

    public final g2 m() {
        c();
        return this.f1616i;
    }

    public final t o() {
        c();
        return this.f1619l;
    }
}
