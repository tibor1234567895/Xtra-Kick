package j0;

import java.util.concurrent.ThreadFactory;

public final class l implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f8403a = "fonts-androidx";

    /* renamed from: b  reason: collision with root package name */
    public final int f8404b = 10;

    public final Thread newThread(Runnable runnable) {
        return new k(runnable, this.f8403a, this.f8404b);
    }
}
