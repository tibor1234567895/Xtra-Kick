package c4;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

public final class r extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable.ConstantState f2948a;

    public r(Drawable.ConstantState constantState) {
        this.f2948a = constantState;
    }

    public final boolean canApplyTheme() {
        return this.f2948a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.f2948a.getChangingConfigurations();
    }

    public final Drawable newDrawable() {
        s sVar = new s();
        sVar.f2892h = (VectorDrawable) this.f2948a.newDrawable();
        return sVar;
    }

    public final Drawable newDrawable(Resources resources) {
        s sVar = new s();
        sVar.f2892h = (VectorDrawable) this.f2948a.newDrawable(resources);
        return sVar;
    }

    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        s sVar = new s();
        sVar.f2892h = (VectorDrawable) this.f2948a.newDrawable(resources, theme);
        return sVar;
    }
}
