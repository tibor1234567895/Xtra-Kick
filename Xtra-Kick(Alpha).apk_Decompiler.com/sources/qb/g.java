package qb;

import java.util.concurrent.ThreadFactory;
import xa.j;

public final /* synthetic */ class g implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f13491a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f13492b;

    public /* synthetic */ g(String str, boolean z10) {
        this.f13491a = str;
        this.f13492b = z10;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.f13491a;
        j.f("$name", str);
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(this.f13492b);
        return thread;
    }
}
