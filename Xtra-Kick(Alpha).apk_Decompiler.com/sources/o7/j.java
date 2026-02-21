package o7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;
import androidx.lifecycle.b2;
import dagger.hilt.android.internal.managers.h;
import dagger.hilt.android.internal.managers.l;
import ha.d;
import ja.b;
import m7.c;

public abstract class j extends c implements b {

    /* renamed from: l0  reason: collision with root package name */
    public l f12303l0;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f12304m0;

    /* renamed from: n0  reason: collision with root package name */
    public volatile h f12305n0;

    /* renamed from: o0  reason: collision with root package name */
    public final Object f12306o0 = new Object();

    /* renamed from: p0  reason: collision with root package name */
    public boolean f12307p0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f12303l0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        ja.c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        s0();
        if (!this.f12307p0) {
            this.f12307p0 = true;
            c cVar = (c) this;
            ((d) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        s0();
        if (!this.f12307p0) {
            this.f12307p0 = true;
            c cVar = (c) this;
            ((d) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f12305n0 == null) {
            synchronized (this.f12306o0) {
                if (this.f12305n0 == null) {
                    this.f12305n0 = new h((c0) this);
                }
            }
        }
        return this.f12305n0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void s0() {
        if (this.f12303l0 == null) {
            this.f12303l0 = new l(super.v(), (c0) this);
            this.f12304m0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f12304m0) {
            return null;
        }
        s0();
        return this.f12303l0;
    }
}
