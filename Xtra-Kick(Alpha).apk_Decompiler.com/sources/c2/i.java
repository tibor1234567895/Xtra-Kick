package c2;

import android.opengl.GLES20;
import android.util.Log;
import androidx.activity.result.j;
import androidx.appcompat.widget.n0;
import j1.l;

public final class i {

    /* renamed from: i  reason: collision with root package name */
    public static final float[] f2743i = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f2744j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final float[] f2745k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public int f2746a;

    /* renamed from: b  reason: collision with root package name */
    public j f2747b;

    /* renamed from: c  reason: collision with root package name */
    public n0 f2748c;

    /* renamed from: d  reason: collision with root package name */
    public int f2749d;

    /* renamed from: e  reason: collision with root package name */
    public int f2750e;

    /* renamed from: f  reason: collision with root package name */
    public int f2751f;

    /* renamed from: g  reason: collision with root package name */
    public int f2752g;

    /* renamed from: h  reason: collision with root package name */
    public int f2753h;

    public static boolean b(g gVar) {
        j[] jVarArr = gVar.f2739a.f2738a;
        if (jVarArr.length != 1 || jVarArr[0].f517h != 0) {
            return false;
        }
        j[] jVarArr2 = gVar.f2740b.f2738a;
        if (jVarArr2.length == 1 && jVarArr2[0].f517h == 0) {
            return true;
        }
        return false;
    }

    public final void a() {
        try {
            n0 n0Var = new n0("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f2748c = n0Var;
            this.f2749d = GLES20.glGetUniformLocation(n0Var.f963a, "uMvpMatrix");
            this.f2750e = GLES20.glGetUniformLocation(this.f2748c.f963a, "uTexMatrix");
            this.f2751f = this.f2748c.c("aPosition");
            this.f2752g = this.f2748c.c("aTexCoords");
            this.f2753h = GLES20.glGetUniformLocation(this.f2748c.f963a, "uTexture");
        } catch (l e10) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e10);
        }
    }
}
