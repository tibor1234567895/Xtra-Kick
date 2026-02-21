package com.github.andreyasadchy.xtra.ui.settings;

import a6.x;
import a6.z;
import androidx.lifecycle.w1;
import javax.inject.Inject;
import xa.j;

public final class SettingsViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final x f3499d;

    /* renamed from: e  reason: collision with root package name */
    public final z f3500e;

    @Inject
    public SettingsViewModel(x xVar, z zVar) {
        j.f("videoPositions", xVar);
        j.f("videos", zVar);
        this.f3499d = xVar;
        this.f3500e = zVar;
    }
}
