package j3;

import android.content.Context;
import android.content.ContextWrapper;
import wa.l;
import xa.j;
import xa.k;

public final class d extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public static final d f8516h = new d();

    public d() {
        super(1);
    }

    public final Object invoke(Object obj) {
        Context context = (Context) obj;
        j.f("it", context);
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
