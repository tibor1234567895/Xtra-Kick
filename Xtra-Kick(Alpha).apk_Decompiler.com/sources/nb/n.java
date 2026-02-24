package nb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f11833b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f11834c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f11835d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f11836e;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReferenceArray f11837a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        Class<n> cls = n.class;
        f11833b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f11834c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f11835d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f11836e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public final j a(j jVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11834c;
        if (atomicIntegerFieldUpdater.get(this) - f11835d.get(this) == 127) {
            return jVar;
        }
        boolean z10 = true;
        if (jVar.f11822i.f4883h != 1) {
            z10 = false;
        }
        if (z10) {
            f11836e.incrementAndGet(this);
        }
        int i10 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f11837a;
            if (atomicReferenceArray.get(i10) != null) {
                Thread.yield();
            } else {
                atomicReferenceArray.lazySet(i10, jVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
        }
    }

    public final j b() {
        j jVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f11835d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f11834c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (jVar = (j) this.f11837a.getAndSet(i11, (Object) null)) != null) {
                boolean z10 = true;
                if (jVar.f11822i.f4883h != 1) {
                    z10 = false;
                }
                if (z10) {
                    f11836e.decrementAndGet(this);
                }
                return jVar;
            }
        }
    }

    public final j c(int i10, boolean z10) {
        boolean z11;
        int i11 = i10 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f11837a;
        j jVar = (j) atomicReferenceArray.get(i11);
        if (jVar != null) {
            boolean z12 = false;
            if (jVar.f11822i.f4883h == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 == z10) {
                while (true) {
                    if (!atomicReferenceArray.compareAndSet(i11, jVar, (Object) null)) {
                        if (atomicReferenceArray.get(i11) != jVar) {
                            break;
                        }
                    } else {
                        z12 = true;
                        break;
                    }
                }
                if (z12) {
                    if (z10) {
                        f11836e.decrementAndGet(this);
                    }
                    return jVar;
                }
            }
        }
        return null;
    }
}
