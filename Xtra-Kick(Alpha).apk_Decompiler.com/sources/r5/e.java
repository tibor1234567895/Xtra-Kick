package r5;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import w5.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f13827a = new AtomicReference();

    /* renamed from: b  reason: collision with root package name */
    public final q.e f13828b = new q.e();

    public final void a(Class cls, Class cls2, Class cls3, List list) {
        synchronized (this.f13828b) {
            this.f13828b.put(new m(cls, cls2, cls3), list);
        }
    }
}
