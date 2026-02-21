package dc;

import java.util.concurrent.atomic.AtomicReference;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final l0 f4795a = new l0();

    /* renamed from: b  reason: collision with root package name */
    public static final int f4796b = 65536;

    /* renamed from: c  reason: collision with root package name */
    public static final k0 f4797c = new k0(new byte[0], 0, 0, false, false);

    /* renamed from: d  reason: collision with root package name */
    public static final int f4798d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicReference[] f4799e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f4798d = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i10 = 0; i10 < highestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference();
        }
        f4799e = atomicReferenceArr;
    }

    private l0() {
    }

    public static final void a(k0 k0Var) {
        boolean z10;
        int i10;
        if (k0Var.f4793f == null && k0Var.f4794g == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!k0Var.f4791d) {
            f4795a.getClass();
            AtomicReference atomicReference = f4799e[(int) (Thread.currentThread().getId() & (((long) f4798d) - 1))];
            k0 k0Var2 = f4797c;
            k0 k0Var3 = (k0) atomicReference.getAndSet(k0Var2);
            if (k0Var3 != k0Var2) {
                if (k0Var3 != null) {
                    i10 = k0Var3.f4790c;
                } else {
                    i10 = 0;
                }
                if (i10 >= f4796b) {
                    atomicReference.set(k0Var3);
                    return;
                }
                k0Var.f4793f = k0Var3;
                k0Var.f4789b = 0;
                k0Var.f4790c = i10 + 8192;
                atomicReference.set(k0Var);
            }
        }
    }

    public static final k0 b() {
        f4795a.getClass();
        AtomicReference atomicReference = f4799e[(int) (Thread.currentThread().getId() & (((long) f4798d) - 1))];
        k0 k0Var = f4797c;
        k0 k0Var2 = (k0) atomicReference.getAndSet(k0Var);
        if (k0Var2 == k0Var) {
            return new k0();
        }
        if (k0Var2 == null) {
            atomicReference.set((Object) null);
            return new k0();
        }
        atomicReference.set(k0Var2.f4793f);
        k0Var2.f4793f = null;
        k0Var2.f4790c = 0;
        return k0Var2;
    }
}
