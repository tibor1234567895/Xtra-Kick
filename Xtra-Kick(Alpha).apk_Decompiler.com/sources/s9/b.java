package s9;

import android.content.Context;
import androidx.fragment.app.y;
import hb.h0;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l.h;
import la.v;
import ma.z;
import p9.k;
import q9.e;
import w9.a;
import xa.j;
import y9.g;
import y9.l;
import z5.i;

public final class b implements Closeable {
    public final h A;
    public final int B;
    public final boolean C;

    /* renamed from: h  reason: collision with root package name */
    public final Object f14394h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f14395i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f14396j;

    /* renamed from: k  reason: collision with root package name */
    public final HashMap f14397k;

    /* renamed from: l  reason: collision with root package name */
    public volatile int f14398l;

    /* renamed from: m  reason: collision with root package name */
    public volatile boolean f14399m;

    /* renamed from: n  reason: collision with root package name */
    public final y9.h f14400n;

    /* renamed from: o  reason: collision with root package name */
    public final long f14401o;

    /* renamed from: p  reason: collision with root package name */
    public final l f14402p;

    /* renamed from: q  reason: collision with root package name */
    public final a f14403q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f14404r;

    /* renamed from: s  reason: collision with root package name */
    public final u9.a f14405s;

    /* renamed from: t  reason: collision with root package name */
    public final a f14406t;

    /* renamed from: u  reason: collision with root package name */
    public final i f14407u;

    /* renamed from: v  reason: collision with root package name */
    public final k f14408v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f14409w = false;

    /* renamed from: x  reason: collision with root package name */
    public final y9.b f14410x;

    /* renamed from: y  reason: collision with root package name */
    public final Context f14411y;

    /* renamed from: z  reason: collision with root package name */
    public final String f14412z;

    public b(y9.h hVar, int i10, long j10, l lVar, a aVar, boolean z10, u9.a aVar2, a aVar3, i iVar, k kVar, y9.b bVar, Context context, String str, h hVar2, int i11, boolean z11) {
        int i12 = i10;
        l lVar2 = lVar;
        a aVar4 = aVar3;
        i iVar2 = iVar;
        k kVar2 = kVar;
        y9.b bVar2 = bVar;
        Context context2 = context;
        String str2 = str;
        h hVar3 = hVar2;
        j.g("httpDownloader", hVar);
        j.g("logger", lVar2);
        j.g("downloadManagerCoordinator", aVar4);
        j.g("listenerCoordinator", iVar2);
        j.g("fileServerDownloader", kVar2);
        j.g("storageResolver", bVar2);
        j.g("context", context2);
        j.g("namespace", str2);
        j.g("groupInfoProvider", hVar3);
        this.f14400n = hVar;
        this.f14401o = j10;
        this.f14402p = lVar2;
        this.f14403q = aVar;
        this.f14404r = z10;
        this.f14405s = aVar2;
        this.f14406t = aVar4;
        this.f14407u = iVar2;
        this.f14408v = kVar2;
        this.f14410x = bVar2;
        this.f14411y = context2;
        this.f14412z = str2;
        this.A = hVar3;
        this.B = i11;
        this.C = z11;
        this.f14394h = new Object();
        this.f14395i = i12 > 0 ? Executors.newFixedThreadPool(i10) : null;
        this.f14396j = i12;
        this.f14397k = new HashMap();
    }

    public static final void c(b bVar, p9.b bVar2) {
        synchronized (bVar.f14394h) {
            if (bVar.f14397k.containsKey(Integer.valueOf(((e) bVar2).f13433h))) {
                bVar.f14397k.remove(Integer.valueOf(((e) bVar2).f13433h));
                bVar.f14398l--;
            }
            bVar.f14406t.d(((e) bVar2).f13433h);
            v vVar = v.f9814a;
        }
    }

