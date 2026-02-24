package f0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

public final class n extends m {

    /* renamed from: o  reason: collision with root package name */
    public static Method f5428o;

    public n(Drawable drawable) {
        super(drawable);
        if (f5428o == null) {
            try {
                f5428o = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e10) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e10);
            }
        }
    }

    public final boolean a() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f5427m;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final Rect getDirtyBounds() {
        return this.f5427m.getDirtyBounds();
    }

    public final void getOutline(Outline outline) {
        this.f5427m.getOutline(outline);
    }

    public final boolean isProjected() {
        Method method;
        Drawable drawable = this.f5427m;
        if (!(drawable == null || (method = f5428o) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e10) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e10);
            }
        }
        return false;
    }

    public final void setHotspot(float f10, float f11) {
        this.f5427m.setHotspot(f10, f11);
    }

    public final void setHotspotBounds(int i10, int i11, int i12, int i13) {
        this.f5427m.setHotspotBounds(i10, i11, i12, i13);
    }

    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public final void setTint(int i10) {
        if (a()) {
            super.setTint(i10);
        } else {
            this.f5427m.setTint(i10);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (a()) {
            super.setTintList(colorStateList);
        } else {
            this.f5427m.setTintList(colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (a()) {
            super.setTintMode(mode);
        } else {
            this.f5427m.setTintMode(mode);
        }
    }

    public n(o oVar, Resources resources) {
        super(oVar, resources);
        if (f5428o == null) {
            try {
                f5428o = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e10) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e10);
            }
        }
    }
}
