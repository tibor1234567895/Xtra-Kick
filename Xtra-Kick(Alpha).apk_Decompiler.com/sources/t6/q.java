package t6;

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
import l6.n;

public abstract class q extends n implements b {

    /* renamed from: v0  reason: collision with root package name */
    public l f14650v0;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f14651w0;

    /* renamed from: x0  reason: collision with root package name */
    public volatile h f14652x0;

    /* renamed from: y0  reason: collision with root package name */
    public final Object f14653y0 = new Object();

    /* renamed from: z0  reason: collision with root package name */
    public boolean f14654z0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f14650v0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        r0();
        if (!this.f14654z0) {
            this.f14654z0 = true;
            o0 o0Var = (o0) this;
            ((p0) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        r0();
        if (!this.f14654z0) {
            this.f14654z0 = true;
            o0 o0Var = (o0) this;
            ((p0) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f14652x0 == null) {
            synchronized (this.f14653y0) {
                if (this.f14652x0 == null) {
                    this.f14652x0 = new h((c0) this);
                }
            }
        }
        return this.f14652x0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void r0() {
        if (this.f14650v0 == null) {
            this.f14650v0 = new l(super.v(), (c0) this);
            this.f14651w0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f14651w0) {
            return null;
        }
        r0();
        return this.f14650v0;
    }
}
