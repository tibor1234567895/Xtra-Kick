package j1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class i implements Iterable {

    /* renamed from: h  reason: collision with root package name */
    public final Object f8439h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public final HashMap f8440i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public Set f8441j = Collections.emptySet();

    /* renamed from: k  reason: collision with root package name */
    public List f8442k = Collections.emptyList();

    public final int a(Object obj) {
        int intValue;
        synchronized (this.f8439h) {
            intValue = this.f8440i.containsKey(obj) ? ((Integer) this.f8440i.get(obj)).intValue() : 0;
        }
        return intValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f8439h
            monitor-enter(r0)
            java.util.HashMap r1 = r4.f8440i     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x000f:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x004c }
            java.util.List r3 = r4.f8442k     // Catch:{ all -> 0x004c }
            r2.<init>(r3)     // Catch:{ all -> 0x004c }
            r2.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)     // Catch:{ all -> 0x004c }
            r4.f8442k = r2     // Catch:{ all -> 0x004c }
            int r2 = r1.intValue()     // Catch:{ all -> 0x004c }
            r3 = 1
            if (r2 != r3) goto L_0x003c
            java.util.HashMap r1 = r4.f8440i     // Catch:{ all -> 0x004c }
            r1.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x004c }
            java.util.Set r2 = r4.f8441j     // Catch:{ all -> 0x004c }
            r1.<init>(r2)     // Catch:{ all -> 0x004c }
            r1.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.Set r5 = java.util.Collections.unmodifiableSet(r1)     // Catch:{ all -> 0x004c }
            r4.f8441j = r5     // Catch:{ all -> 0x004c }
            goto L_0x004a
        L_0x003c:
            java.util.HashMap r2 = r4.f8440i     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            int r1 = r1 - r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x004c }
            r2.put(r5, r1)     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.i.b(java.lang.Object):void");
    }

    public final Iterator iterator() {
        Iterator it;
        synchronized (this.f8439h) {
            it = this.f8442k.iterator();
        }
        return it;
    }
}
