package z0;

import android.view.ViewGroup;
import androidx.fragment.app.c0;
import xa.j;

public final class e extends i {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(c0 c0Var, ViewGroup viewGroup, int i10) {
        super(c0Var, "Attempting to use <fragment> tag to add fragment " + c0Var + " to container " + viewGroup);
        if (i10 != 1) {
            return;
        }
        j.f("container", viewGroup);
        super(c0Var, "Attempting to add fragment " + c0Var + " to container " + viewGroup + " which is not a FragmentContainerView");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(c0 c0Var, String str) {
        super(c0Var, "Attempting to reuse fragment " + c0Var + " with previous ID " + str);
        j.f("fragment", c0Var);
        j.f("previousFragmentId", str);
    }
}