    public final c N(p9.b bVar, y9.h hVar) {
        y9.h hVar2 = hVar;
        p9.b bVar2 = bVar;
        g E0 = h0.E0(bVar, "GET");
        hVar2.C(E0);
        if (hVar2.k0(E0, hVar2.J0(E0)) == y9.e.SEQUENTIAL) {
            return new g(bVar, hVar, this.f14401o, this.f14402p, this.f14403q, this.f14404r, this.f14409w, this.f14410x, this.C);
        }
        long j10 = this.f14401o;
        l lVar = this.f14402p;
        a aVar = this.f14403q;
        boolean z10 = this.f14404r;
        y9.b bVar3 = this.f14410x;
        return new e(bVar, hVar, j10, lVar, aVar, z10, bVar3.f17240b, this.f14409w, bVar3, this.C);
    }

    public final c W(p9.b bVar) {
        y9.h hVar;
        j.g("download", bVar);
        if (!h0.U0(((e) bVar).f13435j)) {
            hVar = this.f14400n;
        } else {
            hVar = this.f14408v;
        }
        return N(bVar, hVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y(p9.b r7) {
        /*
            r6 = this;
            java.lang.String r0 = " because the download queue is full"
            java.lang.String r1 = "DownloadManager cannot init download "
            java.lang.String r2 = "DownloadManager already running download "
            java.lang.Object r3 = r6.f14394h
            monitor-enter(r3)
            boolean r4 = r6.f14399m     // Catch:{ all -> 0x0084 }
            if (r4 != 0) goto L_0x0086
            java.util.HashMap r4 = r6.f14397k     // Catch:{ all -> 0x0084 }
            r5 = r7
            q9.e r5 = (q9.e) r5     // Catch:{ all -> 0x0084 }
            int r5 = r5.f13433h     // Catch:{ all -> 0x0084 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0084 }
            boolean r4 = r4.containsKey(r5)     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x0031
            y9.l r0 = r6.f14402p     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r1.<init>(r2)     // Catch:{ all -> 0x0084 }
            r1.append(r7)     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0084 }
            r0.a(r7)     // Catch:{ all -> 0x0084 }
            monitor-exit(r3)
            return
        L_0x0031:
            int r2 = r6.f14398l     // Catch:{ all -> 0x0084 }
            int r4 = r6.f14396j     // Catch:{ all -> 0x0084 }
            if (r2 < r4) goto L_0x004d
            y9.l r2 = r6.f14402p     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r4.<init>(r1)     // Catch:{ all -> 0x0084 }
            r4.append(r7)     // Catch:{ all -> 0x0084 }
            r4.append(r0)     // Catch:{ all -> 0x0084 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0084 }
            r2.a(r7)     // Catch:{ all -> 0x0084 }
            monitor-exit(r3)
            return
        L_0x004d:
            int r0 = r6.f14398l     // Catch:{ all -> 0x0084 }
            int r0 = r0 + 1
            r6.f14398l = r0     // Catch:{ all -> 0x0084 }
            java.util.HashMap r0 = r6.f14397k     // Catch:{ all -> 0x0084 }
            r1 = r7
            q9.e r1 = (q9.e) r1     // Catch:{ all -> 0x0084 }
            int r1 = r1.f13433h     // Catch:{ all -> 0x0084 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0084 }
            r2 = 0
            r0.put(r1, r2)     // Catch:{ all -> 0x0084 }
            s9.a r0 = r6.f14406t     // Catch:{ all -> 0x0084 }
            r1 = r7
            q9.e r1 = (q9.e) r1     // Catch:{ all -> 0x0084 }
            int r1 = r1.f13433h     // Catch:{ all -> 0x0084 }
            r0.a(r1, r2)     // Catch:{ all -> 0x0084 }
            java.util.concurrent.ExecutorService r0 = r6.f14395i     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0082
            boolean r1 = r0.isShutdown()     // Catch:{ all -> 0x0084 }
            if (r1 != 0) goto L_0x0082
            android.support.v4.media.j r1 = new android.support.v4.media.j     // Catch:{ all -> 0x0084 }
            r2 = 9
            r1.<init>((java.lang.Object) r6, (java.lang.Object) r7, (int) r2)     // Catch:{ all -> 0x0084 }
            r0.execute(r1)     // Catch:{ all -> 0x0084 }
            monitor-exit(r3)
            return
        L_0x0082:
            monitor-exit(r3)
            return
        L_0x0084:
            r7 = move-exception
            goto L_0x008e
        L_0x0086:
            androidx.fragment.app.y r7 = new androidx.fragment.app.y     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = "DownloadManager is already shutdown."
            r7.<init>((java.lang.String) r0)     // Catch:{ all -> 0x0084 }
            throw r7     // Catch:{ all -> 0x0084 }
        L_0x008e:
            monitor-exit(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.b.Y(p9.b):void");
    }

    public final void Z() {
        for (Map.Entry entry : this.f14397k.entrySet()) {
            c cVar = (c) entry.getValue();
            if (cVar != null) {
                cVar.Y();
                l lVar = this.f14402p;
                lVar.a("DownloadManager terminated download " + cVar.Z());
                this.f14406t.d(((Number) entry.getKey()).intValue());
            }
        }
        this.f14397k.clear();
        this.f14398l = 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1 = la.v.f9814a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f14394h
            monitor-enter(r0)
            boolean r1 = r3.f14399m     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            r1 = 1
            r3.f14399m = r1     // Catch:{ all -> 0x0028 }
            int r1 = r3.f14396j     // Catch:{ all -> 0x0028 }
            if (r1 <= 0) goto L_0x0013
            r3.Z()     // Catch:{ all -> 0x0028 }
        L_0x0013:
            y9.l r1 = r3.f14402p     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "DownloadManager closing download manager"
            r1.a(r2)     // Catch:{ all -> 0x0028 }
            java.util.concurrent.ExecutorService r1 = r3.f14395i     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x0026
            r1.shutdown()     // Catch:{ Exception -> 0x0024 }
            la.v r1 = la.v.f9814a     // Catch:{ Exception -> 0x0024 }
            goto L_0x0026
        L_0x0024:
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r0)
            return
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.b.close():void");
    }

    public final boolean e() {
        boolean z10;
        synchronized (this.f14394h) {
            if (this.f14399m || this.f14398l >= this.f14396j) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public final void k() {
        synchronized (this.f14394h) {
            if (!this.f14399m) {
                v();
                v vVar = v.f9814a;
            } else {
                throw new y("DownloadManager is already shutdown.");
            }
        }
    }

    public final void v() {
        List<c> J;
        if (this.f14396j > 0) {
            a aVar = this.f14406t;
            synchronized (aVar.f14391a) {
                J = z.J(((Map) aVar.f14392b).values());
            }
            for (c cVar : J) {
                if (cVar != null) {
                    cVar.v();
                    this.f14406t.d(cVar.Z().f13433h);
                    l lVar = this.f14402p;
                    lVar.a("DownloadManager cancelled download " + cVar.Z());
                }
            }
        }
        this.f14397k.clear();
        this.f14398l = 0;
    }

    public final boolean w(int i10) {
        if (!this.f14399m) {
            c cVar = (c) this.f14397k.get(Integer.valueOf(i10));
            if (cVar != null) {
                cVar.v();
                this.f14397k.remove(Integer.valueOf(i10));
                this.f14398l--;
                this.f14406t.d(i10);
                this.f14402p.a("DownloadManager cancelled download " + cVar.Z());
                return cVar.H0();
            }
            a aVar = this.f14406t;
            synchronized (aVar.f14391a) {
                c cVar2 = (c) ((Map) aVar.f14392b).get(Integer.valueOf(i10));
                if (cVar2 != null) {
                    cVar2.v();
                    ((Map) aVar.f14392b).remove(Integer.valueOf(i10));
                }
                v vVar = v.f9814a;
            }
            return false;
        }
        throw new y("DownloadManager is already shutdown.");
    }

    public final boolean z(int i10) {
        boolean z10;
        synchronized (this.f14394h) {
            if (this.f14399m || !this.f14406t.c(i10)) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }
}
