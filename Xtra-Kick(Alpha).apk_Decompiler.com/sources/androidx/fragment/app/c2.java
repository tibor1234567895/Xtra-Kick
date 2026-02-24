package androidx.fragment.app;

import android.view.ViewGroup;
import com.woxthebox.draglistview.R;
import xa.j;

public final class c2 {
    private c2() {
    }

    public /* synthetic */ c2(int i10) {
        this();
    }

    public static n a(ViewGroup viewGroup, p0 p0Var) {
        j.f("container", viewGroup);
        j.f("factory", p0Var);
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof n) {
            return (n) tag;
        }
        n nVar = new n(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, nVar);
        return nVar;
    }
}
