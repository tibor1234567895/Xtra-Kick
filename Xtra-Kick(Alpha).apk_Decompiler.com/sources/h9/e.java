package h9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7734a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7735b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7736c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7737d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f7738e;

    public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(0);
        this.f7734a = atomicReferenceFieldUpdater;
        this.f7735b = atomicReferenceFieldUpdater2;
        this.f7736c = atomicReferenceFieldUpdater3;
        this.f7737d = atomicReferenceFieldUpdater4;
        this.f7738e = atomicReferenceFieldUpdater5;
    }

    public final boolean a(n nVar, d dVar, d dVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f7737d;
            if (atomicReferenceFieldUpdater.compareAndSet(nVar, dVar, dVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(nVar) == dVar);
        return false;
    }

    public final boolean b(n nVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f7738e;
            if (atomicReferenceFieldUpdater.compareAndSet(nVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(nVar) == obj);
        return false;
    }

    public final boolean c(n nVar, m mVar, m mVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f7736c;
            if (atomicReferenceFieldUpdater.compareAndSet(nVar, mVar, mVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(nVar) == mVar);
        return false;
    }

    public final void d(m mVar, m mVar2) {
        this.f7735b.lazySet(mVar, mVar2);
    }

    public final void e(m mVar, Thread thread) {
        this.f7734a.lazySet(mVar, thread);
    }
}
