package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class g implements Executor {

    /* renamed from: h  reason: collision with root package name */
    public final Handler f1991h = new Handler(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f1991h.post(runnable);
    }
}
