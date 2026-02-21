package j3;

import android.content.Context;
import android.content.ContextWrapper;
import wa.l;
import xa.j;
import xa.k;

public final class z extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public static final z f8726h = new z();

    public z() {
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
