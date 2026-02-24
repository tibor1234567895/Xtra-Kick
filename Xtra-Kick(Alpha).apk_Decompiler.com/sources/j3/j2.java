package j3;

import android.view.View;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import wa.l;
import xa.j;
import xa.k;

public final class j2 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public static final j2 f8573h = new j2();

    public j2() {
        super(1);
    }

    public final Object invoke(Object obj) {
        View view = (View) obj;
        j.f("it", view);
        k2.f8602a.getClass();
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            tag = ((WeakReference) tag).get();
        } else if (!(tag instanceof k0)) {
            return null;
        }
        return (k0) tag;
    }
}
