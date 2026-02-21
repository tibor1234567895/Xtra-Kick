package k6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;
import androidx.lifecycle.b2;
import dagger.hilt.android.internal.managers.h;
import dagger.hilt.android.internal.managers.l;
import ha.d;
import j6.a;
import ja.b;
import ja.c;

public abstract class o extends a implements b {

    /* renamed from: l0  reason: collision with root package name */
    public l f9240l0;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f9241m0;

    /* renamed from: n0  reason: collision with root package name */
    public volatile h f9242n0;

    /* renamed from: o0  reason: collision with root package name */
    public final Object f9243o0 = new Object();

    /* renamed from: p0  reason: collision with root package name */
    public boolean f9244p0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f9240l0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        r0();
        if (!this.f9244p0) {
            this.f9244p0 = true;
            e eVar = (e) this;
            ((f) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        r0();
        if (!this.f9244p0) {
            this.f9244p0 = true;
            e eVar = (e) this;
            ((f) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f9242n0 == null) {
            synchronized (this.f9243o0) {
                if (this.f9242n0 == null) {
                    this.f9242n0 = new h((c0) this);
                }
            }
        }
        return this.f9242n0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void r0() {
        if (this.f9240l0 == null) {
            this.f9240l0 = new l(super.v(), (c0) this);
            this.f9241m0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f9241m0) {
            return null;
        }
        r0();
        return this.f9240l0;
    }
}
