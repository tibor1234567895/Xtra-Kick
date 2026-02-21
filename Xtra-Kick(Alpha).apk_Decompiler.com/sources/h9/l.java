package h9;

import sun.misc.Unsafe;

public final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f7746a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f7747b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f7748c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f7749d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f7750e;

    /* renamed from: f  reason: collision with root package name */
    public static final long f7751f;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
        throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new h9.k());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    static {
        /*
            java.lang.Class<h9.m> r0 = h9.m.class
            sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
            goto L_0x0012
        L_0x0007:
            h9.k r1 = new h9.k     // Catch:{ PrivilegedActionException -> 0x005d }
            r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
            java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
            sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
        L_0x0012:
            java.lang.Class<h9.n> r2 = h9.n.class
            java.lang.String r3 = "j"
            java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
            long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
            f7748c = r3     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "i"
            java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
            long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
            f7747b = r3     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "h"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
            long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
            f7749d = r2     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = "a"
            java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
            long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
            f7750e = r2     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = "b"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
            long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
            f7751f = r2     // Catch:{ Exception -> 0x0053 }
            f7746a = r1     // Catch:{ Exception -> 0x0053 }
            return
        L_0x0053:
            r0 = move-exception
            c9.z.a(r0)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x005d:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Could not initialize intrinsics"
            java.lang.Throwable r0 = r0.getCause()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.l.<clinit>():void");
    }

    private l() {
        super(0);
    }

    public final boolean a(n nVar, d dVar, d dVar2) {
        return j.a(f7746a, nVar, f7747b, dVar, dVar2);
    }

    public final boolean b(n nVar, Object obj, Object obj2) {
        return j.a(f7746a, nVar, f7749d, obj, obj2);
    }

    public final boolean c(n nVar, m mVar, m mVar2) {
        return j.a(f7746a, nVar, f7748c, mVar, mVar2);
    }

    public final void d(m mVar, m mVar2) {
        f7746a.putObject(mVar, f7751f, mVar2);
    }

    public final void e(m mVar, Thread thread) {
        f7746a.putObject(mVar, f7750e, thread);
    }

    public /* synthetic */ l(int i10) {
        this();
    }
}
