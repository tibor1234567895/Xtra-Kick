package m4;

import android.net.Uri;
import s4.m;
import xa.j;

public final class f implements j {
    public final k a(Object obj, m mVar) {
        Uri uri = (Uri) obj;
        if (!j.a(uri.getScheme(), "content")) {
            return null;
        }
        return new b(uri, mVar, 1);
    }
}
