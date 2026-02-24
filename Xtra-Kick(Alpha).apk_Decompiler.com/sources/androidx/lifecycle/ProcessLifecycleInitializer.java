package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.List;
import ma.b0;
import x3.a;
import x3.b;
import xa.j;

public final class ProcessLifecycleInitializer implements b {
    public final Object a(Context context) {
        j.f("context", context);
        a c10 = a.c(context);
        j.e("getInstance(context)", c10);
        if (c10.f16648b.contains(ProcessLifecycleInitializer.class)) {
            if (!a0.f1645a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                j.d("null cannot be cast to non-null type android.app.Application", applicationContext);
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new z());
            }
            y0.f1792p.getClass();
            y0 y0Var = y0.f1793q;
            y0Var.getClass();
            y0Var.f1798l = new Handler();
            y0Var.f1799m.f(r.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            j.d("null cannot be cast to non-null type android.app.Application", applicationContext2);
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new w0(y0Var));
            return y0Var;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }

    public final List dependencies() {
        return b0.f10801h;
    }
}
