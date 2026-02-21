package w2;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import l1.e;
import l1.h;
import l1.i;
import l1.j;
import y1.a;

public abstract class c implements e, e {

    /* renamed from: a  reason: collision with root package name */
    public final j f16041a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f16042b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque f16043c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayDeque f16044d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    public final h[] f16045e = new h[2];

    /* renamed from: f  reason: collision with root package name */
    public final i[] f16046f;

    /* renamed from: g  reason: collision with root package name */
    public int f16047g = 2;

    /* renamed from: h  reason: collision with root package name */
    public int f16048h;

    /* renamed from: i  reason: collision with root package name */
    public h f16049i;

    /* renamed from: j  reason: collision with root package name */
    public f f16050j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16051k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f16052l;

    public c() {
        boolean z10;
        i[] iVarArr = new i[2];
        for (int i10 = 0; i10 < this.f16047g; i10++) {
            this.f16045e[i10] = new h();
        }
        this.f16046f = iVarArr;
        this.f16048h = 2;
        int i11 = 0;
        while (true) {
            z10 = true;
            if (i11 >= this.f16048h) {
                break;
            }
            this.f16046f[i11] = new a(this, 1);
            i11++;
        }
        j jVar = new j(this);
        this.f16041a = jVar;
        jVar.start();
        int i12 = this.f16047g;
        h[] hVarArr = this.f16045e;
        j1.a.e(i12 != hVarArr.length ? false : z10);
        for (h j10 : hVarArr) {
            j10.j(1024);
        }
    }

