package h9;

import android.support.v4.media.j;
import c9.v;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public final class w extends y {
    private w() {
    }

    public static void a(e0 e0Var, v vVar, Executor executor) {
        e0Var.a(new j((Object) e0Var, (Object) vVar, 8), executor);
    }

    public static Object b(Future future) {
        Object obj;
        boolean z10 = false;
        if (future.isDone()) {
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                } catch (Throwable th) {
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return obj;
        }
        throw new IllegalStateException(v.a("Future was expected to be done: %s", future));
    }
}
