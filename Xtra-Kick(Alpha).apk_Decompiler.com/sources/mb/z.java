package mb;

import hb.a2;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pa.k;

public abstract class z extends e implements a2 {

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f10889k = AtomicIntegerFieldUpdater.newUpdater(z.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: j  reason: collision with root package name */
    public final long f10890j;

    public z(long j10, z zVar, int i10) {
        super(zVar);
        this.f10890j = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    public final boolean c() {
        boolean z10;
        if (f10889k.get(this) != f()) {
            return false;
        }
        if (b() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        boolean z10;
        if (f10889k.addAndGet(this, -65536) != f()) {
            return false;
        }
        if (b() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return true;
        }
        return false;
    }

    public abstract int f();

    public abstract void g(int i10, k kVar);

    public final void h() {
        if (f10889k.incrementAndGet(this) == f()) {
            d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i() {
        /*
            r5 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f10889k
            int r1 = r0.get(r5)
            int r2 = r5.f()
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x001c
            mb.e r2 = r5.b()
            if (r2 != 0) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = 0
            goto L_0x001d
        L_0x001c:
            r2 = 1
        L_0x001d:
            if (r2 != 0) goto L_0x0021
            r3 = 0
            goto L_0x002a
        L_0x0021:
            r2 = 65536(0x10000, float:9.18355E-41)
            int r2 = r2 + r1
            boolean r0 = r0.compareAndSet(r5, r1, r2)
            if (r0 == 0) goto L_0x0000
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.z.i():boolean");
    }
}
