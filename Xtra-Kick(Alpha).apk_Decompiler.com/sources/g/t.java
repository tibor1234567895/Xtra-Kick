package g;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppLocalesMetadataHolderService;
import i0.i;
import i0.l;
import java.lang.ref.WeakReference;
import java.util.Objects;
import q.a;
import q.f;

public abstract class t {

    /* renamed from: h  reason: collision with root package name */
    public static final s0 f6208h = new s0(new t0(), 0);

    /* renamed from: i  reason: collision with root package name */
    public static final int f6209i = -100;

    /* renamed from: j  reason: collision with root package name */
    public static i f6210j = null;

    /* renamed from: k  reason: collision with root package name */
    public static i f6211k = null;

    /* renamed from: l  reason: collision with root package name */
    public static Boolean f6212l = null;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f6213m = false;

    /* renamed from: n  reason: collision with root package name */
    public static final f f6214n = new f();

    /* renamed from: o  reason: collision with root package name */
    public static final Object f6215o = new Object();

    /* renamed from: p  reason: collision with root package name */
    public static final Object f6216p = new Object();

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void C(android.content.Context r3) {
        /*
            boolean r0 = n(r3)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 < r1) goto L_0x001d
            boolean r0 = f6213m
            if (r0 != 0) goto L_0x0055
            g.s0 r0 = f6208h
            g.q r1 = new g.q
            r2 = 1
            r1.<init>(r3, r2)
            r0.execute(r1)
            goto L_0x0055
        L_0x001d:
            java.lang.Object r0 = f6216p
            monitor-enter(r0)
            i0.i r1 = f6210j     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0041
            i0.i r1 = f6211k     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0032
            java.lang.String r3 = g.u0.b(r3)     // Catch:{ all -> 0x0056 }
            i0.i r3 = i0.i.b(r3)     // Catch:{ all -> 0x0056 }
            f6211k = r3     // Catch:{ all -> 0x0056 }
        L_0x0032:
            i0.i r3 = f6211k     // Catch:{ all -> 0x0056 }
            boolean r3 = r3.d()     // Catch:{ all -> 0x0056 }
            if (r3 == 0) goto L_0x003c
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x003c:
            i0.i r3 = f6211k     // Catch:{ all -> 0x0056 }
            f6210j = r3     // Catch:{ all -> 0x0056 }
            goto L_0x0054
        L_0x0041:
            i0.i r2 = f6211k     // Catch:{ all -> 0x0056 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0054
            i0.i r1 = f6210j     // Catch:{ all -> 0x0056 }
            f6211k = r1     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = r1.e()     // Catch:{ all -> 0x0056 }
            g.u0.a(r3, r1)     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
        L_0x0055:
            return
        L_0x0056:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g.t.C(android.content.Context):void");
    }

    public static i f() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object i10 = i();
            if (i10 != null) {
                return new i(new l(s.a(i10)));
            }
        } else {
            i iVar = f6210j;
            if (iVar != null) {
                return iVar;
            }
        }
        return i.f7946b;
    }

    public static Object i() {
        Context g10;
        f fVar = f6214n;
        fVar.getClass();
        a aVar = new a(fVar);
        while (aVar.hasNext()) {
            t tVar = (t) ((WeakReference) aVar.next()).get();
            if (tVar != null && (g10 = tVar.g()) != null) {
                return g10.getSystemService("locale");
            }
        }
        return null;
    }

    public static boolean n(Context context) {
        int i10;
        if (f6212l == null) {
            try {
                int i11 = AppLocalesMetadataHolderService.f545h;
                if (Build.VERSION.SDK_INT >= 24) {
                    i10 = q0.a() | 128;
                } else {
                    i10 = 640;
                }
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), i10).metaData;
                if (bundle != null) {
                    f6212l = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f6212l = Boolean.FALSE;
            }
        }
        return f6212l.booleanValue();
    }

    public static void u(t tVar) {
        synchronized (f6215o) {
            f fVar = f6214n;
            fVar.getClass();
            a aVar = new a(fVar);
            while (aVar.hasNext()) {
                t tVar2 = (t) ((WeakReference) aVar.next()).get();
                if (tVar2 == tVar || tVar2 == null) {
                    aVar.remove();
                }
            }
        }
    }

    public static void w(i iVar) {
        Objects.requireNonNull(iVar);
        if (Build.VERSION.SDK_INT >= 33) {
            Object i10 = i();
            if (i10 != null) {
                s.b(i10, r.a(iVar.e()));
            }
        } else if (!iVar.equals(f6210j)) {
            synchronized (f6215o) {
                f6210j = iVar;
                f fVar = f6214n;
                fVar.getClass();
                a aVar = new a(fVar);
                while (aVar.hasNext()) {
                    t tVar = (t) ((WeakReference) aVar.next()).get();
                    if (tVar != null) {
                        tVar.b();
                    }
                }
            }
        }
    }

    public void A(int i10) {
    }

    public abstract void B(CharSequence charSequence);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public void b() {
    }

    public Context c(Context context) {
        return context;
    }

    public abstract View d(int i10);

    public Context g() {
        return null;
    }

    public int h() {
        return -100;
    }

    public abstract MenuInflater j();

    public abstract void k();

    public abstract void m();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract boolean v(int i10);

    public abstract void x(int i10);

    public abstract void y(View view);

    public abstract void z(View view, ViewGroup.LayoutParams layoutParams);
}
