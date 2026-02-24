package j1;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import g.g0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import jb.a;
import kb.i;
import pa.k;
import v1.r;
import v1.w;

public final class z {

    /* renamed from: e  reason: collision with root package name */
    public static z f8482e;

    /* renamed from: a  reason: collision with root package name */
    public int f8483a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f8484b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f8485c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f8486d;

    public z(int i10, String str, ArrayList arrayList, byte[] bArr) {
        this.f8483a = i10;
        this.f8484b = str;
        this.f8485c = arrayList == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList);
        this.f8486d = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.hasNext() == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r1 = (java.lang.ref.WeakReference) r0.next();
        r2 = (a2.f) r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r2 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r2.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        ((java.util.concurrent.CopyOnWriteArrayList) r4.f8485c).remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r0 = ((java.util.concurrent.CopyOnWriteArrayList) r4.f8485c).iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r3, j1.z r4) {
        /*
            java.lang.Object r0 = r4.f8486d
            monitor-enter(r0)
            int r1 = r4.f8483a     // Catch:{ all -> 0x0035 }
            if (r1 != r3) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            goto L_0x0034
        L_0x0009:
            r4.f8483a = r3     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            java.lang.Object r0 = r4.f8485c
            java.util.concurrent.CopyOnWriteArrayList r0 = (java.util.concurrent.CopyOnWriteArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            a2.f r2 = (a2.f) r2
            if (r2 == 0) goto L_0x002c
            r2.a(r3)
            goto L_0x0014
        L_0x002c:
            java.lang.Object r2 = r4.f8485c
            java.util.concurrent.CopyOnWriteArrayList r2 = (java.util.concurrent.CopyOnWriteArrayList) r2
            r2.remove(r1)
            goto L_0x0014
        L_0x0034:
            return
        L_0x0035:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.z.a(int, j1.z):void");
    }

    public static synchronized z b(Context context) {
        z zVar;
        synchronized (z.class) {
            if (f8482e == null) {
                f8482e = new z(context);
            }
            zVar = f8482e;
        }
        return zVar;
    }

    public final int c() {
        int i10;
        synchronized (this.f8486d) {
            i10 = this.f8483a;
        }
        return i10;
    }

    public z(int i10, k kVar, a aVar, i iVar) {
        this.f8484b = iVar;
        this.f8483a = i10;
        this.f8485c = aVar;
        this.f8486d = kVar;
    }

    public z(Context context) {
        this.f8484b = new Handler(Looper.getMainLooper());
        this.f8485c = new CopyOnWriteArrayList();
        this.f8486d = new Object();
        this.f8483a = 0;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new g0(this), intentFilter);
    }

    public z(r rVar, w wVar, IOException iOException, int i10) {
        this.f8484b = rVar;
        this.f8485c = wVar;
        this.f8486d = iOException;
        this.f8483a = i10;
    }
}
