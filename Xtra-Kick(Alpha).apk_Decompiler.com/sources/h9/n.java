package h9;

import i9.a;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class n extends a implements e0 {

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f7758k;

    /* renamed from: l  reason: collision with root package name */
    public static final Logger f7759l;

    /* renamed from: m  reason: collision with root package name */
    public static final a f7760m;

    /* renamed from: n  reason: collision with root package name */
    public static final Object f7761n = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile Object f7762h;

    /* renamed from: i  reason: collision with root package name */
    public volatile d f7763i;

    /* renamed from: j  reason: collision with root package name */
    public volatile m f7764j;

    static {
        boolean z10;
        a aVar;
        Class<m> cls = m.class;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f7758k = z10;
        Class<n> cls2 = n.class;
        f7759l = Logger.getLogger(cls2.getName());
        Throwable th = null;
        try {
            aVar = new l(0);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            aVar = new g(0);
        }
        f7760m = aVar;
        if (th != null) {
            Logger logger = f7759l;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
    }

    private void c(StringBuilder sb2) {
        Object obj;
        String str = "]";
        boolean z10 = false;
        while (true) {
            try {
                obj = get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (ExecutionException e10) {
                sb2.append("FAILURE, cause=[");
                sb2.append(e10.getCause());
                sb2.append(str);
                return;
            } catch (CancellationException unused2) {
                str = "CANCELLED";
                sb2.append(str);
                return;
            } catch (RuntimeException e11) {
                sb2.append("UNKNOWN, cause=[");
                sb2.append(e11.getClass());
                str = " thrown from get()]";
                sb2.append(str);
                return;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        sb2.append("SUCCESS, result=[");
        e(obj, sb2);
        sb2.append(str);
    }

    public static void f(n nVar) {
        d dVar;
        d dVar2;
        d dVar3 = null;
        while (true) {
            m mVar = nVar.f7764j;
            if (f7760m.c(nVar, mVar, m.f7754c)) {
                while (mVar != null) {
                    Thread thread = mVar.f7755a;
                    if (thread != null) {
                        mVar.f7755a = null;
                        LockSupport.unpark(thread);
                    }
                    mVar = mVar.f7756b;
                }
                nVar.d();
                do {
                    dVar = nVar.f7763i;
                } while (!f7760m.a(nVar, dVar, d.f7728d));
                while (true) {
                    dVar2 = dVar3;
                    dVar3 = dVar;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar = dVar3.f7731c;
                    dVar3.f7731c = dVar2;
                }
                while (dVar2 != null) {
                    dVar3 = dVar2.f7731c;
                    Runnable runnable = dVar2.f7729a;
                    Objects.requireNonNull(runnable);
                    Runnable runnable2 = runnable;
                    if (runnable2 instanceof f) {
                        f fVar = (f) runnable2;
                        nVar = fVar.f7739h;
                        if (nVar.f7762h == fVar) {
                            if (f7760m.b(nVar, fVar, i(fVar.f7740i))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = dVar2.f7730b;
                        Objects.requireNonNull(executor);
                        g(runnable2, executor);
                    }
                    dVar2 = dVar3;
                }
                return;
            }
        }
    }

    public static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + valueOf.length() + 57);
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            f7759l.log(level, sb2.toString(), e10);
        }
    }

    private static Object h(Object obj) {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f7724b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f7727a);
        } else if (obj == f7761n) {
            return null;
        } else {
            return obj;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object i(h9.e0 r8) {
        /*
            java.lang.String r0 = "get() did not throw CancellationException, despite reporting isCancelled() == true: "
            boolean r1 = r8 instanceof h9.h
            r2 = 0
            if (r1 == 0) goto L_0x0028
            h9.n r8 = (h9.n) r8
            java.lang.Object r8 = r8.f7762h
            boolean r0 = r8 instanceof h9.b
            if (r0 == 0) goto L_0x0024
            r0 = r8
            h9.b r0 = (h9.b) r0
            boolean r1 = r0.f7723a
            if (r1 == 0) goto L_0x0024
            java.lang.Throwable r8 = r0.f7724b
            if (r8 == 0) goto L_0x0022
            h9.b r8 = new h9.b
            java.lang.Throwable r0 = r0.f7724b
            r8.<init>(r0, r2)
            goto L_0x0024
        L_0x0022:
            h9.b r8 = h9.b.f7722d
        L_0x0024:
            java.util.Objects.requireNonNull(r8)
            return r8
        L_0x0028:
            boolean r1 = r8 instanceof i9.a
            if (r1 == 0) goto L_0x003b
            r1 = r8
            i9.a r1 = (i9.a) r1
            java.lang.Throwable r1 = r1.b()
            if (r1 == 0) goto L_0x003b
            h9.c r8 = new h9.c
            r8.<init>(r1)
            return r8
        L_0x003b:
            boolean r1 = r8.isCancelled()
            boolean r3 = f7758k
            r4 = 1
            r3 = r3 ^ r4
            r3 = r3 & r1
            if (r3 == 0) goto L_0x004c
            h9.b r8 = h9.b.f7722d
            java.util.Objects.requireNonNull(r8)
            return r8
        L_0x004c:
            r3 = 0
        L_0x004d:
            java.lang.Object r4 = r8.get()     // Catch:{ InterruptedException -> 0x00fa, all -> 0x008b }
            if (r3 == 0) goto L_0x005a
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            r3.interrupt()     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
        L_0x005a:
            if (r1 == 0) goto L_0x0086
            h9.b r3 = new h9.b     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            int r6 = r5.length()     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            int r6 = r6 + 84
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            r7.<init>(r6)     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            r7.append(r0)     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            r7.append(r5)     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            java.lang.String r5 = r7.toString()     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            r4.<init>(r5)     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            r3.<init>(r4, r2)     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            return r3
        L_0x0080:
            r8 = move-exception
            goto L_0x0096
        L_0x0082:
            r0 = move-exception
            goto L_0x009c
        L_0x0084:
            r3 = move-exception
            goto L_0x00ca
        L_0x0086:
            if (r4 != 0) goto L_0x008a
            java.lang.Object r4 = f7761n     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
        L_0x008a:
            return r4
        L_0x008b:
            r4 = move-exception
            if (r3 == 0) goto L_0x0095
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
            r3.interrupt()     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
        L_0x0095:
            throw r4     // Catch:{ ExecutionException -> 0x0084, CancellationException -> 0x0082, all -> 0x0080 }
        L_0x0096:
            h9.c r0 = new h9.c
            r0.<init>(r8)
            return r0
        L_0x009c:
            if (r1 != 0) goto L_0x00c4
            h9.c r1 = new h9.c
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r3 = r8.length()
            int r3 = r3 + 77
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "get() threw CancellationException, despite reporting isCancelled() == false: "
            r4.append(r3)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r2.<init>(r8, r0)
            r1.<init>(r2)
            return r1
        L_0x00c4:
            h9.b r8 = new h9.b
            r8.<init>(r0, r2)
            return r8
        L_0x00ca:
            if (r1 == 0) goto L_0x00f0
            h9.b r1 = new h9.b
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r5 = r8.length()
            int r5 = r5 + 84
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r0)
            r6.append(r8)
            java.lang.String r8 = r6.toString()
            r4.<init>(r8, r3)
            r1.<init>(r4, r2)
            return r1
        L_0x00f0:
            h9.c r8 = new h9.c
            java.lang.Throwable r0 = r3.getCause()
            r8.<init>(r0)
            return r8
        L_0x00fa:
            r3 = 1
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.n.i(h9.e0):java.lang.Object");
    }

    public void a(Runnable runnable, Executor executor) {
        d dVar;
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        } else if (isDone() || (dVar = this.f7763i) == d.f7728d) {
            g(runnable, executor);
        } else {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f7731c = dVar;
                if (!f7760m.a(this, dVar, dVar2)) {
                    dVar = this.f7763i;
                } else {
                    return;
                }
            } while (dVar != d.f7728d);
            g(runnable, executor);
        }
    }

    public final Throwable b() {
        if (!(this instanceof h)) {
            return null;
        }
        Object obj = this.f7762h;
        if (obj instanceof c) {
            return ((c) obj).f7727a;
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, h9.e0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f7762h
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof h9.f
            r3 = r3 | r4
            if (r3 == 0) goto L_0x005f
            boolean r3 = f7758k
            if (r3 == 0) goto L_0x001f
            h9.b r3 = new h9.b
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r4, r8)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            h9.b r3 = h9.b.f7721c
            goto L_0x0026
        L_0x0024:
            h9.b r3 = h9.b.f7722d
        L_0x0026:
            java.util.Objects.requireNonNull(r3)
        L_0x0029:
            r5 = 0
            r4 = r7
        L_0x002b:
            h9.a r6 = f7760m
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0057
            f(r4)
            boolean r4 = r0 instanceof h9.f
            if (r4 == 0) goto L_0x0060
            h9.f r0 = (h9.f) r0
            h9.e0 r0 = r0.f7740i
            boolean r4 = r0 instanceof h9.h
            if (r4 == 0) goto L_0x0053
            r4 = r0
            h9.n r4 = (h9.n) r4
            java.lang.Object r0 = r4.f7762h
            if (r0 != 0) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            boolean r6 = r0 instanceof h9.f
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0060
            r5 = 1
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
            goto L_0x0060
        L_0x0057:
            java.lang.Object r0 = r4.f7762h
            boolean r6 = r0 instanceof h9.f
            if (r6 != 0) goto L_0x002b
            r1 = r5
            goto L_0x0060
        L_0x005f:
            r1 = 0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.n.cancel(boolean):boolean");
    }

    public void d() {
    }

    public final void e(Object obj, StringBuilder sb2) {
        String str;
        if (obj == null) {
            str = "null";
        } else if (obj == this) {
            str = "this future";
        } else {
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            str = Integer.toHexString(System.identityHashCode(obj));
        }
        sb2.append(str);
    }

    public Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f7762h;
            if ((obj2 != null) && (!(obj2 instanceof f))) {
                return h(obj2);
            }
            m mVar = this.f7764j;
            m mVar2 = m.f7754c;
            if (mVar != mVar2) {
                m mVar3 = new m();
                do {
                    a aVar = f7760m;
                    aVar.d(mVar3, mVar);
                    if (aVar.c(this, mVar, mVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f7762h;
                            } else {
                                k(mVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return h(obj);
                    }
                    mVar = this.f7764j;
                } while (mVar != mVar2);
            }
            Object obj3 = this.f7762h;
            Objects.requireNonNull(obj3);
            return h(obj3);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.f7762h instanceof b;
    }

    public boolean isDone() {
        Object obj = this.f7762h;
        return (!(obj instanceof f)) & (obj != null);
    }

    public String j() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }

    public final void k(m mVar) {
        mVar.f7755a = null;
        while (true) {
            m mVar2 = this.f7764j;
            if (mVar2 != m.f7754c) {
                m mVar3 = null;
                while (mVar2 != null) {
                    m mVar4 = mVar2.f7756b;
                    if (mVar2.f7755a != null) {
                        mVar3 = mVar2;
                    } else if (mVar3 != null) {
                        mVar3.f7756b = mVar4;
                        if (mVar3.f7755a == null) {
                        }
                    } else if (!f7760m.c(this, mVar2, mVar4)) {
                    }
                    mVar2 = mVar4;
                }
                return;
            }
            return;
        }
    }

    public boolean l(Object obj) {
        if (obj == null) {
            obj = f7761n;
        }
        if (!f7760m.b(this, (Object) null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean m(Throwable th) {
        if (!f7760m.b(this, (Object) null, new c(th))) {
            return false;
        }
        f(this);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.google.common.util.concurrent."
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L_0x001e
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            goto L_0x0026
        L_0x001e:
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getName()
        L_0x0026:
            r0.append(r1)
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r7)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r1 = "[status="
            r0.append(r1)
            boolean r1 = r7.isCancelled()
            java.lang.String r2 = "]"
            if (r1 == 0) goto L_0x004d
            java.lang.String r1 = "CANCELLED"
            r0.append(r1)
            goto L_0x00df
        L_0x004d:
            boolean r1 = r7.isDone()
            if (r1 == 0) goto L_0x0058
            r7.c(r0)
            goto L_0x00df
        L_0x0058:
            int r1 = r0.length()
            java.lang.String r3 = "PENDING"
            r0.append(r3)
            java.lang.Object r3 = r7.f7762h
            boolean r4 = r3 instanceof h9.f
            java.lang.String r5 = "Exception thrown from implementation: "
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ", setFuture=["
            r0.append(r4)
            h9.f r3 = (h9.f) r3
            h9.e0 r3 = r3.f7740i
            if (r3 != r7) goto L_0x007a
            java.lang.String r3 = "this future"
            r0.append(r3)     // Catch:{ RuntimeException -> 0x0080, StackOverflowError -> 0x007e }
            goto L_0x00cc
        L_0x007a:
            r0.append(r3)     // Catch:{ RuntimeException -> 0x0080, StackOverflowError -> 0x007e }
            goto L_0x00cc
        L_0x007e:
            r3 = move-exception
            goto L_0x0081
        L_0x0080:
            r3 = move-exception
        L_0x0081:
            r0.append(r5)
            java.lang.Class r3 = r3.getClass()
            r0.append(r3)
            goto L_0x00cc
        L_0x008c:
            java.lang.String r3 = r7.j()     // Catch:{ RuntimeException -> 0x00a4, StackOverflowError -> 0x00a2 }
            int r4 = c9.p.f3044a     // Catch:{ RuntimeException -> 0x00a4, StackOverflowError -> 0x00a2 }
            if (r3 == 0) goto L_0x009d
            boolean r4 = r3.isEmpty()     // Catch:{ RuntimeException -> 0x00a4, StackOverflowError -> 0x00a2 }
            if (r4 == 0) goto L_0x009b
            goto L_0x009d
        L_0x009b:
            r4 = 0
            goto L_0x009e
        L_0x009d:
            r4 = 1
        L_0x009e:
            if (r4 == 0) goto L_0x00c2
            r3 = 0
            goto L_0x00c2
        L_0x00a2:
            r3 = move-exception
            goto L_0x00a5
        L_0x00a4:
            r3 = move-exception
        L_0x00a5:
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            int r4 = r4 + 38
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            r6.append(r5)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
        L_0x00c2:
            if (r3 == 0) goto L_0x00cf
            java.lang.String r4 = ", info=["
            r0.append(r4)
            r0.append(r3)
        L_0x00cc:
            r0.append(r2)
        L_0x00cf:
            boolean r3 = r7.isDone()
            if (r3 == 0) goto L_0x00df
            int r3 = r0.length()
            r0.delete(r1, r3)
            r7.c(r0)
        L_0x00df:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.n.toString():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(long r20, java.util.concurrent.TimeUnit r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            long r4 = r3.toNanos(r1)
            boolean r6 = java.lang.Thread.interrupted()
            if (r6 != 0) goto L_0x01de
            java.lang.Object r6 = r0.f7762h
            r8 = 1
            if (r6 == 0) goto L_0x0017
            r9 = 1
            goto L_0x0018
        L_0x0017:
            r9 = 0
        L_0x0018:
            boolean r10 = r6 instanceof h9.f
            r10 = r10 ^ r8
            r9 = r9 & r10
            if (r9 == 0) goto L_0x0023
            java.lang.Object r1 = h(r6)
            return r1
        L_0x0023:
            r9 = 0
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x002f
            long r11 = java.lang.System.nanoTime()
            long r11 = r11 + r4
            goto L_0x0030
        L_0x002f:
            r11 = r9
        L_0x0030:
            r13 = 1000(0x3e8, double:4.94E-321)
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x009d
            h9.m r6 = r0.f7764j
            h9.m r15 = h9.m.f7754c
            if (r6 == r15) goto L_0x0093
            h9.m r7 = new h9.m
            r7.<init>()
        L_0x0041:
            h9.a r9 = f7760m
            r9.d(r7, r6)
            boolean r6 = r9.c(r0, r6, r7)
            if (r6 == 0) goto L_0x008b
        L_0x004c:
            r9 = 2147483647999999999(0x1dcd64ffffffffff, double:3.98785104510193E-165)
            long r4 = java.lang.Math.min(r4, r9)
            java.util.concurrent.locks.LockSupport.parkNanos(r0, r4)
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0082
            java.lang.Object r4 = r0.f7762h
            if (r4 == 0) goto L_0x0064
            r5 = 1
            goto L_0x0065
        L_0x0064:
            r5 = 0
        L_0x0065:
            boolean r6 = r4 instanceof h9.f
            r6 = r6 ^ r8
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0070
            java.lang.Object r1 = h(r4)
            return r1
        L_0x0070:
            long r4 = java.lang.System.nanoTime()
            long r4 = r11 - r4
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 >= 0) goto L_0x004c
            r0.k(r7)
            r7 = r0
            r9 = r7
            r5 = r4
            r4 = r3
            goto L_0x00c5
        L_0x0082:
            r0.k(r7)
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x008b:
            h9.m r6 = r0.f7764j
            if (r6 != r15) goto L_0x0090
            goto L_0x0093
        L_0x0090:
            r9 = 0
            goto L_0x0041
        L_0x0093:
            java.lang.Object r1 = r0.f7762h
            java.util.Objects.requireNonNull(r1)
            java.lang.Object r1 = h(r1)
            return r1
        L_0x009d:
            r7 = r0
            r5 = r4
            r17 = r9
            r9 = r7
            r4 = r3
        L_0x00a3:
            int r10 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r10 <= 0) goto L_0x00ce
            java.lang.Object r5 = r9.f7762h
            if (r5 == 0) goto L_0x00ad
            r6 = 1
            goto L_0x00ae
        L_0x00ad:
            r6 = 0
        L_0x00ae:
            boolean r10 = r5 instanceof h9.f
            r10 = r10 ^ r8
            r6 = r6 & r10
            if (r6 == 0) goto L_0x00b9
            java.lang.Object r1 = h(r5)
            return r1
        L_0x00b9:
            boolean r5 = java.lang.Thread.interrupted()
            if (r5 != 0) goto L_0x00c8
            long r5 = java.lang.System.nanoTime()
            long r5 = r11 - r5
        L_0x00c5:
            r17 = 0
            goto L_0x00a3
        L_0x00c8:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x00ce:
            java.lang.String r9 = r7.toString()
            java.lang.String r10 = r3.toString()
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.toLowerCase(r11)
            java.lang.String r11 = java.lang.String.valueOf(r3)
            int r11 = r11.length()
            int r11 = r11 + 28
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            java.lang.String r11 = "Waited "
            r12.append(r11)
            r12.append(r1)
            java.lang.String r1 = " "
            r12.append(r1)
            r12.append(r3)
            java.lang.String r2 = r12.toString()
            long r11 = r5 + r13
            r17 = 0
            int r3 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r3 >= 0) goto L_0x019b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = " (plus "
            java.lang.String r2 = r2.concat(r3)
            long r5 = -r5
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r11 = r4.convert(r5, r3)
            long r3 = r4.toNanos(r11)
            long r5 = r5 - r3
            int r3 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r3 == 0) goto L_0x0131
            int r4 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x012e
            goto L_0x0131
        L_0x012e:
            r16 = 0
            goto L_0x0133
        L_0x0131:
            r16 = 1
        L_0x0133:
            if (r3 <= 0) goto L_0x0171
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            int r3 = r3 + 21
            java.lang.String r4 = java.lang.String.valueOf(r10)
            int r4 = r4.length()
            int r4 = r4 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r2)
            r3.append(r11)
            r3.append(r1)
            r3.append(r10)
            java.lang.String r2 = r3.toString()
            if (r16 == 0) goto L_0x0169
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = ","
            java.lang.String r2 = r2.concat(r3)
        L_0x0169:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r2 = r2.concat(r1)
        L_0x0171:
            if (r16 == 0) goto L_0x0191
            java.lang.String r1 = java.lang.String.valueOf(r2)
            int r2 = r1.length()
            int r2 = r2 + 33
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            r3.append(r5)
            java.lang.String r1 = " nanoseconds "
            r3.append(r1)
            java.lang.String r2 = r3.toString()
        L_0x0191:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "delay)"
            java.lang.String r2 = r1.concat(r2)
        L_0x019b:
            boolean r1 = r7.isDone()
            if (r1 == 0) goto L_0x01b1
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = " but future completed as timeout expired"
            java.lang.String r2 = r2.concat(r3)
            r1.<init>(r2)
            throw r1
        L_0x01b1:
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            int r3 = r3 + 5
            java.lang.String r4 = java.lang.String.valueOf(r9)
            int r4 = r4.length()
            int r4 = r4 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = " for "
            r3.append(r2)
            r3.append(r9)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x01de:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h9.n.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}
