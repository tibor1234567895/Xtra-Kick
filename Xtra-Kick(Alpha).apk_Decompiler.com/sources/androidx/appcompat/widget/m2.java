package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import f0.a;
import f0.b;

public final class m2 extends Drawable implements Drawable.Callback {

    /* renamed from: h  reason: collision with root package name */
    public Drawable f930h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f931i;

    public m2(Drawable drawable) {
        Drawable drawable2 = this.f930h;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f930h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f931i = true;
    }

    /* renamed from: A */
    public final void setTintList(ColorStateList colorStateList) {
        b.h(this.f930h, colorStateList);
    }

    /* renamed from: B */
    public final void setTintMode(PorterDuff.Mode mode) {
        b.i(this.f930h, mode);
    }

    public final boolean C(boolean z10, boolean z11) {
        return super.setVisible(z10, z11) || this.f930h.setVisible(z10, z11);
    }

    public final void a(Canvas canvas) {
        this.f930h.draw(canvas);
    }

    /* renamed from: b */
    public final int getChangingConfigurations() {
        return this.f930h.getChangingConfigurations();
    }

    /* renamed from: c */
    public final Drawable getCurrent() {
        return this.f930h.getCurrent();
    }

    /* renamed from: d */
    public final int getIntrinsicHeight() {
        return this.f930h.getIntrinsicHeight();
    }

    public final void draw(Canvas canvas) {
        if (this.f931i) {
            a(canvas);
        }
    }

    /* renamed from: e */
    public final int getIntrinsicWidth() {
        return this.f930h.getIntrinsicWidth();
    }

    /* renamed from: f */
    public final int getMinimumHeight() {
        return this.f930h.getMinimumHeight();
    }

    /* renamed from: g */
    public final int getMinimumWidth() {
        return this.f930h.getMinimumWidth();
    }

    /* renamed from: h */
    public final int getOpacity() {
        return this.f930h.getOpacity();
    }

    /* renamed from: i */
    public final boolean getPadding(Rect rect) {
        return this.f930h.getPadding(rect);
    }

    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    /* renamed from: j */
    public final int[] getState() {
        return this.f930h.getState();
    }

    /* renamed from: k */
    public final Region getTransparentRegion() {
        return this.f930h.getTransparentRegion();
    }

    /* renamed from: l */
    public final boolean isAutoMirrored() {
        return a.d(this.f930h);
    }

    /* renamed from: m */
    public final boolean isStateful() {
        return this.f930h.isStateful();
    }

    /* renamed from: n */
    public final void jumpToCurrentState() {
        this.f930h.jumpToCurrentState();
    }

    /* renamed from: o */
    public final void onBoundsChange(Rect rect) {
        this.f930h.setBounds(rect);
    }

    /* renamed from: p */
    public final boolean onLevelChange(int i10) {
        return this.f930h.setLevel(i10);
    }

    /* renamed from: q */
    public final void setAlpha(int i10) {
        this.f930h.setAlpha(i10);
    }

    /* renamed from: r */
    public final void setAutoMirrored(boolean z10) {
        a.e(this.f930h, z10);
    }

    /* renamed from: s */
    public final void setChangingConfigurations(int i10) {
        this.f930h.setChangingConfigurations(i10);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public final void setHotspot(float f10, float f11) {
        if (this.f931i) {
            w(f10, f11);
        }
    }

    public final void setHotspotBounds(int i10, int i11, int i12, int i13) {
        if (this.f931i) {
            x(i10, i11, i12, i13);
        }
    }

    public final boolean setState(int[] iArr) {
        if (this.f931i) {
            return y(iArr);
        }
        return false;
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        if (this.f931i) {
            return C(z10, z11);
        }
        return false;
    }

    /* renamed from: t */
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f930h.setColorFilter(colorFilter);
    }

    /* renamed from: u */
    public final void setDither(boolean z10) {
        this.f930h.setDither(z10);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* renamed from: v */
    public final void setFilterBitmap(boolean z10) {
        this.f930h.setFilterBitmap(z10);
    }

    public final void w(float f10, float f11) {
        b.e(this.f930h, f10, f11);
    }

    public final void x(int i10, int i11, int i12, int i13) {
        b.f(this.f930h, i10, i11, i12, i13);
    }

    public final boolean y(int[] iArr) {
        return this.f930h.setState(iArr);
    }

    /* renamed from: z */
    public final void setTint(int i10) {
        b.g(this.f930h, i10);
    }
}
