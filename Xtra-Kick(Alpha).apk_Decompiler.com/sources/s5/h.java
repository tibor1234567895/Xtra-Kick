package s5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.media.session.u;
import android.util.Log;
import b5.a;
import b5.n;
import com.bumptech.glide.j;
import d5.b0;
import d5.o0;
import d5.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import m5.b;
import t5.f;
import t5.g;
import w5.e;
import w5.i;
import w5.p;

public final class h implements d, f, g {
    public static final boolean B = Log.isLoggable("GlideRequest", 2);
    public int A;

    /* renamed from: a  reason: collision with root package name */
    public final x5.h f14329a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f14330b;

    /* renamed from: c  reason: collision with root package name */
    public final c f14331c;

    /* renamed from: d  reason: collision with root package name */
    public final e f14332d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f14333e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bumptech.glide.h f14334f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f14335g;

    /* renamed from: h  reason: collision with root package name */
    public final Class f14336h;

    /* renamed from: i  reason: collision with root package name */
    public final a f14337i;

    /* renamed from: j  reason: collision with root package name */
    public final int f14338j;

    /* renamed from: k  reason: collision with root package name */
    public final int f14339k;

    /* renamed from: l  reason: collision with root package name */
    public final j f14340l;

    /* renamed from: m  reason: collision with root package name */
    public final g f14341m;

    /* renamed from: n  reason: collision with root package name */
    public final List f14342n;

    /* renamed from: o  reason: collision with root package name */
    public final u5.h f14343o;

    /* renamed from: p  reason: collision with root package name */
    public final Executor f14344p;

    /* renamed from: q  reason: collision with root package name */
    public o0 f14345q;

    /* renamed from: r  reason: collision with root package name */
    public u f14346r;

    /* renamed from: s  reason: collision with root package name */
    public volatile w f14347s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f14348t;

    /* renamed from: u  reason: collision with root package name */
    public Drawable f14349u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f14350v;

    /* renamed from: w  reason: collision with root package name */
    public int f14351w;

    /* renamed from: x  reason: collision with root package name */
    public int f14352x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f14353y;

    /* renamed from: z  reason: collision with root package name */
    public final RuntimeException f14354z;

    public h(Context context, com.bumptech.glide.h hVar, Object obj, Object obj2, Class cls, a aVar, int i10, int i11, j jVar, g gVar, ArrayList arrayList, e eVar, w wVar, u5.h hVar2, e eVar2) {
        com.bumptech.glide.h hVar3 = hVar;
        if (B) {
            String.valueOf(hashCode());
        }
        this.f14329a = new x5.h();
        this.f14330b = obj;
        this.f14333e = context;
        this.f14334f = hVar3;
        this.f14335g = obj2;
        this.f14336h = cls;
        this.f14337i = aVar;
        this.f14338j = i10;
        this.f14339k = i11;
        this.f14340l = jVar;
        this.f14341m = gVar;
        this.f14331c = null;
        this.f14342n = arrayList;
        this.f14332d = eVar;
        this.f14347s = wVar;
        this.f14343o = hVar2;
        this.f14344p = eVar2;
        this.A = 1;
        if (this.f14354z == null && ((Map) hVar3.f3195h.f2538i).containsKey(com.bumptech.glide.e.class)) {
            this.f14354z = new RuntimeException("Glide request origin trace");
        }
    }

    public final boolean a() {
        boolean z10;
        synchronized (this.f14330b) {
            z10 = this.A == 4;
        }
        return z10;
    }

    public final boolean b() {
        boolean z10;
        synchronized (this.f14330b) {
            z10 = this.A == 6;
        }
        return z10;
    }

