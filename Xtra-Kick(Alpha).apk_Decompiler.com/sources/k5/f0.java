package k5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class f0 implements Lock {
    public final void lock() {
    }

    public final void lockInterruptibly() {
    }

    public final Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean tryLock() {
        return true;
    }

    public final void unlock() {
    }

    public final boolean tryLock(long j10, TimeUnit timeUnit) {
        return true;
    }
}
