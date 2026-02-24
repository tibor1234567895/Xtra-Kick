package h3;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import e.a;
import g.r0;
import g1.k1;
import h9.e0;
import h9.k0;
import h9.z;
import j1.l0;
import j1.v;
import java.util.List;
import java.util.concurrent.ExecutionException;
import p0.c;

public class n2 {

    /* renamed from: w  reason: collision with root package name */
    public static final Object f7225w = new Object();

    /* renamed from: x  reason: collision with root package name */
    public static boolean f7226x = false;

    /* renamed from: y  reason: collision with root package name */
    public static ComponentName f7227y;

    /* renamed from: a  reason: collision with root package name */
    public final Object f7228a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Uri f7229b;

    /* renamed from: c  reason: collision with root package name */
    public final j2 f7230c;

    /* renamed from: d  reason: collision with root package name */
    public final b2 f7231d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f7232e;

    /* renamed from: f  reason: collision with root package name */
    public final s3 f7233f;

    /* renamed from: g  reason: collision with root package name */
    public final x2 f7234g;

    /* renamed from: h  reason: collision with root package name */
    public final String f7235h;

    /* renamed from: i  reason: collision with root package name */
    public final l4 f7236i;

    /* renamed from: j  reason: collision with root package name */
    public final g2 f7237j;

    /* renamed from: k  reason: collision with root package name */
    public final PendingIntent f7238k;

    /* renamed from: l  reason: collision with root package name */
    public final Handler f7239l;

    /* renamed from: m  reason: collision with root package name */
    public final a f7240m;

    /* renamed from: n  reason: collision with root package name */
    public final h2 f7241n;

    /* renamed from: o  reason: collision with root package name */
    public final Handler f7242o;

    /* renamed from: p  reason: collision with root package name */
    public l2 f7243p;

    /* renamed from: q  reason: collision with root package name */
    public a f7244q;

    /* renamed from: r  reason: collision with root package name */
    public w3 f7245r;

    /* renamed from: s  reason: collision with root package name */
    public a4 f7246s;

    /* renamed from: t  reason: collision with root package name */
    public c3 f7247t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f7248u;

    /* renamed from: v  reason: collision with root package name */
    public final long f7249v;

    static {
        new j4(1);
    }

