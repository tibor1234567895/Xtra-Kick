package h3;

import a2.g;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.emoji2.text.r;
import d9.r0;
import e1.c0;
import j0.h;
import j1.a;
import j1.l0;
import j1.v;
import q.e;

public abstract class b3 extends Service {

    /* renamed from: o  reason: collision with root package name */
    public static final /* synthetic */ int f6933o = 0;

    /* renamed from: h  reason: collision with root package name */
    public final Object f6934h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public final Handler f6935i = new Handler(Looper.getMainLooper());

    /* renamed from: j  reason: collision with root package name */
    public final e f6936j = new e();

    /* renamed from: k  reason: collision with root package name */
    public a3 f6937k;

    /* renamed from: l  reason: collision with root package name */
    public y1 f6938l;

    /* renamed from: m  reason: collision with root package name */
    public l f6939m;

    /* renamed from: n  reason: collision with root package name */
    public h f6940n;

    public final void a(g2 g2Var) {
        g2 g2Var2;
        boolean z10 = true;
        a.a("session is already released", !g2Var.f7047a.f());
        synchronized (this.f6934h) {
            g2Var2 = (g2) this.f6936j.getOrDefault(g2Var.f7047a.f7235h, (Object) null);
            if (g2Var2 != null) {
                if (g2Var2 != g2Var) {
                    z10 = false;
                }
            }
            a.a("Session ID should be unique", z10);
            this.f6936j.put(g2Var.f7047a.f7235h, g2Var);
        }
        if (g2Var2 == null) {
            l0.L(this.f6935i, new r(this, d(), g2Var, 14));
        }
    }

    public final h b() {
        h hVar;
        synchronized (this.f6934h) {
            if (this.f6940n == null) {
                this.f6940n = new h((Service) this);
            }
            hVar = this.f6940n;
        }
        return hVar;
    }

    public final y1 d() {
        y1 y1Var;
        synchronized (this.f6934h) {
            if (this.f6938l == null) {
                if (this.f6939m == null) {
                    g gVar = new g(getApplicationContext());
                    a.e(!gVar.f31c);
                    l lVar = new l(gVar);
                    gVar.f31c = true;
                    this.f6939m = lVar;
                }
                this.f6938l = new y1(this, this.f6939m, b());
            }
            y1Var = this.f6938l;
        }
        return y1Var;
    }

    public abstract g2 e(e2 e2Var);

