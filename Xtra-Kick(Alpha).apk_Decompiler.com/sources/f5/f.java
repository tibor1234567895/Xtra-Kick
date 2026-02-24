package f5;

import android.content.Context;
import android.support.v4.media.n;
import h3.u2;
import java.io.File;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public final long f5820a = 262144000;

    /* renamed from: b  reason: collision with root package name */
    public final n f5821b;

    public f(n nVar) {
        this.f5821b = nVar;
    }

    public final u2 a() {
        n nVar = this.f5821b;
        File cacheDir = ((Context) nVar.f337i).getCacheDir();
        if (cacheDir == null) {
            cacheDir = null;
        } else if (((String) nVar.f338j) != null) {
            cacheDir = new File(cacheDir, (String) nVar.f338j);
        }
        if (cacheDir == null) {
            return null;
        }
        if (cacheDir.isDirectory() || cacheDir.mkdirs()) {
            return new u2(cacheDir, this.f5820a);
        }
        return null;
    }
}
