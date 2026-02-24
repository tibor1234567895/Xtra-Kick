package m1;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import b2.y;
import y1.f;

public final class k0 implements y, f, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, d, r1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ n0 f10314h;

    public k0(n0 n0Var) {
        this.f10314h = n0Var;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        n0 n0Var = this.f10314h;
        n0Var.getClass();
        Surface surface = new Surface(surfaceTexture);
        n0Var.q1(surface);
        n0Var.R = surface;
        n0Var.i1(i10, i11);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        n0 n0Var = this.f10314h;
        n0Var.q1((Object) null);
        n0Var.i1(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        this.f10314h.i1(i10, i11);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        this.f10314h.i1(i11, i12);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        n0 n0Var = this.f10314h;
        if (n0Var.U) {
            n0Var.q1(surfaceHolder.getSurface());
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        n0 n0Var = this.f10314h;
        if (n0Var.U) {
            n0Var.q1((Object) null);
        }
        n0Var.i1(0, 0);
    }
}
