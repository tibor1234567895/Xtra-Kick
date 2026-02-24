package d6;

import a2.i;
import a2.l;
import a2.n;
import a2.q;
import a2.s;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import f3.a;
import j1.l0;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import r1.b;
import r1.h;
import r1.o;
import r1.p;
import r1.t;
import r1.v;
import r1.w;
import r1.x;
import v1.f0;
import v1.r;

public final class c implements x, l {

    /* renamed from: v  reason: collision with root package name */
    public static final a f4521v = new a(1);

    /* renamed from: h  reason: collision with root package name */
    public final q1.c f4522h;

    /* renamed from: i  reason: collision with root package name */
    public final t f4523i;

    /* renamed from: j  reason: collision with root package name */
    public final i f4524j;

    /* renamed from: k  reason: collision with root package name */
    public final HashMap f4525k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public final CopyOnWriteArrayList f4526l = new CopyOnWriteArrayList();

    /* renamed from: m  reason: collision with root package name */
    public f0 f4527m;

    /* renamed from: n  reason: collision with root package name */
    public q f4528n;

    /* renamed from: o  reason: collision with root package name */
    public Handler f4529o;

    /* renamed from: p  reason: collision with root package name */
    public w f4530p;

    /* renamed from: q  reason: collision with root package name */
    public o f4531q;

    /* renamed from: r  reason: collision with root package name */
    public Uri f4532r;

    /* renamed from: s  reason: collision with root package name */
    public r1.l f4533s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4534t;

    /* renamed from: u  reason: collision with root package name */
    public long f4535u = -9223372036854775807L;

    public c(q1.c cVar, i iVar, t tVar) {
        this.f4522h = cVar;
        this.f4523i = tVar;
        this.f4524j = iVar;
    }

