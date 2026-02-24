package h3;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;

public final class x0 implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ y0 f7431h;

    public x0(y0 y0Var) {
        this.f7431h = y0Var;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        y0 y0Var = this.f7431h;
        TextureView textureView = y0Var.f7473u;
        if (textureView != null && textureView.getSurfaceTexture() == surfaceTexture) {
            y0Var.f7471s = new Surface(surfaceTexture);
            y0Var.S0(new w0(this, 0));
            y0Var.Z0(i10, i11);
        }
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        y0 y0Var = this.f7431h;
        TextureView textureView = y0Var.f7473u;
        if (textureView != null && textureView.getSurfaceTexture() == surfaceTexture) {
            y0Var.f7471s = null;
            y0Var.S0(new w0(this, 2));
            y0Var.Z0(0, 0);
        }
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        y0 y0Var = this.f7431h;
        TextureView textureView = y0Var.f7473u;
        if (textureView != null && textureView.getSurfaceTexture() == surfaceTexture) {
            y0Var.Z0(i10, i11);
        }
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        y0 y0Var = this.f7431h;
        if (y0Var.f7472t == surfaceHolder) {
            y0Var.Z0(i11, i12);
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        y0 y0Var = this.f7431h;
        if (y0Var.f7472t == surfaceHolder) {
            y0Var.f7471s = surfaceHolder.getSurface();
            y0Var.S0(new w0(this, 3));
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            y0Var.Z0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        y0 y0Var = this.f7431h;
        if (y0Var.f7472t == surfaceHolder) {
            y0Var.f7471s = null;
            y0Var.S0(new w0(this, 1));
            y0Var.Z0(0, 0);
        }
    }
}
