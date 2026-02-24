package n6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;
import androidx.lifecycle.b2;
import com.github.andreyasadchy.xtra.ui.follow.FollowPagerFragment;
import dagger.hilt.android.internal.managers.h;
import dagger.hilt.android.internal.managers.l;
import ha.d;
import ja.b;

public abstract class c extends c0 implements b {

    /* renamed from: d0  reason: collision with root package name */
    public l f11705d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f11706e0;

    /* renamed from: f0  reason: collision with root package name */
    public volatile h f11707f0;

    /* renamed from: g0  reason: collision with root package name */
    public final Object f11708g0 = new Object();

    /* renamed from: h0  reason: collision with root package name */
    public boolean f11709h0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f11705d0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        ja.c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        l0();
        if (!this.f11709h0) {
            this.f11709h0 = true;
            FollowPagerFragment followPagerFragment = (FollowPagerFragment) this;
            ((b) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        l0();
        if (!this.f11709h0) {
            this.f11709h0 = true;
            FollowPagerFragment followPagerFragment = (FollowPagerFragment) this;
            ((b) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f11707f0 == null) {
            synchronized (this.f11708g0) {
                if (this.f11707f0 == null) {
                    this.f11707f0 = new h((c0) this);
                }
            }
        }
        return this.f11707f0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void l0() {
        if (this.f11705d0 == null) {
            this.f11705d0 = new l(super.v(), (c0) this);
            this.f11706e0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f11706e0) {
            return null;
        }
        l0();
        return this.f11705d0;
    }
}
