package y8;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import t8.i;

public abstract class h extends i {
    public static final /* synthetic */ int F = 0;
    public f E;

    public h(f fVar) {
        super((t8.h) fVar);
        this.E = fVar;
    }

    public final Drawable mutate() {
        this.E = new f(this.E);
        return this;
    }

    public final void o(float f10, float f11, float f12, float f13) {
        RectF rectF = this.E.f17136v;
        if (f10 != rectF.left || f11 != rectF.top || f12 != rectF.right || f13 != rectF.bottom) {
            rectF.set(f10, f11, f12, f13);
            invalidateSelf();
        }
    }
}
