package o4;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import s4.m;
import w4.e;
import xa.j;

public final class c implements b {
    public final String a(Object obj, m mVar) {
        Uri uri = (Uri) obj;
        if (!j.a(uri.getScheme(), "android.resource")) {
            return uri.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(uri);
        sb2.append('-');
        Configuration configuration = mVar.f14276a.getResources().getConfiguration();
        Bitmap.Config[] configArr = e.f16080a;
        sb2.append(configuration.uiMode & 48);
        return sb2.toString();
    }
}
