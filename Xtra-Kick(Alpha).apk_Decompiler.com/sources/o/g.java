package o;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class g implements Iterable {

    /* renamed from: h  reason: collision with root package name */
    public c f11849h;

    /* renamed from: i  reason: collision with root package name */
    public c f11850i;

    /* renamed from: j  reason: collision with root package name */
    public final WeakHashMap f11851j = new WeakHashMap();

    /* renamed from: k  reason: collision with root package name */
    public int f11852k = 0;

    public c a(Object obj) {
        c cVar = this.f11849h;
        while (cVar != null && !cVar.f11840h.equals(obj)) {
            cVar = cVar.f11842j;
        }
        return cVar;
    }

    public Object b(Object obj, Object obj2) {
        c a10 = a(obj);
        if (a10 != null) {
            return a10.f11841i;
        }
        c cVar = new c(obj, obj2);
        this.f11852k++;
        c cVar2 = this.f11850i;
        if (cVar2 == null) {
            this.f11849h = cVar;
        } else {
            cVar2.f11842j = cVar;
            cVar.f11843k = cVar2;
        }
        this.f11850i = cVar;
        return null;
    }

    public Object c(Object obj) {
        c a10 = a(obj);
        if (a10 == null) {
            return null;
        }
        this.f11852k--;
        WeakHashMap weakHashMap = this.f11851j;
        if (!weakHashMap.isEmpty()) {
            for (f a11 : weakHashMap.keySet()) {
                a11.a(a10);
            }
        }
        c cVar = a10.f11843k;
        c cVar2 = a10.f11842j;
        if (cVar != null) {
            cVar.f11842j = cVar2;
        } else {
            this.f11849h = cVar2;
        }
        c cVar3 = a10.f11842j;
        if (cVar3 != null) {
            cVar3.f11843k = cVar;
        } else {
            this.f11850i = cVar;
        }
        a10.f11842j = null;
        a10.f11843k = null;
        return a10.f11841i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r3.hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (((o.e) r7).hasNext() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof o.g
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            o.g r7 = (o.g) r7
            int r1 = r6.f11852k
            int r3 = r7.f11852k
            if (r1 == r3) goto L_0x0013
            return r2
        L_0x0013:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x001b:
            r3 = r1
            o.e r3 = (o.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0044
            r4 = r7
            o.e r4 = (o.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0044
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L_0x003b
            if (r4 != 0) goto L_0x0043
        L_0x003b:
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x001b
        L_0x0043:
            return r2
        L_0x0044:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L_0x0053
            o.e r7 = (o.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return i10;
            }
            i10 += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    public final Iterator iterator() {
        b bVar = new b(this.f11849h, this.f11850i, 0);
        this.f11851j.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                sb2.append(((Map.Entry) eVar.next()).toString());
                if (eVar.hasNext()) {
                    sb2.append(", ");
                }
            } else {
                sb2.append("]");
                return sb2.toString();
            }
        }
    }
}
