package t9;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import la.g;
import la.v;
import ma.q;
import ma.z;
import p9.d;
import p9.k;
import p9.s;
import p9.x;
import q9.e;
import q9.h;
import s9.b;
import u9.c;
import u9.f;
import xa.j;
import y9.l;
import z5.i;

public final class a implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final int f14829h = UUID.randomUUID().hashCode();

    /* renamed from: i  reason: collision with root package name */
    public final LinkedHashSet f14830i = new LinkedHashSet();

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f14831j;

    /* renamed from: k  reason: collision with root package name */
    public final String f14832k;

    /* renamed from: l  reason: collision with root package name */
    public final h f14833l;

    /* renamed from: m  reason: collision with root package name */
    public final b f14834m;

    /* renamed from: n  reason: collision with root package name */
    public final c f14835n;

    /* renamed from: o  reason: collision with root package name */
    public final l f14836o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f14837p;

    /* renamed from: q  reason: collision with root package name */
    public final i f14838q;

    /* renamed from: r  reason: collision with root package name */
    public final Handler f14839r;

    /* renamed from: s  reason: collision with root package name */
    public final y9.b f14840s;

    /* renamed from: t  reason: collision with root package name */
    public final s f14841t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f14842u;

    public a(String str, h hVar, b bVar, c cVar, l lVar, boolean z10, y9.h hVar2, k kVar, i iVar, Handler handler, y9.b bVar2, l.h hVar3, s sVar, boolean z11) {
        j.g("namespace", str);
        j.g("fetchDatabaseManagerWrapper", hVar);
        j.g("logger", lVar);
        j.g("httpDownloader", hVar2);
        j.g("fileServerDownloader", kVar);
        j.g("listenerCoordinator", iVar);
        j.g("uiHandler", handler);
        j.g("storageResolver", bVar2);
        j.g("groupInfoProvider", hVar3);
        j.g("prioritySort", sVar);
        this.f14832k = str;
        this.f14833l = hVar;
        this.f14834m = bVar;
        this.f14835n = cVar;
        this.f14836o = lVar;
        this.f14837p = z10;
        this.f14838q = iVar;
        this.f14839r = handler;
        this.f14840s = bVar2;
        this.f14841t = sVar;
        this.f14842u = z11;
    }

    public final ArrayList N(List list) {
        h hVar = this.f14833l;
        ArrayList q10 = z.q(hVar.L0(list));
        ArrayList arrayList = new ArrayList();
        Iterator it = q10.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (!this.f14834m.z(eVar.f13433h)) {
                int ordinal = eVar.f13442q.ordinal();
                boolean z10 = true;
                if (!(ordinal == 1 || ordinal == 3 || ordinal == 9)) {
                    z10 = false;
                }
                if (z10) {
                    eVar.K(x.QUEUED);
                    arrayList.add(eVar);
                }
            }
        }
        hVar.p0(arrayList);
        W();
        return arrayList;
    }

    public final void W() {
        f fVar = (f) this.f14835n;
        synchronized (fVar.f15447h) {
            Intent intent = new Intent("com.tonyodev.fetch2.action.QUEUE_BACKOFF_RESET");
            intent.putExtra("com.tonyodev.fetch2.extra.NAMESPACE", fVar.f15463x);
            fVar.f15462w.sendBroadcast(intent);
            v vVar = v.f9814a;
        }
        if (((f) this.f14835n).f15450k && !this.f14831j) {
            ((f) this.f14835n).w();
        }
        if (((f) this.f14835n).f15449j && !this.f14831j) {
            ((f) this.f14835n).v();
        }
    }

    public final void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = this.f14834m;
            int i10 = ((e) it.next()).f13433h;
            synchronized (bVar.f14394h) {
                bVar.w(i10);
            }
        }
    }

    public final void close() {
        if (!this.f14831j) {
            this.f14831j = true;
            synchronized (this.f14830i) {
                for (p9.l d10 : this.f14830i) {
                    this.f14838q.d(this.f14829h, d10);
                }
                this.f14830i.clear();
                v vVar = v.f9814a;
            }
            ((f) this.f14835n).z();
            ((f) this.f14835n).close();
            this.f14834m.close();
            p pVar = p.f14899d;
            String str = this.f14832k;
            pVar.getClass();
            p.a(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005c, code lost:
        if (r3.exists() != false) goto L_0x0083;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x000c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.util.List r7) {
        /*
            r6 = this;
            r6.c(r7)
            q9.h r0 = r6.f14833l
            r0.f0(r7)
            java.util.Iterator r7 = r7.iterator()
        L_0x000c:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x009d
            java.lang.Object r1 = r7.next()
            q9.e r1 = (q9.e) r1
            p9.x r2 = p9.x.DELETED
            r1.K(r2)
            java.lang.String r2 = r1.f13436k
            y9.b r3 = r6.f14840s
            r3.getClass()
            java.lang.String r4 = "file"
            xa.j.g(r4, r2)
            java.lang.String r5 = "context"
            android.content.Context r3 = r3.f17239a
            xa.j.g(r5, r3)
            boolean r5 = hb.h0.a1(r2)
            if (r5 == 0) goto L_0x007e
            android.net.Uri r2 = android.net.Uri.parse(r2)
            java.lang.String r5 = "uri"
            xa.j.b(r5, r2)
            java.lang.String r5 = r2.getScheme()
            boolean r4 = xa.j.a(r5, r4)
            if (r4 == 0) goto L_0x005f
            java.io.File r3 = new java.io.File
            java.lang.String r2 = r2.getPath()
            r3.<init>(r2)
            boolean r2 = r3.canWrite()
            if (r2 == 0) goto L_0x0092
            boolean r2 = r3.exists()
            if (r2 == 0) goto L_0x0092
            goto L_0x0083
        L_0x005f:
            java.lang.String r4 = r2.getScheme()
            java.lang.String r5 = "content"
            boolean r4 = xa.j.a(r4, r5)
            if (r4 == 0) goto L_0x0092
            boolean r4 = android.provider.DocumentsContract.isDocumentUri(r3, r2)
            android.content.ContentResolver r3 = r3.getContentResolver()
            if (r4 == 0) goto L_0x0079
            android.provider.DocumentsContract.deleteDocument(r3, r2)
            goto L_0x0092
        L_0x0079:
            r4 = 0
            r3.delete(r2, r4, r4)
            goto L_0x0092
        L_0x007e:
            java.io.File r3 = new java.io.File
            r3.<init>(r2)
        L_0x0083:
            boolean r2 = r3.exists()
            if (r2 == 0) goto L_0x0092
            boolean r2 = r3.canWrite()
            if (r2 == 0) goto L_0x0092
            r3.delete()
        L_0x0092:
            t9.o r2 = r0.d()
            if (r2 == 0) goto L_0x000c
            r2.a(r1)
            goto L_0x000c
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.a.e(java.util.List):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final java.util.ArrayList k(java.util.List r8) {
        /*
            r7 = this;
            java.lang.String r0 = "requests"
            xa.j.g(r0, r8)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x000e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x013b
            java.lang.Object r1 = r8.next()
            p9.u r1 = (p9.u) r1
            q9.h r2 = r7.f14833l
            q9.e r2 = r2.P()
            java.lang.String r3 = "$this$toDownloadInfo"
            xa.j.g(r3, r1)
            java.lang.String r3 = "downloadInfo"
            xa.j.g(r3, r2)
            int r3 = r1.f12719r
            r2.f13433h = r3
            java.lang.String r3 = r1.f12720s
            r2.M(r3)
            java.lang.String r3 = r1.f12721t
            r2.G(r3)
            p9.r r3 = r1.f12725k
            r2.J(r3)
            java.util.LinkedHashMap r3 = r1.f12724j
            java.util.Map r3 = ma.j0.g(r3)
            r2.f13439n = r3
            int r3 = r1.f12723i
            r2.f13437l = r3
            p9.p r3 = r1.f12726l
            r2.I(r3)
            p9.x r3 = x9.a.f16792e
            r2.K(r3)
            p9.f r3 = x9.a.f16791d
            r2.D(r3)
            r3 = 0
            r2.f13440o = r3
            java.lang.String r3 = r1.f12727m
            r2.f13446u = r3
            p9.d r3 = r1.f12728n
            r2.C(r3)
            long r3 = r1.f12722h
            r2.f13448w = r3
            boolean r3 = r1.f12729o
            r2.f13449x = r3
            y9.j r3 = r1.f12731q
            r2.F(r3)
            int r3 = r1.f12730p
            r2.f13451z = r3
            r3 = 0
            r2.A = r3
            java.lang.String r4 = r7.f14832k
            r2.H(r4)
            boolean r4 = r7.z(r2)     // Catch:{ Exception -> 0x012c }
            p9.x r5 = r2.f13442q     // Catch:{ Exception -> 0x012c }
            p9.x r6 = p9.x.COMPLETED     // Catch:{ Exception -> 0x012c }
            if (r5 == r6) goto L_0x00e9
            boolean r1 = r1.f12729o     // Catch:{ Exception -> 0x012c }
            if (r1 == 0) goto L_0x008f
            p9.x r1 = p9.x.QUEUED     // Catch:{ Exception -> 0x012c }
            goto L_0x0091
        L_0x008f:
            p9.x r1 = p9.x.ADDED     // Catch:{ Exception -> 0x012c }
        L_0x0091:
            r2.K(r1)     // Catch:{ Exception -> 0x012c }
            if (r4 != 0) goto L_0x00c6
            q9.h r1 = r7.f14833l     // Catch:{ Exception -> 0x012c }
            la.i r1 = r1.i(r2)     // Catch:{ Exception -> 0x012c }
            y9.l r4 = r7.f14836o     // Catch:{ Exception -> 0x012c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r5.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r6 = "Enqueued download "
            r5.append(r6)     // Catch:{ Exception -> 0x012c }
            java.lang.Object r6 = r1.f9799h     // Catch:{ Exception -> 0x012c }
            q9.e r6 = (q9.e) r6     // Catch:{ Exception -> 0x012c }
            r5.append(r6)     // Catch:{ Exception -> 0x012c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x012c }
            r4.a(r5)     // Catch:{ Exception -> 0x012c }
            la.i r4 = new la.i     // Catch:{ Exception -> 0x012c }
            java.lang.Object r1 = r1.f9799h     // Catch:{ Exception -> 0x012c }
            p9.f r5 = p9.f.NONE     // Catch:{ Exception -> 0x012c }
            r4.<init>(r1, r5)     // Catch:{ Exception -> 0x012c }
            r0.add(r4)     // Catch:{ Exception -> 0x012c }
            r7.W()     // Catch:{ Exception -> 0x012c }
            goto L_0x00f3
        L_0x00c6:
            q9.h r1 = r7.f14833l     // Catch:{ Exception -> 0x012c }
            r1.I(r2)     // Catch:{ Exception -> 0x012c }
            y9.l r1 = r7.f14836o     // Catch:{ Exception -> 0x012c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r4.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r5 = "Updated download "
            r4.append(r5)     // Catch:{ Exception -> 0x012c }
            r4.append(r2)     // Catch:{ Exception -> 0x012c }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x012c }
            r1.a(r4)     // Catch:{ Exception -> 0x012c }
            la.i r1 = new la.i     // Catch:{ Exception -> 0x012c }
            p9.f r4 = p9.f.NONE     // Catch:{ Exception -> 0x012c }
            r1.<init>(r2, r4)     // Catch:{ Exception -> 0x012c }
            goto L_0x00f0
        L_0x00e9:
            la.i r1 = new la.i     // Catch:{ Exception -> 0x012c }
            p9.f r4 = p9.f.NONE     // Catch:{ Exception -> 0x012c }
            r1.<init>(r2, r4)     // Catch:{ Exception -> 0x012c }
        L_0x00f0:
            r0.add(r1)     // Catch:{ Exception -> 0x012c }
        L_0x00f3:
            p9.s r1 = r7.f14841t     // Catch:{ Exception -> 0x012c }
            p9.s r4 = p9.s.DESC     // Catch:{ Exception -> 0x012c }
            if (r1 != r4) goto L_0x000e
            s9.b r1 = r7.f14834m     // Catch:{ Exception -> 0x012c }
            boolean r1 = r1.e()     // Catch:{ Exception -> 0x012c }
            if (r1 != 0) goto L_0x000e
            u9.c r1 = r7.f14835n     // Catch:{ Exception -> 0x012c }
            u9.f r1 = (u9.f) r1     // Catch:{ Exception -> 0x012c }
            java.lang.Object r4 = r1.f15447h     // Catch:{ Exception -> 0x012c }
            monitor-enter(r4)     // Catch:{ Exception -> 0x012c }
            int r5 = r1.f15461v     // Catch:{ all -> 0x0129 }
            if (r5 <= 0) goto L_0x0113
            y9.p r5 = r1.f15455p     // Catch:{ all -> 0x0129 }
            androidx.activity.h r6 = r1.f15454o     // Catch:{ all -> 0x0129 }
            r5.e(r6)     // Catch:{ all -> 0x0129 }
        L_0x0113:
            r5 = 1
            r1.f15449j = r5     // Catch:{ all -> 0x0129 }
            r1.f15450k = r3     // Catch:{ all -> 0x0129 }
            s9.b r3 = r1.f15457r     // Catch:{ all -> 0x0129 }
            r3.k()     // Catch:{ all -> 0x0129 }
            y9.l r1 = r1.f15459t     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = "PriorityIterator paused"
            r1.a(r3)     // Catch:{ all -> 0x0129 }
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x0129 }
            monitor-exit(r4)     // Catch:{ Exception -> 0x012c }
            goto L_0x000e
        L_0x0129:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ Exception -> 0x012c }
            throw r1     // Catch:{ Exception -> 0x012c }
        L_0x012c:
            r1 = move-exception
            p9.f r1 = hb.h0.i0(r1)
            la.i r3 = new la.i
            r3.<init>(r2, r1)
            r0.add(r3)
            goto L_0x000e
        L_0x013b:
            r7.W()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.a.k(java.util.List):java.util.ArrayList");
    }

    public final boolean v(boolean z10) {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        j.b("Looper.getMainLooper()", mainLooper);
        if (!j.a(currentThread, mainLooper.getThread())) {
            return this.f14833l.B0(z10) > 0;
        }
        throw new y("blocking_call_on_ui_thread");
    }

    public final ArrayList w(List list) {
        c(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            j.g("download", eVar);
            int ordinal = eVar.f13442q.ordinal();
            boolean z10 = true;
            if (!(ordinal == 1 || ordinal == 2)) {
                z10 = false;
            }
            if (z10) {
                eVar.K(x.PAUSED);
                arrayList.add(eVar);
            }
        }
        this.f14833l.p0(arrayList);
        return arrayList;
    }

    public final boolean z(e eVar) {
        x xVar;
        c(q.b(eVar));
        String str = eVar.f13436k;
        h hVar = this.f14833l;
        e m02 = hVar.m0(str);
        boolean z10 = this.f14842u;
        y9.b bVar = this.f14840s;
        if (m02 != null) {
            c(q.b(m02));
            m02 = hVar.m0(eVar.f13436k);
            String str2 = "";
            l lVar = this.f14836o;
            if (m02 == null || m02.f13442q != x.DOWNLOADING) {
                if (m02 != null) {
                    xVar = m02.f13442q;
                } else {
                    xVar = null;
                }
                if (xVar == x.COMPLETED && eVar.f13447v == d.UPDATE_ACCORDINGLY && !bVar.b(m02.f13436k)) {
                    try {
                        hVar.u(m02);
                    } catch (Exception e10) {
                        String message = e10.getMessage();
                        if (message != null) {
                            str2 = message;
                        }
                        lVar.b(str2, e10);
                    }
                    if (eVar.f13447v != d.INCREMENT_FILE_NAME && z10) {
                        bVar.a(eVar.f13436k, false);
                    }
                    m02 = null;
                }
            } else {
                m02.K(x.QUEUED);
                try {
                    hVar.I(m02);
                } catch (Exception e11) {
                    String message2 = e11.getMessage();
                    if (message2 != null) {
                        str2 = message2;
                    }
                    lVar.b(str2, e11);
                }
            }
        } else if (eVar.f13447v != d.INCREMENT_FILE_NAME && z10) {
            bVar.a(eVar.f13436k, false);
        }
        int ordinal = eVar.f13447v.ordinal();
        if (ordinal == 0) {
            if (m02 != null) {
                e(q.b(m02));
            }
            e(q.b(eVar));
            return false;
        } else if (ordinal == 1) {
            if (z10) {
                bVar.a(eVar.f13436k, true);
            }
            eVar.G(eVar.f13436k);
            String str3 = eVar.f13435j;
            String str4 = eVar.f13436k;
            j.g("url", str3);
            j.g("file", str4);
            eVar.f13433h = str4.hashCode() + (str3.hashCode() * 31);
            return false;
        } else if (ordinal != 2) {
            if (ordinal != 3) {
                throw new g();
            } else if (m02 == null) {
                return false;
            } else {
                eVar.f13440o = m02.f13440o;
                eVar.f13441p = m02.f13441p;
                eVar.D(m02.f13443r);
                eVar.K(m02.f13442q);
                x xVar2 = eVar.f13442q;
                x xVar3 = x.COMPLETED;
                if (xVar2 != xVar3) {
                    eVar.K(x.QUEUED);
                    eVar.D(x9.a.f16791d);
                }
                if (eVar.f13442q == xVar3 && !bVar.b(eVar.f13436k)) {
                    if (z10) {
                        bVar.a(eVar.f13436k, false);
                    }
                    eVar.f13440o = 0;
                    eVar.f13441p = -1;
                    eVar.K(x.QUEUED);
                    eVar.D(x9.a.f16791d);
                }
                return true;
            }
        } else if (m02 == null) {
            return false;
        } else {
            throw new y("request_with_file_path_already_exist");
        }
    }
}
