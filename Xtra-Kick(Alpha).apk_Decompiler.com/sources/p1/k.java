package p1;

import a2.i;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.n;
import d9.i2;
import d9.p0;
import d9.r1;
import d9.u0;
import g.r0;
import g1.a0;
import g1.a1;
import g1.t;
import g1.u;
import j1.a;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import n1.f0;

public final class k implements u {

    /* renamed from: b  reason: collision with root package name */
    public final UUID f12472b;

    /* renamed from: c  reason: collision with root package name */
    public final e0 f12473c;

    /* renamed from: d  reason: collision with root package name */
    public final i0 f12474d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f12475e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f12476f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f12477g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f12478h;

    /* renamed from: i  reason: collision with root package name */
    public final n f12479i = new n();

    /* renamed from: j  reason: collision with root package name */
    public final i f12480j;

    /* renamed from: k  reason: collision with root package name */
    public final g f12481k = new g(this, 1);

    /* renamed from: l  reason: collision with root package name */
    public final long f12482l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f12483m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public final Set f12484n = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: o  reason: collision with root package name */
    public final Set f12485o = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: p  reason: collision with root package name */
    public int f12486p;

    /* renamed from: q  reason: collision with root package name */
    public c0 f12487q;

    /* renamed from: r  reason: collision with root package name */
    public e f12488r;

    /* renamed from: s  reason: collision with root package name */
    public e f12489s;

    /* renamed from: t  reason: collision with root package name */
    public Looper f12490t;

    /* renamed from: u  reason: collision with root package name */
    public Handler f12491u;

    /* renamed from: v  reason: collision with root package name */
    public int f12492v = 0;

    /* renamed from: w  reason: collision with root package name */
    public byte[] f12493w;

    /* renamed from: x  reason: collision with root package name */
    public f0 f12494x;

    /* renamed from: y  reason: collision with root package name */
    public volatile h f12495y;

    public k(UUID uuid, e0 e0Var, i0 i0Var, HashMap hashMap, boolean z10, int[] iArr, boolean z11, i iVar, long j10) {
        uuid.getClass();
        a.a("Use C.CLEARKEY_UUID instead", !g1.n.f6474b.equals(uuid));
        this.f12472b = uuid;
        this.f12473c = e0Var;
        this.f12474d = i0Var;
        this.f12475e = hashMap;
        this.f12476f = z10;
        this.f12477g = iArr;
        this.f12478h = z11;
        this.f12480j = iVar;
        this.f12482l = j10;
    }

