package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import xa.j;

public final class t0 {
    static {
        new t0();
    }

    private t0() {
    }

    public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        j.f("activity", activity);
        j.f("callback", activityLifecycleCallbacks);
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
