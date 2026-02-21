package f0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public final class o extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f5429a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable.ConstantState f5430b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f5431c = null;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f5432d = m.f5421n;

    public o(o oVar) {
        if (oVar != null) {
            this.f5429a = oVar.f5429a;
            this.f5430b = oVar.f5430b;
            this.f5431c = oVar.f5431c;
            this.f5432d = oVar.f5432d;
        }
    }

    public final int getChangingConfigurations() {
        int i10 = this.f5429a;
        Drawable.ConstantState constantState = this.f5430b;
        return i10 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public final Drawable newDrawable() {
        return new n(this, (Resources) null);
    }

    public final Drawable newDrawable(Resources resources) {
        return new n(this, resources);
    }
}
