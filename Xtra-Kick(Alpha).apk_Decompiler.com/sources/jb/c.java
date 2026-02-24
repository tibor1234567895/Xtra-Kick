package jb;

import android.support.v4.media.h;
import h3.u1;
import hb.h0;
import hb.k;
import hb.k2;
import j3.m2;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import la.a;
import la.v;
import mb.z;
import pa.e;
import qa.d;
import wa.l;
import xa.j;
import xa.y;

public class c implements g {

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f8888j;

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f8889k;

    /* renamed from: l  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f8890l;

    /* renamed from: m  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f8891m;

    /* renamed from: n  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8892n;

    /* renamed from: o  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8893o;

    /* renamed from: p  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8894p;

    /* renamed from: q  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8895q;

    /* renamed from: r  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8896r;
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;

    /* renamed from: h  reason: collision with root package name */
    public final int f8897h;

    /* renamed from: i  reason: collision with root package name */
    public final l f8898i;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    static {
        Class<c> cls = c.class;
        f8888j = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus");
        f8889k = AtomicLongFieldUpdater.newUpdater(cls, "receivers");
        f8890l = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd");
        f8891m = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag");
        Class<Object> cls2 = Object.class;
        f8892n = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "sendSegment");
        f8893o = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "receiveSegment");
        f8894p = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "bufferEndSegment");
        f8895q = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closeCause");
        f8896r = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "closeHandler");
    }

    public c(int i10, l lVar) {
        boolean z10;
        long j10;
        this.f8897h = i10;
        this.f8898i = lVar;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            l lVar2 = e.f8900a;
            if (i10 == 0) {
                j10 = 0;
            } else if (i10 != Integer.MAX_VALUE) {
                j10 = (long) i10;
            } else {
                j10 = Long.MAX_VALUE;
            }
            this.bufferEnd = j10;
            this.completedExpandBuffersAndPauseFlag = o();
            l lVar3 = new l(0, (l) null, this, 3);
            this.sendSegment = lVar3;
            this.receiveSegment = lVar3;
            if (w()) {
                lVar3 = e.f8900a;
                j.d("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>", lVar3);
            }
            this.bufferEndSegment = lVar3;
            this._closeCause = e.f8918s;
            return;
        }
        throw new IllegalArgumentException(h.j("Invalid channel capacity: ", i10, ", should be >=0").toString());
    }

    public static boolean B(Object obj) {
        if (obj instanceof k) {
            j.d("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>", obj);
            return e.a((k) obj, v.f9814a, (l) null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if ((r14.f10890j * ((long) jb.e.f8901b)) < r11.q()) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00af, code lost:
        if ((r14.f10890j * ((long) jb.e.f8901b)) < r11.q()) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final jb.l c(jb.c r11, long r12, jb.l r14) {
        /*
            r11.getClass()
            jb.l r0 = jb.e.f8900a
            jb.d r0 = jb.d.f8899q
        L_0x0007:
            java.lang.Object r1 = mb.d.a(r14, r12, r0)
            boolean r2 = hb.h0.T0(r1)
            if (r2 != 0) goto L_0x0056
            mb.z r2 = hb.h0.H0(r1)
        L_0x0015:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f8892n
            java.lang.Object r4 = r3.get(r11)
            mb.z r4 = (mb.z) r4
            long r5 = r4.f10890j
            long r7 = r2.f10890j
            r9 = 1
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 < 0) goto L_0x0027
            goto L_0x0049
        L_0x0027:
            boolean r5 = r2.i()
            r6 = 0
            if (r5 != 0) goto L_0x0030
            r9 = 0
            goto L_0x0049
        L_0x0030:
            boolean r5 = r3.compareAndSet(r11, r4, r2)
            if (r5 == 0) goto L_0x0038
            r6 = 1
            goto L_0x003e
        L_0x0038:
            java.lang.Object r5 = r3.get(r11)
            if (r5 == r4) goto L_0x0030
        L_0x003e:
            if (r6 == 0) goto L_0x004c
            boolean r2 = r4.e()
            if (r2 == 0) goto L_0x0049
            r4.d()
        L_0x0049:
            if (r9 == 0) goto L_0x0007
            goto L_0x0056
        L_0x004c:
            boolean r3 = r2.e()
            if (r3 == 0) goto L_0x0015
            r2.d()
            goto L_0x0015
        L_0x0056:
            boolean r0 = hb.h0.T0(r1)
            if (r0 == 0) goto L_0x006f
            r11.l()
            int r12 = jb.e.f8901b
            long r12 = (long) r12
            long r0 = r14.f10890j
            long r0 = r0 * r12
            long r11 = r11.q()
            int r13 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x00b4
            goto L_0x00b1
        L_0x006f:
            mb.z r14 = hb.h0.H0(r1)
            jb.l r14 = (jb.l) r14
            long r0 = r14.f10890j
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b5
            int r12 = jb.e.f8901b
            long r12 = (long) r12
            long r0 = r0 * r12
        L_0x0080:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f8888j
            long r4 = r2.get(r11)
            r12 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r12 = r12 & r4
            int r3 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r3 < 0) goto L_0x0091
            goto L_0x00a2
        L_0x0091:
            r3 = 60
            long r6 = r4 >> r3
            int r7 = (int) r6
            jb.l r6 = jb.e.f8900a
            long r6 = (long) r7
            long r6 = r6 << r3
            long r6 = r6 + r12
            r3 = r11
            boolean r12 = r2.compareAndSet(r3, r4, r6)
            if (r12 == 0) goto L_0x0080
        L_0x00a2:
            int r12 = jb.e.f8901b
            long r12 = (long) r12
            long r0 = r14.f10890j
            long r0 = r0 * r12
            long r11 = r11.q()
            int r13 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x00b4
        L_0x00b1:
            r14.a()
        L_0x00b4:
            r14 = 0
        L_0x00b5:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.c(jb.c, long, jb.l):jb.l");
    }

    public static final int d(c cVar, l lVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        cVar.getClass();
        lVar.n(i10, obj);
        if (!z10) {
            Object k10 = lVar.k(i10);
            if (k10 == null) {
                if (cVar.f(j10)) {
                    if (lVar.j((Object) null, i10, e.f8903d)) {
                        return 1;
                    }
                } else if (obj2 == null) {
                    return 3;
                } else {
                    if (lVar.j((Object) null, i10, obj2)) {
                        return 2;
                    }
                }
            } else if (k10 instanceof k2) {
                lVar.n(i10, (Object) null);
                if (cVar.A(k10, obj)) {
                    lVar.o(i10, e.f8908i);
                    return 0;
                }
                u1 u1Var = e.f8910k;
                if (lVar.f8926m.getAndSet((i10 * 2) + 1, u1Var) != u1Var) {
                    lVar.l(i10, true);
                }
                return 5;
            }
        }
        return cVar.D(lVar, i10, obj, j10, obj2, z10);
    }

    public final boolean A(Object obj, Object obj2) {
        m2 m2Var = null;
        if (obj instanceof b) {
            j.d("null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>", obj);
            b bVar = (b) obj;
            hb.l lVar = bVar.f8886i;
            j.c(lVar);
            bVar.f8886i = null;
            bVar.f8885h = obj2;
            Boolean bool = Boolean.TRUE;
            l lVar2 = bVar.f8887j.f8898i;
            if (lVar2 != null) {
                m2Var = h0.m(lVar2, obj2, lVar.f7822l);
            }
            return e.a(lVar, bool, m2Var);
        } else if (obj instanceof k) {
            j.d("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>", obj);
            k kVar = (k) obj;
            l lVar3 = this.f8898i;
            if (lVar3 != null) {
                m2Var = h0.m(lVar3, obj2, kVar.getContext());
            }
            return e.a(kVar, obj2, m2Var);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0081, code lost:
        m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        if (r10 != false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a4, code lost:
        m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return r8.m(r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object C(jb.l r8, int r9, long r10, jb.b r12) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.k(r9)
            r1 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = f8888j
            if (r0 != 0) goto L_0x0027
            long r4 = r3.get(r7)
            long r4 = r4 & r1
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x003b
            if (r12 != 0) goto L_0x001b
            h3.u1 r8 = jb.e.f8913n
            return r8
        L_0x001b:
            boolean r0 = r8.j(r0, r9, r12)
            if (r0 == 0) goto L_0x003b
            r7.m()
            h3.u1 r8 = jb.e.f8912m
            return r8
        L_0x0027:
            h3.u1 r4 = jb.e.f8903d
            if (r0 != r4) goto L_0x003b
            h3.u1 r4 = jb.e.f8908i
            boolean r0 = r8.j(r0, r9, r4)
            if (r0 == 0) goto L_0x003b
            r7.m()
            java.lang.Object r8 = r8.m(r9)
            return r8
        L_0x003b:
            java.lang.Object r0 = r8.k(r9)
            if (r0 == 0) goto L_0x0093
            h3.u1 r4 = jb.e.f8904e
            if (r0 != r4) goto L_0x0046
            goto L_0x0093
        L_0x0046:
            h3.u1 r4 = jb.e.f8903d
            if (r0 != r4) goto L_0x0053
            h3.u1 r4 = jb.e.f8908i
            boolean r0 = r8.j(r0, r9, r4)
            if (r0 == 0) goto L_0x003b
            goto L_0x0081
        L_0x0053:
            h3.u1 r4 = jb.e.f8909j
            if (r0 != r4) goto L_0x0058
            goto L_0x00a7
        L_0x0058:
            h3.u1 r5 = jb.e.f8907h
            if (r0 != r5) goto L_0x005d
            goto L_0x00a7
        L_0x005d:
            h3.u1 r5 = jb.e.f8911l
            if (r0 != r5) goto L_0x0062
            goto L_0x00a4
        L_0x0062:
            h3.u1 r5 = jb.e.f8906g
            if (r0 == r5) goto L_0x003b
            h3.u1 r5 = jb.e.f8905f
            boolean r5 = r8.j(r0, r9, r5)
            if (r5 == 0) goto L_0x003b
            boolean r10 = r0 instanceof jb.u
            if (r10 == 0) goto L_0x0076
            jb.u r0 = (jb.u) r0
            hb.k2 r0 = r0.f8932a
        L_0x0076:
            boolean r11 = B(r0)
            if (r11 == 0) goto L_0x0089
            h3.u1 r10 = jb.e.f8908i
            r8.o(r9, r10)
        L_0x0081:
            r7.m()
            java.lang.Object r8 = r8.m(r9)
            goto L_0x00ba
        L_0x0089:
            r8.o(r9, r4)
            r11 = 0
            r8.l(r9, r11)
            if (r10 == 0) goto L_0x00a7
            goto L_0x00a4
        L_0x0093:
            long r4 = r3.get(r7)
            long r4 = r4 & r1
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00aa
            h3.u1 r4 = jb.e.f8907h
            boolean r0 = r8.j(r0, r9, r4)
            if (r0 == 0) goto L_0x003b
        L_0x00a4:
            r7.m()
        L_0x00a7:
            h3.u1 r8 = jb.e.f8914o
            goto L_0x00ba
        L_0x00aa:
            if (r12 != 0) goto L_0x00af
            h3.u1 r8 = jb.e.f8913n
            goto L_0x00ba
        L_0x00af:
            boolean r0 = r8.j(r0, r9, r12)
            if (r0 == 0) goto L_0x003b
            r7.m()
            h3.u1 r8 = jb.e.f8912m
        L_0x00ba:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.C(jb.l, int, long, jb.b):java.lang.Object");
    }

    public final int D(l lVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        while (true) {
            Object k10 = lVar.k(i10);
            if (k10 == null) {
                if (!f(j10) || z10) {
                    if (z10) {
                        if (lVar.j((Object) null, i10, e.f8909j)) {
                            lVar.l(i10, false);
                            return 4;
                        }
                    } else if (obj2 == null) {
                        return 3;
                    } else {
                        if (lVar.j((Object) null, i10, obj2)) {
                            return 2;
                        }
                    }
                } else if (lVar.j((Object) null, i10, e.f8903d)) {
                    return 1;
                }
            } else if (k10 != e.f8904e) {
                u1 u1Var = e.f8910k;
                if (k10 == u1Var) {
                    lVar.n(i10, (Object) null);
                    return 5;
                } else if (k10 == e.f8907h) {
                    lVar.n(i10, (Object) null);
                    return 5;
                } else if (k10 == e.f8911l) {
                    lVar.n(i10, (Object) null);
                    l();
                    return 4;
                } else {
                    lVar.n(i10, (Object) null);
                    if (k10 instanceof u) {
                        k10 = ((u) k10).f8932a;
                    }
                    if (A(k10, obj)) {
                        lVar.o(i10, e.f8908i);
                        return 0;
                    }
                    if (lVar.f8926m.getAndSet((i10 * 2) + 1, u1Var) != u1Var) {
                        lVar.l(i10, true);
                    }
                    return 5;
                }
            } else if (lVar.j(k10, i10, e.f8903d)) {
                return 1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(n3.j5 r7) {
        /*
            r6 = this;
        L_0x0000:
            r0 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f8896r
            boolean r0 = r1.compareAndSet(r6, r0, r7)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x000d
            r0 = 1
            goto L_0x0014
        L_0x000d:
            java.lang.Object r0 = r1.get(r6)
            if (r0 == 0) goto L_0x0000
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0017
            return
        L_0x0017:
            java.lang.Object r0 = r1.get(r6)
            h3.u1 r4 = jb.e.f8916q
            if (r0 != r4) goto L_0x003a
            h3.u1 r5 = jb.e.f8917r
        L_0x0021:
            boolean r0 = r1.compareAndSet(r6, r4, r5)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x0030
        L_0x0029:
            java.lang.Object r0 = r1.get(r6)
            if (r0 == r4) goto L_0x0021
            r0 = 0
        L_0x0030:
            if (r0 == 0) goto L_0x0017
            java.lang.Throwable r0 = r6.p()
            r7.invoke((java.lang.Object) r0)
            return
        L_0x003a:
            h3.u1 r7 = jb.e.f8917r
            if (r0 != r7) goto L_0x004a
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Another handler was already registered and successfully invoked"
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x004a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Another handler is already registered: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.a(n3.j5):void");
    }

    public final boolean b(Throwable th) {
        return i(th, false);
    }

    public final void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        i(cancellationException, true);
    }

    public final boolean f(long j10) {
        return j10 < o() || j10 < q() + ((long) this.f8897h);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (r16 == false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011e, code lost:
        r0.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0124, code lost:
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r1.a(r0, r17 + r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object g(java.lang.Object r25, pa.e r26) {
        /*
            r24 = this;
            r9 = r24
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f8892n
            java.lang.Object r1 = r0.get(r9)
            jb.l r1 = (jb.l) r1
        L_0x000a:
            r7 = 0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = f8888j
            long r2 = r10.getAndIncrement(r9)
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r13 = r2 & r11
            r15 = 0
            boolean r16 = r9.u(r2, r15)
            int r8 = jb.e.f8901b
            long r2 = (long) r8
            long r4 = r13 / r2
            long r2 = r13 % r2
            int r6 = (int) r2
            long r2 = r1.f10890j
            qa.a r15 = qa.a.COROUTINE_SUSPENDED
            int r18 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x003f
            jb.l r2 = c(r9, r4, r1)
            if (r2 != 0) goto L_0x003d
            if (r16 == 0) goto L_0x000a
            java.lang.Object r0 = r24.y(r25, r26)
            if (r0 != r15) goto L_0x01b7
            goto L_0x01b9
        L_0x003d:
            r5 = r2
            goto L_0x0040
        L_0x003f:
            r5 = r1
        L_0x0040:
            r1 = r24
            r2 = r5
            r3 = r6
            r4 = r25
            r19 = r5
            r18 = r6
            r5 = r13
            r20 = r8
            r8 = r16
            int r1 = d(r1, r2, r3, r4, r5, r7, r8)
            if (r1 == 0) goto L_0x01b2
            r8 = 1
            if (r1 == r8) goto L_0x01b7
            r7 = 2
            if (r1 == r7) goto L_0x01a2
            r5 = 3
            r6 = 5
            r4 = 4
            if (r1 == r5) goto L_0x007e
            if (r1 == r4) goto L_0x006b
            if (r1 == r6) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            r19.a()
        L_0x0068:
            r1 = r19
            goto L_0x000a
        L_0x006b:
            long r0 = r24.q()
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0076
            r19.a()
        L_0x0076:
            java.lang.Object r0 = r24.y(r25, r26)
            if (r0 != r15) goto L_0x01b7
            goto L_0x01b9
        L_0x007e:
            pa.e r1 = qa.d.b(r26)
            hb.l r3 = hb.h0.y0(r1)
            r16 = 0
            r1 = r24
            r2 = r19
            r21 = r3
            r3 = r18
            r11 = 4
            r4 = r25
            r12 = 5
            r5 = r13
            r12 = 2
            r7 = r21
            r11 = 1
            r8 = r16
            int r1 = d(r1, r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x017d
            if (r1 == r11) goto L_0x0178
            if (r1 == r12) goto L_0x016e
            r2 = 4
            if (r1 == r2) goto L_0x0141
            java.lang.String r13 = "unexpected"
            r2 = 5
            if (r1 != r2) goto L_0x0135
            r19.a()     // Catch:{ all -> 0x019b }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x019b }
            jb.l r0 = (jb.l) r0     // Catch:{ all -> 0x019b }
        L_0x00b6:
            long r1 = r10.getAndIncrement(r9)     // Catch:{ all -> 0x019b }
            r18 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r22 = r1 & r18
            r14 = 0
            boolean r16 = r9.u(r1, r14)     // Catch:{ all -> 0x019b }
            int r8 = jb.e.f8901b     // Catch:{ all -> 0x019b }
            long r1 = (long) r8     // Catch:{ all -> 0x019b }
            long r3 = r22 / r1
            long r1 = r22 % r1
            int r7 = (int) r1     // Catch:{ all -> 0x019b }
            long r1 = r0.f10890j     // Catch:{ all -> 0x019b }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00de
            jb.l r1 = c(r9, r3, r0)     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x00dd
            if (r16 == 0) goto L_0x00b6
            goto L_0x0121
        L_0x00dd:
            r0 = r1
        L_0x00de:
            r1 = r24
            r2 = r0
            r3 = r7
            r4 = r25
            r5 = r22
            r17 = r7
            r7 = r21
            r20 = r8
            r8 = r16
            int r1 = d(r1, r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x012f
            if (r1 == r11) goto L_0x0178
            if (r1 == r12) goto L_0x011c
            r2 = 3
            if (r1 == r2) goto L_0x0112
            r3 = 4
            if (r1 == r3) goto L_0x0106
            r4 = 5
            if (r1 == r4) goto L_0x0102
            goto L_0x00b6
        L_0x0102:
            r0.a()     // Catch:{ all -> 0x019b }
            goto L_0x00b6
        L_0x0106:
            long r1 = r24.q()     // Catch:{ all -> 0x019b }
            int r3 = (r22 > r1 ? 1 : (r22 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0121
            r0.a()     // Catch:{ all -> 0x019b }
            goto L_0x0121
        L_0x0112:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x019b }
            java.lang.String r1 = r13.toString()     // Catch:{ all -> 0x019b }
            r0.<init>(r1)     // Catch:{ all -> 0x019b }
            throw r0     // Catch:{ all -> 0x019b }
        L_0x011c:
            if (r16 == 0) goto L_0x0124
            r0.h()     // Catch:{ all -> 0x019b }
        L_0x0121:
            r1 = r21
            goto L_0x014e
        L_0x0124:
            int r7 = r17 + r20
            r1 = r21
            r1.a(r0, r7)     // Catch:{ all -> 0x012c }
            goto L_0x018a
        L_0x012c:
            r0 = move-exception
            goto L_0x019e
        L_0x012f:
            r1 = r21
            r0.a()     // Catch:{ all -> 0x012c }
            goto L_0x017a
        L_0x0135:
            r1 = r21
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x012c }
            java.lang.String r2 = r13.toString()     // Catch:{ all -> 0x012c }
            r0.<init>(r2)     // Catch:{ all -> 0x012c }
            throw r0     // Catch:{ all -> 0x012c }
        L_0x0141:
            r1 = r21
            long r2 = r24.q()     // Catch:{ all -> 0x012c }
            int r0 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x014e
            r19.a()     // Catch:{ all -> 0x012c }
        L_0x014e:
            wa.l r0 = r9.f8898i     // Catch:{ all -> 0x012c }
            if (r0 == 0) goto L_0x0160
            r2 = 0
            r3 = r25
            androidx.fragment.app.y r0 = hb.h0.v(r0, r3, r2)     // Catch:{ all -> 0x012c }
            if (r0 == 0) goto L_0x0160
            pa.k r2 = r1.f7822l     // Catch:{ all -> 0x012c }
            hb.h0.K0(r2, r0)     // Catch:{ all -> 0x012c }
        L_0x0160:
            java.lang.Throwable r0 = r24.r()     // Catch:{ all -> 0x012c }
            int r2 = la.l.f9802h     // Catch:{ all -> 0x012c }
            la.k r0 = hb.h0.I(r0)     // Catch:{ all -> 0x012c }
            r1.resumeWith(r0)     // Catch:{ all -> 0x012c }
            goto L_0x018a
        L_0x016e:
            r1 = r21
            int r6 = r18 + r20
            r2 = r19
            r1.a(r2, r6)     // Catch:{ all -> 0x012c }
            goto L_0x018a
        L_0x0178:
            r1 = r21
        L_0x017a:
            int r0 = la.l.f9802h     // Catch:{ all -> 0x012c }
            goto L_0x0185
        L_0x017d:
            r2 = r19
            r1 = r21
            r2.a()     // Catch:{ all -> 0x012c }
            goto L_0x017a
        L_0x0185:
            la.v r0 = la.v.f9814a     // Catch:{ all -> 0x012c }
            r1.resumeWith(r0)     // Catch:{ all -> 0x012c }
        L_0x018a:
            java.lang.Object r0 = r1.u()
            if (r0 != r15) goto L_0x0193
            hb.h0.m1(r26)
        L_0x0193:
            if (r0 != r15) goto L_0x0196
            goto L_0x0198
        L_0x0196:
            la.v r0 = la.v.f9814a
        L_0x0198:
            if (r0 != r15) goto L_0x01b7
            goto L_0x01b9
        L_0x019b:
            r0 = move-exception
            r1 = r21
        L_0x019e:
            r1.C()
            throw r0
        L_0x01a2:
            r3 = r25
            r2 = r19
            if (r16 == 0) goto L_0x01b7
            r2.h()
            java.lang.Object r0 = r24.y(r25, r26)
            if (r0 != r15) goto L_0x01b7
            goto L_0x01b9
        L_0x01b2:
            r2 = r19
            r2.a()
        L_0x01b7:
            la.v r0 = la.v.f9814a
        L_0x01b9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.g(java.lang.Object, pa.e):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cf, code lost:
        r0 = jb.k.f8923a;
        r1 = la.v.f9814a;
        r0.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(java.lang.Object r22) {
        /*
            r21 = this;
            r8 = r21
            java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = f8888j
            long r0 = r9.get(r8)
            r10 = 0
            boolean r2 = r8.u(r0, r10)
            r11 = 1
            r12 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r2 == 0) goto L_0x0017
            r0 = 0
            goto L_0x001d
        L_0x0017:
            long r0 = r0 & r12
            boolean r0 = r8.f(r0)
            r0 = r0 ^ r11
        L_0x001d:
            if (r0 == 0) goto L_0x0027
            jb.i r0 = jb.k.f8923a
            r0.getClass()
            jb.j r0 = jb.k.f8924b
            return r0
        L_0x0027:
            h3.u1 r14 = jb.e.f8909j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f8892n
            java.lang.Object r0 = r0.get(r8)
            jb.l r0 = (jb.l) r0
        L_0x0031:
            long r1 = r9.getAndIncrement(r8)
            long r15 = r1 & r12
            boolean r17 = r8.u(r1, r10)
            int r7 = jb.e.f8901b
            long r1 = (long) r7
            long r3 = r15 / r1
            long r1 = r15 % r1
            int r6 = (int) r1
            long r1 = r0.f10890j
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0054
            jb.l r1 = c(r8, r3, r0)
            if (r1 != 0) goto L_0x0052
            if (r17 == 0) goto L_0x0031
            goto L_0x009d
        L_0x0052:
            r4 = r1
            goto L_0x0055
        L_0x0054:
            r4 = r0
        L_0x0055:
            r0 = r21
            r1 = r4
            r2 = r6
            r3 = r22
            r18 = r4
            r4 = r15
            r19 = r6
            r6 = r14
            r20 = r7
            r7 = r17
            int r0 = d(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00ca
            if (r0 == r11) goto L_0x00cf
            r1 = 2
            if (r0 == r1) goto L_0x0098
            r1 = 3
            if (r0 == r1) goto L_0x008c
            r1 = 4
            if (r0 == r1) goto L_0x0080
            r1 = 5
            if (r0 == r1) goto L_0x007a
            goto L_0x007d
        L_0x007a:
            r18.a()
        L_0x007d:
            r0 = r18
            goto L_0x0031
        L_0x0080:
            long r0 = r21.q()
            int r2 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x009d
            r18.a()
            goto L_0x009d
        L_0x008c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0098:
            if (r17 == 0) goto L_0x00ab
            r18.h()
        L_0x009d:
            jb.i r0 = jb.k.f8923a
            java.lang.Throwable r1 = r21.r()
            r0.getClass()
            jb.h r0 = jb.i.a(r1)
            goto L_0x00d7
        L_0x00ab:
            boolean r0 = r14 instanceof hb.k2
            if (r0 == 0) goto L_0x00b2
            hb.k2 r14 = (hb.k2) r14
            goto L_0x00b3
        L_0x00b2:
            r14 = 0
        L_0x00b3:
            if (r14 == 0) goto L_0x00bd
            int r6 = r19 + r20
            r0 = r18
            r14.a(r0, r6)
            goto L_0x00bf
        L_0x00bd:
            r0 = r18
        L_0x00bf:
            r0.h()
            jb.i r0 = jb.k.f8923a
            r0.getClass()
            jb.j r0 = jb.k.f8924b
            goto L_0x00d7
        L_0x00ca:
            r0 = r18
            r0.a()
        L_0x00cf:
            jb.i r0 = jb.k.f8923a
            la.v r1 = la.v.f9814a
            r0.getClass()
            r0 = r1
        L_0x00d7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.h(java.lang.Object):java.lang.Object");
    }

    public final boolean i(Throwable th, boolean z10) {
        boolean z11;
        Object obj;
        u1 u1Var;
        boolean z12;
        long j10;
        int i10;
        long j11;
        long j12;
        long j13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8888j;
        if (z10) {
            do {
                j13 = atomicLongFieldUpdater.get(this);
                if (((int) (j13 >> 60)) != 0) {
                    break;
                }
                l lVar = e.f8900a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j13, (((long) 1) << 60) + (j13 & 1152921504606846975L)));
        }
        u1 u1Var2 = e.f8918s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8895q;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, u1Var2, th)) {
                if (atomicReferenceFieldUpdater.get(this) != u1Var2) {
                    z11 = false;
                    break;
                }
            } else {
                z11 = true;
                break;
            }
        }
        if (z10) {
            do {
                j12 = atomicLongFieldUpdater.get(this);
                l lVar2 = e.f8900a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j12, (((long) 3) << 60) + (j12 & 1152921504606846975L)));
        } else {
            do {
                j10 = atomicLongFieldUpdater.get(this);
                int i11 = (int) (j10 >> 60);
                if (i11 == 0) {
                    j11 = j10 & 1152921504606846975L;
                    l lVar3 = e.f8900a;
                    i10 = 2;
                } else if (i11 != 1) {
                    break;
                } else {
                    j11 = j10 & 1152921504606846975L;
                    l lVar4 = e.f8900a;
                    i10 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j10, (((long) i10) << 60) + j11));
        }
        l();
        if (z11) {
            do {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8896r;
                obj = atomicReferenceFieldUpdater2.get(this);
                if (obj == null) {
                    u1Var = e.f8916q;
                } else {
                    u1Var = e.f8917r;
                }
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, u1Var)) {
                        if (atomicReferenceFieldUpdater2.get(this) != obj) {
                            z12 = false;
                            continue;
                            break;
                        }
                    } else {
                        z12 = true;
                        continue;
                        break;
                    }
                }
            } while (!z12);
            if (obj != null) {
                y.c(1, obj);
                ((l) obj).invoke(p());
            }
        }
        return z11;
    }

    public final b iterator() {
        return new b(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009a, code lost:
        r1 = (jb.l) ((mb.e) mb.e.f10846i.get(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00eb, code lost:
        r4 = hb.h0.k1(r4, r6);
        r1.l(r5, true);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final jb.l j(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f8894p
            java.lang.Object r0 = r0.get(r13)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f8892n
            java.lang.Object r1 = r1.get(r13)
            jb.l r1 = (jb.l) r1
            long r2 = r1.f10890j
            r4 = r0
            jb.l r4 = (jb.l) r4
            long r4 = r4.f10890j
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x001a
            r0 = r1
        L_0x001a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f8893o
            java.lang.Object r1 = r1.get(r13)
            jb.l r1 = (jb.l) r1
            long r2 = r1.f10890j
            r4 = r0
            jb.l r4 = (jb.l) r4
            long r4 = r4.f10890j
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x002e
            r0 = r1
        L_0x002e:
            mb.e r0 = (mb.e) r0
            h3.u1 r1 = mb.d.f10843a
        L_0x0032:
            r0.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = mb.e.f10845h
            java.lang.Object r1 = r1.get(r0)
            h3.u1 r2 = mb.d.f10843a
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x0042
            goto L_0x0059
        L_0x0042:
            mb.e r1 = (mb.e) r1
            if (r1 != 0) goto L_0x012e
        L_0x0046:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = mb.e.f10845h
            boolean r5 = r1.compareAndSet(r0, r4, r2)
            if (r5 == 0) goto L_0x0050
            r1 = 1
            goto L_0x0057
        L_0x0050:
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x0046
            r1 = 0
        L_0x0057:
            if (r1 == 0) goto L_0x0032
        L_0x0059:
            jb.l r0 = (jb.l) r0
            boolean r1 = r13.v()
            r2 = -1
            if (r1 == 0) goto L_0x00ae
            r1 = r0
        L_0x0063:
            int r5 = jb.e.f8901b
            int r5 = r5 + r2
        L_0x0066:
            r6 = -1
            if (r2 >= r5) goto L_0x009a
            int r8 = jb.e.f8901b
            long r8 = (long) r8
            long r10 = r1.f10890j
            long r10 = r10 * r8
            long r8 = (long) r5
            long r10 = r10 + r8
            long r8 = r13.q()
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x007c
            goto L_0x00a6
        L_0x007c:
            java.lang.Object r8 = r1.k(r5)
            if (r8 == 0) goto L_0x008c
            h3.u1 r9 = jb.e.f8904e
            if (r8 != r9) goto L_0x0087
            goto L_0x008c
        L_0x0087:
            h3.u1 r9 = jb.e.f8903d
            if (r8 != r9) goto L_0x0097
            goto L_0x00a7
        L_0x008c:
            h3.u1 r9 = jb.e.f8911l
            boolean r8 = r1.j(r8, r5, r9)
            if (r8 == 0) goto L_0x007c
            r1.h()
        L_0x0097:
            int r5 = r5 + -1
            goto L_0x0066
        L_0x009a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = mb.e.f10846i
            java.lang.Object r1 = r5.get(r1)
            mb.e r1 = (mb.e) r1
            jb.l r1 = (jb.l) r1
            if (r1 != 0) goto L_0x0063
        L_0x00a6:
            r10 = r6
        L_0x00a7:
            int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00ae
            r13.k(r10)
        L_0x00ae:
            r1 = r0
        L_0x00af:
            if (r1 == 0) goto L_0x010c
            int r5 = jb.e.f8901b
            int r5 = r5 - r3
        L_0x00b4:
            if (r2 >= r5) goto L_0x0101
            int r6 = jb.e.f8901b
            long r6 = (long) r6
            long r8 = r1.f10890j
            long r8 = r8 * r6
            long r6 = (long) r5
            long r8 = r8 + r6
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 < 0) goto L_0x010c
        L_0x00c3:
            java.lang.Object r6 = r1.k(r5)
            if (r6 == 0) goto L_0x00f3
            h3.u1 r7 = jb.e.f8904e
            if (r6 != r7) goto L_0x00ce
            goto L_0x00f3
        L_0x00ce:
            boolean r7 = r6 instanceof jb.u
            if (r7 == 0) goto L_0x00df
            h3.u1 r7 = jb.e.f8911l
            boolean r7 = r1.j(r6, r5, r7)
            if (r7 == 0) goto L_0x00c3
            jb.u r6 = (jb.u) r6
            hb.k2 r6 = r6.f8932a
            goto L_0x00eb
        L_0x00df:
            boolean r7 = r6 instanceof hb.k2
            if (r7 == 0) goto L_0x00fe
            h3.u1 r7 = jb.e.f8911l
            boolean r7 = r1.j(r6, r5, r7)
            if (r7 == 0) goto L_0x00c3
        L_0x00eb:
            java.lang.Object r4 = hb.h0.k1(r4, r6)
            r1.l(r5, r3)
            goto L_0x00fe
        L_0x00f3:
            h3.u1 r7 = jb.e.f8911l
            boolean r6 = r1.j(r6, r5, r7)
            if (r6 == 0) goto L_0x00c3
            r1.h()
        L_0x00fe:
            int r5 = r5 + -1
            goto L_0x00b4
        L_0x0101:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = mb.e.f10846i
            java.lang.Object r1 = r5.get(r1)
            mb.e r1 = (mb.e) r1
            jb.l r1 = (jb.l) r1
            goto L_0x00af
        L_0x010c:
            if (r4 == 0) goto L_0x012d
            boolean r14 = r4 instanceof java.util.ArrayList
            if (r14 != 0) goto L_0x0118
            hb.k2 r4 = (hb.k2) r4
            r13.z(r4, r3)
            goto L_0x012d
        L_0x0118:
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r14 = r4.size()
            int r14 = r14 - r3
        L_0x011f:
            if (r2 >= r14) goto L_0x012d
            java.lang.Object r15 = r4.get(r14)
            hb.k2 r15 = (hb.k2) r15
            r13.z(r15, r3)
            int r14 = r14 + -1
            goto L_0x011f
        L_0x012d:
            return r0
        L_0x012e:
            r0 = r1
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.j(long):jb.l");
    }

    public final void k(long j10) {
        androidx.fragment.app.y v10;
        l lVar = (l) f8893o.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f8889k;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 >= Math.max(((long) this.f8897h) + j11, o())) {
                if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                    long j12 = (long) e.f8901b;
                    long j13 = j11 / j12;
                    int i10 = (int) (j11 % j12);
                    if (lVar.f10890j != j13) {
                        l n10 = n(j13, lVar);
                        if (n10 == null) {
                            continue;
                        } else {
                            lVar = n10;
                        }
                    }
                    Object C = C(lVar, i10, j11, (b) null);
                    if (C != e.f8914o) {
                        lVar.a();
                        l lVar2 = this.f8898i;
                        if (!(lVar2 == null || (v10 = h0.v(lVar2, C, (androidx.fragment.app.y) null)) == null)) {
                            throw v10;
                        }
                    } else if (j11 < s()) {
                        lVar.a();
                    }
                }
            } else {
                return;
            }
        }
    }

    public final boolean l() {
        return u(f8888j.get(this), false);
    }

    /* JADX WARNING: type inference failed for: r2v18, types: [mb.z] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x019a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0012 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0012 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r17 = this;
            r6 = r17
            boolean r0 = r17.w()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = f8894p
            java.lang.Object r0 = r7.get(r6)
            jb.l r0 = (jb.l) r0
            r8 = r0
        L_0x0012:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f8890l
            long r9 = r0.getAndIncrement(r6)
            int r0 = jb.e.f8901b
            long r0 = (long) r0
            long r0 = r9 / r0
            long r2 = r17.s()
            r11 = 1
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            long r2 = r8.f10890j
            if (r4 > 0) goto L_0x003a
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0036
            mb.e r2 = r8.b()
            if (r2 == 0) goto L_0x0036
            r6.x(r0, r8)
        L_0x0036:
            r6.t(r11)
            return
        L_0x003a:
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L_0x00d6
            jb.d r2 = jb.d.f8899q
        L_0x0040:
            java.lang.Object r3 = mb.d.a(r8, r0, r2)
            boolean r4 = hb.h0.T0(r3)
            if (r4 != 0) goto L_0x0092
            mb.z r4 = hb.h0.H0(r3)
        L_0x004e:
            java.lang.Object r5 = r7.get(r6)
            mb.z r5 = (mb.z) r5
            long r13 = r5.f10890j
            long r11 = r4.f10890j
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 < 0) goto L_0x005d
            goto L_0x007f
        L_0x005d:
            boolean r11 = r4.i()
            if (r11 != 0) goto L_0x0065
            r4 = 0
            goto L_0x0080
        L_0x0065:
            boolean r11 = r7.compareAndSet(r6, r5, r4)
            if (r11 == 0) goto L_0x006d
            r11 = 1
            goto L_0x0074
        L_0x006d:
            java.lang.Object r11 = r7.get(r6)
            if (r11 == r5) goto L_0x0065
            r11 = 0
        L_0x0074:
            if (r11 == 0) goto L_0x0086
            boolean r4 = r5.e()
            if (r4 == 0) goto L_0x007f
            r5.d()
        L_0x007f:
            r4 = 1
        L_0x0080:
            if (r4 == 0) goto L_0x0083
            goto L_0x0092
        L_0x0083:
            r11 = 1
            goto L_0x0040
        L_0x0086:
            boolean r5 = r4.e()
            if (r5 == 0) goto L_0x008f
            r4.d()
        L_0x008f:
            r11 = 1
            goto L_0x004e
        L_0x0092:
            boolean r2 = hb.h0.T0(r3)
            if (r2 == 0) goto L_0x009f
            r17.l()
            r6.x(r0, r8)
            goto L_0x00cb
        L_0x009f:
            mb.z r2 = hb.h0.H0(r3)
            r11 = r2
            jb.l r11 = (jb.l) r11
            long r2 = r11.f10890j
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f8890l
            r4 = 1
            long r12 = r9 + r4
            int r1 = jb.e.f8901b
            long r4 = (long) r1
            long r15 = r4 * r2
            r1 = r17
            r2 = r12
            r12 = r4
            r4 = r15
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x00cb
            long r0 = r11.f10890j
            long r0 = r0 * r12
            long r0 = r0 - r9
            r6.t(r0)
            goto L_0x00d0
        L_0x00cb:
            r0 = 1
            r6.t(r0)
        L_0x00d0:
            r11 = 0
        L_0x00d1:
            if (r11 != 0) goto L_0x00d5
            goto L_0x0012
        L_0x00d5:
            r8 = r11
        L_0x00d6:
            int r0 = jb.e.f8901b
            long r0 = (long) r0
            long r0 = r9 % r0
            int r1 = (int) r0
            java.lang.Object r0 = r8.k(r1)
            boolean r2 = r0 instanceof hb.k2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = f8889k
            if (r2 == 0) goto L_0x010e
            long r4 = r3.get(r6)
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x010e
            h3.u1 r2 = jb.e.f8906g
            boolean r2 = r8.j(r0, r1, r2)
            if (r2 == 0) goto L_0x010e
            boolean r0 = B(r0)
            if (r0 == 0) goto L_0x0103
            h3.u1 r0 = jb.e.f8903d
            r8.o(r1, r0)
            goto L_0x0192
        L_0x0103:
            h3.u1 r0 = jb.e.f8909j
            r8.o(r1, r0)
            r0 = 0
            r8.l(r1, r0)
            r2 = 0
            goto L_0x0151
        L_0x010e:
            java.lang.Object r0 = r8.k(r1)
            boolean r2 = r0 instanceof hb.k2
            if (r2 == 0) goto L_0x014c
            long r4 = r3.get(r6)
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x012e
            jb.u r2 = new jb.u
            r4 = r0
            hb.k2 r4 = (hb.k2) r4
            r2.<init>(r4)
            boolean r0 = r8.j(r0, r1, r2)
            if (r0 == 0) goto L_0x010e
            goto L_0x0192
        L_0x012e:
            h3.u1 r2 = jb.e.f8906g
            boolean r2 = r8.j(r0, r1, r2)
            if (r2 == 0) goto L_0x010e
            boolean r0 = B(r0)
            if (r0 == 0) goto L_0x0142
            h3.u1 r0 = jb.e.f8903d
            r8.o(r1, r0)
            goto L_0x0192
        L_0x0142:
            h3.u1 r0 = jb.e.f8909j
            r8.o(r1, r0)
            r2 = 0
            r8.l(r1, r2)
            goto L_0x0151
        L_0x014c:
            r2 = 0
            h3.u1 r4 = jb.e.f8909j
            if (r0 != r4) goto L_0x0153
        L_0x0151:
            r13 = 0
            goto L_0x0193
        L_0x0153:
            if (r0 != 0) goto L_0x015e
            h3.u1 r4 = jb.e.f8904e
            boolean r0 = r8.j(r0, r1, r4)
            if (r0 == 0) goto L_0x010e
            goto L_0x0192
        L_0x015e:
            h3.u1 r4 = jb.e.f8903d
            if (r0 != r4) goto L_0x0163
            goto L_0x0192
        L_0x0163:
            h3.u1 r4 = jb.e.f8907h
            if (r0 == r4) goto L_0x0192
            h3.u1 r4 = jb.e.f8908i
            if (r0 == r4) goto L_0x0192
            h3.u1 r4 = jb.e.f8910k
            if (r0 != r4) goto L_0x0170
            goto L_0x0192
        L_0x0170:
            h3.u1 r4 = jb.e.f8911l
            if (r0 != r4) goto L_0x0175
            goto L_0x0192
        L_0x0175:
            h3.u1 r4 = jb.e.f8905f
            if (r0 != r4) goto L_0x017a
            goto L_0x010e
        L_0x017a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected cell state: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0192:
            r13 = 1
        L_0x0193:
            r0 = 1
            r6.t(r0)
            if (r13 == 0) goto L_0x0012
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.m():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if ((r15.f10890j * ((long) jb.e.f8901b)) < s()) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ee, code lost:
        if ((r15.f10890j * ((long) jb.e.f8901b)) < s()) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final jb.l n(long r13, jb.l r15) {
        /*
            r12 = this;
            jb.l r0 = jb.e.f8900a
            jb.d r0 = jb.d.f8899q
        L_0x0004:
            java.lang.Object r1 = mb.d.a(r15, r13, r0)
            boolean r2 = hb.h0.T0(r1)
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x0055
            mb.z r2 = hb.h0.H0(r1)
        L_0x0014:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f8893o
            java.lang.Object r6 = r5.get(r12)
            mb.z r6 = (mb.z) r6
            long r7 = r6.f10890j
            long r9 = r2.f10890j
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0025
            goto L_0x0047
        L_0x0025:
            boolean r7 = r2.i()
            if (r7 != 0) goto L_0x002d
            r2 = 0
            goto L_0x0048
        L_0x002d:
            boolean r7 = r5.compareAndSet(r12, r6, r2)
            if (r7 == 0) goto L_0x0035
            r5 = 1
            goto L_0x003c
        L_0x0035:
            java.lang.Object r7 = r5.get(r12)
            if (r7 == r6) goto L_0x002d
            r5 = 0
        L_0x003c:
            if (r5 == 0) goto L_0x004b
            boolean r2 = r6.e()
            if (r2 == 0) goto L_0x0047
            r6.d()
        L_0x0047:
            r2 = 1
        L_0x0048:
            if (r2 == 0) goto L_0x0004
            goto L_0x0055
        L_0x004b:
            boolean r5 = r2.e()
            if (r5 == 0) goto L_0x0014
            r2.d()
            goto L_0x0014
        L_0x0055:
            boolean r0 = hb.h0.T0(r1)
            if (r0 == 0) goto L_0x0072
            r12.l()
            int r13 = jb.e.f8901b
            long r13 = (long) r13
            long r0 = r15.f10890j
            long r0 = r0 * r13
            long r13 = r12.s()
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x00f2
        L_0x006d:
            r15.a()
            goto L_0x00f2
        L_0x0072:
            mb.z r15 = hb.h0.H0(r1)
            jb.l r15 = (jb.l) r15
            boolean r0 = r12.w()
            long r1 = r15.f10890j
            if (r0 != 0) goto L_0x00c5
            long r5 = r12.o()
            int r0 = jb.e.f8901b
            long r7 = (long) r0
            long r5 = r5 / r7
            int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x00c5
        L_0x008c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f8894p
            java.lang.Object r5 = r0.get(r12)
            mb.z r5 = (mb.z) r5
            long r6 = r5.f10890j
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x00c5
            boolean r6 = r15.i()
            if (r6 == 0) goto L_0x00c5
        L_0x00a0:
            boolean r6 = r0.compareAndSet(r12, r5, r15)
            if (r6 == 0) goto L_0x00a8
            r0 = 1
            goto L_0x00af
        L_0x00a8:
            java.lang.Object r6 = r0.get(r12)
            if (r6 == r5) goto L_0x00a0
            r0 = 0
        L_0x00af:
            if (r0 == 0) goto L_0x00bb
            boolean r0 = r5.e()
            if (r0 == 0) goto L_0x00c5
            r5.d()
            goto L_0x00c5
        L_0x00bb:
            boolean r0 = r15.e()
            if (r0 == 0) goto L_0x008c
            r15.d()
            goto L_0x008c
        L_0x00c5:
            int r0 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f3
            int r13 = jb.e.f8901b
            long r13 = (long) r13
            long r1 = r1 * r13
        L_0x00ce:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = f8889k
            long r5 = r3.get(r12)
            int r13 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x00d9
            goto L_0x00e1
        L_0x00d9:
            r4 = r12
            r7 = r1
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L_0x00ce
        L_0x00e1:
            int r13 = jb.e.f8901b
            long r13 = (long) r13
            long r0 = r15.f10890j
            long r0 = r0 * r13
            long r13 = r12.s()
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x00f2
            goto L_0x006d
        L_0x00f2:
            r15 = 0
        L_0x00f3:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.n(long, jb.l):jb.l");
    }

    public final long o() {
        return f8890l.get(this);
    }

    public final Throwable p() {
        return (Throwable) f8895q.get(this);
    }

    public final long q() {
        return f8889k.get(this);
    }

    public final Throwable r() {
        Throwable p10 = p();
        return p10 == null ? new n() : p10;
    }

    public final long s() {
        return f8888j.get(this) & 1152921504606846975L;
    }

    public final void t(long j10) {
        boolean z10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8891m;
        if ((atomicLongFieldUpdater.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            do {
                if ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
            } while (z10);
        }
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [mb.e] */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0198, code lost:
        r3 = r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x019f, code lost:
        if (r3 != null) goto L_0x01d7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f8888j
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r3 = (int) r2
            r2 = 3
            r4 = 2
            if (r3 == r4) goto L_0x001b
            if (r3 == r2) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            java.lang.String r3 = "cancelled,"
            goto L_0x001d
        L_0x001b:
            java.lang.String r3 = "closed,"
        L_0x001d:
            r1.append(r3)
        L_0x0020:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "capacity="
            r3.<init>(r5)
            int r5 = r0.f8897h
            r3.append(r5)
            r5 = 44
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r1.append(r3)
            java.lang.String r3 = "data=["
            r1.append(r3)
            jb.l[] r2 = new jb.l[r2]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f8893o
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f8892n
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f8894p
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = ma.r.e(r2)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0066:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r2.next()
            r8 = r4
            jb.l r8 = (jb.l) r8
            jb.l r9 = jb.e.f8900a
            if (r8 == r9) goto L_0x0079
            r8 = 1
            goto L_0x007a
        L_0x0079:
            r8 = 0
        L_0x007a:
            if (r8 == 0) goto L_0x0066
            r3.add(r4)
            goto L_0x0066
        L_0x0080:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01db
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x0095
            goto L_0x00af
        L_0x0095:
            r4 = r3
            jb.l r4 = (jb.l) r4
            long r8 = r4.f10890j
        L_0x009a:
            java.lang.Object r4 = r2.next()
            r10 = r4
            jb.l r10 = (jb.l) r10
            long r10 = r10.f10890j
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00a9
            r3 = r4
            r8 = r10
        L_0x00a9:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009a
        L_0x00af:
            jb.l r3 = (jb.l) r3
            long r10 = r16.q()
            long r12 = r16.s()
        L_0x00b9:
            int r2 = jb.e.f8901b
            r4 = 0
        L_0x00bc:
            if (r4 >= r2) goto L_0x0198
            long r8 = r3.f10890j
            int r14 = jb.e.f8901b
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00cf
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x01a1
        L_0x00cf:
            java.lang.Object r15 = r3.k(r4)
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r3.f8926m
            int r7 = r4 * 2
            java.lang.Object r6 = r6.get(r7)
            boolean r7 = r15 instanceof hb.k
            if (r7 == 0) goto L_0x00f5
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00e9
            if (r14 < 0) goto L_0x00e9
            java.lang.String r7 = "receive"
            goto L_0x0164
        L_0x00e9:
            if (r14 >= 0) goto L_0x00f1
            if (r7 < 0) goto L_0x00f1
            java.lang.String r7 = "send"
            goto L_0x0164
        L_0x00f1:
            java.lang.String r7 = "cont"
            goto L_0x0164
        L_0x00f5:
            boolean r7 = r15 instanceof jb.u
            if (r7 == 0) goto L_0x010d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "EB("
            r7.<init>(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x0164
        L_0x010d:
            h3.u1 r7 = jb.e.f8905f
            boolean r7 = xa.j.a(r15, r7)
            if (r7 == 0) goto L_0x0117
            r7 = 1
            goto L_0x011d
        L_0x0117:
            h3.u1 r7 = jb.e.f8906g
            boolean r7 = xa.j.a(r15, r7)
        L_0x011d:
            if (r7 == 0) goto L_0x0122
            java.lang.String r7 = "resuming_sender"
            goto L_0x0164
        L_0x0122:
            if (r15 != 0) goto L_0x0126
            r7 = 1
            goto L_0x012c
        L_0x0126:
            h3.u1 r7 = jb.e.f8904e
            boolean r7 = xa.j.a(r15, r7)
        L_0x012c:
            if (r7 == 0) goto L_0x0130
            r7 = 1
            goto L_0x0136
        L_0x0130:
            h3.u1 r7 = jb.e.f8908i
            boolean r7 = xa.j.a(r15, r7)
        L_0x0136:
            if (r7 == 0) goto L_0x013a
            r7 = 1
            goto L_0x0140
        L_0x013a:
            h3.u1 r7 = jb.e.f8907h
            boolean r7 = xa.j.a(r15, r7)
        L_0x0140:
            if (r7 == 0) goto L_0x0144
            r7 = 1
            goto L_0x014a
        L_0x0144:
            h3.u1 r7 = jb.e.f8910k
            boolean r7 = xa.j.a(r15, r7)
        L_0x014a:
            if (r7 == 0) goto L_0x014e
            r7 = 1
            goto L_0x0154
        L_0x014e:
            h3.u1 r7 = jb.e.f8909j
            boolean r7 = xa.j.a(r15, r7)
        L_0x0154:
            if (r7 == 0) goto L_0x0158
            r7 = 1
            goto L_0x015e
        L_0x0158:
            h3.u1 r7 = jb.e.f8911l
            boolean r7 = xa.j.a(r15, r7)
        L_0x015e:
            if (r7 != 0) goto L_0x0192
            java.lang.String r7 = r15.toString()
        L_0x0164:
            if (r6 == 0) goto L_0x0180
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "("
            r8.<init>(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            goto L_0x018f
        L_0x0180:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
        L_0x018f:
            r1.append(r6)
        L_0x0192:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00bc
        L_0x0198:
            mb.e r2 = r3.b()
            r3 = r2
            jb.l r3 = (jb.l) r3
            if (r3 != 0) goto L_0x01d7
        L_0x01a1:
            int r2 = r1.length()
            if (r2 != 0) goto L_0x01a9
            r6 = 1
            goto L_0x01aa
        L_0x01a9:
            r6 = 0
        L_0x01aa:
            if (r6 != 0) goto L_0x01cf
            int r2 = fb.y.q(r1)
            char r2 = r1.charAt(r2)
            if (r2 != r5) goto L_0x01c5
            int r2 = r1.length()
            r4 = 1
            int r2 = r2 - r4
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "this.deleteCharAt(index)"
            xa.j.e(r3, r2)
        L_0x01c5:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x01cf:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            java.lang.String r2 = "Char sequence is empty."
            r1.<init>(r2)
            throw r1
        L_0x01d7:
            r6 = 0
            r7 = 1
            goto L_0x00b9
        L_0x01db:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.toString():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a3, code lost:
        r13.n(r2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        r13.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b6, code lost:
        r13 = (jb.l) ((mb.e) mb.e.f10846i.get(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0130, code lost:
        r13 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u(long r13, boolean r15) {
        /*
            r12 = this;
            r0 = 60
            long r0 = r13 >> r0
            int r1 = (int) r0
            r0 = 0
            if (r1 == 0) goto L_0x018f
            r2 = 1
            if (r1 == r2) goto L_0x018f
            r2 = 2
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r1 == r2) goto L_0x00f8
            r15 = 3
            if (r1 != r15) goto L_0x00e8
            long r13 = r13 & r3
            jb.l r13 = r12.j(r13)
            r14 = 0
            r15 = r14
            r1 = r15
        L_0x001e:
            int r2 = jb.e.f8901b
            r3 = -1
            int r2 = r2 + r3
        L_0x0022:
            if (r3 >= r2) goto L_0x00b6
            int r4 = jb.e.f8901b
            long r4 = (long) r4
            long r6 = r13.f10890j
            long r6 = r6 * r4
            long r4 = (long) r2
            long r6 = r6 + r4
        L_0x002d:
            java.lang.Object r4 = r13.k(r2)
            h3.u1 r5 = jb.e.f8908i
            if (r4 == r5) goto L_0x00c2
            h3.u1 r5 = jb.e.f8903d
            java.util.concurrent.atomic.AtomicReferenceArray r8 = r13.f8926m
            wa.l r9 = r12.f8898i
            if (r4 != r5) goto L_0x005a
            long r10 = r12.q()
            int r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x00c2
            h3.u1 r5 = jb.e.f8911l
            boolean r4 = r13.j(r4, r2, r5)
            if (r4 == 0) goto L_0x002d
            if (r9 == 0) goto L_0x00a3
            int r4 = r2 * 2
            java.lang.Object r4 = r8.get(r4)
            androidx.fragment.app.y r1 = hb.h0.v(r9, r4, r1)
            goto L_0x00a3
        L_0x005a:
            h3.u1 r5 = jb.e.f8904e
            if (r4 == r5) goto L_0x00a7
            if (r4 != 0) goto L_0x0061
            goto L_0x00a7
        L_0x0061:
            boolean r5 = r4 instanceof hb.k2
            if (r5 != 0) goto L_0x0076
            boolean r5 = r4 instanceof jb.u
            if (r5 == 0) goto L_0x006a
            goto L_0x0076
        L_0x006a:
            h3.u1 r5 = jb.e.f8906g
            if (r4 == r5) goto L_0x00c2
            h3.u1 r8 = jb.e.f8905f
            if (r4 != r8) goto L_0x0073
            goto L_0x00c2
        L_0x0073:
            if (r4 == r5) goto L_0x002d
            goto L_0x00b2
        L_0x0076:
            long r10 = r12.q()
            int r5 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x00c2
            boolean r5 = r4 instanceof jb.u
            if (r5 == 0) goto L_0x0088
            r5 = r4
            jb.u r5 = (jb.u) r5
            hb.k2 r5 = r5.f8932a
            goto L_0x008b
        L_0x0088:
            r5 = r4
            hb.k2 r5 = (hb.k2) r5
        L_0x008b:
            h3.u1 r10 = jb.e.f8911l
            boolean r4 = r13.j(r4, r2, r10)
            if (r4 == 0) goto L_0x002d
            if (r9 == 0) goto L_0x009f
            int r4 = r2 * 2
            java.lang.Object r4 = r8.get(r4)
            androidx.fragment.app.y r1 = hb.h0.v(r9, r4, r1)
        L_0x009f:
            java.lang.Object r15 = hb.h0.k1(r15, r5)
        L_0x00a3:
            r13.n(r2, r14)
            goto L_0x00af
        L_0x00a7:
            h3.u1 r5 = jb.e.f8911l
            boolean r4 = r13.j(r4, r2, r5)
            if (r4 == 0) goto L_0x002d
        L_0x00af:
            r13.h()
        L_0x00b2:
            int r2 = r2 + -1
            goto L_0x0022
        L_0x00b6:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = mb.e.f10846i
            java.lang.Object r13 = r2.get(r13)
            mb.e r13 = (mb.e) r13
            jb.l r13 = (jb.l) r13
            if (r13 != 0) goto L_0x001e
        L_0x00c2:
            if (r15 == 0) goto L_0x00e3
            boolean r13 = r15 instanceof java.util.ArrayList
            if (r13 != 0) goto L_0x00ce
            hb.k2 r15 = (hb.k2) r15
            r12.z(r15, r0)
            goto L_0x00e3
        L_0x00ce:
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            int r13 = r15.size()
            int r13 = r13 + r3
        L_0x00d5:
            if (r3 >= r13) goto L_0x00e3
            java.lang.Object r14 = r15.get(r13)
            hb.k2 r14 = (hb.k2) r14
            r12.z(r14, r0)
            int r13 = r13 + -1
            goto L_0x00d5
        L_0x00e3:
            if (r1 != 0) goto L_0x00e7
            goto L_0x018e
        L_0x00e7:
            throw r1
        L_0x00e8:
            java.lang.String r13 = "unexpected close status: "
            java.lang.String r13 = android.support.v4.media.h.i(r13, r1)
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            throw r14
        L_0x00f8:
            long r13 = r13 & r3
            r12.j(r13)
            if (r15 == 0) goto L_0x018e
        L_0x00fe:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = f8893o
            java.lang.Object r14 = r13.get(r12)
            jb.l r14 = (jb.l) r14
            long r3 = r12.q()
            long r1 = r12.s()
            int r15 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r15 > 0) goto L_0x0113
            goto L_0x0130
        L_0x0113:
            int r15 = jb.e.f8901b
            long r1 = (long) r15
            long r5 = r3 / r1
            long r7 = r14.f10890j
            int r15 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r15 == 0) goto L_0x0132
            jb.l r14 = r12.n(r5, r14)
            if (r14 != 0) goto L_0x0132
            java.lang.Object r13 = r13.get(r12)
            jb.l r13 = (jb.l) r13
            long r13 = r13.f10890j
            int r15 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r15 >= 0) goto L_0x00fe
        L_0x0130:
            r13 = 0
            goto L_0x017f
        L_0x0132:
            r14.a()
            long r1 = r3 % r1
            int r13 = (int) r1
        L_0x0138:
            java.lang.Object r15 = r14.k(r13)
            if (r15 == 0) goto L_0x0170
            h3.u1 r1 = jb.e.f8904e
            if (r15 != r1) goto L_0x0143
            goto L_0x0170
        L_0x0143:
            h3.u1 r13 = jb.e.f8903d
            if (r15 != r13) goto L_0x0148
            goto L_0x016e
        L_0x0148:
            h3.u1 r13 = jb.e.f8909j
            if (r15 != r13) goto L_0x014d
            goto L_0x017b
        L_0x014d:
            h3.u1 r13 = jb.e.f8911l
            if (r15 != r13) goto L_0x0152
            goto L_0x017b
        L_0x0152:
            h3.u1 r13 = jb.e.f8908i
            if (r15 != r13) goto L_0x0157
            goto L_0x017b
        L_0x0157:
            h3.u1 r13 = jb.e.f8907h
            if (r15 != r13) goto L_0x015c
            goto L_0x017b
        L_0x015c:
            h3.u1 r13 = jb.e.f8906g
            if (r15 != r13) goto L_0x0161
            goto L_0x016e
        L_0x0161:
            h3.u1 r13 = jb.e.f8905f
            if (r15 != r13) goto L_0x0166
            goto L_0x017b
        L_0x0166:
            long r13 = r12.q()
            int r15 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x017b
        L_0x016e:
            r13 = 1
            goto L_0x017c
        L_0x0170:
            h3.u1 r1 = jb.e.f8907h
            boolean r15 = r14.j(r15, r13, r1)
            if (r15 == 0) goto L_0x0138
            r12.m()
        L_0x017b:
            r13 = 0
        L_0x017c:
            if (r13 == 0) goto L_0x0182
            r13 = 1
        L_0x017f:
            if (r13 != 0) goto L_0x018f
            goto L_0x018e
        L_0x0182:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f8889k
            r13 = 1
            long r5 = r3 + r13
            r2 = r12
            r1.compareAndSet(r2, r3, r5)
            goto L_0x00fe
        L_0x018e:
            r0 = 1
        L_0x018f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.c.u(long, boolean):boolean");
    }

    public boolean v() {
        return false;
    }

    public final boolean w() {
        long o10 = o();
        return o10 == 0 || o10 == Long.MAX_VALUE;
    }

    public final void x(long j10, l lVar) {
        boolean z10;
        l lVar2;
        l lVar3;
        while (lVar.f10890j < j10 && (lVar3 = (l) lVar.b()) != null) {
            lVar = lVar3;
        }
        while (true) {
            if (!lVar.c() || (lVar2 = (l) lVar.b()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8894p;
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (zVar.f10890j >= lVar.f10890j) {
                        break;
                    }
                    boolean z11 = false;
                    if (!lVar.i()) {
                        z10 = false;
                        break;
                    }
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, zVar, lVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != zVar) {
                                break;
                            }
                        } else {
                            z11 = true;
                            break;
                        }
                    }
                    if (z11) {
                        if (zVar.e()) {
                            zVar.d();
                        }
                    } else if (lVar.e()) {
                        lVar.d();
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                lVar = lVar2;
            }
        }
    }

    public final Object y(Object obj, e eVar) {
        Throwable th;
        hb.l lVar = new hb.l(1, d.b(eVar));
        lVar.w();
        l lVar2 = this.f8898i;
        if (lVar2 == null || (th = h0.v(lVar2, obj, (androidx.fragment.app.y) null)) == null) {
            th = r();
        } else {
            a.a(th, r());
        }
        int i10 = la.l.f9802h;
        lVar.resumeWith(h0.I(th));
        Object u10 = lVar.u();
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (u10 == aVar) {
            h0.m1(eVar);
        }
        if (u10 == aVar) {
            return u10;
        }
        return v.f9814a;
    }

    public final void z(k2 k2Var, boolean z10) {
        Object obj;
        Throwable th;
        if (k2Var instanceof k) {
            e eVar = (e) k2Var;
            int i10 = la.l.f9802h;
            if (z10) {
                th = p();
                if (th == null) {
                    th = new m();
                }
            } else {
                th = r();
            }
            eVar.resumeWith(h0.I(th));
        } else if (k2Var instanceof b) {
            b bVar = (b) k2Var;
            hb.l lVar = bVar.f8886i;
            j.c(lVar);
            bVar.f8886i = null;
            bVar.f8885h = e.f8911l;
            Throwable p10 = bVar.f8887j.p();
            if (p10 == null) {
                int i11 = la.l.f9802h;
                obj = Boolean.FALSE;
            } else {
                int i12 = la.l.f9802h;
                obj = h0.I(p10);
            }
            lVar.resumeWith(obj);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + k2Var).toString());
        }
    }
}
