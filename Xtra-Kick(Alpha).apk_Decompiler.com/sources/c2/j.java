package c2;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class j implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ k f2754h;

    public /* synthetic */ j(k kVar) {
        this.f2754h = kVar;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f2754h.f2755h.set(true);
    }
}
