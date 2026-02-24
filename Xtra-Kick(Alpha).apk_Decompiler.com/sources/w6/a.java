package w6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;
import androidx.lifecycle.b2;
import dagger.hilt.android.internal.managers.h;
import ha.d;
import ja.b;
import ja.c;
import t6.l;

public abstract class a extends l implements b {
    public boolean A0;
    public volatile h B0;
    public final Object C0 = new Object();
    public boolean D0 = false;

    /* renamed from: z0  reason: collision with root package name */
    public dagger.hilt.android.internal.managers.l f16129z0;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        dagger.hilt.android.internal.managers.l lVar = this.f16129z0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        N0();
        if (!this.D0) {
            this.D0 = true;
            f fVar = (f) this;
            ((g) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        N0();
        if (!this.D0) {
            this.D0 = true;
            f fVar = (f) this;
            ((g) c()).getClass();
        }
    }

    public final void N0() {
        if (this.f16129z0 == null) {
            this.f16129z0 = new dagger.hilt.android.internal.managers.l(super.v(), (c0) this);
            this.A0 = ea.b.a(super.v());
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new dagger.hilt.android.internal.managers.l(S, (c0) this));
    }

    public final Object c() {
        if (this.B0 == null) {
            synchronized (this.C0) {
                if (this.B0 == null) {
                    this.B0 = new h((c0) this);
                }
            }
        }
        return this.B0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final Context v() {
        if (super.v() == null && !this.A0) {
            return null;
        }
        N0();
        return this.f16129z0;
    }
}
