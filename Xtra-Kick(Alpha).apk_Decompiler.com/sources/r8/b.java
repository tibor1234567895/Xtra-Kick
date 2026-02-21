package r8;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import f0.k;
import t8.i;
import t8.n;
import t8.y;

public final class b extends Drawable implements y, k {

    /* renamed from: h  reason: collision with root package name */
    public a f13883h;

    public b(a aVar) {
        this.f13883h = aVar;
    }

    public final void draw(Canvas canvas) {
        a aVar = this.f13883h;
        if (aVar.f13882b) {
            aVar.f13881a.draw(canvas);
        }
    }

    public final Drawable.ConstantState getConstantState() {
        return this.f13883h;
    }

    public final int getOpacity() {
        return this.f13883h.f13881a.getOpacity();
    }

    public final boolean isStateful() {
        return true;
    }

    public final Drawable mutate() {
        this.f13883h = new a(this.f13883h);
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13883h.f13881a.setBounds(rect);
    }

    public final boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f13883h.f13881a.setState(iArr)) {
            onStateChange = true;
        }
        boolean d10 = d.d(iArr);
        a aVar = this.f13883h;
        if (aVar.f13882b == d10) {
            return onStateChange;
        }
        aVar.f13882b = d10;
        return true;
    }

    public final void setAlpha(int i10) {
        this.f13883h.f13881a.setAlpha(i10);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f13883h.f13881a.setColorFilter(colorFilter);
    }

    public final void setShapeAppearanceModel(n nVar) {
        this.f13883h.f13881a.setShapeAppearanceModel(nVar);
    }

    public final void setTint(int i10) {
        this.f13883h.f13881a.setTint(i10);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.f13883h.f13881a.setTintList(colorStateList);
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.f13883h.f13881a.setTintMode(mode);
    }

    public b(n nVar) {
        this(new a(new i(nVar)));
    }
}
