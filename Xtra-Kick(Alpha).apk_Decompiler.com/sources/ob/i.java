package ob;

import android.support.v4.media.h;
import androidx.fragment.app.k;
import h3.u1;
import hb.h0;
import hb.k2;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.v;
import mb.d;
import mb.z;

public class i implements f {

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12378c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12379d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12380e;

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12381f;

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12382g;
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    public final int f12383a;

    /* renamed from: b  reason: collision with root package name */
    public final k f12384b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    static {
        Class<i> cls = i.class;
        Class<Object> cls2 = Object.class;
        f12378c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head");
        f12379d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        f12380e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail");
        f12381f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        f12382g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    public i(int i10, int i11) {
        boolean z10;
        this.f12383a = i10;
        boolean z11 = false;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 >= 0 && i11 <= i10) {
                z11 = true;
            }
            if (z11) {
                k kVar = new k(0, (k) null, 2);
                this.head = kVar;
                this.tail = kVar;
                this._availablePermits = i10 - i11;
                this.f12384b = new k(21, this);
                return;
            }
            throw new IllegalArgumentException(h.i("The number of acquired permits should be in 0..", i10).toString());
        }
        throw new IllegalArgumentException(h.i("Semaphore should have at least 1 permit, but had ", i10).toString());
    }

    public final void a(hb.k kVar) {
        while (true) {
            int andDecrement = f12382g.getAndDecrement(this);
            if (andDecrement <= this.f12383a) {
                if (andDecrement > 0) {
                    kVar.i(v.f9814a, this.f12384b);
                    return;
                } else if (b((k2) kVar)) {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0059, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(hb.k2 r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = f12380e
            java.lang.Object r3 = r2.get(r0)
            ob.k r3 = (ob.k) r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = f12381f
            long r4 = r4.getAndIncrement(r0)
            ob.g r6 = ob.g.f12376q
            int r7 = ob.j.f12390f
            long r7 = (long) r7
            long r7 = r4 / r7
        L_0x0019:
            java.lang.Object r9 = mb.d.a(r3, r7, r6)
            boolean r10 = hb.h0.T0(r9)
            if (r10 != 0) goto L_0x0066
            mb.z r10 = hb.h0.H0(r9)
        L_0x0027:
            java.lang.Object r13 = r2.get(r0)
            mb.z r13 = (mb.z) r13
            long r14 = r13.f10890j
            long r11 = r10.f10890j
            int r16 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r16 < 0) goto L_0x0036
            goto L_0x0058
        L_0x0036:
            boolean r11 = r10.i()
            if (r11 != 0) goto L_0x003e
            r10 = 0
            goto L_0x0059
        L_0x003e:
            boolean r11 = r2.compareAndSet(r0, r13, r10)
            if (r11 == 0) goto L_0x0046
            r11 = 1
            goto L_0x004d
        L_0x0046:
            java.lang.Object r11 = r2.get(r0)
            if (r11 == r13) goto L_0x003e
            r11 = 0
        L_0x004d:
            if (r11 == 0) goto L_0x005c
            boolean r10 = r13.e()
            if (r10 == 0) goto L_0x0058
            r13.d()
        L_0x0058:
            r10 = 1
        L_0x0059:
            if (r10 == 0) goto L_0x0019
            goto L_0x0066
        L_0x005c:
            boolean r11 = r10.e()
            if (r11 == 0) goto L_0x0027
            r10.d()
            goto L_0x0027
        L_0x0066:
            mb.z r2 = hb.h0.H0(r9)
            ob.k r2 = (ob.k) r2
            int r3 = ob.j.f12390f
            long r6 = (long) r3
            long r4 = r4 % r6
            int r3 = (int) r4
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r2.f12391l
        L_0x0073:
            r5 = 0
            boolean r5 = r4.compareAndSet(r3, r5, r1)
            if (r5 == 0) goto L_0x007c
            r4 = 1
            goto L_0x0083
        L_0x007c:
            java.lang.Object r5 = r4.get(r3)
            if (r5 == 0) goto L_0x0073
            r4 = 0
        L_0x0083:
            if (r4 == 0) goto L_0x008a
            r1.a(r2, r3)
            r1 = 1
            return r1
        L_0x008a:
            h3.u1 r5 = ob.j.f12386b
            h3.u1 r6 = ob.j.f12387c
            java.util.concurrent.atomic.AtomicReferenceArray r7 = r2.f12391l
        L_0x0090:
            boolean r2 = r7.compareAndSet(r3, r5, r6)
            if (r2 == 0) goto L_0x0098
            r2 = 1
            goto L_0x009f
        L_0x0098:
            java.lang.Object r2 = r7.get(r3)
            if (r2 == r5) goto L_0x0090
            r2 = 0
        L_0x009f:
            if (r2 == 0) goto L_0x00ac
            hb.k r1 = (hb.k) r1
            la.v r2 = la.v.f9814a
            androidx.fragment.app.k r3 = r0.f12384b
            r1.i(r2, r3)
            r8 = 1
            return r8
        L_0x00ac:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.i.b(hb.k2):boolean");
    }

    public final void c() {
        int i10;
        Object a10;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12382g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i11 = this.f12383a;
            if (andIncrement >= i11) {
                do {
                    i10 = atomicIntegerFieldUpdater.get(this);
                    if (i10 <= i11 || atomicIntegerFieldUpdater.compareAndSet(this, i10, i11)) {
                    }
                    i10 = atomicIntegerFieldUpdater.get(this);
                    break;
                } while (atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i11).toString());
            } else if (andIncrement < 0) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12378c;
                k kVar = (k) atomicReferenceFieldUpdater.get(this);
                long andIncrement2 = f12379d.getAndIncrement(this);
                long j10 = andIncrement2 / ((long) j.f12390f);
                h hVar = h.f12377q;
                do {
                    a10 = d.a(kVar, j10, hVar);
                    if (h0.T0(a10)) {
                        break;
                    }
                    z H0 = h0.H0(a10);
                    while (true) {
                        z zVar = (z) atomicReferenceFieldUpdater.get(this);
                        if (zVar.f10890j >= H0.f10890j) {
                            break;
                        } else if (!H0.i()) {
                            z13 = false;
                            continue;
                            break;
                        } else {
                            while (true) {
                                if (!atomicReferenceFieldUpdater.compareAndSet(this, zVar, H0)) {
                                    if (atomicReferenceFieldUpdater.get(this) != zVar) {
                                        z14 = false;
                                        break;
                                    }
                                } else {
                                    z14 = true;
                                    break;
                                }
                            }
                            if (z14) {
                                if (zVar.e()) {
                                    zVar.d();
                                }
                            } else if (H0.e()) {
                                H0.d();
                            }
                        }
                    }
                    z13 = true;
                    continue;
                } while (!z13);
                k kVar2 = (k) h0.H0(a10);
                kVar2.a();
                if (kVar2.f10890j <= j10) {
                    int i12 = (int) (andIncrement2 % ((long) j.f12390f));
                    u1 u1Var = j.f12386b;
                    AtomicReferenceArray atomicReferenceArray = kVar2.f12391l;
                    Object andSet = atomicReferenceArray.getAndSet(i12, u1Var);
                    if (andSet == null) {
                        int i13 = j.f12385a;
                        int i14 = 0;
                        while (i14 < i13) {
                            if (atomicReferenceArray.get(i12) != j.f12387c) {
                                i14++;
                            }
                        }
                        u1 u1Var2 = j.f12386b;
                        u1 u1Var3 = j.f12388d;
                        while (true) {
                            if (!atomicReferenceArray.compareAndSet(i12, u1Var2, u1Var3)) {
                                if (atomicReferenceArray.get(i12) != u1Var2) {
                                    z11 = true;
                                    z12 = false;
                                    break;
                                }
                            } else {
                                z11 = true;
                                z12 = true;
                                break;
                            }
                        }
                        z10 = z12 ^ z11;
                        continue;
                    } else if (andSet != j.f12389e) {
                        if (andSet instanceof hb.k) {
                            hb.k kVar3 = (hb.k) andSet;
                            u1 f10 = kVar3.f(v.f9814a, this.f12384b);
                            if (f10 != null) {
                                kVar3.n(f10);
                            }
                        } else {
                            throw new IllegalStateException(("unexpected: " + andSet).toString());
                        }
                    }
                    z10 = true;
                    continue;
                    break;
                }
                z10 = false;
                continue;
            } else {
                return;
            }
        } while (!z10);
    }
}
