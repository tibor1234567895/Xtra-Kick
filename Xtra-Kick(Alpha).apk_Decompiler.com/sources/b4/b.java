package b4;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

public final class b extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f2517a = new Rect();

    public b() {
        super(PointF.class, "boundsOrigin");
    }

    public final Object get(Object obj) {
        Rect rect = this.f2517a;
        ((Drawable) obj).copyBounds(rect);
        return new PointF((float) rect.left, (float) rect.top);
    }

    public final void set(Object obj, Object obj2) {
        Drawable drawable = (Drawable) obj;
        PointF pointF = (PointF) obj2;
        Rect rect = this.f2517a;
        drawable.copyBounds(rect);
        rect.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(rect);
    }
}
