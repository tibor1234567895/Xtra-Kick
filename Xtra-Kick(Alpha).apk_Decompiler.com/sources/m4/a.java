package m4;

import android.graphics.Bitmap;
import android.net.Uri;
import ma.z;
import s4.m;
import w4.e;
import xa.j;

public final class a implements j {
    public final k a(Object obj, m mVar) {
        boolean z10;
        Uri uri = (Uri) obj;
        Bitmap.Config[] configArr = e.f16080a;
        if (!j.a(uri.getScheme(), "file") || !j.a((String) z.u(uri.getPathSegments()), "android_asset")) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            return null;
        }
        return new b(uri, mVar, 0);
    }
}
