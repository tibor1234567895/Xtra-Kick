package b2;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.support.v4.media.h;
import android.util.AttributeSet;

public final class k extends GLSurfaceView implements l {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ int f2474i = 0;

    /* renamed from: h  reason: collision with root package name */
    public final j f2475h;

    public k(Context context) {
        super(context, (AttributeSet) null);
        j jVar = new j(this);
        this.f2475h = jVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(jVar);
        setRenderMode(0);
    }

    @Deprecated
    public l getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(l1.k kVar) {
        j jVar = this.f2475h;
        h.y(jVar.f2472m.getAndSet(kVar));
        jVar.f2467h.requestRender();
    }
}
