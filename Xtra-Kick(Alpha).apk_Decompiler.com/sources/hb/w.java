package hb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class w {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7874b = AtomicIntegerFieldUpdater.newUpdater(w.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f7875a;

    public w(Throwable th, boolean z10) {
        this.f7875a = th;
        this._handled = z10 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f7875a + ']';
    }
}
