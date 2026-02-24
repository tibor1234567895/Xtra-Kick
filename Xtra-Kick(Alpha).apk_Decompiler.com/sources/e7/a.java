package e7;

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
import ja.c;
import l6.x;

public abstract class a extends x implements b {

    /* renamed from: k0  reason: collision with root package name */
    public l f5289k0;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f5290l0;

    /* renamed from: m0  reason: collision with root package name */
    public volatile h f5291m0;

    /* renamed from: n0  reason: collision with root package name */
    public final Object f5292n0 = new Object();

    /* renamed from: o0  reason: collision with root package name */
    public boolean f5293o0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f5289k0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        r0();
        if (!this.f5293o0) {
            this.f5293o0 = true;
            g gVar = (g) this;
            ((h) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        r0();
        if (!this.f5293o0) {
            this.f5293o0 = true;
            g gVar = (g) this;
            ((h) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f5291m0 == null) {
            synchronized (this.f5292n0) {
                if (this.f5291m0 == null) {
                    this.f5291m0 = new h((c0) this);
                }
            }
        }
        return this.f5291m0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void r0() {
        if (this.f5289k0 == null) {
            this.f5289k0 = new l(super.v(), (c0) this);
            this.f5290l0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f5290l0) {
            return null;
        }
        r0();
        return this.f5289k0;
    }
}