    public n2(g2 g2Var, Context context, String str, k1 k1Var, PendingIntent pendingIntent, b2 b2Var, Bundle bundle, a aVar) {
        this.f7232e = context;
        this.f7237j = g2Var;
        s3 s3Var = new s3(this);
        this.f7233f = s3Var;
        this.f7238k = pendingIntent;
        this.f7242o = new Handler(Looper.getMainLooper());
        Handler handler = new Handler(k1Var.N0());
        this.f7239l = handler;
        this.f7231d = b2Var;
        this.f7240m = aVar;
        this.f7245r = w3.L;
        this.f7230c = new j2(this, k1Var.N0());
        this.f7235h = str;
        Uri build = new Uri.Builder().scheme(n2.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.f7229b = build;
        this.f7236i = new l4(Process.myUid(), 1000002300, 1, context.getPackageName(), s3Var, bundle);
        synchronized (f7225w) {
            if (!f7226x) {
                ComponentName e10 = e(context, "androidx.media3.session.MediaLibraryService");
                f7227y = e10;
                if (e10 == null) {
                    f7227y = e(context, "androidx.media3.session.MediaSessionService");
                }
                f7226x = true;
            }
        }
        this.f7234g = new x2(this, build, f7227y, handler);
        a4 a4Var = new a4(k1Var);
        this.f7246s = a4Var;
        l0.L(handler, new r0(this, 23, a4Var));
        this.f7249v = 3000;
        this.f7241n = new h2(this, 0);
        l0.L(handler, new h2(this, 1));
    }

    public static void a(n2 n2Var) {
        if (Looper.myLooper() != n2Var.f7239l.getLooper()) {
            throw new IllegalStateException("Player callback method is called from a wrong thread. See javadoc of MediaSession for details.");
        }
    }

    public static ComponentName e(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    public final void b(c cVar) {
        try {
            cVar.i(this.f7234g.f7439i, 0);
        } catch (RemoteException e10) {
            v.d("MSImplBase", "Exception in using media1 API", e10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(h3.e2 r4, h3.m2 r5) {
        /*
            r3 = this;
            h3.s3 r0 = r3.f7233f
            h3.g r1 = r0.f7319f     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            h3.e4 r1 = r1.f(r4)     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            if (r1 == 0) goto L_0x000f
            int r1 = r1.a()     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            goto L_0x002a
        L_0x000f:
            h3.g r1 = r0.f7319f     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            boolean r1 = r1.g(r4)     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            r2 = 0
            if (r1 != 0) goto L_0x0025
            h3.x2 r1 = r3.f7234g     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            h3.g r1 = r1.f7436f     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            boolean r1 = r1.g(r4)     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            if (r1 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r1 = 0
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            if (r1 != 0) goto L_0x0029
            return
        L_0x0029:
            r1 = 0
        L_0x002a:
            h3.d2 r2 = r4.f6998c     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            if (r2 == 0) goto L_0x0050
            r5.i(r2, r1)     // Catch:{ DeadObjectException -> 0x004b, RemoteException -> 0x0032 }
            goto L_0x0050
        L_0x0032:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Exception in "
            r0.<init>(r1)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "MSImplBase"
            j1.v.h(r0, r4, r5)
            goto L_0x0050
        L_0x004b:
            h3.g r5 = r0.f7319f
            r5.k(r4)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.n2.c(h3.e2, h3.m2):void");
    }

    public final void d(m2 m2Var) {
        d9.r0 d10 = this.f7233f.f7319f.d();
        for (int i10 = 0; i10 < d10.size(); i10++) {
            c((e2) d10.get(i10), m2Var);
        }
        try {
            m2Var.i(this.f7234g.f7439i, 0);
        } catch (RemoteException e10) {
            v.d("MSImplBase", "Exception in using media1 API", e10);
        }
    }

    public final boolean f() {
        boolean z10;
        synchronized (this.f7228a) {
            z10 = this.f7248u;
        }
        return z10;
    }

    public final e0 g(e2 e2Var, List list) {
        z i10 = this.f7231d.i(this.f7237j, e2Var, list);
        j1.a.d(i10, "onAddMediaItems must return a non-null future");
        return i10;
    }

    public final boolean h() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            k0 n10 = k0.n();
            this.f7242o.post(new r0(this, 24, n10));
            try {
                return ((Boolean) n10.get()).booleanValue();
            } catch (InterruptedException | ExecutionException e10) {
                throw new IllegalStateException(e10);
            }
        } else {
            a aVar = this.f7244q;
            if (aVar == null) {
                return true;
            }
            aVar.getClass();
            int i10 = l0.f8453a;
            if (i10 < 31 || i10 >= 33) {
                return true;
            }
            int i11 = b3.f6933o;
            if (!((b3) aVar.f4852i).d().f7489k) {
                return ((b3) aVar.f4852i).g(this.f7237j, true);
            }
            return true;
        }
    }

    public final e0 i(e2 e2Var, List list, int i10, long j10) {
        k0 d10 = this.f7231d.d(this.f7237j, e2Var, list, i10, j10);
        j1.a.d(d10, "onSetMediaItems must return a non-null future");
        return d10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        j1.l0.L(r4.f7239l, new h3.h2(r4, 2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        j1.v.h("MSImplBase", "Exception thrown while closing", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r4.f7239l.removeCallbacksAndMessages((java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f7228a
            monitor-enter(r0)
            boolean r1 = r4.f7248u     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            return
        L_0x0009:
            r1 = 1
            r4.f7248u = r1     // Catch:{ all -> 0x0083 }
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            android.os.Handler r0 = r4.f7239l
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            android.os.Handler r0 = r4.f7239l     // Catch:{ Exception -> 0x001f }
            h3.h2 r2 = new h3.h2     // Catch:{ Exception -> 0x001f }
            r3 = 2
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x001f }
            j1.l0.L(r0, r2)     // Catch:{ Exception -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            java.lang.String r2 = "MSImplBase"
            java.lang.String r3 = "Exception thrown while closing"
            j1.v.h(r2, r3, r0)
        L_0x0027:
            h3.x2 r0 = r4.f7234g
            boolean r2 = r0.f7445o
            android.support.v4.media.session.u r3 = r0.f7442l
            if (r2 != 0) goto L_0x0036
            java.lang.Object r2 = r3.f428i
            android.support.v4.media.session.z r2 = (android.support.v4.media.session.z) r2
            r2.s(r1)
        L_0x0036:
            g.g0 r1 = r0.f7444n
            if (r1 == 0) goto L_0x0041
            h3.n2 r0 = r0.f7437g
            android.content.Context r0 = r0.f7232e
            r0.unregisterReceiver(r1)
        L_0x0041:
            r3.I()
            h3.s3 r0 = r4.f7233f
            h3.g r1 = r0.f7319f
            d9.r0 r1 = r1.d()
            java.util.Iterator r1 = r1.iterator()
        L_0x0050:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r1.next()
            h3.e2 r2 = (h3.e2) r2
            h3.d2 r2 = r2.f6998c
            if (r2 == 0) goto L_0x0050
            r2.b()     // Catch:{ RemoteException -> 0x0064 }
            goto L_0x0050
        L_0x0064:
            goto L_0x0050
        L_0x0066:
            java.util.Set r0 = r0.f7320g
            java.util.Iterator r0 = r0.iterator()
        L_0x006c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0082
            java.lang.Object r1 = r0.next()
            h3.e2 r1 = (h3.e2) r1
            h3.d2 r1 = r1.f6998c
            if (r1 == 0) goto L_0x006c
            r1.b()     // Catch:{ RemoteException -> 0x0080 }
            goto L_0x006c
        L_0x0080:
            goto L_0x006c
        L_0x0082:
            return
        L_0x0083:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0083 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.n2.j():void");
    }

    public final void k() {
        Handler handler = this.f7239l;
        h2 h2Var = this.f7241n;
        handler.removeCallbacks(h2Var);
        long j10 = this.f7249v;
        if (j10 <= 0) {
            return;
        }
        if (this.f7246s.I() || this.f7246s.c()) {
            handler.postDelayed(h2Var, j10);
        }
    }
}
