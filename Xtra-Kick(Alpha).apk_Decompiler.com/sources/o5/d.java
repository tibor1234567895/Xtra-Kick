package o5;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public final class d extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final j f12200a;

    public d(j jVar) {
        this.f12200a = jVar;
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        return new e(this);
    }

    public final Drawable newDrawable(Resources resources) {
        return new e(this);
    }
}
