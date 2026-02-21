package gb;

import java.util.concurrent.TimeUnit;

public enum d {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS);
    

    /* renamed from: h  reason: collision with root package name */
    public final TimeUnit f6876h;

    /* access modifiers changed from: public */
    d(TimeUnit timeUnit) {
        this.f6876h = timeUnit;
    }
}
