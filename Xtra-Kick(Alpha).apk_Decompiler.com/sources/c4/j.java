package c4;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import f0.b;
import f0.k;

public abstract class j extends Drawable implements k {

    /* renamed from: h  reason: collision with root package name */
    public Drawable f2892h;

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            b.a(drawable, theme);
        }
    }

    public final void clearColorFilter() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public final Drawable getCurrent() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    public final int getMinimumHeight() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    public final int getMinimumWidth() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    public final boolean getPadding(Rect rect) {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    public final int[] getState() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getState() : super.getState();
    }

    public final Region getTransparentRegion() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    public final void jumpToCurrentState() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.setLevel(i10) : super.onLevelChange(i10);
    }

    public final void setChangingConfigurations(int i10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setChangingConfigurations(i10);
        } else {
            super.setChangingConfigurations(i10);
        }
    }

    public final void setColorFilter(int i10, PorterDuff.Mode mode) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setColorFilter(i10, mode);
        } else {
            super.setColorFilter(i10, mode);
        }
    }

    public final void setFilterBitmap(boolean z10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setFilterBitmap(z10);
        }
    }

    public final void setHotspot(float f10, float f11) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            b.e(drawable, f10, f11);
        }
    }

    public final void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            b.f(drawable, i10, i11, i12, i13);
        }
    }

    public final boolean setState(int[] iArr) {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
