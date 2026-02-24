package com.github.andreyasadchy.xtra;

import android.content.Context;
import ca.b;
import com.bumptech.glide.c;
import com.bumptech.glide.n;
import pb.f1;
import xa.j;
import y5.h;

public final class XtraGlideModule extends q5.a {

    public interface a {
    }

    public final void b(Context context, c cVar, n nVar) {
        j.f("glide", cVar);
        Context applicationContext = context.getApplicationContext();
        j.e("context.applicationContext", applicationContext);
        nVar.m(new z4.c((f1) ((h) ((a) b.a(applicationContext, a.class))).f16981e.get()));
    }
}
