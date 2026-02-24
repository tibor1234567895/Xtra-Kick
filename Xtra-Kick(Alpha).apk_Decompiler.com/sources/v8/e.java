package v8;

import a5.u;
import android.os.Handler;
import android.os.Looper;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static e f15968b;

    /* renamed from: a  reason: collision with root package name */
    public final Object f15969a = new Object();

    private e() {
        new Handler(Looper.getMainLooper(), new u(2, this));
    }

    public static e a() {
        if (f15968b == null) {
            f15968b = new e();
        }
        return f15968b;
    }

    public final void b() {
        synchronized (this.f15969a) {
        }
    }
}
