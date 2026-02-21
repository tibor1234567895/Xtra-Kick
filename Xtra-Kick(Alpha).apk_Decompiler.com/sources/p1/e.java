package p1;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.n;
import j1.a;
import j1.h;
import j1.i;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import l1.b;
import m1.e0;
import n1.f0;
import p0.c;
import v1.r;

public final class e implements n {

    /* renamed from: a  reason: collision with root package name */
    public final List f12423a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f12424b;

    /* renamed from: c  reason: collision with root package name */
    public final n f12425c;

    /* renamed from: d  reason: collision with root package name */
    public final g f12426d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12427e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f12428f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f12429g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap f12430h;

    /* renamed from: i  reason: collision with root package name */
    public final i f12431i;

    /* renamed from: j  reason: collision with root package name */
    public final a2.i f12432j;

    /* renamed from: k  reason: collision with root package name */
    public final f0 f12433k;

    /* renamed from: l  reason: collision with root package name */
    public final i0 f12434l;

    /* renamed from: m  reason: collision with root package name */
    public final UUID f12435m;

    /* renamed from: n  reason: collision with root package name */
    public final Looper f12436n;

    /* renamed from: o  reason: collision with root package name */
    public final c f12437o;

    /* renamed from: p  reason: collision with root package name */
    public int f12438p;

    /* renamed from: q  reason: collision with root package name */
    public int f12439q;

    /* renamed from: r  reason: collision with root package name */
    public HandlerThread f12440r;

    /* renamed from: s  reason: collision with root package name */
    public a f12441s;

    /* renamed from: t  reason: collision with root package name */
    public b f12442t;

    /* renamed from: u  reason: collision with root package name */
    public m f12443u;

    /* renamed from: v  reason: collision with root package name */
    public byte[] f12444v;

    /* renamed from: w  reason: collision with root package name */
    public byte[] f12445w;

    /* renamed from: x  reason: collision with root package name */
    public a0 f12446x;

    /* renamed from: y  reason: collision with root package name */
    public b0 f12447y;

    public e(UUID uuid, c0 c0Var, n nVar, g gVar, List list, int i10, boolean z10, boolean z11, byte[] bArr, HashMap hashMap, i0 i0Var, Looper looper, a2.i iVar, f0 f0Var) {
        List list2;
        if (i10 == 1 || i10 == 3) {
            bArr.getClass();
        }
        this.f12435m = uuid;
        this.f12425c = nVar;
        this.f12426d = gVar;
        this.f12424b = c0Var;
        this.f12427e = i10;
        this.f12428f = z10;
        this.f12429g = z11;
        if (bArr != null) {
            this.f12445w = bArr;
            list2 = null;
        } else {
            list.getClass();
            list2 = Collections.unmodifiableList(list);
        }
        this.f12423a = list2;
        this.f12430h = hashMap;
        this.f12434l = i0Var;
        this.f12431i = new i();
        this.f12432j = iVar;
        this.f12433k = f0Var;
        this.f12438p = 2;
        this.f12436n = looper;
        this.f12437o = new c(this, looper);
    }

    public final boolean a() {
        p();
        return this.f12428f;
    }

    public final UUID b() {
        p();
        return this.f12435m;
    }

