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

public abstract class s extends c0 implements b {

    /* renamed from: d0  reason: collision with root package name */
    public l f13862d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f13863e0;

    /* renamed from: f0  reason: collision with root package name */
    public volatile h f13864f0;

    /* renamed from: g0  reason: collision with root package name */
    public final Object f13865g0 = new Object();

    /* renamed from: h0  reason: collision with root package name */
    public boolean f13866h0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f13862d0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        l0();
        if (!this.f13866h0) {
            this.f13866h0 = true;
            q qVar = (q) this;
            ((r) c()).getClass();
        }
    }

    public void M(Context context) {
        super.M(context);
        l0();
        if (!this.f13866h0) {
            this.f13866h0 = true;
            q qVar = (q) this;
            ((r) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f13864f0 == null) {
            synchronized (this.f13865g0) {
                if (this.f13864f0 == null) {
                    this.f13864f0 = new h((c0) this);
                }
            }
        }
        return this.f13864f0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void l0() {
        if (this.f13862d0 == null) {
            this.f13862d0 = new l(super.v(), (c0) this);
            this.f13863e0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f13863e0) {
            return null;
        }
        l0();
        return this.f13862d0;
    }
}
