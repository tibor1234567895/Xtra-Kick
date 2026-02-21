package nb;

import e0.q;
import hb.h0;
import java.util.concurrent.TimeUnit;
import mb.b0;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11824a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f11825b = h0.M1("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, Long.MAX_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public static final int f11826c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f11827d = h0.N1("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final long f11828e = TimeUnit.SECONDS.toNanos(h0.M1("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 1, Long.MAX_VALUE));

    /* renamed from: f  reason: collision with root package name */
    public static final g f11829f = g.f11819a;

    /* renamed from: g  reason: collision with root package name */
    public static final q f11830g = new q(0);

    /* renamed from: h  reason: collision with root package name */
    public static final q f11831h = new q(1);

    static {
        String str;
        int i10 = b0.f10840a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f11824a = str;
        int i11 = b0.f10840a;
        if (i11 < 2) {
            i11 = 2;
        }
        f11826c = h0.N1("kotlinx.coroutines.scheduler.core.pool.size", i11, 1, 0, 8);
    }
}
