package r;

import h9.e0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class i implements e0 {

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f13512k = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: l  reason: collision with root package name */
    public static final Logger f13513l;

    /* renamed from: m  reason: collision with root package name */
    public static final a f13514m;

    /* renamed from: n  reason: collision with root package name */
    public static final Object f13515n = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile Object f13516h;

    /* renamed from: i  reason: collision with root package name */
    public volatile e f13517i;

    /* renamed from: j  reason: collision with root package name */
    public volatile h f13518j;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: r.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: r.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: r.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: r.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<r.h> r0 = r.h.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f13512k = r1
            java.lang.Class<r.i> r1 = r.i.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            f13513l = r2
            r.f r2 = new r.f     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "j"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<r.e> r0 = r.e.class
            java.lang.String r3 = "i"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "h"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            r.g r2 = new r.g
            r2.<init>()
        L_0x004e:
            f13514m = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = f13513l
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f13515n = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.i.<clinit>():void");
    }

    public static void c(i iVar) {
        h hVar;
        e eVar;
        e eVar2;
        e eVar3;
        do {
            hVar = iVar.f13518j;
        } while (!f13514m.c(iVar, hVar, h.f13509c));
        while (true) {
            eVar = null;
            if (hVar == null) {
                break;
            }
            Thread thread = hVar.f13510a;
            if (thread != null) {
                hVar.f13510a = null;
                LockSupport.unpark(thread);
            }
            hVar = hVar.f13511b;
        }
        do {
            eVar2 = iVar.f13517i;
        } while (!f13514m.a(iVar, eVar2, e.f13500d));
        while (true) {
            eVar3 = eVar;
            eVar = eVar2;
            if (eVar == null) {
                break;
            }
            eVar2 = eVar.f13503c;
            eVar.f13503c = eVar3;
        }
        while (eVar3 != null) {
            e eVar4 = eVar3.f13503c;
            d(eVar3.f13501a, eVar3.f13502b);
            eVar3 = eVar4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Level level = Level.SEVERE;
            f13513l.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e10);
        }
    }

    public static Object e(Object obj) {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f13498a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof d) {
            ((d) obj).getClass();
            throw new ExecutionException((Throwable) null);
        } else if (obj == f13515n) {
            return null;
        } else {
            return obj;
        }
    }

    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        e eVar = this.f13517i;
        e eVar2 = e.f13500d;
        if (eVar != eVar2) {
            e eVar3 = new e(runnable, executor);
            do {
                eVar3.f13503c = eVar;
                if (!f13514m.a(this, eVar, eVar3)) {
                    eVar = this.f13517i;
                } else {
                    return;
                }
            } while (eVar != eVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb2) {
        Object obj;
        String str;
        String str2 = "]";
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
                sb2.append(str2);
                return;
            } catch (CancellationException unused2) {
                str2 = "CANCELLED";
                sb2.append(str2);
                return;
            } catch (RuntimeException e11) {
                sb2.append("UNKNOWN, cause=[");
                sb2.append(e11.getClass());
                str2 = " thrown from get()]";
                sb2.append(str2);
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
        if (obj == this) {
            str = "this future";
        } else {
            str = String.valueOf(obj);
        }
        sb2.append(str);
        sb2.append(str2);
    }

    public final boolean cancel(boolean z10) {
        Object obj = this.f13516h;
        if ((obj == null) || false) {
            if (f13514m.b(this, obj, f13512k ? new b(new CancellationException("Future.cancel() was called."), z10) : z10 ? b.f13496b : b.f13497c)) {
                c(this);
                return true;
            }
        }
        return false;
    }

    public final void f(h hVar) {
        hVar.f13510a = null;
        while (true) {
            h hVar2 = this.f13518j;
            if (hVar2 != h.f13509c) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f13511b;
                    if (hVar2.f13510a != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f13511b = hVar4;
                        if (hVar3.f13510a == null) {
                        }
                    } else if (!f13514m.c(this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f13516h;
            if ((obj2 != null) && true) {
                return e(obj2);
            }
            h hVar = this.f13518j;
            h hVar2 = h.f13509c;
            if (hVar != hVar2) {
                h hVar3 = new h();
                do {
                    a aVar = f13514m;
                    aVar.d(hVar3, hVar);
                    if (aVar.c(this, hVar, hVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f13516h;
                            } else {
                                f(hVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & true));
                        return e(obj);
                    }
                    hVar = this.f13518j;
                } while (hVar != hVar2);
            }
            return e(this.f13516h);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f13516h instanceof b;
    }

    public final boolean isDone() {
        return (this.f13516h != null) & true;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (this.f13516h instanceof b) {
            str2 = "CANCELLED";
        } else {
            if (!isDone()) {
                try {
                    if (this instanceof ScheduledFuture) {
                        str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                    } else {
                        str = null;
                    }
                } catch (RuntimeException e10) {
                    str = "Exception thrown from implementation: " + e10.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb2.append("PENDING, info=[");
                    sb2.append(str);
                    sb2.append("]");
                    sb2.append("]");
                    return sb2.toString();
                } else if (!isDone()) {
                    str2 = "PENDING";
                }
            }
            b(sb2);
            sb2.append("]");
            return sb2.toString();
        }
        sb2.append(str2);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(long r18, java.util.concurrent.TimeUnit r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r20
            long r4 = r3.toNanos(r1)
            boolean r6 = java.lang.Thread.interrupted()
            if (r6 != 0) goto L_0x0172
            java.lang.Object r6 = r0.f13516h
            r7 = 1
            if (r6 == 0) goto L_0x0017
            r8 = 1
            goto L_0x0018
        L_0x0017:
            r8 = 0
        L_0x0018:
            r8 = r8 & r7
            if (r8 == 0) goto L_0x0020
            java.lang.Object r1 = e(r6)
            return r1
        L_0x0020:
            r8 = 0
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x002c
            long r10 = java.lang.System.nanoTime()
            long r10 = r10 + r4
            goto L_0x002d
        L_0x002c:
            r10 = r8
        L_0x002d:
            r12 = 1000(0x3e8, double:4.94E-321)
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x0087
            r.h r6 = r0.f13518j
            r.h r8 = r.h.f13509c
            if (r6 == r8) goto L_0x0080
            r.h r9 = new r.h
            r9.<init>()
        L_0x003e:
            r.a r14 = f13514m
            r14.d(r9, r6)
            boolean r6 = r14.c(r0, r6, r9)
            if (r6 == 0) goto L_0x007c
        L_0x0049:
            java.util.concurrent.locks.LockSupport.parkNanos(r0, r4)
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0073
            java.lang.Object r4 = r0.f13516h
            if (r4 == 0) goto L_0x0058
            r5 = 1
            goto L_0x0059
        L_0x0058:
            r5 = 0
        L_0x0059:
            r5 = r5 & r7
            if (r5 == 0) goto L_0x0061
            java.lang.Object r1 = e(r4)
            return r1
        L_0x0061:
            long r4 = java.lang.System.nanoTime()
            long r4 = r10 - r4
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x0049
            r0.f(r9)
            r14 = r0
            r15 = r14
            r5 = r4
            r4 = r3
            goto L_0x00aa
        L_0x0073:
            r0.f(r9)
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x007c:
            r.h r6 = r0.f13518j
            if (r6 != r8) goto L_0x003e
        L_0x0080:
            java.lang.Object r1 = r0.f13516h
            java.lang.Object r1 = e(r1)
            return r1
        L_0x0087:
            r14 = r0
            r15 = r14
            r5 = r4
            r4 = r3
        L_0x008b:
            int r16 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r16 <= 0) goto L_0x00b3
            java.lang.Object r5 = r15.f13516h
            if (r5 == 0) goto L_0x0095
            r6 = 1
            goto L_0x0096
        L_0x0095:
            r6 = 0
        L_0x0096:
            r6 = r6 & r7
            if (r6 == 0) goto L_0x009e
            java.lang.Object r1 = e(r5)
            return r1
        L_0x009e:
            boolean r5 = java.lang.Thread.interrupted()
            if (r5 != 0) goto L_0x00ad
            long r5 = java.lang.System.nanoTime()
            long r5 = r10 - r5
        L_0x00aa:
            r8 = 0
            goto L_0x008b
        L_0x00ad:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        L_0x00b3:
            java.lang.String r7 = r14.toString()
            java.lang.String r8 = r3.toString()
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Waited "
            r10.<init>(r11)
            r10.append(r1)
            java.lang.String r1 = " "
            r10.append(r1)
            java.lang.String r2 = r3.toString()
            java.lang.String r2 = r2.toLowerCase(r9)
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            long r9 = r5 + r12
            r15 = 0
            int r3 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0146
            java.lang.String r3 = " (plus "
            java.lang.String r2 = q0.f.g(r2, r3)
            long r5 = -r5
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r9 = r4.convert(r5, r3)
            long r3 = r4.toNanos(r9)
            long r5 = r5 - r3
            r3 = 0
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 == 0) goto L_0x0106
            int r3 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r3 = 0
            goto L_0x0107
        L_0x0106:
            r3 = 1
        L_0x0107:
            if (r11 <= 0) goto L_0x012a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r9)
            r4.append(r1)
            r4.append(r8)
            java.lang.String r2 = r4.toString()
            if (r3 == 0) goto L_0x0126
            java.lang.String r4 = ","
            java.lang.String r2 = q0.f.g(r2, r4)
        L_0x0126:
            java.lang.String r2 = q0.f.g(r2, r1)
        L_0x012a:
            if (r3 == 0) goto L_0x0140
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " nanoseconds "
            r1.append(r2)
            java.lang.String r2 = r1.toString()
        L_0x0140:
            java.lang.String r1 = "delay)"
            java.lang.String r2 = q0.f.g(r2, r1)
        L_0x0146:
            boolean r1 = r14.isDone()
            if (r1 == 0) goto L_0x0158
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.String r3 = " but future completed as timeout expired"
            java.lang.String r2 = q0.f.g(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x0158:
            java.util.concurrent.TimeoutException r1 = new java.util.concurrent.TimeoutException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " for "
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0172:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r.i.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}