    public final void c(q qVar) {
        int i10;
        p();
        boolean z10 = false;
        if (this.f12439q < 0) {
            v.c("DefaultDrmSession", "Session reference count less than zero: " + this.f12439q);
            this.f12439q = 0;
        }
        if (qVar != null) {
            i iVar = this.f12431i;
            synchronized (iVar.f8439h) {
                ArrayList arrayList = new ArrayList(iVar.f8442k);
                arrayList.add(qVar);
                iVar.f8442k = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) iVar.f8440i.get(qVar);
                if (num == null) {
                    HashSet hashSet = new HashSet(iVar.f8441j);
                    hashSet.add(qVar);
                    iVar.f8441j = Collections.unmodifiableSet(hashSet);
                }
                HashMap hashMap = iVar.f8440i;
                if (num != null) {
                    i10 = num.intValue() + 1;
                } else {
                    i10 = 1;
                }
                hashMap.put(qVar, Integer.valueOf(i10));
            }
        }
        int i11 = this.f12439q + 1;
        this.f12439q = i11;
        if (i11 == 1) {
            if (this.f12438p == 2) {
                z10 = true;
            }
            a.e(z10);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f12440r = handlerThread;
            handlerThread.start();
            this.f12441s = new a(this, this.f12440r.getLooper());
            if (m()) {
                i(true);
            }
        } else if (qVar != null && j() && this.f12431i.a(qVar) == 1) {
            qVar.d(this.f12438p);
        }
        k kVar = this.f12426d.f12457a;
        if (kVar.f12482l != -9223372036854775807L) {
            kVar.f12485o.remove(this);
            Handler handler = kVar.f12491u;
            handler.getClass();
            handler.removeCallbacksAndMessages(this);
        }
    }

    public final void d(q qVar) {
        p();
        int i10 = this.f12439q;
        if (i10 <= 0) {
            v.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i11 = i10 - 1;
        this.f12439q = i11;
        if (i11 == 0) {
            this.f12438p = 0;
            c cVar = this.f12437o;
            int i12 = l0.f8453a;
            cVar.removeCallbacksAndMessages((Object) null);
            a aVar = this.f12441s;
            synchronized (aVar) {
                aVar.removeCallbacksAndMessages((Object) null);
                aVar.f12408a = true;
            }
            this.f12441s = null;
            this.f12440r.quit();
            this.f12440r = null;
            this.f12442t = null;
            this.f12443u = null;
            this.f12446x = null;
            this.f12447y = null;
            byte[] bArr = this.f12444v;
            if (bArr != null) {
                this.f12424b.d(bArr);
                this.f12444v = null;
            }
        }
        if (qVar != null) {
            this.f12431i.b(qVar);
            if (this.f12431i.a(qVar) == 0) {
                qVar.f();
            }
        }
        g gVar = this.f12426d;
        int i13 = this.f12439q;
        k kVar = gVar.f12457a;
        if (i13 == 1 && kVar.f12486p > 0 && kVar.f12482l != -9223372036854775807L) {
            kVar.f12485o.add(this);
            Handler handler = kVar.f12491u;
            handler.getClass();
            handler.postAtTime(new androidx.activity.e(11, this), this, SystemClock.uptimeMillis() + kVar.f12482l);
        } else if (i13 == 0) {
            kVar.f12483m.remove(this);
            if (kVar.f12488r == this) {
                kVar.f12488r = null;
            }
            if (kVar.f12489s == this) {
                kVar.f12489s = null;
            }
            n nVar = kVar.f12479i;
            ((Set) nVar.f337i).remove(this);
            if (((e) nVar.f338j) == this) {
                nVar.f338j = null;
                if (!((Set) nVar.f337i).isEmpty()) {
                    e eVar = (e) ((Set) nVar.f337i).iterator().next();
                    nVar.f338j = eVar;
                    b0 f10 = eVar.f12424b.f();
                    eVar.f12447y = f10;
                    a aVar2 = eVar.f12441s;
                    int i14 = l0.f8453a;
                    f10.getClass();
                    aVar2.getClass();
                    aVar2.obtainMessage(0, new b(r.f15758a.getAndIncrement(), true, SystemClock.elapsedRealtime(), f10)).sendToTarget();
                }
            }
            if (kVar.f12482l != -9223372036854775807L) {
                Handler handler2 = kVar.f12491u;
                handler2.getClass();
                handler2.removeCallbacksAndMessages(this);
                kVar.f12485o.remove(this);
            }
        }
        kVar.l();
    }

    public final boolean e(String str) {
        p();
        byte[] bArr = this.f12444v;
        a.f(bArr);
        return this.f12424b.m(str, bArr);
    }

    public final m f() {
        p();
        if (this.f12438p == 1) {
            return this.f12443u;
        }
        return null;
    }

    public final b g() {
        p();
        return this.f12442t;
    }

    public final int getState() {
        p();
        return this.f12438p;
    }

    public final void h(h hVar) {
        Set<q> set;
        i iVar = this.f12431i;
        synchronized (iVar.f8439h) {
            set = iVar.f8441j;
        }
        for (q b10 : set) {
            hVar.b(b10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A[Catch:{ NumberFormatException -> 0x0097 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(boolean r12) {
        /*
            r11 = this;
            boolean r0 = r11.f12429g
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            byte[] r0 = r11.f12444v
            int r1 = j1.l0.f8453a
            r1 = 0
            p1.c0 r2 = r11.f12424b
            r3 = 1
            int r4 = r11.f12427e
            r5 = 2
            if (r4 == 0) goto L_0x003d
            if (r4 == r3) goto L_0x003d
            if (r4 == r5) goto L_0x002c
            r0 = 3
            if (r4 == r0) goto L_0x001b
            goto L_0x00df
        L_0x001b:
            byte[] r1 = r11.f12445w
            r1.getClass()
            byte[] r1 = r11.f12444v
            r1.getClass()
            byte[] r1 = r11.f12445w
            r11.n(r1, r0, r12)
            goto L_0x00df
        L_0x002c:
            byte[] r4 = r11.f12445w
            if (r4 == 0) goto L_0x00c1
            r2.b(r0, r4)     // Catch:{ Exception -> 0x0035 }
            r1 = 1
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            r11.k(r3, r2)
        L_0x0039:
            if (r1 == 0) goto L_0x00df
            goto L_0x00c1
        L_0x003d:
            byte[] r6 = r11.f12445w
            if (r6 != 0) goto L_0x0046
            r11.n(r0, r3, r12)
            goto L_0x00df
        L_0x0046:
            int r7 = r11.f12438p
            r8 = 4
            if (r7 == r8) goto L_0x0056
            r2.b(r0, r6)     // Catch:{ Exception -> 0x0050 }
            r1 = 1
            goto L_0x0054
        L_0x0050:
            r2 = move-exception
            r11.k(r3, r2)
        L_0x0054:
            if (r1 == 0) goto L_0x00df
        L_0x0056:
            java.util.UUID r1 = g1.n.f6476d
            java.util.UUID r2 = r11.f12435m
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0066
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x00b6
        L_0x0066:
            java.util.Map r1 = r11.o()
            if (r1 != 0) goto L_0x006e
            r1 = 0
            goto L_0x009f
        L_0x006e:
            android.util.Pair r2 = new android.util.Pair
            java.lang.String r3 = "LicenseDurationRemaining"
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.lang.Object r3 = r1.get(r3)     // Catch:{ NumberFormatException -> 0x0084 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x0084 }
            if (r3 == 0) goto L_0x0084
            long r9 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = r6
        L_0x0085:
            java.lang.Long r3 = java.lang.Long.valueOf(r9)
            java.lang.String r9 = "PlaybackDurationRemaining"
            java.lang.Object r1 = r1.get(r9)     // Catch:{ NumberFormatException -> 0x0097 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x0097 }
            if (r1 == 0) goto L_0x0097
            long r6 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x0097 }
        L_0x0097:
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r2.<init>(r3, r1)
            r1 = r2
        L_0x009f:
            r1.getClass()
            java.lang.Object r2 = r1.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r6 = r1.longValue()
            long r1 = java.lang.Math.min(r2, r6)
        L_0x00b6:
            if (r4 != 0) goto L_0x00c5
            r3 = 60
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x00c5
            j1.v.b()
        L_0x00c1:
            r11.n(r0, r5, r12)
            goto L_0x00df
        L_0x00c5:
            r3 = 0
            int r12 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r12 > 0) goto L_0x00d4
            p1.j0 r12 = new p1.j0
            r12.<init>()
            r11.k(r5, r12)
            goto L_0x00df
        L_0x00d4:
            r11.f12438p = r8
            i1.c r12 = new i1.c
            r0 = 6
            r12.<init>(r0)
            r11.h(r12)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.e.i(boolean):void");
    }

    public final boolean j() {
        int i10 = this.f12438p;
        return i10 == 3 || i10 == 4;
    }

    public final void k(int i10, Exception exc) {
        int i11;
        int i12 = l0.f8453a;
        if (i12 < 21 || !w.a(exc)) {
            if (i12 < 23 || !x.a(exc)) {
                if (i12 < 18 || !v.b(exc)) {
                    if (i12 >= 18 && v.a(exc)) {
                        i11 = 6007;
                    } else if (exc instanceof l0) {
                        i11 = 6001;
                    } else if (exc instanceof i) {
                        i11 = 6003;
                    } else if (exc instanceof j0) {
                        i11 = 6008;
                    } else if (i10 != 1) {
                        if (i10 == 2) {
                            i11 = 6004;
                        } else if (i10 != 3) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                i11 = 6002;
            }
            i11 = 6006;
        } else {
            i11 = w.b(exc);
        }
        this.f12443u = new m(exc, i11);
        v.d("DefaultDrmSession", "DRM session error", exc);
        h(new c(5, exc));
        if (this.f12438p != 4) {
            this.f12438p = 1;
        }
    }

    public final void l(Exception exc, boolean z10) {
        int i10;
        if (exc instanceof NotProvisionedException) {
            n nVar = this.f12425c;
            ((Set) nVar.f337i).add(this);
            if (((e) nVar.f338j) == null) {
                nVar.f338j = this;
                b0 f10 = this.f12424b.f();
                this.f12447y = f10;
                a aVar = this.f12441s;
                int i11 = l0.f8453a;
                f10.getClass();
                aVar.getClass();
                aVar.obtainMessage(0, new b(r.f15758a.getAndIncrement(), true, SystemClock.elapsedRealtime(), f10)).sendToTarget();
                return;
            }
            return;
        }
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        k(i10, exc);
    }

    public final boolean m() {
        c0 c0Var = this.f12424b;
        if (j()) {
            return true;
        }
        try {
            byte[] n10 = c0Var.n();
            this.f12444v = n10;
            c0Var.l(n10, this.f12433k);
            this.f12442t = c0Var.k(this.f12444v);
            this.f12438p = 3;
            h(new e0(3, 1));
            this.f12444v.getClass();
            return true;
        } catch (NotProvisionedException unused) {
            n nVar = this.f12425c;
            ((Set) nVar.f337i).add(this);
            if (((e) nVar.f338j) == null) {
                nVar.f338j = this;
                b0 f10 = c0Var.f();
                this.f12447y = f10;
                a aVar = this.f12441s;
                int i10 = l0.f8453a;
                f10.getClass();
                aVar.getClass();
                aVar.obtainMessage(0, new b(r.f15758a.getAndIncrement(), true, SystemClock.elapsedRealtime(), f10)).sendToTarget();
            }
            return false;
        } catch (Exception e10) {
            k(1, e10);
            return false;
        }
    }

    public final void n(byte[] bArr, int i10, boolean z10) {
        try {
            a0 i11 = this.f12424b.i(bArr, this.f12423a, i10, this.f12430h);
            this.f12446x = i11;
            a aVar = this.f12441s;
            int i12 = l0.f8453a;
            i11.getClass();
            aVar.getClass();
            aVar.obtainMessage(1, new b(r.f15758a.getAndIncrement(), z10, SystemClock.elapsedRealtime(), i11)).sendToTarget();
        } catch (Exception e10) {
            l(e10, true);
        }
    }

    public final Map o() {
        p();
        byte[] bArr = this.f12444v;
        if (bArr == null) {
            return null;
        }
        return this.f12424b.c(bArr);
    }

    public final void p() {
        Thread currentThread = Thread.currentThread();
        Looper looper = this.f12436n;
        if (currentThread != looper.getThread()) {
            v.h("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + looper.getThread().getName(), new IllegalStateException());
        }
    }
}
