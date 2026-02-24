package i;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import q.i;
import q.l;

public final class b extends j {
    public i J;
    public l K;

    public b(b bVar, f fVar, Resources resources) {
        super(bVar, fVar, resources);
        l lVar;
        if (bVar != null) {
            this.J = bVar.J;
            lVar = bVar.K;
        } else {
            this.J = new i();
            lVar = new l();
        }
        this.K = lVar;
    }

    public final void e() {
        this.J = this.J.clone();
        this.K = this.K.clone();
    }

    public final Drawable newDrawable() {
        return new f(this, (Resources) null);
    }

    public final Drawable newDrawable(Resources resources) {
        return new f(this, resources);
    }
}
