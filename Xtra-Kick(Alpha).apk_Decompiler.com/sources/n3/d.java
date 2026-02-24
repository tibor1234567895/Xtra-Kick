package n3;

import java.util.concurrent.locks.ReentrantLock;
import kb.e1;
import kb.f1;
import wa.l;
import xa.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f11097a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public final e1 f11098b;

    /* renamed from: c  reason: collision with root package name */
    public final c f11099c;

    public d() {
        c1.f11077d.getClass();
        this.f11098b = f1.a(c1.f11078e);
        this.f11099c = new c();
    }

    public final Object a(l lVar) {
        c cVar = this.f11099c;
        j.f("block", lVar);
        ReentrantLock reentrantLock = this.f11097a;
        reentrantLock.lock();
        try {
            Object invoke = lVar.invoke(cVar);
            this.f11098b.k(new c1(cVar.b(d1.REFRESH), cVar.b(d1.PREPEND), cVar.b(d1.APPEND)));
            return invoke;
        } finally {
            reentrantLock.unlock();
        }
    }
}
