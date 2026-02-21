package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class s<S> extends a0 {

    /* renamed from: e0  reason: collision with root package name */
    public int f3789e0;

    /* renamed from: f0  reason: collision with root package name */
    public d f3790f0;

    public final void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            bundle = this.f1357m;
        }
        this.f3789e0 = bundle.getInt("THEME_RES_ID_KEY");
        h.w(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f3790f0 = (d) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(v(), this.f3789e0));
        new q(this);
        throw null;
    }

    public final void W(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f3789e0);
        bundle.putParcelable("DATE_SELECTOR_KEY", (Parcelable) null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f3790f0);
    }
}
