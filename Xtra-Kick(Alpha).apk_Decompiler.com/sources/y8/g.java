package y8;

import android.graphics.Canvas;
import android.graphics.Region;
import android.os.Build;

public final class g extends h {
    public g(f fVar) {
        super(fVar);
    }

    public final void g(Canvas canvas) {
        if (this.E.f17136v.isEmpty()) {
            super.g(canvas);
            return;
        }
        canvas.save();
        if (Build.VERSION.SDK_INT >= 26) {
            canvas.clipOutRect(this.E.f17136v);
        } else {
            canvas.clipRect(this.E.f17136v, Region.Op.DIFFERENCE);
        }
        super.g(canvas);
        canvas.restore();
    }
}
