package h9;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a0 implements e0 {

    /* renamed from: i  reason: collision with root package name */
    public static final a0 f7718i = new a0((Object) null);

    /* renamed from: j  reason: collision with root package name */
    public static final Logger f7719j = Logger.getLogger(a0.class.getName());

    /* renamed from: h  reason: collision with root package name */
    public final Object f7720h;

    public a0(Object obj) {
        this.f7720h = obj;
    }

    public final void a(Runnable runnable, Executor executor) {
        if (executor != null) {
            try {
                executor.execute(runnable);
            } catch (RuntimeException e10) {
                Level level = Level.SEVERE;
                String valueOf = String.valueOf(runnable);
                String valueOf2 = String.valueOf(executor);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + valueOf.length() + 57);
                sb2.append("RuntimeException while executing runnable ");
                sb2.append(valueOf);
                sb2.append(" with executor ");
                sb2.append(valueOf2);
                f7719j.log(level, sb2.toString(), e10);
            }
        } else {
            throw new NullPointerException("Executor was null.");
        }
    }

    public final boolean cancel(boolean z10) {
        return false;
    }

    public final Object get() {
        return this.f7720h;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.f7720h);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + String.valueOf(obj).length() + 27);
        sb2.append(obj);
        sb2.append("[status=SUCCESS, result=[");
        sb2.append(valueOf);
        sb2.append("]]");
        return sb2.toString();
    }

    public final Object get(long j10, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.f7720h;
    }
}
