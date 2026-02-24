package mb;

import pa.k;

public final class h extends RuntimeException {

    /* renamed from: h  reason: collision with root package name */
    public final transient k f10856h;

    public h(k kVar) {
        this.f10856h = kVar;
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final String getLocalizedMessage() {
        return this.f10856h.toString();
    }
}
