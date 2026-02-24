package pb;

import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import la.v;
import qb.g;
import qb.h;
import tb.l;
import tb.o;
import xa.j;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f12766a = 64;

    /* renamed from: b  reason: collision with root package name */
    public final int f12767b = 5;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f12768c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayDeque f12769d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayDeque f12770e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final ArrayDeque f12771f = new ArrayDeque();

    public final synchronized ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor;
        if (this.f12768c == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            String str = h.f13495c + " Dispatcher";
            j.f("name", str);
            this.f12768c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, timeUnit, synchronousQueue, new g(str, false));
        }
        threadPoolExecutor = this.f12768c;
        j.c(threadPoolExecutor);
        return threadPoolExecutor;
    }

    public final void b(l lVar) {
        j.f("call", lVar);
        lVar.f14976i.decrementAndGet();
        ArrayDeque arrayDeque = this.f12770e;
        synchronized (this) {
            if (arrayDeque.remove(lVar)) {
                v vVar = v.f9814a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        d();
    }

    public final void c(o oVar) {
        j.f("call", oVar);
        ArrayDeque arrayDeque = this.f12771f;
        synchronized (this) {
            if (arrayDeque.remove(oVar)) {
                v vVar = v.f9814a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        d();
    }

    public final void d() {
        p0 p0Var = h.f13493a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f12769d.iterator();
            j.e("readyAsyncCalls.iterator()", it);
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (this.f12770e.size() >= this.f12766a) {
                    break;
                } else if (lVar.f14976i.get() < this.f12767b) {
                    it.remove();
                    lVar.f14976i.incrementAndGet();
                    arrayList.add(lVar);
                    this.f12770e.add(lVar);
                }
            }
            int e10 = e();
            v vVar = v.f9814a;
        }
        int i10 = 0;
        if (((ThreadPoolExecutor) a()).isShutdown()) {
            int size = arrayList.size();
            while (i10 < size) {
                l lVar2 = (l) arrayList.get(i10);
                lVar2.f14976i.decrementAndGet();
                synchronized (this) {
                    this.f12770e.remove(lVar2);
                }
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause((Throwable) null);
                o oVar = lVar2.f14977j;
                oVar.i(interruptedIOException);
                lVar2.f14975h.onFailure(oVar, interruptedIOException);
                i10++;
            }
            return;
        }
        int size2 = arrayList.size();
        while (i10 < size2) {
            l lVar3 = (l) arrayList.get(i10);
            ExecutorService a10 = a();
            lVar3.getClass();
            o oVar2 = lVar3.f14977j;
            a0 a0Var = oVar2.f14980h.f12820a;
            p0 p0Var2 = h.f13493a;
            try {
                ((ThreadPoolExecutor) a10).execute(lVar3);
            } catch (RejectedExecutionException e11) {
                InterruptedIOException interruptedIOException2 = new InterruptedIOException("executor rejected");
                interruptedIOException2.initCause(e11);
                o oVar3 = lVar3.f14977j;
                oVar3.i(interruptedIOException2);
                lVar3.f14975h.onFailure(oVar3, interruptedIOException2);
                oVar2.f14980h.f12820a.b(lVar3);
            } catch (Throwable th) {
                oVar2.f14980h.f12820a.b(lVar3);
                throw th;
            }
            i10++;
        }
    }

    public final synchronized int e() {
        return this.f12770e.size() + this.f12771f.size();
    }
}
