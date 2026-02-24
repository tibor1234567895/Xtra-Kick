package com.github.andreyasadchy.xtra.ui.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.c0;
import androidx.lifecycle.b2;
import com.github.andreyasadchy.xtra.ui.settings.SettingsActivity;
import dagger.hilt.android.internal.managers.h;
import dagger.hilt.android.internal.managers.l;
import ha.d;
import ja.b;
import ja.c;
import o3.z;

public abstract class a extends z implements b {

    /* renamed from: l0  reason: collision with root package name */
    public l f3501l0;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f3502m0;

    /* renamed from: n0  reason: collision with root package name */
    public volatile h f3503n0;

    /* renamed from: o0  reason: collision with root package name */
    public final Object f3504o0 = new Object();

    /* renamed from: p0  reason: collision with root package name */
    public boolean f3505p0 = false;

    public final void L(Activity activity) {
        boolean z10;
        this.K = true;
        l lVar = this.f3501l0;
        if (lVar == null || h.b(lVar) == activity) {
            z10 = true;
        } else {
            z10 = false;
        }
        c.a(z10, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        o0();
        if (!this.f3505p0) {
            this.f3505p0 = true;
            SettingsActivity.d dVar = (SettingsActivity.d) this;
            ((c) c()).getClass();
        }
    }

    public final void M(Context context) {
        super.M(context);
        o0();
        if (!this.f3505p0) {
            this.f3505p0 = true;
            SettingsActivity.d dVar = (SettingsActivity.d) this;
            ((c) c()).getClass();
        }
    }

    public final LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        return S.cloneInContext(new l(S, (c0) this));
    }

    public final Object c() {
        if (this.f3503n0 == null) {
            synchronized (this.f3504o0) {
                if (this.f3503n0 == null) {
                    this.f3503n0 = new h((c0) this);
                }
            }
        }
        return this.f3503n0.c();
    }

    public final b2 h() {
        return d.b(this, super.h());
    }

    public final void o0() {
        if (this.f3501l0 == null) {
            this.f3501l0 = new l(super.v(), (c0) this);
            this.f3502m0 = ea.b.a(super.v());
        }
    }

    public final Context v() {
        if (super.v() == null && !this.f3502m0) {
            return null;
        }
        o0();
        return this.f3501l0;
    }
}
