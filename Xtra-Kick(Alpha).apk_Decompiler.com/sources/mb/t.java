package mb;

import h3.u1;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final class t {

    /* renamed from: e  reason: collision with root package name */
    public static final r f10878e = new r(0);

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10879f;

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f10880g;

    /* renamed from: h  reason: collision with root package name */
    public static final u1 f10881h = new u1("REMOVE_FROZEN", 2);
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a  reason: collision with root package name */
    public final int f10882a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10883b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10884c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReferenceArray f10885d;

    static {
        Class<t> cls = t.class;
        f10879f = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f10880g = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public t(int i10, boolean z10) {
        this.f10882a = i10;
        this.f10883b = z10;
        int i11 = i10 - 1;
        this.f10884c = i11;
        this.f10885d = new AtomicReferenceArray(i10);
        boolean z11 = false;
        if (i11 <= 1073741823) {
            if (!((i10 & i11) == 0 ? true : z11)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int a(Object obj) {
        Object obj2 = obj;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f10880g;
            long j10 = atomicLongFieldUpdater.get(this);
            r rVar = f10878e;
            if ((3458764513820540928L & j10) != 0) {
                rVar.getClass();
                if ((2305843009213693952L & j10) != 0) {
                    return 2;
                }
                return 1;
            }
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f10884c;
            if (((i11 + 2) & i12) == (i10 & i12)) {
                return 1;
            }
            boolean z10 = this.f10883b;
            AtomicReferenceArray atomicReferenceArray = this.f10885d;
            if (z10 || atomicReferenceArray.get(i11 & i12) == null) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = f10880g;
                rVar.getClass();
                if (atomicLongFieldUpdater2.compareAndSet(this, j10, (j10 & -1152921503533105153L) | (((long) ((i11 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i11 & i12, obj2);
                    t tVar = this;
                    while ((atomicLongFieldUpdater.get(tVar) & 1152921504606846976L) != 0) {
                        tVar = tVar.c();
                        AtomicReferenceArray atomicReferenceArray2 = tVar.f10885d;
                        int i13 = tVar.f10884c & i11;
                        Object obj3 = atomicReferenceArray2.get(i13);
                        if (!(obj3 instanceof s) || ((s) obj3).f10877a != i11) {
                            tVar = null;
                            continue;
                        } else {
                            atomicReferenceArray2.set(i13, obj2);
                            continue;
                        }
                        if (tVar == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i14 = this.f10882a;
                if (i14 < 1024 || ((i11 - i10) & 1073741823) > (i14 >> 1)) {
                    return 1;
                }
            }
        }
        return 1;
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        do {
            atomicLongFieldUpdater = f10880g;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, 2305843009213693952L | j10));
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071 A[LOOP:3: B:16:0x0071->B:19:0x007d, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final mb.t c() {
        /*
            r10 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = f10880g
            long r2 = r6.get(r10)
            r0 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r0
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0011
            goto L_0x001d
        L_0x0011:
            long r7 = r2 | r0
            r0 = r6
            r1 = r10
            r4 = r7
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            r2 = r7
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f10879f
            java.lang.Object r1 = r0.get(r10)
            mb.t r1 = (mb.t) r1
            if (r1 == 0) goto L_0x0028
            return r1
        L_0x0028:
            mb.t r1 = new mb.t
            int r4 = r10.f10882a
            int r4 = r4 * 2
            boolean r5 = r10.f10883b
            r1.<init>(r4, r5)
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r7 = 0
            long r4 = r4 >> r7
            int r5 = (int) r4
            r7 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r7 = r7 & r2
            r4 = 30
            long r7 = r7 >> r4
            int r4 = (int) r7
        L_0x0044:
            int r7 = r10.f10884c
            r8 = r5 & r7
            r7 = r7 & r4
            if (r8 == r7) goto L_0x0063
            java.util.concurrent.atomic.AtomicReferenceArray r7 = r10.f10885d
            java.lang.Object r7 = r7.get(r8)
            if (r7 != 0) goto L_0x0058
            mb.s r7 = new mb.s
            r7.<init>(r5)
        L_0x0058:
            java.util.concurrent.atomic.AtomicReferenceArray r8 = r1.f10885d
            int r9 = r1.f10884c
            r9 = r9 & r5
            r8.set(r9, r7)
            int r5 = r5 + 1
            goto L_0x0044
        L_0x0063:
            mb.r r4 = f10878e
            r4.getClass()
            r4 = -1152921504606846977(0xefffffffffffffff, double:-3.1050361846014175E231)
            long r4 = r4 & r2
            r6.set(r1, r4)
        L_0x0071:
            r4 = 0
            boolean r4 = r0.compareAndSet(r10, r4, r1)
            if (r4 == 0) goto L_0x0079
            goto L_0x001d
        L_0x0079:
            java.lang.Object r4 = r0.get(r10)
            if (r4 == 0) goto L_0x0071
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.t.c():mb.t");
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f10880g;
            long j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return f10881h;
            }
            int i10 = (int) ((j10 & 1073741823) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f10884c;
            int i13 = i10 & i12;
            if ((i11 & i12) == i13) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f10885d;
            Object obj = atomicReferenceArray.get(i13);
            boolean z10 = this.f10883b;
            if (obj == null) {
                if (z10) {
                    return null;
                }
            } else if (obj instanceof s) {
                return null;
            } else {
                f10878e.getClass();
                long j11 = ((long) ((i10 + 1) & 1073741823)) << 0;
                AtomicReferenceArray atomicReferenceArray2 = atomicReferenceArray;
                Object obj2 = obj;
                if (atomicLongFieldUpdater.compareAndSet(this, j10, (j10 & -1073741824) | j11)) {
                    atomicReferenceArray2.set(i13, (Object) null);
                    return obj2;
                } else if (z10) {
                    t tVar = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f10880g;
                        long j12 = atomicLongFieldUpdater2.get(tVar);
                        int i14 = (int) ((j12 & 1073741823) >> 0);
                        if ((j12 & 1152921504606846976L) != 0) {
                            tVar = tVar.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(tVar, j12, (j12 & -1073741824) | j11)) {
                                tVar.f10885d.set(tVar.f10884c & i14, (Object) null);
                                tVar = null;
                            } else {
                                continue;
                            }
                        }
                        if (tVar == null) {
                            return obj2;
                        }
                    }
                }
            }
        }
    }
}
