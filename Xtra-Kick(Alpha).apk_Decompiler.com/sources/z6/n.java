package z6;

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
import l6.f;

public abstract class n extends f implements b {

    /* renamed from: j0  reason: collision with root package name */
    public l f17776j0;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f17777k0;

    /* renamed from: l0  reason: collision with root package name */
    public volatile h f17778l0;

    /* renamed from: m0  reason: collision with root package name */
    public final Object f17779m0 = new Object();

    /* renamed from: n0  reason: collision with root package name */
    public boolean f17780n0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f17776j0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        p0();
        if (!this.f17780n0) {
            this.f17780n0 = true;
            g gVar = (g) this;
            ((h) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        p0();
        if (!this.f17780n0) {
            this.f17780n0 = true;
            g gVar = (g) this;
            ((h) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f17778l0 == null) {
            synchronized (this.f17779m0) {
                if (this.f17778l0 == null) {
                    this.f17778l0 = new h((c0) this);
                }
            }
        }
        return this.f17778l0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void p0() {
        if (this.f17776j0 == null) {
            this.f17776j0 = new l(super.v(), (c0) this);
            this.f17777k0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f17777k0) {
            return null;
        }
        p0();
        return this.f17776j0;
    }
}
