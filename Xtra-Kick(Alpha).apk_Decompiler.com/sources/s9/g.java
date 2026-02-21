package s9;

import android.net.Uri;
import androidx.fragment.app.y;
import hb.h0;
import java.io.BufferedInputStream;
import java.util.LinkedHashMap;
import la.f;
import la.o;
import ma.j0;
import q9.e;
import xa.j;
import y9.a;
import y9.b;
import y9.d;
import y9.h;
import y9.l;
import y9.t;

public final class g implements c {
    public final boolean A;
    public final b B;
    public final boolean C;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f14436h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f14437i;

    /* renamed from: j  reason: collision with root package name */
    public u9.b f14438j;

    /* renamed from: k  reason: collision with root package name */
    public volatile long f14439k = -1;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f14440l;

    /* renamed from: m  reason: collision with root package name */
    public volatile long f14441m;

    /* renamed from: n  reason: collision with root package name */
    public long f14442n = -1;

    /* renamed from: o  reason: collision with root package name */
    public final o f14443o = f.b(new f(this, 1));

    /* renamed from: p  reason: collision with root package name */
    public double f14444p;

    /* renamed from: q  reason: collision with root package name */
    public final a f14445q = new a(5);

    /* renamed from: r  reason: collision with root package name */
    public final d f14446r = ((d) new f(this, 0).b());

    /* renamed from: s  reason: collision with root package name */
    public final int f14447s = 1;

    /* renamed from: t  reason: collision with root package name */
    public final d f14448t = new d(1, this);

    /* renamed from: u  reason: collision with root package name */
    public final p9.b f14449u;

    /* renamed from: v  reason: collision with root package name */
    public final h f14450v;

    /* renamed from: w  reason: collision with root package name */
    public final long f14451w;

    /* renamed from: x  reason: collision with root package name */
    public final l f14452x;

    /* renamed from: y  reason: collision with root package name */
    public final w9.a f14453y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f14454z;

    public g(p9.b bVar, h hVar, long j10, l lVar, w9.a aVar, boolean z10, boolean z11, b bVar2, boolean z12) {
        j.g("initialDownload", bVar);
        j.g("downloader", hVar);
        j.g("logger", lVar);
        j.g("networkInfoProvider", aVar);
        j.g("storageResolver", bVar2);
        this.f14449u = bVar;
        this.f14450v = hVar;
        this.f14451w = j10;
        this.f14452x = lVar;
        this.f14453y = aVar;
        this.f14454z = z10;
        this.A = z11;
        this.B = bVar2;
        this.C = z12;
    }

    public final boolean H0() {
        return this.f14436h;
    }

