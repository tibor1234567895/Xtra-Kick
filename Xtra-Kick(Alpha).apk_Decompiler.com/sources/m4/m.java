package m4;

import android.webkit.MimeTypeMap;
import dc.e0;
import dc.f0;
import dc.r;
import j4.q;
import java.io.Closeable;
import java.io.File;
import pa.e;
import va.k;

public final class m implements k {

    /* renamed from: a  reason: collision with root package name */
    public final File f10578a;

    public m(File file) {
        this.f10578a = file;
    }

    public final Object a(e eVar) {
        e0 e0Var = f0.f4761i;
        File file = this.f10578a;
        return new v(new q(e0.b(e0Var, file), r.f4819a, (String) null, (Closeable) null), MimeTypeMap.getSingleton().getMimeTypeFromExtension(k.b(file)), 3);
    }
}