    public final void c() {
        if (!this.f14353y) {
            this.f14329a.a();
            this.f14341m.e(this);
            u uVar = this.f14346r;
            if (uVar != null) {
                synchronized (((w) uVar.f430k)) {
                    ((b0) uVar.f428i).j((g) uVar.f429j);
                }
                this.f14346r = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        r5.f14347s.getClass();
        d5.w.f(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f14330b
            monitor-enter(r0)
            boolean r1 = r5.f14353y     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x0046
            x5.h r1 = r5.f14329a     // Catch:{ all -> 0x004e }
            r1.a()     // Catch:{ all -> 0x004e }
            int r1 = r5.A     // Catch:{ all -> 0x004e }
            r2 = 6
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x0013:
            r5.c()     // Catch:{ all -> 0x004e }
            d5.o0 r1 = r5.f14345q     // Catch:{ all -> 0x004e }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.f14345q = r3     // Catch:{ all -> 0x004e }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            s5.e r3 = r5.f14332d     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.d(r5)     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r3 = 0
            goto L_0x002d
        L_0x002c:
            r3 = 1
        L_0x002d:
            if (r3 == 0) goto L_0x0038
            t5.g r3 = r5.f14341m     // Catch:{ all -> 0x004e }
            android.graphics.drawable.Drawable r4 = r5.d()     // Catch:{ all -> 0x004e }
            r3.i(r4)     // Catch:{ all -> 0x004e }
        L_0x0038:
            r5.A = r2     // Catch:{ all -> 0x004e }
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0045
            d5.w r0 = r5.f14347s
            r0.getClass()
            d5.w.f(r1)
        L_0x0045:
            return
        L_0x0046:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead."
            r1.<init>(r2)     // Catch:{ all -> 0x004e }
            throw r1     // Catch:{ all -> 0x004e }
        L_0x004e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.h.clear():void");
    }

    public final Drawable d() {
        int i10;
        if (this.f14349u == null) {
            a aVar = this.f14337i;
            Drawable drawable = aVar.f14310n;
            this.f14349u = drawable;
            if (drawable == null && (i10 = aVar.f14311o) > 0) {
                this.f14349u = i(i10);
            }
        }
        return this.f14349u;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f14330b
            monitor-enter(r0)
            boolean r1 = r7.f14353y     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x00c4
            x5.h r1 = r7.f14329a     // Catch:{ all -> 0x00cc }
            r1.a()     // Catch:{ all -> 0x00cc }
            int r1 = w5.i.f16115a     // Catch:{ all -> 0x00cc }
            android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ all -> 0x00cc }
            java.lang.Object r1 = r7.f14335g     // Catch:{ all -> 0x00cc }
            r2 = 3
            if (r1 != 0) goto L_0x004f
            int r1 = r7.f14338j     // Catch:{ all -> 0x00cc }
            int r3 = r7.f14339k     // Catch:{ all -> 0x00cc }
            boolean r1 = w5.p.h(r1, r3)     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x0028
            int r1 = r7.f14338j     // Catch:{ all -> 0x00cc }
            r7.f14351w = r1     // Catch:{ all -> 0x00cc }
            int r1 = r7.f14339k     // Catch:{ all -> 0x00cc }
            r7.f14352x = r1     // Catch:{ all -> 0x00cc }
        L_0x0028:
            android.graphics.drawable.Drawable r1 = r7.f14350v     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x003e
            s5.a r1 = r7.f14337i     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r3 = r1.f14318v     // Catch:{ all -> 0x00cc }
            r7.f14350v = r3     // Catch:{ all -> 0x00cc }
            if (r3 != 0) goto L_0x003e
            int r1 = r1.f14319w     // Catch:{ all -> 0x00cc }
            if (r1 <= 0) goto L_0x003e
            android.graphics.drawable.Drawable r1 = r7.i(r1)     // Catch:{ all -> 0x00cc }
            r7.f14350v = r1     // Catch:{ all -> 0x00cc }
        L_0x003e:
            android.graphics.drawable.Drawable r1 = r7.f14350v     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x0043
            r2 = 5
        L_0x0043:
            d5.i0 r1 = new d5.i0     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = "Received null model"
            r1.<init>(r3)     // Catch:{ all -> 0x00cc }
            r7.k(r1, r2)     // Catch:{ all -> 0x00cc }
            monitor-exit(r0)     // Catch:{ all -> 0x00cc }
            return
        L_0x004f:
            int r1 = r7.A     // Catch:{ all -> 0x00cc }
            r3 = 2
            if (r1 == r3) goto L_0x00bc
            r4 = 0
            r5 = 4
            if (r1 != r5) goto L_0x0061
            d5.o0 r1 = r7.f14345q     // Catch:{ all -> 0x00cc }
            b5.a r2 = b5.a.MEMORY_CACHE     // Catch:{ all -> 0x00cc }
            r7.l(r1, r2, r4)     // Catch:{ all -> 0x00cc }
            monitor-exit(r0)     // Catch:{ all -> 0x00cc }
            return
        L_0x0061:
            java.util.List r1 = r7.f14342n     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x0066
            goto L_0x007e
        L_0x0066:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00cc }
        L_0x006a:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x00cc }
            if (r5 == 0) goto L_0x007e
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x00cc }
            s5.c r5 = (s5.c) r5     // Catch:{ all -> 0x00cc }
            boolean r6 = r5 instanceof s5.c     // Catch:{ all -> 0x00cc }
            if (r6 == 0) goto L_0x006a
            r5.getClass()     // Catch:{ all -> 0x00cc }
            goto L_0x006a
        L_0x007e:
            r7.A = r2     // Catch:{ all -> 0x00cc }
            int r1 = r7.f14338j     // Catch:{ all -> 0x00cc }
            int r5 = r7.f14339k     // Catch:{ all -> 0x00cc }
            boolean r1 = w5.p.h(r1, r5)     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x0092
            int r1 = r7.f14338j     // Catch:{ all -> 0x00cc }
            int r5 = r7.f14339k     // Catch:{ all -> 0x00cc }
            r7.n(r1, r5)     // Catch:{ all -> 0x00cc }
            goto L_0x0097
        L_0x0092:
            t5.g r1 = r7.f14341m     // Catch:{ all -> 0x00cc }
            r1.d(r7)     // Catch:{ all -> 0x00cc }
        L_0x0097:
            int r1 = r7.A     // Catch:{ all -> 0x00cc }
            if (r1 == r3) goto L_0x009d
            if (r1 != r2) goto L_0x00b3
        L_0x009d:
            s5.e r1 = r7.f14332d     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00a7
            boolean r1 = r1.h(r7)     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00a8
        L_0x00a7:
            r4 = 1
        L_0x00a8:
            if (r4 == 0) goto L_0x00b3
            t5.g r1 = r7.f14341m     // Catch:{ all -> 0x00cc }
            android.graphics.drawable.Drawable r2 = r7.d()     // Catch:{ all -> 0x00cc }
            r1.g(r2)     // Catch:{ all -> 0x00cc }
        L_0x00b3:
            boolean r1 = B     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00ba
            android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ all -> 0x00cc }
        L_0x00ba:
            monitor-exit(r0)     // Catch:{ all -> 0x00cc }
            return
        L_0x00bc:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00cc }
            throw r1     // Catch:{ all -> 0x00cc }
        L_0x00c4:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead."
            r1.<init>(r2)     // Catch:{ all -> 0x00cc }
            throw r1     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cc }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.h.e():void");
    }

    public final boolean f(d dVar) {
        int i10;
        int i11;
        Object obj;
        Class cls;
        a aVar;
        j jVar;
        int i12;
        int i13;
        int i14;
        Object obj2;
        Class cls2;
        a aVar2;
        j jVar2;
        int i15;
        boolean z10;
        d dVar2 = dVar;
        if (!(dVar2 instanceof h)) {
            return false;
        }
        synchronized (this.f14330b) {
            i10 = this.f14338j;
            i11 = this.f14339k;
            obj = this.f14335g;
            cls = this.f14336h;
            aVar = this.f14337i;
            jVar = this.f14340l;
            List list = this.f14342n;
            if (list != null) {
                i12 = list.size();
            } else {
                i12 = 0;
            }
        }
        h hVar = (h) dVar2;
        synchronized (hVar.f14330b) {
            i13 = hVar.f14338j;
            i14 = hVar.f14339k;
            obj2 = hVar.f14335g;
            cls2 = hVar.f14336h;
            aVar2 = hVar.f14337i;
            jVar2 = hVar.f14340l;
            List list2 = hVar.f14342n;
            if (list2 != null) {
                i15 = list2.size();
            } else {
                i15 = 0;
            }
        }
        if (i10 == i13 && i11 == i14) {
            char[] cArr = p.f16126a;
            if (obj != null) {
                z10 = obj.equals(obj2);
            } else if (obj2 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 || !cls.equals(cls2) || !aVar.equals(aVar2) || jVar != jVar2 || i12 != i15) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void g() {
        synchronized (this.f14330b) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public final boolean h() {
        e eVar = this.f14332d;
        return eVar == null || !eVar.c().a();
    }

    public final Drawable i(int i10) {
        Resources.Theme theme = this.f14337i.B;
        Context context = this.f14333e;
        if (theme == null) {
            theme = context.getTheme();
        }
        return b.a(context, context, i10, theme);
    }

    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f14330b) {
            int i10 = this.A;
            if (i10 != 2) {
                if (i10 != 3) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public final boolean j() {
        boolean z10;
        synchronized (this.f14330b) {
            z10 = this.A == 4;
        }
        return z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088 A[Catch:{ all -> 0x0095 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(d5.i0 r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Load failed for ["
            x5.h r1 = r5.f14329a
            r1.a()
            java.lang.Object r1 = r5.f14330b
            monitor-enter(r1)
            r6.getClass()     // Catch:{ all -> 0x00e2 }
            com.bumptech.glide.h r2 = r5.f14334f     // Catch:{ all -> 0x00e2 }
            int r2 = r2.f3196i     // Catch:{ all -> 0x00e2 }
            if (r2 > r7) goto L_0x0045
            java.lang.String r7 = "Glide"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r3.<init>(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.Object r0 = r5.f14335g     // Catch:{ all -> 0x00e2 }
            r3.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "] with dimensions ["
            r3.append(r0)     // Catch:{ all -> 0x00e2 }
            int r0 = r5.f14351w     // Catch:{ all -> 0x00e2 }
            r3.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "x"
            r3.append(r0)     // Catch:{ all -> 0x00e2 }
            int r0 = r5.f14352x     // Catch:{ all -> 0x00e2 }
            r3.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = "]"
            r3.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00e2 }
            android.util.Log.w(r7, r0, r6)     // Catch:{ all -> 0x00e2 }
            r7 = 4
            if (r2 > r7) goto L_0x0045
            r6.e()     // Catch:{ all -> 0x00e2 }
        L_0x0045:
            r6 = 0
            r5.f14346r = r6     // Catch:{ all -> 0x00e2 }
            r7 = 5
            r5.A = r7     // Catch:{ all -> 0x00e2 }
            s5.e r7 = r5.f14332d     // Catch:{ all -> 0x00e2 }
            if (r7 == 0) goto L_0x0052
            r7.l(r5)     // Catch:{ all -> 0x00e2 }
        L_0x0052:
            r7 = 1
            r5.f14353y = r7     // Catch:{ all -> 0x00e2 }
            r0 = 0
            java.util.List r2 = r5.f14342n     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0074
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0095 }
            r3 = 0
        L_0x005f:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x0075
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0095 }
            s5.c r4 = (s5.c) r4     // Catch:{ all -> 0x0095 }
            r5.h()     // Catch:{ all -> 0x0095 }
            boolean r4 = r4.a()     // Catch:{ all -> 0x0095 }
            r3 = r3 | r4
            goto L_0x005f
        L_0x0074:
            r3 = 0
        L_0x0075:
            s5.c r2 = r5.f14331c     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0084
            r5.h()     // Catch:{ all -> 0x0095 }
            boolean r2 = r2.a()     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0084
            r2 = 1
            goto L_0x0085
        L_0x0084:
            r2 = 0
        L_0x0085:
            r2 = r2 | r3
            if (r2 != 0) goto L_0x00db
            s5.e r2 = r5.f14332d     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0097
            boolean r2 = r2.h(r5)     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x0093
            goto L_0x0097
        L_0x0093:
            r7 = 0
            goto L_0x0097
        L_0x0095:
            r6 = move-exception
            goto L_0x00df
        L_0x0097:
            if (r7 != 0) goto L_0x009a
            goto L_0x00db
        L_0x009a:
            java.lang.Object r7 = r5.f14335g     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x00b6
            android.graphics.drawable.Drawable r6 = r5.f14350v     // Catch:{ all -> 0x0095 }
            if (r6 != 0) goto L_0x00b4
            s5.a r6 = r5.f14337i     // Catch:{ all -> 0x0095 }
            android.graphics.drawable.Drawable r7 = r6.f14318v     // Catch:{ all -> 0x0095 }
            r5.f14350v = r7     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x00b4
            int r6 = r6.f14319w     // Catch:{ all -> 0x0095 }
            if (r6 <= 0) goto L_0x00b4
            android.graphics.drawable.Drawable r6 = r5.i(r6)     // Catch:{ all -> 0x0095 }
            r5.f14350v = r6     // Catch:{ all -> 0x0095 }
        L_0x00b4:
            android.graphics.drawable.Drawable r6 = r5.f14350v     // Catch:{ all -> 0x0095 }
        L_0x00b6:
            if (r6 != 0) goto L_0x00d0
            android.graphics.drawable.Drawable r6 = r5.f14348t     // Catch:{ all -> 0x0095 }
            if (r6 != 0) goto L_0x00ce
            s5.a r6 = r5.f14337i     // Catch:{ all -> 0x0095 }
            android.graphics.drawable.Drawable r7 = r6.f14308l     // Catch:{ all -> 0x0095 }
            r5.f14348t = r7     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x00ce
            int r6 = r6.f14309m     // Catch:{ all -> 0x0095 }
            if (r6 <= 0) goto L_0x00ce
            android.graphics.drawable.Drawable r6 = r5.i(r6)     // Catch:{ all -> 0x0095 }
            r5.f14348t = r6     // Catch:{ all -> 0x0095 }
        L_0x00ce:
            android.graphics.drawable.Drawable r6 = r5.f14348t     // Catch:{ all -> 0x0095 }
        L_0x00d0:
            if (r6 != 0) goto L_0x00d6
            android.graphics.drawable.Drawable r6 = r5.d()     // Catch:{ all -> 0x0095 }
        L_0x00d6:
            t5.g r7 = r5.f14341m     // Catch:{ all -> 0x0095 }
            r7.b(r6)     // Catch:{ all -> 0x0095 }
        L_0x00db:
            r5.f14353y = r0     // Catch:{ all -> 0x00e2 }
            monitor-exit(r1)     // Catch:{ all -> 0x00e2 }
            return
        L_0x00df:
            r5.f14353y = r0     // Catch:{ all -> 0x00e2 }
            throw r6     // Catch:{ all -> 0x00e2 }
        L_0x00e2:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e2 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.h.k(d5.i0, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        r7.f14347s.getClass();
        d5.w.f(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(d5.o0 r8, b5.a r9, boolean r10) {
        /*
            r7 = this;
            java.lang.String r10 = "Expected to receive an object of "
            java.lang.String r0 = "Expected to receive a Resource<R> with an object of "
            x5.h r1 = r7.f14329a
            r1.a()
            r1 = 0
            java.lang.Object r2 = r7.f14330b     // Catch:{ all -> 0x00c1 }
            monitor-enter(r2)     // Catch:{ all -> 0x00c1 }
            r7.f14346r = r1     // Catch:{ all -> 0x00b3 }
            r3 = 5
            if (r8 != 0) goto L_0x002f
            d5.i0 r8 = new d5.i0     // Catch:{ all -> 0x00b3 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r9.<init>(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.Class r10 = r7.f14336h     // Catch:{ all -> 0x00b3 }
            r9.append(r10)     // Catch:{ all -> 0x00b3 }
            java.lang.String r10 = " inside, but instead got null."
            r9.append(r10)     // Catch:{ all -> 0x00b3 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00b3 }
            r8.<init>(r9)     // Catch:{ all -> 0x00b3 }
            r7.k(r8, r3)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b3 }
            return
        L_0x002f:
            java.lang.Object r0 = r8.get()     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0066
            java.lang.Class r4 = r7.f14336h     // Catch:{ all -> 0x00b3 }
            java.lang.Class r5 = r0.getClass()     // Catch:{ all -> 0x00b3 }
            boolean r4 = r4.isAssignableFrom(r5)     // Catch:{ all -> 0x00b3 }
            if (r4 != 0) goto L_0x0042
            goto L_0x0066
        L_0x0042:
            s5.e r10 = r7.f14332d     // Catch:{ all -> 0x00b3 }
            if (r10 == 0) goto L_0x004f
            boolean r10 = r10.k(r7)     // Catch:{ all -> 0x00b3 }
            if (r10 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r10 = 0
            goto L_0x0050
        L_0x004f:
            r10 = 1
        L_0x0050:
            if (r10 != 0) goto L_0x0061
            r7.f14345q = r1     // Catch:{ all -> 0x00af }
            r9 = 4
            r7.A = r9     // Catch:{ all -> 0x00af }
        L_0x0057:
            monitor-exit(r2)     // Catch:{ all -> 0x00af }
            d5.w r9 = r7.f14347s
            r9.getClass()
            d5.w.f(r8)
            return
        L_0x0061:
            r7.m(r8, r0, r9)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b3 }
            return
        L_0x0066:
            r7.f14345q = r1     // Catch:{ all -> 0x00af }
            d5.i0 r9 = new d5.i0     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>(r10)     // Catch:{ all -> 0x00af }
            java.lang.Class r10 = r7.f14336h     // Catch:{ all -> 0x00af }
            r1.append(r10)     // Catch:{ all -> 0x00af }
            java.lang.String r10 = " but instead got "
            r1.append(r10)     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x0080
            java.lang.Class r10 = r0.getClass()     // Catch:{ all -> 0x00af }
            goto L_0x0082
        L_0x0080:
            java.lang.String r10 = ""
        L_0x0082:
            r1.append(r10)     // Catch:{ all -> 0x00af }
            java.lang.String r10 = "{"
            r1.append(r10)     // Catch:{ all -> 0x00af }
            r1.append(r0)     // Catch:{ all -> 0x00af }
            java.lang.String r10 = "} inside Resource{"
            r1.append(r10)     // Catch:{ all -> 0x00af }
            r1.append(r8)     // Catch:{ all -> 0x00af }
            java.lang.String r10 = "}."
            r1.append(r10)     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x009f
            java.lang.String r10 = ""
            goto L_0x00a1
        L_0x009f:
            java.lang.String r10 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L_0x00a1:
            r1.append(r10)     // Catch:{ all -> 0x00af }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x00af }
            r9.<init>(r10)     // Catch:{ all -> 0x00af }
            r7.k(r9, r3)     // Catch:{ all -> 0x00af }
            goto L_0x0057
        L_0x00af:
            r9 = move-exception
            r1 = r8
            r8 = r7
            goto L_0x00b8
        L_0x00b3:
            r8 = move-exception
            r9 = r7
        L_0x00b5:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x00b8:
            monitor-exit(r2)     // Catch:{ all -> 0x00bc }
            throw r9     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r9 = move-exception
            goto L_0x00c3
        L_0x00bc:
            r9 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x00b5
        L_0x00c1:
            r9 = move-exception
            r8 = r7
        L_0x00c3:
            if (r1 == 0) goto L_0x00cd
            d5.w r8 = r8.f14347s
            r8.getClass()
            d5.w.f(r1)
        L_0x00cd:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.h.l(d5.o0, b5.a, boolean):void");
    }

    public final void m(o0 o0Var, Object obj, a aVar) {
        boolean z10;
        h();
        this.A = 4;
        this.f14345q = o0Var;
        if (this.f14334f.f3196i <= 3) {
            Objects.toString(aVar);
            Objects.toString(this.f14335g);
            int i10 = i.f16115a;
            SystemClock.elapsedRealtimeNanos();
        }
        e eVar = this.f14332d;
        if (eVar != null) {
            eVar.i(this);
        }
        boolean z11 = true;
        this.f14353y = true;
        try {
            List<c> list = this.f14342n;
            if (list != null) {
                z10 = false;
                for (c b10 : list) {
                    z10 |= b10.b();
                }
            } else {
                z10 = false;
            }
            c cVar = this.f14331c;
            if (cVar == null || !cVar.b()) {
                z11 = false;
            }
            if (!z11 && !z10) {
                this.f14341m.f(obj, this.f14343o.a(aVar));
            }
        } finally {
            this.f14353y = false;
        }
    }

    public final void n(int i10, int i11) {
        Object obj;
        int i12;
        u a10;
        int i13 = i10;
        int i14 = i11;
        this.f14329a.a();
        Object obj2 = this.f14330b;
        synchronized (obj2) {
            try {
                boolean z10 = B;
                if (z10) {
                    int i15 = i.f16115a;
                    SystemClock.elapsedRealtimeNanos();
                }
                if (this.A == 3) {
                    this.A = 2;
                    float f10 = this.f14337i.f14305i;
                    if (i13 != Integer.MIN_VALUE) {
                        i13 = Math.round(((float) i13) * f10);
                    }
                    this.f14351w = i13;
                    if (i14 == Integer.MIN_VALUE) {
                        i12 = i14;
                    } else {
                        i12 = Math.round(f10 * ((float) i14));
                    }
                    this.f14352x = i12;
                    if (z10) {
                        int i16 = i.f16115a;
                        SystemClock.elapsedRealtimeNanos();
                    }
                    w wVar = this.f14347s;
                    com.bumptech.glide.h hVar = this.f14334f;
                    Object obj3 = this.f14335g;
                    a aVar = this.f14337i;
                    b5.j jVar = aVar.f14315s;
                    int i17 = this.f14351w;
                    int i18 = this.f14352x;
                    Class cls = aVar.f14322z;
                    Class cls2 = this.f14336h;
                    j jVar2 = this.f14340l;
                    d5.u uVar = aVar.f14306j;
                    w5.b bVar = aVar.f14321y;
                    boolean z11 = aVar.f14316t;
                    boolean z12 = aVar.F;
                    n nVar = aVar.f14320x;
                    Object obj4 = obj2;
                    try {
                        boolean z13 = aVar.f14312p;
                        boolean z14 = aVar.D;
                        boolean z15 = aVar.G;
                        n nVar2 = nVar;
                        obj = obj4;
                        try {
                            a10 = wVar.a(hVar, obj3, jVar, i17, i18, cls, cls2, jVar2, uVar, bVar, z11, z12, nVar2, z13, z14, z15, aVar.E, this, this.f14344p);
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            throw th;
                        }
                        try {
                            this.f14346r = a10;
                            if (this.A != 2) {
                                this.f14346r = null;
                            }
                            if (z10) {
                                int i19 = i.f16115a;
                                SystemClock.elapsedRealtimeNanos();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            while (true) {
                                break;
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = obj4;
                        while (true) {
                            break;
                        }
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                obj = obj2;
                while (true) {
                    break;
                }
                throw th;
            }
        }
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.f14330b) {
            obj = this.f14335g;
            cls = this.f14336h;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