    public final void Y() {
        u9.b bVar = this.f14438j;
        if (!(bVar instanceof u9.b)) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f15441a = true;
        }
        this.f14437i = true;
    }

    public final e Z() {
        b().f13440o = this.f14441m;
        b().f13441p = this.f14439k;
        return b();
    }

    public final long a() {
        double d10 = this.f14444p;
        if (d10 < ((double) 1)) {
            return 0;
        }
        return (long) Math.ceil(d10);
    }

    public final void a0(u9.b bVar) {
        this.f14438j = bVar;
    }

    public final e b() {
        return (e) this.f14443o.getValue();
    }

    public final y9.g c() {
        LinkedHashMap i10 = j0.i(((e) this.f14449u).f13439n);
        i10.put("Range", "bytes=" + this.f14441m + '-');
        e eVar = (e) this.f14449u;
        int i11 = eVar.f13433h;
        String str = eVar.f13435j;
        String str2 = eVar.f13436k;
        Uri o02 = h0.o0(str2);
        e eVar2 = (e) this.f14449u;
        return new y9.g(i11, str, i10, str2, o02, eVar2.f13446u, eVar2.f13448w, "GET", eVar2.f13450y, "", 1);
    }

    public final boolean d() {
        return ((this.f14441m > 0 && this.f14439k > 0) || this.f14440l) && this.f14441m >= this.f14439k;
    }

    public final void e(y9.f fVar) {
        u9.b bVar;
        e eVar;
        if (!this.f14436h && !this.f14437i && d()) {
            this.f14439k = this.f14441m;
            b().f13440o = this.f14441m;
            b().f13441p = this.f14439k;
            this.f14446r.f17245l = this.f14441m;
            this.f14446r.f17244k = this.f14439k;
            if (this.A) {
                if (!this.f14450v.D(fVar.f17253e, fVar.f17254f)) {
                    throw new y("invalid content hash");
                } else if (!this.f14437i && !this.f14436h) {
                    u9.b bVar2 = this.f14438j;
                    if (bVar2 != null) {
                        bVar2.f(b());
                    }
                    u9.b bVar3 = this.f14438j;
                    if (bVar3 != null) {
                        bVar3.b(b(), this.f14446r, this.f14447s);
                    }
                    b().B = this.f14442n;
                    b().C = a();
                    e b10 = b();
                    b10.getClass();
                    eVar = new e();
                    h0.T1(b10, eVar);
                    u9.b bVar4 = this.f14438j;
                    if (bVar4 != null) {
                        bVar4.d(b(), b().B, b().C);
                    }
                    b().B = -1;
                    b().C = -1;
                    bVar = this.f14438j;
                    if (bVar == null) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!this.f14437i && !this.f14436h) {
                u9.b bVar5 = this.f14438j;
                if (bVar5 != null) {
                    bVar5.f(b());
                }
                u9.b bVar6 = this.f14438j;
                if (bVar6 != null) {
                    bVar6.b(b(), this.f14446r, this.f14447s);
                }
                b().B = this.f14442n;
                b().C = a();
                e b11 = b();
                b11.getClass();
                eVar = new e();
                h0.T1(b11, eVar);
                u9.b bVar7 = this.f14438j;
                if (bVar7 != null) {
                    bVar7.d(b(), b().B, b().C);
                }
                b().B = -1;
                b().C = -1;
                bVar = this.f14438j;
                if (bVar == null) {
                    return;
                }
            } else {
                return;
            }
            bVar.a(eVar);
        }
    }

    public final void f(BufferedInputStream bufferedInputStream, t tVar, int i10) {
        int i11 = i10;
        long j10 = this.f14441m;
        byte[] bArr = new byte[i11];
        long nanoTime = System.nanoTime();
        long nanoTime2 = System.nanoTime();
        loop0:
        while (true) {
            int read = bufferedInputStream.read(bArr, 0, i11);
            while (!this.f14436h && !this.f14437i && read != -1) {
                tVar.e(bArr, read);
                if (!this.f14437i && !this.f14436h) {
                    byte[] bArr2 = bArr;
                    this.f14441m += (long) read;
                    b().f13440o = this.f14441m;
                    b().f13441p = this.f14439k;
                    this.f14446r.f17245l = this.f14441m;
                    this.f14446r.f17244k = this.f14439k;
                    boolean M0 = h0.M0(nanoTime2, System.nanoTime(), 1000);
                    if (M0) {
                        this.f14445q.a((double) (this.f14441m - j10));
                        this.f14444p = a.b(this.f14445q);
                        this.f14442n = h0.t(this.f14441m, this.f14439k, a());
                        j10 = this.f14441m;
                    }
                    if (h0.M0(nanoTime, System.nanoTime(), this.f14451w)) {
                        this.f14446r.f17245l = this.f14441m;
                        if (!this.f14437i && !this.f14436h) {
                            u9.b bVar = this.f14438j;
                            if (bVar != null) {
                                bVar.f(b());
                            }
                            u9.b bVar2 = this.f14438j;
                            if (bVar2 != null) {
                                bVar2.b(b(), this.f14446r, this.f14447s);
                            }
                            b().B = this.f14442n;
                            b().C = a();
                            u9.b bVar3 = this.f14438j;
                            if (bVar3 != null) {
                                bVar3.d(b(), b().B, b().C);
                            }
                        }
                        nanoTime = System.nanoTime();
                    }
                    if (M0) {
                        nanoTime2 = System.nanoTime();
                    }
                    bArr = bArr2;
                }
            }
        }
        tVar.flush();
    }

    /* JADX WARNING: Removed duplicated region for block: B:160:0x02bf A[Catch:{ InterruptedException -> 0x02e6, all -> 0x02ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02c6 A[Catch:{ InterruptedException -> 0x02e6, all -> 0x02ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0330 A[Catch:{ InterruptedException -> 0x02e6, all -> 0x02ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0339 A[SYNTHETIC, Splitter:B:189:0x0339] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0346 A[SYNTHETIC, Splitter:B:194:0x0346] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0354 A[SYNTHETIC, Splitter:B:199:0x0354] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0371 A[SYNTHETIC, Splitter:B:213:0x0371] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x037e A[SYNTHETIC, Splitter:B:218:0x037e] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x038c A[SYNTHETIC, Splitter:B:223:0x038c] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080 A[Catch:{ Exception -> 0x0183, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098 A[Catch:{ Exception -> 0x0183, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7 A[Catch:{ Exception -> 0x0183, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00df A[Catch:{ Exception -> 0x0183, all -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014e A[Catch:{ Exception -> 0x0161, all -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168 A[Catch:{ Exception -> 0x0161, all -> 0x015e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "FileDownloader"
            java.lang.String r0 = "FileDownloader resuming Download "
            java.lang.String r3 = "FileDownloader starting Download "
            java.lang.String r4 = "FileDownloader download:"
            r5 = -1
            r7 = 1
            p9.b r9 = r1.f14449u     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            q9.e r9 = (q9.e) r9     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            long r9 = r9.f13440o     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            r1.f14441m = r9     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            p9.b r9 = r1.f14449u     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            q9.e r9 = (q9.e) r9     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            long r9 = r9.f13441p     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            r1.f14439k = r9     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            q9.e r9 = r22.b()     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            long r10 = r1.f14441m     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            r9.f13440o = r10     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            q9.e r9 = r22.b()     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            long r10 = r1.f14439k     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            r9.f13441p = r10     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            boolean r9 = r1.f14436h     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            if (r9 != 0) goto L_0x01db
            boolean r9 = r1.f14437i     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            if (r9 != 0) goto L_0x01db
            y9.g r9 = r22.c()     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            y9.h r10 = r1.f14450v     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            s9.d r11 = r1.f14448t     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            y9.f r10 = r10.B(r9, r11)     // Catch:{ Exception -> 0x0297, all -> 0x0290 }
            if (r10 == 0) goto L_0x004f
            boolean r11 = r10.f17250b     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r11 == 0) goto L_0x004f
            long r11 = r10.f17251c     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x004f
            r1.f14440l = r7     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x004f:
            if (r10 == 0) goto L_0x0054
            boolean r12 = r10.f17250b     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            goto L_0x0055
        L_0x0054:
            r12 = 0
        L_0x0055:
            boolean r13 = r1.f14436h     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r13 != 0) goto L_0x0186
            boolean r13 = r1.f14437i     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r13 != 0) goto L_0x0186
            if (r10 == 0) goto L_0x0186
            if (r12 == 0) goto L_0x0186
            int r12 = r10.f17249a     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r13 = 0
            r15 = 206(0xce, float:2.89E-43)
            if (r12 == r15) goto L_0x0070
            boolean r12 = r10.f17256h     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r12 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r11 = r13
            goto L_0x0076
        L_0x0070:
            p9.b r12 = r1.f14449u     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            q9.e r12 = (q9.e) r12     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            long r11 = r12.f13440o     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x0076:
            r1.f14441m = r11     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            long r11 = r10.f17251c     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r1.f14439k = r11     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            int r11 = r10.f17249a     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r11 != r15) goto L_0x0098
            y9.l r3 = r1.f14452x     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r11.<init>(r0)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            q9.e r0 = r22.Z()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r11.append(r0)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r3.a(r0)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            long r13 = r1.f14441m     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            goto L_0x00ad
        L_0x0098:
            y9.l r0 = r1.f14452x     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r11.<init>(r3)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            q9.e r3 = r22.Z()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r11.append(r3)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = r11.toString()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r0.a(r3)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x00ad:
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            long r11 = r1.f14441m     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r0.f13440o = r11     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            long r11 = r1.f14439k     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r0.f13441p = r11     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            y9.b r0 = r1.B     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = r9.f17259c     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            boolean r0 = r0.b(r3)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 != 0) goto L_0x00db
            y9.b r0 = r1.B     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = r9.f17259c     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            p9.b r11 = r1.f14449u     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            q9.e r11 = (q9.e) r11     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            p9.d r11 = r11.f13447v     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            p9.d r12 = p9.d.INCREMENT_FILE_NAME     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r11 != r12) goto L_0x00d7
            r11 = 1
            goto L_0x00d8
        L_0x00d7:
            r11 = 0
        L_0x00d8:
            r0.a(r3, r11)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x00db:
            boolean r0 = r1.C     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 == 0) goto L_0x00ec
            y9.b r0 = r1.B     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = r9.f17259c     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            q9.e r11 = r22.b()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            long r11 = r11.f13441p     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r0.c(r3, r11)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x00ec:
            y9.b r0 = r1.B     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            android.content.Context r0 = r0.f17239a     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = "context.contentResolver"
            xa.j.b(r3, r0)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = r9.f17259c     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            y9.t r3 = hb.h0.z0(r3, r0)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            r3.c(r13)     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            boolean r0 = r1.f14436h     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            if (r0 != 0) goto L_0x01d4
            boolean r0 = r1.f14437i     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            if (r0 != 0) goto L_0x01d4
            y9.h r0 = r1.f14450v     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            r0.y0(r9)     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            java.io.InputStream r0 = r10.f17252d     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            r11 = 8192(0x2000, float:1.14794E-41)
            r9.<init>(r0, r11)     // Catch:{ Exception -> 0x017c, all -> 0x0178 }
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14441m     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f13440o = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14439k     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f13441p = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            y9.d r0 = r1.f14446r     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14441m     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f17245l = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            y9.d r0 = r1.f14446r     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f17243j = r13     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14439k     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f17244k = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            boolean r0 = r1.f14437i     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 != 0) goto L_0x0173
            boolean r0 = r1.f14436h     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 != 0) goto L_0x0173
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.B = r5     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.C = r5     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            u9.b r0 = r1.f14438j     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 == 0) goto L_0x0164
            q9.e r7 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            y9.d r8 = r1.f14446r     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            java.util.List r8 = ma.q.b(r8)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            int r12 = r1.f14447s     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.e(r7, r8, r12)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            goto L_0x0164
        L_0x015e:
            r0 = move-exception
            goto L_0x028a
        L_0x0161:
            r0 = move-exception
            goto L_0x028d
        L_0x0164:
            u9.b r0 = r1.f14438j     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 == 0) goto L_0x0173
            q9.e r7 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            y9.d r8 = r1.f14446r     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            int r12 = r1.f14447s     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.b(r7, r8, r12)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
        L_0x0173:
            r1.f(r9, r3, r11)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            goto L_0x01de
        L_0x0178:
            r0 = move-exception
            r9 = 0
            goto L_0x028a
        L_0x017c:
            r0 = move-exception
            r7 = r3
            r9 = 0
            goto L_0x028e
        L_0x0181:
            r0 = move-exception
            goto L_0x01d6
        L_0x0183:
            r0 = move-exception
            goto L_0x0299
        L_0x0186:
            if (r10 != 0) goto L_0x019f
            boolean r0 = r1.f14436h     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 != 0) goto L_0x019f
            boolean r0 = r1.f14437i     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 != 0) goto L_0x019f
            boolean r0 = r22.d()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 == 0) goto L_0x0197
            goto L_0x019f
        L_0x0197:
            androidx.fragment.app.y r0 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = "empty_response_body"
            r0.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            throw r0     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x019f:
            if (r12 != 0) goto L_0x01b4
            boolean r0 = r1.f14436h     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 != 0) goto L_0x01b4
            boolean r0 = r22.d()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 == 0) goto L_0x01ac
            goto L_0x01b4
        L_0x01ac:
            androidx.fragment.app.y r0 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = "request_not_successful"
            r0.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            throw r0     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x01b4:
            boolean r0 = r1.f14436h     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 != 0) goto L_0x01d3
            boolean r0 = r1.f14437i     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 != 0) goto L_0x01d3
            long r7 = r1.f14441m     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            long r11 = r1.f14439k     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x01d3
            boolean r0 = r22.d()     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            if (r0 == 0) goto L_0x01cb
            goto L_0x01d3
        L_0x01cb:
            androidx.fragment.app.y r0 = new androidx.fragment.app.y     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            java.lang.String r3 = "unknown"
            r0.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
            throw r0     // Catch:{ Exception -> 0x0183, all -> 0x0181 }
        L_0x01d3:
            r3 = 0
        L_0x01d4:
            r9 = 0
            goto L_0x01de
        L_0x01d6:
            r3 = r0
            r7 = 0
            r9 = 0
            goto L_0x036f
        L_0x01db:
            r3 = 0
            r9 = 0
            r10 = 0
        L_0x01de:
            boolean r0 = r22.d()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 != 0) goto L_0x025a
            boolean r0 = r1.f14437i     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 != 0) goto L_0x025a
            boolean r0 = r1.f14436h     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 != 0) goto L_0x025a
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14441m     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f13440o = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14439k     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f13441p = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            y9.d r0 = r1.f14446r     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14441m     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f17245l = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            y9.d r0 = r1.f14446r     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14439k     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f17244k = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            boolean r0 = r1.f14437i     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 != 0) goto L_0x0265
            boolean r0 = r1.f14436h     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 != 0) goto L_0x0265
            u9.b r0 = r1.f14438j     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 == 0) goto L_0x021b
            q9.e r7 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.f(r7)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
        L_0x021b:
            u9.b r0 = r1.f14438j     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 == 0) goto L_0x022a
            q9.e r7 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            y9.d r8 = r1.f14446r     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            int r11 = r1.f14447s     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.b(r7, r8, r11)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
        L_0x022a:
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r1.f14442n     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.B = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            q9.e r0 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r22.a()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r0.C = r7     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            u9.b r0 = r1.f14438j     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 == 0) goto L_0x0265
            q9.e r17 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            q9.e r7 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r7 = r7.B     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            q9.e r11 = r22.b()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            long r11 = r11.C     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            r16 = r0
            r18 = r7
            r20 = r11
            r16.d(r17, r18, r20)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            goto L_0x0265
        L_0x025a:
            boolean r0 = r22.d()     // Catch:{ Exception -> 0x0161, all -> 0x015e }
            if (r0 == 0) goto L_0x0265
            if (r10 == 0) goto L_0x0265
            r1.e(r10)     // Catch:{ Exception -> 0x0161, all -> 0x015e }
        L_0x0265:
            if (r9 == 0) goto L_0x0272
            r9.close()     // Catch:{ Exception -> 0x026b }
            goto L_0x0272
        L_0x026b:
            r0 = move-exception
            r4 = r0
            y9.l r0 = r1.f14452x
            r0.b(r2, r4)
        L_0x0272:
            if (r10 == 0) goto L_0x0280
            y9.h r0 = r1.f14450v     // Catch:{ Exception -> 0x027a }
            r0.q0(r10)     // Catch:{ Exception -> 0x027a }
            goto L_0x0280
        L_0x027a:
            r0 = move-exception
            y9.l r4 = r1.f14452x
            r4.b(r2, r0)
        L_0x0280:
            if (r3 == 0) goto L_0x035d
            r3.close()     // Catch:{ Exception -> 0x0287 }
            goto L_0x035d
        L_0x0287:
            r0 = move-exception
            goto L_0x0358
        L_0x028a:
            r7 = r3
            goto L_0x036e
        L_0x028d:
            r7 = r3
        L_0x028e:
            r3 = r0
            goto L_0x029c
        L_0x0290:
            r0 = move-exception
            r3 = r0
            r7 = 0
            r9 = 0
            r10 = 0
            goto L_0x036f
        L_0x0297:
            r0 = move-exception
            r10 = 0
        L_0x0299:
            r3 = r0
            r7 = 0
            r9 = 0
        L_0x029c:
            boolean r0 = r1.f14436h     // Catch:{ all -> 0x02ee }
            if (r0 != 0) goto L_0x0337
            boolean r0 = r1.f14437i     // Catch:{ all -> 0x02ee }
            if (r0 != 0) goto L_0x0337
            y9.l r0 = r1.f14452x     // Catch:{ all -> 0x02ee }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ee }
            r8.<init>(r4)     // Catch:{ all -> 0x02ee }
            q9.e r4 = r22.Z()     // Catch:{ all -> 0x02ee }
            r8.append(r4)     // Catch:{ all -> 0x02ee }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x02ee }
            r0.b(r4, r3)     // Catch:{ all -> 0x02ee }
            p9.f r4 = hb.h0.i0(r3)     // Catch:{ all -> 0x02ee }
            if (r10 == 0) goto L_0x02c2
            hb.h0.F(r10)     // Catch:{ all -> 0x02ee }
        L_0x02c2:
            boolean r0 = r1.f14454z     // Catch:{ all -> 0x02ee }
            if (r0 == 0) goto L_0x02f5
            w9.a r0 = r1.f14453y     // Catch:{ all -> 0x02ee }
            boolean r0 = r0.b()     // Catch:{ all -> 0x02ee }
            r8 = 1
            r11 = r0 ^ 1
            r0 = 1
        L_0x02d0:
            r8 = 10
            if (r0 > r8) goto L_0x02f1
            r12 = 500(0x1f4, double:2.47E-321)
            java.lang.Thread.sleep(r12)     // Catch:{ InterruptedException -> 0x02e6 }
            w9.a r8 = r1.f14453y     // Catch:{ all -> 0x02ee }
            boolean r8 = r8.b()     // Catch:{ all -> 0x02ee }
            if (r8 != 0) goto L_0x02e3
            r11 = 1
            goto L_0x02f1
        L_0x02e3:
            int r0 = r0 + 1
            goto L_0x02d0
        L_0x02e6:
            r0 = move-exception
            r8 = r0
            y9.l r0 = r1.f14452x     // Catch:{ all -> 0x02ee }
            r0.b(r2, r8)     // Catch:{ all -> 0x02ee }
            goto L_0x02f1
        L_0x02ee:
            r0 = move-exception
            goto L_0x036e
        L_0x02f1:
            if (r11 == 0) goto L_0x02f5
            p9.f r4 = p9.f.NO_NETWORK_CONNECTION     // Catch:{ all -> 0x02ee }
        L_0x02f5:
            q9.e r0 = r22.b()     // Catch:{ all -> 0x02ee }
            long r11 = r1.f14441m     // Catch:{ all -> 0x02ee }
            r0.f13440o = r11     // Catch:{ all -> 0x02ee }
            q9.e r0 = r22.b()     // Catch:{ all -> 0x02ee }
            long r11 = r1.f14439k     // Catch:{ all -> 0x02ee }
            r0.f13441p = r11     // Catch:{ all -> 0x02ee }
            q9.e r0 = r22.b()     // Catch:{ all -> 0x02ee }
            r0.D(r4)     // Catch:{ all -> 0x02ee }
            y9.d r0 = r1.f14446r     // Catch:{ all -> 0x02ee }
            long r11 = r1.f14441m     // Catch:{ all -> 0x02ee }
            r0.f17245l = r11     // Catch:{ all -> 0x02ee }
            y9.d r0 = r1.f14446r     // Catch:{ all -> 0x02ee }
            long r11 = r1.f14439k     // Catch:{ all -> 0x02ee }
            r0.f17244k = r11     // Catch:{ all -> 0x02ee }
            boolean r0 = r1.f14437i     // Catch:{ all -> 0x02ee }
            if (r0 != 0) goto L_0x0337
            boolean r0 = r1.f14436h     // Catch:{ all -> 0x02ee }
            if (r0 != 0) goto L_0x0337
            q9.e r0 = r22.b()     // Catch:{ all -> 0x02ee }
            r0.B = r5     // Catch:{ all -> 0x02ee }
            q9.e r0 = r22.b()     // Catch:{ all -> 0x02ee }
            r0.C = r5     // Catch:{ all -> 0x02ee }
            u9.b r0 = r1.f14438j     // Catch:{ all -> 0x02ee }
            if (r0 == 0) goto L_0x0337
            q9.e r5 = r22.b()     // Catch:{ all -> 0x02ee }
            r0.c(r5, r4, r3)     // Catch:{ all -> 0x02ee }
        L_0x0337:
            if (r9 == 0) goto L_0x0344
            r9.close()     // Catch:{ Exception -> 0x033d }
            goto L_0x0344
        L_0x033d:
            r0 = move-exception
            r3 = r0
            y9.l r0 = r1.f14452x
            r0.b(r2, r3)
        L_0x0344:
            if (r10 == 0) goto L_0x0352
            y9.h r0 = r1.f14450v     // Catch:{ Exception -> 0x034c }
            r0.q0(r10)     // Catch:{ Exception -> 0x034c }
            goto L_0x0352
        L_0x034c:
            r0 = move-exception
            y9.l r3 = r1.f14452x
            r3.b(r2, r0)
        L_0x0352:
            if (r7 == 0) goto L_0x035d
            r7.close()     // Catch:{ Exception -> 0x0287 }
            goto L_0x035d
        L_0x0358:
            y9.l r3 = r1.f14452x
            r3.b(r2, r0)
        L_0x035d:
            u9.b r0 = r1.f14438j
            boolean r2 = r0 instanceof u9.b
            if (r2 != 0) goto L_0x0365
            r8 = 0
            goto L_0x0366
        L_0x0365:
            r8 = r0
        L_0x0366:
            r2 = 1
            if (r8 == 0) goto L_0x036b
            r8.f15441a = r2
        L_0x036b:
            r1.f14437i = r2
            return
        L_0x036e:
            r3 = r0
        L_0x036f:
            if (r9 == 0) goto L_0x037c
            r9.close()     // Catch:{ Exception -> 0x0375 }
            goto L_0x037c
        L_0x0375:
            r0 = move-exception
            r4 = r0
            y9.l r0 = r1.f14452x
            r0.b(r2, r4)
        L_0x037c:
            if (r10 == 0) goto L_0x038a
            y9.h r0 = r1.f14450v     // Catch:{ Exception -> 0x0384 }
            r0.q0(r10)     // Catch:{ Exception -> 0x0384 }
            goto L_0x038a
        L_0x0384:
            r0 = move-exception
            y9.l r4 = r1.f14452x
            r4.b(r2, r0)
        L_0x038a:
            if (r7 == 0) goto L_0x0397
            r7.close()     // Catch:{ Exception -> 0x0390 }
            goto L_0x0397
        L_0x0390:
            r0 = move-exception
            r4 = r0
            y9.l r0 = r1.f14452x
            r0.b(r2, r4)
        L_0x0397:
            u9.b r0 = r1.f14438j
            boolean r2 = r0 instanceof u9.b
            if (r2 != 0) goto L_0x039f
            r8 = 0
            goto L_0x03a0
        L_0x039f:
            r8 = r0
        L_0x03a0:
            r2 = 1
            if (r8 == 0) goto L_0x03a5
            r8.f15441a = r2
        L_0x03a5:
            r1.f14437i = r2
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.g.run():void");
    }

    public final void v() {
        u9.b bVar = this.f14438j;
        if (!(bVar instanceof u9.b)) {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f15441a = true;
        }
        this.f14436h = true;
    }
}
