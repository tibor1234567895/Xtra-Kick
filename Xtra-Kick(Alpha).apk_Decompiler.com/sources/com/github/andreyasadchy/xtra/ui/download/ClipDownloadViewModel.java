package com.github.andreyasadchy.xtra.ui.download;

import android.app.Application;
import androidx.lifecycle.c;
import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import e6.o1;
import javax.inject.Inject;
import xa.j;

public final class ClipDownloadViewModel extends c {

    /* renamed from: e  reason: collision with root package name */
    public final o1 f3377e;

    /* renamed from: f  reason: collision with root package name */
    public final o0 f3378f = new o0();

    /* renamed from: g  reason: collision with root package name */
    public Clip f3379g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public ClipDownloadViewModel(Application application, o1 o1Var) {
        super(application);
        j.f("application", application);
        j.f("offlineRepository", o1Var);
        this.f3377e = o1Var;
    }
}
