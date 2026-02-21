package nb;

import e0.q;
import hb.h0;

public final class k extends j {

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f11823j;

    public k(Runnable runnable, long j10, q qVar) {
        super(j10, qVar);
        this.f11823j = runnable;
    }

    public final void run() {
        try {
            this.f11823j.run();
        } finally {
            this.f11822i.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Task[");
        Runnable runnable = this.f11823j;
        sb2.append(runnable.getClass().getSimpleName());
        sb2.append('@');
        sb2.append(h0.r0(runnable));
        sb2.append(", ");
        sb2.append(this.f11821h);
        sb2.append(", ");
        sb2.append(this.f11822i);
        sb2.append(']');
        return sb2.toString();
    }
}
