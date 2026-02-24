package r;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f13504a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f13505b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f13506c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f13507d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f13508e;

    public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(0);
        this.f13504a = atomicReferenceFieldUpdater;
        this.f13505b = atomicReferenceFieldUpdater2;
        this.f13506c = atomicReferenceFieldUpdater3;
        this.f13507d = atomicReferenceFieldUpdater4;
        this.f13508e = atomicReferenceFieldUpdater5;
    }

    public final boolean a(i iVar, e eVar, e eVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f13507d;
            if (atomicReferenceFieldUpdater.compareAndSet(iVar, eVar, eVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(iVar) == eVar);
        return false;
    }

    public final boolean b(i iVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f13508e;
            if (atomicReferenceFieldUpdater.compareAndSet(iVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(iVar) == obj);
        return false;
    }

    public final boolean c(i iVar, h hVar, h hVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f13506c;
            if (atomicReferenceFieldUpdater.compareAndSet(iVar, hVar, hVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(iVar) == hVar);
        return false;
    }

    public final void d(h hVar, h hVar2) {
        this.f13505b.lazySet(hVar, hVar2);
    }

    public final void e(h hVar, Thread thread) {
        this.f13504a.lazySet(hVar, thread);
    }
}
