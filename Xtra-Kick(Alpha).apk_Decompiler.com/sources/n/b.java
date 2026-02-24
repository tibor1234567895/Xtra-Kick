package n;

import android.os.Looper;

public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f10892b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f10893c = new a(1);

    /* renamed from: a  reason: collision with root package name */
    public final d f10894a = new d();

    private b() {
    }

    public static b a() {
        if (f10892b != null) {
            return f10892b;
        }
        synchronized (b.class) {
            if (f10892b == null) {
                f10892b = new b();
            }
        }
        return f10892b;
    }

    public final boolean b() {
        this.f10894a.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public final void c(Runnable runnable) {
        d dVar = this.f10894a;
        if (dVar.f10898c == null) {
            synchronized (dVar.f10896a) {
                if (dVar.f10898c == null) {
                    dVar.f10898c = d.a(Looper.getMainLooper());
                }
            }
        }
        dVar.f10898c.post(runnable);
    }
}
