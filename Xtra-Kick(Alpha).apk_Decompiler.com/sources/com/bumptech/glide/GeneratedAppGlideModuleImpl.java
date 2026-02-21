package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.integration.webp.b;
import com.bumptech.glide.manager.s;
import com.github.andreyasadchy.xtra.XtraGlideModule;
import java.util.Collections;
import java.util.Set;
import z4.a;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a  reason: collision with root package name */
    public final XtraGlideModule f3161a = new XtraGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        Log.isLoggable("Glide", 3);
    }

    public final void a() {
        this.f3161a.getClass();
    }

    public final void b(Context context, c cVar, n nVar) {
        new a().b(context, cVar, nVar);
        new b().b(context, cVar, nVar);
        this.f3161a.b(context, cVar, nVar);
    }

    public final boolean c() {
        this.f3161a.getClass();
        return false;
    }

    public final Set d() {
        return Collections.emptySet();
    }

    public final s e() {
        return new a();
    }
}
