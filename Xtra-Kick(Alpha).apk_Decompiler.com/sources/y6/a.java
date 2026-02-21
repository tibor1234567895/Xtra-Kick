package y6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;
import androidx.lifecycle.b2;
import com.github.andreyasadchy.xtra.ui.saved.SavedPagerFragment;
import dagger.hilt.android.internal.managers.h;
import dagger.hilt.android.internal.managers.l;
import ha.d;
import ja.b;
import ja.c;

public abstract class a extends c0 implements b {

    /* renamed from: d0  reason: collision with root package name */
    public l f17068d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f17069e0;

    /* renamed from: f0  reason: collision with root package name */
    public volatile h f17070f0;

    /* renamed from: g0  reason: collision with root package name */
    public final Object f17071g0 = new Object();

    /* renamed from: h0  reason: collision with root package name */
    public boolean f17072h0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f17068d0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        l0();
        if (!this.f17072h0) {
            this.f17072h0 = true;
            SavedPagerFragment savedPagerFragment = (SavedPagerFragment) this;
            ((c) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        l0();
        if (!this.f17072h0) {
            this.f17072h0 = true;
            SavedPagerFragment savedPagerFragment = (SavedPagerFragment) this;
            ((c) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f17070f0 == null) {
            synchronized (this.f17071g0) {
                if (this.f17070f0 == null) {
                    this.f17070f0 = new h((c0) this);
                }
            }
        }
        return this.f17070f0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void l0() {
        if (this.f17068d0 == null) {
            this.f17068d0 = new l(super.v(), (c0) this);
            this.f17069e0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f17069e0) {
            return null;
        }
        l0();
        return this.f17068d0;
    }
}
