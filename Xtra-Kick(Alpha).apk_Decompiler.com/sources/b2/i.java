package b2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.view.Surface;
import j1.a;
import j1.j;
import j1.l0;

public final class i extends Surface {

    /* renamed from: k  reason: collision with root package name */
    public static int f2460k;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f2461l;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f2462h;

    /* renamed from: i  reason: collision with root package name */
    public final h f2463i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2464j;

    public i(h hVar, SurfaceTexture surfaceTexture, boolean z10) {
        super(surfaceTexture);
        this.f2463i = hVar;
        this.f2462h = z10;
    }

    public static int u(Context context) {
        boolean z10;
        String eglQueryString;
        String eglQueryString2;
        int i10 = l0.f8453a;
        boolean z11 = false;
        if (i10 >= 24 && ((i10 >= 26 || (!"samsung".equals(l0.f8455c) && !"XT1650".equals(l0.f8456d))) && ((i10 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString2.contains("EGL_EXT_protected_content")))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return 0;
        }
        if (i10 >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_KHR_surfaceless_context")) {
            z11 = true;
        }
        if (z11) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean v(Context context) {
        boolean z10;
        synchronized (i.class) {
            z10 = true;
            if (!f2461l) {
                f2460k = u(context);
                f2461l = true;
            }
            if (f2460k == 0) {
                z10 = false;
            }
        }
        return z10;
    }

    public static i w(Context context, boolean z10) {
        boolean z11;
        int i10;
        boolean z12 = false;
        if (!z10 || v(context)) {
            z11 = true;
        } else {
            z11 = false;
        }
        a.e(z11);
        h hVar = new h();
        if (z10) {
            i10 = f2460k;
        } else {
            i10 = 0;
        }
        hVar.start();
        Handler handler = new Handler(hVar.getLooper(), hVar);
        hVar.f2456i = handler;
        hVar.f2455h = new j(handler);
        synchronized (hVar) {
            hVar.f2456i.obtainMessage(1, i10, 0).sendToTarget();
            while (hVar.f2459l == null && hVar.f2458k == null && hVar.f2457j == null) {
                try {
                    hVar.wait();
                } catch (InterruptedException unused) {
                    z12 = true;
                }
            }
        }
        if (z12) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = hVar.f2458k;
        if (runtimeException == null) {
            Error error = hVar.f2457j;
            if (error == null) {
                i iVar = hVar.f2459l;
                iVar.getClass();
                return iVar;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void release() {
        super.release();
        synchronized (this.f2463i) {
            if (!this.f2464j) {
                h hVar = this.f2463i;
                hVar.f2456i.getClass();
                hVar.f2456i.sendEmptyMessage(2);
                this.f2464j = true;
            }
        }
    }
}
