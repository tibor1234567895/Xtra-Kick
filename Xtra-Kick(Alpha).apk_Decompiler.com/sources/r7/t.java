package r7;

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

public abstract class t extends n implements b {

    /* renamed from: v0  reason: collision with root package name */
    public l f13867v0;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f13868w0;

    /* renamed from: x0  reason: collision with root package name */
    public volatile h f13869x0;

    /* renamed from: y0  reason: collision with root package name */
    public final Object f13870y0 = new Object();

    /* renamed from: z0  reason: collision with root package name */
    public boolean f13871z0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f13867v0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        r0();
        if (!this.f13871z0) {
            this.f13871z0 = true;
            z zVar = (z) this;
            ((a0) c()).getClass();
        }
    }

    public void M(Context context) {
        super.M(context);
        r0();
        if (!this.f13871z0) {
            this.f13871z0 = true;
            z zVar = (z) this;
            ((a0) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f13869x0 == null) {
            synchronized (this.f13870y0) {
                if (this.f13869x0 == null) {
                    this.f13869x0 = new h((c0) this);
                }
            }
        }
        return this.f13869x0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void r0() {
        if (this.f13867v0 == null) {
            this.f13867v0 = new l(super.v(), (c0) this);
            this.f13868w0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f13868w0) {
            return null;
        }
        r0();
        return this.f13867v0;
    }
}
