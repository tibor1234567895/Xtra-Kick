package i;

import android.graphics.drawable.Drawable;

public final class g implements Drawable.Callback {

    /* renamed from: h  reason: collision with root package name */
    public Drawable.Callback f7898h;

    public final void invalidateDrawable(Drawable drawable) {
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = this.f7898h;
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j10);
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = this.f7898h;
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }
}
