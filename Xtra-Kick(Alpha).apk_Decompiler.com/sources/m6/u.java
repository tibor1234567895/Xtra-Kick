package m6;

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

public abstract class u extends b implements b {
    public boolean A0 = false;

    /* renamed from: w0  reason: collision with root package name */
    public l f10666w0;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f10667x0;

    /* renamed from: y0  reason: collision with root package name */
    public volatile h f10668y0;

    /* renamed from: z0  reason: collision with root package name */
    public final Object f10669z0 = new Object();

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f10666w0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        t0();
        if (!this.A0) {
            this.A0 = true;
            z zVar = (z) this;
            ((a0) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        t0();
        if (!this.A0) {
            this.A0 = true;
            z zVar = (z) this;
            ((a0) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f10668y0 == null) {
            synchronized (this.f10669z0) {
                if (this.f10668y0 == null) {
                    this.f10668y0 = new h((c0) this);
                }
            }
        }
        return this.f10668y0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void t0() {
        if (this.f10666w0 == null) {
            this.f10666w0 = new l(super.v(), (c0) this);
            this.f10667x0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f10667x0) {
            return null;
        }
        t0();
        return this.f10666w0;
    }
}
