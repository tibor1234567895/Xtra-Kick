package ob;

import java.util.concurrent.atomic.AtomicReferenceArray;
import mb.z;

public final class k extends z {

    /* renamed from: l  reason: collision with root package name */
    public final AtomicReferenceArray f12391l = new AtomicReferenceArray(j.f12390f);

    public k(long j10, k kVar, int i10) {
        super(j10, kVar, i10);
    }

    public final int f() {
        return j.f12390f;
    }

    public final void g(int i10, pa.k kVar) {
        this.f12391l.set(i10, j.f12389e);
        h();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f10890j + ", hashCode=" + hashCode() + ']';
    }
}
