package b2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import j1.j;
import j1.l;
import j1.l0;
import j1.m;
import j1.v;

public final class h extends HandlerThread implements Handler.Callback {

    /* renamed from: h  reason: collision with root package name */
    public j f2455h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f2456i;

    /* renamed from: j  reason: collision with root package name */
    public Error f2457j;

    /* renamed from: k  reason: collision with root package name */
    public RuntimeException f2458k;

    /* renamed from: l  reason: collision with root package name */
    public i f2459l;

    public h() {
        super("ExoPlayer:PlaceholderSurface");
    }

    public final void a(int i10) {
        boolean z10;
        boolean z11;
        int[] iArr;
        boolean z12;
        EGLSurface eGLSurface;
        int[] iArr2;
        boolean z13;
        this.f2455h.getClass();
        j jVar = this.f2455h;
        jVar.getClass();
        boolean z14 = false;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        m.c("eglGetDisplay failed", z10);
        int[] iArr3 = new int[2];
        m.c("eglInitialize failed", EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1));
        jVar.f8446j = eglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr4 = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, j.f8443n, 0, eGLConfigArr, 0, 1, iArr4, 0);
        if (!eglChooseConfig || iArr4[0] <= 0 || eGLConfigArr[0] == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        m.c(l0.l("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr4[0]), eGLConfigArr[0]), z11);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLDisplay eGLDisplay = jVar.f8446j;
        if (i10 == 0) {
            iArr = new int[]{12440, 2, 12344};
        } else {
            iArr = new int[]{12440, 2, 12992, 1, 12344};
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
        if (eglCreateContext != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        m.c("eglCreateContext failed", z12);
        jVar.f8447k = eglCreateContext;
        EGLDisplay eGLDisplay2 = jVar.f8446j;
        if (i10 == 1) {
            eGLSurface = EGL14.EGL_NO_SURFACE;
        } else {
            if (i10 == 2) {
                iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                iArr2 = new int[]{12375, 1, 12374, 1, 12344};
            }
            eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay2, eGLConfig, iArr2, 0);
            if (eGLSurface != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            m.c("eglCreatePbufferSurface failed", z13);
        }
        m.c("eglMakeCurrent failed", EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, eglCreateContext));
        jVar.f8448l = eGLSurface;
        int[] iArr5 = jVar.f8445i;
        GLES20.glGenTextures(1, iArr5, 0);
        m.b();
        SurfaceTexture surfaceTexture = new SurfaceTexture(iArr5[0]);
        jVar.f8449m = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(jVar);
        SurfaceTexture surfaceTexture2 = this.f2455h.f8449m;
        surfaceTexture2.getClass();
        if (i10 != 0) {
            z14 = true;
        }
        this.f2459l = new i(this, surfaceTexture2, z14);
    }

    public final void b() {
        this.f2455h.getClass();
        j jVar = this.f2455h;
        jVar.f8444h.removeCallbacks(jVar);
        try {
            SurfaceTexture surfaceTexture = jVar.f8449m;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, jVar.f8445i, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = jVar.f8446j;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = jVar.f8446j;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = jVar.f8448l;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(jVar.f8446j, jVar.f8448l);
            }
            EGLContext eGLContext = jVar.f8447k;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(jVar.f8446j, eGLContext);
            }
            if (l0.f8453a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = jVar.f8446j;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(jVar.f8446j);
            }
            jVar.f8446j = null;
            jVar.f8447k = null;
            jVar.f8448l = null;
            jVar.f8449m = null;
        }
    }

    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            try {
                a(message.arg1);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e10) {
                v.d("PlaceholderSurface", "Failed to initialize placeholder surface", e10);
                this.f2458k = e10;
                synchronized (this) {
                    notify();
                }
            } catch (l e11) {
                v.d("PlaceholderSurface", "Failed to initialize placeholder surface", e11);
                this.f2458k = new IllegalStateException(e11);
                synchronized (this) {
                    notify();
                }
            } catch (Error e12) {
                try {
                    v.d("PlaceholderSurface", "Failed to initialize placeholder surface", e12);
                    this.f2457j = e12;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
            return true;
        } else if (i10 != 2) {
            return true;
        } else {
            try {
                b();
            } catch (Throwable th2) {
                quit();
                throw th2;
            }
            quit();
            return true;
        }
    }
}