    public final void f(g2 g2Var, boolean z10) {
        boolean containsKey;
        boolean z11;
        y1 d10 = d();
        b3 b3Var = d10.f7479a;
        synchronized (b3Var.f6934h) {
            containsKey = b3Var.f6936j.containsKey(g2Var.f7047a.f7235h);
        }
        if (containsKey) {
            b0 a10 = d10.a(g2Var);
            if (a10 == null || a10.j0().y() || a10.b() == 1) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                int i10 = d10.f7487i + 1;
                d10.f7487i = i10;
                r0 r0Var = (r0) d10.f7486h.get(g2Var);
                a.f(r0Var);
                l0.L(new Handler(g2Var.b().N0()), new s1(d10, g2Var, r0Var, new n1.h(d10, i10, g2Var), z10));
                return;
            }
        }
        d10.b(true);
    }

    public final boolean g(g2 g2Var, boolean z10) {
        try {
            f(g2Var, d().c(g2Var, z10));
            return true;
        } catch (IllegalStateException e10) {
            if (l0.f8453a < 31 || !y2.a(e10)) {
                throw e10;
            }
            v.d("MSSImpl", "Failed to start foreground", e10);
            this.f6935i.post(new androidx.activity.e(15, this));
            return false;
        }
    }

    public final void h(g2 g2Var) {
        if (g2Var != null) {
            synchronized (this.f6934h) {
                a.a("session not found", this.f6936j.containsKey(g2Var.f7047a.f7235h));
                this.f6936j.remove(g2Var.f7047a.f7235h);
            }
            l0.L(this.f6935i, new g.r0(d(), 26, g2Var));
            return;
        }
        throw new NullPointerException("session must not be null");
    }

    public final IBinder onBind(Intent intent) {
        String action;
        a3 a3Var;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        if (action.equals("androidx.media3.session.MediaSessionService")) {
            synchronized (this.f6934h) {
                a3Var = this.f6937k;
                a.f(a3Var);
            }
            return a3Var;
        } else if (!action.equals("android.media.browse.MediaBrowserService")) {
            return null;
        } else {
            c0 c0Var = new c0("android.media.session.MediaController", -1, -1);
            Bundle bundle = Bundle.EMPTY;
            g2 e10 = e(new e2(c0Var, 0, false, (d2) null));
            if (e10 == null) {
                return null;
            }
            a(e10);
            return e10.a();
        }
    }

    public void onCreate() {
        super.onCreate();
        synchronized (this.f6934h) {
            this.f6937k = new a3(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        synchronized (this.f6934h) {
            a3 a3Var = this.f6937k;
            if (a3Var != null) {
                a3Var.f6915d.clear();
                a3Var.f6916e.removeCallbacksAndMessages((Object) null);
                for (o g10 : a3Var.f6918g) {
                    try {
                        g10.g(0);
                    } catch (RemoteException unused) {
                    }
                }
                this.f6937k = null;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.view.KeyEvent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.view.KeyEvent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.view.KeyEvent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: android.view.KeyEvent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: android.view.KeyEvent} */
    /* JADX WARNING: type inference failed for: r11v11, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int onStartCommand(android.content.Intent r11, int r12, int r13) {
        /*
            r10 = this;
            r12 = 1
            if (r11 != 0) goto L_0x0004
            return r12
        L_0x0004:
            j0.h r13 = r10.b()
            android.net.Uri r0 = r11.getData()
            r1 = 0
            if (r0 == 0) goto L_0x003b
            java.lang.Object r2 = h3.g2.f7045b
            monitor-enter(r2)
            java.util.HashMap r3 = h3.g2.f7046c     // Catch:{ all -> 0x0038 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x0038 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0038 }
        L_0x001c:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x0034
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0038 }
            h3.g2 r4 = (h3.g2) r4     // Catch:{ all -> 0x0038 }
            h3.n2 r5 = r4.f7047a     // Catch:{ all -> 0x0038 }
            android.net.Uri r5 = r5.f7229b     // Catch:{ all -> 0x0038 }
            boolean r5 = j1.l0.a(r5, r0)     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x001c
            monitor-exit(r2)     // Catch:{ all -> 0x0038 }
            goto L_0x0036
        L_0x0034:
            monitor-exit(r2)     // Catch:{ all -> 0x0038 }
            r4 = r1
        L_0x0036:
            r5 = r4
            goto L_0x003c
        L_0x0038:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0038 }
            throw r11
        L_0x003b:
            r5 = r1
        L_0x003c:
            r13.getClass()
            java.lang.String r13 = "android.intent.action.MEDIA_BUTTON"
            java.lang.String r0 = r11.getAction()
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x008d
            if (r5 != 0) goto L_0x0067
            e1.c0 r13 = new e1.c0
            java.lang.String r0 = "android.media.session.MediaController"
            r2 = -1
            r13.<init>(r0, r2, r2)
            h3.e2 r0 = new h3.e2
            android.os.Bundle r2 = android.os.Bundle.EMPTY
            r2 = 0
            r0.<init>(r13, r2, r2, r1)
            h3.g2 r5 = r10.e(r0)
            if (r5 != 0) goto L_0x0064
            return r12
        L_0x0064:
            r10.a(r5)
        L_0x0067:
            android.os.Bundle r11 = r11.getExtras()
            if (r11 == 0) goto L_0x007c
            java.lang.String r13 = "android.intent.extra.KEY_EVENT"
            boolean r0 = r11.containsKey(r13)
            if (r0 == 0) goto L_0x007c
            android.os.Parcelable r11 = r11.getParcelable(r13)
            r1 = r11
            android.view.KeyEvent r1 = (android.view.KeyEvent) r1
        L_0x007c:
            if (r1 == 0) goto L_0x00ee
            h3.n2 r11 = r5.f7047a
            h3.x2 r11 = r11.f7234g
            android.support.v4.media.session.u r11 = r11.f7442l
            java.lang.Object r11 = r11.f429j
            android.support.v4.media.session.u r11 = (android.support.v4.media.session.u) r11
            r11.o(r1)
            goto L_0x00ee
        L_0x008d:
            if (r5 == 0) goto L_0x00ee
            java.lang.String r13 = "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION"
            java.lang.String r0 = r11.getAction()
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x00ee
            android.os.Bundle r13 = r11.getExtras()
            if (r13 == 0) goto L_0x00a8
            java.lang.String r0 = "androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION"
            java.lang.Object r13 = r13.get(r0)
            goto L_0x00a9
        L_0x00a8:
            r13 = r1
        L_0x00a9:
            boolean r0 = r13 instanceof java.lang.String
            if (r0 == 0) goto L_0x00b1
            java.lang.String r13 = (java.lang.String) r13
            r6 = r13
            goto L_0x00b2
        L_0x00b1:
            r6 = r1
        L_0x00b2:
            if (r6 != 0) goto L_0x00b5
            return r12
        L_0x00b5:
            android.os.Bundle r11 = r11.getExtras()
            if (r11 == 0) goto L_0x00c1
            java.lang.String r13 = "androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS"
            java.lang.Object r1 = r11.get(r13)
        L_0x00c1:
            boolean r11 = r1 instanceof android.os.Bundle
            if (r11 == 0) goto L_0x00c9
            android.os.Bundle r1 = (android.os.Bundle) r1
            r7 = r1
            goto L_0x00cc
        L_0x00c9:
            android.os.Bundle r11 = android.os.Bundle.EMPTY
            r7 = r11
        L_0x00cc:
            h3.y1 r4 = r10.d()
            h3.b0 r8 = r4.a(r5)
            if (r8 != 0) goto L_0x00d7
            goto L_0x00ee
        L_0x00d7:
            android.os.Handler r11 = new android.os.Handler
            g1.k1 r13 = r5.b()
            android.os.Looper r13 = r13.N0()
            r11.<init>(r13)
            h3.e r13 = new h3.e
            r9 = 1
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)
            j1.l0.L(r11, r13)
        L_0x00ee:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.b3.onStartCommand(android.content.Intent, int, int):int");
    }
}
