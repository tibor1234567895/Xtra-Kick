package com.github.andreyasadchy.xtra.ui.download;

import android.app.Application;
import androidx.lifecycle.c;
import androidx.lifecycle.o0;
import e6.o1;
import e6.z1;
import javax.inject.Inject;
import xa.j;

public final class VideoDownloadViewModel extends c {

    /* renamed from: e  reason: collision with root package name */
    public final z1 f3394e;

    /* renamed from: f  reason: collision with root package name */
    public final o1 f3395f;

    /* renamed from: g  reason: collision with root package name */
    public final o0 f3396g = new o0();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public VideoDownloadViewModel(Application application, z1 z1Var, o1 o1Var) {
        super(application);
        j.f("application", application);
        j.f("playerRepository", z1Var);
        j.f("offlineRepository", o1Var);
        this.f3394e = z1Var;
        this.f3395f = o1Var;
    }
}
