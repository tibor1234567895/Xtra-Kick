package hb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7787b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* renamed from: a  reason: collision with root package name */
    public final k0[] f7788a;
    private volatile int notCompletedCount;

    public e(k0[] k0VarArr) {
        this.f7788a = k0VarArr;
        this.notCompletedCount = k0VarArr.length;
    }
}
