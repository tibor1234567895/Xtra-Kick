package h9;

import c9.z;

public final class i0 extends i implements Runnable {

    /* renamed from: o  reason: collision with root package name */
    public final Runnable f7744o;

    public i0(Runnable runnable) {
        runnable.getClass();
        this.f7744o = runnable;
    }

    public final String j() {
        String valueOf = String.valueOf(this.f7744o);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
        sb2.append("task=[");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    public final void run() {
        try {
            this.f7744o.run();
        } catch (Throwable th) {
            m(th);
            z.a(th);
            throw new RuntimeException(th);
        }
    }
}
