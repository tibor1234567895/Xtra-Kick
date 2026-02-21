package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import xa.j;

public final class w0 extends k {
    final /* synthetic */ y0 this$0;

    public w0(y0 y0Var) {
        this.this$0 = y0Var;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        j.f("activity", activity);
        if (Build.VERSION.SDK_INT < 29) {
            g1.f1694i.getClass();
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            j.d("null cannot be cast to non-null type androidx.lifecycle.ReportFragment", findFragmentByTag);
            ((g1) findFragmentByTag).f1695h = this.this$0.f1801o;
        }
    }

    public void onActivityPaused(Activity activity) {
        j.f("activity", activity);
        y0 y0Var = this.this$0;
        int i10 = y0Var.f1795i - 1;
        y0Var.f1795i = i10;
        if (i10 == 0) {
            Handler handler = y0Var.f1798l;
            j.c(handler);
            handler.postDelayed(y0Var.f1800n, 700);
        }
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        j.f("activity", activity);
        t0.a(activity, new v0(this.this$0));
    }

    public void onActivityStopped(Activity activity) {
        j.f("activity", activity);
        y0 y0Var = this.this$0;
        int i10 = y0Var.f1794h - 1;
        y0Var.f1794h = i10;
        if (i10 == 0 && y0Var.f1796j) {
            y0Var.f1799m.f(r.ON_STOP);
            y0Var.f1797k = true;
        }
    }
}
