package c2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import g.r0;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class l implements GLSurfaceView.Renderer, d {

    /* renamed from: h  reason: collision with root package name */
    public final k f2768h;

    /* renamed from: i  reason: collision with root package name */
    public final float[] f2769i = new float[16];

    /* renamed from: j  reason: collision with root package name */
    public final float[] f2770j = new float[16];

    /* renamed from: k  reason: collision with root package name */
    public final float[] f2771k;

    /* renamed from: l  reason: collision with root package name */
    public final float[] f2772l;

    /* renamed from: m  reason: collision with root package name */
    public final float[] f2773m;

    /* renamed from: n  reason: collision with root package name */
    public float f2774n;

    /* renamed from: o  reason: collision with root package name */
    public float f2775o;

    /* renamed from: p  reason: collision with root package name */
    public final float[] f2776p;

    /* renamed from: q  reason: collision with root package name */
    public final float[] f2777q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ m f2778r;

    public l(m mVar, k kVar) {
        this.f2778r = mVar;
        float[] fArr = new float[16];
        this.f2771k = fArr;
        float[] fArr2 = new float[16];
        this.f2772l = fArr2;
        float[] fArr3 = new float[16];
        this.f2773m = fArr3;
        this.f2776p = new float[16];
        this.f2777q = new float[16];
        this.f2768h = kVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f2775o = 3.1415927f;
    }

    public final synchronized void a(float[] fArr, float f10) {
        float[] fArr2 = this.f2771k;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f11 = -f10;
        this.f2775o = f11;
        Matrix.setRotateM(this.f2772l, 0, -this.f2774n, (float) Math.cos((double) f11), (float) Math.sin((double) this.f2775o), 0.0f);
    }

    public final void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            Matrix.multiplyMM(this.f2777q, 0, this.f2771k, 0, this.f2773m, 0);
            Matrix.multiplyMM(this.f2776p, 0, this.f2772l, 0, this.f2777q, 0);
        }
        Matrix.multiplyMM(this.f2770j, 0, this.f2769i, 0, this.f2776p, 0);
        this.f2768h.b(this.f2770j);
    }

    public final void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        float f10;
        boolean z10 = false;
        GLES20.glViewport(0, 0, i10, i11);
        float f11 = ((float) i10) / ((float) i11);
        if (f11 > 1.0f) {
            z10 = true;
        }
        if (z10) {
            f10 = (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f11))) * 2.0d);
        } else {
            f10 = 90.0f;
        }
        Matrix.perspectiveM(this.f2769i, 0, f10, f11, 0.1f, 100.0f);
    }

    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        m mVar = this.f2778r;
        mVar.f2784l.post(new r0(mVar, 19, this.f2768h.e()));
    }
}
