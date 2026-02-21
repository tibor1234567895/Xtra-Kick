package j3;

import android.view.View;
import android.view.ViewParent;
import wa.l;
import xa.j;
import xa.k;

public final class i2 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public static final i2 f8567h = new i2();

    public i2() {
        super(1);
    }

    public final Object invoke(Object obj) {
        View view = (View) obj;
        j.f("it", view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