    public final void a() {
        synchronized (this.f16042b) {
            this.f16052l = true;
            this.f16042b.notify();
        }
        try {
            this.f16041a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void b(long j10) {
    }

    public final void c(h hVar) {
        boolean z10;
        synchronized (this.f16042b) {
            try {
                f fVar = this.f16050j;
                if (fVar == null) {
                    boolean z11 = true;
                    if (hVar == this.f16049i) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    j1.a.b(z10);
                    this.f16043c.addLast(hVar);
                    if (this.f16043c.isEmpty() || this.f16048h <= 0) {
                        z11 = false;
                    }
                    if (z11) {
                        this.f16042b.notify();
                    }
                    this.f16049i = null;
                } else {
                    throw fVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object d() {
        synchronized (this.f16042b) {
            try {
                f fVar = this.f16050j;
                if (fVar != null) {
                    throw fVar;
                } else if (this.f16044d.isEmpty()) {
                    return null;
                } else {
                    i iVar = (i) this.f16044d.removeFirst();
                    return iVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object e() {
        boolean z10;
        h hVar;
        synchronized (this.f16042b) {
            try {
                f fVar = this.f16050j;
                if (fVar == null) {
                    if (this.f16049i == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    j1.a.e(z10);
                    int i10 = this.f16047g;
                    if (i10 == 0) {
                        hVar = null;
                    } else {
                        h[] hVarArr = this.f16045e;
                        int i11 = i10 - 1;
                        this.f16047g = i11;
                        hVar = hVarArr[i11];
                    }
                    this.f16049i = hVar;
                } else {
                    throw fVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public abstract d f(byte[] bArr, int i10, boolean z10);

    public final void flush() {
        synchronized (this.f16042b) {
            this.f16051k = true;
            h hVar = this.f16049i;
            if (hVar != null) {
                hVar.h();
                int i10 = this.f16047g;
                this.f16047g = i10 + 1;
                this.f16045e[i10] = hVar;
                this.f16049i = null;
            }
            while (!this.f16043c.isEmpty()) {
                h hVar2 = (h) this.f16043c.removeFirst();
                hVar2.h();
                int i11 = this.f16047g;
                this.f16047g = i11 + 1;
                this.f16045e[i11] = hVar2;
            }
            while (!this.f16044d.isEmpty()) {
                ((i) this.f16044d.removeFirst()).h();
            }
        }
    }

    public final f g(h hVar, i iVar, boolean z10) {
        h hVar2 = (h) hVar;
        i iVar2 = (i) iVar;
        try {
            ByteBuffer byteBuffer = hVar2.f9515j;
            byteBuffer.getClass();
            iVar2.i(hVar2.f9517l, f(byteBuffer.array(), byteBuffer.limit(), z10), hVar2.f16064p);
            iVar2.f9501h &= Integer.MAX_VALUE;
            return null;
        } catch (f e10) {
            return e10;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (r1.f(4) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        r4.e(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        if (r1.g() == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
        r4.e(androidx.recyclerview.widget.RecyclerView.UNDEFINED_DURATION);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        if (r1.f(134217728) == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        r4.e(134217728);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0 = g(r1, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        r0 = new w2.f("Unexpected decode error", r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f16042b
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r7.f16052l     // Catch:{ all -> 0x0017 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0023
            java.util.ArrayDeque r1 = r7.f16043c     // Catch:{ all -> 0x0017 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x001a
            int r1 = r7.f16048h     // Catch:{ all -> 0x0017 }
            if (r1 <= 0) goto L_0x001a
            r1 = 1
            goto L_0x001b
        L_0x0017:
            r1 = move-exception
            goto L_0x00a7
        L_0x001a:
            r1 = 0
        L_0x001b:
            if (r1 != 0) goto L_0x0023
            java.lang.Object r1 = r7.f16042b     // Catch:{ all -> 0x0017 }
            r1.wait()     // Catch:{ all -> 0x0017 }
            goto L_0x0003
        L_0x0023:
            boolean r1 = r7.f16052l     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            goto L_0x00a3
        L_0x002a:
            java.util.ArrayDeque r1 = r7.f16043c     // Catch:{ all -> 0x0017 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0017 }
            l1.h r1 = (l1.h) r1     // Catch:{ all -> 0x0017 }
            l1.i[] r4 = r7.f16046f     // Catch:{ all -> 0x0017 }
            int r5 = r7.f16048h     // Catch:{ all -> 0x0017 }
            int r5 = r5 - r3
            r7.f16048h = r5     // Catch:{ all -> 0x0017 }
            r4 = r4[r5]     // Catch:{ all -> 0x0017 }
            boolean r5 = r7.f16051k     // Catch:{ all -> 0x0017 }
            r7.f16051k = r2     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            r0 = 4
            boolean r6 = r1.f(r0)
            if (r6 == 0) goto L_0x004b
            r4.e(r0)
            goto L_0x007d
        L_0x004b:
            boolean r0 = r1.g()
            if (r0 == 0) goto L_0x0056
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r4.e(r0)
        L_0x0056:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            boolean r6 = r1.f(r0)
            if (r6 == 0) goto L_0x0061
            r4.e(r0)
        L_0x0061:
            w2.f r0 = r7.g(r1, r4, r5)     // Catch:{ RuntimeException -> 0x0068, OutOfMemoryError -> 0x0066 }
            goto L_0x0071
        L_0x0066:
            r0 = move-exception
            goto L_0x0069
        L_0x0068:
            r0 = move-exception
        L_0x0069:
            w2.f r5 = new w2.f
            java.lang.String r6 = "Unexpected decode error"
            r5.<init>(r6, r0)
            r0 = r5
        L_0x0071:
            if (r0 == 0) goto L_0x007d
            java.lang.Object r5 = r7.f16042b
            monitor-enter(r5)
            r7.f16050j = r0     // Catch:{ all -> 0x007a }
            monitor-exit(r5)     // Catch:{ all -> 0x007a }
            goto L_0x00a3
        L_0x007a:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007a }
            throw r0
        L_0x007d:
            java.lang.Object r2 = r7.f16042b
            monitor-enter(r2)
            boolean r0 = r7.f16051k     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x0085
            goto L_0x008b
        L_0x0085:
            boolean r0 = r4.g()     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x008f
        L_0x008b:
            r4.h()     // Catch:{ all -> 0x00a4 }
            goto L_0x0094
        L_0x008f:
            java.util.ArrayDeque r0 = r7.f16044d     // Catch:{ all -> 0x00a4 }
            r0.addLast(r4)     // Catch:{ all -> 0x00a4 }
        L_0x0094:
            r1.h()     // Catch:{ all -> 0x00a4 }
            int r0 = r7.f16047g     // Catch:{ all -> 0x00a4 }
            int r4 = r0 + 1
            r7.f16047g = r4     // Catch:{ all -> 0x00a4 }
            l1.h[] r4 = r7.f16045e     // Catch:{ all -> 0x00a4 }
            r4[r0] = r1     // Catch:{ all -> 0x00a4 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a4 }
            r2 = 1
        L_0x00a3:
            return r2
        L_0x00a4:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a4 }
            throw r0
        L_0x00a7:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.c.h():boolean");
    }
}
