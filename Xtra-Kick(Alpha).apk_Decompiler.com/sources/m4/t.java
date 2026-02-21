package m4;

import android.net.Uri;
import s4.m;
import xa.j;

public final class t implements j {
    public final k a(Object obj, m mVar) {
        Uri uri = (Uri) obj;
        if (!j.a(uri.getScheme(), "android.resource")) {
            return null;
        }
        return new u(uri, mVar);
    }
}
