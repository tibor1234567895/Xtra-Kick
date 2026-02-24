package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.activity.s;
import androidx.lifecycle.g2;
import androidx.lifecycle.h2;
import androidx.lifecycle.t;
import b0.m0;
import b0.n0;
import c0.h;
import c0.i;
import l0.a;
import m0.q;
import t3.e;

public final class e0 extends h0 implements h, i, m0, n0, h2, s, androidx.activity.result.h, t3.h, i1, q {

    /* renamed from: h  reason: collision with root package name */
    public final Activity f1402h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f1403i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f1404j;

    /* renamed from: k  reason: collision with root package name */
    public final d1 f1405k = new d1();

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ f0 f1406l;

    public e0(f0 f0Var) {
        this.f1406l = f0Var;
        Handler handler = new Handler();
        this.f1402h = f0Var;
        if (f0Var != null) {
            this.f1403i = f0Var;
            this.f1404j = handler;
            return;
        }
        throw new NullPointerException("context == null");
    }

    public final e a() {
        return this.f1406l.f451l.f14540b;
    }

    public final void b(c1 c1Var, c0 c0Var) {
        this.f1406l.getClass();
    }

    public final View c(int i10) {
        return this.f1406l.findViewById(i10);
    }

    public final boolean d() {
        Window window = this.f1406l.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public final void e(r0 r0Var) {
        this.f1406l.k(r0Var);
    }

    public final void f(a aVar) {
        this.f1406l.n(aVar);
    }

    public final void g(o0 o0Var) {
        this.f1406l.r(o0Var);
    }

    public final void h(o0 o0Var) {
        this.f1406l.s(o0Var);
    }

    public final void i(o0 o0Var) {
        this.f1406l.t(o0Var);
    }

    public final void j(r0 r0Var) {
        this.f1406l.v(r0Var);
    }

    public final void k(o0 o0Var) {
        this.f1406l.w(o0Var);
    }

    public final void l(o0 o0Var) {
        this.f1406l.x(o0Var);
    }

    public final g2 m() {
        return this.f1406l.m();
    }

    public final void n(o0 o0Var) {
        this.f1406l.y(o0Var);
    }

    public final t o() {
        return this.f1406l.f1417y;
    }

    public final void p(o0 o0Var) {
        this.f1406l.z(o0Var);
    }
}