    public static boolean h(e eVar) {
        eVar.p();
        if (eVar.f12438p == 1) {
            if (l0.f8453a < 19) {
                return true;
            }
            m f10 = eVar.f();
            f10.getClass();
            if (f10.getCause() instanceof ResourceBusyException) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList k(u uVar, UUID uuid, boolean z10) {
        boolean z11;
        ArrayList arrayList = new ArrayList(uVar.f6595k);
        for (int i10 = 0; i10 < uVar.f6595k; i10++) {
            t tVar = uVar.f6592h[i10];
            if (tVar.u(uuid) || (g1.n.f6475c.equals(uuid) && tVar.u(g1.n.f6474b))) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && (tVar.f6570l != null || z10)) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public final void a() {
        m(true);
        int i10 = this.f12486p - 1;
        this.f12486p = i10;
        if (i10 == 0) {
            if (this.f12482l != -9223372036854775807L) {
                ArrayList arrayList = new ArrayList(this.f12483m);
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    ((e) arrayList.get(i11)).d((q) null);
                }
            }
            i2 g10 = u0.j(this.f12484n).iterator();
            while (g10.hasNext()) {
                ((j) g10.next()).a();
            }
            l();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(g1.a0 r7) {
        /*
            r6 = this;
            r0 = 0
            r6.m(r0)
            p1.c0 r1 = r6.f12487q
            r1.getClass()
            int r1 = r1.j()
            g1.u r2 = r7.f6279v
            if (r2 != 0) goto L_0x002b
            java.lang.String r7 = r7.f6276s
            int r7 = g1.a1.h(r7)
            r2 = 0
        L_0x0018:
            int[] r3 = r6.f12477g
            int r4 = r3.length
            r5 = -1
            if (r2 >= r4) goto L_0x0026
            r3 = r3[r2]
            if (r3 != r7) goto L_0x0023
            goto L_0x0027
        L_0x0023:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x0026:
            r2 = -1
        L_0x0027:
            if (r2 == r5) goto L_0x002a
            r0 = r1
        L_0x002a:
            return r0
        L_0x002b:
            byte[] r7 = r6.f12493w
            r3 = 1
            if (r7 == 0) goto L_0x0031
            goto L_0x008d
        L_0x0031:
            java.util.UUID r7 = r6.f12472b
            java.util.ArrayList r4 = k(r2, r7, r3)
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0060
            int r4 = r2.f6595k
            if (r4 != r3) goto L_0x008e
            g1.t[] r4 = r2.f6592h
            r4 = r4[r0]
            java.util.UUID r5 = g1.n.f6474b
            boolean r4 = r4.u(r5)
            if (r4 == 0) goto L_0x008e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "DrmInitData only contains common PSSH SchemeData. Assuming support for: "
            r4.<init>(r5)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            java.lang.String r4 = "DefaultDrmSessionMgr"
            j1.v.g(r4, r7)
        L_0x0060:
            java.lang.String r7 = r2.f6594j
            if (r7 == 0) goto L_0x008d
            java.lang.String r2 = "cenc"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x006d
            goto L_0x008d
        L_0x006d:
            java.lang.String r2 = "cbcs"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x007c
            int r7 = j1.l0.f8453a
            r2 = 25
            if (r7 < r2) goto L_0x008e
            goto L_0x008d
        L_0x007c:
            java.lang.String r2 = "cbc1"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x008e
            java.lang.String r2 = "cens"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r0 = 1
        L_0x008e:
            if (r0 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r1 = 1
        L_0x0092:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.k.b(g1.a0):int");
    }

    public final n c(q qVar, a0 a0Var) {
        boolean z10 = false;
        m(false);
        if (this.f12486p > 0) {
            z10 = true;
        }
        a.e(z10);
        a.f(this.f12490t);
        return g(this.f12490t, qVar, a0Var, true);
    }

    public final t d(q qVar, a0 a0Var) {
        boolean z10;
        if (this.f12486p > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        a.f(this.f12490t);
        j jVar = new j(this, qVar);
        Handler handler = this.f12491u;
        handler.getClass();
        handler.post(new r0(jVar, 12, a0Var));
        return jVar;
    }

    public final void e() {
        c0 c0Var;
        m(true);
        int i10 = this.f12486p;
        this.f12486p = i10 + 1;
        if (i10 == 0) {
            int i11 = 0;
            if (this.f12487q == null) {
                UUID uuid = this.f12472b;
                this.f12473c.getClass();
                try {
                    c0Var = new h0(uuid);
                } catch (UnsupportedSchemeException e10) {
                    throw new l0(e10);
                } catch (Exception e11) {
                    throw new l0(e11);
                } catch (l0 unused) {
                    v.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
                    c0Var = new y();
                }
                this.f12487q = c0Var;
                c0Var.h(new g(this, 0));
            } else if (this.f12482l != -9223372036854775807L) {
                while (true) {
                    ArrayList arrayList = this.f12483m;
                    if (i11 < arrayList.size()) {
                        ((e) arrayList.get(i11)).c((q) null);
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void f(Looper looper, f0 f0Var) {
        boolean z10;
        synchronized (this) {
            Looper looper2 = this.f12490t;
            if (looper2 == null) {
                this.f12490t = looper;
                this.f12491u = new Handler(looper);
            } else {
                if (looper2 == looper) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a.e(z10);
                this.f12491u.getClass();
            }
        }
        this.f12494x = f0Var;
    }

    public final n g(Looper looper, q qVar, a0 a0Var, boolean z10) {
        ArrayList arrayList;
        boolean z11;
        if (this.f12495y == null) {
            this.f12495y = new h(this, looper);
        }
        u uVar = a0Var.f6279v;
        int i10 = 0;
        e eVar = null;
        if (uVar == null) {
            int h10 = a1.h(a0Var.f6276s);
            c0 c0Var = this.f12487q;
            c0Var.getClass();
            if (c0Var.j() != 2 || !d0.f12419d) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return null;
            }
            int[] iArr = this.f12477g;
            while (true) {
                if (i10 >= iArr.length) {
                    i10 = -1;
                    break;
                } else if (iArr[i10] == h10) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1 || c0Var.j() == 1) {
                return null;
            }
            e eVar2 = this.f12488r;
            if (eVar2 == null) {
                p0 p0Var = d9.r0.f4657i;
                e j10 = j(r1.f4658l, true, (q) null, z10);
                this.f12483m.add(j10);
                this.f12488r = j10;
            } else {
                eVar2.c((q) null);
            }
            return this.f12488r;
        }
        if (this.f12493w == null) {
            arrayList = k(uVar, this.f12472b, false);
            if (arrayList.isEmpty()) {
                i iVar = new i(this.f12472b);
                v.d("DefaultDrmSessionMgr", "DRM error", iVar);
                if (qVar != null) {
                    qVar.e(iVar);
                }
                return new z(new m(iVar, 6003));
            }
        } else {
            arrayList = null;
        }
        if (this.f12476f) {
            Iterator it = this.f12483m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e eVar3 = (e) it.next();
                if (l0.a(eVar3.f12423a, arrayList)) {
                    eVar = eVar3;
                    break;
                }
            }
        } else {
            eVar = this.f12489s;
        }
        if (eVar == null) {
            eVar = j(arrayList, false, qVar, z10);
            if (!this.f12476f) {
                this.f12489s = eVar;
            }
            this.f12483m.add(eVar);
        } else {
            eVar.c(qVar);
        }
        return eVar;
    }

    public final e i(List list, boolean z10, q qVar) {
        this.f12487q.getClass();
        UUID uuid = this.f12472b;
        c0 c0Var = this.f12487q;
        n nVar = this.f12479i;
        g gVar = this.f12481k;
        int i10 = this.f12492v;
        byte[] bArr = this.f12493w;
        HashMap hashMap = this.f12475e;
        i0 i0Var = this.f12474d;
        Looper looper = this.f12490t;
        looper.getClass();
        i iVar = this.f12480j;
        f0 f0Var = this.f12494x;
        f0Var.getClass();
        e eVar = new e(uuid, c0Var, nVar, gVar, list, i10, this.f12478h | z10, z10, bArr, hashMap, i0Var, looper, iVar, f0Var);
        eVar.c(qVar);
        if (this.f12482l != -9223372036854775807L) {
            eVar.c((q) null);
        }
        return eVar;
    }

    public final e j(List list, boolean z10, q qVar, boolean z11) {
        e i10 = i(list, z10, qVar);
        boolean h10 = h(i10);
        long j10 = this.f12482l;
        Set set = this.f12485o;
        if (h10 && !set.isEmpty()) {
            i2 g10 = u0.j(set).iterator();
            while (g10.hasNext()) {
                ((n) g10.next()).d((q) null);
            }
            i10.d(qVar);
            if (j10 != -9223372036854775807L) {
                i10.d((q) null);
            }
            i10 = i(list, z10, qVar);
        }
        if (!h(i10) || !z11) {
            return i10;
        }
        Set set2 = this.f12484n;
        if (set2.isEmpty()) {
            return i10;
        }
        i2 g11 = u0.j(set2).iterator();
        while (g11.hasNext()) {
            ((j) g11.next()).a();
        }
        if (!set.isEmpty()) {
            i2 g12 = u0.j(set).iterator();
            while (g12.hasNext()) {
                ((n) g12.next()).d((q) null);
            }
        }
        i10.d(qVar);
        if (j10 != -9223372036854775807L) {
            i10.d((q) null);
        }
        return i(list, z10, qVar);
    }

    public final void l() {
        if (this.f12487q != null && this.f12486p == 0 && this.f12483m.isEmpty() && this.f12484n.isEmpty()) {
            c0 c0Var = this.f12487q;
            c0Var.getClass();
            c0Var.a();
            this.f12487q = null;
        }
    }

    public final void m(boolean z10) {
        if (!z10 || this.f12490t != null) {
            Thread currentThread = Thread.currentThread();
            Looper looper = this.f12490t;
            looper.getClass();
            if (currentThread != looper.getThread()) {
                v.h("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f12490t.getThread().getName(), new IllegalStateException());
                return;
            }
            return;
        }
        v.h("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
    }
}
