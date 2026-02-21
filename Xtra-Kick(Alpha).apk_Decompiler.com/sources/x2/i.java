package x2;

import j1.a;
import j1.l0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import p0.c;
import w2.e;
import w2.h;

public abstract class i implements e {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f16637a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque f16638b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityQueue f16639c;

    /* renamed from: d  reason: collision with root package name */
    public g f16640d;

    /* renamed from: e  reason: collision with root package name */
    public long f16641e;

    /* renamed from: f  reason: collision with root package name */
    public long f16642f;

    public i() {
        for (int i10 = 0; i10 < 10; i10++) {
            this.f16637a.add(new g(0));
        }
        this.f16638b = new ArrayDeque();
        for (int i11 = 0; i11 < 2; i11++) {
            this.f16638b.add(new h(new c(9, this)));
        }
        this.f16639c = new PriorityQueue();
    }

    public void a() {
    }

    public final void b(long j10) {
        this.f16641e = j10;
    }

    public final void c(h hVar) {
        boolean z10;
        if (hVar == this.f16640d) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10);
        g gVar = (g) hVar;
        if (gVar.g()) {
            gVar.h();
            this.f16637a.add(gVar);
        } else {
            long j10 = this.f16642f;
            this.f16642f = 1 + j10;
            gVar.f16635q = j10;
            this.f16639c.add(gVar);
        }
        this.f16640d = null;
    }

    public final Object e() {
        a.e(this.f16640d == null);
        ArrayDeque arrayDeque = this.f16637a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        g gVar = (g) arrayDeque.pollFirst();
        this.f16640d = gVar;
        return gVar;
    }

    public abstract j f();

    public void flush() {
        ArrayDeque arrayDeque;
        this.f16642f = 0;
        this.f16641e = 0;
        while (true) {
            PriorityQueue priorityQueue = this.f16639c;
            boolean isEmpty = priorityQueue.isEmpty();
            arrayDeque = this.f16637a;
            if (isEmpty) {
                break;
            }
            g gVar = (g) priorityQueue.poll();
            int i10 = l0.f8453a;
            gVar.h();
            arrayDeque.add(gVar);
        }
        g gVar2 = this.f16640d;
        if (gVar2 != null) {
            gVar2.h();
            arrayDeque.add(gVar2);
            this.f16640d = null;
        }
    }

    public abstract void g(g gVar);

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        return null;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w2.i d() {
        /*
            r12 = this;
            java.util.ArrayDeque r0 = r12.f16638b
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.PriorityQueue r1 = r12.f16639c
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L_0x0067
            java.lang.Object r3 = r1.peek()
            x2.g r3 = (x2.g) r3
            int r4 = j1.l0.f8453a
            long r3 = r3.f9517l
            long r5 = r12.f16641e
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0067
            java.lang.Object r1 = r1.poll()
            x2.g r1 = (x2.g) r1
            r3 = 4
            boolean r4 = r1.f(r3)
            java.util.ArrayDeque r5 = r12.f16637a
            if (r4 == 0) goto L_0x0041
            java.lang.Object r0 = r0.pollFirst()
            w2.i r0 = (w2.i) r0
            r0.e(r3)
        L_0x003a:
            r1.h()
            r5.add(r1)
            return r0
        L_0x0041:
            r12.g(r1)
            boolean r3 = r12.i()
            if (r3 == 0) goto L_0x0060
            x2.j r9 = r12.f()
            java.lang.Object r0 = r0.pollFirst()
            w2.i r0 = (w2.i) r0
            long r7 = r1.f9517l
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = r0
            r6.i(r7, r9, r10)
            goto L_0x003a
        L_0x0060:
            r1.h()
            r5.add(r1)
            goto L_0x000a
        L_0x0067:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.i.d():w2.i");
    }

    public abstract boolean i();
}
