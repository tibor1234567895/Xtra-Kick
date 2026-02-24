package b2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.support.v4.media.h;
import android.util.Log;
import androidx.appcompat.widget.n0;
import j1.l;
import j1.m;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class j implements GLSurfaceView.Renderer {

    /* renamed from: o  reason: collision with root package name */
    public static final String[] f2465o = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: p  reason: collision with root package name */
    public static final FloatBuffer f2466p = m.d(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

    /* renamed from: h  reason: collision with root package name */
    public final GLSurfaceView f2467h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f2468i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    public final int[] f2469j = new int[3];

    /* renamed from: k  reason: collision with root package name */
    public final int[] f2470k = new int[3];

    /* renamed from: l  reason: collision with root package name */
    public final int[] f2471l = new int[3];

    /* renamed from: m  reason: collision with root package name */
    public final AtomicReference f2472m = new AtomicReference();

    /* renamed from: n  reason: collision with root package name */
    public n0 f2473n;

    public j(GLSurfaceView gLSurfaceView) {
        this.f2467h = gLSurfaceView;
        for (int i10 = 0; i10 < 3; i10++) {
            int[] iArr = this.f2470k;
            this.f2471l[i10] = -1;
            iArr[i10] = -1;
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        h.y(this.f2472m.getAndSet((Object) null));
    }

    public final void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = this.f2469j;
        try {
            n0 n0Var = new n0("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f2473n = n0Var;
            GLES20.glVertexAttribPointer(n0Var.c("in_pos"), 2, 5126, false, 0, f2466p);
            iArr[0] = this.f2473n.c("in_tc_y");
            iArr[1] = this.f2473n.c("in_tc_u");
            iArr[2] = this.f2473n.c("in_tc_v");
            GLES20.glGetUniformLocation(this.f2473n.f963a, "mColorConversion");
            m.b();
            int[] iArr2 = this.f2468i;
            try {
                GLES20.glGenTextures(3, iArr2, 0);
                for (int i10 = 0; i10 < 3; i10++) {
                    n0 n0Var2 = this.f2473n;
                    GLES20.glUniform1i(GLES20.glGetUniformLocation(n0Var2.f963a, f2465o[i10]), i10);
                    GLES20.glActiveTexture(33984 + i10);
                    m.a(3553, iArr2[i10]);
                }
                m.b();
            } catch (l e10) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e10);
            }
            m.b();
        } catch (l e11) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e11);
        }
    }
}
