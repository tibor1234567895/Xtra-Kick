package d5;

import androidx.activity.h;
import b5.j;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4359a = false;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f4360b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ReferenceQueue f4361c = new ReferenceQueue();

    /* renamed from: d  reason: collision with root package name */
    public f0 f4362d;

    public c() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new a());
        newSingleThreadExecutor.execute(new h(15, this));
    }

    public final synchronized void a(j jVar, g0 g0Var) {
        b bVar = (b) this.f4360b.put(jVar, new b(jVar, g0Var, this.f4361c, this.f4359a));
        if (bVar != null) {
            bVar.f4339c = null;
            bVar.clear();
        }
    }

    public final void b(b bVar) {
        synchronized (this) {
            this.f4360b.remove(bVar.f4337a);
            if (bVar.f4338b) {
                o0 o0Var = bVar.f4339c;
                if (o0Var != null) {
                    g0 g0Var = new g0(o0Var, true, false, bVar.f4337a, this.f4362d);
                    ((w) this.f4362d).e(bVar.f4337a, g0Var);
                }
            }
        }
    }
}
