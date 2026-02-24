package q;

import java.util.LinkedHashMap;
import java.util.Locale;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f13070a;

    /* renamed from: b  reason: collision with root package name */
    public int f13071b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13072c;

    /* renamed from: d  reason: collision with root package name */
    public int f13073d;

    /* renamed from: e  reason: collision with root package name */
    public int f13074e;

    public j(int i10) {
        if (i10 > 0) {
            this.f13072c = i10;
            this.f13070a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public void a(Object obj, Object obj2, Object obj3) {
    }

    public final Object b(Object obj) {
        if (obj != null) {
            synchronized (this) {
                Object obj2 = this.f13070a.get(obj);
                if (obj2 != null) {
                    this.f13073d++;
                    return obj2;
                }
                this.f13074e++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final Object c(Object obj, Object obj2) {
        Object put;
        if (obj != null) {
            synchronized (this) {
                this.f13071b += e(obj, obj2);
                put = this.f13070a.put(obj, obj2);
                if (put != null) {
                    this.f13071b -= e(obj, put);
                }
            }
            if (put != null) {
                a(obj, put, obj2);
            }
            g(this.f13072c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final void d(Object obj) {
        Object remove;
        synchronized (this) {
            remove = this.f13070a.remove(obj);
            if (remove != null) {
                this.f13071b -= e(obj, remove);
            }
        }
        if (remove != null) {
            a(obj, remove, (Object) null);
        }
    }

    public final int e(Object obj, Object obj2) {
        int f10 = f(obj, obj2);
        if (f10 >= 0) {
            return f10;
        }
        throw new IllegalStateException("Negative size: " + obj + Constants.ATTRIBUTE_SEPARATOR + obj2);
    }

    public int f(Object obj, Object obj2) {
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(int r5) {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            int r0 = r4.f13071b     // Catch:{ all -> 0x006b }
            if (r0 < 0) goto L_0x004c
            java.util.LinkedHashMap r0 = r4.f13070a     // Catch:{ all -> 0x006b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0011
            int r0 = r4.f13071b     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x004c
        L_0x0011:
            int r0 = r4.f13071b     // Catch:{ all -> 0x006b }
            if (r0 <= r5) goto L_0x004a
            java.util.LinkedHashMap r0 = r4.f13070a     // Catch:{ all -> 0x006b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x001e
            goto L_0x004a
        L_0x001e:
            java.util.LinkedHashMap r0 = r4.f13070a     // Catch:{ all -> 0x006b }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x006b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x006b }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x006b }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x006b }
            java.util.LinkedHashMap r2 = r4.f13070a     // Catch:{ all -> 0x006b }
            r2.remove(r1)     // Catch:{ all -> 0x006b }
            int r2 = r4.f13071b     // Catch:{ all -> 0x006b }
            int r3 = r4.e(r1, r0)     // Catch:{ all -> 0x006b }
            int r2 = r2 - r3
            r4.f13071b = r2     // Catch:{ all -> 0x006b }
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            r2 = 0
            r4.a(r1, r0, r2)
            goto L_0x0000
        L_0x004a:
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            return
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r0.<init>()     // Catch:{ all -> 0x006b }
            java.lang.Class r1 = r4.getClass()     // Catch:{ all -> 0x006b }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x006b }
            r0.append(r1)     // Catch:{ all -> 0x006b }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x006b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006b }
            r5.<init>(r0)     // Catch:{ all -> 0x006b }
            throw r5     // Catch:{ all -> 0x006b }
        L_0x006b:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q.j.g(int):void");
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        i10 = this.f13073d;
        i11 = this.f13074e + i10;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f13072c), Integer.valueOf(this.f13073d), Integer.valueOf(this.f13074e), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0)});
    }
}
