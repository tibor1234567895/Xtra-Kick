package x4;

import java.util.concurrent.Callable;

public final class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f16650a;

    public a(d dVar) {
        this.f16650a = dVar;
    }

    public final Object call() {
        synchronized (this.f16650a) {
            d dVar = this.f16650a;
            if (dVar.f16667p != null) {
                dVar.I0();
                if (this.f16650a.N()) {
                    this.f16650a.j0();
                    this.f16650a.f16669r = 0;
                }
            }
        }
        return null;
    }
}
