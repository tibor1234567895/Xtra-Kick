package s6;

import android.view.MenuItem;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import j3.j1;
import o8.j;
import o8.k;

public final /* synthetic */ class b implements k, j {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MainActivity f14362h;

    public /* synthetic */ b(MainActivity mainActivity) {
        this.f14362h = mainActivity;
    }

    public final boolean a(MenuItem menuItem) {
        int i10 = MainActivity.N;
        MainActivity mainActivity = this.f14362h;
        xa.j.f("this$0", mainActivity);
        xa.j.f("it", menuItem);
        j1 j1Var = mainActivity.J;
        if (j1Var != null) {
            m3.b.b(menuItem, j1Var);
            return true;
        }
        xa.j.l("navController");
        throw null;
    }
}
