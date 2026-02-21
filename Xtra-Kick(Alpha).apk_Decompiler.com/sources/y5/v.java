package y5;

import android.app.Application;
import com.github.andreyasadchy.xtra.XtraApp;
import xa.j;

public final class v {
    private v() {
    }

    public /* synthetic */ v(int i10) {
        this();
    }

    public static Application a() {
        Application application = XtraApp.f3320l;
        if (application != null) {
            return application;
        }
        j.l("INSTANCE");
        throw null;
    }
}
