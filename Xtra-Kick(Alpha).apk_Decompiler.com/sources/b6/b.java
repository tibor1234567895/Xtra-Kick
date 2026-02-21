package b6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.f0;
import androidx.fragment.app.m0;
import com.github.andreyasadchy.xtra.XtraApp;
import java.util.concurrent.CopyOnWriteArrayList;
import xa.j;

public final class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XtraApp f2639a;

    public b(XtraApp xtraApp) {
        this.f2639a = xtraApp;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        j.f("activity", activity);
        if (activity instanceof f0) {
            ((CopyOnWriteArrayList) ((f0) activity).A().f1384n.f1511a).add(new m0(new a(this.f2639a), true));
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        j.f("activity", activity);
    }

    public final void onActivityPaused(Activity activity) {
        j.f("activity", activity);
    }

    public final void onActivityResumed(Activity activity) {
        j.f("activity", activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        j.f("activity", activity);
        j.f("outState", bundle);
    }

    public final void onActivityStarted(Activity activity) {
        j.f("activity", activity);
    }

    public final void onActivityStopped(Activity activity) {
        j.f("activity", activity);
    }
}
