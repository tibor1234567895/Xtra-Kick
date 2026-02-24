package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import xa.j;

public final class f1 implements Application.ActivityLifecycleCallbacks {
    public static final e1 Companion = new e1(0);

    public static final void registerIn(Activity activity) {
        Companion.getClass();
        j.f("activity", activity);
        activity.registerActivityLifecycleCallbacks(new f1());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        j.f("activity", activity);
    }

    public void onActivityDestroyed(Activity activity) {
        j.f("activity", activity);
    }

    public void onActivityPaused(Activity activity) {
        j.f("activity", activity);
    }

    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        j.f("activity", activity);
        d1 d1Var = g1.f1694i;
        r rVar = r.ON_CREATE;
        d1Var.getClass();
        d1.a(activity, rVar);
    }

    public void onActivityPostResumed(Activity activity) {
        j.f("activity", activity);
        d1 d1Var = g1.f1694i;
        r rVar = r.ON_RESUME;
        d1Var.getClass();
        d1.a(activity, rVar);
    }

    public void onActivityPostStarted(Activity activity) {
        j.f("activity", activity);
        d1 d1Var = g1.f1694i;
        r rVar = r.ON_START;
        d1Var.getClass();
        d1.a(activity, rVar);
    }

    public void onActivityPreDestroyed(Activity activity) {
        j.f("activity", activity);
        d1 d1Var = g1.f1694i;
        r rVar = r.ON_DESTROY;
        d1Var.getClass();
        d1.a(activity, rVar);
    }

    public void onActivityPrePaused(Activity activity) {
        j.f("activity", activity);
        d1 d1Var = g1.f1694i;
        r rVar = r.ON_PAUSE;
        d1Var.getClass();
        d1.a(activity, rVar);
    }

    public void onActivityPreStopped(Activity activity) {
        j.f("activity", activity);
        d1 d1Var = g1.f1694i;
        r rVar = r.ON_STOP;
        d1Var.getClass();
        d1.a(activity, rVar);
    }

    public void onActivityResumed(Activity activity) {
        j.f("activity", activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        j.f("activity", activity);
        j.f("bundle", bundle);
    }

    public void onActivityStarted(Activity activity) {
        j.f("activity", activity);
    }

    public void onActivityStopped(Activity activity) {
        j.f("activity", activity);
    }
}
