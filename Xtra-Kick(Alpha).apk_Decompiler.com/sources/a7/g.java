package a7;

import java.io.File;
import java.io.FileFilter;
import va.k;
import xa.j;

public final /* synthetic */ class g implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ File f281a;

    public /* synthetic */ g(File file) {
        this.f281a = file;
    }

    public final boolean accept(File file) {
        j.e("it", file);
        if (!j.a(k.b(file), "m3u8") || j.a(file, this.f281a)) {
            return false;
        }
        return true;
    }
}
