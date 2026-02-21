package o4;

import java.io.File;
import s4.m;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12191a;

    public a(boolean z10) {
        this.f12191a = z10;
    }

    public final String a(Object obj, m mVar) {
        File file = (File) obj;
        if (!this.f12191a) {
            return file.getPath();
        }
        return file.getPath() + ':' + file.lastModified();
    }
}
