package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import xa.j;

public final class d1 {
    private d1() {
    }

    public /* synthetic */ d1(int i10) {
        this();
    }

    public static void a(Activity activity, r rVar) {
        j.f("activity", activity);
        j.f("event", rVar);
        if (activity instanceof d0) {
            t o10 = ((d0) activity).o();
            if (o10 instanceof g0) {
                ((g0) o10).f(rVar);
            }
        }
    }

    public static void b(Activity activity) {
        j.f("activity", activity);
        if (Build.VERSION.SDK_INT >= 29) {
            f1.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new f1());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new g1(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
