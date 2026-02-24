package g5;

import android.support.v4.media.j;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f6831a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6832b;

    /* renamed from: c  reason: collision with root package name */
    public final f f6833c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6834d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f6835e = new AtomicInteger();

    public b(a aVar, String str, d dVar, boolean z10) {
        this.f6831a = aVar;
        this.f6832b = str;
        this.f6833c = dVar;
        this.f6834d = z10;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f6831a.newThread(new j((Object) this, 7, (Object) runnable));
        newThread.setName("glide-" + this.f6832b + "-thread-" + this.f6835e.getAndIncrement());
        return newThread;
    }
}
