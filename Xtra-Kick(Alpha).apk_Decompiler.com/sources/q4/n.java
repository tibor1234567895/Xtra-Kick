package q4;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ma.z;

public final class n implements p {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f13343a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    public int f13344b;

    static {
        new l(0);
    }

    public final synchronized void a(int i10) {
        if (i10 >= 10 && i10 != 20) {
            d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized q4.e b(q4.d r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.LinkedHashMap r0 = r6.f13343a     // Catch:{ all -> 0x0044 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0044 }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x0044 }
            r0 = 0
            if (r7 != 0) goto L_0x000e
            monitor-exit(r6)
            return r0
        L_0x000e:
            int r1 = r7.size()     // Catch:{ all -> 0x0044 }
            r2 = 0
        L_0x0013:
            if (r2 >= r1) goto L_0x0035
            java.lang.Object r3 = r7.get(r2)     // Catch:{ all -> 0x0044 }
            q4.m r3 = (q4.m) r3     // Catch:{ all -> 0x0044 }
            java.lang.ref.WeakReference r4 = r3.f13340b     // Catch:{ all -> 0x0044 }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x0044 }
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ all -> 0x0044 }
            if (r4 == 0) goto L_0x002d
            q4.e r5 = new q4.e     // Catch:{ all -> 0x0044 }
            java.util.Map r3 = r3.f13341c     // Catch:{ all -> 0x0044 }
            r5.<init>(r4, r3)     // Catch:{ all -> 0x0044 }
            goto L_0x002e
        L_0x002d:
            r5 = r0
        L_0x002e:
            if (r5 == 0) goto L_0x0032
            r0 = r5
            goto L_0x0035
        L_0x0032:
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0035:
            int r7 = r6.f13344b     // Catch:{ all -> 0x0044 }
            int r1 = r7 + 1
            r6.f13344b = r1     // Catch:{ all -> 0x0044 }
            r1 = 10
            if (r7 < r1) goto L_0x0042
            r6.d()     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r6)
            return r0
        L_0x0044:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.n.b(q4.d):q4.e");
    }

    public final synchronized void c(d dVar, Bitmap bitmap, Map map, int i10) {
        LinkedHashMap linkedHashMap = this.f13343a;
        Object obj = linkedHashMap.get(dVar);
        if (obj == null) {
            obj = new ArrayList();
            linkedHashMap.put(dVar, obj);
        }
        ArrayList arrayList = (ArrayList) obj;
        int identityHashCode = System.identityHashCode(bitmap);
        m mVar = new m(identityHashCode, new WeakReference(bitmap), map, i10);
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                arrayList.add(mVar);
                break;
            }
            m mVar2 = (m) arrayList.get(i11);
            if (i10 < mVar2.f13342d) {
                i11++;
            } else if (mVar2.f13339a == identityHashCode && mVar2.f13340b.get() == bitmap) {
                arrayList.set(i11, mVar);
            } else {
                arrayList.add(i11, mVar);
            }
        }
        int i12 = this.f13344b;
        this.f13344b = i12 + 1;
        if (i12 >= 10) {
            d();
        }
    }

    public final void d() {
        boolean z10;
        Bitmap bitmap;
        WeakReference weakReference;
        this.f13344b = 0;
        Iterator it = this.f13343a.values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                m mVar = (m) z.u(arrayList);
                if (mVar == null || (weakReference = mVar.f13340b) == null) {
                    bitmap = null;
                } else {
                    bitmap = (Bitmap) weakReference.get();
                }
                if (bitmap != null) {
                }
            } else {
                int size = arrayList.size();
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    int i12 = i11 - i10;
                    if (((m) arrayList.get(i12)).f13340b.get() == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        arrayList.remove(i12);
                        i10++;
                    }
                }
                if (!arrayList.isEmpty()) {
                }
            }
            it.remove();
        }
    }
}
