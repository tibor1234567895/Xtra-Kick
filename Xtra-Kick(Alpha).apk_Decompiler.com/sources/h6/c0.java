package h6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.b2;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import dagger.hilt.android.internal.managers.h;
import dagger.hilt.android.internal.managers.l;
import ha.d;
import ja.b;
import ja.c;
import l6.f;

public abstract class c0 extends f implements b {

    /* renamed from: j0  reason: collision with root package name */
    public l f7642j0;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f7643k0;

    /* renamed from: l0  reason: collision with root package name */
    public volatile h f7644l0;

    /* renamed from: m0  reason: collision with root package name */
    public final Object f7645m0 = new Object();

    /* renamed from: n0  reason: collision with root package name */
    public boolean f7646n0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f7642j0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        p0();
        if (!this.f7646n0) {
            this.f7646n0 = true;
            ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) this;
            ((t) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        p0();
        if (!this.f7646n0) {
            this.f7646n0 = true;
            ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) this;
            ((t) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (androidx.fragment.app.c0) this));
    }

    public final Object c() {
        if (this.f7644l0 == null) {
            synchronized (this.f7645m0) {
                if (this.f7644l0 == null) {
                    this.f7644l0 = new h((androidx.fragment.app.c0) this);
                }
            }
        }
        return this.f7644l0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void p0() {
        if (this.f7642j0 == null) {
            this.f7642j0 = new l(super.v(), (androidx.fragment.app.c0) this);
            this.f7643k0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f7643k0) {
            return null;
        }
        p0();
        return this.f7642j0;
    }
}
