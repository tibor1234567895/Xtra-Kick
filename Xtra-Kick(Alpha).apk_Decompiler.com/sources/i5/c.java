package i5;

import android.content.Context;
import android.net.Uri;
import h5.i0;
import h5.j0;
import h5.q0;
import java.io.File;

public abstract class c implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8282a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f8283b;

    public c(Context context, Class cls) {
        this.f8282a = context;
        this.f8283b = cls;
    }

    public final i0 a(q0 q0Var) {
        Class cls = this.f8283b;
        return new f(this.f8282a, q0Var.c(File.class, cls), q0Var.c(Uri.class, cls), cls);
    }

    public final void b() {
    }
}
