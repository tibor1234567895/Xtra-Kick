package m4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import c4.s;
import dc.j;
import j4.d0;
import j4.f0;
import j4.h0;
import java.nio.ByteBuffer;
import pa.e;
import s4.m;
import w4.g;

public final class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f10572a;

    /* renamed from: b  reason: collision with root package name */
    public final m f10573b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f10574c;

    public /* synthetic */ d(Object obj, m mVar, int i10) {
        this.f10572a = i10;
        this.f10574c = obj;
        this.f10573b = mVar;
    }

    /* JADX INFO: finally extract failed */
    public final Object a(e eVar) {
        int i10 = this.f10572a;
        boolean z10 = false;
        m mVar = this.f10573b;
        Object obj = this.f10574c;
        switch (i10) {
            case 0:
                return new h(new BitmapDrawable(mVar.f14276a.getResources(), (Bitmap) obj), false, 2);
            case 1:
                try {
                    j jVar = new j();
                    jVar.write((ByteBuffer) obj);
                    ((ByteBuffer) obj).position(0);
                    return new v(new h0(jVar, new f0(mVar.f14276a, 0), (d0) null), (String) null, 2);
                } catch (Throwable th) {
                    ((ByteBuffer) obj).position(0);
                    throw th;
                }
            default:
                Drawable drawable = (Drawable) obj;
                Bitmap.Config[] configArr = w4.e.f16080a;
                if ((drawable instanceof VectorDrawable) || (drawable instanceof s)) {
                    z10 = true;
                }
                if (z10) {
                    g gVar = g.f16085a;
                    Bitmap.Config config = mVar.f14277b;
                    gVar.getClass();
                    drawable = new BitmapDrawable(mVar.f14276a.getResources(), g.a(drawable, config, mVar.f14279d, mVar.f14280e, mVar.f14281f));
                }
                return new h(drawable, z10, 2);
        }
    }
}
