package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.d0;
import androidx.lifecycle.h;
import androidx.lifecycle.t;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import x3.a;
import x3.b;
import xa.j;

public class EmojiCompatInitializer implements b {
    /* renamed from: b */
    public final Boolean a(Context context) {
        q qVar = new q(context);
        if (p.f1267j == null) {
            synchronized (p.f1266i) {
                if (p.f1267j == null) {
                    p.f1267j = new p(qVar);
                }
            }
        }
        c(context);
        return Boolean.TRUE;
    }

    public final void c(Context context) {
        Object obj;
        a c10 = a.c(context);
        Class<ProcessLifecycleInitializer> cls = ProcessLifecycleInitializer.class;
        c10.getClass();
        synchronized (a.f16646e) {
            try {
                obj = c10.f16647a.get(cls);
                if (obj == null) {
                    obj = c10.b(cls, new HashSet());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        final t o10 = ((d0) obj).o();
        o10.a(new h() {
            public final void a(d0 d0Var) {
                Handler handler;
                EmojiCompatInitializer.this.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = b.a(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new t(), 500);
                o10.c(this);
            }

            public final /* synthetic */ void b(d0 d0Var) {
                android.support.v4.media.h.b(d0Var);
            }

            public final /* synthetic */ void f(d0 d0Var) {
            }

            public final /* synthetic */ void onDestroy(d0 d0Var) {
            }

            public final void onStart(d0 d0Var) {
                j.f("owner", d0Var);
            }

            public final /* synthetic */ void onStop(d0 d0Var) {
            }
        });
    }

    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
