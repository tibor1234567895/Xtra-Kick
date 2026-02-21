package mb;

import h3.u1;
import hb.h0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import xa.j;

public class p {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10873h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10874i;

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f10875j;
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    static {
        Class<p> cls = p.class;
        Class<Object> cls2 = Object.class;
        f10873h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f10874i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        f10875j = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        r6 = ((mb.w) r6).f10887a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r5.compareAndSet(r4, r2, r6) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r5.get(r4) == r2) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        if (r7 != false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final mb.p h() {
        /*
            r11 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f10874i
            java.lang.Object r1 = r0.get(r11)
            mb.p r1 = (mb.p) r1
            r2 = r1
        L_0x0009:
            r3 = 0
            r4 = r3
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f10873h
            java.lang.Object r6 = r5.get(r2)
            r7 = 1
            r8 = 0
            if (r6 != r11) goto L_0x002a
            if (r1 != r2) goto L_0x0018
            return r2
        L_0x0018:
            boolean r3 = r0.compareAndSet(r11, r1, r2)
            if (r3 == 0) goto L_0x001f
            goto L_0x0026
        L_0x001f:
            java.lang.Object r3 = r0.get(r11)
            if (r3 == r1) goto L_0x0018
            r7 = 0
        L_0x0026:
            if (r7 != 0) goto L_0x0029
            goto L_0x0000
        L_0x0029:
            return r2
        L_0x002a:
            boolean r9 = r11.n()
            if (r9 == 0) goto L_0x0031
            return r3
        L_0x0031:
            if (r6 != 0) goto L_0x0034
            return r2
        L_0x0034:
            boolean r9 = r6 instanceof mb.v
            if (r9 == 0) goto L_0x003e
            mb.v r6 = (mb.v) r6
            r6.a(r2)
            goto L_0x0000
        L_0x003e:
            boolean r9 = r6 instanceof mb.w
            if (r9 == 0) goto L_0x0062
            if (r4 == 0) goto L_0x005b
            mb.w r6 = (mb.w) r6
            mb.p r6 = r6.f10887a
        L_0x0048:
            boolean r3 = r5.compareAndSet(r4, r2, r6)
            if (r3 == 0) goto L_0x004f
            goto L_0x0056
        L_0x004f:
            java.lang.Object r3 = r5.get(r4)
            if (r3 == r2) goto L_0x0048
            r7 = 0
        L_0x0056:
            if (r7 != 0) goto L_0x0059
            goto L_0x0000
        L_0x0059:
            r2 = r4
            goto L_0x0009
        L_0x005b:
            java.lang.Object r2 = r0.get(r2)
            mb.p r2 = (mb.p) r2
            goto L_0x000b
        L_0x0062:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            xa.j.d(r4, r6)
            r4 = r6
            mb.p r4 = (mb.p) r4
            r10 = r4
            r4 = r2
            r2 = r10
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.p.h():mb.p");
    }

    public final void i(p pVar) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10874i;
            p pVar2 = (p) atomicReferenceFieldUpdater.get(pVar);
            if (j() == pVar) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(pVar, pVar2, this)) {
                        if (atomicReferenceFieldUpdater.get(pVar) != pVar2) {
                            z10 = false;
                            continue;
                            break;
                        }
                    } else {
                        z10 = true;
                        continue;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z10);
        if (n()) {
            pVar.h();
        }
    }

    public final Object j() {
        while (true) {
            Object obj = f10873h.get(this);
            if (!(obj instanceof v)) {
                return obj;
            }
            ((v) obj).a(this);
        }
    }

    public final p l() {
        w wVar;
        p pVar;
        Object j10 = j();
        u1 u1Var = n.f10872a;
        if (j10 instanceof w) {
            wVar = (w) j10;
        } else {
            wVar = null;
        }
        if (wVar != null && (pVar = wVar.f10887a) != null) {
            return pVar;
        }
        j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", j10);
        return (p) j10;
    }

    public final p m() {
        p h10 = h();
        if (h10 == null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10874i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            while (true) {
                h10 = (p) obj;
                if (!h10.n()) {
                    break;
                }
                obj = atomicReferenceFieldUpdater.get(h10);
            }
        }
        return h10;
    }

    public boolean n() {
        return j() instanceof w;
    }

    public String toString() {
        return new o(this) + '@' + h0.r0(this);
    }
}
