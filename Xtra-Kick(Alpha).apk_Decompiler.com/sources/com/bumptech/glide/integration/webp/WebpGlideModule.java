package com.bumptech.glide.integration.webp;

import a5.a;
import a5.b;
import a5.d;
import a5.e;
import a5.f;
import a5.l;
import a5.o;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.bumptech.glide.n;
import e5.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import q5.c;
import r5.h;
import r5.i;

@Deprecated
public class WebpGlideModule implements c {
    public final void a() {
    }

    public final void b(Context context, com.bumptech.glide.c cVar, n nVar) {
        Resources resources = context.getResources();
        e5.c cVar2 = cVar.f3164h;
        ArrayList f10 = nVar.f();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        k kVar = cVar.f3167k;
        l lVar = new l(f10, displayMetrics, cVar2, kVar);
        a aVar = new a(kVar, cVar2);
        a5.c cVar3 = new a5.c(0, lVar);
        e eVar = new e(lVar, 0, kVar);
        d dVar = new d(context, kVar, cVar2);
        Class<ByteBuffer> cls = ByteBuffer.class;
        Class<Bitmap> cls2 = Bitmap.class;
        nVar.i(cVar3, cls, cls2, "Bitmap");
        Class<InputStream> cls3 = InputStream.class;
        nVar.i(eVar, cls3, cls2, "Bitmap");
        e eVar2 = new e(resources, cVar3);
        Class<BitmapDrawable> cls4 = BitmapDrawable.class;
        nVar.i(eVar2, cls, cls4, "BitmapDrawable");
        nVar.i(new e(resources, eVar), cls3, cls4, "BitmapDrawable");
        nVar.i(new b(aVar, 0), cls, cls2, "Bitmap");
        nVar.i(new b(aVar, 1), cls3, cls2, "Bitmap");
        Class<a5.n> cls5 = a5.n.class;
        nVar.i(dVar, cls, cls5, "legacy_prepend_all");
        nVar.i(new f(dVar, kVar), cls3, cls5, "legacy_prepend_all");
        o oVar = new o();
        Class<a5.n> cls6 = a5.n.class;
        i iVar = nVar.f3296d;
        synchronized (iVar) {
            iVar.f13836a.add(0, new h(cls6, oVar));
        }
    }
}
