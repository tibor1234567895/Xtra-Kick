package j1;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;

public final class j implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f8443n = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: h  reason: collision with root package name */
    public final Handler f8444h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f8445i = new int[1];

    /* renamed from: j  reason: collision with root package name */
    public EGLDisplay f8446j;

    /* renamed from: k  reason: collision with root package name */
    public EGLContext f8447k;

    /* renamed from: l  reason: collision with root package name */
    public EGLSurface f8448l;

    /* renamed from: m  reason: collision with root package name */
    public SurfaceTexture f8449m;

    public j(Handler handler) {
        this.f8444h = handler;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f8444h.post(this);
    }

    public final void run() {
        SurfaceTexture surfaceTexture = this.f8449m;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
