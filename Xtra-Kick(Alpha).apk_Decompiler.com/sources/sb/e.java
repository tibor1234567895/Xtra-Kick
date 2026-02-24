package sb;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import qb.g;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f14469a;

    public e(g gVar) {
        this.f14469a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), gVar);
    }
}
