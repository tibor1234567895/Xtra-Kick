package a5;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public final class m extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final w f174a;

    public m(w wVar) {
        this.f174a = wVar;
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        return new n(this);
    }

    public final Drawable newDrawable(Resources resources) {
        return new n(this);
    }
}
