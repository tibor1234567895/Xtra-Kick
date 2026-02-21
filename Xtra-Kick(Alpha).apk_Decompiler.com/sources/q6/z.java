package q6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;
import androidx.lifecycle.b2;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import dagger.hilt.android.internal.managers.h;
import dagger.hilt.android.internal.managers.l;
import ha.d;
import ja.b;
import ja.c;
import l6.f;

public abstract class z extends f implements b {

    /* renamed from: j0  reason: collision with root package name */
    public l f13398j0;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f13399k0;

    /* renamed from: l0  reason: collision with root package name */
    public volatile h f13400l0;

    /* renamed from: m0  reason: collision with root package name */
    public final Object f13401m0 = new Object();

    /* renamed from: n0  reason: collision with root package name */
    public boolean f13402n0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f13398j0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        p0();
        if (!this.f13402n0) {
            this.f13402n0 = true;
            GamePagerFragment gamePagerFragment = (GamePagerFragment) this;
            ((i) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        p0();
        if (!this.f13402n0) {
            this.f13402n0 = true;
            GamePagerFragment gamePagerFragment = (GamePagerFragment) this;
            ((i) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f13400l0 == null) {
            synchronized (this.f13401m0) {
                if (this.f13400l0 == null) {
                    this.f13400l0 = new h((c0) this);
                }
            }
        }
        return this.f13400l0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void p0() {
        if (this.f13398j0 == null) {
            this.f13398j0 = new l(super.v(), (c0) this);
            this.f13399k0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f13399k0) {
            return null;
        }
        p0();
        return this.f13398j0;
    }
}