    public final void a(Uri uri, f0 f0Var, w wVar) {
        boolean z10;
        this.f4529o = l0.k((Handler.Callback) null);
        this.f4527m = f0Var;
        this.f4530p = wVar;
        s sVar = new s(this.f4522h.a(), uri, this.f4523i.b());
        if (this.f4528n == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        j1.a.e(z10);
        q qVar = new q("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f4528n = qVar;
        i iVar = this.f4524j;
        int i10 = sVar.f79c;
        qVar.g(sVar, this, iVar.b(i10));
        f0Var.m(new r(sVar.f78b), i10);
    }

    public final boolean b() {
        return this.f4534t;
    }

    public final o c() {
        return this.f4531q;
    }

    public final boolean d(Uri uri, long j10) {
        b bVar = (b) this.f4525k.get(uri);
        if (bVar != null) {
            return !b.a(bVar, j10);
        }
        return false;
    }

    public final boolean e(Uri uri) {
        int i10;
        b bVar = (b) this.f4525k.get(uri);
        if (bVar.f4513k == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000, l0.Q(bVar.f4513k.f13599u));
        r1.l lVar = bVar.f4513k;
        if (lVar.f13593o || (i10 = lVar.f13582d) == 2 || i10 == 1 || bVar.f4514l + max > elapsedRealtime) {
            return true;
        }
        return false;
    }

    public final void f() {
        q qVar = this.f4528n;
        if (qVar != null) {
            qVar.e();
        }
        Uri uri = this.f4532r;
        if (uri != null) {
            i(uri);
        }
    }

    public final void g(v vVar) {
        this.f4526l.remove(vVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a2.k h(a2.n r5, long r6, long r8, java.io.IOException r10, int r11) {
        /*
            r4 = this;
            a2.s r5 = (a2.s) r5
            v1.r r6 = new v1.r
            long r7 = r5.f77a
            k1.e0 r7 = r5.f80d
            android.net.Uri r7 = r7.f8992c
            r6.<init>()
            a2.i r7 = r4.f4524j
            r7.getClass()
            boolean r7 = r10 instanceof g1.b1
            r8 = 1
            r9 = 0
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 != 0) goto L_0x0052
            boolean r7 = r10 instanceof java.io.FileNotFoundException
            if (r7 != 0) goto L_0x0052
            boolean r7 = r10 instanceof k1.w
            if (r7 != 0) goto L_0x0052
            boolean r7 = r10 instanceof a2.p
            if (r7 != 0) goto L_0x0052
            int r7 = k1.i.f9006i
            r7 = r10
        L_0x002c:
            if (r7 == 0) goto L_0x0042
            boolean r2 = r7 instanceof k1.i
            if (r2 == 0) goto L_0x003d
            r2 = r7
            k1.i r2 = (k1.i) r2
            int r2 = r2.f9007h
            r3 = 2008(0x7d8, float:2.814E-42)
            if (r2 != r3) goto L_0x003d
            r7 = 1
            goto L_0x0043
        L_0x003d:
            java.lang.Throwable r7 = r7.getCause()
            goto L_0x002c
        L_0x0042:
            r7 = 0
        L_0x0043:
            if (r7 == 0) goto L_0x0046
            goto L_0x0052
        L_0x0046:
            int r11 = r11 + -1
            int r11 = r11 * 1000
            r7 = 5000(0x1388, float:7.006E-42)
            int r7 = java.lang.Math.min(r11, r7)
            long r2 = (long) r7
            goto L_0x0053
        L_0x0052:
            r2 = r0
        L_0x0053:
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r8 = 0
        L_0x0059:
            v1.f0 r7 = r4.f4527m
            int r5 = r5.f79c
            r7.k(r6, r5, r10, r8)
            if (r8 == 0) goto L_0x0065
            a2.k r5 = a2.q.f73f
            goto L_0x0069
        L_0x0065:
            a2.k r5 = a2.q.b(r2, r9)
        L_0x0069:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.c.h(a2.n, long, long, java.io.IOException, int):a2.k");
    }

    public final void i(Uri uri) {
        b bVar = (b) this.f4525k.get(uri);
        bVar.f4511i.e();
        IOException iOException = bVar.f4519q;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final void j(v vVar) {
        vVar.getClass();
        this.f4526l.add(vVar);
    }

    public final void k(Uri uri) {
        b bVar = (b) this.f4525k.get(uri);
        bVar.c(bVar.f4510h);
    }

    public final void l(n nVar, long j10, long j11, boolean z10) {
        s sVar = (s) nVar;
        long j12 = sVar.f77a;
        Uri uri = sVar.f80d.f8992c;
        r rVar = new r();
        this.f4524j.getClass();
        this.f4527m.d(rVar);
    }

    public final r1.l m(boolean z10, Uri uri) {
        r1.l lVar;
        HashMap hashMap = this.f4525k;
        r1.l lVar2 = ((b) hashMap.get(uri)).f4513k;
        if (lVar2 != null && z10 && !uri.equals(this.f4532r)) {
            List list = this.f4531q.f13612e;
            boolean z11 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= list.size()) {
                    break;
                } else if (uri.equals(((r1.n) list.get(i10)).f13604a)) {
                    z11 = true;
                    break;
                } else {
                    i10++;
                }
            }
            if (z11 && ((lVar = this.f4533s) == null || !lVar.f13593o)) {
                this.f4532r = uri;
                b bVar = (b) hashMap.get(uri);
                r1.l lVar3 = bVar.f4513k;
                if (lVar3 == null || !lVar3.f13593o) {
                    bVar.c(p(uri));
                } else {
                    this.f4533s = lVar3;
                    ((q1.q) this.f4530p).t(lVar3);
                }
            }
        }
        return lVar2;
    }

    public final void n(n nVar, long j10, long j11) {
        o oVar;
        s sVar = (s) nVar;
        p pVar = (p) sVar.f82f;
        boolean z10 = pVar instanceof r1.l;
        if (z10) {
            oVar = o.d(pVar.f13621a);
        } else {
            oVar = (o) pVar;
        }
        this.f4531q = oVar;
        this.f4532r = ((r1.n) oVar.f13612e.get(0)).f13604a;
        this.f4526l.add(new b(this));
        List list = oVar.f13611d;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Uri uri = (Uri) list.get(i10);
            this.f4525k.put(uri, new b(this, uri));
        }
        Uri uri2 = sVar.f80d.f8992c;
        r rVar = new r();
        b bVar = (b) this.f4525k.get(this.f4532r);
        if (z10) {
            bVar.d((r1.l) pVar, rVar);
        } else {
            bVar.c(bVar.f4510h);
        }
        this.f4524j.getClass();
        this.f4527m.g(rVar);
    }

    public final long o() {
        return this.f4535u;
    }

    public final Uri p(Uri uri) {
        h hVar;
        r1.l lVar = this.f4533s;
        if (lVar == null || !lVar.f13600v.f13581e || (hVar = (h) lVar.f13598t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(hVar.f13562b));
        int i10 = hVar.f13563c;
        if (i10 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i10));
        }
        return buildUpon.build();
    }

    public final void stop() {
        this.f4532r = null;
        this.f4533s = null;
        this.f4531q = null;
        this.f4535u = -9223372036854775807L;
        this.f4528n.f((a2.o) null);
        this.f4528n = null;
        HashMap hashMap = this.f4525k;
        for (b bVar : hashMap.values()) {
            bVar.f4511i.f((a2.o) null);
        }
        this.f4529o.removeCallbacksAndMessages((Object) null);
        this.f4529o = null;
        hashMap.clear();
    }
}
