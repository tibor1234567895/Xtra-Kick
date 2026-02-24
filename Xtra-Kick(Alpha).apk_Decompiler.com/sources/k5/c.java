package k5;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import b5.n;
import b5.p;
import d5.o0;
import e5.d;
import j4.z;
import j5.b;

public final class c implements p {

    /* renamed from: a  reason: collision with root package name */
    public final d f9130a = new d();

    public final /* bridge */ /* synthetic */ boolean a(Object obj, n nVar) {
        z.u(obj);
        return true;
    }

    public final /* bridge */ /* synthetic */ o0 b(Object obj, int i10, int i11, n nVar) {
        return c(z.e(obj), i10, i11, nVar);
    }

    public final d c(ImageDecoder.Source source, int i10, int i11, n nVar) {
        Bitmap c10 = ImageDecoder.decodeBitmap(source, new b(i10, i11, nVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            c10.getWidth();
            c10.getHeight();
        }
        return new d(c10, (e5.c) this.f9130a);
    }
}
