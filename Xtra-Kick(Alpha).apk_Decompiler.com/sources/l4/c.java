package l4;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import j4.i;
import za.b;

public final class c extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f9582h;

    /* renamed from: i  reason: collision with root package name */
    public final int f9583i;

    /* renamed from: j  reason: collision with root package name */
    public float f9584j;

    /* renamed from: k  reason: collision with root package name */
    public float f9585k;

    /* renamed from: l  reason: collision with root package name */
    public float f9586l = 1.0f;

    public c(Drawable drawable, int i10) {
        this.f9582h = drawable;
        this.f9583i = i10;
        drawable.setCallback(this);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        try {
            canvas.translate(this.f9584j, this.f9585k);
            float f10 = this.f9586l;
            canvas.scale(f10, f10);
            this.f9582h.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public final int getAlpha() {
        return this.f9582h.getAlpha();
    }

    public final ColorFilter getColorFilter() {
        return this.f9582h.getColorFilter();
    }

    public final int getIntrinsicHeight() {
        return this.f9582h.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth() {
        return this.f9582h.getIntrinsicWidth();
    }

    public final int getOpacity() {
        return this.f9582h.getOpacity();
    }

    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public final boolean isRunning() {
        Drawable drawable = this.f9582h;
        return (drawable instanceof Animatable) && ((Animatable) drawable).isRunning();
    }

    public final void onBoundsChange(Rect rect) {
        float f10;
        Drawable drawable = this.f9582h;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            this.f9584j = 0.0f;
            this.f9585k = 0.0f;
            f10 = 1.0f;
        } else {
            int width = rect.width();
            int height = rect.height();
            double a10 = i.a(intrinsicWidth, intrinsicHeight, width, height, this.f9583i);
            double d10 = (double) 2;
            int a11 = b.a((((double) width) - (((double) intrinsicWidth) * a10)) / d10);
            int a12 = b.a((((double) height) - (((double) intrinsicHeight) * a10)) / d10);
            drawable.setBounds(a11, a12, intrinsicWidth + a11, intrinsicHeight + a12);
            this.f9584j = (float) rect.left;
            this.f9585k = (float) rect.top;
            f10 = (float) a10;
        }
        this.f9586l = f10;
    }

    public final boolean onLevelChange(int i10) {
        return this.f9582h.setLevel(i10);
    }

    public final boolean onStateChange(int[] iArr) {
        return this.f9582h.setState(iArr);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public final void setAlpha(int i10) {
        this.f9582h.setAlpha(i10);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9582h.setColorFilter(colorFilter);
    }

    public final void setTint(int i10) {
        this.f9582h.setTint(i10);
    }

    public final void setTintBlendMode(BlendMode blendMode) {
        this.f9582h.setTintBlendMode(blendMode);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.f9582h.setTintList(colorStateList);
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.f9582h.setTintMode(mode);
    }

    public final void start() {
        Drawable drawable = this.f9582h;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    public final void stop() {
        Drawable drawable = this.f9582h;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
