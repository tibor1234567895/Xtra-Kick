package m5;

import android.graphics.drawable.Drawable;
import d5.j0;
import d5.o0;
import w5.n;

public abstract class c implements o0, j0 {

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f10606h;

    public c(Drawable drawable) {
        n.b(drawable);
        this.f10606h = drawable;
    }

    public final Object get() {
        Drawable drawable = this.f10606h;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }
}
