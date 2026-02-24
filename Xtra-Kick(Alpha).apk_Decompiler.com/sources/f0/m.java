package f0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

public abstract class m extends Drawable implements Drawable.Callback, l, k {

    /* renamed from: n  reason: collision with root package name */
    public static final PorterDuff.Mode f5421n = PorterDuff.Mode.SRC_IN;

    /* renamed from: h  reason: collision with root package name */
    public int f5422h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f5423i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f5424j;

    /* renamed from: k  reason: collision with root package name */
    public o f5425k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5426l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f5427m;

    public m(Drawable drawable) {
        this.f5425k = new o(this.f5425k);
        b(drawable);
    }

    public abstract boolean a();

    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f5427m;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f5427m = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            o oVar = this.f5425k;
            if (oVar != null) {
                oVar.f5430b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final boolean c(int[] iArr) {
        if (!a()) {
            return false;
        }
        o oVar = this.f5425k;
        ColorStateList colorStateList = oVar.f5431c;
        PorterDuff.Mode mode = oVar.f5432d;
        if (colorStateList == null || mode == null) {
            this.f5424j = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f5424j && colorForState == this.f5422h && mode == this.f5423i)) {
                setColorFilter(colorForState, mode);
                this.f5422h = colorForState;
                this.f5423i = mode;
                this.f5424j = true;
                return true;
            }
        }
        return false;
    }

    public final void draw(Canvas canvas) {
        this.f5427m.draw(canvas);
    }

    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        o oVar = this.f5425k;
        return changingConfigurations | (oVar != null ? oVar.getChangingConfigurations() : 0) | this.f5427m.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        boolean z10;
        o oVar = this.f5425k;
        if (oVar == null) {
            return null;
        }
        if (oVar.f5430b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return null;
        }
        oVar.f5429a = getChangingConfigurations();
        return this.f5425k;
    }

    public final Drawable getCurrent() {
        return this.f5427m.getCurrent();
    }

    public final int getIntrinsicHeight() {
        return this.f5427m.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth() {
        return this.f5427m.getIntrinsicWidth();
    }

    public final int getLayoutDirection() {
        return d.b(this.f5427m);
    }

    public final int getMinimumHeight() {
        return this.f5427m.getMinimumHeight();
    }

    public final int getMinimumWidth() {
        return this.f5427m.getMinimumWidth();
    }

    public final int getOpacity() {
        return this.f5427m.getOpacity();
    }

    public final boolean getPadding(Rect rect) {
        return this.f5427m.getPadding(rect);
    }

    public final int[] getState() {
        return this.f5427m.getState();
    }

    public final Region getTransparentRegion() {
        return this.f5427m.getTransparentRegion();
    }

    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public final boolean isAutoMirrored() {
        return a.d(this.f5427m);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f5425k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.a()
            if (r0 == 0) goto L_0x000d
            f0.o r0 = r1.f5425k
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f5431c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f5427m
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f0.m.isStateful():boolean");
    }

    public final void jumpToCurrentState() {
        this.f5427m.jumpToCurrentState();
    }

    public final Drawable mutate() {
        Drawable.ConstantState constantState;
        if (!this.f5426l && super.mutate() == this) {
            this.f5425k = new o(this.f5425k);
            Drawable drawable = this.f5427m;
            if (drawable != null) {
                drawable.mutate();
            }
            o oVar = this.f5425k;
            if (oVar != null) {
                Drawable drawable2 = this.f5427m;
                if (drawable2 != null) {
                    constantState = drawable2.getConstantState();
                } else {
                    constantState = null;
                }
                oVar.f5430b = constantState;
            }
            this.f5426l = true;
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5427m;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public final boolean onLayoutDirectionChanged(int i10) {
        return d.c(this.f5427m, i10);
    }

    public final boolean onLevelChange(int i10) {
        return this.f5427m.setLevel(i10);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public final void setAlpha(int i10) {
        this.f5427m.setAlpha(i10);
    }

    public final void setAutoMirrored(boolean z10) {
        a.e(this.f5427m, z10);
    }

    public final void setChangingConfigurations(int i10) {
        this.f5427m.setChangingConfigurations(i10);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f5427m.setColorFilter(colorFilter);
    }

    public final void setDither(boolean z10) {
        this.f5427m.setDither(z10);
    }

    public final void setFilterBitmap(boolean z10) {
        this.f5427m.setFilterBitmap(z10);
    }

    public boolean setState(int[] iArr) {
        return c(iArr) || this.f5427m.setState(iArr);
    }

    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f5425k.f5431c = colorStateList;
        c(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f5425k.f5432d = mode;
        c(getState());
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11) || this.f5427m.setVisible(z10, z11);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public m(o oVar, Resources resources) {
        Drawable.ConstantState constantState;
        this.f5425k = oVar;
        if (oVar != null && (constantState = oVar.f5430b) != null) {
            b(constantState.newDrawable(resources));
        }
    }
}
