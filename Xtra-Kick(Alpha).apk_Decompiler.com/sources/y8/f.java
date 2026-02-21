package y8;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import t8.h;
import t8.n;

public final class f extends h {

    /* renamed from: v  reason: collision with root package name */
    public final RectF f17136v;

    public f(n nVar, RectF rectF) {
        super(nVar);
        this.f17136v = rectF;
    }

    public final Drawable newDrawable() {
        g gVar = new g(this);
        gVar.invalidateSelf();
        return gVar;
    }

    public f(f fVar) {
        super((h) fVar);
        this.f17136v = fVar.f17136v;
    }
}
